package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the report_access table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="report_access"
 */

public abstract class BaseReportAccess  implements Serializable {

	public static String REF = "ReportAccess";
	public static String PROP_REPORT_NAME = "ReportName";
	public static String PROP_REPORT_LEVEL = "ReportLevel";
	public static String PROP_REPORT_ACCESS_TIME = "ReportAccessTime";


	// constructors
	public BaseReportAccess () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseReportAccess (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String reportName;
	private int reportLevel;
	private int reportAccessTime;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="report_access_id"
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
	 * Return the value associated with the column: report_name
	 */
	public java.lang.String getReportName () {
		return reportName;
	}

	/**
	 * Set the value related to the column: report_name
	 * @param reportName the report_name value
	 */
	public void setReportName (java.lang.String reportName) {
		this.reportName = reportName;
	}



	/**
	 * Return the value associated with the column: report_level
	 */
	public int getReportLevel () {
		return reportLevel;
	}

	/**
	 * Set the value related to the column: report_level
	 * @param reportLevel the report_level value
	 */
	public void setReportLevel (int reportLevel) {
		this.reportLevel = reportLevel;
	}



	/**
	 * Return the value associated with the column: report_access_time
	 */
	public int getReportAccessTime () {
		return reportAccessTime;
	}

	/**
	 * Set the value related to the column: report_access_time
	 * @param reportAccessTime the report_access_time value
	 */
	public void setReportAccessTime (int reportAccessTime) {
		this.reportAccessTime = reportAccessTime;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.ReportAccess)) return false;
		else {
			com.ams.mufins.model.ReportAccess reportAccess = (com.ams.mufins.model.ReportAccess) obj;
			return (this.getId() == reportAccess.getId());
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