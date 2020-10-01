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
import com.ams.mufins.webservice.model.RateBunga;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetRateBunga extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETRATEBUNGA".equalsIgnoreCase(action)) {
			return this.performGetRateBunga(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	private ActionForward performGetRateBunga(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedReader reader = null;
		JsonReader reader2 = null;
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		Session session = null;
		List<RateBunga> list = null;
		
		try {
			session = UsersDAO.getInstance().getSession();
			String sql = "select rate_bunga_id as id, tipe, produk, indicator_tahun as indicatorTahun, rate_tahun_1 as rateTahun1, rate_tahun_2 as rateTahun2, rate_tahun_3 as rateTahun3, rate_tahun_4 as rateTahun4 "
					+ "from rate_bunga";
			list = (List<RateBunga>) session.createSQLQuery(sql)
					.addScalar("id", Hibernate.LONG)
					.addScalar("tipe", Hibernate.STRING)
					.addScalar("produk", Hibernate.STRING)
					.addScalar("indicatorTahun", Hibernate.STRING)
					.addScalar("rateTahun1", Hibernate.DOUBLE)
					.addScalar("rateTahun2", Hibernate.DOUBLE)
					.addScalar("rateTahun3", Hibernate.DOUBLE)
					.addScalar("rateTahun4", Hibernate.DOUBLE)
					.setResultTransformer(Transformers.aliasToBean(RateBunga.class))
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

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, List<RateBunga> list) {
		try {
			JsonArray array = null;
			String result = null;
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
			JsonObject objectFinal = null;
			
			for(RateBunga model : list) {
				JsonObject object = null;
				JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
				objectBuilder.add("id", model.getId() > 0 ? String.valueOf(model.getId()) : "0");
				objectBuilder.add("tipe", model.getTipe());
				objectBuilder.add("produk", model.getProduk());
				objectBuilder.add("indicator_tahun", model.getIndicatorTahun());
				objectBuilder.add("rate_tahun_1", model.getRateTahun1() > 0 ? String.valueOf(model.getRateTahun1()) : "0");
				objectBuilder.add("rate_tahun_2", model.getRateTahun2() > 0 ? String.valueOf(model.getRateTahun2()) : "0");
				objectBuilder.add("rate_tahun_3", model.getRateTahun3() > 0 ? String.valueOf(model.getRateTahun3()) : "0");
				objectBuilder.add("rate_tahun_4", model.getRateTahun4() > 0 ? String.valueOf(model.getRateTahun4()) : "0");
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
