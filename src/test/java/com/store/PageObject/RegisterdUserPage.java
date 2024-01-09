package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterdUserPage {
	//1.create object of webdriver
		WebDriver ldriver;
		
	//constructor		
		public RegisterdUserPage(WebDriver rdriver)
		{
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}
		
	//find webelement
		@FindBy(xpath="//a[@title='View my customer account']")//for title mrs
		WebElement username;
		
		@FindBy(xpath="//a[@title='Log me out']")
		WebElement signOut;
		
		
		@FindBy(name ="search_query")
		WebElement searchBox;

		@FindBy(name ="submit_search")
		WebElement submit_search;
		
		@FindBy(linkText = "Women")
		WebElement WomenMenu;

		@FindBy(linkText="T-shirts")
		WebElement TShirtMenu;
		
		
		
		public void clickOnSignOut()
		{
			signOut.click();
		}
		
		public String getuserName()
		{
			String text= username.getText();
			return text;
		}
		
		public void EnterDataInSearchBox(String searchKey)
		{
			searchBox.sendKeys(searchKey);
		}

		public void ClickOnSearchButton()
		{
			submit_search.click();

		}
	
	
}
