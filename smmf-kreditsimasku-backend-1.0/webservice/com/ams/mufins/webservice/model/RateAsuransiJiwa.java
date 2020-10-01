package com.ams.mufins.webservice.model;

public class RateAsuransiJiwa {
	
	public long id;
	public String keterangan;
	public int batasBawah;
	public long batasAtas;
	public int biayaTahun1;
	public int biayaTahun2;
	public int biayaTahun3;
	public int biayaTahun4;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKeterangan() {
		return keterangan;
	}
	public void setKeterangan(String keterangan) {
		this.keterangan = keterangan;
	}
	public double getBatasBawah() {
		return batasBawah;
	}
	
	public long getBatasAtas() {
		return batasAtas;
	}
	public void setBatasAtas(long batasAtas) {
		this.batasAtas = batasAtas;
	}
	public int getBiayaTahun1() {
		return biayaTahun1;
	}
	public void setBiayaTahun1(int biayaTahun1) {
		this.biayaTahun1 = biayaTahun1;
	}
	public int getBiayaTahun2() {
		return biayaTahun2;
	}
	public void setBiayaTahun2(int biayaTahun2) {
		this.biayaTahun2 = biayaTahun2;
	}
	public int getBiayaTahun3() {
		return biayaTahun3;
	}
	public void setBiayaTahun3(int biayaTahun3) {
		this.biayaTahun3 = biayaTahun3;
	}
	public int getBiayaTahun4() {
		return biayaTahun4;
	}
	public void setBiayaTahun4(int biayaTahun4) {
		this.biayaTahun4 = biayaTahun4;
	}
	public void setBatasBawah(int batasBawah) {
		this.batasBawah = batasBawah;
	}
	
}
