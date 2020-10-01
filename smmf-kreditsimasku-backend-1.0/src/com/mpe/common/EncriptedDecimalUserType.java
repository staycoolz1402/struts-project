package com.mpe.common;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;
import org.jasypt.util.numeric.BasicDecimalNumberEncryptor;

public class EncriptedDecimalUserType implements UserType {

	private BasicDecimalNumberEncryptor encryptor;
	
	public EncriptedDecimalUserType() {
		encryptor = new BasicDecimalNumberEncryptor();
		encryptor.setPassword("91f8asiracretsulc");
	}
	
	@Override
	public Object assemble(Serializable arg0, Object arg1)
			throws HibernateException {
		return arg0;
	}

	@Override
	public Object deepCopy(Object arg0) throws HibernateException {
		return arg0;
	}

	@Override
	public Serializable disassemble(Object arg0) throws HibernateException {
		return (Serializable) arg0;
	}

	@Override
	public boolean equals(Object arg0, Object arg1) throws HibernateException {
		return arg0.equals(arg1);
	}

	@Override
	public int hashCode(Object arg0) throws HibernateException {
		return arg0.hashCode();
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Object nullSafeGet(ResultSet arg0, String[] arg1, Object arg2)
			throws HibernateException, SQLException {
		double value = arg0.getDouble(arg1[0]);
		return encryptor.decrypt(new BigDecimal(value));
	}

	@Override
	public void nullSafeSet(PreparedStatement arg0, Object arg1, int arg2)
			throws HibernateException, SQLException {
		if (arg1 == null) {
			arg0.setNull(arg2, Hibernate.BIG_DECIMAL.sqlType());
		} else {
			BigDecimal decimal = encryptor.encrypt((BigDecimal) arg1);
			arg0.setBigDecimal(arg2, decimal);
		}
		
	}

	@Override
	public Object replace(Object arg0, Object arg1, Object arg2)
			throws HibernateException {
		return arg0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class returnedClass() {
		return String.class;
	}

	@Override
	public int[] sqlTypes() {
		return new  int[]{Hibernate.STRING.sqlType()};
	}
	
	

}
