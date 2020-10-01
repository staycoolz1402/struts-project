package com.ams.mufins.model;


import com.ams.mufins.model.base.BaseView;
import com.mpe.common.Formater;


public class View extends BaseView {
	private static final long serialVersionUID = 1L;
	int childs;
	int length;

/*[CONSTRUCTOR MARKER BEGIN]*/
	public View () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public View (long id) {
		super(id);
	}

/*[CONSTRUCTOR MARKER END]*/
	
	public int getChilds() {
		return childs;
	}
	public void setChilds(int childs) {
		this.childs = childs;
	}
	
	public long getValueOfId( View obj ) {
		long result;
		result = (long)0;
		if ( obj == null ) return result;
		else return obj.getId();
	}
	
	public int getMenuLength() {
		// satuan pcx
		// awalan space + menu + space panah
		return 5 + (6 * getViewName().length()) + 20;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public String getFormatedCreateOn() {
	    return Formater.getFormatedDateTime(getCreateOn());
	}
	
	public String getFormatedChangeOn() {
	    return Formater.getFormatedDateTime(getChangeOn());
	}
}