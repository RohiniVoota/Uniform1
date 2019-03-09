package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CheckoutguestLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;



public class CheckoutGuestLogin {

	private WebDriver driver;
	private String baseUrl;
	private CheckoutguestLoginPOM tc0034_pom;
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
		tc0034_pom = new CheckoutguestLoginPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	//To verify whether application allows user to place an order as guest user
	@Test()
	public void ValidCheckout() throws InterruptedException, AWTException {
		
		//select the product 
		tc0034_pom.Shop_Uniforms();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tc0034_pom.T_shirt();
		
		//select the size
		Select dropdown= new Select(driver.findElement(By.id("input-option389")));
		dropdown.selectByVisibleText("26");
		
		tc0034_pom.Cart();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//view the cart and checkout
		tc0034_pom.Cart_icon();
		tc0034_pom.ViewCart();
		tc0034_pom.Checkout();
		
		//login as a guest and continue with order 
		tc0034_pom.RegisterBtn();
		tc0034_pom.firstname("swaroopa");
		tc0034_pom.lastname("v");
		tc0034_pom.email("manuko5@gmail.com");
		tc0034_pom.telephone("387564357");
		tc0034_pom.address("madhapur");
		tc0034_pom.city("hyderabad");
		tc0034_pom.postcode("78858");
		
		//slect the values from dropdown
		Select dropdown1 = new Select(driver.findElement(By.id("input-payment-zone")));
		dropdown1.selectByVisibleText("Andhra Pradesh");
				
		tc0034_pom.password("45678");	
		tc0034_pom.confirmpswd("45678");
		
		tc0034_pom.checkbox();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tc0034_pom.register();
		
		//scroll the page up 
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		
		Thread.sleep(2000);
		tc0034_pom.shippingbtn();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tc0034_pom.comment("Please deliver between 7am to 10am");
		tc0034_pom.shpng();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		tc0034_pom.checkbox1();
		tc0034_pom.payment();
		
		tc0034_pom.cnfrmbtn();
	
		//compare the actual title of the page with the expected one
		tc0034_pom.assertion();
		
		screenShot.captureScreenShot("nine");
	}
}
