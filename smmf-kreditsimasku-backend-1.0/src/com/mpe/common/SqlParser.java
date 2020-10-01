package com.mpe.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SqlParser {
	
	static Log log = LogFactory.getFactory().getInstance("SqlParser");
	
	static String mssql[] = {"ISNULL", "TOP"};
	static String ora[] = {"NVL", "ROWNUM"};
	static String mysql[] = {"IFNULL", "LIMIT"};
	
	public static String parse(String sql, String db) {
		String string = null;
		try {
			
			if (db!=null && db.equalsIgnoreCase("ora")) {
				string = sql;
				int i = mssql.length;
				for (int j=0; j<i; j++) {
					if (!mssql[j].equalsIgnoreCase("TOP")) string = string.replace(mssql[j], ora[j]);
					else {
						int k = string.indexOf("TOP");
						k = k + 4;
						boolean space = true;
						String num = "";
						while (space) {
							if (String.valueOf(string.charAt(k)).equalsIgnoreCase(" ")) space=false;
							num = num + String.valueOf(string.charAt(k));
							k++;
						}
					}
				}
			} else string = sql;
		} catch(Exception exception) {
			exception.printStackTrace();
		}
		return string;
	}
	

}
