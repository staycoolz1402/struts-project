package com.ams.mufins.webservice.model;

public class ParameterPenyusutan {
	
	public long id;
	public int parameter;
	public int value;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getParameter() {
		return parameter;
	}
	public void setParameter(int parameter) {
		this.parameter = parameter;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
}
