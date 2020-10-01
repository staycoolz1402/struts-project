package com.ams.mufins.model.base;

import java.io.Serializable;


/**
 * This is an object that contains data related to the master_kode_aplikasi table.
 * Do not modify this class because it will be overwritten if the configuration file
 * related to this class is modified.
 *
 * @hibernate.class
 *  table="master_kode_aplikasi"
 */

public abstract class BaseMasterKodeAplikasi  implements Serializable {

	public static String REF = "MasterKodeAplikasi";
	public static String PROP_KODE_APLIKASI = "KodeAplikasi";
	public static String PROP_NAMA_APLIKASI = "NamaAplikasi";
	public static String PROP_OTENTIKASI = "Otentikasi";
	public static String PROP_DIBUAT_OLEH = "DibuatOleh";
	public static String PROP_DIBUAT_PADA = "DibuatPada";
	public static String PROP_DIUBAH_OLEH = "DiubahOleh";
	public static String PROP_DIUBAH_PADA = "DiubahPada";


	// constructors
	public BaseMasterKodeAplikasi () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseMasterKodeAplikasi (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BaseMasterKodeAplikasi (
		long id,
		java.lang.String kodeAplikasi,
		java.lang.String namaAplikasi,
		java.lang.String otentikasi) {

		this.setId(id);
		this.setKodeAplikasi(kodeAplikasi);
		this.setNamaAplikasi(namaAplikasi);
		this.setOtentikasi(otentikasi);
		initialize();
	}

	protected void initialize () {}



	private int hashCode = Integer.MIN_VALUE;

	// primary key
	private long id;

	// fields
	private java.lang.String kodeAplikasi;
	private java.lang.String namaAplikasi;
	private java.lang.String otentikasi;
	private java.lang.String dibuatOleh;
	private java.util.Date dibuatPada;
	private java.lang.String diubahOleh;
	private java.util.Date diubahPada;



	/**
	 * Return the unique identifier of this class
     * @hibernate.id
     *  generator-class="sequence"
     *  column="master_kode_aplikasi_id"
     */
	public long getId () {
		return id;
	}

	/**
	 * Set the unique identifier of this class
	 * @param id the new ID
	 */
	public void setId (long id) {
		this.id = id;
		this.hashCode = Integer.MIN_VALUE;
	}




	/**
	 * Return the value associated with the column: kode_aplikasi
	 */
	public java.lang.String getKodeAplikasi () {
		return kodeAplikasi;
	}

	/**
	 * Set the value related to the column: kode_aplikasi
	 * @param kodeAplikasi the kode_aplikasi value
	 */
	public void setKodeAplikasi (java.lang.String kodeAplikasi) {
		this.kodeAplikasi = kodeAplikasi;
	}



	/**
	 * Return the value associated with the column: nama_aplikasi
	 */
	public java.lang.String getNamaAplikasi () {
		return namaAplikasi;
	}

	/**
	 * Set the value related to the column: nama_aplikasi
	 * @param namaAplikasi the nama_aplikasi value
	 */
	public void setNamaAplikasi (java.lang.String namaAplikasi) {
		this.namaAplikasi = namaAplikasi;
	}



	/**
	 * Return the value associated with the column: otentikasi
	 */
	public java.lang.String getOtentikasi () {
		return otentikasi;
	}

	/**
	 * Set the value related to the column: otentikasi
	 * @param otentikasi the otentikasi value
	 */
	public void setOtentikasi (java.lang.String otentikasi) {
		this.otentikasi = otentikasi;
	}



	/**
	 * Return the value associated with the column: dibuat_oleh
	 */
	public java.lang.String getDibuatOleh () {
		return dibuatOleh;
	}

	/**
	 * Set the value related to the column: dibuat_oleh
	 * @param dibuatOleh the dibuat_oleh value
	 */
	public void setDibuatOleh (java.lang.String dibuatOleh) {
		this.dibuatOleh = dibuatOleh;
	}



	/**
	 * Return the value associated with the column: dibuat_pada
	 */
	public java.util.Date getDibuatPada () {
		return dibuatPada;
	}

	/**
	 * Set the value related to the column: dibuat_pada
	 * @param dibuatPada the dibuat_pada value
	 */
	public void setDibuatPada (java.util.Date dibuatPada) {
		this.dibuatPada = dibuatPada;
	}



	/**
	 * Return the value associated with the column: diubah_oleh
	 */
	public java.lang.String getDiubahOleh () {
		return diubahOleh;
	}

	/**
	 * Set the value related to the column: diubah_oleh
	 * @param diubahOleh the diubah_oleh value
	 */
	public void setDiubahOleh (java.lang.String diubahOleh) {
		this.diubahOleh = diubahOleh;
	}



	/**
	 * Return the value associated with the column: diubah_pada
	 */
	public java.util.Date getDiubahPada () {
		return diubahPada;
	}

	/**
	 * Set the value related to the column: diubah_pada
	 * @param diubahPada the diubah_pada value
	 */
	public void setDiubahPada (java.util.Date diubahPada) {
		this.diubahPada = diubahPada;
	}





	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.MasterKodeAplikasi)) return false;
		else {
			com.ams.mufins.model.MasterKodeAplikasi masterKodeAplikasi = (com.ams.mufins.model.MasterKodeAplikasi) obj;
			return (this.getId() == masterKodeAplikasi.getId());
		}
	}

	public int hashCode () {
		if (Integer.MIN_VALUE == this.hashCode) {
			return (int) this.getId();
		}
		return this.hashCode;
	}


	public String toString () {
		return super.toString();
	}


}