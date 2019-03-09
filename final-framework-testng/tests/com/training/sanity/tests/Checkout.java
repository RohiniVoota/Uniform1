package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckoutPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class Checkout {

	private WebDriver driver;
	private String baseUrl;
	private CheckoutPOM tc0032_pom;
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
		tc0032_pom = new CheckoutPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		//close the browser
		driver.quit();
	}
	//To verify whether application displays Login screen upon checking out the product without Pre Logging in
	@Test
	public void ValidCheckout() throws InterruptedException {
		tc0032_pom.Shop_Uniforms();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		tc0032_pom.T_shirt();
		
		//select the size
		Select dropdown= new Select(driver.findElement(By.id("input-option389")));
		dropdown.selectByVisibleText("26");
		
        //click on add cart
		tc0032_pom.Cart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		tc0032_pom.Cart_icon();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//view the cart
		tc0032_pom.ViewCart();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Checkout
		tc0032_pom.Checkout();
		
		//compare the actual title of the page with the expected one
		tc0032_pom.assertion();
		
		screenShot.captureScreenShot("Seventh");
	}
}
