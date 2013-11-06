package com.jrdevel.aboutus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.FolderDAO;
import com.jrdevel.aboutus.model.Folder;
import com.jrdevel.aboutus.model.User;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class FolderService {
	
	private FolderDAO folderDAO;
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setFolderDAO(FolderDAO folderDAO) {
		this.folderDAO = folderDAO;
	}
	
	
	/**
	 * Get all folders
	 * @return
	 */
	@Transactional
	public ListResult<Folder> getFolders(ListParams params){

		return folderDAO.findAllByCriteria(params);
	}
	
	@Transactional
	public List<Folder> getFoldersPermited(User user){

		return folderDAO.getFoldersPermited(user);
		
	}
	
	

}
