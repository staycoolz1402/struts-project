package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the vendor table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="vendor"
 */

public abstract class BaseVendor  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "Vendor";
	public static String PROP_VENDOR_NAME = "VendorName";
	public static String PROP_IS_ACTIVE = "IsActive";
	public static String PROP_USED_FOR = "UsedFor";
	public static String PROP_ACCESS_KEY = "AccessKey";
	public static String PROP_SECRET_KEY = "SecretKey";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseVendor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseVendor (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String vendorName;
	private java.lang.String isActive;
	private java.lang.String usedFor;
	private java.lang.String accessKey;
	private java.lang.String secretKey;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="vendor_id"
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
	 * Return the value associated with the column: vendor_name
	 */
	public java.lang.String getVendorName () {
		return vendorName;
	}

	/**
	 * Set the value related to the column: vendor_name
	 * @param vendorName the vendor_name value
	 */
	public void setVendorName (java.lang.String vendorName) {
		this.vendorName = vendorName;
	}



	/**
	 * Return the value associated with the column: is_active
	 */
	public java.lang.String getIsActive () {
		return isActive;
	}

	/**
	 * Set the value related to the column: is_active
	 * @param isActive the is_active value
	 */
	public void setIsActive (java.lang.String isActive) {
		this.isActive = isActive;
	}



	/**
	 * Return the value associated with the column: used_for
	 */
	public java.lang.String getUsedFor () {
		return usedFor;
	}

	/**
	 * Set the value related to the column: used_for
	 * @param usedFor the used_for value
	 */
	public void setUsedFor (java.lang.String usedFor) {
		this.usedFor = usedFor;
	}



	/**
	 * Return the value associated with the column: access_key
	 */
	public java.lang.String getAccessKey () {
		return accessKey;
	}

	/**
	 * Set the value related to the column: access_key
	 * @param accessKey the access_key value
	 */
	public void setAccessKey (java.lang.String accessKey) {
		this.accessKey = accessKey;
	}



	/**
	 * Return the value associated with the column: secret_key
	 */
	public java.lang.String getSecretKey () {
		return secretKey;
	}

	/**
	 * Set the value related to the column: secret_key
	 * @param secretKey the secret_key value
	 */
	public void setSecretKey (java.lang.String secretKey) {
		this.secretKey = secretKey;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.Vendor)) return false;
		else {
			com.ams.mufins.model.Vendor vendor = (com.ams.mufins.model.Vendor) obj;
			return (this.getId() == vendor.getId());
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