package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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

import com.ams.mufins.model.ApplicationOnline;
import com.ams.mufins.model.MasterVersioning;
import com.ams.mufins.model.PersonalEmployment;
import com.ams.mufins.model.dao.CustomerMobileDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetSimulasiKredit extends Action {
	Logger log = Logger.getLogger(this.getClass());

	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String action = mapping.getParameter();
		if ("GETSIMULASIKREDIT".equalsIgnoreCase(action)) {
			return this.performSimulasiKredit(mapping, form, request, response);
		}
		return null;
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private ActionForward performSimulasiKredit(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request,
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
		String npwp = "";
		PersonalEmployment personalEmployment = null;
		boolean permitted = true;

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
				data = "JSON";
				return this.returnResponse(response, responseMessage, responseStatus, null);
			}
			reader2 = Json.createReader((Reader) new StringReader(body));
			log.info("\n--REQUEST GetSimulasiKredit : "+body+"--\n");
			JsonObject object = reader2.readObject();
			if (object == null) {
				return this.returnResponse(response, responseMessage, responseStatus, null);
			}
			session = CustomerMobileDAO.getInstance().getSession();
			
			MasterVersioning versioning = CommonUtil.getSimaskuVersion(session);
			
			if (object.getInt("version")>0) {
				if(object.getInt("version")!=versioning.getVersion()) {
					responseMessage = "Version tidak sama, harap update APK !";
					return this.returnResponse(response, responseMessage, responseStatus, null);
				}
				
				if(object.getInt("personalId") == 0) {
					responseMessage = "Data personal tidak ada!";
					return this.returnResponse(response, responseMessage, responseStatus, null);
				} else {
					if (!object.getString("product").equalsIgnoreCase("")) {
						
						List<ApplicationOnline> checkList = (List<ApplicationOnline>) session.createCriteria(ApplicationOnline.class)
								.add(Restrictions.eq("PersonalId", Long.valueOf(object.getInt("personalId"))))
								.add(Restrictions.eq("CustBranchId", Long.valueOf(object.getInt("custBranchId"))))
								.add(Restrictions.eq("VehicleMerkId", Long.valueOf(object.getInt("vehicleMerkId"))))
								.add(Restrictions.eq("VehicleCollateralReferenceId", Long.valueOf(object.getInt("vehicleTypeId"))))
								.add(Restrictions.eq("VehiclePrice", object.getJsonNumber("vehiclePrice").bigDecimalValue().doubleValue()))
								.add(Restrictions.ilike("Product", object.getString("product")))
								.add(Restrictions.ilike("LeaseBack", object.getString("leaseback")))
								.add(Restrictions.ilike("VehicleStatus", object.getString("vehicleStatus"))).list();
						
						for(ApplicationOnline check : checkList) {
							if(check.getStatus()!=null) {
								if(check.getStatus().equalsIgnoreCase("PROCESSING")) {
									permitted = false; break;
								}
							}
							if(check.getStatus()==null) {
								permitted = false; break;
							}
						}
						
						if(permitted==true) {
							if(object.containsKey("npwp")) {
								if(object.getString("npwp").length()>0) npwp = object.getString("npwp");
								personalEmployment = (PersonalEmployment) session.createCriteria(PersonalEmployment.class)
										.add(Restrictions.eq("Id", Long.valueOf(object.getInt("personalId")))).setMaxResults(1).uniqueResult();
								if(personalEmployment==null) {
									responseMessage = "Data Pekerjaan tidak ada!";
									return this.returnResponse(response, responseMessage, responseStatus, null);
								} else {
									personalEmployment.setNpwp(npwp);
									personalEmployment.setChangeBy("GetSimulasiKredit- WEBAPPS");
									personalEmployment.setChangeOn(new Date());
								}
							}
							
							transaction = session.beginTransaction();
							
							double otr = object.getJsonNumber("vehiclePrice").bigDecimalValue().doubleValue();
							double vehicleDp = object.getJsonNumber("vehicleDp").bigDecimalValue().doubleValue();
							long personalId = Long.valueOf(object.getInt("personalId"));
							long vehicleMerkId = Long.valueOf(object.getInt("vehicleMerkId"));
							long vehicleTypeId = Long.valueOf(object.getInt("vehicleTypeId"));
							long custBranchId = Long.valueOf(object.getInt("custBranchId"));
							int ten = object.getInt("tenor");
							double tenor = ten  / 12.0;
							int vehicleYear = Integer.valueOf(object.getString("vehicleYear"));
							int currentYear = Calendar.getInstance().get(Calendar.YEAR);
							double interestFlat = object.getJsonNumber("interestFlat").bigDecimalValue().doubleValue();
							double financeAmount = object.getJsonNumber("financeAmount").bigDecimalValue().doubleValue();
							double adminAmount = object.getJsonNumber("adminAmount").bigDecimalValue().doubleValue();
							double fiduciaAmount = object.getJsonNumber("fiduciaAmount").bigDecimalValue().doubleValue();
							double surveyAmount = object.getJsonNumber("surveyAmount").bigDecimalValue().doubleValue();
							double provisiAmount = object.getJsonNumber("provisi").bigDecimalValue().doubleValue();
							double rental = object.getJsonNumber("rental").bigDecimalValue().doubleValue();
							double lifeInsuranceAmount = object.getJsonNumber("lifeInsuranceAmount").bigDecimalValue().doubleValue();
							double insuranceRate = object.getJsonNumber("insuranceRate").bigDecimalValue().doubleValue();
							double insuranceAmount = object.getJsonNumber("insuranceAmount").bigDecimalValue().doubleValue();
									
							ApplicationOnline ao = new ApplicationOnline();
							ao.setApplicationDate(new Date());
							ao.setProduct(object.getString("product"));
							ao.setLeaseBack(object.getString("leaseback").charAt(0));
							ao.setInterestFlat(interestFlat);
							ao.setRental(rental);
							ao.setFinanceAmount(financeAmount);
						    ao.setFiduciaAmount(fiduciaAmount);
						    ao.setSurveyAmount(surveyAmount);
							ao.setAdminAmount(adminAmount);
							ao.setProvisiAmount(provisiAmount);
							ao.setLifeInsuranceAmount(lifeInsuranceAmount);
							ao.setPersonalId(personalId);
							ao.setVehiclePrice(otr);
							ao.setVehicleDp(vehicleDp);
							ao.setVehicleMerkId(vehicleMerkId);
							ao.setVehicleCollateralReferenceId(vehicleTypeId);
							ao.setCategory(object.getString("penggunaKendaraan"));
							ao.setVehicleColour(object.getString("vehicleColour"));
							ao.setVehicleYear(object.getString("vehicleYear"));
							ao.setPoliceNumber(object.getString("policeNumber"));
							ao.setMachineNumber(object.getString("machineNumber"));
							ao.setChassisNumber(object.getString("chassisNumber"));
							ao.setVehicleStatus(object.getString("vehicleStatus"));
							ao.setIsSentPersonal("F");
							ao.setInsuranceRate(insuranceRate);
							ao.setInsuranceAmount(insuranceAmount);
							
							if(object.getString("vehicleStatus").equalsIgnoreCase("Bekas")) {
								long bDates = Long.valueOf(object.getString("bpkbDate"));
								Date bpkbDate = new Date(bDates);
								long sDates = Long.valueOf(object.getString("stnkDate"));
								Date stnkDate = new Date(sDates);
								
								ao.setBpkbName(object.getString("bpkbName"));
								ao.setBpkbNumber(object.getString("bpkbNumber"));
								ao.setBpkbDate(bpkbDate);
								ao.setStnkName(object.getString("stnkName"));
								ao.setStnkDate(stnkDate);
							}
							
							ao.setCustBranchId(custBranchId);
							ao.setInsuranceType(object.getString("insuranceType"));
							
							if(object.containsKey("sumberAplikasi")) {
								ao.setSumberAplikasi(object.getString("sumberAplikasi"));
								
								if(object.getString("sumberAplikasi").equalsIgnoreCase("Showroom") || object.getString("sumberAplikasi").equalsIgnoreCase("Rumahan") 
										|| object.getString("sumberAplikasi").equalsIgnoreCase("Perorangan")) {
									
									if(!object.containsKey("dealerId")) {
										responseMessage = "Dealer tidak boleh kosong !!!";
										return this.returnResponse(response, responseMessage, responseStatus, null);
									} else {
										ao.setDealerId(Long.valueOf(object.getInt("dealerId")));
									}
								} else {
									
									if(object.containsKey("dealerId")) {
										ao.setDealerId(Long.valueOf(object.getInt("dealerId")));
									} else {
										ao.setDealerId(0);
									}
								}
								
								if(object.containsKey("adminRefund")) {
									ao.setAdminRefund(object.getJsonNumber("adminRefund").bigDecimalValue().doubleValue());
								} else {
									ao.setAdminRefund(0);
								}
								
							} else {
								responseMessage = "Sumber Aplikasi tidak boleh kosong !!!";
								return this.returnResponse(response, responseMessage, responseStatus, null);
							}
							
							if(object.containsKey("referalCode")) {
								ao.setReferalCode(object.getString("referalCode"));
							}
							
							if(object.containsKey("promoCode")) {
								ao.setPromoCode(object.getString("promoCode"));
							}
							
							ao.setTenor(object.getInt("tenor"));
							
							if(object.getString("jenisKredit").equalsIgnoreCase("Kepemilikan")) {
								ao.setPembayaranPertama(object.getJsonNumber("pembayaranPertama").bigDecimalValue().doubleValue());
							}
						
							ao.setCreateBy("MOBILE "+object.getString("handphone"));
							if(object.containsKey("version")) ao.setVersion(object.getInt("version"));
							else ao.setVersion(0);
							ao.setCreateOn(new Date());
							
							if(personalEmployment!=null) session.update(personalEmployment);
							session.save(ao);
							
							transaction.commit();
							
							return this.returnResponse(response, responseMessage, responseStatus, ao);
						
						} else {
							responseMessage = "Data Simulasi kredit ini pernah di submit sebelumnya";
							return returnResponse(response, responseMessage, responseStatus, null);
						}
					} else {
						responseMessage = "Harap isi Product !";
						return this.returnResponse(response, responseMessage, responseStatus, null);
					}
				}
			} // check version

		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
			log.error(e.getMessage());
			log.error("error : "+e);
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
				log.error("error : "+e2);
			}
		}
		return this.returnResponse(response, responseMessage, responseStatus, null);
	}

	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus,
			ApplicationOnline ao) {
		try {
			JsonObject result = null;
			JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
			objectBuilderName.add("responseStatus", responseStatus);
			objectBuilderName.add("responseMessage", responseMessage);
			
			if(ao != null) {
				JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
	        	JsonObjectBuilder objectBuilderName2 = Json.createObjectBuilder();
	        	objectBuilderName2.add("applicationOnlineId", ao.getId());
	        	arrayBuilder.add(objectBuilderName2);
		        objectBuilderName.add("data", arrayBuilder);
			}

			result = objectBuilderName.build();
			log.info("--RESPONSE GetSimulasiKredit : "+result.toString()+"--");
			PrintWriter writer = response.getWriter();
			writer.print(result.toString());
			writer.flush();
			response.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("error io : "+e);
		}
		return null;
	}

}
