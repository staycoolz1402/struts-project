package com.ams.mufins.model.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.ams.mufins.model.dao.StatusDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseStatusDAO extends com.ams.mufins.model.dao._RootDAO {

	// query name references


	public static StatusDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static StatusDAO getInstance () {
		if (null == instance) instance = new StatusDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.ams.mufins.model.Status.class;
	}

    public Order getDefaultOrder () {
		return Order.asc("Name");
    }

	/**
	 * Cast the object as a com.ams.mufins.model.Status
	 */
	public com.ams.mufins.model.Status cast (Object object) {
		return (com.ams.mufins.model.Status) object;
	}

	public com.ams.mufins.model.Status get(long key)
	{
		return (com.ams.mufins.model.Status) get(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.Status get(long key, Session s)
	{
		return (com.ams.mufins.model.Status) get(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.Status load(long key)
	{
		return (com.ams.mufins.model.Status) load(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.Status load(long key, Session s)
	{
		return (com.ams.mufins.model.Status) load(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.Status loadInitialize(long key, Session s) 
	{ 
		com.ams.mufins.model.Status obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param status a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.Status status)
	{
		return (java.lang.Long) super.save(status);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param status a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.Status status, Session s)
	{
		return (java.lang.Long) save((Object) status, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param status a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ams.mufins.model.Status status)
	{
		saveOrUpdate((Object) status);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param status a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ams.mufins.model.Status status, Session s)
	{
		saveOrUpdate((Object) status, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param status a transient instance containing updated state
	 */
	public void update(com.ams.mufins.model.Status status) 
	{
		update((Object) status);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param status a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ams.mufins.model.Status status, Session s)
	{
		update((Object) status, s);
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
	 * @param status the instance to be removed
	 */
	public void delete(com.ams.mufins.model.Status status)
	{
		delete((Object) status);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param status the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ams.mufins.model.Status status, Session s)
	{
		delete((Object) status, s);
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
	public void refresh (com.ams.mufins.model.Status status, Session s)
	{
		refresh((Object) status, s);
	}


}