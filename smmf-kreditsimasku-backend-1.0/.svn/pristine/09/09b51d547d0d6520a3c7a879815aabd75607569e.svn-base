package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the log_sms table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="log_sms"
 */

public abstract class BaseLogSms  implements Serializable {

	public static String REF = "LogSms";
	public static String PROP_PERSONAL_DETAIL_ID = "PersonalDetailId"; 
	public static String PROP_NAME = "Name";
	public static String PROP_PHONE = "Phone";
	public static String PROP_CONTENT = "Content";
	public static String PROP_TIME = "Time";
	public static String PROP_TYPE_ID = "TypeId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseLogSms () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLogSms (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLogSms (
		long id,
		long personalDetailId,
		long typeId) {

		this.setId(id);
		this.setPersonalDetailId(personalDetailId);
		this.setTypeId(typeId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long personalDetailId;
	private java.lang.String name;
	private java.lang.String phone;
	private java.lang.String content;
	private java.util.Date time;
	private long typeId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;


	public long getPersonalDetailId() {
		return personalDetailId;
	}

	public void setPersonalDetailId(long personalDetailId) {
		this.personalDetailId = personalDetailId;
	}

	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="log_sms_id"
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
	 * Return the value associated with the column: phone
	 */
	public java.lang.String getPhone () {
		return phone;
	}

	/**
	 * Set the value related to the column: phone
	 * @param phone the phone value
	 */
	public void setPhone (java.lang.String phone) {
		this.phone = phone;
	}



	/**
	 * Return the value associated with the column: content
	 */
	public java.lang.String getContent () {
		return content;
	}

	/**
	 * Set the value related to the column: content
	 * @param content the content value
	 */
	public void setContent (java.lang.String content) {
		this.content = content;
	}



	/**
	 * Return the value associated with the column: time
	 */
	public java.util.Date getTime () {
		return time;
	}

	/**
	 * Set the value related to the column: time
	 * @param time the time value
	 */
	public void setTime (java.util.Date time) {
		this.time = time;
	}



	/**
	 * Return the value associated with the column: type_id
	 */
	public long getTypeId () {
		return typeId;
	}

	/**
	 * Set the value related to the column: type_id
	 * @param typeId the type_id value
	 */
	public void setTypeId (long typeId) {
		this.typeId = typeId;
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
		if (!(obj instanceof com.ams.mufins.model.LogSms)) return false;
		else {
			com.ams.mufins.model.LogSms logSms = (com.ams.mufins.model.LogSms) obj;
			return (this.getId() == logSms.getId());
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