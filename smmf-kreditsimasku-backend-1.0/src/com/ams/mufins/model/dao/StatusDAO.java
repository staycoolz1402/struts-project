package com.ams.mufins.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.Status;
import com.ams.mufins.model.base.BaseStatusDAO;


public class StatusDAO extends BaseStatusDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public StatusDAO () {}
	
	public List getByCategory(String type) throws Exception {
		List list = getSession().createCriteria(Status.class)
			.add(Restrictions.eq("Type", type))
			.addOrder(Order.asc("Name"))
			.list();
		if (list==null || (list!=null && list.size()==0)) throw new Exception("Status with type '"+type+"' not found!");
		return list;
	}
	
	public Status getWOCategoryStatus(long id) throws Exception {
		Status status = (Status)getSession().createCriteria(Status.class)
						.add(Restrictions.eq("StatusId", id))
						.setMaxResults(1)
						.uniqueResult();
		return status;
	}


}