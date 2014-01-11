package com.jrdevel.aboutus.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.EntityMode;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;

import com.jrdevel.aboutus.model.Audit;
import com.jrdevel.aboutus.model.Permission;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.Filter;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;
import com.jrdevel.aboutus.util.Sort;


/**
 * @author Raphael Domingues
 *
 */
public abstract class GenericDAO<T, PK extends Serializable>{

	private Class<T> persistentClass;
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public GenericDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	
	@Autowired
	private User userSession;

	public Session getSession(){
		return getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	protected T findUniqueByCriteria(Criterion... criterion){
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return (T) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		for (Criterion c : criterion) {
			crit.add(c);
		}
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public ListResult<T> findAllByCriteria(ListParams params){

		Criteria criteria = getSession().createCriteria(getPersistentClass());
		if (this.getPersistentClass() != Permission.class){
			criteria.add(Restrictions.eq("customer.id", userSession.getCustomer().getId()));
		}
		setOrder(criteria,params.getSorters());
		setFilters(criteria, params.getFilter());
		int count = setPagingInfo(criteria);
		setExtraFilters(criteria);
		criteria.setFirstResult(params.getStart());
		criteria.setMaxResults(params.getLimit());
		criteria.setProjection(null);
		criteria.setResultTransformer(Criteria.ROOT_ENTITY);
		return new ListResult<T>(criteria.list(), count);
	}
	
	private void setOrder(Criteria criteria, List<Sort> sortInfo){
		if (sortInfo!=null && !sortInfo.isEmpty()){
			Sort sort = sortInfo.get(0);
			String sortField = sort.getProperty();
			Order order = null;
			if (sort.getDirection().equals("ASC")){
				order = Order.asc(sortField);
			}else if (sortField != null){
				order = Order.desc(sortField);

			}
			if (order != null){
				criteria.addOrder(order);
			}
		}
	}
	
	private void setFilters(Criteria criteria, List<Filter> filters){
    	if (filters == null){
    		return;
    	}
    	for(Filter filter: filters){
    		if (filter.getType().equals("textfield")){
    			criteria.add(Restrictions.like(filter.getProperty(), "%"+filter.getValue()+"%"));
    		}
    	}
    }
	
	private int setPagingInfo(Criteria criteria){
    	criteria.setProjection(Projections.rowCount()); 
    	Object result = criteria.list().get(0);
    	if (result instanceof Integer){
    		return (Integer) result;
    	}else{
    		return 0;
    	}
    }
	
	@SuppressWarnings("unchecked")
	public T findById(PK id, boolean lock) {
		T entity;
		if (lock)
			entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
		else
			entity = (T) getSession().get(getPersistentClass(), id);

		return entity;
	}
	
	public T makePersistent(T entity) {
    	return makePersistent(entity, false);
    }
    
    public T makePersistent(T entity, boolean audit) {
    	int mode = 0;
    	if (audit){
	    	ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(getPersistentClass());
	        mode = 1;
	        if (hibernateMetadata.getIdentifier(entity, EntityMode.POJO) == null ||
	        		hibernateMetadata.getIdentifier(entity, EntityMode.POJO).hashCode()==0){
	        	mode = 0;
	        }
    	}
        getSession().saveOrUpdate(entity);
        if (audit){
        	audit(entity, mode);
        }
        return entity;
    }
    
    public T makeTransient(T entity) {
    	return makeTransient(entity, false);
    }
    
    public T makeTransient(T entity, boolean audit) {
    	int mode = 2;
        if (audit){
        	audit(entity, mode);
        }
        getSession().delete(entity);
        return entity;
    }
    
    public void audit(T entity, int mode){
        //Audit
        ClassMetadata hibernateMetadata = getSession().getSessionFactory().getClassMetadata(getPersistentClass());
        if (hibernateMetadata == null){
            return;
        }
        AbstractEntityPersister persister = (AbstractEntityPersister) hibernateMetadata;
        
        String tableName = persister.getTableName();
        Integer tableId = hibernateMetadata.getIdentifier(entity, EntityMode.POJO).hashCode();
        
		Audit audit = new Audit();
		audit.setUserId(1);
		audit.setTableId(tableId);
		audit.setTableName(tableName);
		audit.setActionId(mode);
		audit.setUserName(userSession.getPerson().getName());
//		audit.setObjectName(getObjectName());
//		audit.setObjectTitle(getObjectTitle(entity));
		
		audit.setActionDate(new Date());
		
		getSession().saveOrUpdate(audit);
		
    }


	//Abstract methods

	public abstract void setExtraFilters(Criteria criteria);

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


}
