package com.jrdevel.aboutus.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.CustomerDAO;
import com.jrdevel.aboutus.dao.RegisterDAO;
import com.jrdevel.aboutus.dao.UserDAO;
import com.jrdevel.aboutus.model.Church;
import com.jrdevel.aboutus.model.Customer;
import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.model.Plan;
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
	private CustomerDAO customerDAO;

	private ChurchService churchService;
	private PersonService personService;

	@Autowired
	private User userSession;

	@Autowired
	public void setChurchService(ChurchService churchService) {
		this.churchService = churchService;
	}

	@Autowired
	public void setPersonService(PersonService personService) {
		this.personService = personService;
	}

	@Transactional
	public ResultObject login(User user){
		ResultObject result = new ResultObject();

		User userDB = userDAO.getUserByEmail(user.getEmail());

		if (userDB!=null && user.getPassword().equals(userDB.getPassword())){
			if (!userDB.isActivation() && userDB.getCustomer()==null){
				Register register = getRegister(userDB);
				Customer customer = createCustomer(register);
				Church church = createChurch(register, customer);
				Person person = createPerson(register, church, customer);

				userDB.setCustomer(customer);
				userDB.setChurch(church);
				userDB.setPerson(person);

				userDB.setActivation(true);
				userDB.setLastvisitDate(new Date());

				userDAO.makePersistent(userDB);

			}else if (!userDB.isActivation() && userDB.getCustomer()!=null){
				//TODO abrir a janela de altera��o de palavra-passe
			}else{
				userDB.setLastvisitDate(new Date());
				userDAO.makePersistent(userDB);
			}
			saveUserSession(userDB);
		}else{
			result.setSuccess(false);
			result.addErrorMessage("Nome do utilizador ou palavra-chave incorreta.");
			return result;
		}

		return result;
	}
	
	private void saveUserSession(User user){
		userSession.setId(user.getId());
		userSession.setEmail(user.getEmail());
		userSession.setCustomer(user.getCustomer());
	}

	private Register getRegister(User user){
		return registerDAO.getRegisterByUser(user);
	}

	private Customer createCustomer(Register register){

		Plan plan = new Plan();
		plan.setId(1);

		Customer customer = new Customer();
		customer.setName(register.getChurchName());
		customer.setPlan(plan);

		customerDAO.makePersistent(customer);

		return customer;
	}

	private Church createChurch(Register register, Customer customer){

		Church church = new Church();
		church.setName(register.getChurchName());
		church.setCompleteName(register.getChurchName());
		church.setAddress(register.getChurchAddress());
		church.setCountry(register.getCountry());
		church.setCustomer(customer);

		churchService.update(church);

		return church;
	}

	private Person createPerson(Register register, Church church, Customer customer){

		Person person = new Person();
		person.setName(register.getNameResp());
		person.setIsMember(true);
		person.setChurch(church);
		person.setCustomer(customer);

		personService.update(person);

		return person;
	}

	/**
	 * Register
	 * @return
	 */
	@Transactional
	public ResultObject register(Register register){

		ResultObject result = new ResultObject();

		//Validations
		//Registo j� existe
		if (registerDAO.existEmailRegistered(register.getEmail()) ||
				userDAO.existEmailRegistered(register.getEmail())){
			result.setSuccess(false);
			result.addErrorMessage("Este email j� existe registado na aplica��o");
			return result;
		}

		register.setRegisterDate(new Date());
		registerDAO.makePersistent(register);
		User user = registerUser(register);
		register.setUser(user);
		registerDAO.makePersistent(register);

		result.setSuccess(true);

		return result;

	}

	public User registerUser(Register register){
		User user = new User();
		user.setEmail(register.getEmail());
		user.setPassword(register.getPassword());
		user.setRegisterDate(register.getRegisterDate());
		userDAO.makePersistent(user);
		return user;
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

	@Autowired
	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

}
