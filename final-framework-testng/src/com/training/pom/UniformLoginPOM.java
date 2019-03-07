package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UniformLoginPOM {
		private WebDriver driver; 
		
		public UniformLoginPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		
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
			
       
			

		
		

}
