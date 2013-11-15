package com.jrdevel.aboutus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.PersonDAO;
import com.jrdevel.aboutus.model.Church;
import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;
import com.jrdevel.aboutus.util.ResultObject;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class PersonService {
	
	private PersonDAO personDAO;
	
	/**
	 * Spring use - DI
	 * @param personDAO
	 */
	@Autowired
	public void setPersonDAO(PersonDAO personDAO) {
		this.personDAO = personDAO;
	}
	
	
	/**
	 * Get all churchs
	 * @return
	 */
	@Transactional
	public ListResult<Person> getPersonList(ListParams params){

		return personDAO.findAllByCriteria(params);
		
	}
	
	@Transactional()
	public ResultObject update(Person person){
		ResultObject result = new ResultObject();
		
		boolean isUpdate = person.getId() != null;
		
		if (!isUpdate){
			
		}
		
		personDAO.makePersistent(person);
		
		return result;
	}



}
