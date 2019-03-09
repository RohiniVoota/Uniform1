package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SaveProductPOM {
	private WebDriver driver; 
	
	public SaveProductPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locate admin username
		@FindBy(id="input-username")
		private WebElement userName; 
		
		//locate admin password 
		@FindBy(id="input-password")
		private WebElement password;
		
		//locate login
		@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
		private WebElement loginBtn; 
		
		
		@FindBy(xpath="//*[@id=\"button-menu\"]/i")
		private WebElement menu;
		
		//locate catalog
		@FindBy(xpath="//*[@id=\"catalog\"]/a")
		private WebElement catalog;
		
		//locate product
		@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[2]/a")
		private WebElement products;
		
		//locate add 
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a/i")
		private WebElement add;
		
		//locate input value elements
		@FindBy(id="input-name1")
		private WebElement prdct_name;
		
		@FindBy(id="input-meta-title1")
		private WebElement meta;
		
		//locate data tab
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[2]/a")
		private WebElement data;
		
		//locate input values
		@FindBy(id="input-model")
		private WebElement model;
		
		@FindBy(id="input-price")
		private WebElement price;
		
		@FindBy(id="input-quantity")
		private WebElement quantity;
		
		//locate link tab
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[3]/a")
		private WebElement links;
		
		@FindBy(xpath = "//*[@id=\"input-category\"]")
		private WebElement category;
		
		//locate discount tab
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[7]/a")
		private WebElement discount;
		
		//locate input discount values
		@FindBy(xpath="//*[@id=\"discount\"]/tfoot/tr/td[2]/button")
		private WebElement add_discount;
		
		@FindBy(xpath="//*[@id=\"discount-row0\"]/td[2]/input")
		private WebElement disc_qnty;
		
		@FindBy(xpath="//*[@id=\"discount-row0\"]/td[4]/input")
		private WebElement disc_price;
		
		//locate date
		@FindBy(xpath="//*[@id=\"discount-row0\"]/td[5]/div/input")
		private WebElement start_date;
		
		@FindBy(xpath="//*[@id=\"discount-row0\"]/td[6]/div/input")
		private WebElement end_date;
		
		//locate rewards tab
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[10]/a")
		private WebElement reward;
		
		@FindBy(id="input-points")
		private WebElement points;
		
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[4]/a")
		private WebElement Attribute;
		
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[5]/a")
		private WebElement option;
		
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[6]/a")
		private WebElement Recurring;
		
	//locate special
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[8]/a")
		private WebElement special;
		
		//locate image
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[9]/a")
		private WebElement image;
		
		//locate design
		@FindBy(xpath="//*[@id=\"form-product\"]/ul/li[11]/a")
		private WebElement design;
		
		//locate save button
		@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
		private WebElement save;
		
	
		
		//input the valid credentials
		public void sendUserName(String userName) {
			this.userName.clear();
			this.userName.sendKeys(userName);
		}
		
		public void sendPassword(String password) {
			this.password.clear(); 
			this.password.sendKeys(password); 
		}
		//click on login button
		public void clickLoginBtn() {
			this.loginBtn.click(); 
		}
		//click on menu
		public void menu() {
			this.menu.click();
		}
		public void catalog() {
			this.catalog.click();
		}
		//click on products
		public void products() {
			this.products.click();
		}
		
		//click on add product
		public void add() {
			this.add.click();
		}
		//input product details
		public void prdct_name(String prdct_name) {
			this.prdct_name.sendKeys(prdct_name);
		}
		public void meta(String meta) {
			this.meta.sendKeys(meta);
		}
		//click on data tab
		public void data() {
			this.data.click();
		}
		//input the data values
		public void model(String model) {
			this.model.sendKeys(model);
		}
		public void price(String price) {
			this.price.clear();
			this.price.sendKeys(price);
		}
		public void quantity(String quantity) {
			this.quantity.clear();
			this.quantity.sendKeys(quantity);
		}
		//click on link tab
		public void links() {
			this.links.click();
		}
		public void setCategory(String category) {
			this.category.clear();
			this.category.sendKeys(category);
		}
		
		//click on discount tab
		public void discount() {
			this.discount.click();
		}
		public void add_discount() {
			this.add_discount.click();
		}
		public void disc_qnty(String disc_qnty) {
			
			this.disc_qnty.sendKeys(disc_qnty);
		}
		
	    public void disc_price(String disc_price) {
			
			this.disc_price.sendKeys(disc_price);
		}
	    //input the start date and end date
	    public void start_date(String start_date) {
		this.start_date.clear();
		this.start_date.sendKeys(start_date);
	    }
	    public void end_date(String end_date) {
	    	this.end_date.clear();
	    	this.end_date.sendKeys(end_date);
	        }
	    //click on rewards tab;
	    public void reward() {
	    	this.reward.click();
	    }
	    
	    public void points(String points) {
	    	this.points.clear();
	    	this.points.sendKeys(points);
	        }
	    //click on attribute tab
	    public void Attribute() {
	    	this.Attribute.click();
	    }
	    
	    //click on option tab
	    public void option() {
	    	this.option.click();
	    }
	    //click on recurring tab
	    public void Recurring() {
	    	this.Recurring.click();
	    }
	    //clickon special tab
	    public void special() {
	    	this.special.click();
	    }
	    //click on image tab
	    public void image() {
	    	this.image.click();
	    }
	    public void design() {
	    	this.design.click();
	    }
	    //click on save button
	    public void save() {
	    	this.save.click();
	    }
	    
	   //Assertion
    public void Assertion() {
    	String Actual="Products";
		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
		Assert.assertEquals(Actual, Expected);
    }
}


