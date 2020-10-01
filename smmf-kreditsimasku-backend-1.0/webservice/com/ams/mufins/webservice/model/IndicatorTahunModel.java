package com.ams.mufins.webservice.model;

public class IndicatorTahunModel {
	
	public long id;
	public int batasBawah;
	public int batasAtas;
	public String indicatorTahun;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getIndicatorTahun() {
		return indicatorTahun;
	}
	public void setIndicatorTahun(String indicatorTahun) {
		this.indicatorTahun = indicatorTahun;
	}
	
}
