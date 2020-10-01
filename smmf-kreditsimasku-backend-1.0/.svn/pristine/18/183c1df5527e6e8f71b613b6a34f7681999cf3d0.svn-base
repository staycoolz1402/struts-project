package com.ams.mufins.model.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.ams.mufins.model.dao.ViewBlockMultipleHistoryDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseViewBlockMultipleHistoryDAO extends com.ams.mufins.model.dao._RootDAO {

	// query name references


	public static ViewBlockMultipleHistoryDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static ViewBlockMultipleHistoryDAO getInstance () {
		if (null == instance) instance = new ViewBlockMultipleHistoryDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.ams.mufins.model.ViewBlockMultipleHistory.class;
	}

    public Order getDefaultOrder () {
		return null;
    }

	/**
	 * Cast the object as a com.ams.mufins.model.ViewBlockMultipleHistory
	 */
	public com.ams.mufins.model.ViewBlockMultipleHistory cast (Object object) {
		return (com.ams.mufins.model.ViewBlockMultipleHistory) object;
	}

	public com.ams.mufins.model.ViewBlockMultipleHistory get(long key)
	{
		return (com.ams.mufins.model.ViewBlockMultipleHistory) get(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.ViewBlockMultipleHistory get(long key, Session s)
	{
		return (com.ams.mufins.model.ViewBlockMultipleHistory) get(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.ViewBlockMultipleHistory load(long key)
	{
		return (com.ams.mufins.model.ViewBlockMultipleHistory) load(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.ViewBlockMultipleHistory load(long key, Session s)
	{
		return (com.ams.mufins.model.ViewBlockMultipleHistory) load(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.ViewBlockMultipleHistory loadInitialize(long key, Session s) 
	{ 
		com.ams.mufins.model.ViewBlockMultipleHistory obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param viewBlockMultipleHistory a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory)
	{
		return (java.lang.Long) super.save(viewBlockMultipleHistory);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param viewBlockMultipleHistory a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory, Session s)
	{
		return (java.lang.Long) save((Object) viewBlockMultipleHistory, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param viewBlockMultipleHistory a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory)
	{
		saveOrUpdate((Object) viewBlockMultipleHistory);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param viewBlockMultipleHistory a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory, Session s)
	{
		saveOrUpdate((Object) viewBlockMultipleHistory, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param viewBlockMultipleHistory a transient instance containing updated state
	 */
	public void update(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory) 
	{
		update((Object) viewBlockMultipleHistory);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param viewBlockMultipleHistory a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory, Session s)
	{
		update((Object) viewBlockMultipleHistory, s);
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
	 * @param viewBlockMultipleHistory the instance to be removed
	 */
	public void delete(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory)
	{
		delete((Object) viewBlockMultipleHistory);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param viewBlockMultipleHistory the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory, Session s)
	{
		delete((Object) viewBlockMultipleHistory, s);
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
	public void refresh (com.ams.mufins.model.ViewBlockMultipleHistory viewBlockMultipleHistory, Session s)
	{
		refresh((Object) viewBlockMultipleHistory, s);
	}


}