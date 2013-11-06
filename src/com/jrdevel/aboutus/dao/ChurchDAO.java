package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.Church;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class ChurchDAO extends GenericDAO<Church, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		
	}

}
