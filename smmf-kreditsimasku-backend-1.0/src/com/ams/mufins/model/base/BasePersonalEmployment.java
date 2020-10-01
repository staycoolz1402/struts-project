package com.ams.mufins.model.base;

public class BasePersonalEmployment {

	public static String REF = "PersonalEmployment";
	public static String PROP_JOB_ID = "JobId";
	public static String PROP_COMPANY_NAME = "CompanyName";
	public static String PROP_COMPANY_ADDRESS = "CompanyAddress";
	public static String PROP_COMPANY_RT = "CompanyRt";
	public static String PROP_COMPANY_RW = "CompanyRw";
	public static String PROP_COMPANY_POSTAL_CODE_ID = "CompanyPostalCodeId";
	public static String PROP_COMPANY_PROVINCE = "CompanyProvince";
	public static String PROP_COMPANY_CITY = "CompanyCity";
	public static String PROP_COMPANY_SUBDISTRICT = "CompanySubdistrict";
	public static String PROP_COMPANY_VILLAGE = "CompanyVillage";
	public static String PROP_COMPANY_POSTAL_CODE = "CompanyPostalCode";
	public static String PROP_COMPANY_PHONE_NUMBER = "CompanyPhoneNumber";
	public static String PROP_COMPANY_HANDPHONE_NUMBER = "CompanyHandphoneNumber";
	public static String PROP_BUSINESS_SECTOR_ID = "BusinessSectorId";
	public static String PROP_SUB_BUSINESS_SECTOR_ID = "SubBusinessSectorId";
	public static String PROP_SUB_BUSINESS_SECTOR2_ID = "SubBusinessSector2Id";
	public static String PROP_SUB_BUSINESS_SECTOR3_ID = "SubBusinessSector3Id";
	public static String PROP_JOB_RANK = "JobRank";
	public static String PROP_JOB_LENGTH = "JobLength";
	public static String PROP_SALARY = "Salary";
	public static String PROP_NPWP = "Npwp";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";


	
	// constructors
	public BasePersonalEmployment () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalEmployment (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}
	
	// primary key
	private long id;

	// fields
	private long jobId;
	private java.lang.String companyName;
	private java.lang.String companyAddress;
	private java.lang.String companyRt;
	private java.lang.String companyRw;
	private long companyPostalCodeId;
	private java.lang.String companyProvince;
	private java.lang.String companyCity;
	private java.lang.String companySubdistrict;
	private java.lang.String companyVillage;
	private java.lang.String companyPostalCode;
	private java.lang.String companyPhoneNumber;
	private java.lang.String companyHandphoneNumber;
	private long businessSectorId;
	private long subBusinessSectorId;
	private long subBusinessSector2Id;
	private long subBusinessSector3Id;
	private java.lang.String jobRank;
	private int jobLength;
	private double salary;
	private java.lang.String npwp;
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
	 * @return the jobId
	 */
	public long getJobId() {
		return jobId;
	}

	/**
	 * @param jobId the jobId to set
	 */
	public void setJobId(long jobId) {
		this.jobId = jobId;
	}

	/**
	 * @return the companyName
	 */
	public java.lang.String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(java.lang.String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyAddress
	 */
	public java.lang.String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(java.lang.String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the companyRt
	 */
	public java.lang.String getCompanyRt() {
		return companyRt;
	}

	/**
	 * @param companyRt the companyRt to set
	 */
	public void setCompanyRt(java.lang.String companyRt) {
		this.companyRt = companyRt;
	}

	/**
	 * @return the companyRw
	 */
	public java.lang.String getCompanyRw() {
		return companyRw;
	}

	/**
	 * @param companyRw the companyRw to set
	 */
	public void setCompanyRw(java.lang.String companyRw) {
		this.companyRw = companyRw;
	}

	/**
	 * @return the companyPostalCodeId
	 */
	public long getCompanyPostalCodeId() {
		return companyPostalCodeId;
	}

	/**
	 * @param companyPostalCodeId the companyPostalCodeId to set
	 */
	public void setCompanyPostalCodeId(long companyPostalCodeId) {
		this.companyPostalCodeId = companyPostalCodeId;
	}

	/**
	 * @return the companyProvince
	 */
	public java.lang.String getCompanyProvince() {
		return companyProvince;
	}

	/**
	 * @param companyProvince the companyProvince to set
	 */
	public void setCompanyProvince(java.lang.String companyProvince) {
		this.companyProvince = companyProvince;
	}

	/**
	 * @return the companyCity
	 */
	public java.lang.String getCompanyCity() {
		return companyCity;
	}

	/**
	 * @param companyCity the companyCity to set
	 */
	public void setCompanyCity(java.lang.String companyCity) {
		this.companyCity = companyCity;
	}

	/**
	 * @return the companySubdistrict
	 */
	public java.lang.String getCompanySubdistrict() {
		return companySubdistrict;
	}

	/**
	 * @param companySubdistrict the companySubdistrict to set
	 */
	public void setCompanySubdistrict(java.lang.String companySubdistrict) {
		this.companySubdistrict = companySubdistrict;
	}

	/**
	 * @return the companyVillage
	 */
	public java.lang.String getCompanyVillage() {
		return companyVillage;
	}

	/**
	 * @param companyVillage the companyVillage to set
	 */
	public void setCompanyVillage(java.lang.String companyVillage) {
		this.companyVillage = companyVillage;
	}

	/**
	 * @return the companyPostalCode
	 */
	public java.lang.String getCompanyPostalCode() {
		return companyPostalCode;
	}

	/**
	 * @param companyPostalCode the companyPostalCode to set
	 */
	public void setCompanyPostalCode(java.lang.String companyPostalCode) {
		this.companyPostalCode = companyPostalCode;
	}

	/**
	 * @return the companyPhoneNumber
	 */
	public java.lang.String getCompanyPhoneNumber() {
		return companyPhoneNumber;
	}

	/**
	 * @param companyPhoneNumber the companyPhoneNumber to set
	 */
	public void setCompanyPhoneNumber(java.lang.String companyPhoneNumber) {
		this.companyPhoneNumber = companyPhoneNumber;
	}

	/**
	 * @return the companyHandphoneNumber
	 */
	public java.lang.String getCompanyHandphoneNumber() {
		return companyHandphoneNumber;
	}

	/**
	 * @param companyHandphoneNumber the companyHandphoneNumber to set
	 */
	public void setCompanyHandphoneNumber(java.lang.String companyHandphoneNumber) {
		this.companyHandphoneNumber = companyHandphoneNumber;
	}

	/**
	 * @return the businessSectorId
	 */
	public long getBusinessSectorId() {
		return businessSectorId;
	}

	/**
	 * @param businessSectorId the businessSectorId to set
	 */
	public void setBusinessSectorId(long businessSectorId) {
		this.businessSectorId = businessSectorId;
	}

	/**
	 * @return the subBusinessSectorId
	 */
	public long getSubBusinessSectorId() {
		return subBusinessSectorId;
	}

	/**
	 * @param subBusinessSectorId the subBusinessSectorId to set
	 */
	public void setSubBusinessSectorId(long subBusinessSectorId) {
		this.subBusinessSectorId = subBusinessSectorId;
	}

	/**
	 * @return the subBusinessSector2Id
	 */
	public long getSubBusinessSector2Id() {
		return subBusinessSector2Id;
	}

	/**
	 * @param subBusinessSector2Id the subBusinessSector2Id to set
	 */
	public void setSubBusinessSector2Id(long subBusinessSector2Id) {
		this.subBusinessSector2Id = subBusinessSector2Id;
	}

	/**
	 * @return the subBusinessSector3Id
	 */
	public long getSubBusinessSector3Id() {
		return subBusinessSector3Id;
	}

	/**
	 * @param subBusinessSector3Id the subBusinessSector3Id to set
	 */
	public void setSubBusinessSector3Id(long subBusinessSector3Id) {
		this.subBusinessSector3Id = subBusinessSector3Id;
	}

	/**
	 * @return the jobRank
	 */
	public java.lang.String getJobRank() {
		return jobRank;
	}

	/**
	 * @param jobRank the jobRank to set
	 */
	public void setJobRank(java.lang.String jobRank) {
		this.jobRank = jobRank;
	}

	/**
	 * @return the jobLength
	 */
	public int getJobLength() {
		return jobLength;
	}

	/**
	 * @param jobLength the jobLength to set
	 */
	public void setJobLength(int jobLength) {
		this.jobLength = jobLength;
	}

	/**
	 * @return the salary
	 */
	public double getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(double salary) {
		this.salary = salary;
	}

	/**
	 * @return the npwp
	 */
	public java.lang.String getNpwp() {
		return npwp;
	}

	/**
	 * @param npwp the npwp to set
	 */
	public void setNpwp(java.lang.String npwp) {
		this.npwp = npwp;
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
		if (!(obj instanceof com.ams.mufins.model.PersonalEmployment)) return false;
		else {
			com.ams.mufins.model.PersonalEmployment personalEmployment = (com.ams.mufins.model.PersonalEmployment) obj;
			return (this.getId() == personalEmployment.getId());
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
