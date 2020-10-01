package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the role table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="role"
 */

public abstract class BaseRole  implements Serializable {

	public static String REF = "Role";
	public static String PROP_ROLE_NAME = "RoleName";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_DEFAULT_USER_PASS_DURATION = "defaultUserPassDuration";
	public static String PROP_NUMERIC = "Numeric";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseRole () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseRole (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseRole (
		long id,
		java.lang.String roleName) {

		this.setId(id);
		this.setRoleName(roleName);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String roleName;
	private java.lang.String description;
	private int defaultUserPassDuration;
	private boolean numeric;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;

	// collections
	private java.util.Set parent;
	private java.util.Set roleGroups;
	private java.util.List views;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="role_id"
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
	 * Return the value associated with the column: description
	 */
	public java.lang.String getDescription () {
		return description;
	}

	/**
	 * Set the value related to the column: description
	 * @param description the description value
	 */
	public void setDescription (java.lang.String description) {
		this.description = description;
	}



	/**
	 * Return the value associated with the column: default_user_pass_duration
	 */
	public int getDefaultUserPassDuration () {
		return defaultUserPassDuration;
	}

	/**
	 * Set the value related to the column: default_user_pass_duration
	 * @param defaultUserPassDuration the default_user_pass_duration value
	 */
	public void setDefaultUserPassDuration (int defaultUserPassDuration) {
		this.defaultUserPassDuration = defaultUserPassDuration;
	}



	/**
	 * Return the value associated with the column: is_numeric
	 */
	public boolean isNumeric () {
		return numeric;
	}

	/**
	 * Set the value related to the column: is_numeric
	 * @param numeric the is_numeric value
	 */
	public void setNumeric (boolean numeric) {
		this.numeric = numeric;
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



	/**
	 * Return the value associated with the column: Parent
	 */
	public java.util.Set getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: Parent
	 * @param parent the Parent value
	 */
	public void setParent (java.util.Set parent) {
		this.parent = parent;
	}



	/**
	 * Return the value associated with the column: RoleGroups
	 */
	public java.util.Set getRoleGroups () {
		return roleGroups;
	}

	/**
	 * Set the value related to the column: RoleGroups
	 * @param roleGroups the RoleGroups value
	 */
	public void setRoleGroups (java.util.Set roleGroups) {
		this.roleGroups = roleGroups;
	}



	/**
	 * Return the value associated with the column: Views
	 */
	public java.util.List getViews () {
		return views;
	}

	/**
	 * Set the value related to the column: Views
	 * @param views the Views value
	 */
	public void setViews (java.util.List views) {
		this.views = views;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.Role)) return false;
		else {
			com.ams.mufins.model.Role role = (com.ams.mufins.model.Role) obj;
			return (this.getId() == role.getId());
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