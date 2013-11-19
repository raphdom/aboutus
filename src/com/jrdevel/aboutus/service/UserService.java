package com.jrdevel.aboutus.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class UserService extends GenericService<User>{
	
	private UserDAO userDAO;
	
	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	@Transactional
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
	
	public ResultObject list(ListParams params) {
		
		ListResult<User> listResult = userDAO.findAllByCriteria(params);
		ResultObject result = newResultObject();
		result.setData(listResult.getData());
		result.setTotal(listResult.getTotal());
		
		return result;
	}


	public ResultObject get(User bean) {
		
		ResultObject result = newResultObject();
		
		if (bean == null || bean.getId() == null){
			result.setSuccess(false);
			result.addErrorMessage("Utilizador não existe.");
		}else{
			User user = userDAO.getUserById(bean.getId());
			result.setData(user);
		}
		
		return result;
	}


	public ResultObject delete(List<User> beans) {
		
		ResultObject result = newResultObject();
		
		for (User user: beans){
			userDAO.makeTransient(user);
		}
		
		return result;
	}
	
	//Private methods
	private boolean existUserEmail(String email) {
		
		User bean = userDAO.getUserByEmail(email);
		
		return bean != null;
		
	}


}
