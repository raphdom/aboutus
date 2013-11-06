package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.Audit;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class AuditDAO extends GenericDAO<Audit, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		
	}

}
