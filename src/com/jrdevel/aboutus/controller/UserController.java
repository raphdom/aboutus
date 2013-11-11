package com.jrdevel.aboutus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.service.UserService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;
import com.jrdevel.aboutus.util.ResultObject;

@Controller
public class UserController {
	
	private UserService userService;
	
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	@RequestMapping(value="/user/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{
			
			ListResult<User> result = userService.getUserList(input);
			
			return ExtJSReturn.mapOK(result.getData(),result.getTotal());
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Contacts from database.");
		}
	}
	
	@RequestMapping(value="/user/create.action")
	public @ResponseBody Map<String,? extends Object> create(User input) throws Exception {

		try{

			ResultObject result = userService.update(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error save User in database.");
		}
	}
	
	

}
