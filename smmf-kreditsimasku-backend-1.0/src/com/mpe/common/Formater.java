/*
 * Created on Oct 29, 2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.mpe.common;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
import java.math.BigDecimal;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;

public class Formater {
	  
	
	  public static final int DAY = 0;
	  public static final int MONTH = 1;
	  	
	  public static ResourceBundle prop = ResourceBundle.getBundle("resource.ApplicationResources");
	  
	  /*mencegah new Formater() sekaligus init variable untuk format tanggal*/
	  private Formater(){ }
	  
		private static String[] htmlCommand = {"&lt;", "&gt;", "&amp;", "&quot;", "&nbsp;"};
		private static String[] htmlCommandReplace = {"<", ">", "&", "'", " "};
		
		private static String[] tandaBaca = {"'", ",", " "};
		
		public synchronized static String getFormatedPayment(double x) {
			java.text.DecimalFormat df = new java.text.DecimalFormat("0");
			java.text.DecimalFormat df2 = new java.text.DecimalFormat("000");
			String a = df.format(x);
			String out = "";
			if (a.length() > 3) {
				String a1 = a.substring(0, a.length()-3);
				String a2 = a.substring(a.length() - 3);
				double w = Double.parseDouble(a2);
				if (w > 0 && w < 250 ) {
					w = 0;
				} else if (250 <= w && w < 500) {
					w = 500;
				} else if (500 <= w && w < 750) {
					w = 500;
				} else if (750 <= w && w <= 1000) {
					w = 1000;
				}
				if (w == 1000) {
					double w1 = Double.parseDouble(a1);
					w1 = w1 + 1;
					out = df.format(w1)+"000";
				} else {
					out = a1 + df2.format(w);
				}
			} else {
				if (a.length() == 3) {
					double w = Double.parseDouble(a);
					if (w > 0 && w < 250 ) {
						w = 0;
					} else if (250 <= w && w < 500) {
						w = 500;
					} else if (500 <= w && w < 750) {
						w = 500;
					} else if (750 <= w && w <= 1000) {
						w = 1000;
					}
					out = df.format(w);
				} else if (a.length() > 0 && a.length() <3) {
					double w = Double.parseDouble(a);
					if (w > 0) {out = "500";} else out = "0"; 
				} else {
					out = "0";
				}
			}
			return out;
		}
		
		public synchronized static String[] getFormatedOutput(int numberOfDigit, double[] amount, double pembagi) {
			
			String[] hasil = new String[amount.length];
			double[] nilai = new double[amount.length];
			
			for (int i = 0; i < amount.length; i++) {
				nilai[i] = round(numberOfDigit, amount[i] / pembagi);
			}
			
			java.text.DecimalFormat df = new DecimalFormat("0.000");
			df.setGroupingSize(3);
			for (int i = 0; i < amount.length; i++) {
				hasil[i] = df.format(nilai[i]);
			}
			
			return hasil;
			
		}
		
		public synchronized static String getFormatedOutput(int numberOfDigit, double amount, double pembagi) {
			
			double nilai = round(numberOfDigit, amount / pembagi);
			
			java.text.DecimalFormat df = new DecimalFormat("0.000");
			df.setGroupingSize(3);
			return df.format(nilai);
			
		}
		
		public synchronized static String getFormatedOutput(int numberOfDigit, double x) {
			java.text.DecimalFormat df = new DecimalFormat("###,###,###,###,###,###.##");
			if (numberOfDigit == 5) {
				df = new DecimalFormat("###,###,###,###,###,##0.00000");
				df.setGroupingSize(3);
				return df.format(x);
			} else if (numberOfDigit == 4) {
				df = new DecimalFormat("###,###,###,###,###,##0.0000");
				df.setGroupingSize(3);
				return df.format(x);
			} else if (numberOfDigit == 3) {
				df = new DecimalFormat("###,###,###,###,###,##0.000");
				df.setGroupingSize(3);
				return df.format(x);
			} else if (numberOfDigit == 2) {
				df = new DecimalFormat("###,###,###,###,###,##0.00");
				df.setGroupingSize(3);
				return df.format(x);	
			} else if (numberOfDigit == 1) {
				df = new DecimalFormat("###,###,###,###,###,##0.0");
				df.setGroupingSize(3);
				return df.format(x);
			} else if (numberOfDigit == 0) {
				df = new DecimalFormat("###,###,###,###,###,##0");
				df.setGroupingSize(3);
				return df.format(x);
			} else {
				df.setGroupingSize(3);
				return df.format(x);
			}
		}
		
		public synchronized static String getFormatedOutputCurrency(int numberOfDigit, double x) {
			String currency = "Rp ";
			java.text.DecimalFormat df = new DecimalFormat("###,###,###,###,###,###.##");
			if (numberOfDigit == 5) {
				df = new DecimalFormat("###,###,###,###,###,##0.00000");
				df.setGroupingSize(3);
				return currency + df.format(x);
			} else if (numberOfDigit == 4) {
				df = new DecimalFormat("###,###,###,###,###,##0.0000");
				df.setGroupingSize(3);
				return currency + df.format(x);
			} else if (numberOfDigit == 3) {
				df = new DecimalFormat("###,###,###,###,###,##0.000");
				df.setGroupingSize(3);
				return currency + df.format(x);
			} else if (numberOfDigit == 2) {
				df = new DecimalFormat("###,###,###,###,###,##0.00");
				df.setGroupingSize(3);
				return currency + df.format(x);	
			} else if (numberOfDigit == 1) {
				df = new DecimalFormat("###,###,###,###,###,##0.0");
				df.setGroupingSize(3);
				return currency + df.format(x);
			} else if (numberOfDigit == 0) {
				df = new DecimalFormat("###,###,###,###,###,##0");
				df.setGroupingSize(3);
				return currency + df.format(x);
			} else {
				df.setGroupingSize(3);
				return currency + df.format(x);
			}
		}
		
		public synchronized static String getFormatedOutputForm(int numberOfDigit, double x) {
			java.text.DecimalFormat df = new DecimalFormat("0.##");
			if (numberOfDigit == 5) {
				df = new DecimalFormat("0.00000");
				return df.format(x);
			} else if (numberOfDigit == 4) {
				df = new DecimalFormat("0.0000");
				return df.format(x);
			} else if (numberOfDigit == 3) {
				df = new DecimalFormat("0.000");
				return df.format(x);
			} else if (numberOfDigit == 2) {
				df = new DecimalFormat("0.00");
				return df.format(x);	
			} else if (numberOfDigit == 1) {
				df = new DecimalFormat("0.0");
				return df.format(x);
			} else if (numberOfDigit == 0) {
				df = new DecimalFormat("0");
				return df.format(x);
			} else {
				return df.format(x);
			}
		}
		
		public synchronized static double getFormatedOutputResult(int numberOfDigit, double x) {
			return round(numberOfDigit, x);
		}
		
		public synchronized static String getFormatedOutputNoDecimal(double x) {
			java.text.DecimalFormat df = new DecimalFormat("###,###,###,###,###,##0");
			df.setGroupingSize(3);
			return df.format(x);
		}
		
		public synchronized static String getFormatedOutput(double x) {
			java.text.DecimalFormat df = new DecimalFormat("###,###,###,###,###,##0.00000");
			df.setGroupingSize(3);
			return df.format(x);
		}
		
		public synchronized static String getFormatedOutputForm(double x) {
			java.text.DecimalFormat df = new DecimalFormat("0");
			return df.format(x);
		}
		
		private static final SimpleDateFormat sdft = new SimpleDateFormat(prop.getString("date.formater"));
		public synchronized static String getFormatedDate(Date date) {
			return date!=null?sdft.format(date):"";
		}
		
		public synchronized static String getFormatedDate(Date date, String format) {
			SimpleDateFormat sdx = new SimpleDateFormat(format);
			String str = null;
			try {
				str = sdx.format(date);
				return str;
			} catch (Exception e) {
				return "";
			}
		}
		
		public synchronized static String getFormatedDateTxt(Date date, String format) {
			int i = format.length();
			String space = "";
			for(int j=0; j<i ;j++){
				space+=" ";
			}
			return date!=null?new SimpleDateFormat(format).format(date):space;
		}
		
		public synchronized static Date getFormatedDate(String strDate, String format) {
			Date date = null;
			try {
				date = new SimpleDateFormat(format).parse(strDate);
			}catch(Exception exx) {}
			return date;
		}
		
		private static final SimpleDateFormat sdfDateTime = new SimpleDateFormat(prop.getString("date.time.formater"));
		public synchronized static String getFormatedDateTime(Date date) {
			return date!=null?sdfDateTime.format(date):"";
		}
		
		public synchronized static String getFormatedDateTime(Date date, String format) {
			return date!=null?new SimpleDateFormat(format).format(date):"";
		}
		
		public synchronized static String getDayMonth(Calendar calendar, int element){
			
			if(Formater.DAY==element){
				if (calendar.get(Calendar.DAY_OF_WEEK) == 1) return "Sunday";
				else if (calendar.get(Calendar.DAY_OF_WEEK) == 2) return "Monday";
				else if (calendar.get(Calendar.DAY_OF_WEEK) == 3) return "Tuesday";
				else if (calendar.get(Calendar.DAY_OF_WEEK) == 4) return "Wednesday";
				else if (calendar.get(Calendar.DAY_OF_WEEK) == 5) return "Thursday";
				else if (calendar.get(Calendar.DAY_OF_WEEK) == 6) return "Friday";
				else return "Saturday";
			}
			
			else if(Formater.MONTH==element){
				if (calendar.get(Calendar.MONTH) == 0) return "Jan";
				else if (calendar.get(Calendar.MONTH) == 1) return "Feb";
				else if (calendar.get(Calendar.MONTH) == 2) return "Mar";
				else if (calendar.get(Calendar.MONTH) == 3) return "April";
				else if (calendar.get(Calendar.MONTH) == 4) return "May";
				else if (calendar.get(Calendar.MONTH) == 5) return "Jun";
				else if (calendar.get(Calendar.MONTH) == 6) return "Jul";
				else if (calendar.get(Calendar.MONTH) == 7) return "Aug";
				else if (calendar.get(Calendar.MONTH) == 8) return "Sept";
				else if (calendar.get(Calendar.MONTH) == 9) return "Oct";
				else if (calendar.get(Calendar.MONTH) == 10) return "Nov";
				else return "Dec";
			}
			
			return null;
		}
		
		private static final SimpleDateFormat sdTime = new SimpleDateFormat(prop.getString("time.format"));
		private static final Calendar timecal = new GregorianCalendar();
		public synchronized static String getFormatedTime(Time time) {
			timecal.setTime(time);
			return time!=null? sdTime.format(timecal.getTime()):"";
		}
		public synchronized static String getFormatedTime(Time time, String format) {
			timecal.setTime(time);
			return time!=null? new SimpleDateFormat(format).format(timecal.getTime()):"";
		}

		private static final SimpleDateFormat sdTime2 = new SimpleDateFormat(prop.getString("time.format"));
		private static final Calendar datecal = new GregorianCalendar();
		public synchronized static String getFormatedTime(Date time) {
				datecal.setTime(time);
				return time!=null? sdTime2.format(datecal.getTime()):"";
		}
		
		public synchronized static String getFormatedDateTimeIndo(Date date) {
				String tanggal="";
				try {
					String monthS = "";
					Calendar cal = new GregorianCalendar();
					cal.setTime(date);
					int month = cal.get(Calendar.MONTH);
					int day = cal.get(Calendar.DAY_OF_MONTH);
					int year = cal.get(Calendar.YEAR);
					if(month==0){monthS = "Januari";}
					else if(month==1){monthS = "Februari";}
					else if(month==2){monthS = "Maret";}
					else if(month==3){monthS = "April";}
					else if(month==4){monthS = "Mei";}
					else if(month==5){monthS = "Juni";}
					else if(month==6){monthS = "Juli";}
					else if(month==7){monthS = "Agustus";}
					else if(month==8){monthS = "September";}
					else if(month==9){monthS = "Oktober";}
					else if(month==10){monthS = "November";}
					else if(month==11){monthS = "Desember";}
					tanggal = ""+day+" "+monthS+" "+year+"";
					
				}catch(Exception exx) {
				}
				return tanggal;
			}
		
		public synchronized static String getFormatedDateTimeIndoSingkat(Date date) {
			String tanggal="";
			try {
				String monthS = "";
				Calendar cal = new GregorianCalendar();
				cal.setTime(date);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);
				if(month==0){monthS = "Jan";}
				else if(month==1){monthS = "Feb";}
				else if(month==2){monthS = "Mar";}
				else if(month==3){monthS = "Apr";}
				else if(month==4){monthS = "Mei";}
				else if(month==5){monthS = "Juni";}
				else if(month==6){monthS = "Juli";}
				else if(month==7){monthS = "Agu";}
				else if(month==8){monthS = "Sept";}
				else if(month==9){monthS = "Okt";}
				else if(month==10){monthS = "Nov";}
				else if(month==11){monthS = "Des";}
				tanggal = ""+day+" "+monthS+" "+year+"";
				
			}catch(Exception exx) {
			}
			return tanggal;
		}
			
			public synchronized static String getFormatedRomawi(int angka) {
				String romawi="";
				try {
					if (angka==1){romawi = "I";}
					else if (angka==2){romawi = "II";}
					else if (angka==3){romawi = "III";}
					else if (angka==4){romawi = "IV";}
					else if (angka==5){romawi = "V";}
					else if (angka==6){romawi = "VI";}
					else if (angka==7){romawi = "VII";}
					else if (angka==8){romawi = "VIII";}
					else if (angka==9){romawi = "IX";}
					else if (angka==10){romawi = "X";}
					else if (angka==11){romawi = "XI";}
					else if (angka==12){romawi = "XII";}
				}catch(Exception exx) {
				}
				return romawi;
			}

		public synchronized static String formatedAddress(String address1, String address2, String rt, String rw, 
				String kelurahan, String kecamatan, String city, String postalCode, int blnBreak){
			
			String strRsl="";
			String vBr="";
			if(blnBreak == 1) vBr="<BR>";
			else vBr = ", ";
			
			strRsl = address1.trim();
			if( address2 == null || address2.trim().equals("")){}
			else strRsl = strRsl + vBr + address2.trim();
			
			if( ( rt == null || rt.trim().equals("") ) && ( rw == null || rw.trim().equals("") ) ){}
			else if( (rt == null || rt.trim().equals("")) && !rw.trim().equals("") )
				strRsl = strRsl + vBr + "RW: " + rw.trim();
			else if( (rw == null || rw.trim().equals("")) && !rt.trim().equals("") )
				strRsl = strRsl + vBr + "RT: " + rt.trim();
			else
				strRsl = strRsl + vBr + "RT: " + rt.trim() + "/RW: " + rw.trim();

			if( kelurahan == null || kelurahan.trim().equals("") ){}
			else strRsl = strRsl + vBr + "Kel: " + kelurahan.trim();
			
			if( kecamatan == null || kecamatan.trim().equals("")){}
			else strRsl = strRsl + vBr + "Kec: " + kecamatan.trim();
			
			strRsl = strRsl + vBr + city.toUpperCase();
			if( postalCode == null || postalCode.trim().equals("") || postalCode.length() < 5 ){}
			else strRsl = strRsl + " - " + postalCode;

			return strRsl;
		}
		
		public synchronized static String replaceHtmlCommand(String string) {
			for (int i=0; i<htmlCommand.length; i++) {
				string = string.replaceAll(htmlCommand[i], htmlCommandReplace[i]);
			}
			return string;
		}
		
		public synchronized static String getFormatedText(String text, int length) {
			if (text==null) text = "";
			text = replaceHtmlCommand(text);
			if(text.length() >= length){
				return text.substring(0,length);
			} else {
				String space = "";
				for(int i = 0; i < (length - text.length()) ;i++){
					space+=" ";
				}
				return text+space;
			}
			
		}
		
		public synchronized static String getFormatedText(String string1, String string2, int length) {
			if (string1==null) string1 = "";
			if (string2==null) string2 = "";
			string1 = replaceHtmlCommand(string1);
			string2 = replaceHtmlCommand(string2);
			String text = "";
			if (string1!=null && string1.length()>0) text = string1;
			else text = string2;
			if(text.length() >= length){
				return text.substring(0,length);
			} else{
				String space = "";
				for(int i = 0; i < (length - text.length()) ;i++){
					space+=" ";
				}
				return text+space;
			}
			
		}
		
		public synchronized static String getFormatedNumeric(double d, int length) {
			String string = getFormatedOutputForm(2, d);
			String space = "";
			for(int j = 0; j < (length - (string.length())) ;j++){
				space+=" ";
			}
			return space+string;
			
		}
		
		public synchronized static String getFormatedNumeric(double d, int length, int numberOfDigit) {
			String string = getFormatedOutputForm(numberOfDigit, d);
			String space = "";
			for(int j = 0; j < (length - (string.length())) ;j++){
				space+=" ";
			}
			return space+string;
		}
		
		public synchronized static String getFormatedNumeric(double d, int length, int numberOfDigit, String spacer) {
			String string = getFormatedOutputForm(numberOfDigit, d);
			String space = "";
			for(int j = 0; j < (length - (string.length())) ;j++){
				space+=spacer;
			}
			return space+string;
		}
		
		public synchronized static String getFormatedNumeric(int d, int length) {
			String space = "";
			String string = String.valueOf(d);
			for(int j = 0; j < (length - string.length()) ;j++){
				space+=" ";
			}
			return space+string;
		}
		
		public synchronized static String getFormatedNumeric(int d, int length, String spacer) {
			String space = "";
			String string = String.valueOf(d);
			for(int j = 0; j < (length - string.length()) ;j++){
				space+=spacer;
			}
			return space+string;
		}
		
		public synchronized static String getFormatedNumericLeft(double d, int length) {
			String string = getFormatedOutputForm(2, d);
			String space = "";
			for(int j = 0; j < (length - (string.length()-1)) ;j++){
				space+=" ";
			}
			return string+space;
			
		}
		
		public synchronized static String getFormatedNumericLeft(double d, int length, int numberOfDigit) {
			String string = getFormatedOutputForm(numberOfDigit, d);
			int x = 0;
			String space = "";
			for(int j = 0; j < (length - (string.length()-x)) ;j++){
				space+=" ";
			}
			return string+space;
		}
		
		public synchronized static String getFormatedNumericLeft(int d, int length) {
			String space = "";
			String string = String.valueOf(d);
			for(int j = 0; j < (length - string.length()) ;j++){
				space+=" ";
			}
			return string+space;
		}
		
		public static Date addMonthDb(Calendar cal, int interval){
			if(cal.get(Calendar.DAY_OF_MONTH) == cal.getActualMaximum(Calendar.DAY_OF_MONTH)){
				cal.add(Calendar.MONTH, interval);
				cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			}else{
				cal.add(Calendar.MONTH, interval);
			}
	        return cal.getTime();
		}
		
		public static Date getLastDayOfMonth(Date date){
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			return cal.getTime();
		}
		
		public static Date getLastDayOfMonthToday(){
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
			return cal.getTime();
		}
		
		
		public static Date getFirstDayOfMonth(Date date) {
			Calendar c = Calendar.getInstance(); 
			c.setTime(date); 
			c.add(Calendar.DATE, 1);
			date = c.getTime();
			return date;
		}
		
		public static Date getFirstDayOfMonth1(Date date) {
			Calendar c = Calendar.getInstance(); 
			c.setTime(date); 
			c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
			date = c.getTime();
			return date;
		}
		
		public static Date getFirstDateOfMonth(Date date) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
			return cal.getTime();
		}
		
		public synchronized static double round(int decimalPlace, double d){
		    BigDecimal bd = new BigDecimal(Double.toString(d));
		    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
		    return bd.doubleValue();
		  }
		
		public synchronized static double roundUp(int decimalPlace, double d){
		    BigDecimal bd = new BigDecimal(Double.toString(d));
		    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_UP);
		    return bd.doubleValue();
		  }
		
		public synchronized static double roundHalfDown(int decimalPlace, double d){
		    BigDecimal bd = new BigDecimal(Double.toString(d));
		    bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_DOWN);
		    return bd.doubleValue();
		  }
		
		public synchronized static String removeTandaBaca(String string) {
			for (int i=0; i<tandaBaca.length; i++) {
				string = string.replaceAll(tandaBaca[i], "");
			}
			return string;
			
		}
		
		public synchronized static String removeTandaBaca(String string, String string2) {
			string = string.replaceAll(string2, "");
			return string;
			
		}
		
		public synchronized static String getFormatedText(String text, String origin) {
			if (text==null) text = "";
			int lengthText = text.length();
			int lengthOrigin = origin.length();
			if (lengthOrigin - lengthText > 1) {
				for (int i=0; i < ((lengthOrigin-lengthText)/2); i++) {
					text = "."+text;
				}
			}
			if(text.length() >= lengthOrigin){
				return text.substring(0, lengthOrigin);
			} else {
				String space = "";
				for(int i = 0; i < (lengthOrigin - text.length()) ;i++){
					space+=".";
				}
				return text+space;
			}
			
		}
		
		public synchronized static String getFormatedSeparator(String text, int position, String separat){
			if(text.length() > position) return text.substring(0,position)+separat+text.substring(position);
			else return "";
		}
		
		public synchronized static int getNumberOfDigit(String amount) {
			int digit = 0;
			if(amount.indexOf(".")>0){
				amount = amount.substring(amount.indexOf(".")+1, amount.length());
				digit = amount.length();
			}
			return digit;
		}
		
		/**
		 * <p>Fungsi untuk memformat tampilan double dengan <b>numberOfDigit</b> dinamis sesuai dengan banyaknya angka di 
		 * belakang koma yang dikirimkan lewat parameter.</p>
		 *  
		 * <p><b>Contoh</b> : 200000.56 menjadi 200,000.56</p> 
		 * 
		 * @param amount String yang akan diformat
		 * 
		 * @author Brian
		 */
		public synchronized static String getFormatedOutputDynaDigit(String amount) {
			int digit = getNumberOfDigit(amount);
			double d = Double.parseDouble(amount);
			return getFormatedOutput(digit, d);
		}
		
}
 
