package com.jrdevel.aboutus.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class MainController {
	
	@RequestMapping(value="/home.action")
	public ModelAndView home(HttpSession session) throws Exception {
		
		if (session.getAttribute("user")==null){
			return new ModelAndView("home");
		}else{
			return new ModelAndView("home");
		}
		
	}

}
