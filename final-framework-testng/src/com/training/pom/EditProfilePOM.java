package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class EditProfilePOM {
		private WebDriver driver; 
		
		public EditProfilePOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		//locating elements
		@FindBy(xpath="//i[@class='fa fa-user']")
		private WebElement myaccount;
		
		@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/ul/li[2]/a")
		private WebElement login;
		
		@FindBy(id="input-email")
		private WebElement email;
		
		@FindBy(id="input-password")
		private WebElement password;
		
		
		@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/input")
		private WebElement LoginBtn;
		
		@FindBy(xpath="//*[@id=\"content\"]/ul[2]/li[1]/a")
		private WebElement EditProfile;
		
		@FindBy(id="input-firstname")
		private WebElement firstname;
		
		@FindBy(id="input-lastname")
		private WebElement lastname;
		
		@FindBy(id="input-email")
		private WebElement change_email;
		
		@FindBy(id="input-telephone")
		private WebElement telephone;
		
		@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
		private WebElement continuebtn;
		
		//Methods
		public void MyAccount() {
			this.myaccount.click();
		}
		
		public void Login() {
			this.login.click();
		}
		
		public void email(String email) {
		
		this.email.sendKeys(email);
		}
		
		public void password(String password) {
			
			this.password.sendKeys(password);
			}
		
		public void LoginBtn() {
			this.LoginBtn.click();
		}
			
		public void EditProfiel() {
			this.EditProfile.click();
		}
		
		public void firstname(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
			
		}
		
		public void lastname(String lastname) {
			this.lastname.clear();
			this.lastname.sendKeys(lastname);
			
		}
		
		public void change_email(String email) {
			this.change_email.clear();
			this.change_email.sendKeys(email);
			
		}
		
		public void telephone(String telephone) {
			this.telephone.clear();
			this.telephone.sendKeys(telephone);
			
		}
		
		public void Continue() {
			
			this.continuebtn.click();
		}
		
		public void Assertion() {
			String Actual="Success: Your account has been successfully updated.";
			String Expected=driver.findElement(By.xpath("/html/body/div[1]/div[1]")).getText();
			Assert.assertEquals(Actual, Expected);
		}
		
		
		
		
		
		
      
			

		
		

}
