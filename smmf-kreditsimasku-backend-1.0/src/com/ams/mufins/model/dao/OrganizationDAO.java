package com.ams.mufins.model.dao;


import com.ams.mufins.model.base.BaseOrganizationDAO;


public class OrganizationDAO extends BaseOrganizationDAO {

	/**
	 * Default constructor.  Can be used in place of getInstance()
	 */
	public OrganizationDAO () {}
	
	/*public int getNumberOfDigit(Users users) throws Exception {
		int i = 0;
		String sql = "" +
				"select " +
				"number_of_digit as A " +
				"from organization_setup " +
				"where organization_id = " + users.getOrganizationId()+" " +
				"";
		i = ((Integer)getSession().createSQLQuery(sql)
			.addScalar("", Hibernate.INTEGER)
			.uniqueResult()).intValue();
		return i;
		
	}*/


}