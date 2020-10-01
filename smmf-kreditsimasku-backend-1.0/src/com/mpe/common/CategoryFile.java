package com.mpe.common;

public enum CategoryFile {
	DOC1("DOCUMENT_CATEGORY", "SURVEYOR_DOCUMENTATION_FILE"),
	DOC2("DOCUMENT_CATEGORY", "PERSONAL_DOCUMENTATION_FILE"),
	DOC3("DOCUMENT_SAMPLING_CATEGORY", "CF_APPLICATION_SAMPLING_FILE"),
	DOC4("DOCUMENT_TYPE", "CORPORATE_DOCUMENT"),
	DOC5("MARKETING_FILE", "PERSONAL_DOCUMENTATION_FILE"),
	DOC6("SURVEYOR_IMAGE", "SURVEYOR_FILE"),
	DOC7("TERMINATION_IMAGE", "TERMINATION_FILE"),
	DOC8("PARTNER_VISIT_DOC_CATEGORY", "PARTNER_VISIT_DOC_FILE"),
	DOC9("PA_WO_FILE_CATEGORY", ""),
	DOC10("PREREFINANCE_DOCUMENT_TYPE", "");
	
	private String category;
	private String namaTable;
	
    private CategoryFile(String category, String namaTable) {
        this.category = category;
        this.namaTable = namaTable;
    }

    public String getCategory() {
        return category;
    }
    
    public String getNamaTable() {
        return namaTable;
    }
}