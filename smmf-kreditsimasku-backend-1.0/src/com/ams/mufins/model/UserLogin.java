package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseUserLogin;



public class UserLogin extends BaseUserLogin {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public UserLogin () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public UserLogin (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public UserLogin (
		long id,
		java.lang.String userName) {

		super (
			id,
			userName);
	}

/*[CONSTRUCTOR MARKER END]*/


}