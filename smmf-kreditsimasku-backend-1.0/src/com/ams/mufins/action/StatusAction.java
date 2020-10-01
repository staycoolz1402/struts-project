
package com.ams.mufins.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.criterion.*;

import com.ams.mufins.model.*;
import com.ams.mufins.model.dao.*;
import com.ams.mufins.form.*;

import java.util.*;

import com.mpe.common.*;

public class StatusAction extends Action {
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
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
		throws Exception {
		//StatusForm statusForm = (StatusForm) form;
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
					UserLoggingDAO.getInstance().save(users, request, setIp, lst);
					/* end log */
					if ("".equalsIgnoreCase(action)) {
						forward = mapping.findForward("home");
					} else if ("LIST".equalsIgnoreCase(action)) {
						forward = performList(mapping, form, request, response);
					} else if ("CREATE".equalsIgnoreCase(action)) {
						forward = performCreate(mapping, form, request, response);
					} else if ("INSERT".equalsIgnoreCase(action)) {
						forward = performInsert(mapping, form, request, response);
					} else if ("EDIT".equalsIgnoreCase(action)) {
						forward = performEdit(mapping, form, request, response);
					} else if ("UPDATE".equalsIgnoreCase(action)) {
						forward = performUpdate(mapping, form, request, response);
					} else if ("DETAIL".equalsIgnoreCase(action)) { 
						forward = performDetail(mapping, form, request, response);
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
	private ActionForward performList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		StatusForm form = (StatusForm) actionForm;
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
			Criteria criteria = StatusDAO.getInstance().getSession().createCriteria(Status.class);
			if (form.getString("type")!=null && form.getString("type").length()>0)criteria.add(Restrictions.ilike("Type", form.getString("type"), MatchMode.ANYWHERE));
			if (form.getString("code")!=null && form.getString("code").length()>0)criteria.add(Restrictions.ilike("Code", form.getString("code"), MatchMode.ANYWHERE));
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.ANYWHERE));
			if (form.getString("description")!=null && form.getString("description").length()>0)criteria.add(Restrictions.ilike("Description", form.getString("description"), MatchMode.ANYWHERE));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = StatusDAO.getInstance().getSession().createCriteria(Status.class);
			if (form.getString("type")!=null && form.getString("type").length()>0)criteria.add(Restrictions.ilike("Type", form.getString("type"), MatchMode.ANYWHERE));
			if (form.getString("code")!=null && form.getString("code").length()>0)criteria.add(Restrictions.ilike("Code", form.getString("code"), MatchMode.ANYWHERE));
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.ANYWHERE));
			if (form.getString("description")!=null && form.getString("description").length()>0)criteria.add(Restrictions.ilike("Description", form.getString("description"), MatchMode.ANYWHERE));
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}else{
				criteria.addOrder(Order.asc("Id"));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			List statusList = criteria.list();
			request.setAttribute("statusList",statusList);
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);
			httpSession.removeAttribute("status");
		}catch(Exception ex){
			ex.printStackTrace();
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list");
	}
	
		/** 
	 * Method performCreate
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */			
	private ActionForward performCreate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		StatusForm form = (StatusForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Status status = (Status)httpSession.getAttribute("status");
			// relationships
			ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
			String string = prop.getString("status.type");
			StringTokenizer tokenizer = new StringTokenizer(string, ";");
			Set categories = new LinkedHashSet();
			while (tokenizer.hasMoreTokens()) {
				String string2 = tokenizer.nextToken();
				categories.add(string2);
			}
			request.setAttribute("statusTypes", categories);
			// form
			if (form.getLong("statusId") == 0) {
				form.setString("statusId",0);
				form.setCurentTimestamp("createOn");
				if (status!=null) {
					form.setString("statusId",status.getId());
					form.setString("type",status.getType());
					form.setString("code",status.getCode());
					form.setString("name",status.getName());
					form.setString("description",status.getDescription());
				}
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT,httpSession.getAttribute(CommonConstants.COUNT));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return mapping.findForward("create");
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("create");
	}
	
	/** 
	 * Method performInsert
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performInsert(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		StatusForm form = (StatusForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
				httpSession.removeAttribute("status");
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			Status status = (Status)httpSession.getAttribute("status");
			if (form.getLong("statusId") == 0) {
				status = (Status)StatusDAO.getInstance().getSession().createCriteria(Status.class)
					.add(Restrictions.eq("Type", form.getString("type")))
					.add(Restrictions.ilike("Code", form.getString("code"), MatchMode.EXACT))
					.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.EXACT))
					.uniqueResult();
				if (status==null) {
					status = (Status)httpSession.getAttribute("status");
					if (status==null) status = new Status();
					status.setType(form.getString("type"));
					status.setCode(form.getString("code"));
					status.setName(form.getString("name"));
					status.setDescription(form.getString("description"));
					StatusDAO.getInstance().save(status);
					form.setString("statusId", status.getId());
				} else {
					ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
					String string = prop.getString("status.type");
					StringTokenizer tokenizer = new StringTokenizer(string, ";");
					Set categories = new LinkedHashSet();
					while (tokenizer.hasMoreTokens()) {
						String string2 = tokenizer.nextToken();
						categories.add(string2);
					}
					request.setAttribute("statusTypes", categories);
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("name")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			try {
				ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
				String string = prop.getString("status.type");
				StringTokenizer tokenizer = new StringTokenizer(string, ";");
				Set categories = new LinkedHashSet();
				while (tokenizer.hasMoreTokens()) {
					String string2 = tokenizer.nextToken();
					categories.add(string2);
				}
				request.setAttribute("statusTypes", categories);
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("list_redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
	}	

	/** 
	 * Method performEdit
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */			
	private ActionForward performEdit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		StatusForm form = (StatusForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Status status = (Status)httpSession.getAttribute("status");
			//
			// relationships
			ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
			String string = prop.getString("status.type");
			StringTokenizer tokenizer = new StringTokenizer(string, ";");
			Set categories = new LinkedHashSet();
			while (tokenizer.hasMoreTokens()) {
				String string2 = tokenizer.nextToken();
				categories.add(string2);
			}
			request.setAttribute("statusTypes", categories);
			// edit
			if (form.getLong("statusId") > 0) {
				if (status==null) {
					status = StatusDAO.getInstance().get(form.getLong("statusId"));
					httpSession.setAttribute("status",status);
				}
				form.setString("statusId",status.getId());
				form.setString("type",status.getType());
				form.setString("code",status.getCode());
				form.setString("name",status.getName());
				form.setString("description",status.getDescription());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return mapping.findForward("edit");
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("edit");
	}
	
	/** 
	 * Method performUpdate
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performUpdate(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		StatusForm form = (StatusForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
				httpSession.removeAttribute("status");
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			//
			Status status = (Status)httpSession.getAttribute("status");
			//if (status==null) status = new Status();
			if (form.getLong("statusId") > 0) {
				Status obj = (Status)StatusDAO.getInstance().getSession().createCriteria(Status.class)
						.add(Restrictions.eq("Type", form.getString("type")))
						.add(Restrictions.ilike("Code", form.getString("code"), MatchMode.EXACT))
						.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.EXACT))
						.add(Restrictions.ne("Id", form.getLong("statusId")))
						.uniqueResult();
				
				if(obj!=null) {
					ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
					String string = prop.getString("status.type");
					StringTokenizer tokenizer = new StringTokenizer(string, ";");
					Set categories = new LinkedHashSet();
					while (tokenizer.hasMoreTokens()) {
						String string2 = tokenizer.nextToken();
						categories.add(string2);
					}
					request.setAttribute("statusTypes", categories);
					
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("name")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				} else {
					if (status==null) status = StatusDAO.getInstance().get(form.getLong("statusId"));
					status.setType(form.getString("type"));
					status.setCode(form.getString("code"));
					status.setName(form.getString("name"));
					status.setDescription(form.getString("description"));
					status.setId(form.getLong("statusId"));
					
					StatusDAO.getInstance().update(status);
				}
				
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			try {
				ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
				String string = prop.getString("status.type");
				StringTokenizer tokenizer = new StringTokenizer(string, ";");
				Set categories = new LinkedHashSet();
				while (tokenizer.hasMoreTokens()) {
					String string2 = tokenizer.nextToken();
					categories.add(string2);
				}
				request.setAttribute("statusTypes", categories);
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("list_redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
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
		StatusForm form = (StatusForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Status status = StatusDAO.getInstance().get(form.getLong("statusId"));
			request.setAttribute("status", status);
		} catch(Exception ex) {
			ex.printStackTrace();
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				StatusDAO.getInstance().closeSessionForReal();
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