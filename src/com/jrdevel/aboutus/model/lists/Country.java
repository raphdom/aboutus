package com.jrdevel.aboutus.model.lists;

// Generated 4/Mar/2014 12:22:19 by Hibernate Tools 3.4.0.CR1

import com.jrdevel.aboutus.model.Access;
import com.jrdevel.aboutus.model.Church;
import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.model.Register;
import com.jrdevel.aboutus.model.lists.translate.CountryTranslate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "lst_country")
public class Country implements java.io.Serializable {

	private String id;
	private Set<Access> accesses = new HashSet<Access>(0);
	private Set<Register> registers = new HashSet<Register>(0);
	private Set<Person> persons = new HashSet<Person>(0);
	private Set<Church> churches = new HashSet<Church>(0);
	private Set<CountryTranslate> countryTranslates = new HashSet<CountryTranslate>(
			0);

	public Country() {
	}

	public Country(String id) {
		this.id = id;
	}

	public Country(String id, Set<Access> accesses, Set<Register> registers,
			Set<Person> persons, Set<Church> churches,
			Set<CountryTranslate> countryTranslates) {
		this.id = id;
		this.accesses = accesses;
		this.registers = registers;
		this.persons = persons;
		this.churches = churches;
		this.countryTranslates = countryTranslates;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Access> getAccesses() {
		return this.accesses;
	}

	public void setAccesses(Set<Access> accesses) {
		this.accesses = accesses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Register> getRegisters() {
		return this.registers;
	}

	public void setRegisters(Set<Register> registers) {
		this.registers = registers;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<Church> getChurches() {
		return this.churches;
	}

	public void setChurches(Set<Church> churches) {
		this.churches = churches;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<CountryTranslate> getCountryTranslates() {
		return this.countryTranslates;
	}

	public void setCountryTranslates(Set<CountryTranslate> countryTranslates) {
		this.countryTranslates = countryTranslates;
	}

}
