package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the master_setup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="master_setup"
 */

public abstract class BaseMasterSetup  implements Serializable {

	public static String REF = "MasterSetup";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_IS_PULLED_APP = "IsPulledApp";
	public static String PROP_IS_PULLED_SMS = "IsPulledSms";
	public static String PROP_IS_PULLED_ADDRESS_BOOK = "IsPulledAddressBook";
	public static String PROP_IS_PULLED_CALL_RECORD = "IsPulledCallRecord";
	public static String PROP_INTERVAL_TIME = "IntervalTime";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseMasterSetup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasterSetup (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasterSetup (
		long id,
		java.lang.Integer intervalTime) {

		this.setId(id);
		this.setIntervalTime(intervalTime);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String roleName;
	private boolean isPulledApp;
	private boolean isPulledSms;
	private boolean isPulledAddressBook;
	private boolean isPulledCallRecord;
	private java.lang.Integer intervalTime;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="master_setup_id"
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
	 * Return the value associated with the column: role_name
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: role_name
	 * @param roleName the role_name value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
	}



	/**
	 * Return the value associated with the column: is_pulled_app
	 */
	public boolean isIsPulledApp () {
		return isPulledApp;
	}

	/**
	 * Set the value related to the column: is_pulled_app
	 * @param isPulledApp the is_pulled_app value
	 */
	public void setIsPulledApp (boolean isPulledApp) {
		this.isPulledApp = isPulledApp;
	}



	/**
	 * Return the value associated with the column: is_pulled_sms
	 */
	public boolean isIsPulledSms () {
		return isPulledSms;
	}

	/**
	 * Set the value related to the column: is_pulled_sms
	 * @param isPulledSms the is_pulled_sms value
	 */
	public void setIsPulledSms (boolean isPulledSms) {
		this.isPulledSms = isPulledSms;
	}



	/**
	 * Return the value associated with the column: is_pulled_address_book
	 */
	public boolean isIsPulledAddressBook () {
		return isPulledAddressBook;
	}

	/**
	 * Set the value related to the column: is_pulled_address_book
	 * @param isPulledAddressBook the is_pulled_address_book value
	 */
	public void setIsPulledAddressBook (boolean isPulledAddressBook) {
		this.isPulledAddressBook = isPulledAddressBook;
	}



	/**
	 * Return the value associated with the column: is_pulled_call_record
	 */
	public boolean isIsPulledCallRecord () {
		return isPulledCallRecord;
	}

	/**
	 * Set the value related to the column: is_pulled_call_record
	 * @param isPulledCallRecord the is_pulled_call_record value
	 */
	public void setIsPulledCallRecord (boolean isPulledCallRecord) {
		this.isPulledCallRecord = isPulledCallRecord;
	}



	/**
	 * Return the value associated with the column: interval_time
	 */
	public java.lang.Integer getIntervalTime () {
		return intervalTime;
	}

	/**
	 * Set the value related to the column: interval_time
	 * @param intervalTime the interval_time value
	 */
	public void setIntervalTime (java.lang.Integer intervalTime) {
		this.intervalTime = intervalTime;
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
		if (!(obj instanceof com.ams.mufins.model.MasterSetup)) return false;
		else {
			com.ams.mufins.model.MasterSetup masterSetup = (com.ams.mufins.model.MasterSetup) obj;
			return (this.getId() == masterSetup.getId());
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