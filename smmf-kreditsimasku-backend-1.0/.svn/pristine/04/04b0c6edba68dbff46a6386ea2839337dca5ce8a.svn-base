/*
 * Created on May 12, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.ams.mufins.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

import com.mpe.common.Formater;


/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class UserStream implements Serializable {
	
	long userId;
	String userName;
	String userType;
	Timestamp loginTime;
	Timestamp lastTime;
	String ip;
	String server;
	String browser;
	
	public UserStream() {
	}
	
	

	/**
	 * @return
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param l
	 */
	public void setUserId(long l) {
		userId = l;
	}

	/**
	 * @param string
	 */
	public void setUserName(String string) {
		userName = string;
	}
	
	
	public static Comparator<UserStream> userNameComparator = new Comparator<UserStream>() {

		@Override
		public int compare(UserStream o1, UserStream o2) {
			//ascending order
			//return userName1.compareTo(userName2);
 
			//descending order
			//return userName2.compareTo(userName1);

			String server1 = o1.getServer().toUpperCase();
			String server2 = o1.getServer().toUpperCase();
			String ip1 = o1.getIp().toUpperCase();
			String ip2 = o2.getIp().toUpperCase();
			String userType1 = o1.getUserType().toUpperCase();
			String userType2 = o2.getUserType().toUpperCase();
			String userName1 = o1.getUserName().toUpperCase();
			String userName2 = o2.getUserName().toUpperCase();
			Timestamp date1 = o1.getLoginTime();
			Timestamp date2 = o2.getLoginTime();
			
			//ascending order		
			int compare0 = server1.compareTo(server2) ;
			int compare1 = ip1.compareTo(ip2) ;
			int compare3 = userType1.compareTo(userType2) ;
			int compare4 = userName1.compareTo(userName2) ;
			int compare5 = date1.compareTo(date2) ;
			
			if(compare0==0){
				if(compare1==0){
						if(compare3==0){
							if(compare4==0){
								return compare5;
							}else{
								return compare4;
							}
						}else{
							return compare3;
						}
				}else{
					return compare1;
				}
			}else{
				return compare0;
			}
			
			//return compare1 == 0 ? branch1.compareTo(branch2) : compare1;
		}
		
		
	};
	
	
	
	public void updateUser(Users users, String ip, String browser) {
		this.userId = users.getId();
		this.userName = users.getUserName();
		this.userType = users.getUserType();
		Calendar calendar = new GregorianCalendar();
		this.loginTime = this.loginTime!=null?this.loginTime:new Timestamp(calendar.getTime().getTime());
		this.lastTime = new Timestamp(calendar.getTime().getTime());
		this.ip = ip;
		this.browser = browser;
	}

	/**
	 * @return
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * @param string
	 */
	public void setUserType(String string) {
		userType = string;
	}






	public Timestamp getLoginTime() {
		return loginTime;
	}
	
	public String getFormatedLoginTime() {
		return Formater.getFormatedDateTime(new Date(getLoginTime()!=null?getLoginTime().getTime():new Date().getTime()));
	}



	public void setLoginTime(Timestamp loginTime) {
		this.loginTime = loginTime;
	}



	public String getIp() {
		return ip;
	}



	public void setIp(String ip) {
		this.ip = ip;
	}



	public String getServer() {
		return server;
	}



	public void setServer(String server) {
		this.server = server;
	}



	public String getBrowser() {
		return browser;
	}



	public void setBrowser(String browser) {
		this.browser = browser;
	}



	public Timestamp getLastTime() {
		return lastTime;
	}
	
	public String getFormatedLastTime() {
		return Formater.getFormatedDateTime(new Date(getLastTime()!=null?getLastTime().getTime():new Date().getTime()));
	}



	public void setLastTime(Timestamp lastTime) {
		this.lastTime = lastTime;
	}

}
