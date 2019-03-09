package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutRegisteredLoginPOM {
	private WebDriver driver; 
	
	public CheckoutRegisteredLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the elements
	
	//locate shop-uniform
	@FindBy(xpath="//*[@id=\"banner0\"]/div/a/img")
	private WebElement shop_uniforms; 
	
	//locate t-shirt
	@FindBy(xpath="//*[@id=\"featured-carousel\"]/div/div/div[1]/div/div/div[1]/a/img")
	private WebElement T_shirt;
	
	//locate add to cart
	@FindBy(id="button-cart")
	private WebElement cart;
	
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	private WebElement Cart_icon;
	
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	private WebElement ViewCart;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
	private WebElement checkout;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="button-login")
	private WebElement LoginBtn;
	
	@FindBy(id="button-payment-address")
	private WebElement Continue_Billing;
	
	@FindBy(id="button-shipping-address")
	private WebElement shipping_Billing;
	
	@FindBy(xpath="//*[@id=\"collapse-shipping-method\"]/div/p[4]/textarea")
	private WebElement comment;
	
	@FindBy(id="button-shipping-method")
	private WebElement Shippingbtn;
	
	//locate checkout button
	@FindBy(xpath="//input[@name='agree']")
	private WebElement checkbox;
	
	//locate payment button
	@FindBy(id="button-payment-method")
	private WebElement paymentbtn;
	
	@FindBy(id="button-confirm")
	private WebElement confirmbtn;
	
	//click on uniforms 
	public void Shop_Uniforms() {
		this.shop_uniforms.click();
	
	}
	//click on t-shirts
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
	//click on checkout
	public void Checkout() {
		this.checkout.click();
	}
	//input values
public void email(String email) {
		
		this.email.sendKeys(email);
		}
		
		public void password(String password) {
			
			this.password.sendKeys(password);
			}
		
		//click on login
		public void LoginBtn() {
			this.LoginBtn.click();
		}
        //click on continue billing button
		public void continue_billing() {
			this.Continue_Billing.click();
		}
		public void shipping_billing() {
			this.shipping_Billing.click();
		}
		
		public void comment(String comment) {
			
			this.comment.sendKeys(comment);
			}
		
		public void shippingbtn() {
			this.Shippingbtn.click();
		}
		//clickon checkbox
		public void checkbox() {
			this.checkbox.click();
		}
		public void paymentbtn() {
			this.paymentbtn.click();
		}
		public void confirmbtn() {
			this.confirmbtn.click();
		}
		//Assertion
		public void assertion() {
			String Actual="Thanks for shopping with us online!";
			String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/p[5]")).getText();
			Assert.assertEquals(Actual, Expected);
		   
		}
}
