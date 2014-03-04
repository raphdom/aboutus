package com.jrdevel.aboutus.service;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jrdevel.aboutus.dao.FileDAO;
import com.jrdevel.aboutus.dao.FileDataDAO;
import com.jrdevel.aboutus.dao.FolderDAO;
import com.jrdevel.aboutus.helper.AboutUsFileHelper;
import com.jrdevel.aboutus.helper.ImageSize;
import com.jrdevel.aboutus.helper.ImageTransformHelper;
import com.jrdevel.aboutus.model.File;
import com.jrdevel.aboutus.model.FileData;
import com.jrdevel.aboutus.model.Folder;
import com.jrdevel.aboutus.util.AboutUsConfiguration;
import com.jrdevel.aboutus.util.ListParams;
import com.jrdevel.aboutus.util.ListResult;
import com.jrdevel.aboutus.util.ResultObject;

/**
 * @author Raphael Domingues
 *
 */
@Service
public class CloudService extends GenericService<File>{
	
	private FileDAO fileDAO;
	private FileDataDAO fileDataDAO;
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
	 * Spring use - DI
	 * @param folderDAO
	 */
	@Autowired
	public void setFileDataDAO(FileDataDAO fileDataDAO) {
		this.fileDataDAO = fileDataDAO;
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
	
	@Transactional
	public void processFile(InputStream inputStream, String name, Long size, 
			String filePath, String fileType){
		
		File fileBean = new File();
		fileBean.setFilename(name);
		fileBean.setFileType(fileType);
		fileBean.setFilesize(size);
		fileBean.setTitle(name);
		Folder folder = new Folder();
		folder.setId(4);
		fileBean.setFolder(folder);
		fileBean.setPath(filePath);
		fileBean.setCreatedDate(new Date());
		fileBean.setModifiedDate(new Date());
		fileBean.setCustomer(getUserSession().getCustomer());
		
		fileDAO.makePersistent(fileBean);
		
		if (AboutUsFileHelper.imageResizeSupported(fileType)){
			
			ImageTransformHelper imageTransform = new ImageTransformHelper();
			HashMap<ImageSize,byte[]> result = imageTransform.transformImages(inputStream, 
					ImageTransformHelper.DATA_TYPE_SMALL_1,
					ImageTransformHelper.DATA_TYPE_SMALL_2);
			
			for (ImageSize imgSize : result.keySet()){
				if (result.get(imgSize)!= null && result.get(imgSize).length > 0){
					FileData fileData = new FileData();
					fileData.setDataType(imgSize.getDataType());
					fileData.setFile(fileBean);
					fileData.setData(result.get(imgSize));
					fileDataDAO.makePersistent(fileData);
				}
			}
			
		}
		
	}

	@Override
	public ResultObject list(ListParams params) {
		return null;
	}

	@Override
	public ResultObject update(File bean) {
		return null;
	}

	@Override
	public ResultObject get(File bean) {
		return null;
	}

	@Override
	public ResultObject delete(List<File> beans) {
		return null;
	}



}
