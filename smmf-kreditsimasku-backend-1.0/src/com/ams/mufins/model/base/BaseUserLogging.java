package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_logging table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_logging"
 */

public abstract class BaseUserLogging  implements Serializable {

	public static String REF = "UserLogging";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_IP = "Ip";
	public static String PROP_COMPUTER_NAME = "ComputerName";
	public static String PROP_HOSTNAME = "Hostname";
	public static String PROP_TRUSTED_IP = "TrustedIp";
	public static String PROP_TRUSTED_ACTION = "TrustedAction";
	public static String PROP_ACCESS_DATE = "AccessDate";
	public static String PROP_ACCESS_TIME = "AccessTime";
	public static String PROP_ACTION = "Action";
	public static String PROP_PARAMETER = "Parameter";
	public static String PROP_VIEW_ID = "ViewId";


	// constructors
	public BaseUserLogging () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserLogging (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserLogging (
		long id,
		java.lang.String userName) {

		this.setId(id);
		this.setUserName(userName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String userName;
	private java.lang.String ip;
	private java.lang.String computerName;
	private java.lang.String hostname;
	private boolean trustedIp;
	private boolean trustedAction;
	private java.util.Date accessDate;
	private java.util.Date accessTime;
	private java.lang.String action;
	private java.lang.String parameter;
	private java.lang.Long viewId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_logging_id"
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
	 * Return the value associated with the column: user_name
	 */
	public java.lang.String getUserName () {
		return userName;
	}

	/**
	 * Set the value related to the column: user_name
	 * @param userName the user_name value
	 */
	public void setUserName (java.lang.String userName) {
		this.userName = userName;
	}



	/**
	 * Return the value associated with the column: ip
	 */
	public java.lang.String getIp () {
		return ip;
	}

	/**
	 * Set the value related to the column: ip
	 * @param ip the ip value
	 */
	public void setIp (java.lang.String ip) {
		this.ip = ip;
	}



	/**
	 * Return the value associated with the column: computer_name
	 */
	public java.lang.String getComputerName () {
		return computerName;
	}

	/**
	 * Set the value related to the column: computer_name
	 * @param computerName the computer_name value
	 */
	public void setComputerName (java.lang.String computerName) {
		this.computerName = computerName;
	}



	/**
	 * Return the value associated with the column: hostname
	 */
	public java.lang.String getHostname () {
		return hostname;
	}

	/**
	 * Set the value related to the column: hostname
	 * @param hostname the hostname value
	 */
	public void setHostname (java.lang.String hostname) {
		this.hostname = hostname;
	}



	/**
	 * Return the value associated with the column: is_trusted_ip
	 */
	public boolean isTrustedIp () {
		return trustedIp;
	}

	/**
	 * Set the value related to the column: is_trusted_ip
	 * @param trustedIp the is_trusted_ip value
	 */
	public void setTrustedIp (boolean trustedIp) {
		this.trustedIp = trustedIp;
	}



	/**
	 * Return the value associated with the column: is_trusted_action
	 */
	public boolean isTrustedAction () {
		return trustedAction;
	}

	/**
	 * Set the value related to the column: is_trusted_action
	 * @param trustedAction the is_trusted_action value
	 */
	public void setTrustedAction (boolean trustedAction) {
		this.trustedAction = trustedAction;
	}



	/**
	 * Return the value associated with the column: access_date
	 */
	public java.util.Date getAccessDate () {
		return accessDate;
	}

	/**
	 * Set the value related to the column: access_date
	 * @param accessDate the access_date value
	 */
	public void setAccessDate (java.util.Date accessDate) {
		this.accessDate = accessDate;
	}



	/**
	 * Return the value associated with the column: access_time
	 */
	public java.util.Date getAccessTime () {
		return accessTime;
	}

	/**
	 * Set the value related to the column: access_time
	 * @param accessTime the access_time value
	 */
	public void setAccessTime (java.util.Date accessTime) {
		this.accessTime = accessTime;
	}



	/**
	 * Return the value associated with the column: action
	 */
	public java.lang.String getAction () {
		return action;
	}

	/**
	 * Set the value related to the column: action
	 * @param action the action value
	 */
	public void setAction (java.lang.String action) {
		this.action = action;
	}



	/**
	 * Return the value associated with the column: parameter
	 */
	public java.lang.String getParameter () {
		return parameter;
	}

	/**
	 * Set the value related to the column: parameter
	 * @param parameter the parameter value
	 */
	public void setParameter (java.lang.String parameter) {
		this.parameter = parameter;
	}



	/**
	 * Return the value associated with the column: view_id
	 */
	public java.lang.Long getViewId () {
		return viewId;
	}

	/**
	 * Set the value related to the column: view_id
	 * @param viewId the view_id value
	 */
	public void setViewId (java.lang.Long viewId) {
		this.viewId = viewId;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.UserLogging)) return false;
		else {
			com.ams.mufins.model.UserLogging userLogging = (com.ams.mufins.model.UserLogging) obj;
			return (this.getId() == userLogging.getId());
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