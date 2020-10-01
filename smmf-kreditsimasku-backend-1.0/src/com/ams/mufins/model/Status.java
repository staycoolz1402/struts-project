package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseStatus;



public class Status extends BaseStatus {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Status () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Status (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Status (
		long id,
		java.lang.String type,
		java.lang.String code,
		java.lang.String name) {

		super (
			id,
			type,
			code,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}