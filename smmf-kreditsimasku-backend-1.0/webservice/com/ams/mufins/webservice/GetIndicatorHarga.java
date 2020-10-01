package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
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
import com.ams.mufins.webservice.model.IndicatorHarga;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetIndicatorHarga extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETINDICATORHARGA".equalsIgnoreCase(action)) {
			return this.performGetIndicatorHarga(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private ActionForward performGetIndicatorHarga(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
		HttpServletResponse response) {
		BufferedReader reader = null;
		JsonReader reader2 = null;
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		Session session = null;
		List<IndicatorHarga> list= null;
		
		try {
			session = UsersDAO.getInstance().getSession();
			String sql = "select indicator_harga_id as id, batas_bawah as batasBawah, batas_atas as batasAtas, indicator_harga as indicatorHarga "
					+"from indicator_harga ";
			list = (List<IndicatorHarga>) session.createSQLQuery(sql)
					.addScalar("id", Hibernate.LONG)
					.addScalar("batasBawah", Hibernate.INTEGER)
					.addScalar("batasAtas", Hibernate.INTEGER)
					.addScalar("indicatorHarga", Hibernate.STRING)
					.setResultTransformer(Transformers.aliasToBean(IndicatorHarga.class))
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
				}
				CommonApiUtil.safeClose(reader);
				CommonApiUtil.safeClose(reader2);
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
			CommonApiUtil.safeClose(reader);
			CommonApiUtil.safeClose(reader2);
		} catch (Exception e2) {
			log.error(e2.getMessage());
			e2.printStackTrace();
		}
		return this.returnResponse(response, responseMessage, responseStatus, list);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, List<IndicatorHarga> list) {
		try {
			JsonArray array = null;
			String result = null;
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
			JsonObject objectFinal = null;
			
			for(IndicatorHarga model : list) {
				JsonObject object = null;
				JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
				objectBuilder.add("id", model.getId() > 0 ? String.valueOf(model.getId()) : "0");
				objectBuilder.add("batas_bawah", model.getBatasBawah() > 0 ? String.valueOf(model.getBatasBawah()) : "0");
				objectBuilder.add("batas_atas", model.getBatasAtas() > 0 ? String.valueOf(model.getBatasAtas()) : "0");
				objectBuilder.add("indicator_harga", model.getIndicatorHarga());
				object = objectBuilder.build();
				arrayBuilder.add(object);
			}
			array = arrayBuilder.build();
			
			objectBuilderFinal.add("rs", "OK");
			objectBuilderFinal.add("l", array);
			objectFinal = objectBuilderFinal.build();

			result = objectFinal.toString();
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
