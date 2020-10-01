package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.ApplicationOnline;
import com.ams.mufins.model.dao.ApplicationOnlineDAO;
import com.ams.mufins.model.report.TotalReport;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetStatusKreditSimasku extends Action {
	
	Log log = LogFactory.getFactory().getInstance(this.getClass());
	
	public ActionForward execute( ActionMapping mapping, ActionForm form, 	
			HttpServletRequest request,HttpServletResponse response) throws Exception {
	
			String action = mapping.getParameter();
			if ("GETSTATUSKREDITSIMASKU".equalsIgnoreCase(action)) {
				return performGetStatus(mapping, form, request, response);
			}				

			return null;
		}
		
	private ActionForward performGetStatus(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		Date startDate = new Date();
		BufferedReader reader = null;
		JsonReader reader2 = null;
		ApplicationOnline applikasiOnline = null;
		Session session = null;
		Transaction transaction = null;
		try {
			//get paramPermintaan
			StringBuffer jb = new StringBuffer();
			String line = null;			 
		    reader = request.getReader();
		    while ((line = reader.readLine()) != null){
		      jb.append(line);
		    }
		    System.out.println("masuk ke backend");
			String body = jb.toString();
			
			if(body==null || body.equals("") || body.equals("{}")){	
				return returnResponse(response, startDate, "200", "Kolom paramPermintaan wajib diisi");
			}
			
			//1. insert parameter request ke table log_input
			reader2 = Json.createReader(new StringReader(body));
			JsonObject obj = reader2.readObject();
			
			//2. cek signature : butuh kode perusahaan dari body untuk ambil secret di DB
			try{
				
				session = ApplicationOnlineDAO.getInstance().getSession();
				transaction = session.beginTransaction();
				
				if(obj.getInt("custOnlineId")>0){
					
					String sql = "select count(1) as totalData from application_online ao " + 
							     "where core_application_id = :custOnlineId ";
					
					Query query = session.createSQLQuery(sql)
							 .addScalar("totalData", Hibernate.INTEGER)
							 .setInteger("custOnlineId", obj.getInt("custOnlineId"));
					
					TotalReport totalReport = (TotalReport) query.setResultTransformer(Transformers.aliasToBean(TotalReport.class)).setMaxResults(1).uniqueResult();
					
					if(totalReport.getTotalData()==0){
						return returnResponse(response, startDate, "200", "Kolom custOnlineId tidak ditemukan");
					}
					//TODO : cek kolom status biar cuma bisa di update status reject sekali aja
				}
				else{
					return returnResponse(response, startDate, "200", "Kolom custOnlineId wajib diisi");
				}
				
				if(obj.getInt("cfApplicationId")==0){		
					return returnResponse(response, startDate, "200", "Kolom cfApplicationId wajib diisi");
				}
				
				if(obj.getString("requestStatus").equals("")){		
					return returnResponse(response, startDate, "200", "Kolom requestStatus wajib diisi");
				}
				
				if(obj.getString("statusReason").equals("")){		
					return returnResponse(response, startDate, "200", "Kolom statusReason wajib diisi");
				}
				
				String sql = "update application_online set status =:status , status_reason =:statusReason where core_application_id = :custOnlineId ";

				//run the update
				Query query = session.createSQLQuery(sql)
							  .setString("status", obj.getString("requestStatus"))
							  .setString("statusReason", obj.getString("statusReason"))
							  .setLong("custOnlineId", Long.valueOf(obj.getInt("custOnlineId")));
				
				query.executeUpdate();
				
				transaction.commit();
				
			 } catch (Exception e) { 
				 e.printStackTrace();
				 //catch expired token
				 return returnResponse(response, startDate, "500", "Otentikasi Gagal. "+e.getMessage());
			 }
				 
		} catch (Exception e) { 
			  e.printStackTrace();
			  log.error(e.getMessage());
			  log.error("Error : "+e);
			  return returnResponse(response, startDate, "500", "Error Tidak Terdefinisi. "+e);
		}
		finally {
			try {
				if (session!=null && session.isOpen()) {
					try {
						CommonApiUtil.safeClose(session);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(reader!=null){reader.close();}
				if(reader2!=null){reader2.close();}
				ApplicationOnlineDAO.getInstance().closeSessionForReal();
			} catch (IOException e) {
				 e.printStackTrace();
			}
		}
		return returnResponse(response, startDate, "200", "Berhasil");
	}
	
	private ActionForward returnResponse(HttpServletResponse response, Date startDate, String responseCode, String description){
		try {
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
	        objectBuilderName.add("kodeRespon", responseCode);
	        objectBuilderName.add("deskripsiRespon", description.length()>100?description.substring(0,100):description);
	        
	        JsonObject paramObj = objectBuilderName.build();
	        
			PrintWriter writer = response.getWriter();
			writer.print(paramObj.toString());
			writer.flush();
			response.setContentType("application/json");
			
		} catch (IOException e) {
			e.printStackTrace();
		}		     
		
        return null;
	}
	
			
}