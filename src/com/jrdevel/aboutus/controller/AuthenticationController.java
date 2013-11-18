package com.jrdevel.aboutus.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.jrdevel.aboutus.model.Register;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.service.AuthenticationService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ResultObject;

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

			ResultObject result = authenticationService.login(user);

			return result.toMap();

		} catch (Exception e) {
			e.printStackTrace();
			return ExtJSReturn.mapError("Erro no login");
		}
	}

	@RequestMapping(value="/register.action")
	public @ResponseBody Map<String,? extends Object> register(Register register, HttpSession session) throws Exception {

		try{

			ResultObject result = authenticationService.register(register);

			return result.toMap();

		} catch (Exception e) {

			return ExtJSReturn.mapError("O Email não existe registado no sistema!");
		}
	}

	@RequestMapping(value="/logout.action")
	public ModelAndView logout(HttpSession session){

		session.setAttribute("scopedTarget.userSession", null);
		return new ModelAndView(new RedirectView("")); 
	}

}
