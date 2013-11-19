package com.jrdevel.aboutus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.service.UserService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
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
			
			ResultObject result = userService.list(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Contacts from database.");
		}
	}
	
	@RequestMapping(value="/user/save.action")
	public @ResponseBody Map<String,? extends Object> save(User input) throws Exception {

		try{

			ResultObject result = userService.update(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error save User in database.");
		}
	}
	
	@RequestMapping(value="/user/get.action")
	public @ResponseBody Map<String,? extends Object> get(User input) throws Exception {

		try{
			
			ResultObject result = userService.get(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	
	@RequestMapping(value="/user/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(List<User> input) throws Exception {

		try{
			
			ResultObject result = userService.delete(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	

}
