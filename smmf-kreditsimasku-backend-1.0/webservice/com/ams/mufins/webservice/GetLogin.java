package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.CustomerMobile;
import com.ams.mufins.model.MasterVersioning;
import com.ams.mufins.model.PersonalMain;
import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.model.dao.PersonalMainDAO;
import com.ams.mufins.webservice.model.LoginData;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.model.SetupResponse;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetLogin extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETLOGIN".equalsIgnoreCase(action)) {
			return this.performGetLogin(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings({ "unused" })
	private ActionForward performGetLogin(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedReader reader = null;
		JsonReader reader2 = null;
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		String data = "";
		Session session = null;
		Transaction transaction = null;
		String dateFormat = "yyyyMMddHHmmss";
		List<MasterDataApi> dataApiList = new ArrayList<MasterDataApi>();
		String currentColumnName = "";

		try {
			StringBuffer jb = new StringBuffer();
			String line = null;
			reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				jb.append(line);
			}
			String body = jb.toString();
			if (body == null || body.equals("") || body.equals("{}")) {
				responseMessage = "ERROR : Body JSON tidak boleh Kosong!";
				responseStatus = 200;
				data = "JSON";
				return this.returnResponse(response, responseMessage, responseStatus, null, null);
			}
			reader2 = Json.createReader((Reader) new StringReader(body));
			JsonObject object = reader2.readObject();
			if (object == null) {
				return this.returnResponse(response, responseMessage, responseStatus, null, null);
			}
			 
			session = CustomerMobileDAO.getInstance().getSession();
			
			MasterVersioning versioning = CommonUtil.getSimaskuVersion(session);
			
			JsonObject objJson = null;

			if (object.containsKey("request")) {
				objJson = object.getJsonObject("request");
			} else {
				responseMessage = "Tidak menemukan request pada server !";
				responseStatus = 200;
				return this.returnResponse(response, responseMessage, responseStatus, null, null);
			}
			
			if (objJson.getInt("version")>0) {
			
				if(objJson.getInt("version")!=versioning.getVersion()) {
					responseMessage = "Version tidak sama, harap update APK !";
					responseStatus = 200;
					return this.returnResponse(response, responseMessage, responseStatus, null, null);
				}
				
				if (!objJson.getString("handphone").equalsIgnoreCase("")) {
					
					transaction = session.beginTransaction();
					
					CustomerMobile cm = (CustomerMobile) CustomerMobileDAO.getInstance().getSession().createCriteria(CustomerMobile.class)
							.add(Restrictions.eq("Handphone", objJson.getString("handphone"))).setMaxResults(1).uniqueResult();
					
					if(cm!=null) { // kedaftar
						if(cm.getDeviceId() == null ) {
							
							String sqlUpdate = "" 
									+ " update customer_mobile " 
									+ " set " 
									+ " device_id = :deviceId "
									+ " where customer_mobile_id = :customerMobileId ";

							session.createSQLQuery(sqlUpdate)
								.setLong("customerMobileId", cm.getId())
								.setString("deviceId", objJson.getString("deviceId"))
								.executeUpdate();
							
							transaction.commit();
							
							PersonalMain pm = (PersonalMain) PersonalMainDAO.getInstance().getSession().createCriteria(PersonalMain.class)
									.add(Restrictions.eq("CustomerId", cm.getId())).uniqueResult();
							
							LoginData ld = new LoginData();
							if(pm != null) {
								ld.setPersonalId(pm.getId());
							}
							ld.setCustomerId(cm.getId());
							ld.setCompletedLongCif(cm.isCompletedLongCif());
							
							return returnResponse(response, responseMessage, responseStatus, null, ld);
							
						} else {
							if(cm.getDeviceId().equalsIgnoreCase(objJson.getString("deviceId"))) {
								
								String hashPassword = CommonUtil.hashMufins(CommonUtil.decryptString(objJson.getString("password"), objJson.getString("key")));
								
								if(cm.getPassword().equalsIgnoreCase(hashPassword)) {
									
									PersonalMain pm = (PersonalMain) PersonalMainDAO.getInstance().getSession().createCriteria(PersonalMain.class)
											.add(Restrictions.eq("CustomerId", cm.getId())).uniqueResult();
									
									LoginData ld = new LoginData();
									if(pm != null) {
										ld.setPersonalId(pm.getId());
									}
									ld.setCustomerId(cm.getId());
									ld.setCompletedLongCif(cm.isCompletedLongCif());
									
									return returnResponse(response, responseMessage, responseStatus, null, ld);
									
								} else {
									responseMessage = "Password Salah.";
									return returnResponse(response, responseMessage, responseStatus, null, null);
								}
							} else {
								responseMessage = "Device harus sama dengan yang digunakan saat registrasi.";
								return returnResponse(response, responseMessage, responseStatus, null, null);
							}
						}
					} else {
						responseMessage = "Nomor belum terdaftar.";
						return returnResponse(response, responseMessage, responseStatus, null, null);
					}
				}
			}
			
			 
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			log.error(e.getMessage());
			log.error("Error : "+e);
			responseMessage = "ERROR : " + e.getMessage();
			responseStatus = 500;
			return this.returnResponse(response, responseMessage, responseStatus, null, null);
		} finally {
			try {
				if (session.isOpen()) {
					CommonApiUtil.safeClose(session);
				}
				CommonApiUtil.safeClose(reader);
				CommonApiUtil.safeClose(reader2);
				CustomerMobileDAO.getInstance().closeSessionForReal();
			} catch (Exception e2) {
				e2.printStackTrace();
				log.error(e2.getMessage());
				log.error("Error : "+e2);
			}
		}
		return this.returnResponse(response, responseMessage, responseStatus, null, null);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus,
			SetupResponse setup, LoginData ld) {
		try {
			JsonObject result = null;
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
			objectBuilderName.add("responseStatus", responseStatus);
			objectBuilderName.add("responseMessage", responseMessage);
			
			if(ld != null) {
				
				JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		        if(ld.getPersonalId() > 0 ){
		        	JsonObjectBuilder objectBuilderName2 = Json.createObjectBuilder();
		        	objectBuilderName2.add("personalId",ld.getPersonalId());
		        	objectBuilderName2.add("customerId", ld.getCustomerId());
		        	objectBuilderName2.add("isCompletedLongCif", ld.isCompletedLongCif()?"T":"F");
		        	arrayBuilder.add(objectBuilderName2);
			        	
		        } else {
		        	
		        	JsonObjectBuilder objectBuilderName2 = Json.createObjectBuilder();
		        	objectBuilderName2.add("personalId", 0);
		        	objectBuilderName2.add("customerId", ld.getCustomerId());
		        	objectBuilderName2.add("isCompletedLongCif", ld.isCompletedLongCif()?"T":"F");
		        	arrayBuilder.add(objectBuilderName2);
		        	
		        }
		        
		        objectBuilderName.add("data", arrayBuilder);
		        
			}
			
			result = objectBuilderName.build();
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Error : "+e);
		}
		return null;
	}

}

