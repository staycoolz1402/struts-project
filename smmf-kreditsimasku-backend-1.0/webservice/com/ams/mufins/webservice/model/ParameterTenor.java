package com.ams.mufins.webservice.model;

public class ParameterTenor {
	
	public long id;
	public String parameter;
	public int batasBawah;
	public int batasAtas;
	public int value;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public int getBatasBawah() {
		return batasBawah;
	}
	public void setBatasBawah(int batasBawah) {
		this.batasBawah = batasBawah;
	}
	public int getBatasAtas() {
		return batasAtas;
	}
	public void setBatasAtas(int batasAtas) {
		this.batasAtas = batasAtas;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
}
