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
import com.training.pom.SaveProductPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class SaveProduct {

	private WebDriver driver;
	private String baseUrl;
	private SaveProductPOM tc0035_pom;
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
        tc0035_pom = new SaveProductPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get("http://uniform.upskills.in/admin/");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//close browser
		driver.quit();
	}
	
	//To verify whether application allows admin to add product with the rewards points
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		
		//login as admin     
		tc0035_pom.sendUserName("admin");
		tc0035_pom.sendPassword("admin@123");
		tc0035_pom.clickLoginBtn(); 
		
		//select the product and save it   
		tc0035_pom.menu();
		tc0035_pom.catalog();
		tc0035_pom.products();
		tc0035_pom.add();
		tc0035_pom.prdct_name("Blazer Girls(7-8)");
		tc0035_pom.meta("Blazer for girls");
		tc0035_pom.data();
		tc0035_pom.model("BLG-112");
		tc0035_pom.price("3000");
		tc0035_pom.quantity("100");
		tc0035_pom.links();
        tc0035_pom.setCategory("Blazers(4-5)");
		
		//add discount
		tc0035_pom.discount();
		tc0035_pom.add_discount();
		tc0035_pom.disc_qnty("5");
		tc0035_pom.disc_price("200");
		tc0035_pom.start_date("2019-02-26");
		tc0035_pom.end_date("2019-02-29");
		
		//give rewards
		tc0035_pom.reward();
		tc0035_pom.points("20");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//set default values for the below values 
		tc0035_pom.Attribute();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.option();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.Recurring();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.special();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.image();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.design();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0035_pom.save();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	//compare the actual title of the page with the expected one
		tc0035_pom.Assertion();
		
		
		screenShot.captureScreenShot("Tenth");
	}
}
