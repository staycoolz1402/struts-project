package com.mpe.common;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfPTableEvent;

public class PdfEvent implements PdfPTableEvent {

	private float height;
	Log log = LogFactory.getFactory().getInstance(this.getClass());
	
	@Override
	public void tableLayout(PdfPTable table, float[][] width, float[] heights,
			int headerRows, int rowStart, PdfContentByte[] canvases) {
		this.height = heights[1];
	}

	public float getHeight() {
		return height;
	}

}
