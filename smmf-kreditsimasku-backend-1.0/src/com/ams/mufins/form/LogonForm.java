package com.ams.mufins.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;

import com.mpe.common.form.*;

import org.apache.struts.action.ActionMapping;

/** 
 * UserForm.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 06-05-2003
 * 
 * XDoclet definition:
 * @struts:form name="userForm"
 */
public class LogonForm extends BaseDynaForm {
	private static final long serialVersionUID = 1L;

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method validate
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 * @return ActionErrors
	 */
	public ActionErrors validate(
		ActionMapping mapping,
		HttpServletRequest request) {
			return null;
	}

	/** 
	 * Method reset
	 * @param ActionMapping mapping
	 * @param HttpServletRequest request
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {

	}

}
