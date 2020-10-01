package com.ams.mufins.model.base;

import java.io.Serializable;

import com.ams.mufins.model.Role;
/**
 * This is an object that contains data related to the users table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users"
 */

public abstract class BaseUsers  implements Serializable {

	public static String REF = "Users";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_USER_PASS = "UserPass";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_SUPERVISOR = "Supervisor";
	public static String PROP_SSO = "Sso";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_IP = "Ip";
	public static String PROP_RSA = "Rsa";
	public static String PROP_PRINTER = "Printer";
	public static String PROP_NAME = "Name";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_CITY = "City";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_HANDPHONE = "Handphone";
	public static String PROP_EMAIL = "Email";
	public static String PROP_ORGANIZATION_ID = "OrganizationId";
	public static String PROP_INSURANCE_VENDOR_ID = "InsuranceVendorId";
	public static String PROP_SALES_CATEGORY = "salesCategory";
	public static String PROP_LAST_LOGIN_TIME = "LastLoginTime";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	public static String PROP_LOGIN_ATTEMPT_COUNTER = "LoginAttemptCounter";


	// constructors
	public BaseUsers () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsers (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsers (
		long id,
		java.lang.String userName,
		java.lang.String userPass,
		long organizationId) {

		this.setId(id);
		this.setUserName(userName);
		this.setUserPass(userPass);
		this.setOrganizationId(organizationId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String userName;
	private java.lang.String userPass;
	private boolean active;
	private boolean supervisor;
	private boolean sso;
	private java.lang.String userType;
	private java.lang.String ip;
	private java.lang.String rsa;
	private java.lang.String printer;
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String city;
	private java.lang.String phoneNumber;
	private java.lang.String handphone;
	private java.lang.String email;
	private long organizationId;
	private java.lang.Long insuranceVendorId;
	private java.lang.String salesCategory;
	private java.util.Date lastLoginTime;
	private java.lang.Long employeeId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.lang.Integer loginAttemptCounter;

	// many to one
	private com.ams.mufins.model.Users parent;
	
	// collections
	private java.util.Set<Role> roles;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_id"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: user_pass
	 */
	public java.lang.String getUserPass () {
		return userPass;
	}

	/**
	 * Set the value related to the column: user_pass
	 * @param userPass the user_pass value
	 */
	public void setUserPass (java.lang.String userPass) {
		this.userPass = userPass;
	}



	/**
	 * Return the value associated with the column: is_active
	 */
	public boolean isActive () {
		return active;
	}

	/**
	 * Set the value related to the column: is_active
	 * @param active the is_active value
	 */
	public void setActive (boolean active) {
		this.active = active;
	}



	/**
	 * Return the value associated with the column: is_supervisor
	 */
	public boolean isSupervisor () {
		return supervisor;
	}

	/**
	 * Set the value related to the column: is_supervisor
	 * @param supervisor the is_supervisor value
	 */
	public void setSupervisor (boolean supervisor) {
		this.supervisor = supervisor;
	}



	/**
	 * Return the value associated with the column: is_sso
	 */
	public boolean isSso () {
		return sso;
	}

	/**
	 * Set the value related to the column: is_sso
	 * @param sso the is_sso value
	 */
	public void setSso (boolean sso) {
		this.sso = sso;
	}



	/**
	 * Return the value associated with the column: user_type
	 */
	public java.lang.String getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: user_type
	 * @param userType the user_type value
	 */
	public void setUserType (java.lang.String userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: ip
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: ip
	 * @param ip the ip value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: rsa
	 */
	public java.lang.String getRsa () {
		return rsa;
	}

	/**
	 * Set the value related to the column: rsa
	 * @param rsa the rsa value
	 */
	public void setRsa (java.lang.String rsa) {
		this.rsa = rsa;
	}



	/**
	 * Return the value associated with the column: printer
	 */
	public java.lang.String getPrinter () {
		return printer;
	}

	/**
	 * Set the value related to the column: printer
	 * @param printer the printer value
	 */
	public void setPrinter (java.lang.String printer) {
		this.printer = printer;
	}



	/**
	 * Return the value associated with the column: name
	 */
	public java.lang.String getName () {
		return name;
	}

	/**
	 * Set the value related to the column: name
	 * @param name the name value
	 */
	public void setName (java.lang.String name) {
		this.name = name;
	}



	/**
	 * Return the value associated with the column: address
	 */
	public java.lang.String getAddress () {
		return address;
	}

	/**
	 * Set the value related to the column: address
	 * @param address the address value
	 */
	public void setAddress (java.lang.String address) {
		this.address = address;
	}



	/**
	 * Return the value associated with the column: city
	 */
	public java.lang.String getCity () {
		return city;
	}

	/**
	 * Set the value related to the column: city
	 * @param city the city value
	 */
	public void setCity (java.lang.String city) {
		this.city = city;
	}



	/**
	 * Return the value associated with the column: phone_number
	 */
	public java.lang.String getPhoneNumber () {
		return phoneNumber;
	}

	/**
	 * Set the value related to the column: phone_number
	 * @param phoneNumber the phone_number value
	 */
	public void setPhoneNumber (java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	/**
	 * Return the value associated with the column: handphone
	 */
	public java.lang.String getHandphone () {
		return handphone;
	}

	/**
	 * Set the value related to the column: handphone
	 * @param handphone the handphone value
	 */
	public void setHandphone (java.lang.String handphone) {
		this.handphone = handphone;
	}



	/**
	 * Return the value associated with the column: email
	 */
	public java.lang.String getEmail () {
		return email;
	}

	/**
	 * Set the value related to the column: email
	 * @param email the email value
	 */
	public void setEmail (java.lang.String email) {
		this.email = email;
	}



	/**
	 * Return the value associated with the column: organization_id
	 */
	public long getOrganizationId () {
		return organizationId;
	}

	/**
	 * Set the value related to the column: organization_id
	 * @param organizationId the organization_id value
	 */
	public void setOrganizationId (long organizationId) {
		this.organizationId = organizationId;
	}



	/**
	 * Return the value associated with the column: insurance_vendor_id
	 */
	public java.lang.Long getInsuranceVendorId () {
		return insuranceVendorId;
	}

	/**
	 * Set the value related to the column: insurance_vendor_id
	 * @param insuranceVendorId the insurance_vendor_id value
	 */
	public void setInsuranceVendorId (java.lang.Long insuranceVendorId) {
		this.insuranceVendorId = insuranceVendorId;
	}



	/**
	 * Return the value associated with the column: sales_category
	 */
	public java.lang.String getSalesCategory () {
		return salesCategory;
	}

	/**
	 * Set the value related to the column: sales_category
	 * @param salesCategory the sales_category value
	 */
	public void setSalesCategory (java.lang.String salesCategory) {
		this.salesCategory = salesCategory;
	}



	/**
	 * Return the value associated with the column: last_login_time
	 */
	public java.util.Date getLastLoginTime () {
		return lastLoginTime;
	}

	/**
	 * Set the value related to the column: last_login_time
	 * @param lastLoginTime the last_login_time value
	 */
	public void setLastLoginTime (java.util.Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}




	/**
	 * Return the value associated with the column: employee_id
	 */
	public java.lang.Long getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (java.lang.Long employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * Return the value associated with the column: create_by
	 */
	public java.lang.String getCreateBy () {
		return createBy;
	}

	/**
	 * Set the value related to the column: create_by
	 * @param createBy the create_by value
	 */
	public void setCreateBy (java.lang.String createBy) {
		this.createBy = createBy;
	}



	/**
	 * Return the value associated with the column: create_on
	 */
	public java.util.Date getCreateOn () {
		return createOn;
	}

	/**
	 * Set the value related to the column: create_on
	 * @param createOn the create_on value
	 */
	public void setCreateOn (java.util.Date createOn) {
		this.createOn = createOn;
	}



	/**
	 * Return the value associated with the column: change_by
	 */
	public java.lang.String getChangeBy () {
		return changeBy;
	}

	/**
	 * Set the value related to the column: change_by
	 * @param changeBy the change_by value
	 */
	public void setChangeBy (java.lang.String changeBy) {
		this.changeBy = changeBy;
	}



	/**
	 * Return the value associated with the column: change_on
	 */
	public java.util.Date getChangeOn () {
		return changeOn;
	}

	/**
	 * Set the value related to the column: change_on
	 * @param changeOn the change_on value
	 */
	public void setChangeOn (java.util.Date changeOn) {
		this.changeOn = changeOn;
	}

	/**
	 * Return the value associated with the column: login_attempt_counter
	 */
	public java.lang.Integer getLoginAttemptCounter () {
		return loginAttemptCounter;
	}

	/**
	 * Set the value related to the column: login_attempt_counter
	 * @param loginAttemptCounter the login_attempt_counter value
	 */
	public void setLoginAttemptCounter (java.lang.Integer loginAttemptCounter) {
		this.loginAttemptCounter = loginAttemptCounter;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public com.ams.mufins.model.Users getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parent the parent_id value
	 */
	public void setParent (com.ams.mufins.model.Users parent) {
		this.parent = parent;
	}

	/**
	 * Return the value associated with the column: Roles
	 */
	public java.util.Set<Role> getRoles () {
		return roles;
	}

	/**
	 * Set the value related to the column: Roles
	 * @param roles the Roles value
	 */
	public void setRoles (java.util.Set<Role> roles) {
		this.roles = roles;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.Users)) return false;
		else {
			com.ams.mufins.model.Users users = (com.ams.mufins.model.Users) obj;
			return (this.getId() == users.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}