package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_detail"
 */

public abstract class BaseUserDetail  implements Serializable {

	public static String REF = "UserDetail";
	public static String PROP_BIRTH_DATE = "BirthDate";
	public static String PROP_JOIN_DATE = "JoinDate";
	public static String PROP_BANK_NAME = "BankName";
	public static String PROP_ACCOUNT_NUMBER = "AccountNumber";
	public static String PROP_ACCOUNT_NAME = "AccountName";
	public static String PROP_TELEPHONE1 = "Telephone1";
	public static String PROP_TELEPHONE2 = "Telephone2";
	public static String PROP_MOBILE1 = "Mobile1";
	public static String PROP_MOBILE2 = "Mobile2";
	public static String PROP_ADDRESS1 = "Address1";
	public static String PROP_CITY = "City";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_ID_CARD_NUMBER = "IdCardNumber";
	public static String PROP_BIRTH_PLACE = "BirthPlace";
	public static String PROP_MOTHER_MAIDEN_NAME = "MotherMaidenName";
	public static String PROP_GENDER = "Gender";
	public static String PROP_ID_EXPIRY_DATE = "IdExpiryDate";
	public static String PROP_OPEN_ON = "OpenOn";


	// constructors
	public BaseUserDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserDetail (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserDetail (
		long id,
		com.ams.mufins.model.Users users) {

		this.setId(id);
		this.setUsers(users);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.util.Date birthDate;
	private java.util.Date joinDate;
	private java.lang.String bankName;
	private java.lang.String accountNumber;
	private java.lang.String accountName;
	private java.lang.String telephone1;
	private java.lang.String telephone2;
	private java.lang.String mobile1;
	private java.lang.String mobile2;
	private java.lang.String address1;
	private java.lang.String city;
	private java.lang.String postalCode;
	private java.lang.String idCardNumber;
	private java.lang.String birthPlace;
	private java.lang.String motherMaidenName;
	private java.lang.String gender;
	private java.util.Date idExpiryDate;
	private java.util.Date openOn;

	// many to one
	private com.ams.mufins.model.Users users;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_detail_id"
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
	 * Return the value associated with the column: birth_date
	 */
	public java.util.Date getBirthDate () {
		return birthDate;
	}

	/**
	 * Set the value related to the column: birth_date
	 * @param birthDate the birth_date value
	 */
	public void setBirthDate (java.util.Date birthDate) {
		this.birthDate = birthDate;
	}



	/**
	 * Return the value associated with the column: join_date
	 */
	public java.util.Date getJoinDate () {
		return joinDate;
	}

	/**
	 * Set the value related to the column: join_date
	 * @param joinDate the join_date value
	 */
	public void setJoinDate (java.util.Date joinDate) {
		this.joinDate = joinDate;
	}



	/**
	 * Return the value associated with the column: bank_name
	 */
	public java.lang.String getBankName () {
		return bankName;
	}

	/**
	 * Set the value related to the column: bank_name
	 * @param bankName the bank_name value
	 */
	public void setBankName (java.lang.String bankName) {
		this.bankName = bankName;
	}



	/**
	 * Return the value associated with the column: account_number
	 */
	public java.lang.String getAccountNumber () {
		return accountNumber;
	}

	/**
	 * Set the value related to the column: account_number
	 * @param accountNumber the account_number value
	 */
	public void setAccountNumber (java.lang.String accountNumber) {
		this.accountNumber = accountNumber;
	}



	/**
	 * Return the value associated with the column: account_name
	 */
	public java.lang.String getAccountName () {
		return accountName;
	}

	/**
	 * Set the value related to the column: account_name
	 * @param accountName the account_name value
	 */
	public void setAccountName (java.lang.String accountName) {
		this.accountName = accountName;
	}



	


	/**
	 * Return the value associated with the column: telephone1
	 */
	public java.lang.String getTelephone1 () {
		return telephone1;
	}

	/**
	 * Set the value related to the column: telephone1
	 * @param telephone1 the telephone1 value
	 */
	public void setTelephone1 (java.lang.String telephone1) {
		this.telephone1 = telephone1;
	}



	/**
	 * Return the value associated with the column: telephone2
	 */
	public java.lang.String getTelephone2 () {
		return telephone2;
	}

	/**
	 * Set the value related to the column: telephone2
	 * @param telephone2 the telephone2 value
	 */
	public void setTelephone2 (java.lang.String telephone2) {
		this.telephone2 = telephone2;
	}



	/**
	 * Return the value associated with the column: mobile1
	 */
	public java.lang.String getMobile1 () {
		return mobile1;
	}

	/**
	 * Set the value related to the column: mobile1
	 * @param mobile1 the mobile1 value
	 */
	public void setMobile1 (java.lang.String mobile1) {
		this.mobile1 = mobile1;
	}



	/**
	 * Return the value associated with the column: mobile2
	 */
	public java.lang.String getMobile2 () {
		return mobile2;
	}

	/**
	 * Set the value related to the column: mobile2
	 * @param mobile2 the mobile2 value
	 */
	public void setMobile2 (java.lang.String mobile2) {
		this.mobile2 = mobile2;
	}



	/**
	 * Return the value associated with the column: address1
	 */
	public java.lang.String getAddress1 () {
		return address1;
	}

	/**
	 * Set the value related to the column: address1
	 * @param address1 the address1 value
	 */
	public void setAddress1 (java.lang.String address1) {
		this.address1 = address1;
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
	 * Return the value associated with the column: postal_code
	 */
	public java.lang.String getPostalCode () {
		return postalCode;
	}

	/**
	 * Set the value related to the column: postal_code
	 * @param postalCode the postal_code value
	 */
	public void setPostalCode (java.lang.String postalCode) {
		this.postalCode = postalCode;
	}



	/**
	 * Return the value associated with the column: idcard_number
	 */
	public java.lang.String getIdCardNumber () {
		return idCardNumber;
	}

	/**
	 * Set the value related to the column: idcard_number
	 * @param idCardNumber the idcard_number value
	 */
	public void setIdCardNumber (java.lang.String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}



	/**
	 * Return the value associated with the column: birth_place
	 */
	public java.lang.String getBirthPlace () {
		return birthPlace;
	}

	/**
	 * Set the value related to the column: birth_place
	 * @param birthPlace the birth_place value
	 */
	public void setBirthPlace (java.lang.String birthPlace) {
		this.birthPlace = birthPlace;
	}



	/**
	 * Return the value associated with the column: mother_maiden_name
	 */
	public java.lang.String getMotherMaidenName () {
		return motherMaidenName;
	}

	/**
	 * Set the value related to the column: mother_maiden_name
	 * @param motherMaidenName the mother_maiden_name value
	 */
	public void setMotherMaidenName (java.lang.String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}



	/**
	 * Return the value associated with the column: gender
	 */
	public java.lang.String getGender () {
		return gender;
	}

	/**
	 * Set the value related to the column: gender
	 * @param gender the gender value
	 */
	public void setGender (java.lang.String gender) {
		this.gender = gender;
	}



	/**
	 * Return the value associated with the column: Id_expiry_date
	 */
	public java.util.Date getIdExpiryDate () {
		return idExpiryDate;
	}

	/**
	 * Set the value related to the column: Id_expiry_date
	 * @param idExpiryDate the Id_expiry_date value
	 */
	public void setIdExpiryDate (java.util.Date idExpiryDate) {
		this.idExpiryDate = idExpiryDate;
	}



	/**
	 * Return the value associated with the column: open_on
	 */
	public java.util.Date getOpenOn () {
		return openOn;
	}

	/**
	 * Set the value related to the column: open_on
	 * @param openOn the open_on value
	 */
	public void setOpenOn (java.util.Date openOn) {
		this.openOn = openOn;
	}



	/**
	 * Return the value associated with the column: user_id
	 */
	public com.ams.mufins.model.Users getUsers () {
		return users;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param users the user_id value
	 */
	public void setUsers (com.ams.mufins.model.Users users) {
		this.users = users;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.UserDetail)) return false;
		else {
			com.ams.mufins.model.UserDetail userDetail = (com.ams.mufins.model.UserDetail) obj;
			return (this.getId() == userDetail.getId());
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