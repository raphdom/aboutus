package com.jrdevel.aboutus.model;

// Generated 5/Jan/2014 19:49:45 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * FileData generated by hbm2java
 */
@Entity
@Table(name = "tbl_file_data")
public class FileData implements java.io.Serializable {

	private Integer id;
	private File file;
	private byte[] data;
	private Integer dataType;

	public FileData() {
	}

	public FileData(File file) {
		this.file = file;
	}

	public FileData(File file, byte[] data, Integer dataType) {
		this.file = file;
		this.data = data;
		this.dataType = dataType;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "file_id", nullable = false)
	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Column(name = "data")
	public byte[] getData() {
		return this.data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	@Column(name = "dataType")
	public Integer getDataType() {
		return this.dataType;
	}

	public void setDataType(Integer dataType) {
		this.dataType = dataType;
	}

}
