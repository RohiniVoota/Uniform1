package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrdersPOM {
		private WebDriver driver; 
		
		public OrdersPOM(WebDriver driver) {
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
		
		@FindBy(xpath="//*[@id=\"content\"]/ul[3]/li[1]/a")
		private WebElement orderlist;
	
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/table/tbody/tr/td[7]/a")
	    private WebElement view;
		
		
		
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
		public void orders() {
			this.orderlist.click();
		}
		
	public void view() {
		this.view.click();
	}
		
		public void Assertion() {
			String Actual="Order Information";
			String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).getText();
			Assert.assertEquals(Actual,Expected);
		}
			

		
		

}
