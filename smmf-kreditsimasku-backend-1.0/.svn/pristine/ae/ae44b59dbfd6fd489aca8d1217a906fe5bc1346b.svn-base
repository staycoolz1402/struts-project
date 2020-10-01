package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the personal_blacklist table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="personal_blacklist"
 */

public abstract class BasePersonalBlacklist  implements Serializable {

	public static String REF = "PersonalBlacklist";
	public static String PROP_PERSONAL_DETAIL_ID = "PersonalDetailId";
	public static String PROP_PERSONAL_ID = "PersonalId";
	public static String PROP_IS_BLACKLIST = "IsBlacklist";
	public static String PROP_STATUS = "status";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BasePersonalBlacklist () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalBlacklist (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonalBlacklist (
		long id,
		long personalDetailId,
		long personalId,
		boolean isBlacklist) {

		this.setId(id);
		this.setPersonalDetailId(personalDetailId);
		this.setPersonalId(personalId);
		this.setIsBlacklist(isBlacklist);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long personalDetailId;
	private long personalId;
	private boolean isBlacklist;
	private java.lang.String status;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="personal_blacklist_id"
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
	 * Return the value associated with the column: is_black_list
	 */
	public boolean isIsBlacklist () {
		return isBlacklist;
	}

	/**
	 * Set the value related to the column: is_black_list
	 * @param isBlacklist the is_black_list value
	 */
	public void setIsBlacklist (boolean isBlacklist) {
		this.isBlacklist = isBlacklist;
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
		if (!(obj instanceof com.ams.mufins.model.PersonalBlacklist)) return false;
		else {
			com.ams.mufins.model.PersonalBlacklist personalBlacklist = (com.ams.mufins.model.PersonalBlacklist) obj;
			return (this.getId() == personalBlacklist.getId());
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