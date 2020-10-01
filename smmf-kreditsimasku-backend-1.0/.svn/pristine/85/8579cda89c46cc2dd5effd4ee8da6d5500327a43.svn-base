
package com.ams.mufins.action;

import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.upload.FormFile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.form.OrganizationForm;
import com.ams.mufins.model.Lookup;
import com.ams.mufins.model.Organization;
import com.ams.mufins.model.OrganizationSetup;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.dao.LookupDAO;
import com.ams.mufins.model.dao.OrganizationDAO;
import com.ams.mufins.model.dao.OrganizationSetupDAO;
import com.ams.mufins.model.dao.UsersDAO;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Pager;

public class OrganizationAction extends Action {
	Log log = LogFactory.getFactory().getInstance(this.getClass());

	// --------------------------------------------------------- Instance Variables

	// --------------------------------------------------------- Methods

	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
		//DataSource ds = (DataSource) servlet.getServletContext().getAttribute(org.apache.struts.Globals.DATA_SOURCE_KEY);
		//Connection conn = null;
		//VendorForm vendorForm = (VendorForm) form;
		ActionForward forward = null;
		String action = mapping.getParameter();
		HttpSession session = request.getSession();
		Users users = (Users)session.getAttribute(CommonConstants.USER);
		Set lst = (Set)session.getAttribute(CommonConstants.VIEWACCESS);
			if (users!=null) {
				if (CommonUtil.isHasRoleAccess(lst,request.getServletPath())) {
					log.info("[ START "+this.getClass().getName()+" "+action+" "+users.getUserName()+"  ] ");
					request.setAttribute("VIEWS",lst);
					request.setAttribute("viewName", CommonUtil.getViewName(lst, request.getServletPath()));
					/* start log */
					Set setIp = CommonUtil.getTrustedIp(getServlet().getServletConfig().getServletContext().getRealPath("/"));
					/* end log */
					if ("".equalsIgnoreCase(action)) {
						forward = mapping.findForward("home");
					} else if ("LIST".equalsIgnoreCase(action)) {
						forward = performPartialList(mapping, form, request, response);
					} else if ("FORM".equalsIgnoreCase(action)) {
						forward = performForm(mapping, form, request, response);
					} else if ("SAVE".equalsIgnoreCase(action)) {
						forward = performSave(mapping, form, request, response);
					} else if ("DETAIL".equalsIgnoreCase(action)) { 
						forward = performDetail(mapping, form, request, response);
					} else if ("DELETE".equalsIgnoreCase(action)) {
						forward = performDelete(mapping, form, request, response);
					} else if ("ORGANIZATIONSETUPFORM".equalsIgnoreCase(action)) {
						forward = performOrganizationSetupForm(mapping, form, request, response);
					} else if ("ORGANIZATIONSETUPSAVE".equalsIgnoreCase(action)) {
						forward = performOrganizationSetupSave(mapping, form, request, response);
					} else if ("SHOWIMAGE".equalsIgnoreCase(action)) { 
						forward = performShowImage(mapping, form, request, response);
					} 
					return forward;
				} else {
					ActionMessages errors = new ActionMessages();
					errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.privilage",request.getContextPath()+mapping.getPath()));
					saveErrors(request,errors);				
					return mapping.findForward("home");
				}
			} else {
				return mapping.findForward("index");
			}
	}

	/** 
	 * Method performList
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	private ActionForward performPartialList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			int start = 0;
			int count = 0;
			int total = 0;
			try {
				start = Integer.parseInt(request.getParameter("start"));
			}catch(Exception ex) {
			}
			try {
				count = Integer.parseInt(request.getParameter("count"));
			}catch(Exception ex) {
				try {
					ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
					count = Integer.parseInt(prop.getString("max.item.per.page"));
				}catch(Exception exx) {
				}
			}
			//save start and count attribute on session
			httpSession.setAttribute(CommonConstants.START,Integer.toString(start));
			httpSession.setAttribute(CommonConstants.COUNT,Integer.toString(count));
			Criteria criteria = OrganizationDAO.getInstance().getSession().createCriteria(Organization.class);
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = OrganizationDAO.getInstance().getSession().createCriteria(Organization.class);
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			List list = criteria.list();
			request.setAttribute("ORGANIZATION",list);
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);
		}catch(Exception ex){
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list");
	}
		

	/** 
	 * Method performForm
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */			
	private ActionForward performForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (form.getLong("organizationId") == 0) {
				form.setString("organizationId",0);
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT,httpSession.getAttribute(CommonConstants.COUNT));
			} else {
				Organization obj = OrganizationDAO.getInstance().get(form.getLong("organizationId"));				
				form.setString("organizationId",obj.getId());
				form.setString("name",obj.getName());
				form.setString("address",obj.getAddress());
				form.setString("city",obj.getCity());
				form.setString("postalCode",obj.getPostalCode());
				form.setString("province",obj.getProvince());
				form.setString("telephone",obj.getTelephone());
				form.setString("email",obj.getEmail());
				form.setString("url",obj.getUrl());
				form.setString("npwp",obj.getNpwp());
				form.setCalendar("npwpDate",obj.getNpwpDate());
				//form.setString("logoContentType",obj.getLogoContentType());
			}
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("form");
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form");
	}
	
	/** 
	 * Method performSave
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			if (form.getLong("organizationId") == 0) {
			    OrganizationSetup obj = new OrganizationSetup();
				obj.setName(form.getString("name"));
				obj.setAddress(form.getString("address"));
				obj.setCity(form.getString("city"));
				obj.setPostalCode(form.getString("postalCode"));
				obj.setProvince(form.getString("province"));
				obj.setNpwp(form.getString("npwp"));
				obj.setTelephone(form.getString("telephone"));
				obj.setEmail(form.getString("email"));
				obj.setNpwpDate(form.getCalendar("npwpDate")!=null?form.getCalendar("npwpDate").getTime():null);
				obj.setUrl(form.getString("url"));
				/*FormFile file = form.getFile("logo");
				if (file!=null && file.getFileSize()>0 && file.getContentType().substring(0,5).equalsIgnoreCase("image")) {
				    obj.setLogo(file.getFileData());
				    obj.setLogoContentType(file.getContentType());
				}*/
				httpSession.setAttribute("organizationSetup", obj);
				//redirect to organization setup
				ActionForward forward = mapping.findForward("form_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				return new ActionForward(sb.toString(),true);
			} else {
				Organization obj = OrganizationDAO.getInstance().load(form.getLong("organizationId"));
				obj.setName(form.getString("name"));
				obj.setAddress(form.getString("address"));
				obj.setCity(form.getString("city"));
				obj.setPostalCode(form.getString("postalCode"));
				obj.setProvince(form.getString("province"));
				obj.setNpwp(form.getString("npwp"));
				obj.setTelephone(form.getString("telephone"));
				obj.setEmail(form.getString("email"));
				obj.setNpwpDate(form.getCalendar("npwpDate")!=null?form.getCalendar("npwpDate").getTime():null);
				obj.setUrl(form.getString("url"));
				
				/*FormFile file = form.getFile("logo");
				if (file!=null && file.getFileSize()>0 && file.getContentType().substring(0,5).equalsIgnoreCase("image")) {
				    obj.setLogo(file.getFileData());
				    obj.setLogoContentType(file.getContentType());
				}
				if (form.getString("removeLogo")!=null && form.getString("removeLogo").equalsIgnoreCase("Y")) {
					obj.setLogo(null);
					obj.setLogoContentType(null);
				}*/
				
				OrganizationDAO.getInstance().saveOrUpdate(obj);
				
				// redirect to list
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
		}catch(Exception ex) {
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
	}
		
	/** 
	 * Method performDetail
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performDetail(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Organization organization = OrganizationDAO.getInstance().get(form.getLong("organizationId"));
			request.setAttribute("organization", organization);
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("detail");
	}
		
	/** 
	 * Method performDelete
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performDelete(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			OrganizationDAO.getInstance().delete(form.getLong("organizationId"));
		}catch(Exception ex) {
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("list_redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
	}
	
	@SuppressWarnings("rawtypes")
	private ActionForward performOrganizationSetupForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			// relationships
			if (form.getLong("organizationId") == 0) {
				form.setString("organizationId",0);
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT,httpSession.getAttribute(CommonConstants.COUNT));
			} else {
				OrganizationSetup obj = OrganizationSetupDAO.getInstance().get(form.getLong("organizationId"));
				form.setCalendar("setupDate", obj.getSetupDate());
				form.setString("numberOfDigit",obj.getNumberOfDigit());
				form.setString("defaultUserPassDuration", obj.getDefaultUserPassDuration());
				form.setString("defaultUserPassHistory", obj.getUserPassHistory());
				form.setString("defaultMinUserPassLength", obj.getMinUserPassLength());
				form.setString("timeoutAdmin",obj.getTimeoutAdmin());
				form.setString("timeoutUser",obj.getTimeoutUser());
				form.setString("timeoutServer",obj.getTimeoutServer());
				form.setString("sodLimit", obj.getSodLimit());
				form.setString("maxLoginAttempt", obj.getMaximumLoginAttempt());

			}
		}catch(Exception ex) {
			try {
				List currencyExchangeRateTypeList = LookupDAO.getInstance().getSession().createCriteria(Lookup.class).add(Restrictions.eq("Category", "CURRENCY_EXCHANGE_RATE_TYPE")).list();
				request.setAttribute("currencyExchangeRateTypeList", currencyExchangeRateTypeList);
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return mapping.findForward("form");
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form");
	}
	
	@SuppressWarnings("rawtypes")
	private ActionForward performOrganizationSetupSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
		    	httpSession.removeAttribute("organizationSetup");
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			OrganizationSetup obj = null;
			if (form.getLong("organizationId") == 0) {
			    // load from session
			    obj = (OrganizationSetup)httpSession.getAttribute("organizationSetup");
			    obj.setSetupDate(form.getCalendar("setupDate")!=null?form.getCalendar("setupDate").getTime():null);
			    obj.setNumberOfDigit(form.getInt("numberOfDigit"));
			    obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
			    obj.setUserPassHistory(form.getInt("defaultUserPassHistory"));
			    obj.setMinUserPassLength(form.getInt("defaultMinUserPassLength"));
			    obj.setTimeoutAdmin(form.getInt("timeoutAdmin"));
			    obj.setTimeoutUser(form.getInt("timeoutUser"));
			    obj.setTimeoutServer(form.getInt("timeoutServer"));
			    obj.setSodLimit(form.getInt("sodLimit"));
			    obj.setMaximumLoginAttempt(form.getInt("maxLoginAttempt"));
			    //obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
				// save
				OrganizationSetupDAO.getInstance().save(obj);
				httpSession.setAttribute("organizationSetup", obj);
				/*// redirect to running number
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				return new ActionForward(sb.toString(),true);*/
			} else {
				obj = OrganizationSetupDAO.getInstance().load(form.getLong("organizationId"));
				obj.setSetupDate(form.getCalendar("setupDate")!=null?form.getCalendar("setupDate").getTime():null);
			    obj.setNumberOfDigit(form.getInt("numberOfDigit"));
			    obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
			    obj.setUserPassHistory(form.getInt("defaultUserPassHistory"));
			    obj.setMinUserPassLength(form.getInt("defaultMinUserPassLength"));
			    obj.setTimeoutAdmin(form.getInt("timeoutAdmin"));
			    obj.setTimeoutUser(form.getInt("timeoutUser"));
			    obj.setTimeoutServer(form.getInt("timeoutServer"));
			    obj.setSodLimit(form.getInt("sodLimit"));
			    obj.setMaximumLoginAttempt(form.getInt("maxLoginAttempt"));
			    obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
				OrganizationSetupDAO.getInstance().saveOrUpdate(obj);
				
				/*// redirect to list
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);*/
			}
		}catch(Exception ex) {
			try {
				List currencyExchangeRateTypeList = LookupDAO.getInstance().getSession().createCriteria(Lookup.class).add(Restrictions.eq("Category", "CURRENCY_EXCHANGE_RATE_TYPE")).list();
				request.setAttribute("currencyExchangeRateTypeList", currencyExchangeRateTypeList);
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("list_redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
	}
	
	private ActionForward performShowImage(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		//OrganizationForm form = (OrganizationForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			long id = Long.parseLong(request.getParameter("id"));
			Organization organization = OrganizationDAO.getInstance().get(id);
			//request.setAttribute("contentType",organization.getLogoContentType());
			StringBuffer out = new StringBuffer();
			//out.append(new String(organization.getLogo(), 0, organization.getLogo().length, "ISO-8859-1"));
			request.setAttribute("image", out.toString());
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				OrganizationDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("detail");
	}
	

	/** 
	 * Method generalError
	 * @param HttpServletRequest request
	 * @param Exception ex
	 */
	private void generalError(HttpServletRequest request, Exception ex) {
		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.global",ex.getMessage()));
		saveErrors(request,errors);
	}

}