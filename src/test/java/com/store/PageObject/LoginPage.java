package com.store.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//1.create object of webdriver
			WebDriver ldriver;
			
	//constructor		
			public LoginPage(WebDriver rdriver)
			{
				ldriver = rdriver;
				PageFactory.initElements(rdriver, this);
			}
			
		//find webelement for new account
			@FindBy(id="email_create")
			WebElement createEmailId;
			
			@FindBy(id="SubmitCreate")
			WebElement SubmitCreate;
			
		//registerd user	
			@FindBy(id="email")
			WebElement RegisterdUserEmail;
			
			@FindBy(id="passwd")
			WebElement RegisterdUserPass;
			
			@FindBy(id="SubmitLogin")
			WebElement SubmitUserLogin;
			
		//identify action	
			
			//for new account

			public void enterCreateEmailAddress(String emailAdd) {
				createEmailId.sendKeys(emailAdd);
			}
			public void clickSubmitCreate()
			{
				SubmitCreate.click();
			}
			
			
			
			
			//for registerd account
			
			public void enterRegistedEmailAddress(String emailAdd) {
				RegisterdUserEmail.sendKeys(emailAdd);
			}
			public void enterRegiterdPassword(String pwd) {
				RegisterdUserPass.sendKeys(pwd);
			}
			public void clickSubmitUserLogin()
			{
				SubmitUserLogin.click();
			}
}
