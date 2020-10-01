package com.ams.mufins.model.dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.RoleListBox;
import com.ams.mufins.model.View;
import com.ams.mufins.model.base.BaseRoleDAO;


public class RoleDAO extends BaseRoleDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public RoleDAO () {}
	
	public static String getRoleList(long roId){
		String role = "";
		try {
			String sql = "select is_numeric as num " +
					"from role " +
					"where role_id=:roId" +
					"";
			
			role = (String) RoleDAO.getInstance().getSession().createSQLQuery(sql)
							.addScalar("num", Hibernate.STRING)
							.setLong("roId", roId)
							.uniqueResult();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	
	@SuppressWarnings("unchecked")
	public List<RoleListBox> getRoleForMapReport (List<Long> roles) throws Exception{
		List<RoleListBox> roleList = new LinkedList<RoleListBox>();
		try {
			String sql = "" +
					"select " +
					"role_id as id, " +
					"role_name as name " +
					"from role " +
					"where role_id in (:roles) " +
					"order by role_name asc ";
			
			roleList = getSession().createSQLQuery(sql)
					.addScalar("id", Hibernate.LONG)
					.addScalar("name", Hibernate.STRING)
					.setParameterList("roles", roles)
					.setResultTransformer(Transformers.aliasToBean(RoleListBox.class)).list();
		} catch (Exception e) {
			throw e;
		} 
		return roleList;
	}
	
	@SuppressWarnings("unchecked")
	public List getAllRoleList() throws Exception {
		List list = new LinkedList();
		String sql = "" +
				"select " +
				"role_id as A, " +
				"role_name as B " +
				"from role " +
				"order by role_id asc ";
		
		List list2 = getSession().createSQLQuery(sql)
			.addScalar("A", Hibernate.LONG)
			.addScalar("B", Hibernate.STRING)
			.list();
		Iterator iterator = list2.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[])iterator.next();
			RoleListBox box = new RoleListBox(((Long)objects[0]).longValue(), (String)objects[1]);
			list.add(box);
		}
		
		return list;
	}
	
	
	@SuppressWarnings("unchecked")
	public List getRolePartnerChildList(List<String> roleList) throws Exception {
		List list = new LinkedList();
		String sql = "" +
				"select " +
				"role_id as A, " +
				"role_name as B " +
				"from role " +
				"where role_name in (:roleList) " +
				"order by role_id asc ";
		
		List list2 = getSession().createSQLQuery(sql)
			.addScalar("A", Hibernate.LONG)
			.addScalar("B", Hibernate.STRING)
			.setParameterList("roleList", roleList)
			.list();
		Iterator iterator = list2.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[])iterator.next();
			RoleListBox box = new RoleListBox(((Long)objects[0]).longValue(), (String)objects[1]);
			list.add(box);
		}
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public List getRoleParentList(long roleId) throws Exception {
		List list = new LinkedList();
		String sql = "" +
				"select " +
				"rp.parent_id as A, " +
				"rr.role_name as B " +
				"from role r " +
				"join role_parent rp on rp.role_id = r.role_id " +
				"join role rr on rr.role_id = rp.parent_id " +
				"where r.role_id = :roleId " +
				"order by r.role_id asc ";
		
		List list2 = getSession().createSQLQuery(sql)
			.addScalar("A", Hibernate.LONG)
			.addScalar("B", Hibernate.STRING)
			.setLong("roleId", roleId)
			.list();
		Iterator iterator = list2.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[])iterator.next();
			RoleListBox box = new RoleListBox(((Long)objects[0]).longValue(), (String)objects[1]);
			list.add(box);
		}
		
		return list;
	}
	
	public List getRoleSelectedList(long roId){
		List role = new LinkedList();
		try {
			String sql = 
					" select v.view_id as viewId, coalesce(vpp.view_name,'')||case when vpp.view_id is not null then ' :: ' else '' end||coalesce(vp.view_name,'')||case when vp.view_id is not null then ' :: ' else '' end ||v.view_name as viewName " +
					" from role_view rv "+
		            " join views v on v.view_id = rv.view_id "+
		            " left join views vp on vp.view_id = v.parent_id "+
		            " left join views vpp on vpp.view_id = vp.parent_id "+
		            " where rv.role_id = :roleId "+
		            " order by viewName ";
			
		List role2 = getSession().createSQLQuery(sql)
						.addScalar("viewId", Hibernate.LONG)
						.addScalar("viewName", Hibernate.STRING)
						.setLong("roleId", roId)
						.list();
		
		Iterator iterator = role2.iterator();
		while (iterator.hasNext()) {
			Object[] objects = (Object[])iterator.next();
			View view = ViewDAO.getInstance().get(((Long)objects[0]).longValue());
			role.add(view);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return role;
	}
	
}