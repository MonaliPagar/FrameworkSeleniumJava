package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {

	//1.create object of webdriver
		WebDriver ldriver;
		
	//constuctor	
		public IndexPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
	//find webelement
		@FindBy(linkText="Sign in")
		WebElement signIn;
		
		@FindBy(xpath="((//a[text()='T-shirts'])[2])")
		WebElement tshirtMenu;
		
	//identify action	
		
		public void ClickOnSignIn() {
			signIn.click();
		}
		
		public String getPageTitle()
		{
			return(ldriver.getTitle());
		}
		
		public void clickOnTShirtMenu()
		{
			tshirtMenu.click();
		}
}
