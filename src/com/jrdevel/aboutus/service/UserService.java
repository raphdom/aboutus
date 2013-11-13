package com.jrdevel.aboutus.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;
import com.jrdevel.aboutus.util.PasswordGenerator;
import com.jrdevel.aboutus.util.ResultObject;

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
	
	@Transactional(propagation=Propagation.NESTED)
	public ResultObject update(User entity){
		
		ResultObject result = new ResultObject();
		
		boolean isUpdate = entity.getId() != null;
		
		if (!isUpdate){
			if (existUserEmail(entity.getEmail())){
				result.setSuccess(false);
				result.addErrorMessage("Este email já existe registado na aplicação");
				return result;
			}
			entity.setRegisterDate(new Date());
			entity.setPassword(PasswordGenerator.passGenerator(8));
		}
		
		userDAO.makePersistent(entity);
		
		result.setSuccess(true);
		
		return result;
		
	}
	
	private boolean existUserEmail(String email) {
		
		User bean = userDAO.getUserByEmail(email);
		
		return bean != null;
		
	}
	
	@Transactional
	public User getUser(int id){
		
		return userDAO.getUserById(id);
		
	}



}
