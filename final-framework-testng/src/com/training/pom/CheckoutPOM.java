package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutPOM {
	private WebDriver driver; 
	
	public CheckoutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	//locating the elements
	
	@FindBy(xpath="//*[@id=\"banner0\"]/div/a/img")
	private WebElement shop_uniforms; 
	
	//locate t-shirt
	@FindBy(xpath="//*[@id=\"featured-carousel\"]/div/div/div[1]/div/div/div[1]/a/img")
	private WebElement T_shirt;
	
	//locate add  to cart button
	@FindBy(id="button-cart")
	private WebElement cart;
	
	//locate cart icon
	@FindBy(xpath="//*[@id=\"cart\"]/button")
	private WebElement Cart_icon;
	
	//locate view cart 
	@FindBy(xpath="//*[@id=\"cart\"]/ul/li[2]/div/p/a[1]/strong")
	private WebElement ViewCart;
	
	@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[2]/a")
	private WebElement checkout;
	
	
	//click on shop-uniforms
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
	
	//click on checkout
	public void Checkout() {
		this.checkout.click();
	}
	//assertion
    public void assertion() {
    	String Actual="CHECKOUT";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
		Assert.assertEquals(Actual,Expected);
		
    }

}
