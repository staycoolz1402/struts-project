package com.ams.mufins.action;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.form.ViewForm;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.ams.mufins.model.ViewBlockMultiple;
import com.ams.mufins.model.ViewBlockMultipleHistory;
import com.ams.mufins.model.dao.UserLoggingDAO;
import com.ams.mufins.model.dao.ViewBlockMultipleDAO;
import com.ams.mufins.model.dao.ViewBlockMultipleHistoryDAO;
import com.ams.mufins.model.dao.ViewDAO;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Pager;

public class ViewBlockMultipleAction extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//ViewForm form = (View) actionForm;
		ActionForward forward = null;
		String action = mapping.getParameter();
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Set lst = (Set)httpSession.getAttribute(CommonConstants.VIEWACCESS);
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
				} else if ("FORM".equalsIgnoreCase(action)) {
					forward = performForm(mapping, form, request, response);
				} else if ("SAVE".equalsIgnoreCase(action)) {
					forward = performSave(mapping, form, request, response);
				} else if ("DETAIL".equalsIgnoreCase(action)) { 
					forward = performDetail(mapping, form, request, response);
				} else if ("DELETE".equalsIgnoreCase(action)) {
					forward = performDelete(mapping, form, request, response);
				} else if ("POPUPLIST".equalsIgnoreCase(action)) {
					forward = performPopUpList(mapping, form, request, response);
				}
				return forward;
			} else {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.privilage",request.getContextPath()+mapping.getPath()));
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
		ViewForm form = (ViewForm) actionForm;
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
			
			Criteria criteria = ViewBlockMultipleDAO.getInstance().getSession().createCriteria(ViewBlockMultiple.class);
			
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.or(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"), Restrictions.ilike("ViewLink", "%"+form.getString("name")+"%")));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = ViewBlockMultipleDAO.getInstance().getSession().createCriteria(ViewBlockMultiple.class);
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.or(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"), Restrictions.ilike("ViewLink", "%"+form.getString("name")+"%")));
			
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}else{
				criteria.addOrder(Order.asc("Id"));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			
			List<ViewBlockMultiple> viewBlockMultipleList = criteria.list();
			request.setAttribute("viewBlockMultipleList",viewBlockMultipleList);
			
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
				ViewBlockMultipleDAO.getInstance().closeSessionForReal();
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
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();		
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			
			if(form.getLong("viewBlockMultipleId")>0){
				ViewBlockMultiple viewBlockMultiple = ViewBlockMultipleDAO.getInstance().get(form.getLong("viewBlockMultipleId"));
				form.setString("viewId", viewBlockMultiple.getViewId());
				form.setString("viewName", viewBlockMultiple.getViewName());
				form.setString("viewLink", viewBlockMultiple.getViewLink());
				form.setString("isActive", viewBlockMultiple.isActive()?"Y":"N");
			}else{
				form.setString("viewBlockMultipleId", 0);
			}
		
		}catch(Exception ex) {
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewBlockMultipleDAO.getInstance().closeSessionForReal();
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
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction = null;
		Session session = null;
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			
			session = (Session) ViewBlockMultipleHistoryDAO.getInstance().getSession();
			transaction = session.beginTransaction();
			
			if(form.getLong("viewBlockMultipleId")==0){
				List<ViewBlockMultiple> viewBlockMultipleList = ViewBlockMultipleDAO.getInstance().getSession().createCriteria(ViewBlockMultiple.class).add(Restrictions.eq("ViewId", form.getLong("viewId"))).list();
				if(viewBlockMultipleList.size()==0){
					ViewBlockMultiple viewBlockMultiple = new ViewBlockMultiple();
					viewBlockMultiple.setViewId(form.getLong("viewId"));
					viewBlockMultiple.setActive(form.getString("isActive").length()>0?true:false);
					viewBlockMultiple.setCreateBy(users.getUserName());
					viewBlockMultiple.setCreateOn(new Date());
					ViewBlockMultipleDAO.getInstance().save(viewBlockMultiple, session);
				}else{
					ActionMessages errors = new ActionMessages();
					errors.add("errorGlobal",new ActionMessage("error.global", "View tersebut sudah pernah ditambahkan"));
					saveErrors(request,errors);
					return performForm(mapping, actionForm, request, response);
				}
				
			}else{
				ViewBlockMultiple viewBlockMultiple = ViewBlockMultipleDAO.getInstance().get(form.getLong("viewBlockMultipleId"));
				viewBlockMultiple.setViewId(form.getLong("viewId"));
				viewBlockMultiple.setActive(form.getString("isActive").length()>0?true:false);
				viewBlockMultiple.setChangeBy(users.getUserName());
				viewBlockMultiple.setChangeOn(new Date());
				ViewBlockMultipleDAO.getInstance().update(viewBlockMultiple, session);
				
				ViewBlockMultipleHistory viewBlockMultipleHistory = new ViewBlockMultipleHistory();
				viewBlockMultipleHistory.setViewId(form.getLong("viewId"));
				viewBlockMultipleHistory.setCreateBy(users.getUserName());
				viewBlockMultipleHistory.setCreateOn(new Date());
				viewBlockMultipleHistory.setChangeBy(users.getUserName());
				viewBlockMultipleHistory.setChangeOn(new Date());
				ViewBlockMultipleHistoryDAO.getInstance().save(viewBlockMultipleHistory, session);
			}
			
			transaction.commit();
			session.close();
			
		}catch(Exception ex) {
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewBlockMultipleDAO.getInstance().closeSessionForReal();
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
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			ViewBlockMultiple viewBlockMultiple = ViewBlockMultipleDAO.getInstance().get(form.getLong("viewBlockMultipleId"));
			request.setAttribute("viewBlockMultiple", viewBlockMultiple);
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewBlockMultipleDAO.getInstance().closeSessionForReal();
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
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction = null;
		Session session = null;
		try {
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			
			session = (Session) ViewBlockMultipleHistoryDAO.getInstance().getSession();
			transaction = session.beginTransaction();
			
			ViewBlockMultiple viewBlockMultiple = ViewBlockMultipleDAO.getInstance().get(form.getLong("viewBlockMultipleId"));
			
			ViewBlockMultipleHistory viewBlockMultipleHistory = new ViewBlockMultipleHistory();
			viewBlockMultipleHistory.setViewId(viewBlockMultiple.getViewId());
			viewBlockMultipleHistory.setCreateBy(users.getUserName());
			viewBlockMultipleHistory.setCreateOn(new Date());
			viewBlockMultipleHistory.setChangeBy(users.getUserName());
			viewBlockMultipleHistory.setChangeOn(new Date());
			ViewBlockMultipleHistoryDAO.getInstance().save(viewBlockMultipleHistory, session);
			
			ViewBlockMultipleDAO.getInstance().delete(viewBlockMultiple, session);
			
			transaction.commit();
			session.close();
			
		}catch(Exception ex) {
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewBlockMultipleDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list_redir");
	}
	
	private ActionForward performPopUpList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		httpSession.removeAttribute("parentId");
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
			Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class).add(Restrictions.isNotNull("Link"));
			
			List results = new LinkedList();
			if( form.getString("subaction").equalsIgnoreCase("search")) {
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.or(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"), Restrictions.ilike("Link", "%"+form.getString("name")+"%")));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			
			// partial data
			criteria = ViewDAO.getInstance().getSession().createCriteria(View.class).add(Restrictions.isNotNull("Link"));
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.or(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"), Restrictions.ilike("Link", "%"+form.getString("name")+"%")));
			
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}else{
				criteria.addOrder(Order.asc("Id"));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			results = criteria.list();
			}
			else{
				results = null;
				total=0;
				request.removeAttribute("RESULT");
			}
			request.setAttribute("RESULT",results);
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
				ViewDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list");
	}
			
	/** 
	 * Method generalError
	 * @param HttpServletRequest request
	 * @param Exception ex
	 */
	private void generalError(HttpServletRequest request, Exception ex) {
		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.global",ex.getMessage()));
		saveErrors(request,errors);
	}

}