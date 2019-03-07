package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.EditProfilePOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditProfile {

	private WebDriver driver;
	private String baseUrl;
	private EditProfilePOM editprofile;
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
		editprofile = new EditProfilePOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	@Test
	public void validLogin() throws InterruptedException {
		
		editprofile.MyAccount();
		editprofile.Login();
		editprofile.email("welcome@gmail.com");
		editprofile.password("Rohini123");
		editprofile.LoginBtn();
		editprofile.EditProfiel();
		editprofile.firstname("Rohini");
		editprofile.lastname("voota");
		editprofile.change_email("welcome7@gmail.com");
		editprofile.telephone("7574574577");
		Thread.sleep(5000);
		editprofile.Continue();
		
		
		String Actual="Success: Your account has been successfully updated.";
		String Expected=driver.findElement(By.xpath("/html/body/div[1]/div[1]")).getText();
		Assert.assertEquals(Actual, Expected);
		
		screenShot.captureScreenShot("Fifth");
	}
}

