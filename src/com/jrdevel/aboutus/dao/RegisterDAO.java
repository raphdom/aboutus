package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.Register;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class RegisterDAO extends GenericDAO<Register, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		
	}
	
	/**
	 * Get User from database
	 * @return user
	 */
	public boolean existEmailRegistered(String email) {
		Criteria criteria = getSession().createCriteria(getPersistentClass());
		criteria.add(Restrictions.eq("email", email));
		Register register = (Register) criteria.uniqueResult(); 
		return register != null;
	}
	

}
