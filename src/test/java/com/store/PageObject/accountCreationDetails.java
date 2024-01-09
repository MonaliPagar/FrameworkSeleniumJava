package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {

	//1.create object of webdriver
	WebDriver ldriver;
	
//constructor		
	public accountCreationDetails(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
//find webelement
	@FindBy(id="id_gender2")//for title mrs
	WebElement titleMrs;
	
	@FindBy(id="customer_firstname")
	WebElement custfirstName;
	
	@FindBy(id="customer_lastname")
	WebElement custlastName;
	
	@FindBy(id="passwd")
	WebElement password;
	
	/*@FindBy(xpath="//a[@title='Add my first address']")
	WebElement addressmyfirstaddress;
	
	@FindBy(id="firstname")
	WebElement Addfirstname;
	
	
	@FindBy(id="lastname")
	WebElement Addlastname;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="uniform-id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postalcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement phone;
	
	@FindBy(id="alias")
	WebElement alias;*/
	
	@FindBy(id="submitAccount")
	WebElement Register;
	
//identify action	
	
	
	public void SelectTitlemrs()
	{
		titleMrs.click();
	}
	
	
	public void enterCustomerFirstName(String fname) {
		
		custfirstName.sendKeys(fname);
	}
	
	public void enterCustomerlastName(String lname) {
		
		custlastName.sendKeys(lname);
	}
	
	public void enterPassword(String pwd) {
	
		password.sendKeys(pwd);
	}
	
	
/*	public void ClickOnAddmyfirstaddress()
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
		obj.deselectByVisibleText(text);
}
	public void enterPostcode(String postcodedata) {
		
		postalcode.sendKeys(postcodedata);
	}
	
	public void selectcountry(String text) {
		
		Select obj = new Select(country);
		obj.deselectByVisibleText(text);
}
	
	
	public void enterphonenumber(String phonenum) {
		
		phone.sendKeys(phonenum);
		}
	
	public void enteralias(String text) {
		
		alias.sendKeys(text);
		}*/
	
	
	public void clickonRegister()
	{
		Register.click();
	}
	
}
