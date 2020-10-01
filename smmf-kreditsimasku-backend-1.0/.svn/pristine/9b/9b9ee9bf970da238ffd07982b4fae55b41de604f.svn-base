package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the user_password_history table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="user_password_history"
 */

public abstract class BaseUserPasswordHistory  implements Serializable {

	public static String REF = "UserPasswordHistory";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_OLD_USER_PASS = "OldUserPass";
	public static String PROP_USER_PASS_CHANGE_DATE = "UserPassChangeDate";


	// constructors
	public BaseUserPasswordHistory () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseUserPasswordHistory (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseUserPasswordHistory (
		long id,
		long userId,
		java.lang.String oldUserPass,
		java.util.Date userPassChangeDate) {

		this.setId(id);
		this.setUserId(userId);
		this.setOldUserPass(oldUserPass);
		this.setUserPassChangeDate(userPassChangeDate);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long userId;
	private java.lang.String oldUserPass;
	private java.util.Date userPassChangeDate;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="user_password_history_id"
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
	 * Return the value associated with the column: old_user_pass
	 */
	public java.lang.String getOldUserPass () {
		return oldUserPass;
	}

	/**
	 * Set the value related to the column: old_user_pass
	 * @param oldUserPass the old_user_pass value
	 */
	public void setOldUserPass (java.lang.String oldUserPass) {
		this.oldUserPass = oldUserPass;
	}



	/**
	 * Return the value associated with the column: user_pass_change_date
	 */
	public java.util.Date getUserPassChangeDate () {
		return userPassChangeDate;
	}

	/**
	 * Set the value related to the column: user_pass_change_date
	 * @param userPassChangeDate the user_pass_change_date value
	 */
	public void setUserPassChangeDate (java.util.Date userPassChangeDate) {
		this.userPassChangeDate = userPassChangeDate;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.UserPasswordHistory)) return false;
		else {
			com.ams.mufins.model.UserPasswordHistory userPasswordHistory = (com.ams.mufins.model.UserPasswordHistory) obj;
			return (this.getId() == userPasswordHistory.getId());
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