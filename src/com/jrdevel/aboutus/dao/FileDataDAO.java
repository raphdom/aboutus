package com.jrdevel.aboutus.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.jrdevel.aboutus.model.FileData;

/**
 * @author Raphael Domingues
 *
 */
@Repository
public class FileDataDAO extends GenericDAO<FileData, Integer>{
	
	public void setExtraFilters(Criteria criteria) {
		
		
	}
	
	public FileData getFileDataByFileAndDataType(Integer fileId, Integer dataType){
 		
		return findUniqueByCriteria(Restrictions.eq("file.id", fileId),
				Restrictions.eq("dataType", dataType));
		
	}

}
