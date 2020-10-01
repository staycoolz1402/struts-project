package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseLookup;



public class Lookup extends BaseLookup {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Lookup () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Lookup (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Lookup (
		long id,
		java.lang.String category,
		java.lang.String code,
		java.lang.String shortName,
		java.lang.String name) {

		super (
			id,
			category,
			code,
			shortName,
			name);
	}

/*[CONSTRUCTOR MARKER END]*/


}