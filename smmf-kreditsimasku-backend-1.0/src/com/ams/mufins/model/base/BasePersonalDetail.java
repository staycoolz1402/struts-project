package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the personal_detail table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="personal_detail"
 */

public abstract class BasePersonalDetail  implements Serializable {

	public static String REF = "PersonalDetail";
	public static String PROP_PERSONAL_ID = "PersonalId";
	public static String PROP_PHONE = "Phone";
	public static String PROP_DEVICE_ID = "DeviceId";
	public static String PROP_STATUS = "status";
	public static String PROP_SCORE_KPI_MONTH = "ScoreKpiMonth";
	public static String PROP_SCORE_KPI_DAY = "ScoreKpiDay";
	public static String PROP_REASON = "reason";
	public static String PROP_SCORE_ENGINE_ON = "ScoreEngineOn";
	public static String PROP_SCORE_ENGINE_ENTRY = "ScoreEngineEntry";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BasePersonalDetail () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalDetail (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonalDetail (
		long id,
		long personalId,
		java.lang.String deviceId) {

		this.setId(id);
		this.setPersonalId(personalId);
		this.setDeviceId(deviceId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long personalId;
	private java.lang.String phone;
	private java.lang.String deviceId;
	private java.lang.String status;
	private double scoreKpiMonth;
	private double scoreKpiDay;
	private java.lang.String reason;
	private java.util.Date scoreEngineOn;
	private java.lang.String scoreEngineEntry;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="personal_detail_id"
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
	 * Return the value associated with the column: personal_id
	 */
	public long getPersonalId () {
		return personalId;
	}

	/**
	 * Set the value related to the column: personal_id
	 * @param personalId the personal_id value
	 */
	public void setPersonalId (long personalId) {
		this.personalId = personalId;
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
	 * Return the value associated with the column: status
	 */
	public java.lang.String getStatus () {
		return status;
	}

	/**
	 * Set the value related to the column: status
	 * @param status the status value
	 */
	public void setStatus (java.lang.String status) {
		this.status = status;
	}



	/**
	 * Return the value associated with the column: score_kpi_month
	 */
	public double getScoreKpiMonth () {
		return scoreKpiMonth;
	}

	/**
	 * Set the value related to the column: score_kpi_month
	 * @param scoreKpiMonth the score_kpi_month value
	 */
	public void setScoreKpiMonth (double scoreKpiMonth) {
		this.scoreKpiMonth = scoreKpiMonth;
	}



	/**
	 * Return the value associated with the column: score_kpi_day
	 */
	public double getScoreKpiDay () {
		return scoreKpiDay;
	}

	/**
	 * Set the value related to the column: score_kpi_day
	 * @param scoreKpiDay the score_kpi_day value
	 */
	public void setScoreKpiDay (double scoreKpiDay) {
		this.scoreKpiDay = scoreKpiDay;
	}



	/**
	 * Return the value associated with the column: reason
	 */
	public java.lang.String getReason () {
		return reason;
	}

	/**
	 * Set the value related to the column: reason
	 * @param reason the reason value
	 */
	public void setReason (java.lang.String reason) {
		this.reason = reason;
	}



	/**
	 * Return the value associated with the column: score_engine_on
	 */
	public java.util.Date getScoreEngineOn () {
		return scoreEngineOn;
	}

	/**
	 * Set the value related to the column: score_engine_on
	 * @param scoreEngineOn the score_engine_on value
	 */
	public void setScoreEngineOn (java.util.Date scoreEngineOn) {
		this.scoreEngineOn = scoreEngineOn;
	}



	/**
	 * Return the value associated with the column: score_engine_entry
	 */
	public java.lang.String getScoreEngineEntry () {
		return scoreEngineEntry;
	}

	/**
	 * Set the value related to the column: score_engine_entry
	 * @param scoreEngineEntry the score_engine_entry value
	 */
	public void setScoreEngineEntry (java.lang.String scoreEngineEntry) {
		this.scoreEngineEntry = scoreEngineEntry;
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
		if (!(obj instanceof com.ams.mufins.model.PersonalDetail)) return false;
		else {
			com.ams.mufins.model.PersonalDetail personalDetail = (com.ams.mufins.model.PersonalDetail) obj;
			return (this.getId() == personalDetail.getId());
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