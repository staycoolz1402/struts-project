package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.dao.UsersDAO;
import com.ams.mufins.webservice.model.Branch;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetBranch extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETBRANCH".equalsIgnoreCase(action)) {
			return this.performGetBranch(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private ActionForward performGetBranch(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		Session session = null;
		List<Branch> list = null;
		BufferedReader bufferedReader = null;
		JsonReader jsonReader = null;
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
				return this.returnResponse(response, responseMessage, responseStatus, list);
			}
			jsonReader = Json.createReader((Reader) new StringReader(body));
			JsonObject jsonObject = jsonReader.readObject();
			if (jsonObject == null || !jsonObject.containsKey("branchid")) {
				responseMessage = "ERROR : Body JSON tidak sesuai format!";
				responseStatus = 200;
				return this.returnResponse(response, responseMessage, responseStatus, list);
			}
			session = UsersDAO.getInstance().getSession();
			String sql = "select " + 
					"	branchid as branchid, " + 
					"	name as name, " + 
					"	wilayah as wilayah, " + 
					"	parentid as parentid, " + 
					"	branchtype as branchtype, " + 
					"	address1 as address1, " + 
					"	address2 as address2, " + 
					"	telp as telp, " + 
					"	fax as fax, " + 
					"	city as city, " + 
					"	postalcode as postalcode, " + 
					"	latitude as latitude, " + 
					"	longitude as longitude " + 
					"from branchs_mobile " + 
					"where parentid = :branchid ";
			
			Query query = session.createSQLQuery(sql)
					.addScalar("branchid", Hibernate.LONG)
					.addScalar("name", Hibernate.STRING)
					.addScalar("wilayah", Hibernate.LONG)
					.addScalar("parentid", Hibernate.LONG)
					.addScalar("address1", Hibernate.STRING)
					.addScalar("address2", Hibernate.STRING)
					.addScalar("telp", Hibernate.STRING)
					.addScalar("fax", Hibernate.STRING)
					.addScalar("city", Hibernate.STRING)
					.addScalar("postalcode", Hibernate.STRING)
					.addScalar("latitude", Hibernate.DOUBLE)
					.addScalar("longitude", Hibernate.DOUBLE)
					.setResultTransformer(Transformers.aliasToBean(Branch.class))
					.setInteger("branchid", Integer.parseInt(jsonObject.getString("branchid")));
			
			list = (List<Branch>) query.list();
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			return this.returnResponse(response, responseMessage, responseStatus, list);
		} finally {
			try {
				if (session.isOpen()) {
					CommonApiUtil.safeClose(session);
				}
				CommonApiUtil.safeClose(bufferedReader);
				CommonApiUtil.safeClose(jsonReader);
				UsersDAO.getInstance().closeSessionForReal();
			} catch (Exception e2) {
				e2.printStackTrace();
				log.error(e2.getMessage());
			}
		}
		try {
			if (session.isOpen()) {
				CommonApiUtil.safeClose(session);
			}
		} catch (Exception e2) {
			log.error(e2.getMessage());
			e2.printStackTrace();
		}
		return this.returnResponse(response, responseMessage, responseStatus, list);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus,
			List<Branch> list) {
		try {
			JsonArray array = null;
			String result = null;
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
			JsonObject objectFinal = null;
			if(list!=null) {
				for(Branch model : list) {
					JsonObject object = null;
					JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
					objectBuilder.add("branchid", model.getBranchid());
					objectBuilder.add("name", model.getName() != null && model.getName().length()>0 ? model.getName() : "");
					objectBuilder.add("wilayah", model.getWilayah());
					objectBuilder.add("parentid", model.getParentid());
					objectBuilder.add("address1", model.getAddress1() != null && model.getAddress1().length()>0 ? model.getAddress1() : "");
					objectBuilder.add("address2", model.getAddress2() != null && model.getAddress2().length()>0 ? model.getAddress2() : "");
					objectBuilder.add("telp", model.getTelp() != null && model.getTelp().length()>0 ? model.getTelp() : "");
					objectBuilder.add("fax", model.getFax() != null && model.getFax().length()>0 ? model.getFax() : "");
					objectBuilder.add("city", model.getCity() != null && model.getCity().length()>0 ? model.getCity() : "");
					objectBuilder.add("postalcode", model.getPostalcode() != null && model.getPostalcode().length()>0 ? model.getPostalcode() : "");
					objectBuilder.add("latitude", model.getLatitude());
					objectBuilder.add("longitude", model.getLongitude());
					
					object = objectBuilder.build();
					arrayBuilder.add(object);
				}
				array = arrayBuilder.build();
				
				objectBuilderFinal.add("rs", "OK");
				objectBuilderFinal.add("l", array);
				objectFinal = objectBuilderFinal.build();
				
				result = objectFinal.toString();
			}else {
				objectBuilderFinal.add("rs", "NOK");
				objectBuilderFinal.add("l", responseMessage);
				objectFinal = objectBuilderFinal.build();
				
				result = objectFinal.toString();
			
			}
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

