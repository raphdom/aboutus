package com.jrdevel.aboutus.util;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Raphael Domingues
 *
 */
public class JsonUtils {
	
	public static ObjectMapper OBJECT_MAPPER = new ObjectMapper(); 
	
	public static List<?> getListObjectsFromJson(String jsonInput, Class<?> className){
		try {
			return OBJECT_MAPPER.readValue(jsonInput, OBJECT_MAPPER.getTypeFactory().constructCollectionType(List.class, className));
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
