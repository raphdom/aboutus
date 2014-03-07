package com.jrdevel.aboutus.controller;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.jrdevel.aboutus.helper.AboutUsFileHelper;
import com.jrdevel.aboutus.service.CloudService;
import com.jrdevel.aboutus.util.AboutUsConfiguration;
import com.jrdevel.aboutus.util.ExtJSReturn;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ResultObject;

@Controller
@RequestMapping(value="/cloud")
public class CloudController {

	private CloudService cloudService;

	@Autowired
	private AboutUsConfiguration configuration;

	@Autowired
	public void setCloudService(CloudService cloudService) {
		this.cloudService = cloudService;
	}


	@RequestMapping(value="/view.action")
	public @ResponseBody Map<String,? extends Object> view(ListParams input) throws Exception {

		try{

			ResultObject result = cloudService.list(input);

			return result.toMap();

		} catch (Exception e) {
			e.printStackTrace();
			return ExtJSReturn.mapError("Error retrieving Files from database.");
		}
	}

	@RequestMapping(value="/upload.action", method = RequestMethod.POST)
	public @ResponseBody String upload(MultipartHttpServletRequest request) throws Exception {

		Iterator<String> itr =  request.getFileNames();

		MultipartFile mpf = request.getFile(itr.next());
		
		String folderIdParam = request.getParameter("folderId");
		Integer folderId = null;
		if (!folderIdParam.isEmpty()){
			folderId = Integer.parseInt(folderIdParam);
		}
		
		java.io.File file = new java.io.File(AboutUsFileHelper.getNameOfFile(configuration.getMediaPath())); 

		mpf.transferTo(file);

		cloudService.processFile(mpf.getInputStream(),mpf.getOriginalFilename(),mpf.getSize(),
				file.getAbsolutePath(), mpf.getContentType(),folderId);

		//System.out.println(mpf.getOriginalFilename() +" uploaded!");

		//Primeiro mover o ficheiro que esta guardado no temp para a pasta definitiva
		//Guardar os ficheiros originais em /mediaFiles/2013/0102/upload-temp
		//Redimensionar para criar as miniaturas se for um ficheiro de imagem
		//Criar somente o datatype=1 e datatype=2 que são para o AboutUs
		//Quando o utilizador colocar o ficheiro no album criar então o datatype=3 e datatype=4 que serão para o site
		//Guardar o registo na base de dados

		return "{'success':true,'message':'OK'}";


	}

	@RequestMapping(value="/getImage.action", method = RequestMethod.GET)
	public void get(@RequestParam Integer imageId, @RequestParam Integer dataType,
			final HttpServletResponse response) throws Exception {

		byte[] fileByteArray = cloudService.getThumb(imageId, dataType);

		if (fileByteArray != null && fileByteArray.length > 0){
			response.addHeader("Cache-Control", "public no-transform max-age=43200");
			response.getOutputStream().write(fileByteArray);
			response.getOutputStream().flush();
		}

	}



}
