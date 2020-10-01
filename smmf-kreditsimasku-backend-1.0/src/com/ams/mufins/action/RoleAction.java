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
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.ams.mufins.model.Lookup;
import com.ams.mufins.model.Role;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.dao.LookupDAO;
import com.ams.mufins.model.dao.RoleDAO;
import com.ams.mufins.model.dao.UserLoggingDAO;
import com.ams.mufins.model.dao.ViewDAO;
import com.ams.mufins.model.View;
import com.ams.mufins.form.RoleForm;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Pager;

public class RoleAction extends Action {
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
		//RoleForm form = (Role) actionForm;
		ActionForward forward = null;
		String action = mapping.getParameter();
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Set lst = (Set)httpSession.getAttribute(CommonConstants.VIEWACCESS);
		if (users!=null) {
			if (CommonUtil.isHasRoleAccess(lst,request.getServletPath())) {
				log.info("[ START "+this.getClass().getName()+" "+action+" "+users.getUserName()+"  ] ");
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
		RoleForm form = (RoleForm) actionForm;
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
			Criteria criteria = RoleDAO.getInstance().getSession().createCriteria(Role.class);
			List role = new LinkedList();
				if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("RoleName", "%"+form.getString("name")+"%"));
				criteria.setProjection(Projections.rowCount());
				total = ((Integer)criteria.list().iterator().next()).intValue();
				// partial data
				criteria = RoleDAO.getInstance().getSession().createCriteria(Role.class);
				if (form.getString("name")!=null && form.getString("name").length()>0)criteria.add(Restrictions.ilike("RoleName", "%"+form.getString("name")+"%"));
				//criteria.addOrder(Order.desc("Id"));
				if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
				    criteria.addOrder(Order.asc(form.getString("orderBy")));
				} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
				    criteria.addOrder(Order.desc(form.getString("orderBy")));
				}else{
					criteria.addOrder(Order.asc("id"));
				}
				criteria.setFirstResult(start);
				criteria.setMaxResults(count);
				role = criteria.list();
			
			
			
			request.setAttribute("ROLE", role);
			
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
				RoleDAO.getInstance().closeSessionForReal();
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
		RoleForm form = (RoleForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			// relationships
/*			ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
			String string = prop.getString("role.group");
			StringTokenizer tokenizer = new StringTokenizer(string, ";");
			Set categories = new LinkedHashSet();
			while (tokenizer.hasMoreTokens()) {
				String string2 = tokenizer.nextToken();
				categories.add(string2);
			}
			request.setAttribute("roleGroups", categories);*/
			List lst = LookupDAO.getInstance().getSession().createCriteria(Role.class)
					.addOrder(Order.asc("Id"))
					.list();
				request.setAttribute("roleLst",lst);
			
			List roleGroupList = LookupDAO.getInstance().getSession().createCriteria(Lookup.class)
				.add(Restrictions.eq("Category", "ROLE_GROUP"))
				.list();
			request.setAttribute("roleGroupList",roleGroupList);
			if (form.getLong("roleId")==0) {
				List list = ViewDAO.getInstance().findAll(Order.asc("ParentViewName"));
				request.setAttribute("viewLst",list);
				List lst2 = new LinkedList();
				request.setAttribute("viewSltdLst",lst2);
				form.setString("roleId",0);
				request.setAttribute("roleId","0");
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT,httpSession.getAttribute(CommonConstants.COUNT));
			} else {
				Role role = RoleDAO.getInstance().get(form.getLong("roleId"));
				List lst2 = RoleDAO.getInstance().getRoleSelectedList(form.getLong("roleId"));
				List results = ViewDAO.getInstance().findAll(Order.asc("ParentViewName"));
				List list = new LinkedList();
				Iterator iterator = results.iterator();
				while (iterator.hasNext()) {
					boolean isSame = false;
					View view = (View)iterator.next();
					Iterator iterator2 = lst2.iterator();
					while (iterator2.hasNext()) {
						View view2 = (View)iterator2.next();
						if (view.getId() == view2.getId()) isSame = true;
					}
					if (!isSame) list.add(view);
				}
				request.setAttribute("viewLst",list);
				request.setAttribute("viewSltdLst",lst2);
				form.setString("roleId",role.getId());
				form.setString("name",role.getRoleName());
				// role group
				Set set = role.getRoleGroups();
				String collectionSelect[] = new String[set.size()];
				java.util.Iterator itr = set.iterator();
				for (int i=0; i<collectionSelect.length; i++) {
					Lookup roleGroup = (Lookup)itr.next();
					collectionSelect[i] = (String.valueOf(roleGroup.getId()));
				}
				form.setCollectionSelect("roleGroupId",collectionSelect);
				Set set3 = role.getParent();
				String collectionSelect3[] = new String[set3.size()];
				java.util.Iterator itr3 = set3.iterator();
				for (int i = 0; i < collectionSelect3.length; i++) {
					Role roleParent = (Role) itr3.next();
					collectionSelect3[i] = String.valueOf(role.getId());
				}
				form.setCollectionSelect("parentId", collectionSelect3);
				form.setString("description",role.getDescription());
				form.setString("isNumeric",role.isNumeric()?"Y":"N");
				form.setString("defaultUserPassDuration",role.getDefaultUserPassDuration());
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
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
		RoleForm form = (RoleForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			Role obj =null;
			if (form.getLong("roleId")==0) {
				obj = (Role)RoleDAO.getInstance().getSession().createCriteria(Role.class).add(Restrictions.eq("RoleName", form.getString("name"))).uniqueResult();
				if (obj == null) {
					obj = new Role();
					obj.setRoleName(form.getString("name"));
					// role group
					String[] roleGroupId = form.getCollectionSelect("roleGroupId");
					Set set = new LinkedHashSet();
					for (int i=0; i<roleGroupId.length; i++) {
						Lookup roleGroup = LookupDAO.getInstance().get(Long.parseLong(roleGroupId[i]));
						set.add(roleGroup);
					}
					obj.setRoleGroups(set);
					Set set2 = new LinkedHashSet();
					
					//role_parent
					String[] roleParentId = form.getCollectionSelect("parentId");
					
					Set setRoleParent  = new LinkedHashSet();
					for (int i=0; i<roleParentId.length; i++) {
						Role roleParent = RoleDAO.getInstance().get(Long.parseLong(roleParentId[i]));
						setRoleParent.add(roleParent);
					}
					obj.setParent(setRoleParent);
					
					obj.setDescription(form.getString("description"));
					List list = new java.util.LinkedList();
					String[] viewId = form.getCollectionSelect("viewSltdLstId");
					for (int i=0; i<viewId.length; i++) {
						View view = ViewDAO.getInstance().get(Long.parseLong(viewId[i]));
						list.add(view);
					}
					List orderList = new java.util.LinkedList();
					List viewList = ViewDAO.getInstance().findAll(Order.asc("Id"));
					Iterator iterator = viewList.iterator();
					while(iterator.hasNext()){
						View  allView = (View)iterator.next();
						Iterator iterator2 = list.iterator();
						while (iterator2.hasNext()){
							View selectedView = (View)iterator2.next();
							if(selectedView.equals(allView)){
								orderList.add(selectedView);
								break;
							}
						}
					}
					obj.setNumeric(form.getString("isNumeric").length()>0?true:false);
					obj.setViews(orderList);
					obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
					RoleDAO.getInstance().save(obj);
				} else {
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List list = ViewDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("viewLst",list);
					List lst2 = new LinkedList();
					request.setAttribute("viewSltdLst",lst2);
					List roleGroupList = LookupDAO.getInstance().getSession().createCriteria(Lookup.class)
						.add(Restrictions.eq("Category", "ROLE_GROUP")).list();
					request.setAttribute("roleGroupList", roleGroupList);
					///
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("name")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
			} else {
				obj = RoleDAO.getInstance().load(form.getLong("roleId"));
				obj.setRoleName(form.getString("name"));
				String[] roleGroupId = form.getCollectionSelect("roleGroupId");
				Set set = new LinkedHashSet();
				for (int i=0; i<roleGroupId.length; i++) {
					Lookup roleGroup = LookupDAO.getInstance().get(Long.parseLong(roleGroupId[i]));
					set.add(roleGroup);
				}
				obj.setRoleGroups(set);
				//
				//role_parent
				String[] roleParentId = form.getCollectionSelect("parentId");
				
				Set setRoleParent  = new LinkedHashSet();
				for (int i=0; i<roleParentId.length; i++) {
					Role roleParent = RoleDAO.getInstance().get(Long.parseLong(roleParentId[i]));
					setRoleParent.add(roleParent);
				}
				obj.setParent(setRoleParent);
				
				obj.setDescription(form.getString("description"));
				List list = new java.util.LinkedList();
				String[] viewId = form.getCollectionSelect("viewSltdLstId");
				for (int i=0; i<viewId.length; i++) {
					View view = ViewDAO.getInstance().get(Long.parseLong(viewId[i]));
					list.add(view);
				}
				List orderList = new java.util.LinkedList();
				List viewList = ViewDAO.getInstance().findAll(Order.asc("Id"));
				Iterator iterator = viewList.iterator();
				while(iterator.hasNext()){
					View  allView = (View)iterator.next();
					Iterator iterator2 = list.iterator();
					while (iterator2.hasNext()){
						View selectedView = (View)iterator2.next();
						if(selectedView.equals(allView)){
							orderList.add(selectedView);
							break;
						}
					}
				}				
				obj.setNumeric(form.getString("isNumeric").length()>0?true:false);
				obj.setDefaultUserPassDuration(form.getInt("defaultUserPassDuration"));
				obj.setViews(orderList);
				
				RoleDAO.getInstance().update(obj);
				
			}
			//load new role access
			/*
			Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
			httpSession.removeAttribute(CommonConstants.VIEWACCESS);
			java.util.Iterator iterator = users.getRoles().iterator();
			java.util.List list = new java.util.LinkedList();
			while (iterator.hasNext()) {
				Role role = (Role)iterator.next();
				list.addAll(role.getViews());
			}
			httpSession.setAttribute(CommonConstants.VIEWACCESS, list);
			*/
		}catch(Exception ex) {
			try {
				List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("roleLst",lst);
				List list = ViewDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("viewLst",list);
				List list2 = new java.util.LinkedList();
				if (form.getLong("roleId") > 0) {
					Role role = RoleDAO.getInstance().get(form.getLong("roleId"));
					list2 = role.getViews();
				}
				request.setAttribute("viewSltdLst",list2);
				List roleGroupList = LookupDAO.getInstance().getSession().createCriteria(Lookup.class)
					.add(Restrictions.eq("Category", "ROLE_GROUP")).list();
				request.setAttribute("roleGroupList", roleGroupList);
				///
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
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
		RoleForm form = (RoleForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Role obj = RoleDAO.getInstance().get(form.getLong("roleId"));
			request.setAttribute("role", obj);
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
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
		RoleForm form = (RoleForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			RoleDAO.getInstance().delete(form.getLong("roleId"));
		}catch(Exception ex) {
			try {
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
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