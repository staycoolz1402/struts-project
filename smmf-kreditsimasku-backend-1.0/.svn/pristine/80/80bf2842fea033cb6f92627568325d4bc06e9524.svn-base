package com.ams.mufins.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
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

import com.ams.mufins.model.CustomerMobile;
import com.ams.mufins.model.MasterVersioning;
import com.ams.mufins.model.PersonalContact;
import com.ams.mufins.model.PersonalEmployment;
import com.ams.mufins.model.PersonalMain;
import com.ams.mufins.model.PersonalSpouseGuarantor;
import com.ams.mufins.model.dao.PersonalMainDAO;
import com.ams.mufins.webservice.model.MasterDataApi;
import com.ams.mufins.webservice.util.CommonApiUtil;
import com.mpe.common.CommonUtil;

public class GetMappingCif extends Action{
	
	Logger log = Logger.getLogger(this.getClass());
	
	public ActionForward execute(ActionMapping mapping,ActionForm form,HttpServletRequest request,HttpServletResponse response)
			throws Exception {
			String action = mapping.getParameter();
			
			if ("GETMAPPINGCIF".equalsIgnoreCase(action)) {
				return performGetMappingCif(mapping, form, request, response);
			}
			
			return null;
	}
	
	private ActionForward performGetMappingCif(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		BufferedReader reader = null;
		JsonReader reader2 = null;
		int responseStatus = 200;
		String responseMessage= "SUCCESS";
		Session session = null;
		String dateFormat = "dd/MM/yyyy";
		Transaction transaction = null;
		PersonalMain balikResponse = null;
		List<MasterDataApi> dataApiList = new ArrayList<MasterDataApi>();
		
		try {
			StringBuffer jb = new StringBuffer();
			String line = null;			
		    reader = request.getReader();
		    while ((line = reader.readLine()) != null){
		      jb.append(line);
		    }
			String body = jb.toString();
			log.info("\n--REQUEST GetMappingCif : "+body+"--\n");
			session = PersonalMainDAO.getInstance().getSession();

			reader2 = Json.createReader(new StringReader(body));
			JsonObject read = reader2.readObject();
			dataApiList = (List<MasterDataApi>)CommonApiUtil.getMasterDataApiList(session, "MASTER_API_KREDITSIMASKU");
			
			for (MasterDataApi api : dataApiList) {
                if (api.getIsMandatory().equalsIgnoreCase("T")) {
                	
                	if (api.getMasterDataType().equalsIgnoreCase("character varying")) {
                		
                		if (read.containsKey("fullName") && read.getString("fullName").equals("")) {
    						responseMessage = "Nama Lengkap tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					} 
                		if (read.containsKey("placeOfBirth") && read.getString("placeOfBirth").equals("")) {
    						responseMessage = "Tempat Lahir tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					} 
    					if (read.containsKey("dateOfBirth") && read.getString("dateOfBirth").equals("")) {
    						responseMessage = "Tanggal Lahir tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					} 
    					if (read.containsKey("gender") && read.getString("gender").equals("")) {
    						responseMessage = "Jenis Kelamin tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("motherMaidenName") && read.getString("motherMaidenName").equals("")) {
    						responseMessage = "Nama Ibu Kandung tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("idNumber") && read.getString("idNumber").equals("")) {
    						responseMessage = "Nomor KTP tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("issueDate") && read.getString("issueDate").equals("")) {
    						responseMessage = "Tanggal Pembuatan KTP tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("handphone") && read.getString("handphone").equals("")) {
    						responseMessage = "Handphone tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("addressPersonalMain") && read.getString("addressPersonalMain").equals("")) {
    						responseMessage = "Alamat tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("rw") && read.getString("rw").equals("")) {
    						responseMessage = "Rw tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("rt") && read.getString("rt").equals("")) {
    						responseMessage = "Rt tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("name") && read.getString("name").equals("")) {
    						responseMessage = "Nama Kontak Darurat tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("addressPersonalContact") && read.getString("addressPersonalContact").equals("")) {
    						responseMessage = "Alamat Kontak Darurat tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("phoneNumberPersonalContact") && read.getString("phoneNumberPersonalContact").equals("")) {
    						responseMessage = "Telepon Kontak Darurat tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyName") && read.getString("companyName").equals("")) {
    						responseMessage = "Nama Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyAddress") && read.getString("companyAddress").equals("")) {
    						responseMessage = "Alamat Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyRt") && read.getString("companyRt").equals("")) {
    						responseMessage = "Rt Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyRw") && read.getString("companyRw").equals("")) {
    						responseMessage = "Rw Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyProvince") && read.getString("companyProvince").equals("")) {
    						responseMessage = "Provinsi Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyCity") && read.getString("companyCity").equals("")) {
    						responseMessage = "Kota Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companySubdistrict") && read.getString("companySubdistrict").equals("")) {
    						responseMessage = "Kecamatan Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyVillage") && read.getString("companyVillage").equals("")) {
    						responseMessage = "Kelurahan Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyPostalCode") && read.getString("companyPostalCode").equals("")) {
    						responseMessage = "Kode Pos Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("companyPhoneNumber") && read.getString("companyPhoneNumber").equals("")) {
    						responseMessage = "Telepon Perusahaan tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					if (read.containsKey("jobRank") && read.getString("jobRank").equals("")) {
    						responseMessage = "Jabatan/Pangkat tidak terdapat pada data yang dikirim !";
    						return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
    					}
    					
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("fullName")) {
                            responseMessage = "Nama Lengkap tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("placeOfBirth")) {
                            responseMessage = "Tempat Lahir tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("dateOfBirth")) {
                            responseMessage = "Tanggal Lahir tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("gender")) {
                            responseMessage = "Jenis Kelamin tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("motherMaidenNAme")) {
                            responseMessage = "Nama Ibu Kandung tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("idNumber")) {
                            responseMessage = "Nomor KTP tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("issueDate")) {
                            responseMessage = "Tanggal Pembuatan KTP tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("handphone")) {
                            responseMessage = "Handphone tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("addressPersonalMain")) {
                            responseMessage = "Alamat tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("rt")) {
                            responseMessage = "RT tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("rw")) {
                            responseMessage = "RW tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("name")) {
                            responseMessage = "Nama Kontak Darurat tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("addressPersonalContact")) {
                            responseMessage = "Alamat Kontak Darurat tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("phoneNumberPersonalContact")) {
                            responseMessage = "Telepon Kontak Darurat tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyName")) {
                            responseMessage = "Nama Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyAddress")) {
                            responseMessage = "Alamat Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyRt")) {
                            responseMessage = "RT Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyRw")) {
                            responseMessage = "RW Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyProvince")) {
                            responseMessage = "Provinsi Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyCity")) {
                            responseMessage = "Kota Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companySubdistrict")) {
                            responseMessage = "Kecamatan Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyVillage")) {
                            responseMessage = "Kelurahan Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyPostalCode")) {
                            responseMessage = "Postal Code Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("companyPhoneNumber")) {
                            responseMessage = "Telepon Perusahaan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("jobRank")) {
                            responseMessage = "Jabatan/Pangkat tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        continue;
                        
                	} else if (api.getMasterDataType().equalsIgnoreCase("bigint")){
                		
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("educationId")) {
                            responseMessage = "Pendidikan tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("marriageStatusId")) {
                            responseMessage = "Status Perkawinan tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("ownershipId")) {
                            responseMessage = "Status Kepemilikan Rumah tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("postalCodeId")) {
                            responseMessage = "Kode Pos tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("relationshipId")) {
                            responseMessage = "Hubungan dengan Debitur tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("jobId")) {
                            responseMessage = "Pekerjaan tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("companyPostalCodeId")) {
                            responseMessage = "Kode Pos Perusahaan tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("businessSectorId")) {
                            responseMessage = "Bidang Usaha Pekerjaan tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        continue;
                		
                	} else if (api.getMasterDataType().equalsIgnoreCase("integer")){
                		
                		if (!read.containsKey((Object)api.getMasterDataColumnName()) || read.getInt(api.getMasterDataColumnName()) == 0 && api.getMasterDataColumnName().contains("jobLength")) {
                            responseMessage = "Lama Bekerja tidak terdapat pada data yang dikirim !!";
                            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                        }
                        continue;                            
                        
                	}
                    
                } else {
                	
                	if (api.getMasterDataType().equalsIgnoreCase("character varying")) {
                		
                		if(read.containsKey(api.getMasterDataColumnName())) {
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("npwp")) {
                                responseMessage = "NPWP tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("email")) {
                                responseMessage = "Email tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseFullName")) {
                                responseMessage = "Nama Lengkap Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spousePlaceOfBirth")) {
                                responseMessage = "Tempat Lahir Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseIdNumber")) {
                                responseMessage = "No KTP Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseCompanyName")) {
                                responseMessage = "Nama Perusahaan Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseCompanyAddress")) {
                                responseMessage = "Alamat Perusahaan Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseCompanyRt")) {
                                responseMessage = "RT Perusahaan Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseCompanyRw")) {
                                responseMessage = "RW Perusahaan Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseCompanyPhoneNumber")) {
                                responseMessage = "Telepon Perusahaan Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseHandphone")) {
                                responseMessage = "Handphone Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("spouseJobRank")) {
                                responseMessage = "Jabatan/Pangkat Pasangan tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			if (read.getString(api.getMasterDataColumnName()).length() > api.getMasterDataLength() && api.getMasterDataColumnName().contains("phoneNumberPersonalMain")) {
                                responseMessage = "Telepon Pemohon tidak boleh lebih dari " + api.getMasterDataLength() + "!";
                                return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
                            }
                			continue;
                		}
                	} 
                }
			}
			
			MasterVersioning versioning = CommonUtil.getSimaskuVersion(session);
			
			if (read.getInt("version")>0) {
				if(read.getInt("version")!=versioning.getVersion()) {
					responseMessage = "Version tidak sama, harap update APK !";
					return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
				}
				
				CustomerMobile cm = (CustomerMobile) session.createCriteria(CustomerMobile.class)
						.add(Restrictions.eq("Id", Long.valueOf(read.getInt("customerId")))).setMaxResults(1).uniqueResult();
				
				if(cm== null) {
					responseMessage = "Customer tidak terdaftar !";
					return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
				}
				
				PersonalMain checkData = (PersonalMain) session.createCriteria(PersonalMain.class).add(Restrictions.eq("CustomerId", cm.getId())).setMaxResults(1).uniqueResult();
				if(checkData!=null) {
					responseMessage = "Data personal sudah terdaftar !";
					return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
				}
				transaction = session.beginTransaction();
				
				cm.setCompletedLongCif(true);
				session.update(cm);		
				
				//personalMain
				PersonalMain pm = new PersonalMain();
				pm.setFullName(read.getString("fullName"));
				pm.setCustomerId(Long.valueOf(read.getInt("customerId")));
				pm.setIdNumber(read.getString("idNumber"));
				pm.setPlaceOfBirth(read.getString("placeOfBirth"));
				pm.setDateOfBirth(CommonApiUtil.getDate(read.getString("dateOfBirth"), dateFormat));
				pm.setGender(read.getString("gender"));
				pm.setIssueDate(CommonApiUtil.getDate(read.getString("issueDate"), dateFormat));
				pm.setMotherMaidenName(read.getString("motherMaidenName"));
				pm.setMarriageStatusId(Long.valueOf(read.getInt("marriageStatusId")));
				pm.setMarriageStatusName(read.getString("marriageStatusName"));
				pm.setEducationId(Long.valueOf(read.getInt("educationId")));
				pm.setAddress(read.getString("addressPersonalMain"));
				pm.setLetterAddress(read.getString("addressPersonalMain"));
				pm.setRt(read.getString("rt"));
				pm.setLetterRt(read.getString("rt"));
				pm.setRw(read.getString("rw"));
				pm.setLetterRw(read.getString("rw"));
				pm.setProvince(read.getString("province"));
				pm.setLetterProvince(read.getString("province"));
				pm.setCity(read.getString("city"));
				pm.setLetterCity(read.getString("city"));
				pm.setSubdistrict(read.getString("subdistrict"));
				pm.setLetterSubdistrict(read.getString("subdistrict"));
				pm.setVillage(read.getString("village"));
				pm.setLetterVillage(read.getString("village"));
				pm.setPostalCodeId(Long.valueOf(read.getInt("postalCodeId")));
				pm.setLetterPostalCodeId(Long.valueOf(read.getInt("postalCodeId")));
				pm.setPostalCode(read.getString("postalCode"));
				pm.setLetterPostalCode(read.getString("postalCode"));
				if(read.getString("phoneNumberPersonalMain").length()>0) {
					pm.setPhoneNumber(read.getString("phoneNumberPersonalMain"));
				}
				pm.setHandphone(read.getString("handphone"));
				if(read.getString("email").length()>0) {
					pm.setEmail(read.getString("email"));
				}
				pm.setOwnershipId(Long.valueOf(read.getInt("ownershipId")));
				if(read.containsKey("version")) pm.setVersion(read.getInt("version"));
				else pm.setVersion(0);
				pm.setCreateBy("SYSTEM");
				pm.setCreateOn(new Date());
				session.save(pm);
				
				
				//personalEmployee
				PersonalEmployment pe = new PersonalEmployment();
				pe.setId(pm.getId());
				pe.setJobId(Long.valueOf(read.getInt("jobId")));
				pe.setCompanyName(read.getString("companyName"));
				pe.setBusinessSectorId(Long.valueOf(read.getInt("businessSectorId")));
				if(read.getInt("subBusinessSectorId")>0) {
					pe.setSubBusinessSectorId(Long.valueOf(read.getInt("subBusinessSectorId")));
				} 
				if(read.getInt("subBusinessSector2Id")>0) {
					pe.setSubBusinessSector2Id(Long.valueOf(read.getInt("subBusinessSector2Id")));
				}
				if(read.getInt("subBusinessSector3Id")>0) {
					pe.setSubBusinessSector3Id(Long.valueOf(read.getInt("subBusinessSector3Id")));
				}
				pe.setCompanyAddress(read.getString("companyAddress"));
				pe.setCompanyRt(read.getString("companyRt"));
				pe.setCompanyRw(read.getString("companyRw"));
				pe.setCompanyProvince(read.getString("companyProvince"));
				pe.setCompanyCity(read.getString("companyCity"));
				pe.setCompanySubdistrict(read.getString("companySubdistrict"));
				pe.setCompanyVillage(read.getString("companyVillage"));
				pe.setCompanyPostalCodeId(Long.valueOf(read.getInt("companyPostalCodeId")));
				pe.setCompanyPostalCode(read.getString("companyPostalCode"));
				pe.setCompanyPhoneNumber(read.getString("companyPhoneNumber"));
				pe.setJobRank(read.getString("jobRank"));
				pe.setJobLength(Integer.valueOf(read.getInt("jobLength")));
				if(read.getString("npwp").length()>0) {
					pe.setNpwp(read.getString("npwp"));
				}
				pe.setCreateBy("SYSTEM");
				pe.setCreateOn(new Date());
				session.save(pe);
				
				
				//personal_spouse_guarantor
				if (pm.getMarriageStatusName().equalsIgnoreCase("Kawin")) {
					PersonalSpouseGuarantor spg = new PersonalSpouseGuarantor();
					spg.setId(pm.getId());
					spg.setSpouseFullName(read.getString("spouseFullName"));
					spg.setSpouseIdNumber(read.getString("spouseIdNumber"));
					spg.setSpousePlaceOfBirth(read.getString("spousePlaceOfBirth"));
					spg.setSpouseDateOfBirth(CommonApiUtil.getDate(read.getString("spouseDateOfBirth"), dateFormat));
					if(read.getInt("spouseJobId")>0) {
						spg.setSpouseJobId(Long.valueOf(read.getInt("spouseJobId")));
					}
					if(read.getString("spouseCompanyName").length()>0) {
						spg.setSpouseCompanyName(read.getString("spouseCompanyName"));
					}
					if(read.getInt("spouseBusinessSectorId")>0) {
						spg.setSpouseBusinessSectorId(Long.valueOf(read.getInt("spouseBusinessSectorId")));
					}
					if(read.getInt("spouseSubbusinessSecId")>0) {
						spg.setSpouseSubBusinessSecId(Long.valueOf(read.getInt("spouseSubbusinessSecId")));
					}
					if(read.getInt("spouseSubbusinessSec2Id")>0) {
						spg.setSpouseSubbusinessSec2Id(Long.valueOf(read.getInt("spouseSubbusinessSec2Id")));
					}
					if(read.getInt("spouseSubbusinessSec3Id")>0) {
						spg.setSpouseSubbusinessSec3Id(Long.valueOf(read.getInt("spouseSubbusinessSec3Id")));
					}
					if(read.getString("spouseCompanyAddress").length()>0) {
						spg.setSpouseCompanyAddress(read.getString("spouseCompanyAddress"));
					}
					spg.setSpouseCompanyRt(read.getString("spouseCompanyRt"));
					spg.setSpouseCompanyRw(read.getString("spouseCompanyRw"));
					if(read.getString("spouseCompanyProvince").length()>0) {
						spg.setSpouseCompanyProvince(read.getString("spouseCompanyProvince"));
					}
					if(read.getString("spouseCompanyCity").length()>0) {
						spg.setSpouseCompanyCity(read.getString("spouseCompanyCity"));
					}
					if(read.getString("spouseCompanySubdistrict").length()>0) {
						spg.setSpouseCompanySubdistrict(read.getString("spouseCompanySubdistrict"));
					}
					if(read.getString("spouseCompanyVillage").length()>0) {
						spg.setSpouseCompanyVillage(read.getString("spouseCompanyVillage"));
					}
					if(read.getString("spouseCompanyPostalCode").length()>0) {
						spg.setSpouseCompanyPostalCode(read.getString("spouseCompanyPostalCode"));
					}
					if(read.getInt("spouseCompanyPostalCodeId")>0) {
						spg.setSpouseCompanyPostalCodeId(Long.valueOf(read.getInt("spouseCompanyPostalCodeId")));
					}
					if(read.getString("spouseCompanyPhoneNumber").length()>0) {
						spg.setSpouseCompanyPhoneNumber(read.getString("spouseCompanyPhoneNumber"));
					}
					if(read.getString("spouseHandphone").length()>0) {
						spg.setSpouseHandphone(read.getString("spouseHandphone"));
					}
					if(read.getString("spouseJobRank").length()>0) {
						spg.setSpouseJobRank(read.getString("spouseJobRank"));
					}
					if(read.getInt("spouseJobLength")>0) {
						spg.setSpouseJobLength(Integer.valueOf(read.getInt("spouseJobLength")));
					}
					spg.setCreateBy("SYSTEM");
					spg.setCreateOn(new Date());
					session.save(spg);
				}
				
				//personal_contact
				PersonalContact pc = new PersonalContact();
				pc.setId(pm.getId());
				if(read.getString("name").length()>0) {
					pc.setName(read.getString("name"));
				}
				if(read.getString("addressPersonalContact").length()>0) {
					pc.setAddress(read.getString("addressPersonalContact"));
				}
				if(read.getString("phoneNumberPersonalContact").length()>0) {
					pc.setPhoneNumber(read.getString("phoneNumberPersonalContact"));
				}
				if(read.getInt("relationshipId")>0) {
					pc.setRelationshipId(Long.valueOf(read.getInt("relationshipId")));
				}
				pc.setCreateBy("SYSTEM");
				pc.setCreateOn(new Date());
				session.save(pc);
				
	            transaction.commit();
	           
	            balikResponse = new PersonalMain();
	            balikResponse.setFullName(pm.getFullName());
	            balikResponse.setIdNumber(pm.getIdNumber());
	            balikResponse.setId(pm.getId());
				
			}
	            
		} catch (Exception e) {
			if (transaction != null)transaction.rollback();
			e.printStackTrace();
			log.error(e.getMessage());
			log.error("error : "+e);
            responseMessage = "ERROR : " + e.getLocalizedMessage();
            responseStatus = 500;
            return this.returnResponse(response, responseMessage, responseStatus, balikResponse);
		} finally {
			try {
				CommonApiUtil.safeClose(session);
				CommonApiUtil.safeClose(reader);
				CommonApiUtil.safeClose(reader2);
				PersonalMainDAO.getInstance().closeSessionForReal();
			} catch (Exception e) {
				e.printStackTrace();
				log.error(e.getMessage());
				log.error("error : "+e);
			}
			
		}
		return returnResponse(response, responseMessage, responseStatus, balikResponse);
	}
	
	private ActionForward returnResponse(HttpServletResponse response, String responseMessage, int responseStatus, PersonalMain balikResponse){
		
		try {
			JsonObject result = null;
            JsonObjectBuilder objectBuilderName = Json.createObjectBuilder();
            objectBuilderName.add("responseStatus", responseStatus);
            objectBuilderName.add("responseMessage", responseMessage);
            
            if(balikResponse!=null) {
            	if(balikResponse.getId()>0 && balikResponse.getFullName()!=null && balikResponse.getIdNumber()!=null) {
                	log.info("\t---GetPersonalInfo Response data : \n\t\t--personalId : "+balikResponse.getId()+"\n\t\t--fullName : "+balikResponse.getFullName()+"\n\t\t--idNumber : "+balikResponse.getIdNumber());
                	objectBuilderName.add("personalId", balikResponse.getId());
                    objectBuilderName.add("fullName", balikResponse.getFullName());
                    objectBuilderName.add("idNumber", balikResponse.getIdNumber());
                }
            }
            
            result = objectBuilderName.build();
            log.info("--RESPONSE GetMappingCif : "+result.toString()+"--");
            PrintWriter writer = response.getWriter();
            writer.print(result.toString());
            writer.flush();
            response.setContentType("application/json");
		} catch (IOException e) {
			e.printStackTrace();
			log.error("Error io : "+e);
		}		     
        return null;
	}
}

