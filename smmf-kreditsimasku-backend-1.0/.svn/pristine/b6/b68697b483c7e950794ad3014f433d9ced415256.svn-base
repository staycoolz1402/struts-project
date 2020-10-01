package com.ams.mufins.model.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.ams.mufins.model.dao.ReportAccessDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseReportAccessDAO extends com.ams.mufins.model.dao._RootDAO {

	// query name references


	public static ReportAccessDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static ReportAccessDAO getInstance () {
		if (null == instance) instance = new ReportAccessDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.ams.mufins.model.ReportAccess.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.ams.mufins.model.ReportAccess
	 */
	public com.ams.mufins.model.ReportAccess cast (Object object) {
		return (com.ams.mufins.model.ReportAccess) object;
	}

	public com.ams.mufins.model.ReportAccess get(long key)
	{
		return (com.ams.mufins.model.ReportAccess) get(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.ReportAccess get(long key, Session s)
	{
		return (com.ams.mufins.model.ReportAccess) get(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.ReportAccess load(long key)
	{
		return (com.ams.mufins.model.ReportAccess) load(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.ReportAccess load(long key, Session s)
	{
		return (com.ams.mufins.model.ReportAccess) load(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.ReportAccess loadInitialize(long key, Session s) 
	{ 
		com.ams.mufins.model.ReportAccess obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param reportAccess a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.ReportAccess reportAccess)
	{
		return (java.lang.Long) super.save(reportAccess);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param reportAccess a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.ReportAccess reportAccess, Session s)
	{
		return (java.lang.Long) save((Object) reportAccess, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param reportAccess a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ams.mufins.model.ReportAccess reportAccess)
	{
		saveOrUpdate((Object) reportAccess);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param reportAccess a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ams.mufins.model.ReportAccess reportAccess, Session s)
	{
		saveOrUpdate((Object) reportAccess, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param reportAccess a transient instance containing updated state
	 */
	public void update(com.ams.mufins.model.ReportAccess reportAccess) 
	{
		update((Object) reportAccess);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param reportAccess a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ams.mufins.model.ReportAccess reportAccess, Session s)
	{
		update((Object) reportAccess, s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param id the instance ID to be removed
	 */
	public void delete(long id)
	{
		delete((Object) load(id));
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param id the instance ID to be removed
	 * @param s the Session
	 */
	public void delete(long id, Session s)
	{
		delete((Object) load(id, s), s);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * @param reportAccess the instance to be removed
	 */
	public void delete(com.ams.mufins.model.ReportAccess reportAccess)
	{
		delete((Object) reportAccess);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param reportAccess the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ams.mufins.model.ReportAccess reportAccess, Session s)
	{
		delete((Object) reportAccess, s);
	}
	
	/**
	 * Re-read the state of the given instance from the underlying database. It is inadvisable to use this to implement
	 * long-running sessions that span many business tasks. This method is, however, useful in certain special circumstances.
	 * For example 
	 * <ul> 
	 * <li>where a database trigger alters the object state upon insert or update</li>
	 * <li>after executing direct SQL (eg. a mass update) in the same session</li>
	 * <li>after inserting a Blob or Clob</li>
	 * </ul>
	 */
	public void refresh (com.ams.mufins.model.ReportAccess reportAccess, Session s)
	{
		refresh((Object) reportAccess, s);
	}


}