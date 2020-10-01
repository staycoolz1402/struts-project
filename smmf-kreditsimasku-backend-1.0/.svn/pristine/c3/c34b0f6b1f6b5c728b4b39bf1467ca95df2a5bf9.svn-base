package com.mpe.common;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.StringType;
import org.hibernate.type.Type;

public class StringInterceptor extends EmptyInterceptor {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public boolean onLoad(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		emptyToNullString(state, types);
		return true;
	}
	
	@Override
	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		emptyToNullString(state, types);
		return true;
	}

	/**
	 * Untuk ganti string yang "" jadi null
	 * @param state
	 * @param types
	 */
	private void emptyToNullString(Object[] state, Type[] types) {
		for (int i = 0; i < types.length; i++) {
			if (types[i] instanceof StringType) {
				String data = (String) state[i];
				if(data != null && data.length() == 0) state[i] = null;// kalau data nya berupa string kosong, NULL kan saja
			}
		}
	}

}
