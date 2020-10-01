package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the  table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table=""
 */

public abstract class BaseTempModel  implements Serializable {

	public static String REF = "TempModel";
	public static String PROP_STRING1 = "String1";
	public static String PROP_STRING2 = "String2";
	public static String PROP_STRING3 = "String3";
	public static String PROP_STRING4 = "String4";
	public static String PROP_STRING5 = "String5";
	public static String PROP_STRING6 = "String6";
	public static String PROP_STRING7 = "String7";
	public static String PROP_STRING8 = "String8";
	public static String PROP_STRING9 = "String9";
	public static String PROP_DOUBLE1 = "Double1";
	public static String PROP_DOUBLE2 = "Double2";
	public static String PROP_DOUBLE3 = "Double3";
	public static String PROP_DOUBLE4 = "Double4";
	public static String PROP_DOUBLE5 = "Double5";
	public static String PROP_LONG1 = "Long1";
	public static String PROP_LONG2 = "Long2";
	public static String PROP_LONG3 = "Long3";
	public static String PROP_LONG4 = "Long4";
	public static String PROP_LONG5 = "Long5";
	public static String PROP_DATE1 = "Date1";
	public static String PROP_DATE2 = "Date2";
	public static String PROP_DATE3 = "Date3";
	public static String PROP_DATE4 = "Date4";
	public static String PROP_DATE5 = "Date5";
	public static String PROP_NUMBER_OF_DIGIT = "NumberOfDigit";


	// constructors
	public BaseTempModel () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseTempModel (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String string1;
	private java.lang.String string2;
	private java.lang.String string3;
	private java.lang.String string4;
	private java.lang.String string5;
	private java.lang.String string6;
	private java.lang.String string7;
	private java.lang.String string8;
	private java.lang.String string9;
	private double double1;
	private double double2;
	private double double3;
	private double double4;
	private double double5;
	private long long1;
	private long long2;
	private long long3;
	private long long4;
	private long long5;
	private java.util.Date date1;
	private java.util.Date date2;
	private java.util.Date date3;
	private java.util.Date date4;
	private java.util.Date date5;
	private int numberOfDigit;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  column="Id"
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
	 * Return the value associated with the column: String1
	 */
	public java.lang.String getString1 () {
		return string1;
	}

	/**
	 * Set the value related to the column: String1
	 * @param string1 the String1 value
	 */
	public void setString1 (java.lang.String string1) {
		this.string1 = string1;
	}



	/**
	 * Return the value associated with the column: String2
	 */
	public java.lang.String getString2 () {
		return string2;
	}

	/**
	 * Set the value related to the column: String2
	 * @param string2 the String2 value
	 */
	public void setString2 (java.lang.String string2) {
		this.string2 = string2;
	}



	/**
	 * Return the value associated with the column: String3
	 */
	public java.lang.String getString3 () {
		return string3;
	}

	/**
	 * Set the value related to the column: String3
	 * @param string3 the String3 value
	 */
	public void setString3 (java.lang.String string3) {
		this.string3 = string3;
	}



	/**
	 * Return the value associated with the column: String4
	 */
	public java.lang.String getString4 () {
		return string4;
	}

	/**
	 * Set the value related to the column: String4
	 * @param string4 the String4 value
	 */
	public void setString4 (java.lang.String string4) {
		this.string4 = string4;
	}



	/**
	 * Return the value associated with the column: String5
	 */
	public java.lang.String getString5 () {
		return string5;
	}

	/**
	 * Set the value related to the column: String5
	 * @param string5 the String5 value
	 */
	public void setString5 (java.lang.String string5) {
		this.string5 = string5;
	}



	/**
	 * Return the value associated with the column: String6
	 */
	public java.lang.String getString6 () {
		return string6;
	}

	/**
	 * Set the value related to the column: String6
	 * @param string6 the String6 value
	 */
	public void setString6 (java.lang.String string6) {
		this.string6 = string6;
	}



	/**
	 * Return the value associated with the column: String7
	 */
	public java.lang.String getString7 () {
		return string7;
	}

	/**
	 * Set the value related to the column: String7
	 * @param string7 the String7 value
	 */
	public void setString7 (java.lang.String string7) {
		this.string7 = string7;
	}



	/**
	 * Return the value associated with the column: String8
	 */
	public java.lang.String getString8 () {
		return string8;
	}

	/**
	 * Set the value related to the column: String8
	 * @param string8 the String8 value
	 */
	public void setString8 (java.lang.String string8) {
		this.string8 = string8;
	}



	/**
	 * Return the value associated with the column: String9
	 */
	public java.lang.String getString9 () {
		return string9;
	}

	/**
	 * Set the value related to the column: String9
	 * @param string9 the String9 value
	 */
	public void setString9 (java.lang.String string9) {
		this.string9 = string9;
	}



	/**
	 * Return the value associated with the column: Double1
	 */
	public double getDouble1 () {
		return double1;
	}

	/**
	 * Set the value related to the column: Double1
	 * @param double1 the Double1 value
	 */
	public void setDouble1 (double double1) {
		this.double1 = double1;
	}



	/**
	 * Return the value associated with the column: Double2
	 */
	public double getDouble2 () {
		return double2;
	}

	/**
	 * Set the value related to the column: Double2
	 * @param double2 the Double2 value
	 */
	public void setDouble2 (double double2) {
		this.double2 = double2;
	}



	/**
	 * Return the value associated with the column: Double3
	 */
	public double getDouble3 () {
		return double3;
	}

	/**
	 * Set the value related to the column: Double3
	 * @param double3 the Double3 value
	 */
	public void setDouble3 (double double3) {
		this.double3 = double3;
	}



	/**
	 * Return the value associated with the column: Double4
	 */
	public double getDouble4 () {
		return double4;
	}

	/**
	 * Set the value related to the column: Double4
	 * @param double4 the Double4 value
	 */
	public void setDouble4 (double double4) {
		this.double4 = double4;
	}



	/**
	 * Return the value associated with the column: Double5
	 */
	public double getDouble5 () {
		return double5;
	}

	/**
	 * Set the value related to the column: Double5
	 * @param double5 the Double5 value
	 */
	public void setDouble5 (double double5) {
		this.double5 = double5;
	}



	/**
	 * Return the value associated with the column: Long1
	 */
	public long getLong1 () {
		return long1;
	}

	/**
	 * Set the value related to the column: Long1
	 * @param long1 the Long1 value
	 */
	public void setLong1 (long long1) {
		this.long1 = long1;
	}



	/**
	 * Return the value associated with the column: Long2
	 */
	public long getLong2 () {
		return long2;
	}

	/**
	 * Set the value related to the column: Long2
	 * @param long2 the Long2 value
	 */
	public void setLong2 (long long2) {
		this.long2 = long2;
	}



	/**
	 * Return the value associated with the column: Long3
	 */
	public long getLong3 () {
		return long3;
	}

	/**
	 * Set the value related to the column: Long3
	 * @param long3 the Long3 value
	 */
	public void setLong3 (long long3) {
		this.long3 = long3;
	}



	/**
	 * Return the value associated with the column: Long4
	 */
	public long getLong4 () {
		return long4;
	}

	/**
	 * Set the value related to the column: Long4
	 * @param long4 the Long4 value
	 */
	public void setLong4 (long long4) {
		this.long4 = long4;
	}



	/**
	 * Return the value associated with the column: Long5
	 */
	public long getLong5 () {
		return long5;
	}

	/**
	 * Set the value related to the column: Long5
	 * @param long5 the Long5 value
	 */
	public void setLong5 (long long5) {
		this.long5 = long5;
	}



	/**
	 * Return the value associated with the column: Date1
	 */
	public java.util.Date getDate1 () {
		return date1;
	}

	/**
	 * Set the value related to the column: Date1
	 * @param date1 the Date1 value
	 */
	public void setDate1 (java.util.Date date1) {
		this.date1 = date1;
	}



	/**
	 * Return the value associated with the column: Date2
	 */
	public java.util.Date getDate2 () {
		return date2;
	}

	/**
	 * Set the value related to the column: Date2
	 * @param date2 the Date2 value
	 */
	public void setDate2 (java.util.Date date2) {
		this.date2 = date2;
	}



	/**
	 * Return the value associated with the column: Date3
	 */
	public java.util.Date getDate3 () {
		return date3;
	}

	/**
	 * Set the value related to the column: Date3
	 * @param date3 the Date3 value
	 */
	public void setDate3 (java.util.Date date3) {
		this.date3 = date3;
	}



	/**
	 * Return the value associated with the column: Date4
	 */
	public java.util.Date getDate4 () {
		return date4;
	}

	/**
	 * Set the value related to the column: Date4
	 * @param date4 the Date4 value
	 */
	public void setDate4 (java.util.Date date4) {
		this.date4 = date4;
	}



	/**
	 * Return the value associated with the column: Date5
	 */
	public java.util.Date getDate5 () {
		return date5;
	}

	/**
	 * Set the value related to the column: Date5
	 * @param date5 the Date5 value
	 */
	public void setDate5 (java.util.Date date5) {
		this.date5 = date5;
	}



	/**
	 * Return the value associated with the column: NumberOfDigit
	 */
	public int getNumberOfDigit () {
		return numberOfDigit;
	}

	/**
	 * Set the value related to the column: NumberOfDigit
	 * @param numberOfDigit the NumberOfDigit value
	 */
	public void setNumberOfDigit (int numberOfDigit) {
		this.numberOfDigit = numberOfDigit;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.TempModel)) return false;
		else {
			com.ams.mufins.model.TempModel tempModel = (com.ams.mufins.model.TempModel) obj;
			return (this.getId() == tempModel.getId());
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