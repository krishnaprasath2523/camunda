/**
 * 
 */
package com.camunda.users;

/**
 * 
 */
public class User {

	private String id;
	private String sex;
	private String dob;
	private String address;
	private String profileName;
	private String firstName;
	private String middleName;
	private String lastName;
	
	/**
	 * @param id
	 * @param sex
	 * @param dob
	 * @param address
	 * @param profileName
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public User(String id, String sex, String dob, String address, String profileName, String firstName,
			String middleName, String lastName) {
		super();
		this.id = id;
		this.sex = sex;
		this.dob = dob;
		this.address = address;
		this.profileName = profileName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the profileName
	 */
	public String getProfileName() {
		return profileName;
	}
	/**
	 * @param profileName the profileName to set
	 */
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [" + (getId() != null ? "getId()=" + getId() + ", " : "")
				+ (getSex() != null ? "getSex()=" + getSex() + ", " : "")
				+ (getDob() != null ? "getDob()=" + getDob() + ", " : "")
				+ (getAddress() != null ? "getAddress()=" + getAddress() + ", " : "")
				+ (getProfileName() != null ? "getProfileName()=" + getProfileName() + ", " : "")
				+ (getFirstName() != null ? "getFirstName()=" + getFirstName() + ", " : "")
				+ (getMiddleName() != null ? "getMiddleName()=" + getMiddleName() + ", " : "")
				+ (getLastName() != null ? "getLastName()=" + getLastName() : "") + "]";
	}
	
}
