package com.jrdevel.aboutus.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ListParams;
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
		
		//ListResult<User> listResult = userDAO.findAllByCriteria(params);
		ResultObject result = newResultObject();
		Person person1 = new Person();
		person1.setId(1);
		person1.setName("User teste 1");
		User user1 = new User();
		user1.setId(1);
		user1.setEmail("user1@teste.com");
		user1.setPerson(person1);
		
		Person person2 = new Person();
		person2.setId(2);
		person2.setName("User teste 2");
		User user2 = new User();
		user2.setId(2);
		user2.setEmail("user2@teste.com");
		user2.setPerson(person2);
		
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		result.setData(users);
		result.setTotal(2);
		
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
