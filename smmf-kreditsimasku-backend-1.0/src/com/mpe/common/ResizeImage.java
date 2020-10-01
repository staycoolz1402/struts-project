package com.mpe.common;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class ResizeImage {
	
	public static BufferedImage resizeImage(byte[] file, int width, int height) throws Exception{
		BufferedImage result = null;
		BufferedImage bufferedImage = null;
		int realHeight = 0, realWidth=0, croph = 0, cropw = 0;
		try {
			double x = height * 3.8;
			double y = width * 3.8;
			
			double x2 = x / 2 ;
			double y2 = y /2 ;
			 
			height = (int)(x);
			width = (int)(y); 

			croph =  (int)(x2);
			cropw =  (int)(y2);
			
			
			InputStream is  = new ByteArrayInputStream(file);
			BufferedImage image = ImageIO.read(is);
			BufferedImage resizeImage = null;
			
			realHeight = image.getHeight();
		    realWidth = image.getWidth();
		    
		   //default image size 307200 setara 640*480
		   int fitSize = realHeight * realWidth;
		   if(fitSize > 307200){
			   double a = realHeight / height;
			    double b = realWidth / width;
			    
			    // resize if greater than 1
			    if (a > 1 || b > 1) {
			    	resizeImage = resize(image, width, height);
			    }
			    result = resizeImage;
		   }else{
			   result = image;
		   }
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return result;
	}
	
	public static BufferedImage resizeImage(byte[] file) throws Exception{
		BufferedImage result = null;
		int realHeight = 0, realWidth=0;
		try {
			
			InputStream is  = new ByteArrayInputStream(file);
			BufferedImage image = ImageIO.read(is);
			BufferedImage resizeImage = null;
			
			realHeight = image.getHeight();
			realWidth = image.getWidth();
			
			int fitSize = realHeight * realWidth;
			
			//default image size 480000 setara 800*600 atau 600*800
			Double tempWidth = 0.0;
			Double tempHeight = 0.0;
			Double resizeWidth = 0.0;
			Double resizeHeight = 0.0;
			boolean isLandscape = false;
			boolean isCount = true;
			if(fitSize > 480000){
				if(realWidth > realHeight) isLandscape = true;
				if(isLandscape) {
					tempWidth = realWidth - 800.0;
					resizeWidth = realWidth * (1 - (tempWidth/realWidth));
					tempHeight = realHeight - 600.0;
					resizeHeight = realHeight * (1 - (tempHeight/realHeight));
				} else {
					tempHeight = realHeight - 800.0;
					double param1 = 1 - (tempHeight/realHeight);
					resizeHeight = realHeight * (param1);
					tempWidth = realWidth - 600.0;
					Double param2 = 1 - (tempWidth/realWidth);
					resizeWidth = realWidth * (param2);
				}
				resizeImage = resize(image, resizeWidth.intValue(), resizeHeight.intValue());	
				result = resizeImage;
			}else{
				result = image;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		 return result;
	}
	
	private static BufferedImage resize(BufferedImage image, int width, int height) {
		  int type = image.getType() == 0? BufferedImage.TYPE_INT_ARGB : image.getType();
		  BufferedImage resizedImage = new BufferedImage(width, height, type);
		  Graphics2D g = resizedImage.createGraphics();
		  g.setComposite(AlphaComposite.Src);
		  g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		  g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		  g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		  g.drawImage(image, 0, 0, width, height, null);
		  g.dispose();
		  return resizedImage;
	  } 
}
