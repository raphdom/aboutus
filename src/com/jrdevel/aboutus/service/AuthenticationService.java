package com.jrdevel.aboutus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.User;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class AuthenticationService {
	

	private UserDAO userDAO;
	
	/**
	 * Get user login
	 * @return
	 */
	@Transactional
	public User getUser(String email){
		
		return userDAO.getUserByEmail(email);
		
	}
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
}
