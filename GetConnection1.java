package com.training.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.training.bean.DBBean1;

public class GetConnection1 {
	static Connection connection; 
	public PreparedStatement ps1, ps2; 
	public ResultSet rs1, rs2; 
	
	public static Connection getMySqlConnection(DBBean1 dbBean) {
		
		try {
			// load 
			Class.forName(dbBean.getDriver());
			connection = DriverManager.getConnection(dbBean.getUrl() , 
					dbBean.getUserName(), dbBean.getPassword());
			
			return connection; 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
	public static Connection getOracleConnection(DBBean1 dbBean) {
		return null;
	}
}
