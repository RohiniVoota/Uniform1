package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.ForgotPasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ForgotPassword {

	private WebDriver driver;
	private String baseUrl;
	private ForgotPasswordPOM forgotpasswordpom;
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
		forgotpasswordpom = new ForgotPasswordPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//close the browser
		driver.quit();
	}
	//To verify whether application allows the user to recover password
	@Test
	public void login() throws InterruptedException {
		
		forgotpasswordpom.MyAccount();
		forgotpasswordpom.Login();
		forgotpasswordpom.email("welcome@gmail.com");
		forgotpasswordpom.password("Rohini23");
		//click login
		forgotpasswordpom.LoginBtn();
		//click on forgot password
		forgotpasswordpom.FrgtPswd();
		forgotpasswordpom.inputemail("welcome@gmail.com");
		forgotpasswordpom.ContinueBtn();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		forgotpasswordpom.Assertion();
		screenShot.captureScreenShot("third");
	}
	

		
	    
		
		
	}
