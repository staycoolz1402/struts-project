package com.ams.mufins.model.base;

public class BasePersonalMain {

	public static String REF = "PersonalMain";
	public static String PROP_CUSTOMER_ID = "CustomerId";
	public static String PROP_FULL_NAME = "FullName";
	public static String PROP_GENDER = "Gender";
	public static String PROP_PLACE_OF_BIRTH = "PlaceOfBirth";
	public static String PROP_DATE_OF_BIRTH = "DateOfBirth";
	public static String PROP_MOTHER_MAIDEN_NAME = "MotherMaidenName";
	public static String PROP_MARRIAGE_STATUS_ID = "MarriageStatusId";
	public static String PROP_EDUCATION_ID = "EducationId";
	public static String PROP_ID_NUMBER = "IdNumber";
	public static String PROP_PHONE_NUMBER = "PhoneNumber";
	public static String PROP_HANDPHONE = "Handphone";
	public static String PROP_ADDRESS = "Address";
	public static String PROP_RT = "Rt";
	public static String PROP_RW = "Rw";
	public static String PROP_POSTAL_CODE_ID = "PostalCodeId";
	public static String PROP_PROVINCE = "Province";
	public static String PROP_CITY = "City";
	public static String PROP_SUBDISTRICT = "Subdistrict";
	public static String PROP_VILLAGE = "Village";
	public static String PROP_POSTAL_CODE = "PostalCode";
	public static String PROP_LETTER_ADDRESS = "LetterAddress";
	public static String PROP_LETTER_RT = "LetterRt";
	public static String PROP_LETTER_RW = "LetterRw";
	public static String PROP_LETTER_POSTAL_CODE_ID = "LetterPostalCodeId";
	public static String PROP_LETTER_PROVINCE = "LetterProvince";
	public static String PROP_LETTER_CITY = "LetterCity";
	public static String PROP_LETTER_SUBDISTRICT = "LetterSubdistrict";
	public static String PROP_LETTER_VILLAGE = "LetterVillage";
	public static String PROP_LETTER_POSTAL_CODE = "LetterPostalCode";
	public static String PROP_ISSUE_DATE = "IssueDate";
	public static String PROP_EMAIL = "Email";
	public static String PROP_OWNERSHIP_ID = "OwnershipId";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	public static String PROP_VERSION= "Version";

	
	// constructors
	public BasePersonalMain () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BasePersonalMain (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}
	
	// primary key
	private long id;

	// fields
	private long customerId;
	private java.lang.String fullName;
	private java.lang.String gender;
	private java.lang.String placeOfBirth;
	private java.util.Date dateOfBirth;
	private java.lang.String motherMaidenName;
	private long marriageStatusId;
	private long educationId;
	private java.lang.String idNumber;
	private java.lang.String phoneNumber;
	private java.lang.String handphone;
	private java.lang.String address;
	private java.lang.String rt;
	private java.lang.String rw;
	private long postalCodeId;
	private java.lang.String province;
	private java.lang.String city;
	private java.lang.String subdistrict;
	private java.lang.String village;
	private java.lang.String postalCode;
	private java.lang.String letterAddress;
	private java.lang.String letterRt;
	private java.lang.String letterRw;
	private long letterPostalCodeId;
	private java.lang.String letterProvince;
	private java.lang.String letterCity;
	private java.lang.String letterSubdistrict;
	private java.lang.String letterVillage;
	private java.lang.String letterPostalCode;
	private java.util.Date issueDate;
	private java.lang.String email;
	private long ownershipId;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.lang.String marriageStatusName;
	private java.lang.Integer version;
	
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

	
	public java.lang.String getMarriageStatusName() {
		return marriageStatusName;
	}

	public void setMarriageStatusName(java.lang.String marriageStatusName) {
		this.marriageStatusName = marriageStatusName;
	}

	/**
	 * @return the customerId
	 */
	public long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	/**
	 * @return the fullName
	 */
	public java.lang.String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(java.lang.String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the gender
	 */
	public java.lang.String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	public void setGender(java.lang.String gender) {
		this.gender = gender;
	}

	/**
	 * @return the placeOfBirth
	 */
	public java.lang.String getPlaceOfBirth() {
		return placeOfBirth;
	}

	/**
	 * @param placeOfBirth the placeOfBirth to set
	 */
	public void setPlaceOfBirth(java.lang.String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	/**
	 * @return the dateOfBirth
	 */
	public java.util.Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(java.util.Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return the motherMaidenName
	 */
	public java.lang.String getMotherMaidenName() {
		return motherMaidenName;
	}

	/**
	 * @param motherMaidenName the motherMaidenName to set
	 */
	public void setMotherMaidenName(java.lang.String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}

	/**
	 * @return the marriageStatusId
	 */
	public long getMarriageStatusId() {
		return marriageStatusId;
	}

	/**
	 * @param marriageStatusId the marriageStatusId to set
	 */
	public void setMarriageStatusId(long marriageStatusId) {
		this.marriageStatusId = marriageStatusId;
	}

	/**
	 * @return the educationId
	 */
	public long getEducationId() {
		return educationId;
	}

	/**
	 * @param educationId the educationId to set
	 */
	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	/**
	 * @return the idNumber
	 */
	public java.lang.String getIdNumber() {
		return idNumber;
	}

	/**
	 * @param idNumber the idNumber to set
	 */
	public void setIdNumber(java.lang.String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public java.lang.String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(java.lang.String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the handphone
	 */
	public java.lang.String getHandphone() {
		return handphone;
	}

	/**
	 * @param handphone the handphone to set
	 */
	public void setHandphone(java.lang.String handphone) {
		this.handphone = handphone;
	}

	/**
	 * @return the address
	 */
	public java.lang.String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(java.lang.String address) {
		this.address = address;
	}

	/**
	 * @return the rt
	 */
	public java.lang.String getRt() {
		return rt;
	}

	/**
	 * @param rt the rt to set
	 */
	public void setRt(java.lang.String rt) {
		this.rt = rt;
	}

	/**
	 * @return the rw
	 */
	public java.lang.String getRw() {
		return rw;
	}

	/**
	 * @param rw the rw to set
	 */
	public void setRw(java.lang.String rw) {
		this.rw = rw;
	}

	/**
	 * @return the postalCodeId
	 */
	public long getPostalCodeId() {
		return postalCodeId;
	}

	/**
	 * @param postalCodeId the postalCodeId to set
	 */
	public void setPostalCodeId(long postalCodeId) {
		this.postalCodeId = postalCodeId;
	}

	/**
	 * @return the province
	 */
	public java.lang.String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(java.lang.String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public java.lang.String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(java.lang.String city) {
		this.city = city;
	}

	/**
	 * @return the subdistrict
	 */
	public java.lang.String getSubdistrict() {
		return subdistrict;
	}

	/**
	 * @param subdistrict the subdistrict to set
	 */
	public void setSubdistrict(java.lang.String subdistrict) {
		this.subdistrict = subdistrict;
	}

	/**
	 * @return the village
	 */
	public java.lang.String getVillage() {
		return village;
	}

	/**
	 * @param village the village to set
	 */
	public void setVillage(java.lang.String village) {
		this.village = village;
	}

	/**
	 * @return the postalCode
	 */
	public java.lang.String getPostalCode() {
		return postalCode;
	}

	/**
	 * @param postalCode the postalCode to set
	 */
	public void setPostalCode(java.lang.String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * @return the letterAddress
	 */
	public java.lang.String getLetterAddress() {
		return letterAddress;
	}

	/**
	 * @param letterAddress the letterAddress to set
	 */
	public void setLetterAddress(java.lang.String letterAddress) {
		this.letterAddress = letterAddress;
	}

	/**
	 * @return the letterRt
	 */
	public java.lang.String getLetterRt() {
		return letterRt;
	}

	/**
	 * @param letterRt the letterRt to set
	 */
	public void setLetterRt(java.lang.String letterRt) {
		this.letterRt = letterRt;
	}

	/**
	 * @return the letterRw
	 */
	public java.lang.String getLetterRw() {
		return letterRw;
	}

	/**
	 * @param letterRw the letterRw to set
	 */
	public void setLetterRw(java.lang.String letterRw) {
		this.letterRw = letterRw;
	}

	/**
	 * @return the letterPostalCodeId
	 */
	public long getLetterPostalCodeId() {
		return letterPostalCodeId;
	}

	/**
	 * @param letterPostalCodeId the letterPostalCodeId to set
	 */
	public void setLetterPostalCodeId(long letterPostalCodeId) {
		this.letterPostalCodeId = letterPostalCodeId;
	}

	/**
	 * @return the letterProvince
	 */
	public java.lang.String getLetterProvince() {
		return letterProvince;
	}

	/**
	 * @param letterProvince the letterProvince to set
	 */
	public void setLetterProvince(java.lang.String letterProvince) {
		this.letterProvince = letterProvince;
	}

	/**
	 * @return the letterCity
	 */
	public java.lang.String getLetterCity() {
		return letterCity;
	}

	/**
	 * @param letterCity the letterCity to set
	 */
	public void setLetterCity(java.lang.String letterCity) {
		this.letterCity = letterCity;
	}

	/**
	 * @return the letterSubdistrict
	 */
	public java.lang.String getLetterSubdistrict() {
		return letterSubdistrict;
	}

	/**
	 * @param letterSubdistrict the letterSubdistrict to set
	 */
	public void setLetterSubdistrict(java.lang.String letterSubdistrict) {
		this.letterSubdistrict = letterSubdistrict;
	}

	/**
	 * @return the letterVillage
	 */
	public java.lang.String getLetterVillage() {
		return letterVillage;
	}

	/**
	 * @param letterVillage the letterVillage to set
	 */
	public void setLetterVillage(java.lang.String letterVillage) {
		this.letterVillage = letterVillage;
	}

	/**
	 * @return the letterPostalCode
	 */
	public java.lang.String getLetterPostalCode() {
		return letterPostalCode;
	}

	/**
	 * @param letterPostalCode the letterPostalCode to set
	 */
	public void setLetterPostalCode(java.lang.String letterPostalCode) {
		this.letterPostalCode = letterPostalCode;
	}

	/**
	 * @return the issueDate
	 */
	public java.util.Date getIssueDate() {
		return issueDate;
	}

	/**
	 * @param issueDate the issueDate to set
	 */
	public void setIssueDate(java.util.Date issueDate) {
		this.issueDate = issueDate;
	}

	/**
	 * @return the email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * @return the ownershipId
	 */
	public long getOwnershipId() {
		return ownershipId;
	}

	/**
	 * @param ownershipId the ownershipId to set
	 */
	public void setOwnershipId(long ownershipId) {
		this.ownershipId = ownershipId;
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

	public java.lang.Integer getVersion() {
		return version;
	}

	public void setVersion(java.lang.Integer version) {
		this.version = version;
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
		if (!(obj instanceof com.ams.mufins.model.PersonalMain)) return false;
		else {
			com.ams.mufins.model.PersonalMain personalMain = (com.ams.mufins.model.PersonalMain) obj;
			return (this.getId() == personalMain.getId());
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
