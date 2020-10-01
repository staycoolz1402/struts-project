package com.ams.mufins.model.base;

public class BaseDocumentationFile {

	public static String PROP_PERSONAL_ID = "PersonalId";
	public static String PROP_APPLICATION_ONLINE_ID = "ApplicationOnlineId";
	public static String PROP_FILE_CONTENT_TYPE = "FileContentType";
	public static String PROP_FILE_NAME = "FileName";
	public static String PROP_FILE_SIZE = "FileSize";
	public static String PROP_FILE_CONTENT = "FileContent";
	public static String PROP_NOTE = "Note";
	public static String PROP_CREATE_BY = "CreateBy";
	public static String PROP_CREATE_ON = "CreateOn";
	public static String PROP_CHANGE_BY = "ChangeBy";
	public static String PROP_CHANGE_ON = "ChangeOn";
	public static String PROP_DOCUMENT_CATEGORY = "DocumentCategory";
	public static String PROP_UUID = "PullOn";
	
	// constructors
	public BaseDocumentationFile () {
		initialize();
	}

	/**
	 * Constructor for primary key
	 */
	public BaseDocumentationFile (long id) {
		this.setId(id);
		initialize();
	}

	protected void initialize () {}
	
	// primary key
	private long id;

	// fields
	private long personalId;
	private long applicationOnlineId;
	private java.lang.String fileContentType;
	private java.lang.String fileName;
	private java.lang.Integer fileSize;
	private byte[] fileContent;
	private java.lang.String note;
	private java.lang.String createBy;
	private java.util.Date createOn;
	private java.lang.String changeBy;
	private java.util.Date changeOn;
	private java.lang.String documentCategory;
	private java.util.Date pullOn;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getPersonalId() {
		return personalId;
	}

	public void setPersonalId(long personalId) {
		this.personalId = personalId;
	}

	public long getApplicationOnlineId() {
		return applicationOnlineId;
	}

	public void setApplicationOnlineId(long applicationOnlineId) {
		this.applicationOnlineId = applicationOnlineId;
	}

	public java.lang.String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(java.lang.String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public java.lang.String getFileName() {
		return fileName;
	}

	public void setFileName(java.lang.String fileName) {
		this.fileName = fileName;
	}

	public java.lang.Integer getFileSize() {
		return fileSize;
	}

	public void setFileSize(java.lang.Integer fileSize) {
		this.fileSize = fileSize;
	}

	public byte[] getFileContent() {
		return fileContent;
	}

	public void setFileContent(byte[] fileContent) {
		this.fileContent = fileContent;
	}

	public java.lang.String getNote() {
		return note;
	}

	public void setNote(java.lang.String note) {
		this.note = note;
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

	public java.lang.String getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(java.lang.String documentCategory) {
		this.documentCategory = documentCategory;
	}

	public java.util.Date getPullOn() {
		return pullOn;
	}

	public void setPullOn(java.util.Date pullOn) {
		this.pullOn = pullOn;
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
		if (!(obj instanceof com.ams.mufins.model.DocumentationFile)) return false;
		else {
			com.ams.mufins.model.DocumentationFile documentationFile = (com.ams.mufins.model.DocumentationFile) obj;
			return (this.getId() == documentationFile.getId());
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
