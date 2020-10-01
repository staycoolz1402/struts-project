package com.ams.mufins.model.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.Role;
import com.ams.mufins.model.UserPasswordHistory;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.base.BaseUserPasswordHistoryDAO;
import com.mpe.common.CommonUtil;
import com.mpe.common.Formater;



public class UserPasswordHistoryDAO extends BaseUserPasswordHistoryDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public UserPasswordHistoryDAO () {}
		
	public boolean userPassDurationExpired(long userId, int userPassDuration, String currentEncriptUserPass, Session session){
		try {
			// no user-pass-duration
			if (userPassDuration==0) return false;
			//
			else {
				// get-last-history
				UserPasswordHistory lastUserPassHistory = (UserPasswordHistory)session.createCriteria(UserPasswordHistory.class)
						.add(Restrictions.eq("UserId", userId))
						.addOrder(Order.desc("UserPassChangeDate")).setMaxResults(1).uniqueResult();
				if (lastUserPassHistory==null) {
					lastUserPassHistory = new UserPasswordHistory();
					lastUserPassHistory.setOldUserPass(currentEncriptUserPass);
					lastUserPassHistory.setUserId(userId);
					Calendar c1 = new GregorianCalendar();
					c1.set(Calendar.HOUR, 0);
					c1.set(Calendar.MINUTE, 0);
					c1.add(Calendar.DAY_OF_YEAR, -userPassDuration);
					lastUserPassHistory.setUserPassChangeDate(c1.getTime());
					session.save(lastUserPassHistory);
				}
				
				// compare-date
				Calendar c2 = Calendar.getInstance();
		        c2.setTime(lastUserPassHistory.getUserPassChangeDate());
		        long t1 = c2.getTimeInMillis();
		        c2.setTime(new Date());
		        long diff = Math.abs(c2.getTimeInMillis() - t1);
		        final int ONE_DAY = 1000 * 60 * 60 * 24;
		        long d = diff / ONE_DAY;
		        if (d>=userPassDuration) return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean saveValidChangeUserPass(long userId, int userPassHistory, String newUserPass){
		Session session = getInstance().getSession();
		Transaction transaction = null;
		boolean validUserPass = true;
		try {
			transaction = session.beginTransaction();
			Vector<Long> longs = new Vector<Long>();
			// check password depend on last password related with userPassHistory
			List<UserPasswordHistory> histories = session.createCriteria(UserPasswordHistory.class)
					.add(Restrictions.eq("UserId", userId))
					.addOrder(Order.desc("UserPassChangeDate"))
					.setMaxResults(userPassHistory).list();
			int i = userPassHistory-1;
			for (UserPasswordHistory history : histories) {
				if (CommonUtil.digest(newUserPass).equals(history.getOldUserPass())) {
					validUserPass = false;
				}
				if (i>0) longs.add(history.getId());
				i--;
			}
			if (validUserPass) {
				// delete last & out of range old password
				if (longs.size()>0) {
					String sql = "delete from user_password_history where user_id =:userId and user_password_history_id NOT IN (:z) ";
					session.createSQLQuery(sql).setLong("userId", userId).setParameterList("z", longs).executeUpdate();
				} else {
					// handle if history = 1
					String sql = "delete from user_password_history where user_id = :userId ";
					session.createSQLQuery(sql).setLong("userId", userId).executeUpdate();
				}
				
				// save new password
				UserPasswordHistory newHistory = new UserPasswordHistory();
				newHistory.setUserId(userId);
				newHistory.setOldUserPass(CommonUtil.digest(newUserPass));
				newHistory.setUserPassChangeDate(new Date());
				session.save(newHistory);
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction!=null) transaction.rollback();
		} finally {
			if (session!=null) session.close();
		}
		return validUserPass;
	}
	
	public void passExpired(Users users, HttpServletRequest request) {
		try {
			/*String sql = "select role_id as roleId from user_role where user_id = :userId";
					
			long roleId = (Long) RoleDAO.getInstance()
						.getSession()
						.createSQLQuery(sql)
						.addScalar("roleId", Hibernate.LONG)
						.setLong("userId", users.getId())
						.setMaxResults(1)
						.uniqueResult();
			
			Role role = RoleDAO.getInstance().get(roleId);*/
			Role role = users.getRoles().iterator().next();
			int expDuration = role.getDefaultUserPassDuration();

			if(expDuration>0 || users.getLastLoginTime() == null){
				request.setAttribute("expDuration", expDuration);
				
				String sql = "select max(user_pass_change_date) as lastChange from user_password_history where user_id = :userId";
				
				Date lastChange = (Date) UserPasswordHistoryDAO.getInstance()
							.getSession()
							.createSQLQuery(sql)
							.addScalar("lastChange", Hibernate.DATE)
							.setLong("userId", users.getId())
							.setMaxResults(1)
							.uniqueResult();
				
				Calendar cal = new GregorianCalendar();
				cal.setTime(lastChange);
				cal.add(Calendar.DATE, expDuration);
				request.setAttribute("nextChangePass", Formater.getFormatedDate(cal.getTime(), "dd MMMM yyyy"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


}