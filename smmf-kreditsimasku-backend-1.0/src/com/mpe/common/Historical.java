package com.mpe.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

import com.ams.mufins.model.dao.OrganizationDAO;

public class Historical {
	
	public static boolean cekHistory(String terminateDate, String namaTabel){
		boolean history = false;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date terminateDate2 = sdf.parse(terminateDate);
			history = cekHistory(terminateDate2, namaTabel);
			return history;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return history;
	}
	
	public static boolean cekHistory(Date terminateDate, String namaTabel){
		boolean history = false;
		try {
			String queryCut = ""+
					 " select cut_off_historical_db_id as id, nama_tabel, tanggal_cut_off "+
					 " from cut_off_historical_db " +
					 " where upper(nama_tabel) = upper(:namaTabel) and :terminateDate <= tanggal_cut_off ";
			
			SQLQuery sqlQueryCut =  (SQLQuery) OrganizationDAO.getInstance().getSession().createSQLQuery(queryCut)
							.addScalar("id", Hibernate.LONG)
							.addScalar("nama_tabel", Hibernate.STRING)
							.addScalar("tanggal_cut_off", Hibernate.DATE)
							.setString("namaTabel", namaTabel)
							.setDate("terminateDate", terminateDate);
			 if(sqlQueryCut!=null && sqlQueryCut.list().size() > 0){
				 history = true;
			 }
			 return history;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return history;
	}
	
	public static boolean cekHistoryNew(Date terminateDate, String namaTabel) throws Exception{
		boolean history = false;
		try {
			String queryCut = ""+
					 " select cut_off_historical_db_id as id, nama_tabel, tanggal_cut_off "+
					 " from cut_off_historical_db " +
					 " where upper(nama_tabel) = upper(:namaTabel) and :terminateDate <= tanggal_cut_off ";
			
			SQLQuery sqlQueryCut =  (SQLQuery) OrganizationDAO.getInstance().getSession().createSQLQuery(queryCut)
							.addScalar("id", Hibernate.LONG)
							.addScalar("nama_tabel", Hibernate.STRING)
							.addScalar("tanggal_cut_off", Hibernate.DATE)
							.setString("namaTabel", namaTabel)
							.setDate("terminateDate", terminateDate);
			 if(sqlQueryCut!=null && sqlQueryCut.list().size() > 0){
				 history = true;
			 }
		} catch (Exception e) {
			throw e;
		}
		return history;
	}
	
	public static void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement){
		try {
			
			if (preparedStatement!=null) preparedStatement.close();
			if (resultSet!=null) resultSet.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
