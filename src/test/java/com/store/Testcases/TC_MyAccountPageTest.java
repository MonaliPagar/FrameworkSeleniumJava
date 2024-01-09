package com.store.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.store.PageObject.AddressControllerPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.LoginPage;
import com.store.PageObject.RegisterdUserPage;
import com.store.PageObject.accountCreationDetails;


public class TC_MyAccountPageTest extends BaseClass {
	
	
	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{
		//browser launch
		
		//open url
		
		
		IndexPage pg = new IndexPage(driver);
		pg.ClickOnSignIn();
		logger.info("clicked on sign in link");

		
		
		LoginPage pg1 = new LoginPage(driver);
		pg1.enterCreateEmailAddress("cs923@gmail.com");
		logger.info("Email address entered and create account section");

		pg1.clickSubmitCreate();
		
		
		logger.info("clicked on create an account button");
		
		
		accountCreationDetails accCreationpg = new accountCreationDetails(driver);
		
		accCreationpg.SelectTitlemrs();
		accCreationpg.enterCustomerFirstName("Prachi");
		accCreationpg.enterCustomerlastName("Gupta");
		accCreationpg.enterPassword("cs923");
		
		accCreationpg.clickonRegister();
		
		logger.info("click on register button");
		
		
		RegisterdUserPage reguser = new RegisterdUserPage(driver);
		String username = reguser.getuserName();
		
		Assert.assertEquals("Prachi Gupta",username);
		
		logger.info("enter user details on registration page");

		
		
		
		AddressControllerPage AddressCon = new AddressControllerPage(driver);
		AddressCon.ClickOnAddmyfirstaddress();
		logger.info("click on Add my first address button");
		
		
		AddressCon.enterAddressFirstName("Prachi");
		AddressCon.enterAddressLastName("Gupta");
		AddressCon.enterAddress("18/8 worli road");
		AddressCon.enterCityName("Mumbai");
		AddressCon.selectStateName("Alabama");
		AddressCon.enterPostcode("00000");
		AddressCon.selectcountry("United States");
		AddressCon.enterHomephonenumber("02592221218");
		AddressCon.enterphonenumber("9891778192");
		AddressCon.enteralias("Home");
		
		AddressCon.clickonsave();
		logger.info("click on save button");
		
		logger.info("enter user address details on registration page");

		
		

	}
	
	@Test(enabled=true)
	public void VerifyLogin() throws IOException
	{
		logger.info("Verify registerd user login");

		IndexPage pg = new IndexPage(driver);
		pg.ClickOnSignIn();
		logger.info("clicked on sign in link");

		
		
		LoginPage pg1 = new LoginPage(driver);
		pg1.enterRegistedEmailAddress("cs923@gmail.com");
		logger.info("enter email");

		pg1.enterRegiterdPassword("cs923");
		logger.info("enter pass");

		pg1.clickSubmitUserLogin();
		logger.info("clicked on submit link");


		RegisterdUserPage reguser = new RegisterdUserPage(driver);
		String username = reguser.getuserName();
		
		
		if(username.equals("Prachi Gupta"))
		{
			logger.info("verifyLogin - passed");
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("verifyLogin - failed");
			captureScreenshot(driver,"verifyLogin");
			Assert.assertTrue(false);

		}
	}
	
	
	@Test(enabled=true)
	public void VerifySignOut() throws IOException 
	{

		logger.info("Verify registerd user login");

		IndexPage pg = new IndexPage(driver);
		pg.ClickOnSignIn();
		logger.info("clicked on sign in link");

		
		
		LoginPage pg1 = new LoginPage(driver);
		pg1.enterRegistedEmailAddress(emailAddress);
		logger.info("enter email");

		pg1.enterRegiterdPassword(password);
		logger.info("enter pass");

		pg1.clickSubmitUserLogin();
		logger.info("clicked on submit link");

		RegisterdUserPage reguser = new RegisterdUserPage(driver);
		
		reguser.clickOnSignOut();
		
		
		if(pg.getPageTitle().equals("Login - My Shop"))
		{
			logger.info("VerifySignOut - Passed");
			Assert.assertTrue(true);
		}

		else
		{
			logger.info("VerifySignOut - Failed");
			captureScreenshot(driver,"VerifySignOut");
			Assert.assertTrue(false);
		}

	
		logger.info("***************TestCase Verify Sign out ends*****************"); 
	
}
}
