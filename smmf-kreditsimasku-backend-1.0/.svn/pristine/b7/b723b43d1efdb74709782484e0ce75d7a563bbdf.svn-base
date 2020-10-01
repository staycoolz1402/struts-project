package com.mpe.common.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;

import com.mpe.common.PartialList;


public interface GenericDAO<T, ID extends Serializable> {
	
	List<T> findAll() throws Exception;
	List<T> findAll(Order order) throws Exception;
	List<T> findByExample(T exampleInstance, Order order, String... excludeProperty) throws Exception;
	PartialList<T> findByExample(int start, int count, T exampleInstance, Order order, String... excludeProperty) throws Exception;
	List<T> findByCriteria(Order order, Criterion... criterion) throws Exception;
	PartialList<T> findByCriteria(int start, int count, Order order, Criterion... criterion) throws Exception;
	T findByExample(T exampleInstance, String... excludeProperty) throws Exception;
	T findById(long id) throws Exception;
	T findById(long id, boolean lockMode) throws Exception;
	// make persistent
	T save(T entity) throws Exception;
	T update(T entity) throws Exception;
	T save(T entity, Session session) throws Exception;
	T update(T entity, Session session) throws Exception;
	T findByCriteria(Criterion... criterion) throws Exception;
	T findByCriteria(Session session, Criterion... criterion) throws Exception;
	// make transient
	void delete(T entity) throws Exception;
	void delete(long id) throws Exception;
	int delete(String sql) throws Exception;
	void delete(T entity, Session session) throws Exception;
	void delete(long id, Session session) throws Exception;
	int delete(String sql, Session session) throws Exception;
	//	
	Session getSession();
}
