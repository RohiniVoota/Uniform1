package com.training.sanity.tests;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.SaveProductAndLogoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SaveProductAndLogout {

	private WebDriver driver;
	private String baseUrl;
	private SaveProductAndLogoutPOM TC065;
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
        TC065 = new SaveProductAndLogoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	//Add the Products,discount,rewards values and remaining tab values as default and save the product
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		
		//login as admin     
		TC065.sendUserName("admin");
		TC065.sendPassword("admin@123");
		TC065.clickLoginBtn(); 
		
		//select the product and save it   
		TC065.menu();
		TC065.catalog();
		TC065.products();
		TC065.add();
		TC065.prdct_name("Blazer Girls(7-8)");
		TC065.meta("Blazer for girls");
		TC065.data();
		TC065.model("BLG-112");
		TC065.price("3000");
		TC065.quantity("100");
		TC065.links();
		TC065.setCategory("Blazers(4-5)");
		
		//add discount
		TC065.discount();
		TC065.add_discount();
		TC065.disc_qnty("5");
		TC065.disc_price("200");
		TC065.start_date("2019-02-26");
		TC065.end_date("2019-02-29");
		
		//give rewards
		TC065.reward();
		TC065.points("20");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//set default values for the below values 
		TC065.Attribute();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		TC065.option();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC065.Recurring();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC065.special();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC065.image();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC065.design();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		TC065.save();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//logout
		
		TC065.logout();
		TC065.Assertion();
		
		
		screenShot.captureScreenShot("TC065");
	}
}
