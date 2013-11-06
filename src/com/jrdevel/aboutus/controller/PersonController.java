package com.jrdevel.aboutus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.service.PersonService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

@Controller
public class PersonController {
	
	private PersonService personService;
	
	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}
	
	
	@RequestMapping(value="/person/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{
			
			ListResult<Person> result = personService.getPersonList(input);
			
			return ExtJSReturn.mapOK(result.getData(), result.getTotal());
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving People from database.");
		}
	}
	
	

}
