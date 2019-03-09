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
import com.training.pom.OrdersPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Orders {

	private WebDriver driver;
	private String baseUrl;
	private OrdersPOM orderspom;
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
		orderspom = new OrdersPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//close th browser
		driver.quit();
	}
	
	//To Verify whether application displays order details upon Clicking My Orders link
	@Test
	public void login() throws InterruptedException {
		
		orderspom.MyAccount();
		orderspom.Login();
		orderspom.email("welcome@gmail.com");
		orderspom.password("Rohini123");
		//click on login button
		orderspom.LoginBtn();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		orderspom.orders();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		orderspom.view();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//assertion
		orderspom.Assertion();
		screenShot.captureScreenShot("Fourth");
		
	}
}