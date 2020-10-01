package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the customer_mobile_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="customer_mobile_history"
 */

public abstract class BaseCustomerMobileHistory  implements Serializable {

	public static String REF = "CustomerMobileHistory";
	public static String PROP_HANDPHONE = "Handphone";
	public static String PROP_RELEASE_ON = "ReleaseOn";
	public static String PROP_OLD_DEVICE_ID = "OldDeviceId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseCustomerMobileHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseCustomerMobileHistory (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String handphone;
	private java.util.Date releaseOn;
	private java.lang.String oldDeviceId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="customer_mobile_history_id"
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
	 * Return the value associated with the column: release_on
	 */
	public java.util.Date getReleaseOn () {
		return releaseOn;
	}

	/**
	 * Set the value related to the column: release_on
	 * @param releaseOn the release_on value
	 */
	public void setReleaseOn (java.util.Date releaseOn) {
		this.releaseOn = releaseOn;
	}



	/**
	 * Return the value associated with the column: old_device_id
	 */
	public java.lang.String getOldDeviceId () {
		return oldDeviceId;
	}

	/**
	 * Set the value related to the column: old_device_id
	 * @param oldDeviceId the old_device_id value
	 */
	public void setOldDeviceId (java.lang.String oldDeviceId) {
		this.oldDeviceId = oldDeviceId;
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
		if (!(obj instanceof com.ams.mufins.model.CustomerMobileHistory)) return false;
		else {
			com.ams.mufins.model.CustomerMobileHistory customerMobileHistory = (com.ams.mufins.model.CustomerMobileHistory) obj;
			return (this.getId() == customerMobileHistory.getId());
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