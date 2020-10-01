/*
 * Created on May 11, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.mpe.common;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ams.mufins.model.UserStream;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.base._BaseRootDAO;
import com.ams.mufins.model.dao._RootReportDAO;

import common.Logger;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class ActionFilter implements Filter {
	transient Logger log = Logger.getLogger(this.getClass());
	transient List<String> pathList = new LinkedList<String>();
	
	public void init(FilterConfig filterConfig) throws ServletException {
		pathList.add("/CfApplicationSampling/imageUpload");
		pathList.add("/CfApplicationSampling/upload/formFileUpload");
		pathList.add("/invoiceScan/save");
		pathList.add("/invoiceUpload/save");
		pathList.add("/personal/copyPersonalDocument");
		pathList.add("/personal/documentationFileUpload");
		pathList.add("/personal/documentationSave");
		pathList.add("/purchaseRequest/approval/save");
		pathList.add("/purchaseRequest/letterOfInquiryUpload/save");
		pathList.add("/purchaseRequest/save");
		pathList.add("/searchReport/uploadDocumentImageSave");
		pathList.add("/surveyor/documentationFileUpload");
		pathList.add("/surveyor/imageUpload");
		pathList.add("/surveyorCfApplication/imageSave");
		pathList.add("/surveyorDocumentationFile/save");
		pathList.add("/termination/assetForFutureSalesImageSave");
	}

	public void destroy() {
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
		throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		Users user = (Users)session.getAttribute(CommonConstants.USER);

		HttpServletResponse myResponse = (HttpServletResponse) resp;
	    myResponse.addHeader("X-Frame-Options", "SAMEORIGIN");
	    
		UserStream userstream = (UserStream)session.getAttribute(CommonConstants.USERSTREAM);
		
		if (user!=null && userstream!=null) {
			String path = request.getRequestURI()
					.replace(request.getContextPath(), "")
					.replace(".do", "");
			if (pathList.contains(path)) {
				log.warn("[ ActionFilter - "+path+" - "+user.getUserName()+" ] ");
			}
			
			String browser = BrowserUtil.getBrowser(request);
			userstream.updateUser(user, request.getRemoteAddr(), browser);
		}
		try{
			chain.doFilter(req, resp);
		//}catch(Exception ex){
			//response.sendRedirect("/error.jsp");	
			
			//log.error("Unhandle Exception", ex);
		}finally{
			_BaseRootDAO.closeCurrentThreadSessions();
			_RootReportDAO.closeCurrentThreadSessions();
		}
	}
	
	

}
