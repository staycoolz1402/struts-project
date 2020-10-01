package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customer_mobile table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customer_mobile"
 */

public abstract class BaseCustomerMobile  implements Serializable {

	public static String REF = "CustomerMobile";
	public static String PROP_HANDPHONE = "Handphone";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_DEVICE_ID = "DeviceId";
	public static String PROP_PASSWORD = "Password";
	public static String PROP_OPERATING_SYSTEM = "OperatingSystem";
	public static String PROP_COMPLETED_LONG_CIF = "CompletedLongCif";
	public static String PROP_ID_NUMBER = "IdNumber";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseCustomerMobile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerMobile (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String handphone;
	private java.lang.String fullName;
	private java.lang.String deviceId;
	private java.lang.String password;
	private int operatingSystem;
	private boolean completedLongCif;
	private java.lang.String idNumber;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="customer_mobile_id"
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
	 * Return the value associated with the column: full_name
	 */
	public java.lang.String getFullName () {
		return fullName;
	}

	/**
	 * Set the value related to the column: full_name
	 * @param fullName the full_name value
	 */
	public void setFullName (java.lang.String fullName) {
		this.fullName = fullName;
	}



	/**
	 * Return the value associated with the column: device_id
	 */
	public java.lang.String getDeviceId () {
		return deviceId;
	}

	/**
	 * Set the value related to the column: device_id
	 * @param deviceId the device_id value
	 */
	public void setDeviceId (java.lang.String deviceId) {
		this.deviceId = deviceId;
	}



	/**
	 * Return the value associated with the column: password
	 */
	public java.lang.String getPassword () {
		return password;
	}

	/**
	 * Set the value related to the column: password
	 * @param password the password value
	 */
	public void setPassword (java.lang.String password) {
		this.password = password;
	}


	/**
	 * Return the value associated with the column: operating_system
	 */
	public int getOperatingSystem () {
		return operatingSystem;
	}

	/**
	 * Set the value related to the column: operating_system
	 * @param operatingSystem the operating_system value
	 */
	public void setOperatingSystem (int operatingSystem) {
		this.operatingSystem = operatingSystem;
	}



	/**
	 * @return the isCompletedLongCif
	 */
	public boolean isCompletedLongCif() {
		return completedLongCif;
	}

	/**
	 * @param isCompletedLongCif the isCompletedLongCif to set
	 */
	public void setCompletedLongCif(boolean completedLongCif) {
		this.completedLongCif = completedLongCif;
	}
	
	/**
	 * @return the idNumber
	 */
	public java.lang.String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(java.lang.String idNumber) {
		this.idNumber = idNumber;
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
		if (!(obj instanceof com.ams.mufins.model.CustomerMobile)) return false;
		else {
			com.ams.mufins.model.CustomerMobile customerMobile = (com.ams.mufins.model.CustomerMobile) obj;
			return (this.getId() == customerMobile.getId());
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