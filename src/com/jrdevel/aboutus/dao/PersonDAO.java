package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.Person;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class PersonDAO extends GenericDAO<Person, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		
		
	}

}
