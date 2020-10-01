package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the users_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="users_history"
 */

public abstract class BaseUsersHistory  implements Serializable {

	public static String REF = "UsersHistory";
	public static String PROP_USER_NAME = "UserName";
	public static String PROP_NAME = "Name";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_ROLE_ID = "RoleId";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_USER_EMPLOYEE_LOG_ID = "UserEmployeeLogId";


	// constructors
	public BaseUsersHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUsersHistory (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUsersHistory (
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
	private java.lang.String name;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private boolean active;
	private long roleId;
	private long userId;
	private java.lang.Long userEmployeeLogId;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_history_id"
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
	 * Return the value associated with the column: is_active
	 */
	public boolean isActive () {
		return active;
	}

	/**
	 * Set the value related to the column: is_active
	 * @param active the is_active value
	 */
	public void setActive (boolean active) {
		this.active = active;
	}



	
	/**
	 * Return the value associated with the column: role_id
	 */
	public long getRoleId () {
		return roleId;
	}

	/**
	 * Set the value related to the column: role_id
	 * @param roleId the role_id value
	 */
	public void setRoleId (long roleId) {
		this.roleId = roleId;
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
	 * Return the value associated with the column: user_employee_log_id
	 */
	public java.lang.Long getUserEmployeeLogId () {
		return userEmployeeLogId;
	}

	/**
	 * Set the value related to the column: user_employee_log_id
	 * @param userEmployeeLogId the user_employee_log_id value
	 */
	public void setUserEmployeeLogId (java.lang.Long userEmployeeLogId) {
		this.userEmployeeLogId = userEmployeeLogId;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.UsersHistory)) return false;
		else {
			com.ams.mufins.model.UsersHistory usersHistory = (com.ams.mufins.model.UsersHistory) obj;
			return (this.getId() == usersHistory.getId());
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