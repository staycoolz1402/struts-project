package com.ams.mufins.model;

import com.ams.mufins.model.base.BaseMasterKodeAplikasi;



public class MasterKodeAplikasi extends BaseMasterKodeAplikasi {
	private static final long serialVersionUID = 1L;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public MasterKodeAplikasi () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public MasterKodeAplikasi (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public MasterKodeAplikasi (
		long id,
		java.lang.String kodeAplikasi,
		java.lang.String namaAplikasi,
		java.lang.String otentikasi) {

		super (
			id,
			kodeAplikasi,
			namaAplikasi,
			otentikasi);
	}

/*[CONSTRUCTOR MARKER END]*/


}