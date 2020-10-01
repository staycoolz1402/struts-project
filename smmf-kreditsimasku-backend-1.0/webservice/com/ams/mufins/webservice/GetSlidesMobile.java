package com.ams.mufins.webservice;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLConnection;
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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.model.dao.UsersDAO;
import com.ams.mufins.webservice.model.SlidesMobile;
import com.ams.mufins.webservice.util.CommonApiUtil;

public class GetSlidesMobile extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETSLIDESMOBILE".equalsIgnoreCase(action)) {
			return this.performGetSlidesMobile(mapping, form, request, response);
		}
		return null;
	}

	private ActionForward performGetSlidesMobile(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) {  
		int responseStatus = 200;
		String responseMessage = "SUCCESS";
		Session session = null;
		List<SlidesMobile> list = null;
		try {
			String imagePath = request.getParameter("imagePath");
			if (imagePath==null) {
				session = UsersDAO.getInstance().getSession();
				String sql = "select " +
						"	slides_mobile_id as slidesMobileId, " +
						"	name as name, " +
						"	image as image, " +
						"	link as link, " +
						"	package_name as packageName, " +
						"	publish as publish, " +
						"	file_content as fileContent " +
						"from slides_mobile " +
						"where publish = 'Y' ";				
				Query query = session.createSQLQuery(sql)
						.addScalar("slidesMobileId", Hibernate.LONG)
						.addScalar("name", Hibernate.STRING)
						.addScalar("image", Hibernate.STRING)
						.addScalar("link", Hibernate.STRING)
						.addScalar("packageName", Hibernate.STRING)
						.addScalar("publish", Hibernate.CHARACTER)
						.addScalar("fileContent", Hibernate.BINARY)
						.setResultTransformer(Transformers.aliasToBean(SlidesMobile.class));
				list = (List<SlidesMobile>) query.list();
				return this.returnResponse(response, request, responseMessage, responseStatus, list);
			}else {
				session = UsersDAO.getInstance().getSession();
				String sql = "select " +
						"	slides_mobile_id as slidesMobileId, " +
						"	name as name, " +
						"	image as image, " +
						"	link as link, " +
						"	package_name as packageName, " +
						"	publish as publish, " +
						"	file_content as fileContent " +
						"from slides_mobile " +
						"where publish = 'Y' " +
						"and image = :imagePath ";				
				SlidesMobile slidesMobile = (SlidesMobile) session.createSQLQuery(sql)
						.addScalar("slidesMobileId", Hibernate.LONG)
						.addScalar("name", Hibernate.STRING)
						.addScalar("image", Hibernate.STRING)
						.addScalar("link", Hibernate.STRING)
						.addScalar("packageName", Hibernate.STRING)
						.addScalar("publish", Hibernate.CHARACTER)
						.addScalar("fileContent", Hibernate.BINARY)
						.setResultTransformer(Transformers.aliasToBean(SlidesMobile.class))
						.setString("imagePath", imagePath)
						.setMaxResults(1)
						.uniqueResult();
				byte[] imageByte = slidesMobile.getFileContent();
				request.setAttribute("contentType", this.getFileContentType(imageByte));
				StringBuffer out = new StringBuffer();
				out.append(new String(imageByte, 0, imageByte.length, "ISO-8859-1"));
				request.setAttribute("image", out.toString());
				return mapping.findForward("show");
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e.getMessage());
			log.error("Error : "+e);
			responseMessage = "ERROR Exception: " + e;
			responseStatus = 500;
			return this.returnResponse(response, request, responseMessage, responseStatus, list);
		} finally {
			try {
				if (session.isOpen()) {
					CommonApiUtil.safeClose(session);
				}
				UsersDAO.getInstance().closeSessionForReal();
			} catch (Exception e2) {
				e2.printStackTrace();
				log.error(e2.getMessage());
			}
		}
	}

	private ActionForward returnResponse(HttpServletResponse response, HttpServletRequest request, String responseMessage, int responseStatus,
			List<SlidesMobile> list) {
		try {
			JsonArray array = null;
			String result = null;
			JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
			JsonObjectBuilder objectBuilderFinal = Json.createObjectBuilder();
			JsonObject objectFinal = null;
			if(list!=null) {
				for(SlidesMobile model : list) {
					JsonObject object = null;
					JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
					objectBuilder.add("id", model.getSlidesMobileId());
					objectBuilder.add("name", model.getName() != null && model.getName().length()>0 ? model.getName() : "");
					objectBuilder.add("image", request.getRequestURL() + "?imagePath=" + model.getImage());
					objectBuilder.add("link", model.getLink() != null && model.getLink().length()>0 ? model.getLink() : "");
					objectBuilder.add("package_name", model.getPackageName() != null && model.getPackageName().length()>0 ? model.getPackageName() : "");
					objectBuilder.add("publish", model.getPublish() != null ? model.getPublish().toString() : "");
					
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
			response.setContentType("application/json");
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
    
	public String getFileContentType (byte[] fileContent) {
		String fileContentType = null;
		try {
			InputStream inputStream = new ByteArrayInputStream(fileContent);
		    String mimeType = null; //mimeType is something like "image/jpeg"
		    mimeType = URLConnection.guessContentTypeFromStream(inputStream); //Find out image type
	        String delimiter="[/]";
	        String[] tokens = mimeType.split(delimiter);
	        fileContentType = tokens[1];
		}catch(Exception e){
			e.printStackTrace();
		}
		return fileContentType;
	}

}
