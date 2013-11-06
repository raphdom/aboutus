package com.jrdevel.aboutus.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.ChurchDAO;
import com.jrdevel.aboutus.model.Church;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class ChurchService {
	
	private ChurchDAO churchDAO;
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setChurchDAO(ChurchDAO churchDAO) {
		this.churchDAO = churchDAO;
	}
	
	
	/**
	 * Get all churchs
	 * @return
	 */
	@Transactional
	public ListResult<Church> getChurchList(ListParams params){

		return churchDAO.findAllByCriteria(params);
		
	}



}
