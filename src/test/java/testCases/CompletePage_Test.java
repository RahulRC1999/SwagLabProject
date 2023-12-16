package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.CheckoutPage1;
import pages.CheckoutPage2;
import pages.CompletePage;
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class CompletePage_Test extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	CompletePage comp;
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException
	{
		initilazation();
		login = new LoginPage();
		login.loginOfApplication();
		invent = new Inventory_Page2();
		invent.add6Products();
		cart = new CartPage();
		cart.VerifyshoppingCartPage();
		cart.VerifyURLofCheckOutPage();
		check1 = new CheckoutPage1();	
		check1.InformationCheckOutPage1();
		check2 = new CheckoutPage2();
		check2.VerifyFinishBtn();
		comp = new CompletePage();
	}
	
	@Test (enabled = true, priority = 1)
	public void VerifyURLofCompletePage() 
	{
		String expURL = "https://www.saucedemo.com/checkout-complete.html";
		String actURL = comp.VerifyURLofCompletePage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Complete Page :- "+actURL);		
	}
	
	@Test (enabled = true, priority = 2)
	public void VerifyCompletePageTitleTest()
	{
		String expTitle = "Checkout: Complete!";
		String actTitle = comp.VerifyCompletePageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of CompletePage :- "+actTitle);
	}
	
	@Test (enabled = true, priority = 3)
	public void  VerifyImageLogoTest()
	{
		boolean Logo = comp.VerifyImageLogo();
		Assert.assertEquals(Logo, true);
		Reporter.log("Display image of CompletePage :- "+Logo);
	}
	
	@Test (enabled = true, priority = 4)
	public void VerifyThankYouMsgTest()
	{
		String expMsg = "Thank you for your order!";
		String actMsg = comp.VerifyThankYouMsg();
		Assert.assertEquals(expMsg, actMsg);
		Reporter.log("Display 'Thank you for your order!' Message of CompletePage :- "+actMsg);
	}
	
	@Test (enabled = true, priority = 5)
	public void VerifyYourOrderMsgTest()
	{
		String expMsg = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";
		String actMsg = comp.VerifyYourOrderMsg();
		Assert.assertEquals(expMsg, actMsg);
		Reporter.log("Display Your Order Message of CompletePage :- "+actMsg);
	}
	
	@Test (enabled = true, priority = 6)
	public void VerifyBackHomeBtnTest()
	{
		String expBtn = "https://www.saucedemo.com/inventory.html";
		String actBtn = comp.VerifyBackHomeBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("BackHome Button of CompletePage :- "+actBtn);
	}
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if (it.FAILURE == it.getStatus())
		{
			CaptureScreenshot.screenshot(it.getName());
		}		
		driver.close();
	}
	
}
