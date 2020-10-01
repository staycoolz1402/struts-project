package com.ams.mufins.webservice.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.List;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.ams.mufins.webservice.model.DetailPersonalId;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.mpe.common.CommonUtil;


public class CommonApiUtil {
	
	public static void safeClose(Session c) throws Exception{
		if(c==null) return;
		if(c.isOpen() || c.isConnected()) c.close();
	}
	
	public static void safeClose(BufferedReader c) throws Exception{
		if(c==null) return;
		c.close();
	}
	
	public static void safeClose(JsonReader c) throws Exception{
		if(c==null) return;
		c.close();
	}
	
	public static String getFormatedDate(Date date, String dateFormat) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(date);
	}
	
	public static boolean isNumeric(String data) throws Exception{
		boolean result = true;
		int index = 0;
		while(index<data.length()){
			if(data.charAt(index)!='-') {
				if(Character.isAlphabetic(data.charAt(index)) || !Character.isDigit(data.charAt(index))) {
					result = false;
					break;
				}
			}
			index++;
		}
		
		return result;
	}
	
	public static Date getDate(String date, String dateFormat) throws Exception {
		Date result = null;
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		result = sdf.parse(date);
		return result;
	}
	
	public static boolean isRightFormattedDate(String data, String dateFormat){
		boolean result = true;
		try{
			DateFormat sdf = new SimpleDateFormat(dateFormat);
	        sdf.setLenient(false);
	        sdf.parse(data);
		}catch(Exception ex){
			result = false;
		}
		
		return result;
	}
	
	public static byte[] convertToImage(String image) throws Exception{
		byte[] result = Base64.decodeBase64(image);
		return result;
	}
	
	
	public static JsonObject sendJsonAndGetResponse(String json, String url, int connectTimeout, int readTimeout, String syncAppHostname) throws Exception{
		OutputStream os = null;
		OutputStreamWriter out = null;
		HttpURLConnection urlConn = null;
		URL obj = new URL(url);
		urlConn = (HttpURLConnection) obj.openConnection();

		if(url.contains("https://")){
			urlConn = (HttpsURLConnection) obj.openConnection();
            ((HttpsURLConnection) urlConn).setDefaultHostnameVerifier(CommonUtil.byPass(syncAppHostname)); 
		}
		
        urlConn.setDoOutput(true);
        urlConn.setRequestProperty("Content-Type", "application/json");
        urlConn.setConnectTimeout(connectTimeout);
        urlConn.setReadTimeout(readTimeout);
        urlConn.setRequestMethod("POST");

        os = urlConn.getOutputStream();
		out = new OutputStreamWriter(os);
		out.write(json);
        out.flush();
		out.close();
		
		InputStream is = urlConn.getInputStream();
		
		JsonReader rdr = Json.createReader(is); 
		JsonObject jsonResponse = rdr.readObject();
		
		is.close();
		rdr.close();
		
		return jsonResponse;
	}
	
	public static JsonObject sendJsonAndGetResponseMufins(JsonObject json, String url, int connectTimeout, int readTimeout) throws Exception{
		OutputStream os = null;
		OutputStreamWriter out = null;
		HttpURLConnection urlConn = null;
		URL obj = new URL(url);
		urlConn = (HttpURLConnection) obj.openConnection();

        urlConn.setDoOutput(true);
        urlConn.setRequestProperty("Content-Type", "application/json");
        urlConn.setRequestProperty("Accept", "application/json");
		urlConn.setRequestProperty("charset", "utf-8");
        urlConn.setConnectTimeout(connectTimeout);
        urlConn.setReadTimeout(readTimeout);
        urlConn.setRequestMethod("POST");

        os = urlConn.getOutputStream();
		out = new OutputStreamWriter(os);
		out.write(json.toString());
        out.flush();
		out.close();
		
		InputStream is = urlConn.getInputStream();
		
		JsonReader rdr = Json.createReader(is); 
		JsonObject jsonResponse = rdr.readObject();
		
		is.close();
		rdr.close();
		
		return jsonResponse;
	}
	
	public static HostnameVerifier byPass(final String strHost){
		
		 HostnameVerifier allHostsValid = null;
		try {
			TrustManager[] trustAllCerts = new TrustManager[] {
		       new X509TrustManager() {
				
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				
				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}
				
				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}
		       }
			};
			
			SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		    
		    allHostsValid = new HostnameVerifier() {
				
				@Override
				public boolean verify(String hostname, SSLSession session) {
					if(hostname.equalsIgnoreCase(strHost)){
		                return true;
		            }
		            return false;
				}
			};
			return allHostsValid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allHostsValid;
	}

	
	public static boolean headerCheck (Session session, String secretKey, String companyName) throws Exception{
		String keyCheckSql = "	select count(1) as count  " + 
				 "	from registered_authorization ra " + 
				 "	where ra.secret_key = :secretKey and ra.is_active = 'T' " +
				 " and ra.company_name = :companyName ";
		int count = (int) session.createSQLQuery(keyCheckSql)
				.addScalar("count", Hibernate.INTEGER)
				.setString("secretKey", secretKey)
				.setString("companyName", companyName)
				.uniqueResult();
		if (count > 0) {
			return true;
		}
		return false;
	}
	
	
	public static String getRemoteIdentity(HttpServletRequest request) throws Exception { 
		//getRequestHeadersInMap(request);
	    String hostname = request.getRemoteHost(); // hostname

	    String computerName = null;
	    String remoteAddress = request.getRemoteAddr();
	    
        InetAddress inetAddress = InetAddress.getByName(remoteAddress);
        java.net.InetSocketAddress isa1 = new java.net.InetSocketAddress(request.getRemoteAddr(), Integer.valueOf(request.getRemotePort()));  
        String hostname1 = isa1.getHostName();
        
        computerName = inetAddress.getHostName();



        if (computerName.equalsIgnoreCase("localhost")) {
            computerName = java.net.InetAddress.getLocalHost().getCanonicalHostName();
        } 
        
	    return "User : "+computerName+", Host : "+inetAddress.getHostAddress()+", Ip : "+remoteAddress+":"+request.getRemotePort();
	}   
	
	@SuppressWarnings("rawtypes")
	public static String getRequestHeaders(HttpServletRequest request) {

		String result = "";
        //Map<String, String> result = new HashMap<>();

        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            //result.put(key, value);
            result += key+" : "+value+"\n";
        }

        return result;
    }
	
	@SuppressWarnings("rawtypes")
	public static Date sabtuMinggu(Date transactionDate, Session session) {
		
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(transactionDate);
		
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			calendar.add(Calendar.DATE, 2);
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		
		String sql = "select holiday_date as A from holiday where holiday_date >= :date order by holiday_date asc";
		List holidayList = session.createSQLQuery(sql).addScalar("A", Hibernate.CALENDAR).setDate("date", transactionDate).list();
		
		for (int i = 0; i < holidayList.size(); i++) {
			GregorianCalendar element = (GregorianCalendar) holidayList.get(i);
			
			//bukan hari sabtu ama minggu
			if (element.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && element.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
				//kl ketemu libur baru tambah 1 hari
				if (calendar.get(Calendar.YEAR) == element.get(Calendar.YEAR) && calendar.get(Calendar.MONTH) == element.get(Calendar.MONTH) && calendar.get(Calendar.DAY_OF_MONTH) == element.get(Calendar.DAY_OF_MONTH)) {
					calendar.add(Calendar.DATE, 1);
				} else {
					break;
				}
			}
			
		}
		
		if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
			calendar.add(Calendar.DATE, 2);
		} else if (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
			calendar.add(Calendar.DATE, 1);
		}
		
		return calendar.getTime();
	}
	
	public static long getForeignId(Session session, String api) throws Exception{
		long result = 0;
		String tableName = "";
		String sql = "select coalesce(max(foreign_id), 0) as id from "+tableName+";";
		
		if(api.equalsIgnoreCase("personalBlacklist")) tableName = "personal_blacklist";
		if(api.equalsIgnoreCase("biChecking")) tableName = "bi_checking";
		if(api.equalsIgnoreCase("personalEkyc")) tableName = "personal_blacklist";
		
		result = (long) session.createSQLQuery(sql).addScalar("id", Hibernate.LONG).setMaxResults(1).uniqueResult();
		
		return result+1;
	}
	
	@SuppressWarnings("unchecked")
	public static List<MasterDataApi> getMasterDataApiList (Session session, String apiName) throws Exception {
		List<MasterDataApi> list = new ArrayList<MasterDataApi>();
		
		String sql = "select master_data_api_id as masterDataApiId, master_data_api_name as masterDataApiName, master_data_column_name as masterDataColumnName, "+
				"master_data_type as masterDataType, master_data_length as masterDataLength, "+
				"is_mandatory as isMandatory, is_active as isActive, coalesce(master_data_table_name, '') as masterDataTableName "+
				"from master_data_api  where master_data_api_name = :apiName  order by master_data_api_id asc ";
		
		list = session.createSQLQuery(sql)
				.addScalar("masterDataApiId", Hibernate.LONG)
				.addScalar("masterDataApiName", Hibernate.STRING)
				.addScalar("masterDataColumnName", Hibernate.STRING)
				.addScalar("masterDataType", Hibernate.STRING)
				.addScalar("masterDataLength", Hibernate.INTEGER)
				.addScalar("isMandatory", Hibernate.STRING)
				.addScalar("isActive", Hibernate.STRING)
				.addScalar("masterDataTableName", Hibernate.STRING)
				.setString("apiName", apiName)
				.setResultTransformer(Transformers.aliasToBean(MasterDataApi.class)).list();
				
		return list;
		
	}
	
}