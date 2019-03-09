package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DatabaseRegistrationPOM {

		private WebDriver driver; 
		
		public DatabaseRegistrationPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		//locate register 
		@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/ul/li[1]/a")		
		private WebElement register;

		//locate Account icon
		@FindBy(xpath="//i[@class='fa fa-user']")
		private WebElement myaccount;
		
		//locate firstname
		@FindBy(id="input-firstname")
		private WebElement firstname; 
		
		//locate lastname
		@FindBy(id="input-lastname")
		private WebElement lastname;
		
		//locate email
		@FindBy(id="input-email")
		private WebElement email; 
		
		//locate telephone
		@FindBy(id="input-telephone")
		private WebElement telephone; 
		
		//locate address1 
		@FindBy(id="input-address-1")
		private WebElement address1; 
		
		//locate address2
		@FindBy(id="input-address-2")
		private WebElement address2;
		
		//locate city
		@FindBy(id="input-city")
		private WebElement city; 
		
		//locate postcode
		@FindBy(id="input-postcode")
		private WebElement postcode; 
		
		//locate password
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(id="input-confirm")
		private WebElement confirm;
		
		//locate radio button
		@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[4]/div/div/label[2]/input")
		private WebElement radio;
		
		//locate checkbox
		@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
		private WebElement checkbox;

	    //locate continue button
		@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
		private WebElement Button;
		
		
		
		//click on myaccount icon
		public void MyAccount() {
	    	
		       this.myaccount.click();
		       
	      }
	     
		//click on register
	   public void register() {
	 	  this.register.click();
	 	 
	   }
	   
	   //input values
			public String Firstname(String firstname) {
				this.firstname.clear();
				this.firstname.sendKeys(firstname);
				return this.firstname.getAttribute("value");
			}
			
			public String Lastname(String lastname) {
				this.lastname.clear(); 
				this.lastname.sendKeys(lastname); 
				return this.lastname.getAttribute("value");
			}
			
			public String Email(String email) {
				this.email.clear(); 
				this.email.sendKeys(email);
				return this.email.getAttribute("value");
			
			}
			public String Telephone(String telephone) {
				this.telephone.clear();
				this.telephone.sendKeys(telephone);
				return this.telephone.getAttribute("value");
			}
			
			
			public String Address1(String address1) {
				this.address1.clear();
				this.address1.sendKeys(address1);
				return this.address1.getAttribute("value");
			}
			
			public String Address2(String address2) {
				this.address2.clear();
				this.address2.sendKeys(address2);
				return this.address2.getAttribute("value");
			}
			
			public String City(String city) {
				this.city.clear();
				this.city.sendKeys(city);
				return this.city.getAttribute("value");
			}
			
			public String Postcode(String postcode) {
				this.postcode.clear();
				this.postcode.sendKeys(postcode);
				return this.postcode.getAttribute("value");
			}

			
			public String Password(String password) {
				this.password.clear();
				this.password.sendKeys(password);
				return this.password.getAttribute("value");
			}
			
			public String Confirm(String confirm) {
				this.confirm.clear();
				this.confirm.sendKeys(confirm);
				return this.confirm.getAttribute("value");
			}
			
			//click radio button
			public void radio() {
				this.radio.click();
			}
			
			//click checkbox
			public void checkbox() {
				this.checkbox.click();
				}
			//click on continue button
			public void ContinueBtn() {
			this.Button.click();
		
			}



	}

		


