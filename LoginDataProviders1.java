package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.LoginBean1;
import com.training.dao.ELearningDAO1;
import com.training.readexcel.ApachePOIExcelRead1;
import com.training.readexcel.ReadExcel1;

public class LoginDataProviders1 {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<LoginBean1> list = new ELearningDAO1().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean1 temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getMember_Login(); 
			obj[1] = temp.getTitle_textbox(); 
			obj[2] = temp.getPrice(); 
			obj[3] = temp.getDescription(); 
			
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new ApachePOIExcelRead1().getExcelContent(fileName); 
	}
	
	@DataProvider(name="Cyclos")
	public Object[][] getExcelData1()
	{
		String FileName="E:\\seleniumtrainee\\test data\\Testttt.xlsx";
		return new ApachePOIExcelRead1().getExcelContent(FileName);
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel1().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
