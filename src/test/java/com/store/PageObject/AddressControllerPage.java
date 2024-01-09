package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddressControllerPage {

	//1.create object of webdriver
	WebDriver ldriver;
	
//constructor		
	public AddressControllerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//find webelement
	
	@FindBy(xpath="//a[@title='Add my first address']")
	WebElement addressmyfirstaddress;
	
	@FindBy(id="firstname")
	WebElement Addfirstname;
	
	
	@FindBy(id="lastname")
	WebElement Addlastname;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postalcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	
	@FindBy(id="phone")
	WebElement Homephone;
	
	@FindBy(id="phone_mobile")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement alias;
	
	@FindBy(id="submitAddress")
	WebElement Save;
	
//identify action	
	
	
	public void ClickOnAddmyfirstaddress()
	{
		addressmyfirstaddress.click();
	}
	
	
	
	public void enterAddressFirstName(String fname) {
		
		Addfirstname.sendKeys(fname);
	}
	
	public void enterAddressLastName(String lname) {
		
		Addlastname.sendKeys(lname);
	}
	
	public void enterAddress(String add) {
		
		address1.sendKeys(add);
	}
	
	
	public void enterCityName(String cityname) {
		
		city.sendKeys(cityname);
	}
	
	public void selectStateName(String text) {
	
		Select obj = new Select(state);
		obj.selectByVisibleText(text);
}
	
	public void enterPostcode(String postcodedata) {
		
		postalcode.sendKeys(postcodedata);
	}
	
	public void selectcountry(String text) {
		
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
}
	
	
	public void enterphonenumber(String phonenum) {
		
		phone.sendKeys(phonenum);
		}
	
	public void enterHomephonenumber(String Homephonenum) {
		
		Homephone.sendKeys(Homephonenum);
		}
	
	public void enteralias(String text) {
		alias.clear();
		alias.sendKeys(text);
		}
	public void clickonsave()
	{
		Save.click();
	}
	
}
