package com.jrdevel.aboutus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ResultObject;

/**
 * @author Raphael Domingues
 *
 */
public abstract class GenericService<T> {
	
	@Autowired
	private User userSession;
	
	public User getUserSession(){
		return userSession;
	}
	
	public ResultObject newResultObject(){
		return new ResultObject();
	}
	
	@Transactional
	public abstract ResultObject list(ListParams params);
	@Transactional
	public abstract ResultObject update(T bean);
	@Transactional
	public abstract ResultObject get(T bean);
	@Transactional
	public abstract ResultObject delete(List<T> beans);

}
