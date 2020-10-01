package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the views table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="views"
 */

public abstract class BaseView  implements Serializable {

	public static String REF = "View";
	public static String PROP_VIEW_NAME = "ViewName";
	public static String PROP_LINK = "Link";
	public static String PROP_VIEW = "View";
	public static String PROP_TRUSTED_ACTION = "TrustedAction";
	public static String PROP_DESCRIPTION = "Description";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	public static String PROP_PARENT_VIEW_NAME = "ParentViewName";


	// constructors
	public BaseView () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseView (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String viewName;
	private java.lang.String link;
	private boolean view;
	private boolean trustedAction;
	private java.lang.String description;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.lang.String parentViewName;

	// many to one
	private com.ams.mufins.model.View parent;

	// collections
	private java.util.Set views;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="increment"
     *  column="view_id"
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
	 * Return the value associated with the column: view_name
	 */
	public java.lang.String getViewName () {
		return viewName;
	}

	/**
	 * Set the value related to the column: view_name
	 * @param viewName the view_name value
	 */
	public void setViewName (java.lang.String viewName) {
		this.viewName = viewName;
	}



	/**
	 * Return the value associated with the column: link
	 */
	public java.lang.String getLink () {
		return link;
	}

	/**
	 * Set the value related to the column: link
	 * @param link the link value
	 */
	public void setLink (java.lang.String link) {
		this.link = link;
	}



	/**
	 * Return the value associated with the column: is_view
	 */
	public boolean isView () {
		return view;
	}

	/**
	 * Set the value related to the column: is_view
	 * @param view the is_view value
	 */
	public void setView (boolean view) {
		this.view = view;
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
	 * Return the value associated with the column: ParentViewName
	 */
	public java.lang.String getParentViewName () {
		return parentViewName;
	}

	/**
	 * Set the value related to the column: ParentViewName
	 * @param parentViewName the ParentViewName value
	 */
	public void setParentViewName (java.lang.String parentViewName) {
		this.parentViewName = parentViewName;
	}



	/**
	 * Return the value associated with the column: parent_id
	 */
	public com.ams.mufins.model.View getParent () {
		return parent;
	}

	/**
	 * Set the value related to the column: parent_id
	 * @param parent the parent_id value
	 */
	public void setParent (com.ams.mufins.model.View parent) {
		this.parent = parent;
	}



	/**
	 * Return the value associated with the column: Views
	 */
	public java.util.Set getViews () {
		return views;
	}

	/**
	 * Set the value related to the column: Views
	 * @param views the Views value
	 */
	public void setViews (java.util.Set views) {
		this.views = views;
	}

	public void addToViews (com.ams.mufins.model.View view) {
		if (null == getViews()) setViews(new java.util.HashSet());
		getViews().add(view);
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.View)) return false;
		else {
			com.ams.mufins.model.View view = (com.ams.mufins.model.View) obj;
			return (this.getId() == view.getId());
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