package com.mpe.common;

import javax.servlet.http.HttpServletRequest;

import com.ams.mufins.model.Users;

public class HrdUrl{
	private static final String PROPERTY_FILE_NAME = "hrdURL.properties";
	public static final String URL_HRD = CommonDynamics.getProperty(PROPERTY_FILE_NAME).getString("URL_HRD");
	public static final String URL_EMPLOYEE_LIST = CommonDynamics.getProperty(PROPERTY_FILE_NAME).getString("URL_EMPLOYEE_LIST");

	public static String getUrlEmployeeList(Users users, HttpServletRequest request){
    		String domain = request.getRequestURL().toString();
    		StringBuilder sb = new StringBuilder();
			sb.append(domain.substring(0,domain.indexOf(request.getContextPath())));
			sb.append(URL_HRD);
			sb.append("?userName=");
			sb.append(users.getUserName());
			sb.append("&userPass=");
			sb.append(users.getUserPass());
			sb.append("&url=");
			sb.append(URL_EMPLOYEE_LIST);
			sb.append("?source=MUFINS");
			return sb.toString();
	}
	
	public static String getUrlEmployeeListPartner(Users users, HttpServletRequest request){
		String domain = request.getRequestURL().toString();
		StringBuilder sb = new StringBuilder();
		sb.append(domain.substring(0,domain.indexOf(request.getContextPath())));
		sb.append(URL_HRD);
		sb.append("?userName=");
		sb.append(users.getUserName());
		sb.append("&userPass=");
		sb.append(users.getUserPass());
		sb.append("&url=");
		sb.append(URL_EMPLOYEE_LIST);
		sb.append("?source=MUFINSPARTNER");
		return sb.toString();
	}
}