package com.mpe.common;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;

public class CommonDynamics {
	transient private static Logger log = Logger.getLogger(CommonDynamics.class);
	
	public static final String CATALINA_BASE = System.getProperty("catalina.base");
//	public static final String CATALINA_BASE = "/home/yongki/JAVA_DEV/SERVER/apache-tomcat-8.5.15";
	
	//mufinsKreditsimasku.properties
	public static final String MUFINS_KREDITSIMASKU_BASE_URL = getProperty("mufinsKreditsimasku.properties").getString("baseUrl");
	public static final String MUFINS_KREDITSIMASKU_CONNECT_TIMEOUT = getProperty("mufinsKreditsimasku.properties").getString("connectTimeout");
	public static final String MUFINS_KREDITSIMASKU_READ_TIMEOUT = getProperty("mufinsKreditsimasku.properties").getString("readTimeout");
	public static final String MUFINS_KREDITSIMASKU_BATCH_SIZE = getProperty("mufinsKreditsimasku.properties").getString("batchSize");
	public static final String GET_WILAYAH_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetWilayahApiUrl");
	public static final String GET_CLOSEST_BRANCH_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetClosestBranchApiUrl");
	public static final String GET_LOOKUP_BY_CATEGORY_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetLookupByCategory");
	public static final String GET_POSTAL_CODE_BY_TYPE_AND_PARENTID_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetPostalCodeByTypeAndParentId");
	public static final String GET_BUSINESS_SECTOR_BY_TYPE_AND_PARENTID_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetBusinessSectorByTypeAndParentId");
	public static final String GET_DEALER_REFUND_BY_LOOKUPID_API_URL = getProperty("mufinsKreditsimasku.properties").getString("GetDealerRefundByLookupId");
	public static final String GET_ADMIN_REFUND_FROM_AGENCY = getProperty("mufinsKreditsimasku.properties").getString("GetAdminRefundFromAgency");
	public static final String GET_DETAIL_PERSONAL_ID = getProperty("mufinsKreditsimasku.properties").getString("GetDetailPersonalId");
	public static final String GET_VENDOR_URL = getProperty("mufinsKreditsimasku.properties").getString("GetVendorUrl");
	public static final String GET_VENDOR_NAME = getProperty("mufinsKreditsimasku.properties").getString("GetVendorName");
	
	public static final String DOCUMENT_CATEGORY = "BPKB,SIM,KK,STNK,PERHITUNGAN_KREDIT,BUKTIKEPEMILIKANRUMAH,BUKTIPENGHASILAN";
	public static final int DIFFERENT_TIME_IN_MINUTE = 5;
	
	public static final String GET_DIALECT = HibernatePlugIn.getDatabaseDialect();
	
	/**
	 * @param propertyName
	 * @param propertyFile
	 * @return PropertiesConfiguration
	 */
	public static PropertiesConfiguration getProperty(String propertyFile){
		PropertiesConfiguration prop = null;
		try {
			prop = new PropertiesConfiguration(CATALINA_BASE + "/conf/" + propertyFile);
			
		} catch (ConfigurationException e) {
			log.error("Unhandle Exception", e);
		}
		return prop;
	}
	
	

}
