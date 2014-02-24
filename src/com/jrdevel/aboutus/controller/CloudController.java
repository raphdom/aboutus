package com.jrdevel.aboutus.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
	
	@RequestMapping(value="/cloud/upload.action", method = RequestMethod.PUT)
	public @ResponseBody String upload(@RequestPart MultipartHttpServletRequest request) throws Exception {
		
		try {
            InputStream inputStream = request.getInputStream();
 
            if (inputStream != null) {
//                String filePath = urlParser.getFilePath(request.getRequestURI());
//                FileOutputStream outputStream = new FileOutputStream(new File(filePath));
 
//                byte[] buffer = new byte[1024];
//                int bytesRead;
 
//                while ((bytesRead = inputStream.read(buffer)) > 0) {
//                    outputStream.write(buffer, 0, bytesRead);
//                }
 
//                outputStream.flush();
 
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
		
		return "";
		
		
	}
	
	

}
