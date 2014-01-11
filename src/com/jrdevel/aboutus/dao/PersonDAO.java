package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.Person;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class PersonDAO extends GenericDAO<Person, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		criteria.setFetchMode("civilStatus", FetchMode.JOIN);
		criteria.setFetchMode("civilStatusTranslates", FetchMode.JOIN);
		criteria.createAlias("civilStatus.civilStatusTranslates", "cvStat", Criteria.LEFT_JOIN);
		Criterion cvStatusTrans = Restrictions.eq("cvStat.langId", "pt_PT");
		Criterion cvStatusNull = Restrictions.isNull("civilStatus");
		LogicalExpression orExp = Restrictions.or(cvStatusTrans,cvStatusNull);
		criteria.add(orExp);
	}

}
