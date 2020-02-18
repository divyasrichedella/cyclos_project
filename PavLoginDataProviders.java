package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.PavLoginBean;
import com.training.dao.PavELearningDAO;
import com.training.readexcel.PavApachePOIExcelRead;
import com.training.readexcel.PavReadExcel;

public class PavLoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<PavLoginBean> list = new PavELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(PavLoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[1] = temp.getMember_Login(); 

			obj[1] = temp.getAmount(); 

			obj[1] = temp.getTransaction_Type(); 

			obj[1] = temp.getDescription(); 

			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/Users/Naveen/Desktop/Testing.xlsx"; 
		return new PavApachePOIExcelRead().getExcelContent(fileName); 
	}
	
	@DataProvider(name="cyclos")
	public Object[][]getExcelContent(){
		String filename="E:\\New folder\\Cycloscomplex.xlsx";
		return new PavApachePOIExcelRead().getExcelContent(filename);
	}
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new PavReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
