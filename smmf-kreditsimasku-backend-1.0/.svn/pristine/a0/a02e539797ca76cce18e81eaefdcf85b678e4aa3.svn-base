package com.mpe.common;

import javax.servlet.http.HttpServletRequest;

public class BrowserUtil {
	
	public static String getBrowser(HttpServletRequest request) {
		
		String browser = "";
		
		String browserType = request.getHeader("User-Agent");
		if(browserType.contains("Android")){
			browser = "Android";
		}else if(browserType.contains("iPhone")){
			browser = "iPhone";
		}else if(browserType.contains("iPad")){
			browser = "iPad";
		}else if(browserType.contains("BlackBerry")){
			browser = "BlackBerry";
		}else if(browserType.contains("Chrome")){
			browser = "Chrome";
		}else if(browserType.contains("Firefox")){
			browser = "Firefox";
		}else if(browserType.contains("Opera")){
			browser = "Opera";
		}else if(browserType.contains("msie")){
			browser = "IE";
		}else if(browserType.contains("rv")){
			browser = "IE";
		}else{
			browser = "Lain-lain";
		}
		
		return browser;
		
	}

}
