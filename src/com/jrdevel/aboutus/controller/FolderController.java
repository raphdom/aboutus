package com.jrdevel.aboutus.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.wrappers.FolderWrapper;
import com.jrdevel.aboutus.service.FolderService;
import com.jrdevel.aboutus.util.ExtJSReturn;

/**
 * @author Raphael Domingues
 *
 */
@Controller
public class FolderController {
	
	private FolderService folderService;
	
	@Autowired
	public void setGroupService(FolderService folderService) {
		this.folderService = folderService;
	}
	
	
	@RequestMapping(value="/folder/view.action")
	public @ResponseBody Map<String,? extends Object> view(HttpSession session) throws Exception {

		try{
			
			FolderWrapper result = folderService.getFoldersPermited();
			
			return ExtJSReturn.mapOK(result);
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving Groups from database.");
		}
	}
	

}
