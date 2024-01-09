package com.store.Testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.store.PageObject.accountCreationDetails;
import com.store.PageObject.AddressControllerPage;
import com.store.PageObject.IndexPage;
import com.store.PageObject.LoginPage;
import com.store.PageObject.RegisterdUserPage;
import com.store.Utilities.ReadExcelFile;



public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {


	@Test(enabled=false)
	public void verifyRegistrationAndLogin()
	{

		logger.info("***************TestCase Verify Registration and Login starts*****************"); 


		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSignIn();
		logger.info("Clicked on sign in link");

		LoginPage pg1 = new LoginPage(driver);
		pg1.enterCreateEmailAddress("cs923@gmail.com");
		logger.info("Email address entered in create account section.");

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
		
		

		logger.info("***************TestCase Verify Registration and Login ends*****************"); 

	}
	
	@Test(dataProvider = "LoginDataProvider")
	
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase VerifyLogin starts*****************"); 


		IndexPage pg = new IndexPage(driver);

		pg.ClickOnSignIn();
		logger.info("Clicked on sign in link");

		LoginPage pg1 = new LoginPage(driver);
		
		pg1.enterRegistedEmailAddress(userEmail);
		logger.info("Entered email address");
		
		pg1.enterRegiterdPassword(userPwd);
		logger.info("Entered password");

		pg1.clickSubmitUserLogin();
		logger.info("Clicked on sign in link..");

		RegisterdUserPage regUser = new RegisterdUserPage(driver);
		String userName = regUser.getuserName();
		
		
		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			Assert.assertTrue(true);
			
			regUser.clickOnSignOut();
			
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenshot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		} 
		
		 
		logger.info("***************TestCase Verify login ends*****************"); 


	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

}
















































