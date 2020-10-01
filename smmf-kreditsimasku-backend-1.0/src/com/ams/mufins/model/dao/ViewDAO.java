package com.ams.mufins.model.dao;

import org.hibernate.Hibernate;

import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.ams.mufins.model.base.BaseViewDAO;


public class ViewDAO extends BaseViewDAO {
	
	int childs;

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public ViewDAO () {}
	
	public int getChilds(View view, Users users) {
		int a = 0;
		try {
			if (view.getViews()!=null && view.getViews().size()>0) a = ((Integer)getSession().createSQLQuery("select count(t0.view_id) as Count from views t0 inner join role_view t1 on t0.view_id=t1.view_id inner join user_role t2 on t1.role_id=t2.role_id where t0.is_view='Y' and t0.parent_id = "+view.getId()+" and t2.user_id="+users.getId()).addScalar("Count", Hibernate.INTEGER).setMaxResults(1).uniqueResult()).intValue();
		} catch(Exception ex){
			ex.printStackTrace();
		}
		return a;
	}


}