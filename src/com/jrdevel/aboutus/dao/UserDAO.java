package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
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
	
	public void setExtraFilters(Criteria criteria) {
		
		criteria.setFetchMode("church", FetchMode.JOIN);
		criteria.setFetchMode("person", FetchMode.JOIN);
		
	}

}
