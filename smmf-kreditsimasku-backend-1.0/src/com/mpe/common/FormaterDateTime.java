package com.mpe.common;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormaterDateTime {
	
	public static final String COUNTRY_IND = "IND";
	public static final String COUNTRY_ENG = "ENG";
	
	public static final String FORMAT_DAY = "DAY";
	public static final String FORMAT_DAY_OF_WEEK = "DAY_OF_WEEK";
	public static final String FORMAT_MONTH = "MONTH";
	public static final String FORMAT_YEAR = "YEAR";
	public static final String FORMAT_ALL = "ALL";

	public static String getFormatedDateTimeCountry(Date date, String country, String format) {
		
		String tanggal = "";
		
		try {
			
			String dayOfWeekS = "";
			String monthS = "";
			
			Calendar cal = new GregorianCalendar();
			cal.setTime(date);
			
			int month = cal.get(Calendar.MONTH);
			int day = cal.get(Calendar.DAY_OF_MONTH);
			int year = cal.get(Calendar.YEAR);
			
			if (country.equalsIgnoreCase(COUNTRY_IND)) {
				
				switch (cal.get(Calendar.DAY_OF_WEEK)) {
					case 1: dayOfWeekS = "Minggu"; break;
					case 2: dayOfWeekS = "Senin"; break;
					case 3: dayOfWeekS = "Selasa"; break;
					case 4: dayOfWeekS = "Rabu"; break;
					case 5: dayOfWeekS = "Kamis"; break;
					case 6: dayOfWeekS = "Jumat"; break;
					case 7: dayOfWeekS = "Sabtu"; break;
				}
				
				switch (month) {
					case 0: monthS = "Januari"; break;
					case 1: monthS = "Februari"; break;
					case 2: monthS = "Maret"; break;
					case 3: monthS = "April"; break;
					case 4: monthS = "Mei"; break;
					case 5: monthS = "Juni"; break;
					case 6: monthS = "Juli"; break;
					case 7: monthS = "Agustus"; break;
					case 8: monthS = "September"; break;
					case 9: monthS = "Oktober"; break;
					case 10: monthS = "November"; break;
					case 11: monthS = "Desember"; break;
				}
				
			} else if (country.equalsIgnoreCase(COUNTRY_ENG)) {
				//monthS = cal.getDisplayName(field, style, locale)
			}
			
			if (format.equalsIgnoreCase(FORMAT_ALL)) {
				tanggal = ""+day+" "+monthS+" "+year+"";
			} else if (format.equalsIgnoreCase(FORMAT_DAY)) {
				
			} else if (format.equalsIgnoreCase(FORMAT_DAY_OF_WEEK)) {
				tanggal = dayOfWeekS;
			} else if (format.equalsIgnoreCase(FORMAT_MONTH)) {
				tanggal = monthS;
			}
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return tanggal;
		
	}
	
}
