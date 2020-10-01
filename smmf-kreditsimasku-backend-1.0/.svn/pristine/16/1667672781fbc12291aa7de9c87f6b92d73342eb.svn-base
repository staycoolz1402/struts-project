package com.ams.mufins.model.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ams.mufins.model.base.BaseUserDetailDAO;


public class UserDetailDAO extends BaseUserDetailDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public UserDetailDAO () {}

	public static int updateOpenOn(String[] userIdList){
		int count = 0; 
		Session session = null;
		Transaction transaction = null;
		try{
			session = UserDetailDAO.getInstance().getSession();
			transaction = session.beginTransaction();
			String sql = "update user_detail set open_on = :currentDate where user_id in (:userIdList) and open_on is null";
			count = session.createSQLQuery(sql)
					.setTimestamp("currentDate", new Date())
					.setParameterList("userIdList", userIdList)
					.executeUpdate();
			transaction.commit();
		}catch(Exception e){
			if(transaction!=null) transaction.rollback();
			throw e;
		}finally {
			if(session!=null) {
				session.close();
				session = null;
			}
		}
		return count;
	}

}