package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the view_block_multiple table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="view_block_multiple"
 */

public abstract class BaseViewBlockMultiple  implements Serializable {

	public static String REF = "ViewBlockMultiple";
	public static String PROP_VIEW_ID = "ViewId";
	public static String PROP_VIEW_NAME = "ViewName";
	public static String PROP_VIEW_LINK = "ViewLink";
	public static String PROP_ACTIVE = "Active";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseViewBlockMultiple () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseViewBlockMultiple (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseViewBlockMultiple (
		long id,
		long viewId) {

		this.setId(id);
		this.setViewId(viewId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long viewId;
	private java.lang.String viewName;
	private java.lang.String viewLink;
	private boolean active;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="view_block_multiple_id"
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
	 * Return the value associated with the column: view_id
	 */
	public long getViewId () {
		return viewId;
	}

	/**
	 * Set the value related to the column: view_id
	 * @param viewId the view_id value
	 */
	public void setViewId (long viewId) {
		this.viewId = viewId;
	}



	/**
	 * Return the value associated with the column: ViewName
	 */
	public java.lang.String getViewName () {
		return viewName;
	}

	/**
	 * Set the value related to the column: ViewName
	 * @param viewName the ViewName value
	 */
	public void setViewName (java.lang.String viewName) {
		this.viewName = viewName;
	}



	/**
	 * Return the value associated with the column: ViewLink
	 */
	public java.lang.String getViewLink () {
		return viewLink;
	}

	/**
	 * Set the value related to the column: ViewLink
	 * @param viewLink the ViewLink value
	 */
	public void setViewLink (java.lang.String viewLink) {
		this.viewLink = viewLink;
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
		if (!(obj instanceof com.ams.mufins.model.ViewBlockMultiple)) return false;
		else {
			com.ams.mufins.model.ViewBlockMultiple viewBlockMultiple = (com.ams.mufins.model.ViewBlockMultiple) obj;
			return (this.getId() == viewBlockMultiple.getId());
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