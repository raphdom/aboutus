package com.jrdevel.aboutus.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Raphael Domingues
 *
 */
public class AboutUsFileHelper {
	
	public static String getDirectoryPath(){
		
		return "/home/raphael/mediaFiles/";
		
	}
	
	public static String getNameOfFile(){
		
		File directory = new File(getDirectoryPath() + year() + "/" + monthDay()+"/");
		
		if (!directory.exists()){
			directory.mkdirs();
		}
		
		return getDirectoryPath() + year() + "/" + monthDay() + "/" + generateUniqueFileName("upload-",".bin");
		
	}
	
	public static String year() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return sdf.format(cal.getTime());

	}
	
	public static String monthDay() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("MMdd");
		return sdf.format(cal.getTime());

	}
	
	public static String generateUniqueFileName(String prefix, String suffix){
		return (prefix != null ? prefix : "" ) + System.nanoTime() + (suffix != null ? suffix : "" ) ;
	}
	

}
