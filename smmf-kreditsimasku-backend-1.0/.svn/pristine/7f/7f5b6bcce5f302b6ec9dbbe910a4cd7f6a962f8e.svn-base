package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.CustomerMobile;
import com.ams.mufins.model.LogVendorRequest;
import com.ams.mufins.model.Vendor;
import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonDynamics;

import credit.izi.Client;

public class GetOCR extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	public static final Integer CONNECT_TIMEOUT = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_CONNECT_TIMEOUT);
	public static final Integer READ_TIMEOUT = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_READ_TIMEOUT);
	public static final String URL_VENDOR = CommonDynamics.GET_VENDOR_URL;
	public static final String VENDOR_NAME = CommonDynamics.GET_VENDOR_NAME;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		this.log.info((Object) ("[ START " + this.getClass().getName() + " " + action + "  ] "));
		if ("GETOCR".equalsIgnoreCase(action)) {
			return performGetOcr(mapping, form, request, response);
		}
		return null;
	}

	private ActionForward performGetOcr(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedReader bufferedReader = null;
		JsonReader jsonReader = null;
		int responseStatus = 200, retryAttempt = 0;
		String responseMessage = "SUCCESS", status = "";
		JsonObject jsonResponse = null, jsonRequestVendor = null;
		Session session = null;
		Transaction transaction = null;
		CustomerMobile customer = null;
		LogVendorRequest logVendor = null;
		long id = 0L;
		
		try {
			StringBuffer jsonBuffer = new StringBuffer();
			String bufferedReaderLine = null;
			bufferedReader = request.getReader();
			while ((bufferedReaderLine = bufferedReader.readLine()) != null) {
				jsonBuffer.append(bufferedReaderLine);
			}
			String body = jsonBuffer.toString();
			jsonReader = Json.createReader((Reader) new StringReader(body));
			JsonObject jsonObject = jsonReader.readObject();
			
			if(!jsonObject.containsKey("image")) {
				responseMessage = "ERROR : Harap mengambil foto ulang!";
				return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
			}
			
			if(!jsonObject.containsKey("customerId")) {
				responseMessage = "ERROR : Customer tidak terdaftar!";
				return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
			} else {
				customer = CustomerMobileDAO.getInstance().get(Long.valueOf(jsonObject.getInt("customerId")));
				if(customer==null) {
					responseMessage = "ERROR : Customer tidak terdaftar!";
					return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
				}
			}
			session = CustomerMobileDAO.getInstance().getSession();
			
			Vendor vendor = (Vendor) session.createCriteria(Vendor.class).add(Restrictions.eq("VendorName", VENDOR_NAME)).setMaxResults(1).uniqueResult();
			
			LogVendorRequest checkData = (LogVendorRequest) session.createCriteria(LogVendorRequest.class)
					.add(Restrictions.eq("CustomerId", customer.getId()))
					.add(Restrictions.eq("VendorId", vendor.getId()))
					.setMaxResults(1)
					.addOrder(Order.desc("CreateOn"))
					.uniqueResult();
			
			if(checkData!=null) {
				if(checkData.getStatus()!=null) {
					if(checkData.getStatus().equalsIgnoreCase("OK") && checkData.getResponse()!=null) { //pernah ngirim dan sukses jd ambil hasil balikan di db aja gaperlu nembak
						String input = checkData.getResponse();
						InputStream is = new ByteArrayInputStream(input.getBytes(Charset.forName("UTF-8")));
						JsonReader rdr = Json.createReader(is); 
						jsonResponse = rdr.readObject();
						return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
					}
				}
				
				Date date1 = checkData.getCreateOn();
				Date date2 = new Date();
		        DateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
		        String strDate1 = sdf.format(date1);  
		        String strDate2 = sdf.format(date2);
		        
		        Date dateA = sdf.parse(strDate1);
		        Date dateB = sdf.parse(strDate2);
		
		        if (dateA.compareTo(dateB) == 0) {
		        	retryAttempt = logCountToday(session, Long.valueOf(jsonObject.getInt("customerId")));
		        	
		        	if(retryAttempt>=3){ //kalo nge hit uda 3x ato lebih
		        		responseMessage = "ERROR : Foto tidak dapat terdeteksi, harap input data ktp!";
		        		return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
		        	}
		        } 
			} 
			
			transaction = session.beginTransaction();
			logVendor = new LogVendorRequest();
			logVendor.setVendorId(vendor.getId());
			logVendor.setCustomerId(Long.valueOf(jsonObject.getInt("customerId")));
			logVendor.setRequest(jsonObject.toString());
			logVendor.setSendOn(new Date());
			logVendor.setCreateBy(jsonObject.getString("createBy"));
			logVendor.setCreateOn(new Date());
			session.save(logVendor);
			transaction.commit();
			
			id = logVendor.getId();
			
			JsonObjectBuilder requestBuilder = Json.createObjectBuilder();
			requestBuilder.add("img", jsonObject.getString("image"));
			jsonRequestVendor = requestBuilder.build();
			
			jsonResponse = sendRequest(jsonRequestVendor, vendor.getSecretKey(), vendor.getAccessKey());
			
			if(jsonResponse.containsKey("status"))status = (jsonResponse.getString("status"));
			
			saveLogVendor(session, transaction, id, status, jsonResponse.toString());
			
			if(jsonResponse.containsKey("status") && !jsonResponse.getString("status").equalsIgnoreCase("OK")) {
				responseMessage = "ERROR : Harap mengambil foto ulang!";
				return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
			}
			
			return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
			
		} catch (Exception e) {
			e.printStackTrace();
			if(transaction!=null) transaction.rollback();
			log.error(e);
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			try {
				saveLogVendor(session, transaction, id, "ERROR", null);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return returnResponse(response, responseMessage, responseStatus, jsonResponse, retryAttempt);
		} finally {
			try {
				CommonApiUtil.safeClose(session);
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
				CustomerMobileDAO.getInstance().closeSessionForReal();
			}
		}
	}
		
	private JsonObject sendRequest (JsonObject jsonObject, String secretKey, String accessKey) throws Exception {
		JsonObject result = null;
		
		Client api = new Client(accessKey, secretKey);
        Map<String, String> data = new HashMap<>();
        data.put("img", jsonObject.getString("img"));
        String response = api.Request(URL_VENDOR, data);
		
        InputStream is = new ByteArrayInputStream(response.getBytes(Charset.forName("UTF-8")));
		//membaca reader json
		JsonReader rdr = Json.createReader(is); 
		result = rdr.readObject();
		
		is.close();
		rdr.close();
		
		return result;
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, JsonObject jsonResult, int retryAttempt) {
		try {
			JsonObject result = null, responseObject = null;
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
        	JsonObjectBuilder responseBuilder = Json.createObjectBuilder();
	        objectBuilderName.add("responseStatus", responseStatus);
	        objectBuilderName.add("responseMessage", responseMessage);
	        objectBuilderName.add("retryAttempt", retryAttempt);
	        if(jsonResult!=null) {
	        	if(jsonResult.containsKey("status") && jsonResult.getString("status").equalsIgnoreCase("OK")) {
	        		JsonObject jsonObject = jsonResult.getJsonObject("message");
	        		responseBuilder.add("name", jsonObject.containsKey("name")?jsonObject.getString("name"):"");
		        	responseBuilder.add("id", jsonObject.containsKey("id")?jsonObject.getString("id"):"");
		        	responseBuilder.add("pob", jsonObject.containsKey("pob")?jsonObject.getString("pob"):"");
		        	responseBuilder.add("dob", jsonObject.containsKey("dob")?jsonObject.getString("dob"):"");
		        	responseBuilder.add("gender", jsonObject.containsKey("gender")?jsonObject.getString("gender"):"");
		        	responseBuilder.add("address", jsonObject.containsKey("address")?jsonObject.getString("address"):"");
		        	responseBuilder.add("rt", jsonObject.containsKey("rt")?jsonObject.getString("rt"):"");
		        	responseBuilder.add("rw", jsonObject.containsKey("rw")?jsonObject.getString("rw"):"");
		        	responseBuilder.add("village", jsonObject.containsKey("village")?jsonObject.getString("village"):"");
		        	responseBuilder.add("district", jsonObject.containsKey("district")?jsonObject.getString("district"):"");
		        	responseBuilder.add("religion", jsonObject.containsKey("religion")?jsonObject.getString("religion"):"");
		        	responseBuilder.add("marital_status", jsonObject.containsKey("marital_status")?jsonObject.getString("marital_status"):"");
		        	responseBuilder.add("work", jsonObject.containsKey("work")?jsonObject.getString("work"):"");
		        	responseBuilder.add("nationnality", jsonObject.containsKey("nationnality")?jsonObject.getString("nationnality"):"");
		        	responseBuilder.add("city", jsonObject.containsKey("city")?jsonObject.getString("city"):"");
		        	responseBuilder.add("province", jsonObject.containsKey("province")?jsonObject.getString("province"):"");
		        	responseObject = responseBuilder.build();
		        	
		        	objectBuilderName.add("data", responseObject);
	        	}
	        	
	        }
	        
	        JsonObjectBuilder objectSearchParam = Json.createObjectBuilder();
	        objectSearchParam.add("result", objectBuilderName);
	        result = objectSearchParam.build();
	        
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush(); 
			response.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private static int logCountToday(Session session, long customerId) throws Exception {
		int result = 0;
		String sql = "select coalesce(count(1), 0) as total from log_vendor_request where customer_id = :customerId and cast(create_on as date) = current_date ";
		result = (int) session.createSQLQuery(sql)
				.addScalar("total", Hibernate.INTEGER)
				.setLong("customerId", customerId).setMaxResults(1).uniqueResult();
		return result;
	}
	
	private static void saveLogVendor(Session session, Transaction transaction, long id, String status, String response) throws Exception {
		transaction = session.beginTransaction();
		
		LogVendorRequest logVendor = (LogVendorRequest) session.createCriteria(LogVendorRequest.class).add(Restrictions.eq("Id", id)).setMaxResults(1).uniqueResult();
		logVendor.setResponse(response);
		logVendor.setStatus(status);
		logVendor.setReplyOn(new Date());
		logVendor.setChangeOn(new Date());
		logVendor.setChangeBy("WEBSERVICE - GET OCR");
		session.update(logVendor);
		
		transaction.commit();
	}
}

