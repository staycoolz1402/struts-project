package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseLogVendorRequest;



public class LogVendorRequest extends BaseLogVendorRequest {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public LogVendorRequest () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public LogVendorRequest (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public LogVendorRequest (
		long id,
		long vendorId) {

		super (
			id,
			vendorId);
	}

/*[CONSTRUCTOR MARKER END]*/


}