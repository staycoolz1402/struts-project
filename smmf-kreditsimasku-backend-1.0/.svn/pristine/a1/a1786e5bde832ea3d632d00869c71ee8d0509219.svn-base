package com.ams.mufins.action;

import java.util.Date;
import java.util.LinkedList;
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
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.form.ViewForm;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.ams.mufins.model.dao.UserLoggingDAO;
import com.ams.mufins.model.dao.ViewDAO;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Pager;

public class ViewAction extends Action {
	Log log = LogFactory.getFactory().getInstance(this.getClass());
	
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
					forward = performPartialList(mapping, form, request, response);
				} else if ("FORM".equalsIgnoreCase(action)) {
					forward = performForm(mapping, form, request, response);
				} else if ("SAVE".equalsIgnoreCase(action)) {
					forward = performSave(mapping, form, request, response);
				} else if ("DETAIL".equalsIgnoreCase(action)) { 
					forward = performDetail(mapping, form, request, response);
				} else if ("DELETE".equalsIgnoreCase(action)) {
					forward = performDelete(mapping, form, request, response);
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
	private ActionForward performPartialList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		ViewForm form = (ViewForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		 /**begin new entry by:Indarto %@20070622*/
		httpSession.removeAttribute("parentId");
		/**end new entry*/
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
			Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
			
			List results = new LinkedList();
			if( form.getString("subaction").equalsIgnoreCase("search")) {
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
			if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("ViewName", "%"+form.getString("name")+"%"));
			//criteria.addOrder(Order.desc("ViewName"));
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
			// relationships
			Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
			criteria.add(Expression.isNull("Parent"));
			request.setAttribute("viewLst", criteria.list());
			
			/**begin new entry by:indarto @20070619*/			
			//Long id = (Long)httpSession.getAttribute("parentId");
			String id = (String)httpSession.getAttribute("parentId");	
			httpSession.removeAttribute("parentId");
			if( id != null) {
				/*Criteria criteria1 = ViewDAO.getInstance().getSession().createCriteria(View.class);
				criteria.add(Expression.eq("Id", id ));
				criteria.add(Expression.eq("View", new Boolean(true)));
				request.setAttribute("subParentList", criteria1.list());*/
				List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
				.add(Restrictions.eq("Parent.Id", new Long(id)))
				.add(Restrictions.eq("View", new Boolean(true)))
				.list();
				httpSession.setAttribute("subParentList", list);
				ViewForm view = (ViewForm)httpSession.getAttribute("viewForm");
				if(view!=null) {
					form.setString("viewId", view.getString("viewId"));
					form.setString("parentId", view.getString("parentId"));
					form.setString("name", view.getString("name"));
					form.setString("path", view.getString("path"));
					form.setString("description", view.getString("description"));
					form.setString("isView", view.getString("isView"));
				}
			}else{
				List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
				.add(Restrictions.eq("Parent.Id", new Long(0)))
				.add(Restrictions.eq("View", new Boolean(true)))
				.list();
				httpSession.setAttribute("subParentList", list);				
			}
			/**end entry */
			
			if (form.getLong("viewId")==0) {
				form.setString("viewId",0);
				request.setAttribute("viewId","0");
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT, httpSession.getAttribute(CommonConstants.COUNT));				
				
				//edit
			} else {
				View view = ViewDAO.getInstance().get(form.getLong("viewId"));
				form.setString("viewId",view.getId());
				form.setString("description",view.getDescription());
				form.setString("isView",view.isView()?"Y":"N");
				form.setString("name",view.getViewName());
				//form.setString("parentId",view.getParent()!=null?view.getParent().getId():0);
				
					/**begin new entry by:indarto @20070620*/
				if( view.getParent()==null ) {//not have parent or null 
					form.setString("parentId", 0);
				} else {
					View temp = ViewDAO.getInstance().get(view.getParent().getId()); //check the id is a sub parent or parent
					if( temp.getParent() == null) { //no sub parent, the value is a parent
						form.setString("parentId", view.getParent().getId()); //or temp.getId()
						List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
						.add( Restrictions.eq( "Parent.Id", new Long( view.getParent().getId() ) ) ) 
						.add( Restrictions.eq( "View", new Boolean( true ) ) )
						.list();
						httpSession.setAttribute("subParentList", list);
					} else { //the value is a sub parent, search the record of parent					
						List list = new LinkedList();												
						//form.setString("parentId", temp.getId());
						if( id == null ) {
							//set the list of subParentList
							list = ViewDAO.getInstance().getSession().createCriteria(View.class)
								.add( Restrictions.eq( "Parent.Id", new Long( temp.getParent().getId() ) ) ) 
								.add( Restrictions.eq( "View", new Boolean( true ) ) )
								.list();
							//set the value of parent
							form.setString("parentId", view.getParent().getParent().getId());
							//set the value of sub parent
							form.setString("subParentId", view.getParent().getId()); //or temp.getId(), the value is same
						}
						else {
							form.setString("parentId", id);
							//set the list of subParentList
							list = ViewDAO.getInstance().getSession().createCriteria(View.class)
								.add( Restrictions.eq( "Parent.Id", new Long( id ) ) ) 
								.add( Restrictions.eq( "View", new Boolean( true ) ) )
								.list();							
							id = null;
						}
						httpSession.setAttribute("subParentList", list);
					}
					
				}
					/**end entry */
				
				form.setString("path",view.getLink());
			}
		
		}catch(Exception ex) {
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewDAO.getInstance().closeSessionForReal();
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
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			/**begin new entry by:indarto @20070619*/
			if( form.getString( "subaction" ).equalsIgnoreCase( "parentChange" ) ){
				ActionForward forward = mapping.findForward("form_redir");
				httpSession.setAttribute("parentId", form.getString("parentId"));
				httpSession.setAttribute("viewForm", form);
				//ViewForm test = (ViewForm) httpSession.getAttribute("viewForm");
				return forward;
			}
			/**end entry*/
			
			View view = null;
			if (form.getLong("viewId")==0) {
				view = (View)ViewDAO.getInstance().getSession().createCriteria(View.class).add(Restrictions.ilike("ViewName", form.getString("name"), MatchMode.EXACT)).uniqueResult();
				
				if (view == null) {
					if(view == null) view = new View();
					view.setViewName(form.getString("name"));
					/**begin new entry by:indarto @20070619*/
					View parent;
					if( form.getLong("subParentId") > 0 ) {
						parent = ViewDAO.getInstance().get(form.getLong("subParentId"));
					} else {
						parent = ViewDAO.getInstance().get(form.getLong("parentId"));
					}
						/**end new entry*/
					//View parent = ViewDAO.getInstance().get(form.getLong("parentId"));
					view.setParent(parent);
					view.setLink(form.getString("path"));
					view.setView(form.getString("isView").length()>0?true:false);
					view.setDescription(form.getString("description"));
					view.setCreateBy(users.getUserName()); 
					view.setCreateOn(new Date());
					ViewDAO.getInstance().save(view);
				} else {
					Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
					criteria.add(Expression.isNull("Parent"));
					request.setAttribute("viewLst", criteria.list());
					
					List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
							.add(Restrictions.eq("Parent.Id", new Long(0)))
							.add(Restrictions.eq("View", new Boolean(true)))
							.list();
					httpSession.setAttribute("subParentList", list);		
					
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("name")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
				
			} else {
				view = ViewDAO.getInstance().get(form.getLong("viewId"));
				
				int child = 0;
				String sqlCekChild = "select count(1) as A from views where parent_id = :parentId ";
				try {
					child = (Integer)ViewDAO.getInstance().getSession().createSQLQuery(sqlCekChild).addScalar("A", Hibernate.INTEGER).setLong("parentId", form.getLong("viewId")).uniqueResult();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (child > 0) {
					Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
					criteria.add(Expression.isNull("Parent"));
					request.setAttribute("viewLst", criteria.list());
					
					List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
							.add(Restrictions.eq("Parent.Id", new Long(0)))
							.add(Restrictions.eq("View", new Boolean(true)))
							.list();
					httpSession.setAttribute("subParentList", list);		
					
					ActionMessages errors = new ActionMessages();
					errors.add("errorView", new ActionMessage("error.editChild", view.getViewName()));
					saveErrors(request, errors);
					return (new ActionForward(mapping.getInput()));
				} else {
					int count=0;
					String cek = "select " +
							"count(1) as X " +
							"from views " +
							"where lower(view_name) = :viewName and view_id <> :id " ;
					
					count = ((Integer)ViewDAO.getInstance().getSession().createSQLQuery(cek)
							.addScalar("X", Hibernate.INTEGER)
							.setLong("id", form.getLong("viewId"))
							.setString("viewName", form.getString("name").toLowerCase())
							.setMaxResults(1).uniqueResult()).intValue();
					
					if(count!=0){
						Criteria criteria = ViewDAO.getInstance().getSession().createCriteria(View.class);
						criteria.add(Expression.isNull("Parent"));
						request.setAttribute("viewLst", criteria.list());
						
						List list = ViewDAO.getInstance().getSession().createCriteria(View.class)
								.add(Restrictions.eq("Parent.Id", new Long(0)))
								.add(Restrictions.eq("View", new Boolean(true)))
								.list();
								httpSession.setAttribute("subParentList", list);		
						
						ActionMessages errors = new ActionMessages();
						errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("name")));
						saveErrors(request,errors);
						return new ActionForward("/view/form.do");
					} else {
						view = ViewDAO.getInstance().load(form.getLong("viewId"), ViewDAO.getInstance().getSession());
						view.setViewName(form.getString("name"));
						
						View parent;
						if( form.getLong("subParentId") > 0 ) {
							parent = ViewDAO.getInstance().get(form.getLong("subParentId"));
						} else {
							parent = ViewDAO.getInstance().get(form.getLong("parentId"));
						}
						view.setParent(parent);
						view.setLink(form.getString("path"));
						view.setView(form.getString("isView").length()>0?true:false);
						view.setDescription(form.getString("description"));
						view.setChangeBy(users.getUserName());
						view.setChangeOn(new Date());
						ViewDAO.getInstance().update(view);
					}
				}
			}
				/**begin new entry by:indarto @20070619*/
			httpSession.removeAttribute("parentId");
			httpSession.removeAttribute("viewForm");
				/**end new entry*/
		}catch(Exception ex) {
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewDAO.getInstance().closeSessionForReal();
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
			View obj = ViewDAO.getInstance().get(form.getLong("viewId"));
			request.setAttribute("view", obj);
				/**begin new entry by:indarto @20070620*/
			if( obj.getParent()==null ) { //not have parent or null 
				//form.setString("parentId", 0);
				request.setAttribute("parentName", "");
				request.setAttribute("subParentName", "");
			}else {
				View temp = ViewDAO.getInstance().get(obj.getParent().getId()); //check the id is a sub parent or parent
				if( temp.getParent() == null) { //no sub parent, the value is a parent
					//form.setString("parentId", obj.getParent().getId()); //or temp.getId()
					request.setAttribute("parentName", obj.getParent().getViewName());
					request.setAttribute("subParentName", "");
				} else { //the value is a sub parent, search the record of parent
					//set the list of subParentList
					//form.setString("subParentId", obj.getParent().getId()); //or temp.getId(), the value is same
					request.setAttribute("subParentName", obj.getParent().getViewName());
					//form.setString("parentId", obj.getParent().getParent().getId());
					request.setAttribute("parentName", obj.getParent().getParent().getViewName());
				}
			}
				/**end new entry*/
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewDAO.getInstance().closeSessionForReal();
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
		try {
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			View view = ViewDAO.getInstance().get(form.getLong("viewId"));
			ActionMessages errors = new ActionMessages();
			
			int roleView = 0, child = 0;
			String sqlCekRoleView = "select count(1) as A from role_view where view_id = :id ";
			String sqlCekChild = "select count(1) as A from views where parent_id = :parentId ";
			try {
				roleView = (Integer)ViewDAO.getInstance().getSession().createSQLQuery(sqlCekRoleView).addScalar("A", Hibernate.INTEGER).setLong("id", form.getLong("viewId")).uniqueResult();
				child = (Integer)ViewDAO.getInstance().getSession().createSQLQuery(sqlCekChild).addScalar("A", Hibernate.INTEGER).setLong("parentId", form.getLong("viewId")).uniqueResult();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (roleView > 0) {
				errors.add("roleView", new ActionMessage("error.global", "Terdapat Role yang terhubung dengan View!!!"));
			}
			
			if (child > 0) {
				errors.add("child", new ActionMessage("error.global", "Masih ada View yang terhubung dengan Parent View " +view.getViewName()+ " !!!"));
			}
			
			if (errors.size() > 0) {
				request.setAttribute("view", view);
				
				saveErrors(request, errors);
				return mapping.getInputForward();
			} else {
				ViewDAO.getInstance().delete(form.getLong("viewId"));
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
			generalError(request,ex);
			return performDetail(mapping, actionForm, request, response);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				ViewDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("list_redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
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