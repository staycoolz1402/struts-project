package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_login table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_login"
 */

public abstract class BaseUserLogin  implements Serializable {

	public static String REF = "UserLogin";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_USER_TYPE = "UserType";
	public static String PROP_LOGIN_TIME = "LoginTime";
	public static String PROP_IP = "Ip";
	public static String PROP_SERVER = "Server";
	public static String PROP_BROWSER = "Browser";


	// constructors
	public BaseUserLogin () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserLogin (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserLogin (
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
	private long userId;
	private java.lang.String userName;
	private java.lang.String userType;
	private java.util.Date loginTime;
	private java.lang.String ip;
	private java.lang.String server;
	private java.lang.String browser;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_login_id"
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
	 * Return the value associated with the column: user_id
	 */
	public long getUserId () {
		return userId;
	}

	/**
	 * Set the value related to the column: user_id
	 * @param userId the user_id value
	 */
	public void setUserId (long userId) {
		this.userId = userId;
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
	 * Return the value associated with the column: user_type
	 */
	public java.lang.String getUserType () {
		return userType;
	}

	/**
	 * Set the value related to the column: user_type
	 * @param userType the user_type value
	 */
	public void setUserType (java.lang.String userType) {
		this.userType = userType;
	}



	/**
	 * Return the value associated with the column: login_time
	 */
	public java.util.Date getLoginTime () {
		return loginTime;
	}

	/**
	 * Set the value related to the column: login_time
	 * @param loginTime the login_time value
	 */
	public void setLoginTime (java.util.Date loginTime) {
		this.loginTime = loginTime;
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
	 * Return the value associated with the column: server
	 */
	public java.lang.String getServer () {
		return server;
	}

	/**
	 * Set the value related to the column: server
	 * @param server the server value
	 */
	public void setServer (java.lang.String server) {
		this.server = server;
	}



	/**
	 * Return the value associated with the column: browser
	 */
	public java.lang.String getBrowser () {
		return browser;
	}

	/**
	 * Set the value related to the column: browser
	 * @param browser the browser value
	 */
	public void setBrowser (java.lang.String browser) {
		this.browser = browser;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.UserLogin)) return false;
		else {
			com.ams.mufins.model.UserLogin userLogin = (com.ams.mufins.model.UserLogin) obj;
			return (this.getId() == userLogin.getId());
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