package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
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

import com.ams.mufins.model.LogCallRecord;
import com.ams.mufins.model.Lookup;
import com.ams.mufins.model.MasterKodeAplikasi;
import com.ams.mufins.model.dao.LookupDAO;
import com.ams.mufins.model.dao.MasterKodeAplikasiDAO;
import com.ams.mufins.model.dao.MasterSetupDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.model.SetupResponse;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetLogCallRecord extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		this.log.info((Object) ("[ START " + this.getClass().getName() + " " + action + "  ] "));
		if ("GETLOGCALLRECORD".equalsIgnoreCase(action)) {
			return this.performMasterSetup(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings({ "unused" })
	private ActionForward performMasterSetup(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
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
			session = MasterSetupDAO.getInstance().getSession();

			MasterKodeAplikasi kode = (MasterKodeAplikasi) MasterKodeAplikasiDAO.getInstance().getSession()
					.createCriteria(MasterKodeAplikasi.class).add(Restrictions.eq("KodeAplikasi", "TARIK_DATA"))
					.setMaxResults(1).uniqueResult();

			String secretKey = CommonUtil
					.digest(kode.getNamaAplikasi() + kode.getKodeAplikasi() + kode.getOtentikasi());

			if (secretKey.equalsIgnoreCase(request.getHeader("secretKey"))) {
				if (object.containsKey("personalDetailId") && object.containsKey("logCallRecord")) {
					JsonArray jsonArray = (JsonArray) object.get("logCallRecord");
					transaction = session.beginTransaction();

					SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

					Long personalDetailId = Long.valueOf(object.getString("personalDetailId"));

					for (int i = 0; i < jsonArray.size(); i++) {
						JsonObject jsn = jsonArray.getJsonObject(i);

						String call = jsn.getString("callTime");
						Date callTime = formatter.parse(call);

						Lookup lookup = (Lookup) LookupDAO.getInstance().getSession().createCriteria(Lookup.class)
								.add(Restrictions.and(Restrictions.eq("Category", "CALL"),
										Restrictions.eq("Code", jsn.getString("type"))))
								.setMaxResults(1).uniqueResult();

						LogCallRecord logCallRecord = new LogCallRecord();
						logCallRecord.setPersonalDetailId(personalDetailId);
						logCallRecord.setCallTime(callTime);
						logCallRecord.setDuration(Integer.parseInt(jsn.getString("duration")));
						logCallRecord.setName(jsn.getString("name"));
						logCallRecord.setPhone(jsn.getString("phone"));
						logCallRecord.setTypeId(lookup.getId());
						logCallRecord.setCreateBy("SYSTEM");
						logCallRecord.setCreateOn(new Date());
						session.save(logCallRecord);
						
					}
					log.info(responseMessage+" Inserting Log Call Record Personal Detail Id : "+personalDetailId);
					transaction.commit();
				}
			} else {
				responseMessage = "ERROR : Secret Key tidak terdaftar!";
				log.info(responseMessage);
				responseStatus = 200;
				return returnResponse(response, responseMessage, responseStatus, null);
			}
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			log.error(e.getMessage());
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
		this.log.info((Object) ("[ END " + this.getClass().getName() + " - " + responseStatus + " - " + responseMessage
				+ " ] "));
		return null;
	}

}
