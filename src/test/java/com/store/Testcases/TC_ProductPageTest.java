package com.store.Testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.store.PageObject.IndexPage;
import com.store.PageObject.LoginPage;
import com.store.PageObject.OrderAddressPage;
import com.store.PageObject.OrderConfirmationPage;
import com.store.PageObject.OrderPaymentPage;
import com.store.PageObject.OrderShippingPage;
import com.store.PageObject.OrderSummaryPage;
import com.store.PageObject.ProductPage;
import com.store.PageObject.RegisterdUserPage;
import com.store.PageObject.SearchResultPage;



public class TC_ProductPageTest  extends BaseClass  {

	@Test(enabled=false)
	public void VerifySearchProduct() throws IOException
	{
		String searchKey = "T-shirts";
		logger.info("\n***************TestCase Search Product started*****************"); 

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.ClickOnSignIn();


		//Enter account details- email and password
		LoginPage pg1 = new LoginPage(driver);
		pg1.enterRegistedEmailAddress(emailAddress);
		logger.info("enter email");

		pg1.enterRegiterdPassword(password);
		logger.info("enter pass");

		pg1.clickSubmitUserLogin();
		logger.info("clicked on submit link");

		
		
		
		//Enter searchkey in search box
		RegisterdUserPage regUser = new RegisterdUserPage(driver);
		regUser.EnterDataInSearchBox(searchKey);
		regUser.ClickOnSearchButton();

		// Get Name of Searched Product
		SearchResultPage resultPg = new SearchResultPage(driver);

		String SearchResultProductname=resultPg.getSearchResultProductName();


		//Verify that correct Product is displaying after search

		if(SearchResultProductname.contains(searchKey))
		{
			logger.info("Search Product testcase - Passed"); 
			Assert.assertTrue(true);

			regUser.clickOnSignOut();

		}
		else
		{
			logger.info("Search Product testcase - Failed");
			captureScreenshot(driver,"VerifySearchProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase Search Product ends*****************"); 

	}


	@Test(enabled = false)
	public void VerifyBuyProduct() throws IOException
	{

		logger.info("\n***************TestCase Buy Product started*****************"); 

		/*	driver.get(url);
		logger.info("Url opened");*/

		//Sign in 
		IndexPage indexPg = new IndexPage(driver);
		indexPg.ClickOnSignIn();


		//Enter account details- email and password
		LoginPage pg1 = new LoginPage(driver);
		pg1.enterRegistedEmailAddress(emailAddress);
		logger.info("enter email");

		pg1.enterRegiterdPassword(password);
		logger.info("enter pass");

		pg1.clickSubmitUserLogin();
		logger.info("clicked on submit link");

		//Enter searchkey in search box
		RegisterdUserPage regUser = new RegisterdUserPage(driver);
		regUser.EnterDataInSearchBox("T-shirts");
		logger.info("T-shirt entered in search box");

		regUser.ClickOnSearchButton();
		logger.info("clicked on search button");

		SearchResultPage searchResultPg = new SearchResultPage(driver);
		searchResultPg.ClickOnMoreLink();
		logger.info("Clicked on more button");

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//

		ProductPage prodPg = new ProductPage(driver);
		prodPg.setQuantity("2");
		logger.info("quantity 2 entereed");

		prodPg.setSize("M");
		logger.info("size M entered");

		prodPg.clickOnAddToCart();
		logger.info("Clicked on add to cart");

		prodPg.clickOnProceedToCheckOut();
		logger.info("Clicked on proceed to checkout on product page");


		OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
		orderSumPg.cickOnProceedToCheckout(); 
		logger.info("Clicked on proceed to checkout on order summary page");

		OrderAddressPage orderAddPg = new OrderAddressPage(driver);
		orderAddPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order address page");

		OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
		orderShippingPg.selectTermsOfServices();
		logger.info("selecged term of service check box");

		orderShippingPg.cickOnProceedToCheckout();
		logger.info("Clicked on proceed to checkout on order shipping page");

		OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
		logger.info(orderPaymentPg.getPageTitle());

		orderPaymentPg.clickOnPayByCheque();
		logger.info("Clicked on pay by cheque");

		OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
		orderConfirmPg.cickOnConfirmOrder();

		logger.info("Clicked on confirmed order");

		String sucessMsg = orderConfirmPg.getOrderSucessMessage();

		//	Assert.assertEquals(sucessMsg, "Your order on My Store is complete.");

		if(sucessMsg.equals("Your order on My Shop is complete."))
		{
			logger.info("VerifyBuyProduct - Passed"); 
			Assert.assertTrue(true);

			orderConfirmPg.clickOnSignOut();

		}
		else
		{
			logger.info("VerifyBuyProduct - Failed");
			captureScreenshot(driver,"VerifyBuyProduct");
			Assert.assertTrue(false);

		} 

		logger.info("***************TestCase BuyProduct ends*****************"); 

	}


	@Test(enabled = true)
	public void verifyAddToWishlistWithoutLogin() throws IOException
	{
		logger.info("\n***************TestCase verifyAddToWishlistWithoutLogin started*****************"); 

		IndexPage indexPage = new IndexPage(driver);
		indexPage.clickOnTShirtMenu();

		ProductPage prodPage = new ProductPage(driver);
		prodPage.mouseOverOnTshirtProduct();

		prodPage.clickOnAddToCompare();

		prodPage.clickOnCompare();
		
		String actualMsg = prodPage.checkTextIsPresent();
		String expectedMsg = "Share this comparison with your friends:";

		if(actualMsg.equals(expectedMsg))
		{
			logger.info("checkTextIsPresent - passed"); 
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("checkTextIsPresent - failed"); 
			captureScreenshot(driver,"checkTextIsPresent");
			Assert.assertTrue(false);
		}
		
		prodPage.clickOnContinueShopping();

		

	}
}
