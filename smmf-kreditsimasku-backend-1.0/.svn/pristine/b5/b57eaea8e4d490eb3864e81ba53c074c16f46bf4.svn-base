package com.mpe.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class Versioning {
	private static final String namaProperties = "versioning.properties";
	private static final String pathSrc = "/src/"+namaProperties;
	private static final String pathWar = "/web/WEB-INF/classes/"+namaProperties; 
	private static boolean isRun = false;
	private static String defaultVersion = "0.0.0";
	
	private static String version="";
	private static String prodVersion="";
	private static String preliveVersion="";
	private static String compileDate="";
	
	/**
	 * @return versi build mufins, sambil update jika ada perubahan
	 */
	public static String getVersion(){
		if(isRun==false){
			URL url = Versioning.class.getResource("/versioning.properties");
			String completePath = url.getFile().toString();
			completePath = completePath.replace(pathWar, pathSrc);
			PropertiesConfiguration prop = null;
	
			try {
				prop = new PropertiesConfiguration(completePath);
			} catch (ConfigurationException e1) {
			}
			
			if(prop!=null){
				version = prop.getString("mufins.version")!=null?prop.getString("mufins.version"):"";
				prodVersion = prop.getString("mufins.prod.version")!=null?prop.getString("mufins.prod.version"):"";
				preliveVersion = prop.getString("mufins.prelive.version")!=null?prop.getString("mufins.prelive.version"):"";
				compileDate = prop.getString("mufins.compile.date")!=null?prop.getString("mufins.compile.date"):"";
			
				int prelive = 0;
				prelive = Integer.parseInt(prop.getString("mufins.prelive.version"));
		
				if(!compileDate.equals(lastCompiled())){//jika tanggal compile tidak sama dengan last compiled
					prelive++;
					compileDate = lastCompiled();
					preliveVersion = String.valueOf(prelive);
					try {
						save(compileDate,preliveVersion);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			defaultVersion = "Version: " + version+"."+prodVersion+"."+preliveVersion;
			isRun = true;
		}
		
		return defaultVersion;
	}
	
	
	private static void save(String date, String version) throws Exception{//tembak nya ke properties yg ada di SRC
		URL url = Versioning.class.getResource("/versioning.properties");
		String completePath = url.getFile().toString();
		completePath = completePath.replace(pathWar, pathSrc);
		String srcPath = completePath.replace("/web/WEB-INF/classes/","/src/").replace("/build/classes", "/src/");
		File propertiesFile = new File(completePath);
		File propSrc = new File(srcPath);
		
		FileInputStream in = new FileInputStream(propertiesFile);
		Properties props = new Properties();
		props.load(in);
		in.close();
		
		FileOutputStream out = new FileOutputStream(propertiesFile);
		props.setProperty("mufins.prelive.version", version);
		props.setProperty("mufins.compile.date", date);
		props.store(out, null);
		out.close();
		
		FileOutputStream out2 = new FileOutputStream(propSrc);
		props.setProperty("mufins.prelive.version", version);
		props.setProperty("mufins.compile.date", date);
		props.store(out2, null);
		out2.close();
	}
	
	private static String lastCompiled(){
		URL url = Versioning.class.getResource("Versioning.class");
		String modified = "BLANK";
		try {
			long lastMod = url.openConnection().getLastModified();
			if(lastMod!=0) 
				modified = (Formater.getFormatedDate(new Date(lastMod), "dd-MMM-yyyy ss"));
			else 
				modified = ("last modified zero");
			return modified;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return modified;
	}

}
