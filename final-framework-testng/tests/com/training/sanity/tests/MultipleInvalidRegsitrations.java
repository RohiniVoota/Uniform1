package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.MultipleInvalidRegsitrationsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MultipleInvalidRegsitrations {
	private WebDriver driver;
	private String baseUrl;
	private MultipleInvalidRegsitrationsPOM TC063;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		TC063 = new MultipleInvalidRegsitrationsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		//close the bowser
		driver.quit();
	}

	//To verify whether application denies the user to get registered on the application by entering invalid credentials
	@Test(dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String firstname, String lastname, String email, String telephone,String address1,String address2,String city,String postcode,String Country,String Region,String password,String confirm) throws InterruptedException {
	    //Registration with invalid credentials
		TC063.MyAccount();
		TC063.register();
		TC063.Firstname(firstname);
		TC063.Lastname(lastname);
		TC063.Email(email);
		TC063.Telephone(telephone);
		TC063.Address1(address1);
		TC063.Address2(address2);
		Thread.sleep(2000);
		TC063.City(city);
		TC063.Postcode(postcode);
		
		//select the values from dropdown
		Select dropdown= new Select(driver.findElement(By.id("input-country")));
		dropdown.selectByVisibleText(Country);
		
		Select dropdown1= new Select(driver.findElement(By.id("input-zone")));
		dropdown1.selectByVisibleText(Region);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		TC063.Password(password);
		TC063.Confirm(confirm);
		
		TC063.radio();
		TC063.checkbox();
		TC063.ContinueBtn();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//Assertion
		TC063.Assertion();
		screenShot.captureScreenShot("TC063");
	}

}