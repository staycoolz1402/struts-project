package com.mpe.common.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import com.mpe.common.*;



public abstract class GenericHibernateDAO<T, ID extends Serializable> 
		implements GenericDAO<T, ID> {

	Log log = LogFactory.getFactory().getInstance(this.getClass());
	
	Class<T> persistentClass;
	Session session;	
	
	@SuppressWarnings("unchecked")
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>)((ParameterizedType) getClass().getGenericSuperclass() )
			.getActualTypeArguments()[0];
	}
	
	public void setSession(Session s) {
		this.session = s;
	}
	
	public Session getSession() {
		if (session == null)
			session = HibernateUtil.getSession();
		return session;
	}
	
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public void delete(T entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(entity);
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(long id) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			T t = (T)session.get(getPersistentClass(), id);
			if (t!=null) session.delete(t);
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}		
	}	
	

	@Override
	public int delete(String sql) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		int i = 0;
		try {
			transaction = session.beginTransaction();
			Query query = session.createSQLQuery(sql);
			i = query.executeUpdate();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return i;
	}
	
	@Override
	public void delete(T entity, Session session) throws Exception {
		try {
			session.delete(entity);
		} catch(Exception exception){
			throw exception;
		} finally {
		}		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void delete(long id, Session session) throws Exception {
		try {
			T t = (T)session.get(getPersistentClass(), id);
			if (t!=null) session.delete(t);
		} catch(Exception exception){
			throw exception;
		} finally {
		}		
	}	
	

	@Override
	public int delete(String sql, Session session) throws Exception {
		int i = 0;
		try {
			Query query = session.createSQLQuery(sql);
			i = query.executeUpdate();
		} catch(Exception exception){
			throw exception;
		} finally {
		}
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		List<T> list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			list = criteria.list();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return list;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(Order order) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		List<T> list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			list = criteria.addOrder(order).list();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByExample(T exampleInstance, Order order, String... excludeProperty) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		List<T> list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			Example example = Example.create(exampleInstance);
			//example.excludeZeroes();
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
			example.ignoreCase();
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			if (order!=null) criteria.addOrder(order); 
			list = criteria.list();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public PartialList<T> findByExample(int start, int count, T exampleInstance, Order order, String... excludeProperty) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		PartialList<T> partialList = null;
		try {
			transaction = session.beginTransaction();
			// total data
			Criteria criteria = session.createCriteria(getPersistentClass());
			Example example = Example.create(exampleInstance);
			//example.excludeZeroes();
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
			example.ignoreCase();
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			criteria.setProjection(Projections.rowCount());
			//long total = ((Long)criteria.list().iterator().next()).longValue();
			Object object = criteria.list().iterator().next();
			// partial data
			criteria = session.createCriteria(getPersistentClass());
			criteria.add(example);
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			partialList = new PartialList<T>(criteria.list(), object);
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return partialList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(long id) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		T entity = null;
		try {
			transaction = session.beginTransaction();
			//entity = (T)session.get(getPersistentClass(), id, LockMode.UPGRADE);
			entity = (T)session.get(getPersistentClass(), id);
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return entity;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T findById(long id, boolean lockMode) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		T entity = null;
		try {
			transaction = session.beginTransaction();
			entity = (T)session.get(getPersistentClass(), id);
			//entity = (T)session.get(getPersistentClass(), id);
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return entity;
	}

	@Override
	public T save(T entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(entity);
			transaction.commit();
		} catch(Exception exception) {
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return entity;
	}
	
	@Override
	public T update(T entity) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.update(entity);
			transaction.commit();
		} catch(Exception exception) {
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return entity;
	}
	
	@Override
	public T save(T entity, Session session) throws Exception {
		try {
			session.save(entity);
		} catch(Exception exception) {
			throw exception;
		} finally {
		}
		return entity;
	}
	
	@Override
	public T update(T entity, Session session) throws Exception {
		try {
			session.update(entity);
		} catch(Exception exception) {
			throw exception;
		} finally {
		}
		return entity;
	}
	
	/**
	* Use this inside subclasses as a convenience method.
	*/
	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(Order order, Criterion... criterion) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		List<T> list = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				criteria.add(c);
			}
			if (order!=null) criteria.addOrder(order);
			list = criteria.list();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override	
	public PartialList<T> findByCriteria(int start, int count, Order order, Criterion... criterion) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		PartialList<T> partialList = null;
		try {
			transaction = session.beginTransaction();
			// total
			Criteria criteria = session.createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				criteria.add(c);
			}
			criteria.setProjection(Projections.rowCount());
			//long total = ((Long)criteria.list().iterator().next()).longValue();
			Object object = criteria.list().iterator().next();
			// partial data
			criteria = session.createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				criteria.add(c);
			}
			if (order!=null) criteria.addOrder(order);
			criteria.setFirstResult(start);
			criteria.setMaxResults(count);
			partialList = new PartialList<T>(criteria.list(), object);
			transaction.commit();
		} catch(Exception exception){
			exception.printStackTrace();
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return partialList;
	}
	
	/**
	* Use this inside subclasses as a convenience method.
	*/
	@SuppressWarnings("unchecked")
	@Override
	public T findByCriteria(Criterion... criterion) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		T t = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				criteria.add(c);
			}
			t = (T)criteria.setMaxResults(1).uniqueResult();
			transaction.commit();
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return t;
	}
	
	/**
	* Use this inside subclasses as a convenience method.
	*/
	@SuppressWarnings("unchecked")
	@Override
	public T findByCriteria(Session session, Criterion... criterion) throws Exception {
		T t = null;
		try {
			Criteria criteria = session.createCriteria(getPersistentClass());
			for (Criterion c : criterion) {
				criteria.add(c);
			}
			t = (T)criteria.uniqueResult();
		} catch(Exception exception){
			throw exception;
		}
		return t;
	}
	
	
	@Override
	@SuppressWarnings("unchecked")
	public T findByExample(T exampleInstance, String... excludeProperty) throws Exception {
		Session session = getSession();
		Transaction transaction = null;
		T entity = null;
		try {
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(getPersistentClass());
			Example example = Example.create(exampleInstance);
			//example.excludeZeroes();
			for (String exclude : excludeProperty) {
				example.excludeProperty(exclude);
			}
			example.ignoreCase();
			example.enableLike(MatchMode.ANYWHERE);
			criteria.add(example);
			
			entity = (T) criteria.setMaxResults(1).uniqueResult();
			transaction.commit();
			
		} catch(Exception exception){
			if (transaction!=null)transaction.rollback();
			throw exception;
		} finally {
			if (session!=null) session.close();
		}
		return entity;
		
	}

}
