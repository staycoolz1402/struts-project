package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the organization table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="organization"
 */

public abstract class BaseOrganization  implements Serializable {

	public static String REF = "Organization";
	public static String PROP_NAME = "Name";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_CITY = "City";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_PROVINCE = "Province";
	public static String PROP_TELEPHONE = "Telephone";
	public static String PROP_EMAIL = "Email";
	public static String PROP_URL = "Url";
	public static String PROP_NPWP = "Npwp";
	public static String PROP_NPWP_DATE = "NpwpDate";

	// constructors
	public BaseOrganization () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseOrganization (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseOrganization (
		long id,
		java.lang.String name) {

		this.setId(id);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String city;
	private java.lang.String postalCode;
	private java.lang.String province;
	private java.lang.String telephone;
	private java.lang.String email;
	private java.lang.String url;
	private java.lang.String npwp;
	private java.util.Date npwpDate;


	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="organization_id"
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
	 * Return the value associated with the column: province
	 */
	public java.lang.String getProvince () {
		return province;
	}

	/**
	 * Set the value related to the column: province
	 * @param province the province value
	 */
	public void setProvince (java.lang.String province) {
		this.province = province;
	}



	/**
	 * Return the value associated with the column: telephone
	 */
	public java.lang.String getTelephone () {
		return telephone;
	}

	/**
	 * Set the value related to the column: telephone
	 * @param telephone the telephone value
	 */
	public void setTelephone (java.lang.String telephone) {
		this.telephone = telephone;
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
	 * Return the value associated with the column: url
	 */
	public java.lang.String getUrl () {
		return url;
	}

	/**
	 * Set the value related to the column: url
	 * @param url the url value
	 */
	public void setUrl (java.lang.String url) {
		this.url = url;
	}



	/**
	 * Return the value associated with the column: npwp
	 */
	public java.lang.String getNpwp () {
		return npwp;
	}

	/**
	 * Set the value related to the column: npwp
	 * @param npwp the npwp value
	 */
	public void setNpwp (java.lang.String npwp) {
		this.npwp = npwp;
	}



	/**
	 * Return the value associated with the column: npwp_date
	 */
	public java.util.Date getNpwpDate () {
		return npwpDate;
	}

	/**
	 * Set the value related to the column: npwp_date
	 * @param npwpDate the npwp_date value
	 */
	public void setNpwpDate (java.util.Date npwpDate) {
		this.npwpDate = npwpDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.Organization)) return false;
		else {
			com.ams.mufins.model.Organization organization = (com.ams.mufins.model.Organization) obj;
			return (this.getId() == organization.getId());
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