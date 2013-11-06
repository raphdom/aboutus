package com.jrdevel.aboutus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class UserService {
	
	private UserDAO userDAO;
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	/**
	 * Get all users
	 * @return
	 */
	@Transactional
	public ListResult<User> getUserList(ListParams params){

		return userDAO.findAllByCriteria(params);
	}



}
