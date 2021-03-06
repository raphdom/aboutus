package com.jrdevel.aboutus.model;

// Generated 4/Mar/2014 12:22:19 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Audit generated by hbm2java
 */
@Entity
@Table(name = "tbl_audit")
public class Audit implements java.io.Serializable {

	private Integer id;
	private int userId;
	private int actionId;
	private Date actionDate;
	private String tableName;
	private int tableId;
	private String collumnName;
	private String collumnValue;
	private String collumnNewValue;
	private String objectName;
	private String objectTitle;
	private String userName;

	public Audit() {
	}

	public Audit(int userId, int actionId, Date actionDate, String tableName,
			int tableId) {
		this.userId = userId;
		this.actionId = actionId;
		this.actionDate = actionDate;
		this.tableName = tableName;
		this.tableId = tableId;
	}

	public Audit(int userId, int actionId, Date actionDate, String tableName,
			int tableId, String collumnName, String collumnValue,
			String collumnNewValue, String objectName, String objectTitle,
			String userName) {
		this.userId = userId;
		this.actionId = actionId;
		this.actionDate = actionDate;
		this.tableName = tableName;
		this.tableId = tableId;
		this.collumnName = collumnName;
		this.collumnValue = collumnValue;
		this.collumnNewValue = collumnNewValue;
		this.objectName = objectName;
		this.objectTitle = objectTitle;
		this.userName = userName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "user_id", nullable = false)
	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name = "action_id", nullable = false)
	public int getActionId() {
		return this.actionId;
	}

	public void setActionId(int actionId) {
		this.actionId = actionId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "actionDate", nullable = false, length = 19)
	public Date getActionDate() {
		return this.actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}

	@Column(name = "table_name", nullable = false)
	public String getTableName() {
		return this.tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Column(name = "table_id", nullable = false)
	public int getTableId() {
		return this.tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	@Column(name = "collumn_name", length = 100)
	public String getCollumnName() {
		return this.collumnName;
	}

	public void setCollumnName(String collumnName) {
		this.collumnName = collumnName;
	}

	@Column(name = "collumn_value")
	public String getCollumnValue() {
		return this.collumnValue;
	}

	public void setCollumnValue(String collumnValue) {
		this.collumnValue = collumnValue;
	}

	@Column(name = "collumn_new_value")
	public String getCollumnNewValue() {
		return this.collumnNewValue;
	}

	public void setCollumnNewValue(String collumnNewValue) {
		this.collumnNewValue = collumnNewValue;
	}

	@Column(name = "objectName")
	public String getObjectName() {
		return this.objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	@Column(name = "objectTitle")
	public String getObjectTitle() {
		return this.objectTitle;
	}

	public void setObjectTitle(String objectTitle) {
		this.objectTitle = objectTitle;
	}

	@Column(name = "userName")
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
