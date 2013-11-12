package com.jrdevel.aboutus.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.GroupDAO;
import com.jrdevel.aboutus.model.Group;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class ListService {
	
	private GroupDAO groupDAO;
	
	/**
	 * Spring use - DI
	 * @param userDAO
	 */
	@Autowired
	public void setGroupDAO(GroupDAO groupDAO) {
		this.groupDAO = groupDAO;
	}
	
	
	/**
	 * Get all groups
	 * @return
	 */
	@Transactional
	public ListResult<Group> getList(ListParams params){

		return groupDAO.findAllByCriteria(params);
	}
	
	@Transactional
	public Group getGroup(int id){
		
		return groupDAO.getGroupById(id);
		
	}
	
	@Transactional
	public void updateGroup(Group entity){
		
		groupDAO.makePersistent(entity);
		
	}
	
	@Transactional
	public void deleteGroups(List<Group> entities){
		
		//groupDAO.makeTransient(entities);
		
	}

}
