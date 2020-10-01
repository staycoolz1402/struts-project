package com.mpe.common;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class ScoringUtil {

	public static String getScoringJson(String username, long cfApplicationId, long roleGroupId, String type, long roleId, String signature){
		JsonObjectBuilder jsonIsiRequest = Json.createObjectBuilder();
		jsonIsiRequest.add("username", username);
		jsonIsiRequest.add("cfApplicationId", cfApplicationId);
		jsonIsiRequest.add("roleGroupId", roleGroupId);
		jsonIsiRequest.add("type", type);
		jsonIsiRequest.add("roleId", roleId);
		jsonIsiRequest.add("signature", signature);
		JsonObjectBuilder jsonRequest = Json.createObjectBuilder();
		jsonRequest.add("request", jsonIsiRequest);
		JsonObject scoringJson = jsonRequest.build();
		return scoringJson.toString();
	}
	
	public static void sendScoringJson(String json, String url, String syncAppHostname) throws Exception{
		OutputStream os = null;
		OutputStreamWriter out = null;
		URL urls = null;
		
		//PROD & SIT
		/*HttpsURLConnection urlConn = null;
		HttpsURLConnection.setDefaultHostnameVerifier(CommonUtil.byPass(syncAppHostname));*/
		HttpURLConnection urlConn = null;
		
		urls = new URL(url);
		urlConn = (HttpURLConnection) urls.openConnection();
		
		//PROD & SIT
		//urlConn = (HttpsURLConnection) urls.openConnection();
		
        urlConn.setDoOutput(true);
        urlConn.setRequestProperty("Accept", "application/json");
        urlConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        urlConn.setConnectTimeout(10000);
        urlConn.setReadTimeout(10000);
        urlConn.setRequestMethod("POST");

        os = urlConn.getOutputStream();
		out = new OutputStreamWriter(os);
		out.write(json);
        out.flush();
		out.close();
	}
}
