package com.jrdevel.aboutus.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.Permission;
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
	
	@Autowired
	private User userSession;
	
	@RequestMapping(value="/user/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{
			
			ResultObject result = userService.list(input);
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Contacts from database.");
		}
	}
	
	@RequestMapping(value="/user/save.action", method = RequestMethod.POST)
	public @ResponseBody Map<String,? extends Object> save(@RequestBody User data) throws Exception {

		try{

			ResultObject result = userService.update(data);
			
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
	
	@RequestMapping(value="/user/currentUser.action")
	public @ResponseBody Map<String,? extends Object> currentUser() throws Exception {

		try{
			
			ResultObject result = userService.get(userSession);
			User user = (User)result.getData().get(0);
			user.setPermissions(new HashSet<Permission>(userService.getUserPermissions(user)));
			
			return result.toMap();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	

}
