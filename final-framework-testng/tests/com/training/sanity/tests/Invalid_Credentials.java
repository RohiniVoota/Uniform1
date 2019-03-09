package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.Invalid_credentialsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Invalid_Credentials {

	private WebDriver driver;
	private String baseUrl;
	private Invalid_credentialsPOM tc0031pom;
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
		tc0031pom= new Invalid_credentialsPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open  browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//close the browser
		driver.quit();
	}
	
	//To verify whether application denies user getting logged in upon entering invalid credentials in required field
	@Test
	public void validLogin() {
		
		//login with invalid credentials
		tc0031pom.MyAccount();
		tc0031pom.Login();
		tc0031pom.email("welcome");
		tc0031pom.password("Rohi123");
		tc0031pom.LoginBtn();
		
		//compare the actual title of the page with the expected one
		
		tc0031pom.Assertion();
		
		//take the screenshot
		
		screenShot.captureScreenShot("Sixth");
	}
}
