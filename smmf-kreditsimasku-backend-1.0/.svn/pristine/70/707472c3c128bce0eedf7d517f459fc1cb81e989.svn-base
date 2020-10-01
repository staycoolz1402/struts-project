package com.ams.mufins.webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
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
import com.ams.mufins.webservice.model.Korwil;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetKorwil extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETKORWIL".equalsIgnoreCase(action)) {
			return this.performGetKorwil(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private ActionForward performGetKorwil(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		Session session = null;
		List<Korwil> list = null;
		try {
			session = UsersDAO.getInstance().getSession();
			String sql = "select " + 
					"	branchid as branchid, " +
					"	name as name " +
					"from branchs_mobile " + 
					"where branchtype = 'KORWIL' ";
			
			list = (List<Korwil>) session.createSQLQuery(sql)
					.addScalar("branchid", Hibernate.LONG)
					.addScalar("name", Hibernate.STRING)
					.setResultTransformer(Transformers.aliasToBean(Korwil.class))
					.list();
			
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
					UsersDAO.getInstance().closeSessionForReal();
				}
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
			List<Korwil> list) {
		try {
			JsonArray array = null;
			String result = null;
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
			JsonObject objectFinal = null;
			if(list!=null) {
				for(Korwil model : list) {
					JsonObject object = null;
					JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
					objectBuilder.add("branchid", model.getBranchid());
					objectBuilder.add("name", model.getName() != null && model.getName().length()>0 ? model.getName() : "");
					
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


