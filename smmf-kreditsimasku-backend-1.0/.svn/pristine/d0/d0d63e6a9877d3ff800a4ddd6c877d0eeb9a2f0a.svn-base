package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonDynamics;

public class GetClosestBranch extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	public static final String baseUrl = CommonDynamics.MUFINS_KREDITSIMASKU_BASE_URL;
	public static final String apiUrl = CommonDynamics.GET_CLOSEST_BRANCH_API_URL;
	public static final Integer connectTimeout = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_CONNECT_TIMEOUT);
	public static final Integer readTimeout = Integer.parseInt(CommonDynamics.MUFINS_KREDITSIMASKU_READ_TIMEOUT);
	
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETCLOSESTBRANCH".equalsIgnoreCase(action)) {
			return this.performGetClosestBranch(mapping, form, request, response);
		}
		return null;
	}

	private ActionForward performGetClosestBranch(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {
		BufferedReader reader = null;
		JsonReader reader2 = null;
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		JsonObject jsonResponse = null;
		String url = baseUrl + apiUrl;
		try {
			OutputStream os = null;
			OutputStreamWriter out = null;
			HttpURLConnection urlConn = null;
			
			URL obj = new URL(url);
			urlConn = (HttpURLConnection) obj.openConnection();
			
			urlConn.setDoOutput(true);
			urlConn.setRequestMethod("GET");
			urlConn.setRequestProperty("Content-Type", "application/json");
			urlConn.setRequestProperty("Accept", "application/json");
			urlConn.setRequestProperty("charset", "utf-8");
			urlConn.setConnectTimeout(connectTimeout);
			urlConn.setReadTimeout(readTimeout);

	        os = urlConn.getOutputStream();
			out = new OutputStreamWriter(os);
			//out.write(jObject.toString());
	        out.flush();
			out.close();
			
			
			//untuk menerima inputan
			InputStream is = urlConn.getInputStream();
			//membaca reader json
			JsonReader rdr = Json.createReader(is); 
			jsonResponse = rdr.readObject();
			
			is.close();
			rdr.close();
			
			return this.returnResponse(response, responseMessage, responseStatus, jsonResponse);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			return this.returnResponse(response, responseMessage, responseStatus, jsonResponse);
		} finally {
			try {
				CommonApiUtil.safeClose(reader);
				CommonApiUtil.safeClose(reader2);
			} catch (Exception e2) {
				e2.printStackTrace();
				log.error(e2.getMessage());
			}
		}
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, JsonObject jsonObject) {
		try {
			String result = jsonObject.toString();
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
