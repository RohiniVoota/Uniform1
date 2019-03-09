package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.Login;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class ELearningDAO {
	
	Properties properties; 
	
	public ELearningDAO() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Login> getRegister(){
		String sql = properties.getProperty("get.register"); 
		
		GetConnection gc  = new GetConnection(); 
		List<Login> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<Login>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				Login temp = new Login(); 
				temp.setfirstname(gc.rs1.getString(1));
				temp.setlastname(gc.rs1.getString(2));
				temp.setemail(gc.rs1.getString(3));
				temp.setTelephone(gc.rs1.getString(4));
				temp.setaddress1(gc.rs1.getString(5));
				temp.setaddress2(gc.rs1.getString(6));
				temp.setcity(gc.rs1.getString(7));
				temp.setpostcode(gc.rs1.getString(8));
				temp.setpassword(gc.rs1.getString(9));
				temp.setconfirm(gc.rs1.getString(10));
				
				

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
	new ELearningDAO().getRegister().forEach(System.out :: println);
	}
	
	
}
