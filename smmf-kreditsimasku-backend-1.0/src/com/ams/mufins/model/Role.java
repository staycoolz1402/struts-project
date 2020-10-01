package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseRole;



public class Role extends BaseRole {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Role () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Role (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Role (
		long id,
		java.lang.String roleName) {

		super (
			id,
			roleName);
	}

/*[CONSTRUCTOR MARKER END]*/


}