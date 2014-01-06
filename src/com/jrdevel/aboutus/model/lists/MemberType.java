package com.jrdevel.aboutus.model.lists;

// Generated 5/Jan/2014 19:49:45 by Hibernate Tools 3.4.0.CR1

import com.jrdevel.aboutus.model.Person;
import com.jrdevel.aboutus.model.lists.translate.MemberTypeTranslate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MemberType generated by hbm2java
 */
@Entity
@Table(name = "lst_memberType")
public class MemberType implements java.io.Serializable {

	private String id;
	private Set<Person> persons = new HashSet<Person>(0);
	private Set<MemberTypeTranslate> memberTypeTranslates = new HashSet<MemberTypeTranslate>(
			0);

	public MemberType() {
	}

	public MemberType(String id) {
		this.id = id;
	}

	public MemberType(String id, Set<Person> persons,
			Set<MemberTypeTranslate> memberTypeTranslates) {
		this.id = id;
		this.persons = persons;
		this.memberTypeTranslates = memberTypeTranslates;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberType")
	public Set<Person> getPersons() {
		return this.persons;
	}

	public void setPersons(Set<Person> persons) {
		this.persons = persons;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "memberType")
	public Set<MemberTypeTranslate> getMemberTypeTranslates() {
		return this.memberTypeTranslates;
	}

	public void setMemberTypeTranslates(
			Set<MemberTypeTranslate> memberTypeTranslates) {
		this.memberTypeTranslates = memberTypeTranslates;
	}

}
