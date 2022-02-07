package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	Properties pro;
	
	public ConfigReader() {
		File con= new File("./Configurations/config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(con);
			pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String getURL() {
		String URL=pro.getProperty("baseURL");
		return URL;
	}
	public String getUname() {
		String Uname=pro.getProperty("username");
		return Uname;
	}
	public String getPass() {
		String pass=pro.getProperty("password");
		return pass;
	}
	
	
}
