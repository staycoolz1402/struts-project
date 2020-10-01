package com.ams.mufins.action;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.ams.mufins.form.UserForm;
import com.ams.mufins.model.Organization;
import com.ams.mufins.model.OrganizationSetup;
import com.ams.mufins.model.Role;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.ams.mufins.model.dao.OrganizationDAO;
import com.ams.mufins.model.dao.OrganizationSetupDAO;
import com.ams.mufins.model.dao.RoleDAO;
import com.ams.mufins.model.dao.UserPasswordHistoryDAO;
import com.ams.mufins.model.dao.UsersDAO;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Formater;
import com.mpe.common.Pager;

public class UserAction extends Action {
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
	@SuppressWarnings("rawtypes")
	public ActionForward execute(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response)
		throws Exception {
		ActionForward forward = null;
		String action = mapping.getParameter();
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Set lst = (Set)httpSession.getAttribute(CommonConstants.VIEWACCESS);
		/* testing */
		/*users = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.eq("UserName", "admin")).uniqueResult();
		lst = users.getViewAccess();
		httpSession.setAttribute(CommonConstants.USER, users);
		httpSession.setAttribute(CommonConstants.VIEWACCESS, lst);*/
		/* testing */
		if (users!=null) {
			if (CommonUtil.isHasRoleAccess(lst,request.getServletPath())) {
				log.info("[ START "+this.getClass().getName()+" "+action+" "+users.getUserName()+"  ] ");
				request.setAttribute("viewName", CommonUtil.getViewName(lst, request.getServletPath()));
				if ("".equalsIgnoreCase(action)) {
					forward = mapping.findForward("home");
				} else if ("HOME".equalsIgnoreCase(action)) {
					forward = performHome(mapping, form, request, response);
				} else if ("LIST".equalsIgnoreCase(action)) {
					forward = performPartialList(mapping, form, request, response);
				} else if ("FORM".equalsIgnoreCase(action)) {
					forward = performForm(mapping, form, request, response);
				} else if ("SAVE".equalsIgnoreCase(action)) {
					forward = performSave(mapping, form, request, response);
				} else if ("DETAIL".equalsIgnoreCase(action)) { 
					forward = performDetail(mapping, form, request, response);
				} else if ("CHECKLISTMARKETING".equalsIgnoreCase(action)) { 
					forward = performChecklistMarketing(mapping, form, request, response);
				} else if ("SALESMAINTAINANCE".equalsIgnoreCase(action)) {
					forward = performSalesMaintainance(mapping, form, request, response);
				} else if ("CHANGEPASSWORD".equalsIgnoreCase(action)) {
					forward = performChangePassword(mapping, form, request, response);
				} else if ("CHANGEPASSWORDSAVE".equalsIgnoreCase(action)) {
					forward = performChangePasswordSave(mapping, form, request, response);
				} else if ("MARKETINGLIST".equalsIgnoreCase(action)) {
					forward = performMarketingList(mapping, form, request, response);
				} else if ("MARKETINGFORM".equalsIgnoreCase(action)) {
					forward = performMarketingForm(mapping, form, request, response);
				} else if ("MARKETINGSAVE".equalsIgnoreCase(action)) {
					forward = performMarketingSave(mapping, form, request, response);
				} else if ("MARKETINGDETAIL".equalsIgnoreCase(action)) { 
					forward = performMarketingDetail(mapping, form, request, response);
				} else if ("PGSQL_FORM".equalsIgnoreCase(action)) {
					forward = performPgsqlForm(mapping, form, request, response);
				} else if ("PGSQL_CONFIRM".equalsIgnoreCase(action)) {
					forward = performPgsqlConfirm(mapping, form, request, response);
				} else if("RESET_LOGIN_ATTEMPT".equalsIgnoreCase(action)) {
					forward = performResetLoginAttempt(mapping, form, request, response);
				} else if("PASSWORD_FORM".equalsIgnoreCase(action)) {
					forward = performPasswordForm(mapping, form, request, response);
				} else if("PASSWORD_SAVE".equalsIgnoreCase(action)) {
					forward = performPasswordSave(mapping, form, request, response);
				}

				return forward;
			} else {
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.privilage",request.getContextPath()+mapping.getPath()));
				saveErrors(request,errors);
				return mapping.findForward("index");
				//return mapping.findForward("home");
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
		UserForm form = (UserForm) actionForm;
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
			Criteria criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
			List results = new LinkedList();
			
			if (form.getString("userName")!=null && form.getString("userName").length()>0)criteria.add(Restrictions.ilike("UserName", "%"+form.getString("userName")+"%"));
			if (!users.getUserName().equalsIgnoreCase("admin")) criteria.add(Restrictions.not(Restrictions.eq("Id", new Long(1))));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
			if (form.getString("userName")!=null && form.getString("userName").length()>0)criteria.add(Restrictions.ilike("UserName", "%"+form.getString("userName")+"%"));
			if (!users.getUserName().equalsIgnoreCase("admin")) criteria.add(Restrictions.not(Restrictions.eq("Id", new Long(1))));
			if (form.getString("isActive").equalsIgnoreCase("1")){
				criteria.add(Restrictions.eq("Active", true));
			}else if (form.getString("isActive").equalsIgnoreCase("2")){
				criteria.add(Restrictions.eq("Active", false));
			}
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}else{
				criteria.addOrder(Order.asc("id"));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			results = criteria.list();
			
			request.setAttribute("USER",results);			
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);
			request.setAttribute("userRole", users.getRoleName());
		}catch(Exception ex){
			log.error("Unhandle Exception", ex);
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
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
	private ActionForward performPasswordForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try{
			Users obj = UsersDAO.getInstance().get(form.getLong("userId"));
			form.setString("userId",obj.getId());

			request.setAttribute("userName", obj.getUserName());
		}catch(Exception ex){
			log.error("Unhandle Exception ", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("passForm");
	}
	private ActionForward performPasswordSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction = null;
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			if(form.getLong("userId")>0){
				Session session = UsersDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				Users obj = UsersDAO.getInstance().load(form.getLong("userId"));
				if(form.getString("passwordnya").length() > 0){
				   if(form.getString("passwordnya").equalsIgnoreCase(form.getString("confirmUserPass"))){
				    obj.setUserPass(CommonUtil.digest(form.getString("passwordnya")));
					obj.setLastLoginTime(null);
					UsersDAO.getInstance().update(users);
					transaction.commit();
						
				   }else{
						// redirect error page
						ActionMessages errors = new ActionMessages();
						errors.add("errorEqual", new ActionMessage("error.equal", ""));
						saveErrors(request, errors);
						return performPasswordForm(mapping, actionForm, request, response);
				   }
				}else{
					// redirect error page
					ActionMessages errors = new ActionMessages();
					errors.add("error", new ActionMessage("errors.notFound", "User Password "));
					saveErrors(request, errors);
					return performPasswordForm(mapping, actionForm, request, response);
				}
				
			}
		}catch(Exception ex){
			log.error("Unhandle Exception ", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		ActionForward forward = mapping.findForward("redir");
		StringBuffer sb = new StringBuffer(forward.getPath());
		sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
		return new ActionForward(sb.toString(),true);
	}
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private ActionForward performForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			List<Role> lst = null;
			
			// relationships
			List organizationLst = OrganizationDAO.getInstance().findAll();
			request.setAttribute("organizationLst", organizationLst);
			
			if (form.getLong("userId")==0) {
				
				Criteria criteria = RoleDAO.getInstance().getSession().createCriteria(Role.class)
						.add(Restrictions.ne("RoleName", "AP"))
						.add(Restrictions.ne("RoleName", "BP"))
						.add(Restrictions.ne("RoleName", "SAS"))
						.add(Restrictions.ne("RoleName", "SAS CANVASSER"))
						.add(Restrictions.ne("RoleName", "MAS"))
						.add(Restrictions.ne("RoleName", "MARKETING_INHOUSE"))
						.add(Restrictions.ne("RoleName", "MARKETING"));
				
				if(!users.getRole("admin"))criteria.add(Restrictions.ne("RoleName", "BRANCH_MANAGER_MOTOR"));
				
				lst =  criteria.list();
				form.setString("userId",0);
				form.setString("isActive", "Y");
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT, httpSession.getAttribute(CommonConstants.COUNT));
			} else {
				lst =  RoleDAO.getInstance().getSession().createCriteria(Role.class).list();
				if(!users.isCheck(users, form.getString("userName"))){
					ActionMessages errors = new ActionMessages();
					errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.privilage",request.getContextPath()+mapping.getPath()));
					saveErrors(request,errors);
					return mapping.findForward("home");
				}
				Users obj = UsersDAO.getInstance().get(form.getLong("userId"));
				if(obj.getRoleName().equalsIgnoreCase("AP")||obj.getRoleName().equalsIgnoreCase("BP")||obj.getRoleName().equalsIgnoreCase("SAS")||obj.getRoleName().equalsIgnoreCase("SAS CANVASSER")||obj.getRoleName().equalsIgnoreCase("MAS")||obj.getRoleName().equalsIgnoreCase("BRANCH_MANAGER_MOTOR")||obj.getRoleName().equalsIgnoreCase("MARKETING")){
					lst =  RoleDAO.getInstance().getSession().createCriteria(Role.class).add(Restrictions.eq("RoleName", obj.getRoleName())).list();
				}
				
				form.setString("userId",obj.getId());
				Set set = obj.getRoles();
				String collectionSelect[] = new String[set.size()];
				java.util.Iterator itr = set.iterator();
				for (int i=0; i<collectionSelect.length; i++) {
					Role role = (Role)itr.next();
					collectionSelect[i] = (String.valueOf(role.getId()));
				}
				// more than 5 ==> look javascript validation
				form.setString("name", obj.getName());
				form.setString("userPass","123456");
				form.setCollectionSelect("roleId",collectionSelect);
				form.setString("isActive",obj.isActive()?"Y":"N");
//				form.setString("isSso",obj.isSso()?"Y":"N");
//				form.setString("isSupervisor",obj.isSupervisor()?"Y":"N");
				form.setString("userName",obj.getUserName());
				form.setString("email",obj.getEmail());
				form.setString("userType",obj.getUserType());
				form.setString("organizationId", obj.getOrganizationId());
				//session request utk user cabang dan helpdesk u/ disable selain password
				
			}
			
			request.setAttribute("roleLst",lst);
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
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
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private ActionForward performSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		String cekString = form.getString("userName");
		Transaction transaction = null;
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			
			String[] roleId = form.getCollectionSelect("roleId");
			Set set = new LinkedHashSet();
			
			String regex = "^[a-zA-Z0-9.]+$";
			String name = form.getString("userName");
			
			Pattern r = Pattern.compile(regex);
			Matcher m = r.matcher(name);
			
			if(name.length()<1){
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.invalid.data","Please enter something."));
				saveErrors(request,errors);	
				List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("roleLst",lst);
				List organizationLst = OrganizationDAO.getInstance().findAll();
				request.setAttribute("organizationLst", organizationLst);
				return mapping.getInputForward();
			}else if(!m.matches()){
				ActionMessages errors = new ActionMessages();
				errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.invalid.data","maaf karakter berikut @ $ % ^ & * # , ( ) [ ] \\ { + } ` ~ =  | - _ dan SPASI tidak boleh digunakan!"));
				saveErrors(request,errors);		
				List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("roleLst",lst);
				List organizationLst = OrganizationDAO.getInstance().findAll();
				request.setAttribute("organizationLst", organizationLst);
				return mapping.getInputForward();
			}
			
			if (form.getLong("userId")==0) {
				Session session = UsersDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				
				Users obj = (Users)UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.ilike("UserName", cekString.toLowerCase(), MatchMode.EXACT)).uniqueResult();
				//cek duplikasi penambahan user
				if (obj==null) {
					obj = new Users();
					obj.setName(form.getString("name"));
					obj.setUserName(cekString.toLowerCase());
					obj.setUserPass(CommonUtil.digest(form.getString("userPass")));
					obj.setActive(form.getString("isActive").length()>0?true:false);
					obj.setUserType(form.getString("userType"));
					obj.setEmail(form.getString("email"));
					obj.setOrganizationId(form.getLong("organizationId"));
					obj.setCreateBy(users.getUserName());
					obj.setLoginAttemptCounter(0);
					obj.setCreateOn(new Date());
					// role
					for (int i=0; i<roleId.length; i++) {
						Role role = RoleDAO.getInstance().get(Long.parseLong(roleId[i]));
						set.add(role);
					}
					//obj.setLogin(false);
					obj.setRoles(set);
				
					UsersDAO.getInstance().save(obj,session);
					
				} else {
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("userName")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
			}
			else {
				Session session = UsersDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				
				Users obj = UsersDAO.getInstance().load(form.getLong("userId"));
				if(obj.isActive() && form.getString("isResign").equalsIgnoreCase("true") && users.getRole("admin")){//dari awalnya aktif mau di nonaktifin kalo udh resign
					obj.setActive(false);
				}else if(!obj.isActive() && form.getString("isResign").equalsIgnoreCase("true")){//kalo uda ga aktif n status resign tp mw di aktifin lagi
					ActionMessages errors = new ActionMessages();
					errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.resign.user",request.getContextPath()+mapping.getPath()));
					saveErrors(request,errors);
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					form.setString("isActive",obj.isActive()?"Y":"N");
//					form.setString("isSso",obj.isSso()?"Y":"N");
//					form.setString("isSupervisor",obj.isSupervisor()?"Y":"N");
					if(!users.getRole("admin")) request.setAttribute("disable", "disable");
					return (new ActionForward(mapping.getInput()));
				}else if(form.getString("isResign").equalsIgnoreCase("false") && users.getRole("admin")){
					obj.setActive(form.getString("isActive").length()>0?true:false);
				}
				if (form.getString("confirmUserPass").length()>0) obj.setUserPass(CommonUtil.digest(form.getString("confirmUserPass")));
				String dummyName =obj.getName();
				obj.setName(form.getString("name"));
				obj.setEmail(form.getString("email"));
				Boolean dummyIsActive = obj.isActive();
				Boolean formIsActive = form.getString("isActive").length()>0?true:false;
				if (!users.getRole("helpdesk")){
					obj.setName(form.getString("name"));
					obj.setActive(form.getString("isActive").length()>0?true:false);
					obj.setUserType(form.getString("userType"));
					obj.setEmail(form.getString("email"));
					obj.setOrganizationId(form.getLong("organizationId"));
					obj.setChangeBy(users.getUserName());
					obj.setChangeOn(new Date());
					// role
					for (int i=0; i<roleId.length; i++) {
						Role role = RoleDAO.getInstance().get(Long.parseLong(roleId[i]));
						set.add(role);
					}
					obj.setRoles(set);
				}
				
				if((form.getString("isActive").equalsIgnoreCase("Y") || obj.isActive()) && form.getString("isResign").equalsIgnoreCase("true")){
					ActionMessages errors = new ActionMessages();
					errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.resign.user",request.getContextPath()+mapping.getPath()));
					saveErrors(request,errors);
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					form.setString("isActive",obj.isActive()?"Y":"N");
					if(!users.getRole("admin")) request.setAttribute("disable", "disable");
					return (new ActionForward(mapping.getInput()));
				}else UsersDAO.getInstance().update(obj,session);
			}
			transaction.commit();
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
			try {
				List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("roleLst",lst);
				List organizationLst = OrganizationDAO.getInstance().findAll();
				request.setAttribute("organizationLst", organizationLst);
			}catch(Exception exx) {
			}
			generalError(request,ex);
			return (new ActionForward(mapping.getInput()));
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
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
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Users users2 = UsersDAO.getInstance().get(form.getLong("userId"));
			request.setAttribute("user", users2);
			Organization organization = OrganizationDAO.getInstance().get(users2.getOrganizationId());
			request.setAttribute("org", organization);
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("detail");
	}
		
	/** 
	 * Method performHome
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performHome(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {	
		//UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		// hapus semua session kecuali session sod, lastLogin, userstream, org.apache.struts.action.LOCALE, viewAccess, user, ORGANIZATION
		CommonUtil.removeAllSession(request);
		try {
			try {
				
				Calendar calendar = new GregorianCalendar();
				calendar.add(Calendar.DATE, 1);
				if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)calendar.add(Calendar.DATE, 2);
				httpSession.setAttribute(CommonConstants.SOD, Formater.getFormatedDate(calendar.getTime(), "d MMMM yyyy"));
				
			} catch(Exception exception){
				
			}
			
			// set password expired
			UserPasswordHistoryDAO.getInstance().passExpired(users, request);
			
			
			
			Set roleGroupList = users.getRoleGroupsShow();		
			request.setAttribute("roleGroupList", roleGroupList);

			//cek punya role buat liad termination approval
			boolean isViewDeskcollCompare = false;
			
			Iterator iterIsViewDealer = users.getViewAccess().iterator();
			while (iterIsViewDealer.hasNext()) {
				View object = (View) iterIsViewDealer.next();
				if(object.getLink()!=null){
					if(object.getLink().trim().equalsIgnoreCase("/deskcollCompare/list.do") && !users.getRole("ADMIN")){
						isViewDeskcollCompare = true;
						break;
					}
				}
			}
			
			//TERMINATION APPROVAL LIST
			//cek punya role buat liad termination approval
			boolean isView = false;
			isView = users.isGetViewAccessPath(users,"/terminationApproval/list.do");
			
			//PURCHASE REQUEST APPROVAL LIST
			//cek punya role buat liad PR approval
			boolean isViewPurchaseRequest = false;
			isViewPurchaseRequest = users.isGetViewAccessPath(users,"/purchaseRequest/approval/list.do");
			
			try {
				// save code
				// remove session
				CommonUtil.removeSession(request);
			} catch(Exception exception){}
			
			String refererUrl = request.getHeader("referer");
			if(refererUrl==null){
				if(httpSession.getAttribute(CommonConstants.URL)!=null){
					httpSession.setAttribute("errorMessage", "Anda tidak memiliki akses untuk menu ini, harap email ke helpdesk dengan ID : "+users.getId()+" - "+httpSession.getAttribute(CommonConstants.URL));
					httpSession.removeAttribute(CommonConstants.URL);
				}
			}
			
		} catch(Exception ex) {
			log.error("Unhandle Exception", ex);
			generalError(request,ex);
			return mapping.findForward("index2");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			UsersDAO.getInstance().closeSessionForReal();
		}
		
		return mapping.findForward("index2");
	}
	
	private ActionForward performChecklistMarketing(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction = null;
		
		try {
			Session session = UsersDAO.getInstance().getSession();
			transaction = session.beginTransaction();
			
			int start = 0;
			int count = 0;
			int total = 0;

			
			if((form.getString("name")!=null && form.getString("name").length()>0) || (form.getString("userName")!=null && form.getString("userName").length()>0)){
				
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
				
							
				String sqlTotal = "" +
				"select count(*) as A " +
				"from users u " + 
				"left join user_role ur on u.user_id=ur.user_id " +
				"where ur.role_id=60 " + //role_id marketing
				//" and ( u.user_id <> " + users.getId() + " ) " +
				" and ( ";
				
					String a = "";
					int i = 0, j = 0;
					
					StringTokenizer st = new StringTokenizer(form.getString("name")," ");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3)j++;
					}
					
					st = new StringTokenizer(form.getString("name")," ");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3){
							if (element.contains("'")) element = element.substring(0, element.indexOf("'"))+"'"+element.substring(element.indexOf("'"), element.length());
							a = a + " upper(u.name) like '%"+element.toUpperCase()+"%' ";
							i++;
							if (i < j) a = a + " OR ";
						}
					}	
					if (a.length()>0) sqlTotal = sqlTotal + " ("+a+")";
					st = new StringTokenizer(form.getString("userName"),".");
					String a1 = "";
					i = 0;
					j = 0;
					
					st = new StringTokenizer(form.getString("userName"),".");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3)j++;
					}
					st = new StringTokenizer(form.getString("userName"),".");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3){
							if (element.contains("'")) element = element.substring(0, element.indexOf("'"))+"'"+element.substring(element.indexOf("'"), element.length());
							a1 = a1 + " upper(u.user_name) like '%"+element.toUpperCase()+"%' ";
							i++;
							if (i < j) a1 = a1 + " OR ";
						}
					}

				if (a1.length()>0) sqlTotal = sqlTotal + " OR ("+a1+")";
				sqlTotal = sqlTotal + ")";
				
				total = ((Long)UsersDAO.getInstance().getSession().createSQLQuery(sqlTotal).addScalar("A", Hibernate.LONG).setMaxResults(1).uniqueResult()).intValue();
				
				String sql = "" +
				"select " +
				"u.user_id as id, " +
				"u.name as name, " +
				"u.user_name as userName, " +
				"u.address as address, " +
				"u.city as city, " +
				"u.handphone as handphone, " +
				"u.email as email " +
				"from users u " +
				"left join user_role ur on u.user_id=ur.user_id " +
				"where ur.role_id=60 " + //role_id marketing
				//"and ( u.user_id <> " + users.getId() + " ) " +
				" and ( ";
				
					a = "";
					i = 0;
					j = 0;
					
					st = new StringTokenizer(form.getString("name")," ");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3)j++;
					}
					
					st = new StringTokenizer(form.getString("name")," ");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3){
							if (element.contains("'")) element = element.substring(0, element.indexOf("'"))+"'"+element.substring(element.indexOf("'"), element.length());
							a = a + " upper(u.name) like '%"+element.toUpperCase()+"%' ";
							i++;
							if (i < j) a = a + " OR ";
						}
					}	
					if (a.length()>0) sql = sql + " ("+a+")";
					st = new StringTokenizer(form.getString("userName"),".");
					a1 = "";
					i = 0;
					j = 0;
					
					st = new StringTokenizer(form.getString("userName"),".");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3)j++;
					}
					st = new StringTokenizer(form.getString("userName"),".");
					while (st.hasMoreTokens()) {
						String element = (String) st.nextToken();
						if(element.length()>=3){
							if (element.contains("'")) element = element.substring(0, element.indexOf("'"))+"'"+element.substring(element.indexOf("'"), element.length());
							a1 = a1 + " upper(u.user_name) like '%"+element.toUpperCase()+"%' ";
							i++;
							if (i < j) a1 = a1 + " OR ";
						}
					}
					
				if (a1.length()>0) sql = sql + " OR ("+a1+")";
				sql = sql + ")";
				
				List checklist = UsersDAO.getInstance().getSession().createSQLQuery(sql)
								.addScalar("id", Hibernate.INTEGER)
								.addScalar("name", Hibernate.STRING)
								.addScalar("userName", Hibernate.STRING)
								.addScalar("address", Hibernate.STRING)
								.addScalar("city", Hibernate.STRING)
								.addScalar("handphone", Hibernate.STRING)
								.addScalar("email", Hibernate.STRING)
								.setResultTransformer(Transformers.aliasToBean(Users.class))
								.setFirstResult(start)
								.setMaxResults(count)
								.list();
				
				httpSession.setAttribute("checklist", checklist);
			} else {
				total=0;
				request.removeAttribute("checklist");
			}
			
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);

			transaction.commit();
		} catch(Exception ex) {
			try {
				if (transaction!=null) transaction.rollback();
			}catch(Exception exx) {
			}
			log.error("Unhandle Exception", ex);
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
		}
		return mapping.findForward("list");
	}
	
	private ActionForward performSalesMaintainance(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
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
			//save
			if(form.getString("subaction")!=null && form.getString("subaction").length()>0 && form.getString("subaction").equalsIgnoreCase("SAVE")){
				for(int index=0;index<form.getLong("size");index++){
					Users users2 = UsersDAO.getInstance().get(form.getLong("id", index));
					if(form.getString("active", index).length()>0){
						users2.setActive(true);
						
					}
					else{
						users2.setActive(false);
					}
					UsersDAO.getInstance().update(users2);
				}
			}
			UsersDAO.getInstance().closeSessionForReal();
			form.setString("subaction", "");
			
			//save start and count attribute on session
			httpSession.setAttribute(CommonConstants.START,Integer.toString(start));
			httpSession.setAttribute(CommonConstants.COUNT,Integer.toString(count));
			
			String sql = " " +
			"user_id IN " +
			"(select ur.user_id from user_role ur " +
			"	join role r on ur.role_id=r.role_id " +
			"	join role_role_group rrg on r.role_id=rrg.role_id " +
			"	where rrg.role_group_id=(select lookup_id from lookup where upper(category) like 'ROLE_GROUP' and upper(name) like 'MARKETING')" +
			") ";
			
			Criteria criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
			if (form.getString("userName")!=null && form.getString("userName").length()>0)criteria.add(Restrictions.ilike("UserName", "%"+form.getString("userName")+"%"));
			//criteria.createCriteria("Roles").createCriteria("RoleGroups").add(Restrictions.eq("Category", "ROLE_GROUP")).add(Restrictions.eq("Name", "MARKETING"));
			criteria.add(Restrictions.sqlRestriction(sql));
			criteria.setProjection(Projections.rowCount());
			total = ((Integer)criteria.list().iterator().next()).intValue();
			// partial data
			criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
			if (form.getString("userName")!=null && form.getString("userName").length()>0)criteria.add(Restrictions.ilike("UserName", "%"+form.getString("userName")+"%"));
			//criteria.createCriteria("Roles").createCriteria("RoleGroups").add(Restrictions.eq("Category", "ROLE_GROUP")).add(Restrictions.eq("Name", "MARKETING"));
			criteria.add(Restrictions.sqlRestriction(sql));
			if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
			    criteria.addOrder(Order.asc(form.getString("orderBy")));
			} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
			    criteria.addOrder(Order.desc(form.getString("orderBy")));
			}else{
				 criteria.addOrder(Order.asc("id"));
			}
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			//list
			List lst = criteria.list();
			request.setAttribute("USER",lst);
			form.setString("size", lst.size());
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list");
	}
	
	private ActionForward performChangePassword(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			form.setString("userId", users.getId());
			form.setString("name", users.getName());
			form.setString("email", users.getEmail());
		
		}catch(Exception ex) {
			
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form");
	}
	
	private ActionForward performChangePasswordSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction = null;
		//String regex = "(?!.*[()+}{;=`~:\\|'?/>.<,])";
		String regex = "";
		
		try {
			
			if(form.getLong("userId")>0){
				if(form.getString("oldPassword")==null || form.getString("oldPassword").length()==0){
					ActionMessages errors = new ActionMessages();
					errors.add("errorsOldPassword",new ActionMessage("error.old.password"));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));					
				} else {
					if(users.getUserPass().equalsIgnoreCase(CommonUtil.digest(form.getString("oldPassword")))){
						// check numeric and character combination!
						OrganizationSetup organizationSetup = (OrganizationSetup) OrganizationSetupDAO.getInstance().getSession().createCriteria(OrganizationSetup.class).add(Restrictions.ne("Id", new Long(-1))).uniqueResult();
						// save history
						if (UserPasswordHistoryDAO.getInstance().saveValidChangeUserPass(users.getId(), organizationSetup.getUserPassHistory(), form.getString("newPassword"))) {
							users.setUserPass(CommonUtil.digest(form.getString("newPassword")));
							users.setName(form.getString("name"));
							users.setEmail(form.getString("email"));
							UsersDAO.getInstance().update(users);
							httpSession.setAttribute(CommonConstants.USER,users);
						}else {
							ActionMessages errors = new ActionMessages();
							errors.add("invalidData",new ActionMessage("error.invalid.data", "Please input another password!"));
							saveErrors(request,errors);
							return (new ActionForward(mapping.getInput()));
						}	
						
						// set password expired
						UserPasswordHistoryDAO.getInstance().passExpired(users, request);
						
						// logoff
						httpSession.invalidate();
					} else{
						ActionMessages errors = new ActionMessages();
						errors.add("errorsOldPassword",new ActionMessage("error.old.password"));
						saveErrors(request,errors);
						return (new ActionForward(mapping.getInput()));
					}
				}
			}
			
			
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form2");
	}
	
	
	
	
	private ActionForward performMarketingList(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
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
			
			
			
			if( form.getString("subaction").equalsIgnoreCase("search")) {
				
				String sql = "" +
				"user_id IN " +
				"(select ur.user_id from user_role ur " +
				"	join role r on ur.role_id=r.role_id " +
				"	join role_role_group rrg on r.role_id=rrg.role_id " +
				"	where rrg.role_group_id=(select lookup_id from lookup where upper(category) like 'ROLE_GROUP' and upper(name) like 'MARKETING')" +
				") ";
				
				Criteria criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
				
				if (form.getString("isActive")!=null && form.getString("isActive").equalsIgnoreCase("T")) criteria.add(Restrictions.eq("Active", new Boolean(true)));
				if (form.getString("isActive")!=null && form.getString("isActive").equalsIgnoreCase("F")) criteria.add(Restrictions.eq("Active", new Boolean(false)));
				if (form.getString("userName")!=null && form.getString("userName").length()>0) criteria.add(Restrictions.ilike("UserName", form.getString("userName"), MatchMode.ANYWHERE));
				if (form.getString("name")!=null && form.getString("name").length()>0) criteria.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.ANYWHERE));
				criteria.add(Restrictions.sqlRestriction(sql));
				criteria.setProjection(Projections.rowCount());
				total = ((Integer)criteria.list().iterator().next()).intValue();
				// partial data
				criteria = UsersDAO.getInstance().getSession().createCriteria(Users.class);
				
				if (form.getString("isActive")!=null && form.getString("isActive").equalsIgnoreCase("T")) criteria.add(Restrictions.eq("Active", new Boolean(true)));
				if (form.getString("isActive")!=null && form.getString("isActive").equalsIgnoreCase("F")) criteria.add(Restrictions.eq("Active", new Boolean(false)));
				if (form.getString("userName")!=null && form.getString("userName").length()>0) criteria.add(Restrictions.ilike("UserName", form.getString("userName"), MatchMode.ANYWHERE));
				if (form.getString("name")!=null && form.getString("name").length()>0) criteria.add(Restrictions.ilike("Name", form.getString("name"), MatchMode.ANYWHERE));
				criteria.add(Restrictions.sqlRestriction(sql));
				if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("asc")) {
				    criteria.addOrder(Order.asc(form.getString("orderBy")));
				} else if (form.getString("orderBy")!=null && form.getString("orderBy").length()>0 && form.getString("ascDesc")!=null && form.getString("ascDesc").length()>0 && form.getString("ascDesc").equalsIgnoreCase("desc")) {
				    criteria.addOrder(Order.desc(form.getString("orderBy")));
				}else{
					criteria.addOrder(Order.asc("id"));
				}
				criteria.setFirstResult(start);
				criteria.setMaxResults(count);
				List results = criteria.list();
				request.setAttribute("USER",results);
				
			}
			else{
				total=0;
				request.removeAttribute("USER");
			}
			
			String pager = Pager.generatePager(start, count, total);
			String pagerItem = Pager.generatePagerItem(start, count, total);
			request.setAttribute("PAGER",pager);
			request.setAttribute("PAGERITEM",pagerItem);
			
		}catch(Exception ex){
			log.error("Unhandle Exception", ex);
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list");
	}
	
	private ActionForward performMarketingForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		String deskripsiRespon = "";
		boolean isResignFlag=false;
		try {
			List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
			request.setAttribute("roleLst",lst);
			// relationships
			List organizationLst = OrganizationDAO.getInstance().findAll();
			request.setAttribute("organizationLst", organizationLst);
			
			
			if (form.getLong("userId")==0) {
				form.setString("userId",0);
				//set default start at beginning of page
				httpSession.setAttribute(CommonConstants.START,"0");
				httpSession.setAttribute(CommonConstants.COUNT, httpSession.getAttribute(CommonConstants.COUNT));
			} else {
				Users obj = UsersDAO.getInstance().get(form.getLong("userId"));
				//cek ke mufins hrd apakah sudah resign atau belum
				form.setString("isResign", isResignFlag?"true":"false");
				//cek username
				String regex = "[0-9]{6,8}";
				boolean cocok = false;
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(obj.getUserName());
				if (matcher.matches()) cocok = true;
				form.setString("userId",obj.getId());
				form.setString("isActive",obj.isActive()?"Y":"N");
				form.setString("userName",obj.getUserName());
				form.setString("name", obj.getName());
				form.setString("organizationId", obj.getOrganizationId());

				if (cocok) {
					request.setAttribute("userNameNumberValid", "valid");
				}
			}
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				RoleDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form");
	}
	
	@SuppressWarnings("rawtypes")
	private ActionForward performMarketingSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		Transaction transaction=null;
		try {				
			if (isCancelled(request)) {
				ActionForward forward = mapping.findForward("list_redir");
				StringBuffer sb = new StringBuffer(forward.getPath());
				sb.append("?start="+httpSession.getAttribute(CommonConstants.START)+"&count="+httpSession.getAttribute(CommonConstants.COUNT));
				return new ActionForward(sb.toString(),true);
			}
			//String cekString = form.getString("userName");
			if (form.getLong("userId")==0) {
				Session session = UsersDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				
				Users obj = (Users)UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.ilike("UserName", form.getString("userName").toLowerCase(), MatchMode.EXACT)).uniqueResult();
				if (obj==null) {
					obj = new Users();
					obj.setUserName(form.getString("userName").toLowerCase());
					obj.setUserPass(CommonUtil.digest("123"));
					obj.setActive(true);
					obj.setUserType("user");
					obj.setOrganizationId(form.getLong("organizationId"));
					obj.setName(form.getString("name"));
					// role marketing
					Set set = new LinkedHashSet();
					Role role = (Role)RoleDAO.getInstance().getSession().createCriteria(Role.class).add(Restrictions.eq("RoleName", "marketing")).uniqueResult();
					//Role role2 = (Role)RoleDAO.getInstance().getSession().createCriteria(Role.class).add(Restrictions.ilike("RoleName", "svy")).uniqueResult();
					set.add(role);
					//set.add(role2);
					obj.setRoles(set);
					UsersDAO.getInstance().save(obj,session);
					
				} else {
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("userName")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
			} else {
				
				Users obj3 = (Users)UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.ilike("UserName", form.getString("userName").toLowerCase(), MatchMode.EXACT))
					.add(Restrictions.ne("Id", form.getLong("userId"))).uniqueResult();
				if (obj3!=null) {
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					ActionMessages errors = new ActionMessages();
					errors.add("errorDuplicate",new ActionMessage("error.duplicate", form.getString("userName")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));	
				}
						
				Session session = UsersDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				
				//object user
				Users obj = UsersDAO.getInstance().load(form.getLong("userId"));
				
				//cek username
				String regex = "[0-9]{6,8}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(form.getString("userName"));
				if (matcher.matches()) {
					
					obj.setUserName(form.getString("userName").toLowerCase());
					obj.setName(form.getString("name"));
					if(obj.isActive()&&form.getString("isResign").equalsIgnoreCase("true")&&users.getRole("admin")){//dari awalnya aktif mau di nonaktifin kalo udh resign
						obj.setActive(false);
					}else if(!obj.isActive()&&form.getString("isResign").equalsIgnoreCase("true")){//kalo uda ga aktif n status resign tp mw di aktifin lagi
						ActionMessages errors = new ActionMessages();
						errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.resign.user",request.getContextPath()+mapping.getPath()));
						saveErrors(request,errors);
						List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
						request.setAttribute("roleLst",lst);
						List organizationLst = OrganizationDAO.getInstance().findAll();
						request.setAttribute("organizationLst", organizationLst);
						return (new ActionForward(mapping.getInput()));
					}else if(form.getString("isResign").equalsIgnoreCase("false")&&users.getRole("admin")){
						obj.setActive(form.getString("isActive").length()>0?true:false);
					}
					
					obj.setOrganizationId(form.getLong("organizationId"));
					
					if(form.getString("isActive").equalsIgnoreCase("Y")&&form.getString("isResign").equalsIgnoreCase("true")){
						ActionMessages errors = new ActionMessages();
						errors.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("error.resign.user",request.getContextPath()+mapping.getPath()));
						saveErrors(request,errors);
						List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
						request.setAttribute("roleLst",lst);
						List organizationLst = OrganizationDAO.getInstance().findAll();
						request.setAttribute("organizationLst", organizationLst);
						return (new ActionForward(mapping.getInput()));
					}
					
					UsersDAO.getInstance().update(obj,session);
					
				} else {
					List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
					request.setAttribute("roleLst",lst);
					List organizationLst = OrganizationDAO.getInstance().findAll();
					request.setAttribute("organizationLst", organizationLst);
					ActionMessages errors = new ActionMessages();
					errors.add("errorUserNameNumber",new ActionMessage("error.userName.number", form.getString("userName")));
					saveErrors(request,errors);
					return (new ActionForward(mapping.getInput()));
				}
				
			}
			transaction.commit();
		}catch(Exception ex) {
			log.error("Unhandle Exception", ex);
			try {
				List lst = RoleDAO.getInstance().findAll(Order.asc("Id"));
				request.setAttribute("roleLst",lst);
				List organizationLst = OrganizationDAO.getInstance().findAll();
				request.setAttribute("organizationLst", organizationLst);
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
	
	private ActionForward performMarketingDetail(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Users users2 = UsersDAO.getInstance().get(form.getLong("userId"));
			request.setAttribute("user", users2);
			Organization organization = OrganizationDAO.getInstance().get(users2.getOrganizationId());
			request.setAttribute("org", organization);
		}catch(Exception ex) {
			generalError(request,ex);
			return mapping.findForward("detail");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("detail");
	}
	

	
	private ActionForward performPgsqlForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		//UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			
		}catch(Exception ex){
			log.error("Unhandle Exception", ex);
			generalError(request,ex);
			return mapping.findForward("list");
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("form");
	}
	
	private ActionForward performPgsqlConfirm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			Session session = UsersDAO.getInstance().getSession();
			Transaction transaction = session.beginTransaction();
			
			// pisahkan antara query update & list!
			
			String sql = form.getString("action");
			
			if (sql!=null && sql.length()>0) {
				// query select
				if (sql.startsWith("select") || sql.startsWith("SELECT")) {
					
					Connection connection = session.connection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery(sql);
					ResultSetMetaData rsMetaData = resultSet.getMetaData();
					
					String[] columnName = new String[rsMetaData.getColumnCount()];
					List list = new LinkedList();
					
				    // get the column names; column indexes start from 1
				    for (int i = 1; i < rsMetaData.getColumnCount() + 1; i++) {
				    	columnName[i-1] = rsMetaData.getColumnName(i);
				    }
				    request.setAttribute("header", columnName);
				    
				    while (resultSet.next()) {
				    	String[] result = new String[rsMetaData.getColumnCount()];
				    	for (int i = 0; i < rsMetaData.getColumnCount(); i++) {
				    		result[i] = resultSet.getString(columnName[i]);
				    	}
				    	list.add(result);
					}
					request.setAttribute("list", list);
					request.setAttribute("jum", new Integer(rsMetaData.getColumnCount()));
					
				} else {
					session.createSQLQuery(sql).executeUpdate();
				}		
				
			}
			
			transaction.commit();
			
		}catch(Exception ex){
			log.error("Unhandle Exception", ex);
			ActionMessages errors = new ActionMessages();
			errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.global",ex.getStackTrace().toString()));
			saveErrors(request,errors);
			return mapping.getInputForward();
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("confirm");
	}
	
	
	private ActionForward performResetLoginAttempt(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		UserForm form = (UserForm) actionForm;
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		try {
			
			Users resetUser = UsersDAO.getInstance().get(form.getLong("userId"));
			resetUser.setLoginAttemptCounter(0);
			UsersDAO.getInstance().save(resetUser);
		
		}catch(Exception ex) {
			
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users.getUserName()+"  ] ");
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
			}
		}
		return mapping.findForward("list_redir");
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