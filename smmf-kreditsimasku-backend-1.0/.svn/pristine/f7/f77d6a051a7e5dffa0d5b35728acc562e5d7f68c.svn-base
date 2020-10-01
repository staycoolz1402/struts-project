package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the status table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="status"
 */

public abstract class BaseStatus  implements Serializable {

	public static String REF = "Status";
	public static String PROP_TYPE = "Type";
	public static String PROP_CODE = "Code";
	public static String PROP_NAME = "Name";
	public static String PROP_DESCRIPTION = "Description";


	// constructors
	public BaseStatus () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseStatus (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseStatus (
		long id,
		java.lang.String type,
		java.lang.String code,
		java.lang.String name) {

		this.setId(id);
		this.setType(type);
		this.setCode(code);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String type;
	private java.lang.String code;
	private java.lang.String name;
	private java.lang.String description;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="status_id"
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
	 * Return the value associated with the column: type
	 */
	public java.lang.String getType () {
		return type;
	}

	/**
	 * Set the value related to the column: type
	 * @param type the type value
	 */
	public void setType (java.lang.String type) {
		this.type = type;
	}



	/**
	 * Return the value associated with the column: code
	 */
	public java.lang.String getCode () {
		return code;
	}

	/**
	 * Set the value related to the column: code
	 * @param code the code value
	 */
	public void setCode (java.lang.String code) {
		this.code = code;
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





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.Status)) return false;
		else {
			com.ams.mufins.model.Status status = (com.ams.mufins.model.Status) obj;
			return (this.getId() == status.getId());
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