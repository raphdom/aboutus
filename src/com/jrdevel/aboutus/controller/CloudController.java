package com.jrdevel.aboutus.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jrdevel.aboutus.model.File;
import com.jrdevel.aboutus.service.CloudService;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

@Controller
public class CloudController {
	
	private CloudService cloudService;
	
	@Autowired
	public void setCloudService(CloudService cloudService) {
		this.cloudService = cloudService;
	}
	
	
	@RequestMapping(value="/cloud/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{
			
			ListResult<File> result = cloudService.getFilesList(input);
			
			return ExtJSReturn.mapOK(result.getData(), result.getTotal());
			
		} catch (Exception e) {

			return ExtJSReturn.mapError("Error retrieving People from database.");
		}
	}
	
	

}
