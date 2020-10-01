/*
 * Created on Jun 25, 2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.mpe.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.security.Key;
import java.security.MessageDigest;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.security.spec.AlgorithmParameterSpec;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.Logger;
import org.apache.struts.Globals;
import org.hibernate.criterion.Restrictions;

import com.ams.mufins.model.MasterVersioning;
import com.ams.mufins.model.UserStream;
import com.ams.mufins.model.Users;
import com.ams.mufins.model.View;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class CommonUtil {
	static Logger log = Logger.getLogger(CommonUtil.class);
	public static final String EQUAL = "=";
	public static final String pathHeaderImage = initHeader();
	
	public static String initHeader(){
		String propertyHome = CommonDynamics.CATALINA_BASE;
		String headerPropertyPath = propertyHome + "/conf/header.properties";
		PropertiesConfiguration prop = null;
		try {
			prop = new PropertiesConfiguration(headerPropertyPath);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
		return prop.getString("pathHeaderImage");
	}
	
	public static String getHeader(){
		return pathHeaderImage;
	}
	
	public static void removeSession(HttpServletRequest request){
		
		HttpSession httpSession = request.getSession();
		httpSession.removeAttribute("insuranceRefund");
		httpSession.removeAttribute("cfApplication");
		httpSession.removeAttribute("factoring");
		httpSession.removeAttribute("journal");
		httpSession.removeAttribute("accountStatement");
		httpSession.removeAttribute("personal");
	}
	
	
	/**
	 * create by Prince hendrie
	 * on 3 Agustus 2015
	 * 
	 * hapus semua session kecuali session kecuali session sod, lastLogin, userstream, org.apache.struts.action.LOCALE, viewAccess, user, ORGANIZATION
	 *
	 */
	public static void removeAllSession(HttpServletRequest request){
		HttpSession httpSession = request.getSession();
		synchronized (httpSession){
			Enumeration<String> e = httpSession.getAttributeNames();

			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				if(!key.equalsIgnoreCase(CommonConstants.SOD) && !key.equalsIgnoreCase(CommonConstants.LASTLOGIN) && !key.equalsIgnoreCase(CommonConstants.USERSTREAM)
						&& !key.equalsIgnoreCase(Globals.LOCALE_KEY) && !key.equalsIgnoreCase(CommonConstants.VIEWACCESS) 
						&& !key.equalsIgnoreCase(CommonConstants.USER) && !key.equalsIgnoreCase(CommonConstants.ORGANIZATION) && !key.equalsIgnoreCase(CommonConstants.URL)
						&& !key.equalsIgnoreCase("windowId")){
					try {
						httpSession.removeAttribute(key);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		}
	}
	
	 public static String alphaNumeric(String input) { 
	    String pattern = "[^\\s0-9a-zA-Z]";  // whitespace or alpha-numeric
	
	    // create and print output
	    String output = input.replaceAll(pattern, "");
	    output = output.replaceAll(" ", "");
	    return output;
	}
	
	public static double flatToEffective(double amount, int periode, double iFlat) {
		double iEffective = 0;
		
		boolean kond = true; // 0 false 1 true
		double rent1 = 0;
		double bunga1 = 100;
		double skbunga = 50;
		double bunga3 = 0;
		double varr1 = ((iFlat / 100) / 12);
		double rental = ((amount * varr1 * periode) + amount ) / periode ;
		while(kond){
			if (Math.abs(rent1 - rental) <= 0.01){
				double bunga = Math.round(skbunga * 100000);
				iEffective = bunga/100000;
				break;
			}
			rent1 = ad_angs(skbunga,periode,amount);
			if (rent1 > rental){
				bunga1 = skbunga;
				skbunga = ((bunga1 + bunga3) / 2);
			} else
			{
				bunga3 = skbunga;
				skbunga = ((bunga1 + bunga3) / 2);
			}
		}
			
		return iEffective;
	}

	private static double ad_angs(double sb, int jwt, double plf){
		double var1 = sb / 1200;
		double var2 = Math.pow((var1 + 1), jwt);
		double var4 = Math.pow((var1 + 1), (jwt-1));
		double var3 = 0;
		
		String tipe_angsuran = "Arear";
		tipe_angsuran = "Advance";
		if (tipe_angsuran.equalsIgnoreCase("Advance")){
			var3 = (plf * ((var1*var4)/(var2 - 1)));
		}
		else{
			var3 = (plf * ((var1*var2)/(var2 - 1)));
		}
		return var3;
	}
	
	public static double unearned(double financeAmount, int tenor, double interestFlat){
		
		double unearned = Math.round((tenor / 12) * (interestFlat / 100) * financeAmount);
		
		double CicilanValue = ((financeAmount + unearned) / tenor) / 10;
		
		double rental = Math.round(CicilanValue) * 10;
		
		double simpan = Math.round(((rental * tenor) - financeAmount) / 10);
		
		unearned = simpan * 10;
		
		return unearned;
	}
	
	//drawdown report
	public static double rate_ad(double amount, int periode, double rental) {
		
		double rent1 = 0;
		double bunga1 = 100;
		double skbunga = 50;
		double bunga3 = 0;
		
		while(Math.abs(rental - rent1) > 0.001){
			rent1 = ad_angs(skbunga, periode, amount);
			
			if (rent1 > rental)bunga1 = skbunga;
			else bunga3 = skbunga;
			
			skbunga = ((bunga1 + bunga3) / 2);
		}
			
		return skbunga;
		
	}
	
	public static boolean isLastRouting(Set set) {
		if (set!=null && set.size()==1) return true;
		else if (set!=null && set.size()>1) return false;
		return true;
	}
	
	public static boolean isHasRoleAccess(java.util.Set lst,String viewAccessPath) {
		if(lst !=null && viewAccessPath!=null) {
			java.util.Iterator itr = lst.iterator();
			while(itr.hasNext()) {
				View view = (View)itr.next();
				if (view.getLink()!=null) {
					try {
						if (view.getLink().equals(viewAccessPath)) return true;
					} catch(Exception exx) {
					}
				}
			}
		}
		return false;		
	}
	
	public static String getViewName(java.util.Set lst,String viewAccessPath) {
		if(lst !=null && viewAccessPath!=null) {
			java.util.Iterator itr = lst.iterator();
			while(itr.hasNext()) {
				View view = (View)itr.next();
				if (view.getLink()!=null) {
					try {
						if (view.getLink().equals(viewAccessPath)) return view.getViewName();
					} catch(Exception exx) {
					}
				}
			}
		}
		return "H O M E";		
	}
	
	
	
	/** 
	 * Method digest.
	 * @return String
	 */
	public static String digest(String plain) throws Exception {
		if (plain == null) return null;
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			sha.update(plain.getBytes("UTF-16"));
			byte bs[] = sha.digest();
			StringBuffer res = new StringBuffer();
			for (int ix=0; ix<bs.length; ix++) {
				int i;
				byte b = bs[ix];
				if (b > 0) i = b; else i = 256 + b;
				int d = i / 16;
				if (d > 9) res.append((char) ('A' + d - 10)); else res.append((char) ('0' + d));
				d = i % 16;
				if (d > 9) res.append((char) ('A' + d - 10)); else res.append((char) ('0' + d));
			}
			return res.toString();
		} catch (Exception ex) {
			throw new Exception("Digest Exception",ex);
		}
	}
	
	public static String getMedia(byte[] b) throws Exception {
		StringBuffer out = new StringBuffer();
		out.append(new String(b, "ISO-8859-1"));
		return out.toString();
	}
	
	public static String randomin(int minLeft, int lenLeft, int minRight, int lenRight, String string) {
		String[] data = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		Random generator = new Random();
		StringBuffer result = new StringBuffer();

		int len = minLeft + generator.nextInt(lenLeft);
		for (int i=0; i<len; i++) {
			int idx = generator.nextInt(data.length);
			result.append(data[idx]);
			idx = generator.nextInt(data.length);
		}

		result.append(string);

		len = minRight + generator.nextInt(lenRight);
		for (int i=0; i<len; i++) {
			int idx = generator.nextInt(data.length);
			result.append(data[idx]);
			idx = generator.nextInt(data.length);
		}

		return result.toString();
	}
	
	public static String htmlEntities(String value){
		String result = value;
		try{
			
			String[][] tagArray = new String[][]{{"<","&lt;"}, {">","&gt;"}, {"\\[b\\]","<b>"}, {"\\[li\\]","<li>"} ,{"\\[/b\\]","</b>"}, {"\\[i\\]","<i>"}, {"\\[/i\\]","</i>"}, {"\\[ul\\]","<ul>"}, {"\\[ul type=\"1\"\\]","<ul type=\"1\">"} ,  {"\\[ul type=\"a\"\\]","<ul type=\"a\">"} ,  {"\\[ul type=\"A\"\\]","<ul type=\"A\">"} ,{"\\[/ul\\]","</ul>"}, {"\\[center\\]","<center>"}, {"\\[/center\\]","</center>"}, {"\\[br\\]","<br>"}, {"\\[/br\\]","</br>"}, {"\\[u\\]","<u>"}, {"\\[/u\\]","</u>"}};
  			for (int i = 0; i < tagArray.length; i++) {
              result=result.replaceAll(tagArray[i][0]  , tagArray[i][1]);
            }

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}


	public static String htmlUser(String value){
		String result = value;
		try{
			
			String[][] tagArray = new String[][]{{"<","\\["}, {">","\\]"} ,{"</","\\[/"}};
  			for (int i = 0; i < tagArray.length; i++) {
              result=result.replaceAll(tagArray[i][0]  , tagArray[i][1]);
            }

		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
	
	public static int bedaHari(Date date1, Date date2){
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		//cek keterlambatan
		if(cal2.after(cal1)){
			int selisihHari = 0;
			for(int i=cal1.get(Calendar.YEAR);i<=cal2.get(Calendar.YEAR);i++){
				int awal = 0;
				int akhir = 365;
				if(i%4==0){
					akhir = 366;
				}
				int selisih;
				//cek awal
				if(i==cal1.get(Calendar.YEAR)){
					awal = cal1.get(Calendar.DAY_OF_YEAR);
				}
				//cek akhir
				if(i==cal2.get(Calendar.YEAR)){
					akhir = cal2.get(Calendar.DAY_OF_YEAR);
				}
				selisih = akhir - awal;
				selisihHari+=selisih;
			}
			
			return selisihHari;
		}
		else 
			return 0;
	}
	
	public static int bedaHari(Calendar cal1, Calendar cal2){
		
		//cek keterlambatan
		if(cal2.after(cal1)){
			int selisihHari = 0;
			for(int i=cal1.get(Calendar.YEAR);i<=cal2.get(Calendar.YEAR);i++){
				int awal = 0;
				int akhir = 365;
				if(i%4==0){
					akhir = 366;
				}
				int selisih;
				//cek awal
				if(i==cal1.get(Calendar.YEAR)){
					awal = cal1.get(Calendar.DAY_OF_YEAR);
				}
				//cek akhir
				if(i==cal2.get(Calendar.YEAR)){
					akhir = cal2.get(Calendar.DAY_OF_YEAR);
				}
				selisih = akhir - awal;
				selisihHari+=selisih;
			}
			
			return selisihHari;
		}
		else 
			return 0;
	}
	
	public static int bedaBulan(Date date1, Date date2){
		
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		//cek keterlambatan
		if(cal2.after(cal1)){
			int selisihBulan = 0;
			for(int i=cal1.get(Calendar.YEAR); i<=cal2.get(Calendar.YEAR); i++){
				int awal = 0;
				int akhir = 11;
				int selisih;
				//cek awal
				if(i==cal1.get(Calendar.YEAR)){
					awal = cal1.get(Calendar.MONTH);
				}
				//cek akhir
				if(i==cal2.get(Calendar.YEAR)){
					akhir = cal2.get(Calendar.MONTH);
				}
				selisih = akhir - awal;
				selisihBulan+=selisih;
			}
			selisihBulan+= cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR); 
			return selisihBulan;
		}
		else 
			return 0;
	}
	
	public static int bedaBulan(Calendar cal1, Calendar cal2){
		
		//cek keterlambatan
		if(cal2.after(cal1)){
			int selisihBulan = 0;
			for(int i=cal1.get(Calendar.YEAR); i<=cal2.get(Calendar.YEAR); i++){
				int awal = 0;
				int akhir = 11;
				int selisih;
				//cek awal
				if(i==cal1.get(Calendar.YEAR)){
					awal = cal1.get(Calendar.MONTH);
				}
				//cek akhir
				if(i==cal2.get(Calendar.YEAR)){
					akhir = cal2.get(Calendar.MONTH);
				}
				selisih = akhir - awal;
				selisihBulan+=selisih;
			}
			selisihBulan+= cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR);
			return selisihBulan;
		}
		else 
			return 0;
	}
	
	//Input Stream to String
	public static String parseISToString(java.io.InputStream is){
		java.io.DataInputStream din = new java.io.DataInputStream(is);
		StringBuffer sb = new StringBuffer();
		try{
			String line = null;
			while((line=din.readLine()) != null){
				sb.append(line+"\n");
			}
		} catch(Exception ex){
			ex.getMessage();
		}finally{
			try{
				is.close();
			}catch(Exception ex){}
			}
		return sb.toString();
	}

	//String to InputStream
	public static java.io.InputStream parseStringToIS(String xml){
		if(xml==null) return null;
		xml = xml.trim();
		java.io.InputStream in = null;
		try{
			in = new java.io.ByteArrayInputStream(xml.getBytes("UTF-8"));
		}catch(Exception ex){
		}
		return in;
	}
	
	public static int bedaHariSabtuMinggu(Calendar cal1, Calendar cal2){
		
		//cek keterlambatan
		if(cal2.after(cal1)){
			int sabtuMinggu = 0;
			Calendar cek = new GregorianCalendar();
			cek.setTime(cal1.getTime());
			for(int i = cal1.get(Calendar.YEAR); i <= cal2.get(Calendar.YEAR); i++){
				for (int j = (i==cal1.get(Calendar.YEAR)?cal1.get(Calendar.MONTH):0); j <= (i==cal2.get(Calendar.YEAR)?cal2.get(Calendar.MONTH):11); j++) {
					for (int k = (i==cal1.get(Calendar.YEAR)&&j==cal1.get(Calendar.MONTH)?cal1.get(Calendar.DAY_OF_MONTH):1); k <= (i==cal2.get(Calendar.YEAR)&&j==cal2.get(Calendar.MONTH)?cal2.get(Calendar.DAY_OF_MONTH):cek.getActualMaximum(Calendar.DAY_OF_MONTH)); k++) {
						if(cek.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY || cek.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)sabtuMinggu++;
						cek.add(Calendar.DATE, 1);
					}
				}
			}
			
			return sabtuMinggu;
		}
		else 
			return 0;
	}
	
	
	public static Set getTrustedIp(String path) {
		Set set = new LinkedHashSet();
		try {
			
	        
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return set;
	}
	
	public static boolean isTrustedIp(String path, String ip) {
		boolean b = false;
		try {
			
			File file = new File(path+"/files/trusted_ip.txt");
			BufferedReader in = new BufferedReader(new FileReader(file));
	        String str;
	        while ((str = in.readLine()) != null) {
	        	if (ip.equals(new String(str.trim()))) {
	        		b = true;
	        		break;
	        	}
	        }
			
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return b;
	}

	public static boolean isHasBeenLoggedIn(java.util.Set lst, HttpServletRequest request, Users user) {
        boolean result = false;
        String viewAccessPath = request.getServletPath();
        if(lst !=null && viewAccessPath!=null) {
            java.util.Iterator itr = lst.iterator();
            while(itr.hasNext()) {
                View view = (View)itr.next();
                if (view.getLink()!=null) {
                    try {
                        if (view.getLink().equals(viewAccessPath)) result = true;
                    } catch(Exception exx) {
                    }
                }
            }
        }
        if(result = true){
            result = validateIpAndBrowser(request, user);
        }
        return result;
    }
	
	public static boolean validateIpAndBrowser(HttpServletRequest request,Users user){
        boolean result = true;
        try {
            java.util.Map userstreams = (java.util.Map)request.getServletContext().getAttribute("userstreams");
            java.util.Iterator itr = userstreams.keySet().iterator();
            boolean userLogon = false;
            if(!user.getUserType().equalsIgnoreCase("ADMINISTRATOR")){
	            while (itr.hasNext()) {
	                String key = (String)itr.next();
	                UserStream userstream = (UserStream)userstreams.get(key);
	                if(userstream.getUserName()!=null && user.getUserName()!=null){
	    				if(userstream.getUserName().equalsIgnoreCase(user.getUserName())){
		                    if(userstream.getUserName().equalsIgnoreCase(user.getUserName()) && !userstream.getIp().equalsIgnoreCase(request.getRemoteAddr())){
		                        request.getSession().invalidate();
		                        result = false;
		                        break;
		                    }else if(userstream.getUserName().equalsIgnoreCase(user.getUserName()) && userstream.getIp().equalsIgnoreCase(request.getRemoteAddr()) && !userstream.getBrowser().equalsIgnoreCase(request.getHeader("User-Agent"))){
		                        request.getSession().invalidate();
		                        result = false;
		                        break;
		                    }
	                        userLogon = true;
	    				}
	                }
	            }
	            if(!userLogon){
	            	request.getSession().invalidate();
	                result = false;
	            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public static GregorianCalendar getDateFromGregorianCalendar(int date, int month, int year){
		GregorianCalendar gc = new GregorianCalendar();
	    gc.setLenient(false);
	    gc.set(GregorianCalendar.YEAR, year);
	    gc.set(GregorianCalendar.MONTH, month);
	    gc.set(GregorianCalendar.DATE, date);

	    return gc;
	}
	
	public static List<Long> getIdFromMultipleCheckbox (String arrayString){
		List<Long> multipleCheckboxIdList = new LinkedList<Long>();
		String value = "";
		
		if(arrayString.endsWith(",")){
			arrayString = arrayString.substring(0,arrayString.length() - 1);
			if(!arrayString.contains(",")) multipleCheckboxIdList.add(Long.valueOf(arrayString));
			else{
				multipleCheckboxIdList = convertStringToListLong(arrayString);
			}
		}else{
			if(!arrayString.contains(",")) multipleCheckboxIdList.add(Long.valueOf(arrayString));
			else{
				value = arrayString.substring(0,arrayString.lastIndexOf(","));
				multipleCheckboxIdList = convertStringToListLong(value);
			}
			
		}
		return multipleCheckboxIdList;
	}
	
	public static List<Long> convertStringToListLong (String value){
		List<Long> list = new LinkedList<Long>();
		String[] ss=value.split(",");
		for(int i=0;i<ss.length;i++){
			list.add(Long.valueOf(ss[i]));
		}
		return list;
	}
	
	public static String getIdListString (List<Long> idList){
		StringBuffer sb = new StringBuffer();
		for(Long id : idList){
			sb.append(id.toString()+",");
		}
		sb.setLength(sb.length() - 1);
		return sb.toString();
	}
	
	public static GregorianCalendar convertUtilDateToGregorianCalendar(Date date){
	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(date);
	    return calendar;
	}
	
	public static HostnameVerifier byPass(final String strHost){
		
		 HostnameVerifier allHostsValid = null;
		try {
			TrustManager[] trustAllCerts = new TrustManager[] {
		       new X509TrustManager() {
				
				@Override
				public X509Certificate[] getAcceptedIssuers() {
					return null;
				}
				
				@Override
				public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					
				}
				
				@Override
				public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				}
		       }
			};
			
			SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		    
		 //  final  String strHost ="sit.secure.smfs.co.id";
		    // Create all-trusting host name verifier
		    allHostsValid = new HostnameVerifier() {
				
				@Override
				public boolean verify(String hostname, SSLSession session) {
					if(hostname.equalsIgnoreCase(strHost)){
		                return true;
		            }
		            return false;
				}
			};
			return allHostsValid;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return allHostsValid;
	}
	
	public static Session sftpConnect(Session session, String username, String host, int port, String password) throws Exception{
		
        JSch jsch = new JSch();
	
        session = jsch.getSession(username, host, port);
	
        session.setPassword(password);
	
        session.setConfig("StrictHostKeyChecking", "no");
	
        session.connect();
        
        return session;
		
	}
	
	public static String hashMufins(String input) throws Exception {
        MessageDigest sha = MessageDigest.getInstance("SHA-1");
        sha.update(input.getBytes("UTF-16"));
        byte bs[] = sha.digest();
        StringBuffer output = new StringBuffer();
        for (int ix = 0; ix < bs.length; ix++) {
            int i;
            byte b = bs[ix];
            if (b > 0)
                i = b;
            else
                i = 256 + b;
            int d = i / 16;
            if (d > 9)
                output.append((char) ('A' + d - 10));
            else
                output.append((char) ('0' + d));
            d = i % 16;
            if (d > 9)
                output.append((char) ('A' + d - 10));
            else
                output.append((char) ('0' + d));
        }
        return output.toString();
    }

    public static String hashHR(String key, String nik, String issuer) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(key);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, 5);

        JwtBuilder builder = Jwts.builder().setIssuer(issuer).setId(nik).setHeaderParam("typ", "JWT").signWith(signatureAlgorithm, signingKey);
        builder.setExpiration(cal.getTime());
        return builder.compact();
    }

    public static byte[] encrypt(String ivStr, String keyStr, byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(ivStr.getBytes());
        byte[] ivBytes = md.digest();

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(keyStr.getBytes());
        byte[] keyBytes = sha.digest();

        return encrypt(ivBytes, keyBytes, bytes);
    }

    public static byte[] encrypt(byte[] ivBytes, byte[] keyBytes, byte[] bytes) throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);
        return cipher.doFinal(bytes);
    }

    public static byte[] decrypt(String ivStr, String keyStr, byte[] bytes) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(ivStr.getBytes());
        byte[] ivBytes = md.digest();

        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        sha.update(keyStr.getBytes());
        byte[] keyBytes = sha.digest();

        return decrypt(ivBytes, keyBytes, bytes);
    }

    public static byte[] decrypt(byte[] ivBytes, byte[] keyBytes, byte[] bytes)  throws Exception {
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, newKey, ivSpec);
        return cipher.doFinal(bytes);
    }

    public static String encryptStrAndToBase64(String ivStr, String keyStr, String enStr) throws Exception {
        byte[] bytes = encrypt(keyStr, keyStr, enStr.getBytes("UTF-8"));
        return new String(Base64.encode(bytes , Base64.DEFAULT), "UTF-8");
    }

    public static String decryptStrAndFromBase64(String ivStr, String keyStr, String deStr) throws Exception {
        byte[] bytes = decrypt(keyStr, keyStr, Base64.decode(deStr.getBytes("UTF-8"), Base64.DEFAULT));
        return new String(bytes, "UTF-8");
    }

    public static String pattern() throws Exception  {
        DateFormat dateFormat = new SimpleDateFormat("ddMMHHmm");
        Date date = new Date();
        String pattern1 = dateFormat.format(date)
                .replace("0","A")
                .replace("1","B")
                .replace("2","C")
                .replace("3","D")
                .replace("4","E")
                .replace("5","F")
                .replace("6","G")
                .replace("7","H")
                .replace("8","I")
                .replace("9","J");
        String pattern2 = dateFormat.format(date)
                .replace("0","a")
                .replace("1","b")
                .replace("2","c")
                .replace("3","d")
                .replace("4","e")
                .replace("5","f")
                .replace("6","g")
                .replace("7","h")
                .replace("8","i")
                .replace("9","j");
        return pattern1+"-"+pattern2;
    }

    public static String encrypt(String str, String pattern) throws Exception {
        String[] patterns = pattern.split("-");
        return encryptStrAndToBase64(patterns[0], patterns[1], str);
    }

    public static String decryptString(String str, String pattern) throws Exception  {
        String[] patterns = pattern.split("-");
        return decryptStrAndFromBase64(patterns[0], patterns[1], str);
    }
    
    public static Date formatedDate(long date) throws Exception {

    	SimpleDateFormat simpledateformate= new SimpleDateFormat("yyyy-MM-dd");
    	String DATE = simpledateformate.format(date);
    	Date returnDate = simpledateformate.parse(DATE);
    	
		return returnDate;
    	
    }
    
    public static Date formatedDateFromLong(long date) throws Exception {
    	
    	 String dat = new java.text.SimpleDateFormat("yyyy-MM-dd")
				.format(new java.util.Date (date*1000));
    	
    	 Date dates = new SimpleDateFormat("yyyy-MM-dd").parse(dat);
    	 
    	 return dates;
    }
    
    public static MasterVersioning getSimaskuVersion (org.hibernate.Session session) throws Exception {
    	
    	MasterVersioning versioning = (MasterVersioning) session.createCriteria(MasterVersioning.class)
				.add(Restrictions.eq("MasterVersionName", "KREDITSIMASKU_VERSION"))
				.add(Restrictions.eq("MasterVersionApp", "KREDITSIMASKU"))
				.setMaxResults(1)
				.uniqueResult();
    	
    	return versioning;
    }
	
}