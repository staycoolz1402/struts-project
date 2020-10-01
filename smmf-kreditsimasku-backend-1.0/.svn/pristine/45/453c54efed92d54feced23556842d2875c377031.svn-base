package com.ams.mufins.model.base;

public class BasePersonalContact {

	public static String REF = "PersonalContact";
	public static String PROP_NAME = "Name";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_RT = "Rt";
	public static String PROP_RW = "Rw";
	public static String PROP_POSTAL_CODE_ID = "PostalCodeId";
	public static String PROP_PROVINCE = "Province";
	public static String PROP_CITY = "City";
	public static String PROP_SUBDISTRICT = "Subdistrict";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_RELATIONSHIP_ID = "RelationshipId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	
	// constructors
	public BasePersonalContact () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalContact (long id) {
		this.setId(id);
		initialize();
	}

	/**
	 * Constructor for required fields
	 */
	public BasePersonalContact (
		long id,
		long relationshipId) {

		this.setId(id);
		this.setRelationshipId(relationshipId);
		initialize();
	}

	protected void initialize () {}
	
	// primary key
	private long id;

	// fields
	private java.lang.String name;
	private java.lang.String address;
	private java.lang.String rt;
	private java.lang.String rw;
	private long postalCodeId;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String subdistrict;
	private java.lang.String village;
	private java.lang.String postalCode;
	private java.lang.String phoneNumber;
	private long relationshipId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public java.lang.String getName() {
		return name;
	}

	public void setName(java.lang.String name) {
		this.name = name;
	}

	public java.lang.String getAddress() {
		return address;
	}

	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	public java.lang.String getRt() {
		return rt;
	}

	public void setRt(java.lang.String rt) {
		this.rt = rt;
	}

	public java.lang.String getRw() {
		return rw;
	}

	public void setRw(java.lang.String rw) {
		this.rw = rw;
	}

	public long getPostalCodeId() {
		return postalCodeId;
	}

	public void setPostalCodeId(long postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	public java.lang.String getProvince() {
		return province;
	}

	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	public java.lang.String getCity() {
		return city;
	}

	public void setCity(java.lang.String city) {
		this.city = city;
	}

	public java.lang.String getSubdistrict() {
		return subdistrict;
	}

	public void setSubdistrict(java.lang.String subdistrict) {
		this.subdistrict = subdistrict;
	}

	public java.lang.String getVillage() {
		return village;
	}

	public void setVillage(java.lang.String village) {
		this.village = village;
	}

	public java.lang.String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(java.lang.String postalCode) {
		this.postalCode = postalCode;
	}

	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(long relationshipId) {
		this.relationshipId = relationshipId;
	}

	public java.lang.String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	public java.util.Date getCreateOn() {
		return createOn;
	}

	public void setCreateOn(java.util.Date createOn) {
		this.createOn = createOn;
	}

	public java.lang.String getChangeBy() {
		return changeBy;
	}

	public void setChangeBy(java.lang.String changeBy) {
		this.changeBy = changeBy;
	}

	public java.util.Date getChangeOn() {
		return changeOn;
	}

	public void setChangeOn(java.util.Date changeOn) {
		this.changeOn = changeOn;
	}

	public int getHashCode() {
		return hashCode;
	}

	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	private int hashCode = Integer.MIN_VALUE;
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.PersonalContact)) return false;
		else {
			com.ams.mufins.model.PersonalContact personalContact = (com.ams.mufins.model.PersonalContact) obj;
			return (this.getId() == personalContact.getId());
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
