package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutguestLoginPOM {
	private WebDriver driver; 
	
	public CheckoutguestLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the elements
	@FindBy(xpath="//*[@id=\"banner0\"]/div/a/img")
	private WebElement shop_uniforms; 
	
	//locate t-shirt
	@FindBy(xpath="//*[@id=\"featured-carousel\"]/div/div/div[1]/div/div/div[1]/a/img")
	private WebElement T_shirt;
	
	//locate add to cart
	@FindBy(id="button-cart")
	private WebElement cart;
	
	//locate the cart icon
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	private WebElement Cart_icon;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	private WebElement ViewCart;
	
	//loacte checkout
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
	private WebElement checkout;
	
    @FindBy(id="button-account")
    private WebElement RegisterBtn;
    
    //locate element firstname
    @FindBy(id="input-payment-firstname")
    private WebElement firstname;
    
    @FindBy(id="input-payment-lastname")
    private WebElement lastname;
    
    @FindBy(id="input-payment-email")
    private WebElement email;
    
    @FindBy(id="input-payment-telephone")
    private WebElement telephone;
    
    @FindBy(id="input-payment-address-1")
    private WebElement address;
    
    @FindBy(id="input-payment-city")
    private WebElement city;
    
    @FindBy(id="input-payment-postcode")
    private WebElement postcode;
    
    @FindBy(id="input-payment-password")
    private WebElement password;
    
    @FindBy(id="input-payment-confirm")
    private WebElement confirmpswd;
    
    //locate checkbox
    @FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/div[4]/div/input[1]")
    private WebElement checkbox;
    
    @FindBy(id="button-register")
    private WebElement register;
   
    @FindBy(id="button-shipping-address")
    private WebElement shipping;
    
    //locate comment
    @FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
    private WebElement comment;
    
    @FindBy(id="button-shipping-method")
    private WebElement shpng;
    
    @FindBy(xpath="//input[@name='agree']")
	private WebElement checkbox1;
    
    @FindBy(id="button-payment-method")
    private WebElement payment;
    
    @FindBy(id="button-confirm")
    private WebElement cnfrmbtn;
    
    
    //click on shop uniform
	public void Shop_Uniforms() {
		this.shop_uniforms.click();
	
	}
	//click on t-shirt
	public void T_shirt() {
		this.T_shirt.click();
	
	}
	//click on add cart
	public void Cart() {
		this.cart.click();
	}
	
	//click on cart icon
	public void Cart_icon() {
		this.Cart_icon.click();
	}
	
	//click on view cart
	public void ViewCart() {
		this.ViewCart.click();
	}
	
	//click on checkout button
	public void Checkout() {
		this.checkout.click();
	}
	
	//click on register button
	public void RegisterBtn() {
		this.RegisterBtn.click();
	}

	//input the values
		public void firstname(String firstname) {
			this.firstname.sendKeys(firstname);
		}
		public void lastname(String lastname) {
			this.lastname.sendKeys(lastname);
		}
		public void email(String email) {
			this.email.sendKeys(email);
		}
		public void telephone(String telephone) {
			this.telephone.sendKeys(telephone);
		}
		public void address(String address) {
			this.address.sendKeys(address);
		}
		public void city(String city) {
			this.city.sendKeys(city);
		}
		public void postcode(String postcode) {
			this.postcode.sendKeys(postcode);
		}
		public void password(String password) {
			this.password.sendKeys(password);
		}
		
		public void confirmpswd(String confirmpswd) {
			this.confirmpswd.sendKeys(confirmpswd);
		}
		//click on checkbox
		public void checkbox() {
			this.checkbox.click();
		}
		
		public void register() {
			this.register.click();
		}
		public void shippingbtn() {
			this.shipping.click();
		}
		//click on comment
		public void comment(String comment) {
			this.comment.sendKeys(comment);
		}
		public void shpng() {
		this.shpng.click();
}
		public void checkbox1() {
			this.checkbox1.click();
	}
		public void payment() {
			this.payment.click();
	}	
		public void cnfrmbtn() {
			this.cnfrmbtn.click();
	}	
		//Assertion
		public void assertion() {
			String Actual="Thanks for shopping with us online!";
			String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/p[5]")).getText();
			Assert.assertEquals(Actual, Expected);
		}
		
}


