package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserRegistrationPOM {

		private WebDriver driver; 
		
		public UserRegistrationPOM(WebDriver driver) {
			this.driver = driver; 
			PageFactory.initElements(driver, this);
		}
		
		
		@FindBy(xpath="//*[@id=\"top-links1\"]/ul/li[3]/ul/li[1]/a")		
		private WebElement register;
    
		@FindBy(xpath="//i[@class='fa fa-user']")
		private WebElement myaccount;
		
		@FindBy(id="input-firstname")
		private WebElement firstname; 
		
		@FindBy(id="input-lastname")
		private WebElement lastname;
		
		@FindBy(id="input-email")
		private WebElement email; 
		
		@FindBy(id="input-telephone")
		private WebElement telephone; 
		
		@FindBy(id="input-address-1")
		private WebElement address; 
		
		@FindBy(id="input-city")
		private WebElement city; 
		
		@FindBy(id="input-postcode")
		private WebElement postcode; 
		
		@FindBy(id="input-password")
		private WebElement password;
		
		@FindBy(id="input-confirm")
		private WebElement confirm;
		
		@FindBy(xpath="//*[@id=\"content\"]/form/fieldset[4]/div/div/label[2]/input")
		private WebElement radio;
		

		@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[1]")
		private WebElement checkbox;
	
		@FindBy(xpath="//*[@id=\"content\"]/form/div/div/input[2]")
		private WebElement Button;
		
		
        public void MyAccount() {
        	
	       this.myaccount.click();
	       
         }
        
      public void register() {
    	  this.register.click();
    	 
      }
		public void Firstname(String firstname) {
			this.firstname.clear();
			this.firstname.sendKeys(firstname);
		}
		
		public void Lastname(String lastname) {
			this.lastname.clear(); 
			this.lastname.sendKeys(lastname); 
		}
		
		public void Email(String email) {
			this.email.clear(); 
			this.email.sendKeys(email);
		
		
		}
		public void Telephone(String telephone) {
			this.telephone.clear();
			this.telephone.sendKeys(telephone);
		}
		
		
		public void Address(String address) {
			this.address.clear();
			this.address.sendKeys(address);
		}
		
		
		public void City(String city) {
			this.city.clear();
			this.city.sendKeys(city);
		}
		
		public void Postcode(String postcode) {
			this.postcode.clear();
			this.postcode.sendKeys(postcode);
		}

		
		public void Password(String password) {
			this.password.clear();
			this.password.sendKeys(password);
		}
		
		public void Confirm(String confirm) {
			this.confirm.clear();
			this.confirm.sendKeys(confirm);
		}
		
		public void radio() {
			this.radio.click();
		}
		
		public void checkbox() {
			this.checkbox.click();
			}
		public void ContinueBtn() {
		this.Button.click();
	
		}
}

