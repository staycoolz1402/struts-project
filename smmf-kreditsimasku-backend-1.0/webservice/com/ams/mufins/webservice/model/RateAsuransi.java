package com.ams.mufins.webservice.model;

public class RateAsuransi {
	
	public long id;
	public String tipe;
	public String indicatorHarga;
	public String kategoriAsuransi;
	public double rateWilayah1;
	public double rateWilayah2;
	public double rateWilayah3;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTipe() {
		return tipe;
	}
	public void setTipe(String tipe) {
		this.tipe = tipe;
	}
	public String getIndicatorHarga() {
		return indicatorHarga;
	}
	public void setIndicatorHarga(String indicatorHarga) {
		this.indicatorHarga = indicatorHarga;
	}
	public String getKategoriAsuransi() {
		return kategoriAsuransi;
	}
	public void setKategoriAsuransi(String kategoriAsuransi) {
		this.kategoriAsuransi = kategoriAsuransi;
	}
	public double getRateWilayah1() {
		return rateWilayah1;
	}
	public void setRateWilayah1(double rateWilayah1) {
		this.rateWilayah1 = rateWilayah1;
	}
	public double getRateWilayah2() {
		return rateWilayah2;
	}
	public void setRateWilayah2(double rateWilayah2) {
		this.rateWilayah2 = rateWilayah2;
	}
	public double getRateWilayah3() {
		return rateWilayah3;
	}
	public void setRateWilayah3(double rateWilayah3) {
		this.rateWilayah3 = rateWilayah3;
	}
	
}
