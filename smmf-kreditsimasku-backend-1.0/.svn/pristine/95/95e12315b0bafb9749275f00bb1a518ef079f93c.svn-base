package com.ams.mufins.model.dao;

import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.ams.mufins.model.base.BaseUserLoggingDAO;

@SuppressWarnings({"rawtypes"})
public class UserLoggingDAO extends BaseUserLoggingDAO {
	Logger log = Logger.getLogger(this.getClass());
	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public UserLoggingDAO () {}
	
	public void save(Users users, HttpServletRequest request,  Set ipList, Set viewList) {
		/* 
		 * 
		 * Session session = getSession();
		Transaction transaction = null;
		try {
			String param = null;
			OrganizationSetup organizationSetup = OrganizationSetupDAO.getInstance().get(users.getOrganizationId(),session);
			
			if (users!=null && !users.getUserName().equalsIgnoreCase("ADMIN") && organizationSetup.isActiveUserLogging()) {
				transaction = session.beginTransaction();
				UserLogging userLogging = new UserLogging();
				userLogging.setUserName(users.getUserName());
				userLogging.setAccessDate(new Date());
				userLogging.setAccessTime(new Date());
				userLogging.setComputerName(InetAddress.getLocalHost().getHostName());
				userLogging.setAction(request.getRequestURI());
				userLogging.setIp(request.getRemoteAddr());
				userLogging.setHostname(request.getRemoteHost());
				userLogging.setTrustedIp(isTrustedIp(request.getRemoteAddr(), ipList));
				userLogging.setTrustedAction(isTrustedAction(request.getRequestURI(), viewList));
				
				View view = (View) session.createCriteria(View.class).add(Restrictions.eq("Link", getProperLink(request.getRequestURI()))).uniqueResult();
				if(getProperLink(request.getRequestURI()).equalsIgnoreCase("/logon.do")) userLogging.setViewId(Long.valueOf("0"));
				else userLogging.setViewId(view.getId());
				
				if(request.getQueryString()!=null){
					if(request.getQueryString().length()>1024)param = request.getQueryString().substring(0,1024);
					else param = request.getQueryString();
				}				
				userLogging.setParameter(param);
				userLogging.setBranch(users.getBranchName());
				
				if(users.getBranchId()!=null)userLogging.setBranchId(users.getBranchId());
				
				save(userLogging,session);
				transaction.commit();
			}
		} catch(Exception exception) {
			if(transaction!=null)transaction.rollback();
			exception.printStackTrace();
		} finally {
			if(session!=null)session.close();
		}*/
	}
	
	public void save(Users users, HttpServletRequest request,  Set ipList, Set viewList, Session session) throws Exception{
			/*String param = null;
			OrganizationSetup organizationSetup = OrganizationSetupDAO.getInstance().get(users.getOrganizationId(),session);
			if (users!=null && !users.getUserName().equalsIgnoreCase("ADMIN") && organizationSetup.isActiveUserLogging()) {
				UserLogging userLogging = new UserLogging();
				userLogging.setUserName(users.getUserName());
				userLogging.setAccessDate(new Date());
				userLogging.setAccessTime(new Date());
				userLogging.setComputerName(InetAddress.getLocalHost().getHostName());
				userLogging.setAction(request.getRequestURI());
				userLogging.setIp(request.getRemoteAddr());
				userLogging.setHostname(request.getRemoteHost());
				userLogging.setTrustedIp(isTrustedIp(request.getRemoteAddr(), ipList));
				userLogging.setTrustedAction(isTrustedAction(request.getRequestURI(), viewList));
				
				View view = (View) session.createCriteria(View.class).add(Restrictions.eq("Link", getProperLink(request.getRequestURI()))).uniqueResult();
				if(getProperLink(request.getRequestURI()).equalsIgnoreCase("/logon.do")) userLogging.setViewId(Long.valueOf("0"));
				else userLogging.setViewId(view.getId());
				
				if(request.getQueryString()!=null){
					if(request.getQueryString().length()>1024)param = request.getQueryString().substring(0,1024);
					else param = request.getQueryString();
				}				
				userLogging.setParameter(param);
				userLogging.setBranch(users.getBranchName());
				
				if(users.getBranchId()!=null)userLogging.setBranchId(users.getBranchId());
				
				save(userLogging,session);
			}*/
	}
	
	public boolean isTrustedIp(String ip, Set set) {
		boolean b = false;
		if (set!=null) {
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				String string = (String)iterator.next();
				if ((ip.trim()).equalsIgnoreCase(string.trim())) {
					b = true;
					break;
				}
			}
		}
		return b;
	}
	
	public boolean isTrustedAction(String path, Set set) {
		boolean b = false;
		if (set!=null) {
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				View view = (View)iterator.next();
				if (path!=null && view.getLink()!=null && (path.trim()).endsWith(view.getLink().trim())) {
					if (view.isTrustedAction()) {
						b = true;
						break;
					}
				}
			}
		}
		return b;
	}
	
	public String getProperLink(String path){
		String link = path.trim();
		if(link.contains("/mufins")){
			int firstDelimiter = link.indexOf("/",2);
			if(link.contains("jsession")){
				int lastDelimiter = link.indexOf(";");
				if(lastDelimiter!=-1)link = link.substring(firstDelimiter, lastDelimiter);
			}else{
				link = link.substring(firstDelimiter);
			}
		}
		return link;
	}
}