package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.CustomerMobile;
import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.model.SetupResponse;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetChangePassword extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETCHANGEPASSWORD".equalsIgnoreCase(action)) {
			return this.performChangePassword(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings({ "unused" })
	private ActionForward performChangePassword(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
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
				return this.returnResponse(response, responseMessage, responseStatus, null);
			}
			reader2 = Json.createReader((Reader) new StringReader(body));
			JsonObject object = reader2.readObject();
			if (object == null) {
				return this.returnResponse(response, responseMessage, responseStatus, null);
			}
			session = CustomerMobileDAO.getInstance().getSession();

				JsonObject objJson = null;

				if (object.containsKey("request")) {
					objJson = object.getJsonObject("request");
				}
				
				if (!objJson.getString("handphone").equalsIgnoreCase("")) {
					
					log.info("Json from Mobile : " +objJson.toString());
					transaction = session.beginTransaction();
					
					CustomerMobile cm = (CustomerMobile) CustomerMobileDAO.getInstance().getSession().createCriteria(CustomerMobile.class)
							.add(Restrictions.and(Restrictions.eq("Handphone", objJson.getString("handphone")), 
									Restrictions.eq("DeviceId", objJson.getString("deviceId")))).setMaxResults(1).uniqueResult();
					
					if(cm.getDeviceId().equalsIgnoreCase(objJson.getString("deviceId"))) {
						
						String hashPassword = CommonUtil.hashMufins(CommonUtil.decryptString(objJson.getString("oldPassword"), 
								objJson.getString("key1")));
						
						if(cm.getPassword().equalsIgnoreCase(hashPassword)) {
							
							String hashNewPassword = CommonUtil.hashMufins(CommonUtil.decryptString(objJson.getString("newPassword"), 
									objJson.getString("key2")));
							
							String sqlUpdate = "" 
									+ " update customer_mobile " 
									+ " set " 
									+ " password = :hashNewPassword "
									+ " where customer_mobile_id = :customerMobileId ";

							session.createSQLQuery(sqlUpdate)
								.setLong("customerMobileId", cm.getId())
								.setString("hashNewPassword", hashNewPassword)
								.executeUpdate();
							
							transaction.commit();
							
							return returnResponse(response, responseMessage, responseStatus, null);
							
						} else {
							responseMessage = "Password Lama Tidak Sesuai.";
							return returnResponse(response, responseMessage, responseStatus, null);
						}
					
					} else {
						
						responseMessage = "Tidak Boleh Mengganti Password Pada HP Yang Berbeda.";
						return returnResponse(response, responseMessage, responseStatus, null);
					}
					
				}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			log.error(e);
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			return this.returnResponse(response, responseMessage, responseStatus, null);
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
			}
		}
		try {
			if (session.isOpen()) {
				CommonApiUtil.safeClose(session);
			}
			CommonApiUtil.safeClose(reader);
			CommonApiUtil.safeClose(reader2);
		} catch (Exception e2) {
			log.error(e2.getMessage());
			e2.printStackTrace();
		}
		return this.returnResponse(response, responseMessage, responseStatus, null);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus,
			SetupResponse setup) {
		try {
			JsonObject result = null;
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
			objectBuilderName.add("responseStatus", responseStatus);
			objectBuilderName.add("responseMessage", responseMessage);
			result = objectBuilderName.build();
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
			response.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
