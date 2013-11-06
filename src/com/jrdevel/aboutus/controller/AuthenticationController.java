package com.jrdevel.aboutus.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.service.AuthenticationService;
import com.jrdevel.aboutus.util.ExtJSReturn;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class AuthenticationController {
	
	private AuthenticationService authenticationService;
	
	@Autowired
	public void setContactService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}
	
	@RequestMapping(value="/login.action")
	public @ResponseBody Map<String,? extends Object> login(User user, HttpSession session) throws Exception {

		try{

			User userDB = authenticationService.getUser(user.getEmail());
			
			if (user.getPassword().equals(userDB.getPassword())){
				session.setAttribute("user", userDB);
				return ExtJSReturn.mapOK();
			}else{
				return ExtJSReturn.mapError("Palavra-chave incorreta!");
			}	
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("O Email não existe registado no sistema!");
		}
	}
	
	@RequestMapping(value="/logout.action")
	public ModelAndView logout(HttpSession session){
		
		session.setAttribute("user", null);
		
		return new ModelAndView("login");
	}

}
