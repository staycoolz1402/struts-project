package com.ams.mufins.webservice.model;

public class ParameterPinjaman {
	
	public long id;
	public String parameter;
	public String description;
	public int valueMobil;
	public int valueMotor;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public int getValueMotor() {
		return valueMotor;
	}
	public void setValueMotor(int valueMotor) {
		this.valueMotor = valueMotor;
	}
	public String getParameter() {
		return parameter;
	}
	public void setParameter(String parameter) {
		this.parameter = parameter;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getValueMobil() {
		return valueMobil;
	}
	public void setValueMobil(int valueMobil) {
		this.valueMobil = valueMobil;
	}
	
}
