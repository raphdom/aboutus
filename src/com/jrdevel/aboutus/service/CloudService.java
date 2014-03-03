package com.jrdevel.aboutus.service;

import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.FileDAO;
import com.jrdevel.aboutus.dao.FolderDAO;
import com.jrdevel.aboutus.model.File;
import com.jrdevel.aboutus.model.Folder;
import com.jrdevel.aboutus.util.AboutUsConfiguration;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class CloudService {
	
	private FileDAO fileDAO;
	private FolderDAO folderDAO;
	
	@Autowired
	private AboutUsConfiguration configuration;
	
	
	/**
	 * Spring use - DI
	 * @param fileDAO
	 */
	@Autowired
	public void setFileDAO(FileDAO fileDAO) {
		this.fileDAO = fileDAO;
	}
	
	/**
	 * Spring use - DI
	 * @param folderDAO
	 */
	@Autowired
	public void setFolderDAO(FolderDAO folderDAO) {
		this.folderDAO = folderDAO;
	}
	
	
	/**
	 * Get all files
	 * @return
	 */
	@Transactional
	public ListResult<File> getFilesList(ListParams params){

		return fileDAO.findAllByCriteria(params);
		
	}
	
	/**
	 * Get all folders
	 * @return
	 */
	@Transactional
	public ListResult<Folder> getFoldersList(ListParams params){

		return folderDAO.findAllByCriteria(params);
		
	}
	
	public void processFile(InputStream inputStream, String name, Long size){
		
	}



}
