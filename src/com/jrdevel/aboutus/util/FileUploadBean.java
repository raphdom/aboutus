package com.jrdevel.aboutus.util;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * @author Raphael Domingues
 *
 */
public class FileUploadBean {
	
	private CommonsMultipartFile file;
	 
    public CommonsMultipartFile getFile() {
        return file;
    }
 
    public void setFile(CommonsMultipartFile file) {
        this.file = file;
    }

}
