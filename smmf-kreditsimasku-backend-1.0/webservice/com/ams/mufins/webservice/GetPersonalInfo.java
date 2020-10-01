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
import com.ams.mufins.model.PersonalEmployment;
import com.ams.mufins.model.PersonalMain;
import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.model.dao.PersonalEmploymentDAO;
import com.ams.mufins.model.dao.PersonalMainDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.model.PersonalInfo;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetPersonalInfo extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETPERSONALINFO".equalsIgnoreCase(action)) {
			return this.performPersonalInfo(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings({ "unused" })
	private ActionForward performPersonalInfo(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
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

			if (object.containsKey("handphone") && !object.getString("handphone").equalsIgnoreCase("")) {
				
				CustomerMobile cm = (CustomerMobile) CustomerMobileDAO.getInstance().getSession()
						.createCriteria(CustomerMobile.class)
						.add(Restrictions.eq("Handphone", object.getString("handphone"))).setMaxResults(1)
						.uniqueResult();
				
				log.info("\n\t--REQUEST GetPersonalInfo : "+object.toString()+"--");
				
				if (cm != null) {
					
					PersonalMain pm = (PersonalMain) PersonalMainDAO.getInstance().getSession().createCriteria(PersonalMain.class)
							.add(Restrictions.eq("CustomerId", cm.getId())).setMaxResults(1).uniqueResult();
					
					PersonalInfo pi = new PersonalInfo();
					pi.setFullName(cm.getFullName());
					pi.setKtp(cm.getIdNumber());
					pi.setCustomerId(cm.getId());
					
					if(pm != null) {
						
						PersonalEmployment pe = (PersonalEmployment) PersonalEmploymentDAO.getInstance().getSession().createCriteria(PersonalEmployment.class)
								.add(Restrictions.eq("Id", pm.getId())).setMaxResults(1).uniqueResult();
						
						pi.setPersonalId(pm.getId());
						if(pe != null && pe.getNpwp() != null) pi.setNpwp(!pe.getNpwp().equalsIgnoreCase("")?pe.getNpwp():""); else pi.setNpwp("");
					
					} else {
						pi.setPersonalId(0);
						pi.setNpwp("");
					}
					
					return returnResponse(response, responseMessage, responseStatus, pi);

				} else {
					
					responseMessage = "FAILED";
					return returnResponse(response, responseMessage, responseStatus, null);
					
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
				log.error("error e2 : "+e2);
			}
		}
		return this.returnResponse(response, responseMessage, responseStatus, null);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus,
			PersonalInfo pi) {
		try {
			JsonObject result = null;
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
			objectBuilderName.add("responseStatus", responseStatus);
			objectBuilderName.add("responseMessage", responseMessage);
			
			if(pi != null) {
				log.info("---GetPersonalInfo Response data : \n\t\t--nama : "+pi.getFullName()+"\n\t\t--ktp : "+pi.getKtp()+"\n\t\t--npwp : "+pi.getNpwp()+"\n\t\t--customerId : "+pi.getCustomerId()+"\n\t\t--personalId : "+pi.getPersonalId());
				JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
	        	JsonObjectBuilder objectBuilderName2 = Json.createObjectBuilder();
	        	objectBuilderName2.add("nama",pi.getFullName());
	        	objectBuilderName2.add("ktp", pi.getKtp());
	        	objectBuilderName2.add("npwp", pi.getNpwp());
	        	objectBuilderName2.add("customerId", pi.getCustomerId());
	        	objectBuilderName2.add("personalId", pi.getPersonalId());
	        	arrayBuilder.add(objectBuilderName2);
		        objectBuilderName.add("data", arrayBuilder);
		        
			}

			result = objectBuilderName.build();
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
			response.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("error creating json : "+e);
		}
		return null;
	}

}
