package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.LoginBean1;
import com.training.connection.GetConnection1;
import com.training.utility.LoadDBDetails1;

// Data Access Object 
public class ELearningDAO1 {
	
	Properties properties; 
	
	public ELearningDAO1() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql1.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<LoginBean1> getLogins(){
		String sql = properties.getProperty("get.logins"); 
		
		GetConnection1 gc  = new GetConnection1(); 
		List<LoginBean1> list = null;
		try {
			gc.ps1 = GetConnection1.getMySqlConnection(LoadDBDetails1.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<LoginBean1>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				LoginBean1 temp = new LoginBean1(); 
				
				temp.setMember_Login(gc.rs1.getString(1));
				temp.setTitle_textbox(gc.rs1.getString(2));
				temp.setPrice(gc.rs1.getString(3));
				temp.setDescription(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new ELearningDAO1().getLogins().forEach(System.out :: println);
	}
	
	
}
