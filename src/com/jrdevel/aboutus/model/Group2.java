package com.jrdevel.aboutus.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Group2 implements Serializable{
	
	private Integer id;
	private String name;
	private List<Object> permissions = new ArrayList<Object>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Object> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Object> permissions) {
		this.permissions = permissions;
	}
	
}
