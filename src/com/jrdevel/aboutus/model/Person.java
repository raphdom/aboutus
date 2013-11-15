package com.jrdevel.aboutus.model;

// Generated 15/Nov/2013 19:04:22 by Hibernate Tools 3.4.0.CR1

import com.jrdevel.aboutus.model.lists.CivilStatus;
import com.jrdevel.aboutus.model.lists.Country;
import com.jrdevel.aboutus.model.lists.MemberType;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name = "tbl_person")
public class Person implements java.io.Serializable {

	private Integer id;
	private MemberType memberType;
	private Church church;
	private CivilStatus civilStatus;
	private Customer customer;
	private Country country;
	private String name;
	private boolean isMember;
	private int nif;
	private Date birthday;
	private Date baptismdate;
	private String profession;
	private boolean consolidated;
	private int state;
	private boolean male;
	private boolean baptized;
	private Date arrivalChurchDate;
	private String precedingChurch;
	private String observations;
	private Set<MemberFunction> memberFunctions = new HashSet<MemberFunction>(0);
	private Set<PersonContacts> personContactses = new HashSet<PersonContacts>(
			0);
	private Set<User> users = new HashSet<User>(0);
	private Set<Address> addresses = new HashSet<Address>(0);

	public Person() {
	}

	public Person(Church church, Customer customer, String name,
			boolean isMember, int nif, boolean consolidated, int state,
			boolean male, boolean baptized) {
		this.church = church;
		this.customer = customer;
		this.name = name;
		this.isMember = isMember;
		this.nif = nif;
		this.consolidated = consolidated;
		this.state = state;
		this.male = male;
		this.baptized = baptized;
	}

	public Person(MemberType memberType, Church church,
			CivilStatus civilStatus, Customer customer, Country country,
			String name, boolean isMember, int nif, Date birthday,
			Date baptismdate, String profession, boolean consolidated,
			int state, boolean male, boolean baptized, Date arrivalChurchDate,
			String precedingChurch, String observations,
			Set<MemberFunction> memberFunctions,
			Set<PersonContacts> personContactses, Set<User> users,
			Set<Address> addresses) {
		this.memberType = memberType;
		this.church = church;
		this.civilStatus = civilStatus;
		this.customer = customer;
		this.country = country;
		this.name = name;
		this.isMember = isMember;
		this.nif = nif;
		this.birthday = birthday;
		this.baptismdate = baptismdate;
		this.profession = profession;
		this.consolidated = consolidated;
		this.state = state;
		this.male = male;
		this.baptized = baptized;
		this.arrivalChurchDate = arrivalChurchDate;
		this.precedingChurch = precedingChurch;
		this.observations = observations;
		this.memberFunctions = memberFunctions;
		this.personContactses = personContactses;
		this.users = users;
		this.addresses = addresses;
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
	@JoinColumn(name = "memberType")
	public MemberType getMemberType() {
		return this.memberType;
	}

	public void setMemberType(MemberType memberType) {
		this.memberType = memberType;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "churchId", nullable = false)
	public Church getChurch() {
		return this.church;
	}

	public void setChurch(Church church) {
		this.church = church;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "civilStatus")
	public CivilStatus getCivilStatus() {
		return this.civilStatus;
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		this.civilStatus = civilStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customerId", nullable = false)
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nacionality")
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Column(name = "name", nullable = false)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "isMember", nullable = false)
	public boolean isIsMember() {
		return this.isMember;
	}

	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	@Column(name = "nif", nullable = false)
	public int getNif() {
		return this.nif;
	}

	public void setNif(int nif) {
		this.nif = nif;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "birthday", length = 19)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "baptismdate", length = 19)
	public Date getBaptismdate() {
		return this.baptismdate;
	}

	public void setBaptismdate(Date baptismdate) {
		this.baptismdate = baptismdate;
	}

	@Column(name = "profession")
	public String getProfession() {
		return this.profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Column(name = "consolidated", nullable = false)
	public boolean isConsolidated() {
		return this.consolidated;
	}

	public void setConsolidated(boolean consolidated) {
		this.consolidated = consolidated;
	}

	@Column(name = "state", nullable = false)
	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "male", nullable = false)
	public boolean isMale() {
		return this.male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Column(name = "baptized", nullable = false)
	public boolean isBaptized() {
		return this.baptized;
	}

	public void setBaptized(boolean baptized) {
		this.baptized = baptized;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "arrivalChurchDate", length = 19)
	public Date getArrivalChurchDate() {
		return this.arrivalChurchDate;
	}

	public void setArrivalChurchDate(Date arrivalChurchDate) {
		this.arrivalChurchDate = arrivalChurchDate;
	}

	@Column(name = "precedingChurch")
	public String getPrecedingChurch() {
		return this.precedingChurch;
	}

	public void setPrecedingChurch(String precedingChurch) {
		this.precedingChurch = precedingChurch;
	}

	@Column(name = "observations", length = 65535)
	public String getObservations() {
		return this.observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<MemberFunction> getMemberFunctions() {
		return this.memberFunctions;
	}

	public void setMemberFunctions(Set<MemberFunction> memberFunctions) {
		this.memberFunctions = memberFunctions;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<PersonContacts> getPersonContactses() {
		return this.personContactses;
	}

	public void setPersonContactses(Set<PersonContacts> personContactses) {
		this.personContactses = personContactses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "person")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
