package com.jrdevel.aboutus.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.Group;
import com.jrdevel.aboutus.service.GroupService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class GroupController {
	
	private GroupService groupService;
	
	@Autowired
	public void setGroupService(GroupService groupService) {
		this.groupService = groupService;
	}
	
	
	@RequestMapping(value="/group/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{
			
			ListResult<Group> result = groupService.getList(input);
			
			return ExtJSReturn.mapOK(result.getData(),result.getTotal());
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	
	@RequestMapping(value="/group/get.action")
	public @ResponseBody Map<String,? extends Object> get(Group input) throws Exception {

		try{
			
			Group group = groupService.getGroup(input.getId());
			
			return ExtJSReturn.mapOK(group);
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	
	@RequestMapping(value="/group/create.action")
	public @ResponseBody Map<String,? extends Object> create(Group input) throws Exception {

		try{

			groupService.updateGroup(input);
			
			return ExtJSReturn.mapOK();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	
	@RequestMapping(value="/group/delete.action")
	public @ResponseBody Map<String,? extends Object> delete(List<Group> input) throws Exception {

		try{

			groupService.deleteGroups(input);
			
			return ExtJSReturn.mapOK();
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}

}
