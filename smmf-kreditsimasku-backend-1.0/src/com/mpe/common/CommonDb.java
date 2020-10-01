package com.mpe.common;

public class CommonDb{
	
	public static String generalLimitRownum(int size, boolean isWhere, boolean isPostgre){
		String limitRownum = "";
		if(isPostgre) limitRownum = "limit "+size+" ";
		else {
			if(isWhere==true) limitRownum = "where rownum <="+size+" ";
			else limitRownum = "rownum <="+size+" "; 
		}
		return limitRownum;
	}
	
	
	public static String getOrderToLimit(String sqlLimitRownum, String sqlOrder, boolean isPostgre, int sizeRownum){
		String sqlNew = "";
		
		if(isPostgre) {
			sqlNew = sqlOrder + " limit " + sizeRownum + " ";
		}
		else{
			if(sqlLimitRownum.toLowerCase().contains("where")) {
				sqlNew = " where rownum <="+sizeRownum+ " " + sqlOrder;
			}
			if(sqlLimitRownum.toLowerCase().contains("and")){
				sqlNew = " and rownum <="+sizeRownum+ " " + sqlOrder;
			}
		}
		return sqlNew;
	}
	
	public static String generalNextval(String sequence, boolean isPostgre){
		String generalNextval="";
		if(isPostgre) generalNextval=" nextval('"+sequence+"') ";
		else generalNextval = sequence+".nextval ";
		return generalNextval;
	}
	
	public static String generalTimestamp(boolean isPostgre){
		String generalTimestamp ="";
		if(isPostgre) generalTimestamp = "current_timestamp";
		else generalTimestamp = "systimestamp";
		return generalTimestamp;
	}
	
	public static String generalDate(boolean isPostgre){
		String generalDate = "";
		if(isPostgre) generalDate = "current_date";
		else generalDate = "sysdate";
		return generalDate;
	}
	
	
	public static String generalCastToDecimal(String param, boolean isPostgre){
		if(isPostgre) param = " cast ( " + param + " as decimal ) ";
		return param;
	}
	
	public static String generalExtract(String sql, String tipe, boolean isPostgre){
		String newSql = "";
		if(isPostgre) newSql = "extract( " + tipe + " from " + sql + " ) ";
		else newSql = sql;
		return newSql;
	}
	
	public static boolean isPostgre(){
		if(CommonDynamics.GET_DIALECT.contains("PostgreSQLDialect")) return true;
		else return false;
	}

}
