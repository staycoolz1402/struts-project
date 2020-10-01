package com.mpe.common;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PivotGenerator {
	private StringBuilder sbCoalesce = new StringBuilder(60);
	private StringBuilder sbSumAs = new StringBuilder(60);
	private StringBuilder sbAlias = new StringBuilder(60);

	private String[] pivotColumn = null;
	private String[] pivotItem = null;
	private String[] nonPivotColumn = null;
	private String pivotBy = null;
	private String sqlQuery = null;
	private String sqlGroupBy = null;
	
	
	/*INITIALIZER METHOD*/
	public String[] getPivotColumn() {
		return pivotColumn;
	}

	public PivotGenerator setPivotColumn(String... pivotColumn) {
		this.pivotColumn = pivotColumn;
		return this;
	}

	public String[] getPivotItem() {
		return pivotItem;
	}

	public PivotGenerator setPivotItem(String... pivotItem) {
		this.pivotItem = pivotItem;
		return this;
	}

	public String[] getNonPivotColumn() {
		return nonPivotColumn;
	}

	public PivotGenerator setNonPivotColumn(String... nonPivotColumn) {
		this.nonPivotColumn = nonPivotColumn;
		return this;
	}

	public String getPivotBy() {
		return pivotBy;
	}

	public PivotGenerator setPivotBy(String pivotBy) {
		this.pivotBy = pivotBy;
		return this;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public PivotGenerator setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
		return this;
	}
	

	public String getSqlGroupBy() {
		return sqlGroupBy;
	}

	public PivotGenerator setSqlGroupBy(String sqlGroupBy) {
		this.sqlGroupBy = sqlGroupBy;
		return this;
	}

	/*public String generateSqlQuery(int start, int count){
		checkInitialization();
		StringBuilder sb = new StringBuilder(200);
		Map<String,List<String>> map = generateMapping(pivotColumn, pivotItem);
		sb.append("WITH myQuery AS (").append(sqlQuery).append(")");
		sb.append(",rawPivot AS(");
		sb.append("SELECT * FROM myQuery ");
		sb.append("PIVOT (").append(generatePivotForSum(pivotItem)).append(" ");
		sb.append("FOR(").append(pivotBy).append(")");
		sb.append(" IN(").append(generatePivotAlias(pivotColumn)).append(")").append(")");
		sb.append("), pivotCTE AS (");
		sb.append(generateSelect(map)).append(" FROM rawPivot" ).append(" GROUP BY ").append(sqlGroupBy);
		sb.append("), totalSum AS (");
		sb.append(generateSelectSum(map, "Total")).append(" FROM pivotCTE WHERE ROWNUM BETWEEN ");
		sb.append(start).append(" AND ").append(count);
		sb.append("), grandTotalSum AS(");
		sb.append(generateSelectSum(map, "Grand Total")).append(" FROM pivotCTE ");
		sb.append(") SELECT * from pivotCTE WHERE ROWNUM BETWEEN ");
		sb.append(start).append(" AND ").append(count).append(" ");
		sb.append(" UNION ALL SELECT * FROM totalSum ");
		sb.append(" UNION ALL SELECT * FROM grandTotalSum");
		return sb.toString();
	}*/

	public  String generateSqlQuery(){
		checkInitialization();
		StringBuilder sb = new StringBuilder(200);
		Map<String,List<String>> map = generateMapping(pivotColumn, pivotItem);
		sb.append("WITH myQuery AS (").append(sqlQuery).append(")");
		sb.append(",rawPivot AS(");
		sb.append("SELECT * FROM myQuery ");
		sb.append("PIVOT (").append(generatePivotForSum(pivotItem)).append(" ");
		sb.append("FOR(").append(pivotBy).append(")");
		sb.append(" IN(").append(generatePivotAlias(pivotColumn)).append(")").append(")");
		sb.append("), pivotCTE AS (");
		sb.append(generateSelect(map)).append(" FROM rawPivot" );
		sb.append("), grandTotalSum AS(");
		sb.append(generateSelectSum(map, "Grand Total")).append(" FROM pivotCTE ");
		sb.append(") SELECT * from pivotCTE ");
		sb.append(" UNION ALL SELECT * FROM grandTotalSum");
		return sb.toString();
	}

	private  Map<String,List<String>> generateMapping(String[] pivotColumn, String[] pivotItem){
		StringBuilder sb = new StringBuilder(100);
		Map<String,List<String>> mapping = new LinkedHashMap<String,List<String>>();
		for(String item : pivotItem){
			for(String column : pivotColumn){
				if(!mapping.containsKey(item)){
					final List<String> list = new ArrayList<String>();
					list.add(sb.append(column).append("_").append(item).toString());
					mapping.put(item, list);
				}
				else{
					mapping.get(item).add(sb.append(column).append("_").append(item).toString());
				}
				sb.setLength(0);
			}
		}
		return mapping;
	}
	
	/*PRIVATE HELPER METHOD*/
	private void checkInitialization(){
		if(pivotItem==null || pivotColumn==null || nonPivotColumn==null || pivotBy==null || sqlQuery==null || sqlGroupBy==null){
			throw new RuntimeException("Uninitialized variable : " + "\n pivotItem=" + pivotItem +
					"\n pivotColumn=" + pivotColumn + "\n nonPivotColumn=" + nonPivotColumn +
					"\n pivotBy=" + pivotBy + "\n sqlQuery=" + sqlQuery + "\n sqlGroupBy =" + sqlGroupBy);
		}
	}
	
	@SuppressWarnings("unchecked")
	private  String generateSelect(Map<String,List<String>> mapping){
		StringBuilder sb = new StringBuilder(150);
		Object[] entries = mapping.values().toArray();
		final int entrySize = ((List<String>)entries[0]).size();
		sb.append(" SELECT ");

		//select mandatory column dulu
		sb.append(nonPivotColumn[0]).append(",");
		for(int i=1; i < nonPivotColumn.length; i++){
			sb.append(sumAs(nonPivotColumn[i])).append(",");
		}

		//untuk generate grand total
		StringBuilder tmp = new StringBuilder(50);
		Set<Entry<String,List<String>>> entrySet = mapping.entrySet();
		for(Entry<String,List<String>> e : entrySet){
			tmp.append("SUM(");
			List<String> list = e.getValue();
			for(int i=0; i<list.size(); i++){
				tmp.append(coalesce(list.get(i)));
				if(i!=list.size()-1)tmp.append('+');

			}
			tmp.append(") AS ").append("grand_total_").append(e.getKey()).append(" ");
			tmp.append(',');
			sb.append(tmp);
			tmp.setLength(0);
		}

		//untuk generate kolom select
		int i = 0;
		for (int c = 0; c < entrySize; c++) {
			for(int e=0; e < entries.length; e++){
				String column = ((List<String>) entries[e]).get(i); 
				sb.append(sumAs(coalesce(column),column));
				if(c!=entrySize-1 || e!=entries.length-1) sb.append(",");
			}
			i++;
		}
		return sb.toString();
	}

	@SuppressWarnings("unchecked")
	private  String generateSelectSum(Map<String,List<String>> mapping, String firstColName){
		StringBuilder sb = new StringBuilder(150);
		Object[] entries = mapping.values().toArray();
		final int entrySize = ((List<String>)entries[0]).size();
		sb.append(" SELECT ").append("'").append(firstColName).append("' AS ");

		//select mandatory column dulu
		sb.append(nonPivotColumn[0]).append(",");
		for(int i=1;i<nonPivotColumn.length;i++){
			sb.append(sumAs(nonPivotColumn[i])).append(",");
		}

		//untuk generate grand total
		for(String item : pivotItem){
			sb.append(sumAs("grand_total_" + item)).append(",");
		}

		int i=0;
		//untuk generate kolom select
		for (int c = 0; c < entrySize; c++) {
			for(int e=0; e < entries.length; e++){
				String column = ((List<String>) entries[e]).get(i); 
				sb.append(sumAs(column));
				if(c!=entrySize-1 || e!=entries.length-1) sb.append(",");
			}
			i++;
		}
		return sb.toString();
	}

	private  String generatePivotAlias (String[] columns){
		StringBuilder sb = new StringBuilder(100);
		for(int i=0;i<columns.length;i++){
			sb.append(alias(columns[i]));
			if(i!=columns.length-1)	sb.append(",");
		}
		return sb.toString();
	}

	private  String generatePivotForSum (String[] columns){
		StringBuilder sb = new StringBuilder(100);
		for(int i=0;i<columns.length;i++){
			sb.append(sumAs(columns[i]));
			if(i!=columns.length-1)	sb.append(",");
		}
		return sb.toString();
	}

	private  String coalesce(String column){
		String str = sbCoalesce.append("COALESCE(")
				.append(column)
				.append(",0)")
				.append(" ")
				.toString();
		sbCoalesce.setLength(0);
		return str;
	}

	private  String sumAs(String column){
		String str = sbSumAs.append("SUM(")
				.append(column)
				.append(")")
				.append(" AS ")
				.append(column)
				.append(" ")
				.toString();
		sbSumAs.setLength(0);
		return str;
	}

	private  String sumAs(String column, String alias){
		String str = sbSumAs.append("SUM(")
				.append(column)
				.append(")")
				.append(" AS ")
				.append(alias)
				.append(" ")
				.toString();
		sbSumAs.setLength(0);
		return str;
	}

	private  String alias(String column){
		String str = sbAlias.append("'")
				.append(column)
				.append("'")
				.append(" AS ")
				.append(column)
				.append(" ")
				.toString();
		sbAlias.setLength(0);
		return str;
	}

}
