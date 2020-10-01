package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the lookup table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="lookup"
 */

public abstract class BaseLookup  implements Serializable {

	public static String REF = "Lookup";
	public static String PROP_CATEGORY = "Category";
	public static String PROP_CODE = "Code";
	public static String PROP_SHORT_NAME = "ShortName";
	public static String PROP_NAME = "Name";
	public static String PROP_DESCRIPTION = "Description";


	// constructors
	public BaseLookup () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLookup (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLookup (
		long id,
		java.lang.String category,
		java.lang.String code,
		java.lang.String shortName,
		java.lang.String name) {

		this.setId(id);
		this.setCategory(category);
		this.setCode(code);
		this.setShortName(shortName);
		this.setName(name);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String category;
	private java.lang.String code;
	private java.lang.String shortName;
	private java.lang.String name;
	private java.lang.String description;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="lookup_id"
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
	 * Return the value associated with the column: category
	 */
	public java.lang.String getCategory () {
		return category;
	}

	/**
	 * Set the value related to the column: category
	 * @param category the category value
	 */
	public void setCategory (java.lang.String category) {
		this.category = category;
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
	 * Return the value associated with the column: short_name
	 */
	public java.lang.String getShortName () {
		return shortName;
	}

	/**
	 * Set the value related to the column: short_name
	 * @param shortName the short_name value
	 */
	public void setShortName (java.lang.String shortName) {
		this.shortName = shortName;
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
		if (!(obj instanceof com.ams.mufins.model.Lookup)) return false;
		else {
			com.ams.mufins.model.Lookup lookup = (com.ams.mufins.model.Lookup) obj;
			return (this.getId() == lookup.getId());
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