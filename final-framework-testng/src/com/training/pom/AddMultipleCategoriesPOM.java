package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddMultipleCategoriesPOM {
	private WebDriver driver; 
	
	public AddMultipleCategoriesPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	//locating the elements
	
	//locate username and password
	@FindBy(id="input-username")
	private WebElement userName; 
	
	@FindBy(id="input-password")
	private WebElement password;
	
	//locate login button
	@FindBy(xpath="//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement loginBtn; 
	
	//locate to menu
	@FindBy(xpath="//*[@id=\"button-menu\"]/i")
	private WebElement menu;
	
	//locate on catalog
	@FindBy(xpath="//*[@id=\"catalog\"]/a")
	private WebElement catalog;

	@FindBy(xpath="//*[@id=\"catalog\"]/ul/li[1]/a")
	private WebElement categories;

	//locate product
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/a[1]/i")
	private WebElement add;
	
	//locate category name and description
	@FindBy(id="input-name1")
	private WebElement category_name;

	@FindBy(xpath="//*[@id=\"language1\"]/div[2]/div/div/div[3]/div[2]")
	private WebElement Description;
	
	@FindBy(id="input-meta-title1")
	private WebElement meta;
	
	@FindBy(id="input-meta-description1")
	private WebElement meta_desc;
	
	//locate on Data tab
	@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[2]/a")
	private WebElement Data;
	
	@FindBy(xpath="//*[@id=\"form-category\"]/ul/li[3]/a")
	private WebElement Design;
	
	
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement save;
	
	//clear and send the username
    public void sendUserName(String userName) {
	this.userName.clear();
    this.userName.sendKeys(userName);
    }

    //clear and send the password
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
     public void categories() {
   	  this.categories.click();
         }
     
     //Add cataegories
     public void add() {
      	  this.add.click();
            }
     //input the values
     public void Category_name(String name) {
    		this.category_name.clear(); 
    		this.category_name.sendKeys(name); 
    	    }
     public void Description(String description) { 
 		this.Description.sendKeys(description); 
 	    }
     public void meta(String meta) { 
    	this.meta.clear();
  		this.meta.sendKeys(meta); 
  	    }
     public void meta_desc(String meta_desc) { 
     	this.meta_desc.clear();
   		this.meta_desc.sendKeys(meta_desc); 
   	    }
     //clickon data tab
     public void Data() {
     	  this.Data.click();
           }
     public void Design() {
    	  this.Design.click();
          }
     
     //click Save button
     public void Save() {
   	  this.save.click();
         }
    //compare the values 
     public void Assertion() {
    	 String Actual="Products";
 		String Expected=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/h1")).getText();
 		Assert.assertEquals(Actual, Expected);
     }
    }