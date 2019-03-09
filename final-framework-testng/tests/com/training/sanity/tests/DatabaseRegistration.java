package com.training.sanity.tests;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
    import com.training.pom.DatabaseRegistrationPOM;
    import com.training.utility.DriverFactory;
	import com.training.utility.DriverNames;

	public class DatabaseRegistration {

		private WebDriver driver;
		private String baseUrl;
		private DatabaseRegistrationPOM register;
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
			register = new DatabaseRegistrationPOM(driver); 
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
    
		//To verify whether registered user details stored in database
		@Test(dataProvider="db-inputs", dataProviderClass = LoginDataProviders.class)
		public void validLoginTest(String firstname,String lastname, String email, String Telephone,String address1,String address2, String city,String postcode, String password, String confirm) throws InterruptedException {
			
			register.MyAccount();
			register.register();
			String Firstname= register.Firstname("Rohini");
			String Lastname=register.Lastname("Voota");
			String Email=register.Email("welcome6@gmail.com"); 
			String telephone=register.Telephone("6787");
			String Address1=register.Address1("madhapur");
			String Address2=register.Address2("image");
			String City=register.City("hyderabad");
			String Postcode=register.Postcode("533005");
			
			//select the value from dropdown
			
			Select Country= new Select(driver.findElement(By.id("input-country")));
			Country.selectByVisibleText("India");
			
			Select Region= new Select(driver.findElement(By.id("input-zone")));
			Region.selectByVisibleText("Telangana");
			
			String Password=register.Password("rohini123");
			String Confirm=register.Confirm("rohini123");
			
			register.radio();
            register.checkbox();
		    register.ContinueBtn();
		    
		    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		    
		    //Assertions
		    Assert.assertEquals(Firstname, firstname);
			Assert.assertEquals(Lastname, lastname);
			Assert.assertEquals(Email, email);
			Assert.assertEquals(telephone,Telephone);
			Assert.assertEquals(Address1,address1);
			Assert.assertEquals(Address2,address2);
			Assert.assertEquals(City,city);
			Assert.assertEquals(Postcode,postcode);
			Assert.assertEquals(Password,password);
			Assert.assertEquals(Confirm,confirm);
		

			
			screenShot.captureScreenShot("TC061");
		}
	}

	
