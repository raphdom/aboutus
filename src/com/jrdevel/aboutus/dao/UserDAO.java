package com.jrdevel.aboutus.dao;

import javax.persistence.criteria.JoinType;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.User;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class UserDAO extends GenericDAO<User, Integer>{
	
	/**
	 * Get User from database
	 * @return user
	 */
	public User getUserByEmail(String email) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("block", false));
		criteria.setFetchMode("groups", FetchMode.JOIN);
		criteria.setFetchMode("permissions", FetchMode.JOIN);
		User user = (User) criteria.uniqueResult(); 
		return user;
	}
	
	public boolean existEmailRegistered(String email) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("email", email));
		User user = (User) criteria.uniqueResult(); 
		return user != null;
	}
	
	public void setExtraFilters(Criteria criteria) {
		
		criteria.createAlias("person", "person", Criteria.LEFT_JOIN);
		criteria.createAlias("church", "church", Criteria.LEFT_JOIN);
		
	}
	
	public User getUserById(int id){
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.setFetchMode("person", FetchMode.JOIN);
		crit.setFetchMode("church", FetchMode.JOIN);
		crit.setFetchMode("groups", FetchMode.JOIN);
		crit.setFetchMode("permissions", FetchMode.JOIN);
		crit.add(Restrictions.eq("id", id));
		return (User) crit.uniqueResult();
	}
	
	public User getUserSimpleById(int id){
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.setFetchMode("groups", FetchMode.JOIN);
		crit.setFetchMode("permissions", FetchMode.JOIN);
		crit.add(Restrictions.eq("id", id));
		return (User) crit.uniqueResult();
	}

}
