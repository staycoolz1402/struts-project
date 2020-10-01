
package com.ams.mufins.action;


import java.nio.charset.StandardCharsets;
import java.security.DigestException;
import java.security.MessageDigest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.mail.Message;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.form.LogonForm;
import com.ams.mufins.model.Organization;
import com.ams.mufins.model.OrganizationSetup;
import com.ams.mufins.model.UserLogin;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.dao.OrganizationDAO;
import com.ams.mufins.model.dao.OrganizationSetupDAO;
import com.ams.mufins.model.dao.RoleDAO;
import com.ams.mufins.model.dao.UserLoginDAO;
import com.ams.mufins.model.dao.UserPasswordHistoryDAO;
import com.ams.mufins.model.dao.UsersDAO;
import com.ams.mufins.model.dao._RootDAO;
import com.mpe.common.BrowserUtil;
import com.mpe.common.CommonConstants;
import com.mpe.common.CommonUtil;
import com.mpe.common.Formater;

/** 
 * LogonAction.java created by EasyStruts - XsltGen.
 * http://easystruts.sf.net
 * created on 06-11-2003
 * 
 * XDoclet definition:
 * @struts:action path="/logon" name="logonForm" input="/user/logon.jsp"/ parameter="LOGON" validate="true"
 */
public class LogonAction extends Action {
	Logger log = Logger.getLogger(this.getClass());
	
	
	static String smtp = "";
	
	// --------------------------------------------------------- Methods
	/** 
	 * Method execute
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	public ActionForward execute(
			ActionMapping mapping,
			ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response)
					throws Exception {
		String action = mapping.getParameter();
		LogonForm forms = (LogonForm) form;
		Users users = (Users)request.getSession().getAttribute(CommonConstants.USER);
		String usr = "";
		if(action.contains("LOGOFF")){
			usr = users==null?"-":users.getUserName();
		}else if(action.contains("LOGON")){
			usr = forms.getString("userName");
		}
		log.info("[ START "+this.getClass().getName()+" "+action+" "+usr+" ] ");
		if ("".equalsIgnoreCase(action)) {
			return mapping.findForward("index");
		} else if ("LOGON".equalsIgnoreCase(action)) {
			return performLogon(mapping, form, request, response, action);
		} else if ("LOGOFF".equalsIgnoreCase(action)) {
			return performLogoff(mapping, form, request, response, action);
		} else if ("LOGONFORM".equalsIgnoreCase(action)) {
			return performLogonForm(mapping, form, request, response);
		} else if ("PASS_CODE_FORM".equalsIgnoreCase(action)) {
			return performPassCodeForm(mapping, form, request, response);
		} else if ("PASSWORDEXPIRED".equalsIgnoreCase(action)) {
			return performPasswordExpired(mapping, form, request, response);
		} else if ("PASSWORDEXPIREDSAVE".equalsIgnoreCase(action)) {
			return performPasswordExpiredSave(mapping, form, request, response);
		} else {
			return mapping.findForward("index");	
		}
	}

	/** 
	 * Method performLogon
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performLogon(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, String action) {
		LogonForm form = (LogonForm) actionForm;
		HttpSession httpSession = request.getSession();  
		Users users = null;
		Session hibernateSession = UsersDAO.getInstance().getSession();
		Transaction transaction = hibernateSession.beginTransaction();
		Organization organization =  OrganizationDAO.getInstance().get(1L, hibernateSession);
		try {
			if(form.getString("userName").contains(" "))return validationErrors("errorPassword","error.password",mapping,request);
			users = (Users) hibernateSession.createCriteria(Users.class)
					.add(Restrictions.eq("UserName", form.getString("userName").toLowerCase())).uniqueResult();
			
			if(users==null) return validationErrors("errorPassword","error.password",mapping,request);
			OrganizationSetup organizationSetup = OrganizationSetupDAO.getInstance()
					.get(users.getOrganizationId(),hibernateSession);			
			if((users.getLoginAttemptCounter()!=null?users.getLoginAttemptCounter():0) >= organizationSetup.getMaximumLoginAttempt()) return validationErrors("userIsLock","error.userislock.date",mapping,request);
			if(!users.isActive()) return validationErrors("errorUnactive","error.unactive.user",mapping,request);
			
			String userPass = "";
			String userName = form.getString("userName");
			
			if(form.getString("userPass") !=null && form.getString("userPass").length()>0)	userPass=form.getString("userPass");
			if(userPass !=null && userPass.length()>0 ){
				byte[] cipherData = Base64.getDecoder().decode(userPass);
				byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
				String secret = userName;
				
				MessageDigest md5 = MessageDigest.getInstance("MD5");
				final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8), md5);
				SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
				IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

				byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
				Cipher aesCBC = Cipher.getInstance("AES/CBC/PKCS5Padding");
				aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
				byte[] decryptedData = aesCBC.doFinal(encrypted);
				String decryptedText = new String(decryptedData, StandardCharsets.UTF_8);
				
				if(decryptedText.contains("SMMF")){
					String splitPass[] = decryptedText.split("SMMF");
					splitPass[1]=splitPass[1].replace(":", "");
					
					Date d1 = new Date();
					SimpleDateFormat df = new SimpleDateFormat("ddMMyyyyHHmm");
					String timeNow = df.format(d1);

					if(Long.parseLong(timeNow) - Long.parseLong(splitPass[1])>5){
						return validationErrors("errorPassword","error.password",mapping,request);	}
					else{
						userPass = splitPass[0];
					}
				}
				else{
					return validationErrors("errorPassword","error.password",mapping,request);
				}
			}
			
			if (users.getUserPass().equals(CommonUtil.digest(userPass)) && userPass !=null) {
				String ip = request.getRemoteAddr();

				// expired passcode in minutes
				int expiredPassCode = 120;

				// EXTERNAL WITHOUT PIN
				ActionForward forwardError = null;
					forwardError = performExternalWithoutPin(mapping, request, form, httpSession, users, hibernateSession, organization,
							ip, expiredPassCode, organizationSetup, transaction);

				if(null != forwardError) return forwardError;
			} else {
				users.setLoginAttemptCounter((users.getLoginAttemptCounter()!=null?users.getLoginAttemptCounter():0)+1);
				hibernateSession.update(users);
				transaction.commit();
				return validationErrors("errorPassword","error.password",mapping,request);
			}
			
		} catch (Exception ex) {
			log.error("performLogon Exception", ex);
			generalError(request, ex);
			return (new ActionForward(mapping.getInput()));
		} finally {
			log.info("[ END " + this.getClass().getName() +" "+action+" "+ (users != null ? users.getUserName() : "-") + "  ] ");
			try {
				UsersDAO.closeCurrentThreadSessions();
			} catch (Exception exx) {
				log.error("performLogon cannot close session Exception", exx);
			}
		}
		return mapping.findForward("success");
	}
	
	
	private ActionForward performExternalWithoutPin(ActionMapping mapping, HttpServletRequest request, LogonForm form,
			HttpSession httpSession, Users users, Session hibernateSession, Organization organization1, String ip,
			int expiredPassCode, OrganizationSetup organizationSetup, Transaction transaction) throws Exception {
		
		ActionForward forward = null;
		boolean sso = true;								
		
		// time out session!
		if (users.getUserType().equalsIgnoreCase("ADMINISTRATOR")){
			sso = true;
		}

		if (sso) {
			httpSession.setAttribute(CommonConstants.USER, users);
			// load organization!
			Organization organization = OrganizationDAO.getInstance().get(users.getOrganizationId(),hibernateSession);
			httpSession.setAttribute(CommonConstants.ORGANIZATION, organization);
			// load view
			Set set = users.getViewAccess();

			if (set!=null && set.size()>0) {
				httpSession.setAttribute(CommonConstants.VIEWACCESS,set);

				// set last login
				httpSession.setAttribute("lastLogin", Formater.getFormatedDate(users.getLastLoginTime(), "dd MMMM yyyy hh:mm:ss a"));	

				// update users
				//UsersDAO.getInstance().updateLastLogin(users, hibernateSession);

				try {
					
					//update users last login time
					users.setLastLoginTime(new Date());
					users.setLoginAttemptCounter(0);
					UsersDAO.getInstance().update(users, hibernateSession);
					
					// insert user login
					String browser = BrowserUtil.getBrowser(request);
					UserLogin userLogin = new UserLogin();
					userLogin.setBrowser(browser);
					userLogin.setIp(ip);
					userLogin.setLoginTime(new Date());
					userLogin.setServer("");
					userLogin.setUserId(users.getId());
					userLogin.setUserName(users.getUserName());
					userLogin.setUserType(users.getUserType());
					UserLoginDAO.getInstance().save(userLogin, hibernateSession);
					//hibernateSession.save(userLogin);

					transaction.commit();
				} catch (Exception e) {
					if (transaction!=null) transaction.rollback();
					log.error("performExternalWithoutPin user login save Exception ", e);
				} finally {
					if (hibernateSession != null) hibernateSession.close();
				}

			} else {
				return validationErrors("errorInvalidRole", "error.invalid.role", mapping, request);
			}
		} else {
			return validationErrors("errorDuplicate", "error.duplicate.user", mapping, request);
		}
		return forward;
	}
	

	private ActionForward performExternalWithPin(ActionMapping mapping, HttpServletRequest request, LogonForm form,
			HttpSession httpSession, Users users, Session hibernateSession, Organization organization1, String ip,
			int expiredPassCode, OrganizationSetup organizationSetup) throws Exception {
		
		ActionForward forward = null;
		
		// belum ada passcode
		if (!CommonUtil.isTrustedIp(getServlet().getServletConfig().getServletContext().getRealPath("/"), ip)
				&& (form.getString("passCode") == null
				|| form.getString("passCode").length() == 0)) {
			// send email
			if (users.getEmail() != null && users.getEmail().length() > 0) {

				StringBuilder sb = new StringBuilder();
				sb.append("");
				sb.append("select ");
				sb.append("pass_code as A, ");
				sb.append("create_on as B ");
				sb.append("from user_pass_code ");
				sb.append("where user_id = ");
				sb.append(users.getId());
				sb.append(" ");

				// cek telah ada passcode yang masih aktif?
				String stringSl = sb.toString();
				Object[] objects = (Object[]) hibernateSession
						.createSQLQuery(stringSl).addScalar("A", Hibernate.STRING)
						.addScalar("B", Hibernate.TIMESTAMP).setMaxResults(1).uniqueResult();
				long selisihWaktuAwal = -1;
				Timestamp timestamp6 = new Timestamp(new GregorianCalendar().getTime().getTime());
				if (objects != null) {
					Timestamp timestamp = (Timestamp) objects[1];
					// change from milisecond to minute!
					if (timestamp != null)
						selisihWaktuAwal = (timestamp6.getTime() - timestamp.getTime())	/ (1000 * 60);
				}

				if (selisihWaktuAwal == -1 || selisihWaktuAwal > expiredPassCode) {

					// generate passcode
					String string = CommonUtil.randomin(3, 1, 3, 1, "");
					// insert into database master

					Transaction transaction = null;
					try {
						hibernateSession.flush();
						Session session = hibernateSession;
						transaction = session.beginTransaction();

						StringBuilder stringBuilder = new StringBuilder();
						stringBuilder.append("");
						stringBuilder.append("delete from user_pass_code ");
						stringBuilder.append("where user_id = ");
						stringBuilder.append(users.getId());
						stringBuilder.append(" ");
						// delete prev record
						String sqlDelete = stringBuilder.toString();
						session.createSQLQuery(sqlDelete).executeUpdate();

						StringBuilder sb2 = new StringBuilder();
						sb2.append("insert into user_pass_code(user_id, pass_code, create_on) ");
						sb2.append("values(:id, :a, :b)");
						// insert into database!
						String sqlInsert = sb2.toString();
						session.createSQLQuery(sqlInsert).setLong("id", users.getId())
						.setString("a", string).setTimestamp("b", new Date())
						.executeUpdate();

						// email
						Properties props = new Properties();
						props.put("mail.smtp.host", smtp);
						javax.mail.Session ss = javax.mail.Session.getInstance(props, null);
						ss.setDebug(true);
						// Define message
						Message message = new MimeMessage(ss);
						message.setFrom(new InternetAddress("HELPDESK@simasfinance.co.id"));
						message.addRecipient(Message.RecipientType.TO,
								new InternetAddress(users.getEmail().trim()));
						// cc ke helpdesk juga ternyata
						message.addRecipient(Message.RecipientType.CC,
								new InternetAddress("HELPDESK@simasfinance.co.id"));
						message.setSubject("My Simasfinance Pass Code");
						// Fill the message

						Calendar fromCal = new GregorianCalendar();
						Calendar toCal = new GregorianCalendar();
						toCal.add(Calendar.MINUTE, expiredPassCode);

						StringBuilder ipDiLuarJaringan = new StringBuilder();
						ipDiLuarJaringan.append("");
						ipDiLuarJaringan.append("Yth. ");
						ipDiLuarJaringan.append(users.getUserName());
						ipDiLuarJaringan.append(", \n\n");
						ipDiLuarJaringan.append("Anda mengakses di luar system jaringan ");
						ipDiLuarJaringan.append(organization1.getName());
						ipDiLuarJaringan.append("");
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("dengan alamat IP : ");
						ipDiLuarJaringan.append(request.getRemoteAddr());
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("untuk verifikasi keamanan sistem harap masukkan passcode di bawah ini");
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("untuk validasi login anda: ");
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("*PASSCODE : ");
						ipDiLuarJaringan.append(string);
						ipDiLuarJaringan.append(" *\n");
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("Masukkan passcode ini terlebih dahulu, lalu masukkan username dan password anda.\n");
						ipDiLuarJaringan.append("*Perhatian!!\n");
						ipDiLuarJaringan.append("Passcode ini hanya berlaku dari ");
						ipDiLuarJaringan.append(Formater.getFormatedTime(fromCal.getTime()));
						ipDiLuarJaringan.append(" sampai ");
						ipDiLuarJaringan.append(Formater.getFormatedTime(toCal.getTime()));
						ipDiLuarJaringan.append("\n");
						ipDiLuarJaringan.append("Jika anda melakukan log-out, anda akan mendapatkan passcode baru.\n");
						ipDiLuarJaringan.append("*\n");
						ipDiLuarJaringan.append("Terima kasih atas perhatiannya.\n\n\n\n");
						ipDiLuarJaringan.append("HELPDESK \n\n");
						ipDiLuarJaringan.append("");
						ipDiLuarJaringan.append("");
						message.setText(ipDiLuarJaringan.toString());
						// Send the message
						Transport.send(message);

						transaction.commit();

					} catch (Exception exception) {
						log.error("performExternalWithPin Transport Exception", exception);
						try {
							if (transaction != null)transaction.rollback();
						} catch (Exception exception2) {
							log.error("performExternalWithPin Cannot rollback Transaction", exception2);
						}
					}
				}
				StringBuilder sb1 = new StringBuilder();
				sb1.append("/logon/passCodeForm.do?userName=");
				sb1.append(form.getString("userName"));
				sb1.append("&userPass=");
				sb1.append(form.getString("userPass"));
				
				// forward to code
				return new ActionForward(sb1.toString());

			} else {
				// no email address!
				// return
				return validationErrors("errorNoEmail", "error.no.email", mapping, request);
			}

		// telah ada passcode
		} else if (!CommonUtil.isTrustedIp(getServlet().getServletConfig().getServletContext().getRealPath("/"), ip) && (form.getString("passCode")!=null && form.getString("passCode").length()>0)) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("select ");
			stringBuilder.append("pass_code as A, ");
			stringBuilder.append("create_on as B ");
			stringBuilder.append("from user_pass_code ");
			stringBuilder.append("where user_id = ");
			stringBuilder.append(users.getId());
			stringBuilder.append(" ");
			// cek passcode
			String passCodeSelect = stringBuilder.toString();
			Object[] objects = (Object[])hibernateSession.createSQLQuery(passCodeSelect)
					.addScalar("A", Hibernate.STRING)
					.addScalar("B", Hibernate.TIMESTAMP)
					.setMaxResults(1).uniqueResult();
			String passCode = null;
			long selisihWaktu = 0;
			Calendar calendar5 = new GregorianCalendar();
			Timestamp timestamp2 = new Timestamp(calendar5.getTime().getTime());
			if (objects!=null) {
				passCode = (String)objects[0];
				Timestamp timestamp = (Timestamp)objects[1];
				// change from milisecond to minute!
				if (timestamp!=null) selisihWaktu = (timestamp2.getTime() - timestamp.getTime())/(1000 * 60);
			}
			
			// SET EXPIRED TIME = EXPIRED PASS CODE
			if (passCode==null || (passCode!=null && !(passCode.equalsIgnoreCase(form.getString("passCode")))) || (selisihWaktu>expiredPassCode)) {
				// no valid pass-code
				ActionMessages errors = new ActionMessages();
				errors.add("errorInvalidPassCode",new ActionMessage("error.invalid.passCode"));
				saveErrors(request,errors);
				StringBuilder sbf = new StringBuilder();
				sbf.append("/logon/passCodeForm.do?userName=");
				sbf.append(form.getString("userName"));
				sbf.append("&userPass=");
				sbf.append(form.getString("userPass"));
				return new ActionForward(sbf.toString());

			} else {
				boolean sso = true;								

				if (users.getUserType().equalsIgnoreCase("ADMINISTRATOR")) sso = true;
				if (sso) {
					httpSession.setAttribute(CommonConstants.USER, users);
					// load organization!
					Organization organization = OrganizationDAO.getInstance().get(users.getOrganizationId(),hibernateSession);
					httpSession.setAttribute(CommonConstants.ORGANIZATION, organization);
					// load view
					Set set = users.getViewAccess();

					if (set!=null && set.size()>0) {
						httpSession.setAttribute(CommonConstants.VIEWACCESS,set);
						//buat tampilin Start Of Day
						//Calendar calendar = getStartOfDay(users, hibernateSession);
						//httpSession.setAttribute(CommonConstants.SOD, Formater.getFormatedDate(calendar.getTime(), "d MMMM yyyy"));

					} else {
						return validationErrors("errorInvalidRole", "error.invalid.role", mapping, request);
					}

				} else {
					return validationErrors("errorDuplicate", "error.duplicate.user", mapping, request);
				}
			}
		// normal & trusted login
		} else if (CommonUtil.isTrustedIp(getServlet().getServletConfig().getServletContext().getRealPath("/"), ip)) {

			boolean sso = true;								

			if (users.getUserType().equalsIgnoreCase("ADMINISTRATOR")) sso = true;
			if (sso) {

				httpSession.setAttribute(CommonConstants.USER, users);
				// load organization!
				Organization organization = OrganizationDAO.getInstance().get(users.getOrganizationId(),hibernateSession);
				httpSession.setAttribute(CommonConstants.ORGANIZATION, organization);
				// load view
				Set set = users.getViewAccess();

				if (set!=null && set.size()>0) {
					httpSession.setAttribute(CommonConstants.VIEWACCESS,set);
					//buat tampilin Start Of Day
					//Calendar calendar = getStartOfDay(users,hibernateSession);
					//httpSession.setAttribute(CommonConstants.SOD, Formater.getFormatedDate(calendar.getTime(), "d MMMM yyyy"));

				} else {
					return validationErrors("errorInvalidRole", "error.invalid.role", mapping, request);
				}
			} else {
				return validationErrors("errorDuplicate", "error.duplicate.user", mapping, request);
			}
		}
		return forward;
	}
	
	
	private ActionForward performInternal(ActionMapping mapping, HttpServletRequest request, LogonForm form,
			HttpSession httpSession, Users users, Session hibernateSession, Organization organization1, String ip,
			int expiredPassCode, OrganizationSetup organizationSetup) throws Exception {
		
		ActionForward forward = null;
		
		// INTERNAL
		try {
			if (CommonUtil.isTrustedIp(getServlet().getServletConfig().getServletContext().getRealPath("/"), ip)) {

				boolean sso = true;								

				if (users.getUserType().equalsIgnoreCase("ADMINISTRATOR"))
					sso = true;
				if (sso) {

					httpSession.setAttribute(CommonConstants.USER, users);
					// load organization!
					Organization organization = OrganizationDAO.getInstance().get(users.getOrganizationId(),hibernateSession);
					httpSession.setAttribute(CommonConstants.ORGANIZATION, organization);
					// load view
					Set set = users.getViewAccess();

					if (set!=null && set.size()>0) {
						httpSession.setAttribute(CommonConstants.VIEWACCESS,set);
						//buat tampilin Start Of Day
						//Calendar calendar = getStartOfDay(users, hibernateSession);
						//httpSession.setAttribute(CommonConstants.SOD, Formater.getFormatedDate(calendar.getTime(), "d MMMM yyyy"));
					} else {
						ActionMessages errors = new ActionMessages();
						errors.add("errorInvalidRole", new ActionMessage("error.invalid.role"));
						saveErrors(request, errors);
						// return
						return (new ActionForward(mapping.getInput()));
					}
				} else {
					return validationErrors("errorDuplicate", "error.duplicate.user", mapping, request);
				}
			} else {
				return validationErrors("errorDuplicate", "error.ip", mapping, request);
			}
		} catch (Exception e) {
			log.error("performInternal exception", e);
		}
		
		return forward;
	}
	

	/** 
	 * Method performLogoff
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performLogoff(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response, String action) {
		HttpSession httpSession = request.getSession();
		Users users = (Users)httpSession.getAttribute(CommonConstants.USER);
		String usr = "-";
		try {
			if(users!=null){
				usr = users.getUserName();
			}
			synchronized(httpSession){
				httpSession.invalidate();
			}
			_RootDAO.closeCurrentThreadSessions();
			
		} catch(Exception ex) {
			log.error("performLogoff Exception", ex);
		} finally {
			log.info("[ END "+this.getClass().getName()+" "+action+" "+usr+"  ] ");
			try {
				UsersDAO.closeCurrentThreadSessions();
			} catch(Exception exx) {
				log.error("performLogoff close session Exception", exx);
			}
		}
		return mapping.findForward("index");
	}
	

	/** 
	 * Method performLogonForm
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performPassCodeForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		return mapping.findForward("index");
	}
	

	/** 
	 * Method performLogonForm
	 * @param ActionMapping mapping
	 * @param ActionForm form
	 * @param HttpServletRequest request
	 * @param HttpServletResponse response
	 * @return ActionForward
	 * @throws Exception
	 */
	private ActionForward performLogonForm(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		HttpSession httpSession = request.getSession();
		if(httpSession.getAttribute(CommonConstants.USER)== null){
			return mapping.findForward("index");
		}
		else{
			return new ActionForward("/home.do",true);
		}
	}
	

	private ActionForward performPasswordExpired(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		LogonForm form = (LogonForm) actionForm;
		Users users = null;
		Session session = UsersDAO.getInstance().getSession();

		try {
			users = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class)
					.add(Restrictions.eq("UserName", form.getString("userName").toLowerCase())).uniqueResult();

			int passDuration = 30;
			
			// get default password-duration
			if(users!=null)passDuration = UsersDAO.getInstance().getUserPassDuration(users.getId(), session);
			form.setString("passDuration",passDuration);

		}catch(Exception ex) {
			log.error("performPasswordExpired Exception", ex);
		}finally {
			log.info("[ END "+this.getClass().getName()+" "+users!=null?users.getUserName():" NULL "+"  ] ");
			try {
				UsersDAO.closeCurrentThreadSessions();
			}catch(Exception exx) {
				log.error("performPasswordExpired close session Exception", exx);
			}
		}
		return mapping.findForward("form");
	}
	

	private ActionForward performPasswordExpiredSave(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) {
		LogonForm form = (LogonForm) actionForm;
		HttpSession httpSession = request.getSession();
		String regex = "";

		try {
			Users users = (Users) UsersDAO.getInstance().getSession().createCriteria(Users.class)
					.add(Restrictions.eq("UserName", form.getString("userName").toLowerCase())).uniqueResult();
			if(users!=null){
				if(users.getId()>0){
					if(users.getUserPass().equalsIgnoreCase(CommonUtil.digest(form.getString("oldPassword")))){
						// check numeric and character combination!
						OrganizationSetup organizationSetup = (OrganizationSetup) OrganizationSetupDAO.getInstance().getSession().createCriteria(OrganizationSetup.class).add(Restrictions.ne("Id", new Long(-1))).uniqueResult();
						regex = "("+regex+".{"+organizationSetup.getMinUserPassLength()+",20})";

						Pattern pattern = Pattern.compile(regex);
						Matcher matcher = pattern.matcher(form.getString("newPassword"));
						/*if (!matcher.matches()) {
							ActionMessages errors = new ActionMessages();
							errors.add("invalidData",new ActionMessage("error.invalid.data", "Password must contain "+(organizationSetup.isAlphabetUserPass()?"alphabet":"")+" "+(organizationSetup.isNumericUserPass()?"numeric":"")+" "+(organizationSetup.isUpperCaseLetter()?"upper-case letter":"")+" combination and less "+(organizationSetup.getMinUserPassLength())+" characters."));
							saveErrors(request,errors);
							return (new ActionForward(mapping.getInput()));

						}*/
						// save history
						if (UserPasswordHistoryDAO.getInstance().saveValidChangeUserPass(users.getId(), organizationSetup.getUserPassHistory(), form.getString("newPassword")) ||  users.getLastLoginTime() == null) {
							users.setUserPass(CommonUtil.digest(form.getString("newPassword")));
							users.setLastLoginTime(new Date());
							UsersDAO.getInstance().update(users);
						}else {
							ActionMessages errors = new ActionMessages();
							errors.add("invalidData",new ActionMessage("error.invalid.data", "Please input another password!"));
							saveErrors(request,errors);
							return (new ActionForward(mapping.getInput()));
						}
						// password expired
						UserPasswordHistoryDAO.getInstance().passExpired(users, request);

						// logoff
						httpSession.invalidate();

					} else{
						ActionMessages errors = new ActionMessages();
						errors.add("errorsOldPassword",new ActionMessage("error.old.password"));
						saveErrors(request,errors);
						return (new ActionForward(mapping.getInput()));
					}
				}
			}
		
		}catch(Exception ex) {
			log.error("performPasswordExpiredSave Exception", ex);
		}finally {
			try {
				RoleDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
				log.error("performPasswordExpiredSave role session close Exception", exx);
			}
			try {
				UsersDAO.getInstance().closeSessionForReal();
			}catch(Exception exx) {
				log.error("performPasswordExpiredSave user session close Exception", exx);
			}
		}
		return mapping.findForward("form2");
	}
	
	
	/**
	 * @param errorType
	 * @param errorMessage
	 * @param mapping
	 * @param request
	 * @return Validasi Error Login
	 */
	private ActionForward validationErrors(String errorType, String errorMessage, ActionMapping mapping, HttpServletRequest request) {
		ActionMessages errors = new ActionMessages();
		errors.add(errorType, new ActionMessage(errorMessage));
		saveErrors(request, errors);
		String browserType = request.getHeader("User-Agent");
		if (browserType.indexOf("Mozilla") > -1 || browserType.indexOf("Firefox") > -1 || browserType.indexOf("Opera") > -1)
			return (new ActionForward(mapping.getInput()));
		else
			return new ActionForward("/logon/form.do", true);
	}

	
	/**
     * @param users
     * @return Calendar berisi Start of Day
     */
   /* private Calendar getStartOfDay(Users users, Session s) {
        Calendar calendar = new GregorianCalendar();
        try {
            StringBuilder sbLocker = new StringBuilder();
            sbLocker.append("select locker_date as L ");
            sbLocker.append("from locker ");
            sbLocker.append("where ");

            if(users.getBranchId()!=null) {
                Branch branch = BranchDAO.getInstance().get(users.getBranchId(),s);
                if(branch!=null){
                	if(branch.getBranchType().equalsIgnoreCase("OUTLET")){
                        sbLocker.append(" branch_id = ").append(branch.getParent().getId());
                    }else{
                        sbLocker.append(" branch_id = ").append(branch.getId());
                    }
                }
            }
            else {
                sbLocker.append(" branch_id = 1 ");
            }

            sbLocker.append(" order by locker_date desc ");
            Date dateLocker = (Date)s.createSQLQuery(sbLocker.toString()).addScalar("L", Hibernate.DATE).setMaxResults(1).uniqueResult();
            calendar.setTime(dateLocker!=null?dateLocker:new Date());

            calendar.add(Calendar.DATE, 1);
            if(calendar.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY)calendar.add(Calendar.DATE, 2);
        } catch (Exception e) {
            log.error("LogonAction getStartOfDay Exception", e);
        }
        return calendar;
    } */


	/** 
	 * Method generalError
	 * @param HttpServletRequest request
	 * @param Exception ex
	 */
	private void generalError(HttpServletRequest request, Exception ex) {
		ActionMessages errors = new ActionMessages();
		errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.global",ex.getMessage()));
		saveErrors(request,errors);
	}
	
	
	public static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password, MessageDigest md) {

	    int digestLength = md.getDigestLength();
	    int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
	    byte[] generatedData = new byte[requiredLength];
	    int generatedLength = 0;

	    try {
	        md.reset();

	        // Repeat process until sufficient data has been generated
	        while (generatedLength < keyLength + ivLength) {

	            // Digest data (last digest if available, password data, salt if available)
	            if (generatedLength > 0)
	                md.update(generatedData, generatedLength - digestLength, digestLength);
	            md.update(password);
	            if (salt != null)
	                md.update(salt, 0, 8);
	            md.digest(generatedData, generatedLength, digestLength);

	            // additional rounds
	            for (int i = 1; i < iterations; i++) {
	                md.update(generatedData, generatedLength, digestLength);
	                md.digest(generatedData, generatedLength, digestLength);
	            }

	            generatedLength += digestLength;
	        }

	        // Copy key and IV into separate byte arrays
	        byte[][] result = new byte[2][];
	        result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
	        if (ivLength > 0)
	            result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

	        return result;

	    } catch (DigestException e) {
	        throw new RuntimeException(e);

	    } finally {
	        // Clean out temporary data
	        Arrays.fill(generatedData, (byte)0);
	    }
	}

}
