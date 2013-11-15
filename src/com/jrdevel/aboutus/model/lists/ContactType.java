package com.jrdevel.aboutus.model.lists;

// Generated 15/Nov/2013 19:04:22 by Hibernate Tools 3.4.0.CR1

import com.jrdevel.aboutus.model.PersonContacts;
import com.jrdevel.aboutus.model.lists.translate.ContactTypeTranslate;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * ContactType generated by hbm2java
 */
@Entity
@Table(name = "lst_contactType")
public class ContactType implements java.io.Serializable {

	private String id;
	private Set<ContactTypeTranslate> contactTypeTranslates = new HashSet<ContactTypeTranslate>(
			0);
	private Set<PersonContacts> personContactses = new HashSet<PersonContacts>(
			0);

	public ContactType() {
	}

	public ContactType(String id) {
		this.id = id;
	}

	public ContactType(String id,
			Set<ContactTypeTranslate> contactTypeTranslates,
			Set<PersonContacts> personContactses) {
		this.id = id;
		this.contactTypeTranslates = contactTypeTranslates;
		this.personContactses = personContactses;
	}

	@Id
	@Column(name = "id", unique = true, nullable = false, length = 100)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contactType")
	public Set<ContactTypeTranslate> getContactTypeTranslates() {
		return this.contactTypeTranslates;
	}

	public void setContactTypeTranslates(
			Set<ContactTypeTranslate> contactTypeTranslates) {
		this.contactTypeTranslates = contactTypeTranslates;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contactType")
	public Set<PersonContacts> getPersonContactses() {
		return this.personContactses;
	}

	public void setPersonContactses(Set<PersonContacts> personContactses) {
		this.personContactses = personContactses;
	}

}
