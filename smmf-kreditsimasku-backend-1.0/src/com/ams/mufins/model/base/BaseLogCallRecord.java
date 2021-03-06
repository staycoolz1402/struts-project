package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the log_call_record table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="log_call_record"
 */

public abstract class BaseLogCallRecord  implements Serializable {

	public static String REF = "LogCallRecord";
	public static String PROP_CALL_TIME = "CallTime";
	public static String PROP_DURATION = "Duration";
	public static String PROP_NAME = "Name";
	public static String PROP_PHONE = "Phone";
	public static String PROP_TYPE_ID = "TypeId";
	public static String PROP_PERSONAL_DETAIL_ID = "PersonalDetailId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseLogCallRecord () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLogCallRecord (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLogCallRecord (
		long id,
		long typeId,
		long personalDetailId) {

		this.setId(id);
		this.setTypeId(typeId);
		this.setPersonalDetailId(personalDetailId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.util.Date callTime;
	private java.lang.Integer duration;
	private java.lang.String name;
	private java.lang.String phone;
	private long typeId;
	private long personalDetailId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="log_call_record_id"
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
	 * Return the value associated with the column: call_time
	 */
	public java.util.Date getCallTime () {
		return callTime;
	}

	/**
	 * Set the value related to the column: call_time
	 * @param callTime the call_time value
	 */
	public void setCallTime (java.util.Date callTime) {
		this.callTime = callTime;
	}



	/**
	 * Return the value associated with the column: duration
	 */
	public Integer getDuration () {
		return duration;
	}

	/**
	 * Set the value related to the column: duration
	 * @param duration the duration value
	 */
	public void setDuration (Integer duration) {
		this.duration = duration;
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
	 * Return the value associated with the column: personal_detail_id
	 */
	public long getPersonalDetailId () {
		return personalDetailId;
	}

	/**
	 * Set the value related to the column: personal_detail_id
	 * @param personalDetailId the personal_detail_id value
	 */
	public void setPersonalDetailId (long personalDetailId) {
		this.personalDetailId = personalDetailId;
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
		if (!(obj instanceof com.ams.mufins.model.LogCallRecord)) return false;
		else {
			com.ams.mufins.model.LogCallRecord logCallRecord = (com.ams.mufins.model.LogCallRecord) obj;
			return (this.getId() == logCallRecord.getId());
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