package com.ams.mufins.model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.OrganizationSetup;
import com.ams.mufins.model.Role;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.UsersHistory;
import com.ams.mufins.model.base.BaseUsersDAO;
import com.ams.mufins.model.report.TotalReport;
import com.mpe.common.CommonUtil;
import com.mpe.common.Formater;


public class UsersDAO extends BaseUsersDAO {
	Logger log = Logger.getLogger(this.getClass());

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public UsersDAO () {}
	static long salesTypeParam;
	static Calendar joinDateParam;
	
	static final String sqlDuration =  "select min(a.default_user_pass_duration) as GBU from role a " +
									   "join user_role b on b.role_id=a.role_id " +
									   "where b.user_id =:userId ";
	public int getUserPassDuration(long userId, Session hibernateSession) throws Exception {
		try {
			
			Integer i = (Integer)hibernateSession.createSQLQuery(sqlDuration).addScalar("GBU", Hibernate.INTEGER)
					.setLong("userId", userId)
					.uniqueResult();
			
			if (i==null) {
				
				OrganizationSetup organizationSetup = (OrganizationSetup)hibernateSession.createCriteria(OrganizationSetup.class)
						.add(Restrictions.ne("organizationSetupId", new Long(-1)))
						.uniqueResult();
				if (organizationSetup!=null && organizationSetup.getDefaultUserPassDuration()>0) return organizationSetup.getDefaultUserPassDuration();				
				
			} else return i;
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return 0;
	}
	
	public Users getUser(String userName) throws Exception {
		Session session = getInstance().getSession();
		Users user = null;
		try{
			user = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class)
			.add(Restrictions.eq("UserName", userName))
			.uniqueResult();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if (session!=null) session.close();
		}
		return user;
	}
	
	public void updateLastLogin(Users user, Session hibernateSession) throws Exception {
		String sql = "update users set last_login_time = :login where user_id = :userId ";
		SQLQuery query = hibernateSession.createSQLQuery(sql);
		query.setTimestamp("login", new Date());
		query.setLong("userId", user.getId());
		query.executeUpdate();
	}
	
	public long getUserId(long employeeId){
		long userId = 0;
		userId = ((Long)getSession().createSQLQuery("select user_id as A from users where employee_id = "+employeeId).addScalar("A", Hibernate.LONG).uniqueResult()).longValue() ;
		return userId;
	}

}