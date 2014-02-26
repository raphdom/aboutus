package com.jrdevel.aboutus.model.view;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Raphael Domingues
 *
 */
public class UserView implements Serializable{
	
	private Integer id;
	private String email;
	private String personName;
	private String churchName;
	private boolean block;
	private boolean activation;
	private Date lastvisitDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isBlock() {
		return block;
	}
	public void setBlock(boolean block) {
		this.block = block;
	}
	public boolean isActivation() {
		return activation;
	}
	public void setActivation(boolean activation) {
		this.activation = activation;
	}
	public Date getLastvisitDate() {
		return lastvisitDate;
	}
	public void setLastvisitDate(Date lastvisitDate) {
		this.lastvisitDate = lastvisitDate;
	}
	public String getPersonName() {
		return personName;
	}
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	public String getChurchName() {
		return churchName;
	}
	public void setChurchName(String churchName) {
		this.churchName = churchName;
	}
	
}
