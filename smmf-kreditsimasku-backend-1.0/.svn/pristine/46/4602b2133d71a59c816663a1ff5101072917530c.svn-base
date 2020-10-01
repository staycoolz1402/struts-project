package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the log_vendor_request table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="log_vendor_request"
 */

public abstract class BaseLogVendorRequest  implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static String REF = "LogVendorRequest";
	public static String PROP_VENDOR_ID = "VendorId";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_REQUEST = "Request";
	public static String PROP_RESPONSE = "Response";
	public static String PROP_STATUS = "Status";
	public static String PROP_SEND_ON = "SendOn";
	public static String PROP_REPLY_ON = "ReplyOn";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	// constructors
	public BaseLogVendorRequest () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseLogVendorRequest (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseLogVendorRequest (
		long id,
		long vendorId) {

		this.setId(id);
		this.setVendorId(vendorId);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private long vendorId;
	private long customerId;
	private java.lang.String request;
	private java.lang.String response;
	private java.lang.String status;
	private java.util.Date sendOn;
	private java.util.Date replyOn;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="log_vendor_request"
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
	 * Return the value associated with the column: vendor_id
	 */
	public long getVendorId () {
		return vendorId;
	}

	/**
	 * Set the value related to the column: vendor_id
	 * @param vendorId the vendor_id value
	 */
	public void setVendorId (long vendorId) {
		this.vendorId = vendorId;
	}



	/**
	 * Return the value associated with the column: request
	 */
	public java.lang.String getRequest () {
		return request;
	}

	/**
	 * Set the value related to the column: request
	 * @param request the request value
	 */
	public void setRequest (java.lang.String request) {
		this.request = request;
	}



	/**
	 * Return the value associated with the column: response
	 */
	public java.lang.String getResponse () {
		return response;
	}

	/**
	 * Set the value related to the column: response
	 * @param response the response value
	 */
	public void setResponse (java.lang.String response) {
		this.response = response;
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
	 * Return the value associated with the column: send_on
	 */
	public java.util.Date getSendOn () {
		return sendOn;
	}

	/**
	 * Set the value related to the column: send_on
	 * @param sendOn the send_on value
	 */
	public void setSendOn (java.util.Date sendOn) {
		this.sendOn = sendOn;
	}



	/**
	 * Return the value associated with the column: reply_on
	 */
	public java.util.Date getReplyOn () {
		return replyOn;
	}

	/**
	 * Set the value related to the column: reply_on
	 * @param replyOn the reply_on value
	 */
	public void setReplyOn (java.util.Date replyOn) {
		this.replyOn = replyOn;
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
		if (!(obj instanceof com.ams.mufins.model.LogVendorRequest)) return false;
		else {
			com.ams.mufins.model.LogVendorRequest logVendorRequest = (com.ams.mufins.model.LogVendorRequest) obj;
			return (this.getId() == logVendorRequest.getId());
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

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}


}