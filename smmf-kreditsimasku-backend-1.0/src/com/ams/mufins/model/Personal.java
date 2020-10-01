package com.ams.mufins.model;

import com.ams.mufins.model.base.BasePersonal;



public class Personal extends BasePersonal {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Personal () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Personal (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Personal (
		long id,
		java.lang.String name,
		long userId,
		long employeeId,
		long masterSetupId,
		java.lang.String status) {

		super (
			id,
			name,
			userId,
			employeeId,
			masterSetupId,
			status);
	}

/*[CONSTRUCTOR MARKER END]*/


}