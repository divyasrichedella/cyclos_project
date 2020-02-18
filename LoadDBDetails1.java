package com.training.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.training.bean.DBBean1;

/**
 * 
 * @author Naveen
 * @see will load the db details and shall be used in connection class
 */
public class LoadDBDetails1 {
	public static DBBean1 getDBDetails() {

		try {
			Properties properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/db1.properties");
			properties.load(inStream);

			DBBean1 dbBean = new DBBean1(); 
			
			dbBean.setUrl(properties.getProperty("url"));
			dbBean.setDriver(properties.getProperty("driver"));
			// getting the user name if not present (by default - root ) 
			dbBean.setUserName(properties.getProperty("username", "root"));
			dbBean.setPassword(properties.getProperty("password"));
			
			return dbBean; 
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}


}
