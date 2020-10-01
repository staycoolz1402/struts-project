package com.ams.mufins.model;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.base.BaseUsers;
import com.ams.mufins.model.dao.UsersDAO;
import com.mpe.common.ViewComparator;




public class Users extends BaseUsers {
	private static final long serialVersionUID = 1L;
	private Set<View> viewAccess = null;
	Log log = LogFactory.getFactory().getInstance(this.getClass());

/*[CONSTRUCTOR MARKER BEGIN]*/
	public Users () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Users (long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Users (
		long id,
		java.lang.String userName,
		java.lang.String userPass,
		long organizationId) {

		super (
			id,
			userName,
			userPass,
			organizationId);
	}

/*[CONSTRUCTOR MARKER END]*/
	
	private java.lang.Long agencyId;
	
	public long getRoleGroupId() {
		long id = 0;
		for(Role role : getRoles()){
			for (Object obj : role.getRoleGroups()) {
				Lookup lookup = (Lookup)obj;
				id = lookup.getId();
			}
		}
		return id;
	}
	
	public boolean isMarketing() {
		boolean b = false;
		Iterator iterator = getRoles()!=null?getRoles().iterator():new LinkedList().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Set set = role.getRoleGroups();
			Iterator iterator2 = set!=null?set.iterator():new LinkedHashSet().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				if (roleGroup.getName().equalsIgnoreCase("MARKETING")) {
					b = true;
					break;
				}
			}
		}
		return b;
	}
	
	public String getRoleGroupName() {
		String string ="";
		Iterator iterator = getRoles()!=null?getRoles().iterator():new LinkedList().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Set set = role.getRoleGroups();
			Iterator iterator2 = set!=null?set.iterator():new LinkedHashSet().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				string = roleGroup.getName();
				break;
			}
		}
		return string;
	}
	
	
	public Set getViewAccess() {
		if(this.viewAccess == null){
			java.util.Iterator iterator = getRoles().iterator();
			Set set = new LinkedHashSet();
			Set superSet = new LinkedHashSet();
			Set masterSetUnsort = new LinkedHashSet();
			ViewComparator comparator = new ViewComparator();
			SortedSet masterSet = new TreeSet(comparator);
			SortedSet standartSet = new TreeSet(comparator);
	//		Set viewIds = new LinkedHashSet();
			while (iterator.hasNext()) {
				Role role = (Role)iterator.next();
				//list = (role.getViews());
				List viewLst = role.getViews();
				Iterator iterator2 = viewLst.iterator();
				while (iterator2.hasNext()) {
					View view = (View)iterator2.next();
					// level #1
					if (view.isView() && view.getParent() == null && !view.getViewName().equalsIgnoreCase("HR") && !view.getViewName().equalsIgnoreCase("Tax") && !view.getViewName().equalsIgnoreCase("Payroll")) superSet.add(view);
					// level #2
					else if (view.isView() && view.getParent()!=null) {masterSetUnsort.add(view);masterSet.add(view);}
					else if (!view.isView()) set.add(view);
					// level #3
					else if (view.isView()) standartSet.add(view);
					
					
				}
			}
			
			Iterator iterator2 = superSet.iterator();
			while (iterator2.hasNext()) {
				// level 1
				View view = (View)iterator2.next();
				view.setChilds(getChilds(view, masterSet));
				set.add(view);
				Iterator iterator3 = view.getViewName().equalsIgnoreCase("Admin")?masterSet.iterator():masterSetUnsort.iterator();
				while (iterator3.hasNext()) {
					// level 2
					View view2 = (View)iterator3.next();
					if (view2.getParent().getId()==view.getId()) {
						view2.setChilds(getChilds(view2, masterSet));
						set.add(view2);
						Iterator iterator4 = masterSet.iterator();
						while (iterator4.hasNext()) {
							// level 3
							View view3 = (View)iterator4.next();
							if (view3.getParent().getId()==view2.getId()) {
								view3.setChilds(0);
								set.add(view3);
							}
							
						}
					}
				}
				
			}
			
			//set panjang tampilan
			iterator = set.iterator();
			while (iterator.hasNext()) {
				View view = (View) iterator.next();
				
				//cari yang tampil
				if(view.isView()){
					int length = view.getViewName().length();
					
					if(view.getParent()!=null){
						iterator2 = set.iterator();
						while (iterator2.hasNext()) {
							View view1 = (View) iterator2.next();
							
							if(view1.isView() && view1.getParent()!=null && view1.getParent().getId()==view.getParent().getId() && view1.getViewName().length() > length) length = view1.getViewName().length();
							
						}
					}
					
					length = 5 + (6 * length) + 20;
					
					view.setLength(length);
					
				}
				
			}
			this.viewAccess = set;
		}
		return this.viewAccess;
	}
	
	public boolean contain(Set set, View view) {
		boolean b = false;
		Iterator iterator = set.iterator();
		while (iterator.hasNext()) {
			View view2 = (View)iterator.next();
			if (view2.getId()==view.getId()) {
				b = true;
				break;
			}
		}
		return b;
	}
	
	
	public int getChilds(View view, Set set) {
		int i = 0;
		//if (view.getViews()!=null && view.getViews().size()>0) a = ((Integer)getSession().createSQLQuery("select count(DISTINCT t0.view_id) as Count from views t0 inner join role_view t1 on t0.view_id=t1.view_id inner join user_role t2 on t1.role_id=t2.role_id where t0.is_view='Y' and t0.parent_id = "+view.getId()+" and t2.user_id="+users.getId()).addScalar("Count", Hibernate.INTEGER).setMaxResults(1).uniqueResult()).intValue();
		if (view.getViews()!=null && view.getViews().size()>0) {
			Iterator iterator = set.iterator();
			while (iterator.hasNext()) {
				View child = (View)iterator.next();
				if (child.isView() && child.getParent()!=null && child.getParent().getId()==view.getId()) i++;
			}
		}
		return i;
	}
	
	
	public Set getRoleGroupIds() {
		Set set = new LinkedHashSet();
		Iterator iterator = getRoles().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Iterator iterator2 = role.getRoleGroups().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				set.add(new Long(roleGroup.getId()));
			}
		}
		return set;
	}
	
	public Set getRoleGroups() {
		Set set = new LinkedHashSet();
		Iterator iterator = getRoles().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Iterator iterator2 = role.getRoleGroups().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				set.add(roleGroup);
			}
		}
		return set;
	}
	
	public Set getRoleGroupsShow() {
		String[] strings = {"ACCOUNTING", "ADMINISTRATOR", "FINANCE"};
		Set set = new LinkedHashSet();
		Iterator iterator = getRoles().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Iterator iterator2 = role.getRoleGroups().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				boolean b = false;
				for (int i=0; i<strings.length; i++) {
					if (roleGroup.getCode().equalsIgnoreCase(strings[i])) b = true;
				}
				if (!b) set.add(roleGroup);
			}
		}
		return set;
	}
	
	public boolean getRoleGroup(String rolegroups) {
		Iterator iterator = getRoles().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			Iterator iterator2 = role.getRoleGroups().iterator();
			while (iterator2.hasNext()) {
				Lookup roleGroup = (Lookup)iterator2.next();
				if(rolegroups.equalsIgnoreCase(roleGroup.getName())){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public String getRoleName(){
		String roleName = "";
		Set<Role> roles = getRoles();
		Iterator<Role> iterator = roles.iterator();
		while(iterator.hasNext()){
			Role role = (Role)iterator.next();
			if (role!=null){
				roleName = role.getRoleName();
				break;
			}
		}
		return roleName;
	}
	
	public boolean getRole(String roles) {
		Iterator iterator = getRoles().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			if(role.getRoleName().equalsIgnoreCase(roles)){
				return true;
			}
		}
		return false;
	}

	public long getValueOfId( Organization obj ) {
		long result;
		result = (long)0;
		if ( obj == null ) return result;
		else return obj.getId();
	}
	
	

	//fungsi untuk check boleh akses user edit dan release
	public boolean isCheck(Users users, String userName) {
		boolean b = false;
		Users checkedUsers = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.ilike("UserName", userName, MatchMode.EXACT)).uniqueResult();
		// CC1, CC2, Admin Cabang bisa akses semua user cabang dibawahnya (kecuali untuk login CC1, CC2 dan admin cabang)
		if (users.getRole("cc1") || users.getRole("cc2") || users.getRole("admin cabang")) {
				if(!checkedUsers.getRole("cc1") && !checkedUsers.getRole("cc2") && !checkedUsers.getRole("admin cabang")){
					b = true ;
				}
			
		}
		// Admin, Helpdesk, HRD bisa akses semua
		else if (users.getRole("admin") || users.getRole("helpdesk") || users.getRole("hrd") || users.getRole("IT Manager")) b = true;
		return b;
	}

	//fungsi untuk check boleh akses user edit dan release
	/*public boolean isCheck(String userName) {
		boolean b = false;
		Users checkedUsers = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class).add(Restrictions.ilike("UserName", userName, MatchMode.EXACT)).uniqueResult();
		Iterator iterator = getRoles()!=null?getRoles().iterator():new LinkedHashSet().iterator();
		while (iterator.hasNext()) {
			Role role = (Role)iterator.next();
			//helpdesk bisa Change Pass & Release Login (hanya untuk login KPNO, Admin cabang, CC1, CC2, ASM, Direksi)
			if (role.getRoleName().equalsIgnoreCase("helpdesk")){
				Iterator iterator2 = checkedUsers.getRoles()!=null?checkedUsers.getRoles().iterator():new LinkedHashSet().iterator();
				while (iterator2.hasNext()) {
					Role role2 = (Role) iterator2.next();
						b = true ; 
					}
				}
				
			}
			//cc1,cc2 Change Password+release untuk semua user yang ada dicabang yang dipimpinnya saja (kecuali untuk login CC1 dan CC2)
			else if (role.getRoleName().equalsIgnoreCase("cc1") || role.getRoleName().equalsIgnoreCase("cc2")) {
				Iterator iterator2 = checkedUsers.getRoles()!=null?checkedUsers.getRoles().iterator():new LinkedHashSet().iterator();
				while (iterator2.hasNext()) {
					Role role2 = (Role) iterator2.next();
					if(!role2.getRoleName().equalsIgnoreCase("cc1") && !role2.getRoleName().equalsIgnoreCase("cc2")){
						b = true ; 
					}
				}
				
			}
			//admin cabang release untuk semua user yang ada dicabang
			else if (role.getRoleName().equalsIgnoreCase("admin cabang")) b = true;
			//admin bisa semua
			else if (role.getRoleName().equalsIgnoreCase("admin")) b = true;
		}
		return b;
	}*/
	
	public boolean isGetViewAccessPath(Users user,String path){
		boolean result = false;
		Iterator iterIsView = user.getViewAccess().iterator();
		while (iterIsView.hasNext()) {
			View object = (View) iterIsView.next();
			if(object.getLink()!=null){
				if(object.getLink().trim().equalsIgnoreCase(path)){
					result = true;
					break;
				}
			}
		}
		return result;
	}
	
	public String getFormatedIsActive(){
		String isActive = "true";
		if(!isActive()){
			isActive = "false";
		}
		return isActive;
	}
	
	public java.lang.Long getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(java.lang.Long agencyId) {
		this.agencyId = agencyId;
	}
}