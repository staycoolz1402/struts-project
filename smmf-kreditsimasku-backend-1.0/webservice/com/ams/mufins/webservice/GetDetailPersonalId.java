package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
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
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.dao.UsersDAO;
import com.ams.mufins.webservice.model.DetailPersonalId;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonDynamics;

public class GetDetailPersonalId extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	public static final String baseUrl = CommonDynamics.MUFINS_KREDITSIMASKU_BASE_URL;
	public static final String apiUrl = CommonDynamics.GET_DETAIL_PERSONAL_ID;
	public static final Integer connectTimeout = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_CONNECT_TIMEOUT);
	public static final Integer readTimeout = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_READ_TIMEOUT);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETDETAILPERSONALID".equalsIgnoreCase(action)) {
			return this.performGetDetailPersonalId(mapping, form, request, response);
		}
		return null;
	}

	private ActionForward performGetDetailPersonalId(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedReader bufferedReader = null;
		JsonReader jsonReader = null;
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		JsonObject jsonResponse = null;
		String url = baseUrl + apiUrl;
		List<DetailPersonalId> list = null;
		Session session = null;
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonArray array = null;
		JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
		JsonObject objectFinal = null;
		
		try {
			StringBuffer jsonBuffer = new StringBuffer();
			String bufferedReaderLine = null;
			bufferedReader = request.getReader();
			while ((bufferedReaderLine = bufferedReader.readLine()) != null) {
				jsonBuffer.append(bufferedReaderLine);
			}
			String body = jsonBuffer.toString();
			
			if (body == null || body.equals("") || body.equals("{}")) {
				responseMessage = "ERROR : Body JSON tidak boleh Kosong!";
				responseStatus = 200;
				return this.returnResponse(response, responseMessage, responseStatus, objectFinal);
			}
			
			jsonReader = Json.createReader((Reader) new StringReader(body));
			JsonObject jsonObject = jsonReader.readObject();
			
			if(jsonObject.getInt("personalId")==0) {
				responseMessage = "Tidak terdapat Personal Id";
				responseStatus = 200;
				return this.returnResponse(response, responseMessage, responseStatus, objectFinal);
			}
			
			session = UsersDAO.getInstance().getSession();
			
			String sql = "select application_date as applicationDate, "
					+ "coalesce(status, 'PROCESSING') as status, "
					+ "vehicle_collateral_reference_id as vehicleCollRefId, " 
					+ "lease_back as leaseBack " 
					+ "from application_online " 
					+ "where core_application_id is not null and core_application_id >0 and personal_id = :personalId "
					+ "order by application_date desc ";
			
			list = (List<DetailPersonalId>) session.createSQLQuery(sql)
					.addScalar("applicationDate", Hibernate.DATE)
					.addScalar("status", Hibernate.STRING)
					.addScalar("leaseBack", Hibernate.STRING)
					.addScalar("vehicleCollRefId", Hibernate.LONG)
					.setResultTransformer(Transformers.aliasToBean(DetailPersonalId.class))
					.setInteger("personalId", jsonObject.getInt("personalId"))
					.list();
			
			
			for(DetailPersonalId dpi : list) {
				JsonObject object = null;
				JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
				jsonBuilder.add("vehicleCollRefId", dpi.getVehicleCollRefId());
		        JsonObject paramObj = jsonBuilder.build();
		        
				jsonResponse = CommonApiUtil.sendJsonAndGetResponseMufins(paramObj, url, connectTimeout, readTimeout);
				
				JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
				DateFormat dateFormat1 = new SimpleDateFormat("dd/MM/yyyy");  
				objectBuilder.add("leaseBack", dpi.getLeaseBack());
				String strDate = dateFormat1.format(dpi.getApplicationDate());  
				objectBuilder.add("applicationDate", strDate);
				if(dpi.getStatus().equalsIgnoreCase("PROCESSING")) {
					objectBuilder.add("status", "Dalam Proses");
				} else {
					objectBuilder.add("status", dpi.getStatus());
				}
				objectBuilder.add("vehicleCollateralRefName", jsonResponse.getString("reffName"));
				object = objectBuilder.build();
				
				arrayBuilder.add(object);
			}
			array = arrayBuilder.build();
			
			if(array.size()>0) {
				objectBuilderFinal.add("responseStatus", responseStatus);
				objectBuilderFinal.add("responseMessage", responseMessage);
				objectBuilderFinal.add("l", array);
				objectFinal = objectBuilderFinal.build();
				
				return this.returnResponse(response, responseMessage, responseStatus, objectFinal);
			} else {
				responseStatus = 200;
				responseMessage = "data kosong";
				return this.returnResponse(response, responseMessage, responseStatus, objectFinal);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			return this.returnResponse(response, responseMessage, responseStatus, objectFinal);
		} finally {
			try {
				CommonApiUtil.safeClose(bufferedReader);
				CommonApiUtil.safeClose(jsonReader);
				UsersDAO.getInstance().closeSessionForReal();
			} catch (Exception e2) {
				e2.printStackTrace();
				log.error(e2.getMessage());
			}
		}
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, JsonObject jsonObject) {
		try {
			
			String result = "";
			if(jsonObject != null) {
				result = jsonObject.toString();
			} else {
				JsonObject hasil = null;
				JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
				objectBuilder.add("responseStatus", responseStatus);
				objectBuilder.add("responseMessage", responseMessage);
				hasil = objectBuilder.build();
				
				result = hasil.toString();
			}
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
