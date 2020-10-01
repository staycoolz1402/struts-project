package com.ams.mufins.webservice.model;

public class MasterDataApi {
	
	private long masterDataApiId;
	private String masterDataApiName;
	private String masterDataColumnName;
	private String masterDataType;
	private int masterDataLength;
	private String isMandatory;
	private String masterDataTableName;
	private String isActive;
	
	public long getMasterDataApiId() {
		return masterDataApiId;
	}
	public void setMasterDataApiId(long masterDataApiId) {
		this.masterDataApiId = masterDataApiId;
	}
	public String getMasterDataApiName() {
		return masterDataApiName;
	}
	public void setMasterDataApiName(String masterDataApiName) {
		this.masterDataApiName = masterDataApiName;
	}
	public String getMasterDataColumnName() {
		return masterDataColumnName;
	}
	public void setMasterDataColumnName(String masterDataColumnName) {
		this.masterDataColumnName = masterDataColumnName;
	}
	public String getMasterDataType() {
		return masterDataType;
	}
	public void setMasterDataType(String masterDataType) {
		this.masterDataType = masterDataType;
	}
	public int getMasterDataLength() {
		return masterDataLength;
	}
	public void setMasterDataLength(int masterDataLength) {
		this.masterDataLength = masterDataLength;
	}
	public String getIsMandatory() {
		return isMandatory;
	}
	public void setIsMandatory(String isMandatory) {
		this.isMandatory = isMandatory;
	}
	public String getMasterDataTableName() {
		return masterDataTableName;
	}
	public void setMasterDataTableName(String masterDataTableName) {
		this.masterDataTableName = masterDataTableName;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

}
