package com.ams.mufins.model.base;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import com.ams.mufins.model.dao.LookupDAO;
import org.hibernate.criterion.Order;

/**
 * This is an automatically generated DAO class which should not be edited.
 */
public abstract class BaseLookupDAO extends com.ams.mufins.model.dao._RootDAO {

	// query name references


	public static LookupDAO instance;

	/**
	 * Return a singleton of the DAO
	 */
	public static LookupDAO getInstance () {
		if (null == instance) instance = new LookupDAO();
		return instance;
	}

	public Class getReferenceClass () {
		return com.ams.mufins.model.Lookup.class;
	}

    public Order getDefaultOrder () {
		return Order.asc("Name");
    }

	/**
	 * Cast the object as a com.ams.mufins.model.Lookup
	 */
	public com.ams.mufins.model.Lookup cast (Object object) {
		return (com.ams.mufins.model.Lookup) object;
	}

	public com.ams.mufins.model.Lookup get(long key)
	{
		return (com.ams.mufins.model.Lookup) get(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.Lookup get(long key, Session s)
	{
		return (com.ams.mufins.model.Lookup) get(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.Lookup load(long key)
	{
		return (com.ams.mufins.model.Lookup) load(getReferenceClass(), new java.lang.Long(key));
	}

	public com.ams.mufins.model.Lookup load(long key, Session s)
	{
		return (com.ams.mufins.model.Lookup) load(getReferenceClass(), new java.lang.Long(key), s);
	}

	public com.ams.mufins.model.Lookup loadInitialize(long key, Session s) 
	{ 
		com.ams.mufins.model.Lookup obj = load(key, s); 
		if (!Hibernate.isInitialized(obj)) {
			Hibernate.initialize(obj);
		} 
		return obj; 
	}


	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * @param lookup a transient instance of a persistent class 
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.Lookup lookup)
	{
		return (java.lang.Long) super.save(lookup);
	}

	/**
	 * Persist the given transient instance, first assigning a generated identifier. (Or using the current value
	 * of the identifier property if the assigned generator is used.) 
	 * Use the Session given.
	 * @param lookup a transient instance of a persistent class
	 * @param s the Session
	 * @return the class identifier
	 */
	public java.lang.Long save(com.ams.mufins.model.Lookup lookup, Session s)
	{
		return (java.lang.Long) save((Object) lookup, s);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default
	 * the instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the
	 * identifier property mapping. 
	 * @param lookup a transient instance containing new or updated state 
	 */
	public void saveOrUpdate(com.ams.mufins.model.Lookup lookup)
	{
		saveOrUpdate((Object) lookup);
	}

	/**
	 * Either save() or update() the given instance, depending upon the value of its identifier property. By default the
	 * instance is always saved. This behaviour may be adjusted by specifying an unsaved-value attribute of the identifier
	 * property mapping. 
	 * Use the Session given.
	 * @param lookup a transient instance containing new or updated state.
	 * @param s the Session.
	 */
	public void saveOrUpdate(com.ams.mufins.model.Lookup lookup, Session s)
	{
		saveOrUpdate((Object) lookup, s);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * @param lookup a transient instance containing updated state
	 */
	public void update(com.ams.mufins.model.Lookup lookup) 
	{
		update((Object) lookup);
	}

	/**
	 * Update the persistent state associated with the given identifier. An exception is thrown if there is a persistent
	 * instance with the same identifier in the current session.
	 * Use the Session given.
	 * @param lookup a transient instance containing updated state
	 * @param the Session
	 */
	public void update(com.ams.mufins.model.Lookup lookup, Session s)
	{
		update((Object) lookup, s);
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
	 * @param lookup the instance to be removed
	 */
	public void delete(com.ams.mufins.model.Lookup lookup)
	{
		delete((Object) lookup);
	}

	/**
	 * Remove a persistent instance from the datastore. The argument may be an instance associated with the receiving
	 * Session or a transient instance with an identifier associated with existing persistent state. 
	 * Use the Session given.
	 * @param lookup the instance to be removed
	 * @param s the Session
	 */
	public void delete(com.ams.mufins.model.Lookup lookup, Session s)
	{
		delete((Object) lookup, s);
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
	public void refresh (com.ams.mufins.model.Lookup lookup, Session s)
	{
		refresh((Object) lookup, s);
	}


}