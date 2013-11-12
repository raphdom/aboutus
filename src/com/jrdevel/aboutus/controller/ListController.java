package com.jrdevel.aboutus.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.service.AuthenticationService;
import com.jrdevel.aboutus.util.ExtJSReturn;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class ListController {

	private AuthenticationService authenticationService;

	@Autowired
	public void setContactService(AuthenticationService authenticationService) {
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="/list/country.action")
	public @ResponseBody Map<String,? extends Object> getListCountry(HttpSession session) throws Exception {

		try{

			return null;

		} catch (Exception e) {

			return ExtJSReturn.mapError("O Email não existe registado no sistema!");
		}
	}

}
