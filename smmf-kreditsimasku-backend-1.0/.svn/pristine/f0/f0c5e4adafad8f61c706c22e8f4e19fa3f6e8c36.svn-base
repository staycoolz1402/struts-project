package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the personal table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="personal"
 */

public abstract class BasePersonal  implements Serializable {

	public static String REF = "Personal";
	public static String PROP_NAME = "Name";
	public static String PROP_USER_ID = "UserId";
	public static String PROP_ID_NUMBER = "IdNumber";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_EMPLOYEE_ID = "EmployeeId";
	public static String PROP_EMPLOYEE_NIK = "EmployeeNik";
	public static String PROP_MASTER_SETUP_ID = "MasterSetupId";
	public static String PROP_STATUS = "Status";
	public static String PROP_LAST_SYNC_ON = "LastSyncOn";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BasePersonal () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonal (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonal (
		long id,
		java.lang.String name,
		long userId,
		long employeeId,
		long masterSetupId,
		java.lang.String status) {

		this.setId(id);
		this.setName(name);
		this.setUserId(userId);
		this.setEmployeeId(employeeId);
		this.setMasterSetupId(masterSetupId);
		this.setStatus(status);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String name;
	private long userId;
	private java.lang.String idNumber;
	private java.lang.String roleName;
	private long employeeId;
	private java.lang.String employeeNik;
	private long masterSetupId;
	private java.lang.String status;
	private java.util.Date lastSyncOn;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="personal_id"
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

	public java.lang.String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(java.lang.String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * Return the value associated with the column: role_name
	 */
	public java.lang.String getRoleName () {
		return roleName;
	}

	/**
	 * Set the value related to the column: role_name
	 * @param roleName the role_name value
	 */
	public void setRoleName (java.lang.String roleName) {
		this.roleName = roleName;
	}



	/**
	 * Return the value associated with the column: employee_id
	 */
	public long getEmployeeId () {
		return employeeId;
	}

	/**
	 * Set the value related to the column: employee_id
	 * @param employeeId the employee_id value
	 */
	public void setEmployeeId (long employeeId) {
		this.employeeId = employeeId;
	}



	/**
	 * Return the value associated with the column: employee_nik
	 */
	public java.lang.String getEmployeeNik () {
		return employeeNik;
	}

	/**
	 * Set the value related to the column: employee_nik
	 * @param employeeNik the employee_nik value
	 */
	public void setEmployeeNik (java.lang.String employeeNik) {
		this.employeeNik = employeeNik;
	}



	/**
	 * Return the value associated with the column: master_setup_id
	 */
	public long getMasterSetupId () {
		return masterSetupId;
	}

	/**
	 * Set the value related to the column: master_setup_id
	 * @param masterSetupId the master_setup_id value
	 */
	public void setMasterSetupId (long masterSetupId) {
		this.masterSetupId = masterSetupId;
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
	 * Return the value associated with the column: last_sync_on
	 */
	public java.util.Date getLastSyncOn () {
		return lastSyncOn;
	}

	/**
	 * Set the value related to the column: last_sync_on
	 * @param lastSyncOn the last_sync_on value
	 */
	public void setLastSyncOn (java.util.Date lastSyncOn) {
		this.lastSyncOn = lastSyncOn;
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
		if (!(obj instanceof com.ams.mufins.model.Personal)) return false;
		else {
			com.ams.mufins.model.Personal personal = (com.ams.mufins.model.Personal) obj;
			return (this.getId() == personal.getId());
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