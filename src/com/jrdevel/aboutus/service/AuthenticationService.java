package com.jrdevel.aboutus.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.RegisterDAO;
import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.Register;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ResultObject;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class AuthenticationService {
	

	private UserDAO userDAO;
	private RegisterDAO registerDAO;
	
	/**
	 * Get user login
	 * @return
	 */
	@Transactional
	public User getUser(String email){
		
		return userDAO.getUserByEmail(email);
		
	}
	
	/**
	 * Register
	 * @return
	 */
	@Transactional
	public ResultObject register(Register register){
		
		ResultObject result = new ResultObject();
		
		//Validations
		//Registo já existe
		if (registerDAO.existEmailRegistered(register.getEmail()) ||
				userDAO.existEmailRegistered(register.getEmail())){
			result.setSuccess(false);
			result.addErrorMessage("Este email já existe registado na aplicação");
			return result;
		}
		
		register.setRegisterDate(new Date());
		registerDAO.makePersistent(register);
		registerUser(register);
		
		result.setSuccess(true);
		
		return result;
		
	}
	
	public void registerUser(Register register){
		User user = new User();
		user.setEmail(register.getEmail());
		user.setPassword(register.getPassword());
		user.setRegisterDate(register.getRegisterDate());
		userDAO.makePersistent(user);
	}
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	/**
	 * Spring use - DI
	 * @param registerDAO
	 */
	@Autowired
	public void setRegisterDAO(RegisterDAO registerDAO) {
		this.registerDAO = registerDAO;
	}
	
}
