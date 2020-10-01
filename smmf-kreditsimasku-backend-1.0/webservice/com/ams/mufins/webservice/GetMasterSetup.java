package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.json.Json;
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

import com.ams.mufins.model.MasterKodeAplikasi;
import com.ams.mufins.model.MasterSetup;
import com.ams.mufins.model.Personal;
import com.ams.mufins.model.PersonalBlacklist;
import com.ams.mufins.model.PersonalDetail;
import com.ams.mufins.model.dao.MasterKodeAplikasiDAO;
import com.ams.mufins.model.dao.MasterSetupDAO;
import com.ams.mufins.model.dao.OrganizationSetupDAO;
import com.ams.mufins.model.dao.PersonalBlacklistDAO;
import com.ams.mufins.model.dao.PersonalDAO;
import com.ams.mufins.model.dao.PersonalDetailDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.model.SetupResponse;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetMasterSetup extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		this.log.info((Object) ("[ START " + this.getClass().getName() + " " + action + "  ] "));
		if ("GETMASTERSETUP".equalsIgnoreCase(action)) {
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
			// log.info("--JSON request : " + body);
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
			session = OrganizationSetupDAO.getInstance().getSession();
			dataApiList = (List<MasterDataApi>) CommonApiUtil.getMasterDataApiList(session, "MASTER_API_TARIK_DATA");
			JsonObject child = null;
			
			MasterKodeAplikasi kode = (MasterKodeAplikasi) MasterKodeAplikasiDAO.getInstance().getSession()
					.createCriteria(MasterKodeAplikasi.class).add(Restrictions.eq("KodeAplikasi", "TARIK_DATA"))
					.setMaxResults(1).uniqueResult();

			String secretKey = CommonUtil
					.digest(kode.getNamaAplikasi() + kode.getKodeAplikasi() + kode.getOtentikasi());
			
			if (secretKey.equalsIgnoreCase(request.getHeader("secretKey"))) {
				if (object.containsKey("personal") && object.containsKey("personalDetail")) {

					JsonObject objectPersonal = object.getJsonObject("personal");
					JsonObject objectDetail = object.getJsonObject("personalDetail");

					for (MasterDataApi api : dataApiList) {
						currentColumnName = api.getMasterDataColumnName();
						if (api.getMasterDataTableName().equalsIgnoreCase("personal")) {
							if (api.getIsMandatory().equalsIgnoreCase("T")) {
								if (api.getMasterDataType().equalsIgnoreCase("character varying")) {
									if (!objectPersonal.containsKey((Object) api.getMasterDataColumnName())
											|| objectPersonal.getString(api.getMasterDataColumnName()).equals("")) {
										responseMessage = "ERROR : " + currentColumnName
												+ " tidak boleh kosong atau null!";
										responseStatus = 200;
										return this.returnResponse(response, responseMessage, responseStatus, null);
									}
									if (objectPersonal.getString(api.getMasterDataColumnName()).length() > api
											.getMasterDataLength()) {
										responseMessage = "ERROR : " + currentColumnName + " tidak boleh lebih dari "
												+ api.getMasterDataLength() + "!";
										responseStatus = 200;
										return this.returnResponse(response, responseMessage, responseStatus, null);
									}
									continue;
								}
							} else {
								if (object.getString(api.getMasterDataColumnName()).length() > api
										.getMasterDataLength()) {
									responseMessage = "ERROR : " + currentColumnName + " "
											+ object.getString(api.getMasterDataColumnName())
											+ " tidak boleh lebih dari " + api.getMasterDataLength() + "!";
									responseStatus = 200;
									return this.returnResponse(response, responseMessage, responseStatus, null);
								}
								continue;
							}
						} else if (api.getMasterDataTableName().equalsIgnoreCase("personalDetail")) {
							if (api.getIsMandatory().equalsIgnoreCase("T")) {
								if (api.getMasterDataType().equalsIgnoreCase("character varying")) {
									if (!objectDetail.containsKey((Object) api.getMasterDataColumnName())
											|| objectDetail.getString(api.getMasterDataColumnName()).equals("")) {
										responseMessage = "ERROR : " + currentColumnName
												+ " tidak boleh kosong atau null!";
										responseStatus = 200;
										return this.returnResponse(response, responseMessage, responseStatus, null);
									}
									if (objectDetail.getString(api.getMasterDataColumnName()).length() > api
											.getMasterDataLength()) {
										responseMessage = "ERROR : " + currentColumnName + " tidak boleh lebih dari "
												+ api.getMasterDataLength() + "!";
										responseStatus = 200;
										return this.returnResponse(response, responseMessage, responseStatus, null);
									}
									continue;
								}
							} else {
								if (object.getString(api.getMasterDataColumnName()).length() > api
										.getMasterDataLength()) {
									responseMessage = "ERROR : " + currentColumnName + " "
											+ object.getString(api.getMasterDataColumnName())
											+ " tidak boleh lebih dari " + api.getMasterDataLength() + "!";
									responseStatus = 200;
									return this.returnResponse(response, responseMessage, responseStatus, null);
								}
								continue;
							}
						}
					}
					currentColumnName = "ERROR EXCEPTION";

					if (!objectPersonal.getString("roleName").isEmpty() && !objectPersonal.getString("idNumber").isEmpty()) {

						session = PersonalDAO.getInstance().getSession();
						transaction = session.beginTransaction();

						Personal cekPersonal = (Personal) PersonalDAO.getInstance().getSession()
								.createCriteria(Personal.class)
								.add(Restrictions.and(Restrictions.eq("RoleName", objectPersonal.getString("roleName")),
										Restrictions.eq("IdNumber", objectPersonal.getString("idNumber"))))
								.setMaxResults(1).uniqueResult();

						MasterSetup master = (MasterSetup) MasterSetupDAO.getInstance().getSession()
								.createCriteria(MasterSetup.class)
								.add(Restrictions.eq("RoleName", objectPersonal.getString("roleName"))).uniqueResult();
            			
						if(master!=null) {

							long masterSetupId = master.getId();
							
							if (cekPersonal == null) {
								Timestamp currentTime = new Timestamp(System.currentTimeMillis());

								Personal personal = new Personal();
								personal.setName(objectPersonal.getString("name"));
								personal.setIdNumber(objectPersonal.getString("idNumber"));
								personal.setUserId(Long.valueOf(objectPersonal.getString("userId")));
								personal.setRoleName(objectPersonal.getString("roleName"));
								personal.setEmployeeId(Long.valueOf(objectPersonal.getString("employeeId")));
								personal.setEmployeeNik(objectPersonal.getString("employeeNik"));
								personal.setMasterSetupId(masterSetupId);
								personal.setStatus("");
								personal.setLastSyncOn(currentTime);
								personal.setCreateBy("SYSTEM");
								personal.setCreateOn(new Date());
		            			session.save(personal);

								PersonalDetail detail = new PersonalDetail();
								detail.setPersonalId(personal.getId());
								detail.setPhone(objectDetail.getString("phone"));
								detail.setDeviceId(objectDetail.getString("deviceId"));
								detail.setStatus("OPEN");
								detail.setScoreKpiMonth(Double.valueOf(objectDetail.getString("scoreKpiMonth")));
								detail.setScoreKpiDay(Double.valueOf(objectDetail.getString("scoreKpiDay")));
//		            			detail.setScoreEngineOn(scoreEngineOn);
//		            			detail.setScoreEngineEntry(scoreEngineEntry);
								detail.setCreateBy("SYSTEM");
								detail.setCreateOn(new Date());
		            			session.save(detail);
								transaction.commit();
								
								log.info(responseMessage+" Inserting & Get Setting New Personal. Id Personal : "+personal.getId());
								
								SetupResponse setup = new SetupResponse();
		            			setup.setPersonalDetailId(detail.getId());
		            			setup.setIsPulledAddressBook(master.isIsPulledAddressBook()==true?"TRUE":"FALSE");
		            			setup.setIsPulledApp(master.isIsPulledApp()==true?"TRUE":"FALSE");
		            			setup.setIsPulledCallRecord(master.isIsPulledCallRecord()==true?"TRUE":"FALSE");
		            			setup.setIsPulledSms(master.isIsPulledSms()==true?"TRUE":"FALSE");

								return this.returnResponse(response, responseMessage, responseStatus, setup);

							} else {
								
								if(cekPersonal.getLastSyncOn().compareTo(new Date()) > master.getIntervalTime()) {
									
									PersonalBlacklistDAO blacklist = (PersonalBlacklistDAO) PersonalBlacklistDAO.getInstance().getSession().createCriteria(PersonalBlacklist.class)
											.add(Restrictions.eq("", cekPersonal.getId()))
											.uniqueResult();
											
									if(blacklist == null) {
										
										PersonalDetail personalDetail = (PersonalDetail) PersonalDetailDAO.getInstance()
												.getSession().createCriteria(PersonalDetail.class)
												.add(Restrictions.eq("PersonalId", cekPersonal.getId())).setMaxResults(1)
												.uniqueResult();

										SetupResponse setup = new SetupResponse();
										setup.setPersonalDetailId(personalDetail.getId());
										setup.setIsPulledAddressBook(master.isIsPulledAddressBook() == true ? "TRUE" : "FALSE");
										setup.setIsPulledApp(master.isIsPulledApp() == true ? "TRUE" : "FALSE");
										setup.setIsPulledCallRecord(master.isIsPulledCallRecord() == true ? "TRUE" : "FALSE");
										setup.setIsPulledSms(master.isIsPulledSms() == true ? "TRUE" : "FALSE");
										
										log.info(responseMessage+" Get Setting Old Personal. Id Personal : "+cekPersonal.getId());
										
										return this.returnResponse(response, responseMessage, responseStatus, setup);
									} else {
										
										PersonalDetail personalDetail = (PersonalDetail) PersonalDetailDAO.getInstance()
												.getSession().createCriteria(PersonalDetail.class)
												.add(Restrictions.eq("PersonalId", cekPersonal.getId())).setMaxResults(1)
												.uniqueResult();

										SetupResponse setup = new SetupResponse();
										setup.setPersonalDetailId(personalDetail.getId());
										setup.setIsPulledAddressBook("FALSE");
										setup.setIsPulledApp("FALSE");
										setup.setIsPulledCallRecord("FALSE");
										setup.setIsPulledSms("FALSE");
										
										log.info(responseMessage+" Get Setting Old Personal. Id Personal : "+cekPersonal.getId());
										
										return this.returnResponse(response, responseMessage, responseStatus, setup);
										
									}
									
								} else {
									
									PersonalDetail personalDetail = (PersonalDetail) PersonalDetailDAO.getInstance()
											.getSession().createCriteria(PersonalDetail.class)
											.add(Restrictions.eq("PersonalId", cekPersonal.getId())).setMaxResults(1)
											.uniqueResult();

									SetupResponse setup = new SetupResponse();
									setup.setPersonalDetailId(personalDetail.getId());
									setup.setIsPulledAddressBook("FALSE");
									setup.setIsPulledApp("FALSE");
									setup.setIsPulledCallRecord("FALSE");
									setup.setIsPulledSms("FALSE");
									
									log.info(responseMessage+" Get Setting Old Personal. Id Personal : "+cekPersonal.getId());
									
									return this.returnResponse(response, responseMessage, responseStatus, setup);
								}
							}
						}

					}

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

			if (setup != null) {
				JsonObjectBuilder objectBuilderName2 = Json.createObjectBuilder();
				objectBuilderName2.add("personalDetailId", setup.getPersonalDetailId());
				objectBuilderName2.add("isPulledAddressBook", setup.getIsPulledAddressBook());
				objectBuilderName2.add("isPulledApp", setup.getIsPulledApp());
				objectBuilderName2.add("isPulledCallRecord", setup.getIsPulledCallRecord());
				objectBuilderName2.add("isPulledSms", setup.getIsPulledSms());
				objectBuilderName.add("data", objectBuilderName2);
			}
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
