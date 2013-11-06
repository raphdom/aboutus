package com.jrdevel.aboutus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.PermissionDAO;
import com.jrdevel.aboutus.model.Permission;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class PermissionService {
	
	private PermissionDAO permissionDAO;
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setPermissionDAO(PermissionDAO permissionDAO) {
		this.permissionDAO = permissionDAO;
	}
	
	
	/**
	 * Get all users
	 * @return
	 */
	@Transactional
	public ListResult<Permission> getList(ListParams params){

		return permissionDAO.findAllByCriteria(params);
	}



}
