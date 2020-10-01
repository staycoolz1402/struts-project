package com.ams.mufins.model.report.dao;

import jxl.biff.DisplayFormat;
import jxl.format.Alignment;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;
import jxl.write.DateFormat;
import jxl.write.NumberFormats;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;

public class ExcelFormat {
	
	public static final CellFormat cellFormatDate = new WritableCellFormat(new DateFormat("dd MMM yyyy"));
	public static final CellFormat cellFormatAcc = new WritableCellFormat(new NumberFormats().THOUSANDS_FLOAT);
	
	private static WritableCellFormat cellFormatTopBotReport(Colour font, Colour background, Colour border, DisplayFormat format, Alignment alignment) {
		
		WritableCellFormat wcf = null;
		
		try{
			
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
			wf.setColour(font);
			
			wcf = new WritableCellFormat(wf, format);
			
			wcf.setAlignment(alignment);
			wcf.setBackground(background);
			wcf.setBorder(Border.ALL, BorderLineStyle.THIN, border);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wcf;
	}
	
	private static WritableCellFormat cellFormatContentReport(DisplayFormat format) {
		
		WritableCellFormat wcf = null;
		
		try{
			
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10);
			
			wcf = new WritableCellFormat(wf, format);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wcf;
	}
	
	public static WritableCellFormat cellFormatHeader(){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.WHITE, Colour.GRAY_80, Colour.WHITE, NumberFormats.THOUSANDS_FLOAT, Alignment.CENTRE);
		
		return wcf;
		
	}
	
	public static WritableCellFormat cellFormatTotal(DisplayFormat format){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.BLACK, Colour.GRAY_25, Colour.BLACK, format, Alignment.RIGHT);
		
		return wcf;
		
	}
	
	public static WritableCellFormat cellFormatGrandTotal(DisplayFormat format){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.BLACK, Colour.ROSE, Colour.BLACK, format, Alignment.RIGHT);
		
		return wcf;
		
	}
	
	public static WritableCellFormat cellFormatContent(Colour background, DisplayFormat format){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.BLACK, background, Colour.BLACK, format, Alignment.JUSTIFY);
		
		return wcf;
		
	}
	
	public static WritableCellFormat cellFormatContent(Colour background, DisplayFormat format, Alignment alignment){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.BLACK, background, Colour.BLACK, format, alignment);
		
		return wcf;
		
	}
	
	public static WritableCellFormat cellFormatContent(DisplayFormat format){
		
		WritableCellFormat wcf = cellFormatContentReport(format);
		
		return wcf;
		
	}
	
	private static WritableCellFormat cellFormatTopBotReport(Colour font, Colour background, Colour border, DisplayFormat format, VerticalAlignment verticalAlignment) {
		
		WritableCellFormat wcf = null;
		
		try{
			
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 10);
			wf.setColour(font);
			
			wcf = new WritableCellFormat(wf, format);
			
			wcf.setVerticalAlignment(verticalAlignment);
			wcf.setBackground(background);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return wcf;
	}
	
	public static WritableCellFormat cellFormatContentVerticalAlignment(){
		
		WritableCellFormat wcf = cellFormatTopBotReport(Colour.BLACK, Colour.WHITE, Colour.WHITE, NumberFormats.THOUSANDS_FLOAT, VerticalAlignment.CENTRE);
		
		return wcf;
		
	}
}
