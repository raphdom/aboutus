package com.jrdevel.aboutus.model.lists;

// Generated 23/Set/2013 20:26:47 by Hibernate Tools 4.0.0

import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.model.lists.translate.CivilStatusTranslate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CivilStatus generated by hbm2java
 */
@Entity
@Table(name = "lst_civilStatus")
public class CivilStatus implements java.io.Serializable {

	private String id;
	private Set<Person> persons = new HashSet<Person>(0);
	private Set<CivilStatusTranslate> civilStatusTranslates = new HashSet<CivilStatusTranslate>(
			0);

	public CivilStatus() {
	}

	public CivilStatus(String id) {
		this.id = id;
	}

	public CivilStatus(String id, Set<Person> persons,
			Set<CivilStatusTranslate> civilStatusTranslates) {
		this.id = id;
		this.persons = persons;
		this.civilStatusTranslates = civilStatusTranslates;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "civilStatus")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "civilStatus")
	public Set<CivilStatusTranslate> getCivilStatusTranslates() {
		return this.civilStatusTranslates;
	}

	public void setCivilStatusTranslates(
			Set<CivilStatusTranslate> civilStatusTranslates) {
		this.civilStatusTranslates = civilStatusTranslates;
	}

}
