package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the branch table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="branch"
 */

public abstract class BaseMasterVersioning  implements Serializable {

	public static String REF = "MasterVersioning";
	public static String PROP_MASTER_VERSION_NAME = "MasterVersionName";
	public static String PROP_MASTER_VERSION_APP = "MasterVersionApp";
	public static String PROP_VERSION = "Version";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";

	// constructors
	public BaseMasterVersioning () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasterVersioning (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	
	private java.lang.String masterVersionName;
	private java.lang.String masterVersionApp;
	private java.lang.Integer version;
	private java.lang.String createBy;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.util.Date createOn;

	
	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.lang.String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(java.lang.String changeBy) {
		this.changeBy = changeBy;
	}

	

	public void setChangeOn(java.util.Date changeOn) {
		this.changeOn = changeOn;
	}

	public java.util.Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(java.util.Date createOn) {
		this.createOn = createOn;
	}
	
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getMasterVersionName() {
		return masterVersionName;
	}

	public void setMasterVersionName(java.lang.String masterVersionName) {
		this.masterVersionName = masterVersionName;
	}

	public java.lang.String getMasterVersionApp() {
		return masterVersionApp;
	}

	public void setMasterVersionApp(java.lang.String masterVersionApp) {
		this.masterVersionApp = masterVersionApp;
	}

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
	}
	
	

	public java.util.Date getChangeOn() {
		return changeOn;
	}

	/**
	 * Return the value associated with the column: code
	 */
	

	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.MasterVersioning)) return false;
		else {
			com.ams.mufins.model.MasterVersioning masterVersioning = (com.ams.mufins.model.MasterVersioning) obj;
			return (this.getId() == masterVersioning.getId());
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