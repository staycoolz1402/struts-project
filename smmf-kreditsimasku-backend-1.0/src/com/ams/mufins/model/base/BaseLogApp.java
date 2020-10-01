package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the log_app table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="log_app"
 */

public abstract class BaseLogApp  implements Serializable {

	public static String REF = "LogApp";
	public static String PROP_APP_NAME = "AppName";
	public static String PROP_APP_PACKAGE_NAME = "AppPackageName";
	public static String PROP_CREATE_TIME = "CreateTime";
	public static String PROP_FIRST_INSTALL_TIME = "FirstInstallTime";
	public static String PROP_LAST_UPDATE_TIME = "LastUpdateTime";
	public static String PROP_PERSONAL_DETAIL_ID = "PersonalDetailId";
	public static String PROP_VERSION_NAME = "VersionName";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseLogApp () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLogApp (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLogApp (
		long id,
		long personalDetailId) {

		this.setId(id);
		this.setPersonalDetailId(personalDetailId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String appName;
	private java.lang.String appPackageName;
	private java.util.Date createTime;
	private java.util.Date firstInstallTime;
	private java.util.Date lastUpdateTime;
	private long personalDetailId;
	private java.lang.String versionName;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="log_app_id"
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
	 * Return the value associated with the column: app_name
	 */
	public java.lang.String getAppName () {
		return appName;
	}

	/**
	 * Set the value related to the column: app_name
	 * @param appName the app_name value
	 */
	public void setAppName (java.lang.String appName) {
		this.appName = appName;
	}



	/**
	 * Return the value associated with the column: app_package_name
	 */
	public java.lang.String getAppPackageName () {
		return appPackageName;
	}

	/**
	 * Set the value related to the column: app_package_name
	 * @param appPackageName the app_package_name value
	 */
	public void setAppPackageName (java.lang.String appPackageName) {
		this.appPackageName = appPackageName;
	}



	/**
	 * Return the value associated with the column: create_time
	 */
	public java.util.Date getCreateTime () {
		return createTime;
	}

	/**
	 * Set the value related to the column: create_time
	 * @param createTime the create_time value
	 */
	public void setCreateTime (java.util.Date createTime) {
		this.createTime = createTime;
	}



	/**
	 * Return the value associated with the column: first_install_time
	 */
	public java.util.Date getFirstInstallTime () {
		return firstInstallTime;
	}

	/**
	 * Set the value related to the column: first_install_time
	 * @param firstInstallTime the first_install_time value
	 */
	public void setFirstInstallTime (java.util.Date firstInstallTime) {
		this.firstInstallTime = firstInstallTime;
	}



	/**
	 * Return the value associated with the column: last_update_time
	 */
	public java.util.Date getLastUpdateTime () {
		return lastUpdateTime;
	}

	/**
	 * Set the value related to the column: last_update_time
	 * @param lastUpdateTime the last_update_time value
	 */
	public void setLastUpdateTime (java.util.Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public java.lang.String getVersionName() {
		return versionName;
	}

	public void setVersionName(java.lang.String versionName) {
		this.versionName = versionName;
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
		if (!(obj instanceof com.ams.mufins.model.LogApp)) return false;
		else {
			com.ams.mufins.model.LogApp logApp = (com.ams.mufins.model.LogApp) obj;
			return (this.getId() == logApp.getId());
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