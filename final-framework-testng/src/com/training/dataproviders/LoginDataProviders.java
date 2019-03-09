package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.Login;
import com.training.dao.ELearningDAO;
import com.training.readexcel.ApachePOIExcelRead1;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {

		List<Login> list = new ELearningDAO().getRegister(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(Login temp : list){
			Object[]  obj = new Object[10]; 
			obj[0] = temp.getfirstname(); 
			obj[1] = temp.getlastname(); 
			obj[2] = temp.getemail();
			obj[3] = temp.getTelephone();
			obj[4] = temp.getaddress1();
			obj[5] = temp.getaddress2();
			obj[6] = temp.getcity();
			obj[7] = temp.getpostcode();
			obj[8]=  temp.getpassword();
			obj[9]=  temp.getconfirm();
 			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:\\IBM Selenium drivers\\ExcelData.xlsx"; 
		String SheetName="Sheet1";
		return new ApachePOIExcelRead1().getExcelContent(fileName,SheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:\\IBM Selenium drivers\\ExcelData.xlsx"; 
		String SheetName="Sheet2";
		return new ApachePOIExcelRead1().getExcelContent(fileName,SheetName);
	
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:\\IBM Selenium drivers\\ExcelData.xlsx"; 
		String SheetName="Sheet3";
		return new ApachePOIExcelRead1().getExcelContent(fileName,SheetName);
	
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:\\IBM Selenium drivers\\ExcelData.xlsx", "Sheet1"); 
	}
}
