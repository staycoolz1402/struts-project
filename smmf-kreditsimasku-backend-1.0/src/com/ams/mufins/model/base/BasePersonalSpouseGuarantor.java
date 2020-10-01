package com.ams.mufins.model.base;

public class BasePersonalSpouseGuarantor {

	public static String REF = "PersonalSpouseGuarantor";
	public static String PROP_SPOUSE_FULL_NAME = "SpouseFullName";
	public static String PROP_SPOUSE_PLACE_OF_BIRTH = "SpousePlaceOfBirth";
	public static String PROP_SPOUSE_DATE_OF_BIRTH = "SpouseDateOfBirth";
	public static String PROP_SPOUSE_ID_NUMBER = "SpouseIdNumber";
	public static String PROP_SPOUSE_JOB_ID = "SpouseJobId";
	public static String PROP_SPOUSE_COMPANY_NAME = "SpouseCompanyName";
	public static String PROP_SPOUSE_COMPANY_ADDRESS = "SpouseCompanyAddress";
	public static String PROP_SPOUSE_COMPANY_RT = "SpouseCompanyRt";
	public static String PROP_SPOUSE_COMPANY_RW = "SpouseCompanyRw";
	public static String PROP_SPOUSE_COMPANY_POSTAL_CODE_ID = "SpouseCompanyPostalCodeId";
	public static String PROP_SPOUSE_COMPANY_PROVINCE = "SpouseCompanyProvince";
	public static String PROP_SPOUSE_COMPANY_CITY = "SpouseCompanyCity";
	public static String PROP_SPOUSE_COMPANY_SUBDISTRICT = "SpouseCompanySubdistrict";
	public static String PROP_SPOUSE_COMPANY_VILLAGE = "SpouseCompanyVillage";
	public static String PROP_SPOUSE_COMPANY_POSTAL_CODE = "SpouseCompanyPostalCode";
	public static String PROP_SPOUSE_COMPANY_PHONE_NUMBER = "SpouseCompanyPhone_number";
	public static String PROP_SPOUSE_HANDPHONE = "SpouseHandphone";
	public static String PROP_SPOUSE_BUSINESS_SECTOR_ID = "SpouseBusinessSectorId";
	public static String PROP_SPOUSE_SUB_BUSINESS_SEC_ID = "SpouseSub_businessSecId";
	public static String PROP_SPOUSE_SUBBUSINESS_SEC2_ID = "SpouseSubbusinessSec2Id";
	public static String PROP_SPOUSE_SUBBUSINESS_SEC3_ID = "SpouseSubbusinessSec3Id";
	public static String PROP_SPOUSE_JOB_RANK = "SpouseJobRank";
	public static String PROP_SPOUSE_JOB_LENGTH = "SpouseJobLength";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	
	// constructors
	public BasePersonalSpouseGuarantor () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalSpouseGuarantor (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}
	
	// primary key
	private long id;

	// fields
	private java.lang.String spouseFullName;
	private java.lang.String spousePlaceOfBirth;
	private java.util.Date spouseDateOfBirth;
	private java.lang.String spouseIdNumber;
	private long spouseJobId;
	private java.lang.String spouseCompanyName;
	private java.lang.String spouseCompanyAddress;
	private java.lang.String spouseCompanyRt;
	private java.lang.String spouseCompanyRw;
	private long spouseCompanyPostalCodeId;
	private java.lang.String spouseCompanyProvince;
	private java.lang.String spouseCompanyCity;
	private java.lang.String spouseCompanySubdistrict;
	private java.lang.String spouseCompanyVillage;
	private java.lang.String spouseCompanyPostalCode;
	private java.lang.String spouseCompanyPhoneNumber;
	private java.lang.String spouseHandphone;
	private long spouseBusinessSectorId;
	private long spouseSubBusinessSecId;
	private long spouseSubbusinessSec2Id;
	private long spouseSubbusinessSec3Id;
	private java.lang.String spouseJobRank;
	private int spouseJobLength;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the spouseFullName
	 */
	public java.lang.String getSpouseFullName() {
		return spouseFullName;
	}

	/**
	 * @param spouseFullName the spouseFullName to set
	 */
	public void setSpouseFullName(java.lang.String spouseFullName) {
		this.spouseFullName = spouseFullName;
	}

	/**
	 * @return the spousePlaceOfBirth
	 */
	public java.lang.String getSpousePlaceOfBirth() {
		return spousePlaceOfBirth;
	}

	/**
	 * @param spousePlaceOfBirth the spousePlaceOfBirth to set
	 */
	public void setSpousePlaceOfBirth(java.lang.String spousePlaceOfBirth) {
		this.spousePlaceOfBirth = spousePlaceOfBirth;
	}

	/**
	 * @return the spouseDateOfBirth
	 */
	public java.util.Date getSpouseDateOfBirth() {
		return spouseDateOfBirth;
	}

	/**
	 * @param spouseDateOfBirth the spouseDateOfBirth to set
	 */
	public void setSpouseDateOfBirth(java.util.Date spouseDateOfBirth) {
		this.spouseDateOfBirth = spouseDateOfBirth;
	}

	/**
	 * @return the spouseIdNumber
	 */
	public java.lang.String getSpouseIdNumber() {
		return spouseIdNumber;
	}

	/**
	 * @param spouseIdNumber the spouseIdNumber to set
	 */
	public void setSpouseIdNumber(java.lang.String spouseIdNumber) {
		this.spouseIdNumber = spouseIdNumber;
	}

	/**
	 * @return the spouseJobId
	 */
	public long getSpouseJobId() {
		return spouseJobId;
	}

	/**
	 * @param spouseJobId the spouseJobId to set
	 */
	public void setSpouseJobId(long spouseJobId) {
		this.spouseJobId = spouseJobId;
	}

	/**
	 * @return the spouseCompanyName
	 */
	public java.lang.String getSpouseCompanyName() {
		return spouseCompanyName;
	}

	/**
	 * @param spouseCompanyName the spouseCompanyName to set
	 */
	public void setSpouseCompanyName(java.lang.String spouseCompanyName) {
		this.spouseCompanyName = spouseCompanyName;
	}

	/**
	 * @return the spouseCompanyAddress
	 */
	public java.lang.String getSpouseCompanyAddress() {
		return spouseCompanyAddress;
	}

	/**
	 * @param spouseCompanyAddress the spouseCompanyAddress to set
	 */
	public void setSpouseCompanyAddress(java.lang.String spouseCompanyAddress) {
		this.spouseCompanyAddress = spouseCompanyAddress;
	}

	/**
	 * @return the spouseCompanyRt
	 */
	public java.lang.String getSpouseCompanyRt() {
		return spouseCompanyRt;
	}

	/**
	 * @param spouseCompanyRt the spouseCompanyRt to set
	 */
	public void setSpouseCompanyRt(java.lang.String spouseCompanyRt) {
		this.spouseCompanyRt = spouseCompanyRt;
	}

	/**
	 * @return the spouseCompanyRw
	 */
	public java.lang.String getSpouseCompanyRw() {
		return spouseCompanyRw;
	}

	/**
	 * @param spouseCompanyRw the spouseCompanyRw to set
	 */
	public void setSpouseCompanyRw(java.lang.String spouseCompanyRw) {
		this.spouseCompanyRw = spouseCompanyRw;
	}

	/**
	 * @return the spouseCompanyPostalCodeId
	 */
	public long getSpouseCompanyPostalCodeId() {
		return spouseCompanyPostalCodeId;
	}

	/**
	 * @param spouseCompanyPostalCodeId the spouseCompanyPostalCodeId to set
	 */
	public void setSpouseCompanyPostalCodeId(long spouseCompanyPostalCodeId) {
		this.spouseCompanyPostalCodeId = spouseCompanyPostalCodeId;
	}

	/**
	 * @return the spouseCompanyProvince
	 */
	public java.lang.String getSpouseCompanyProvince() {
		return spouseCompanyProvince;
	}

	/**
	 * @param spouseCompanyProvince the spouseCompanyProvince to set
	 */
	public void setSpouseCompanyProvince(java.lang.String spouseCompanyProvince) {
		this.spouseCompanyProvince = spouseCompanyProvince;
	}

	/**
	 * @return the spouseCompanyCity
	 */
	public java.lang.String getSpouseCompanyCity() {
		return spouseCompanyCity;
	}

	/**
	 * @param spouseCompanyCity the spouseCompanyCity to set
	 */
	public void setSpouseCompanyCity(java.lang.String spouseCompanyCity) {
		this.spouseCompanyCity = spouseCompanyCity;
	}

	/**
	 * @return the spouseCompanySubdistrict
	 */
	public java.lang.String getSpouseCompanySubdistrict() {
		return spouseCompanySubdistrict;
	}

	/**
	 * @param spouseCompanySubdistrict the spouseCompanySubdistrict to set
	 */
	public void setSpouseCompanySubdistrict(java.lang.String spouseCompanySubdistrict) {
		this.spouseCompanySubdistrict = spouseCompanySubdistrict;
	}

	/**
	 * @return the spouseCompanyVillage
	 */
	public java.lang.String getSpouseCompanyVillage() {
		return spouseCompanyVillage;
	}

	/**
	 * @param spouseCompanyVillage the spouseCompanyVillage to set
	 */
	public void setSpouseCompanyVillage(java.lang.String spouseCompanyVillage) {
		this.spouseCompanyVillage = spouseCompanyVillage;
	}

	/**
	 * @return the spouseCompanyPostal_code
	 */
	/**
	 * @return the spouseHandphone
	 */
	public java.lang.String getSpouseHandphone() {
		return spouseHandphone;
	}

	public java.lang.String getSpouseCompanyPostalCode() {
		return spouseCompanyPostalCode;
	}

	public void setSpouseCompanyPostalCode(java.lang.String spouseCompanyPostalCode) {
		this.spouseCompanyPostalCode = spouseCompanyPostalCode;
	}

	public java.lang.String getSpouseCompanyPhoneNumber() {
		return spouseCompanyPhoneNumber;
	}

	public void setSpouseCompanyPhoneNumber(java.lang.String spouseCompanyPhoneNumber) {
		this.spouseCompanyPhoneNumber = spouseCompanyPhoneNumber;
	}

	/**
	 * @param spouseHandphone the spouseHandphone to set
	 */
	public void setSpouseHandphone(java.lang.String spouseHandphone) {
		this.spouseHandphone = spouseHandphone;
	}

	/**
	 * @return the spouseBusinessSectorId
	 */
	public long getSpouseBusinessSectorId() {
		return spouseBusinessSectorId;
	}

	/**
	 * @param spouseBusinessSectorId the spouseBusinessSectorId to set
	 */
	public void setSpouseBusinessSectorId(long spouseBusinessSectorId) {
		this.spouseBusinessSectorId = spouseBusinessSectorId;
	}

	/**
	 * @return the spouseSub_businessSecId
	 */

	/**
	 * @return the spouseSubbusinessSec2Id
	 */
	public long getSpouseSubbusinessSec2Id() {
		return spouseSubbusinessSec2Id;
	}

	public long getSpouseSubBusinessSecId() {
		return spouseSubBusinessSecId;
	}

	public void setSpouseSubBusinessSecId(long spouseSubBusinessSecId) {
		this.spouseSubBusinessSecId = spouseSubBusinessSecId;
	}

	/**
	 * @param spouseSubbusinessSec2Id the spouseSubbusinessSec2Id to set
	 */
	public void setSpouseSubbusinessSec2Id(long spouseSubbusinessSec2Id) {
		this.spouseSubbusinessSec2Id = spouseSubbusinessSec2Id;
	}

	/**
	 * @return the spouseSubbusinessSec3Id
	 */
	public long getSpouseSubbusinessSec3Id() {
		return spouseSubbusinessSec3Id;
	}

	/**
	 * @param spouseSubbusinessSec3Id the spouseSubbusinessSec3Id to set
	 */
	public void setSpouseSubbusinessSec3Id(long spouseSubbusinessSec3Id) {
		this.spouseSubbusinessSec3Id = spouseSubbusinessSec3Id;
	}

	/**
	 * @return the spouseJobRank
	 */
	public java.lang.String getSpouseJobRank() {
		return spouseJobRank;
	}

	/**
	 * @param spouseJobRank the spouseJobRank to set
	 */
	public void setSpouseJobRank(java.lang.String spouseJobRank) {
		this.spouseJobRank = spouseJobRank;
	}

	/**
	 * @return the spouseJobLength
	 */
	public int getSpouseJobLength() {
		return spouseJobLength;
	}

	/**
	 * @param spouseJobLength the spouseJobLength to set
	 */
	public void setSpouseJobLength(int spouseJobLength) {
		this.spouseJobLength = spouseJobLength;
	}

	/**
	 * @return the createBy
	 */
	public java.lang.String getCreateBy() {
		return createBy;
	}

	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(java.lang.String createBy) {
		this.createBy = createBy;
	}

	/**
	 * @return the createOn
	 */
	public java.util.Date getCreateOn() {
		return createOn;
	}

	/**
	 * @param createOn the createOn to set
	 */
	public void setCreateOn(java.util.Date createOn) {
		this.createOn = createOn;
	}

	/**
	 * @return the changeBy
	 */
	public java.lang.String getChangeBy() {
		return changeBy;
	}

	/**
	 * @param changeBy the changeBy to set
	 */
	public void setChangeBy(java.lang.String changeBy) {
		this.changeBy = changeBy;
	}

	/**
	 * @return the changeOn
	 */
	public java.util.Date getChangeOn() {
		return changeOn;
	}

	/**
	 * @param changeOn the changeOn to set
	 */
	public void setChangeOn(java.util.Date changeOn) {
		this.changeOn = changeOn;
	}

	/**
	 * @return the hashCode
	 */
	public int getHashCode() {
		return hashCode;
	}

	/**
	 * @param hashCode the hashCode to set
	 */
	public void setHashCode(int hashCode) {
		this.hashCode = hashCode;
	}

	private int hashCode = Integer.MIN_VALUE;
	
	public boolean equals (Object obj) {
		if (null == obj) return false;
		if (!(obj instanceof com.ams.mufins.model.PersonalSpouseGuarantor)) return false;
		else {
			com.ams.mufins.model.PersonalSpouseGuarantor personalSpouseGuarantor = (com.ams.mufins.model.PersonalSpouseGuarantor) obj;
			return (this.getId() == personalSpouseGuarantor.getId());
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
