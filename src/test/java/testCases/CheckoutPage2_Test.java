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
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class CheckoutPage2_Test extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	CheckoutPage2 check2;
	
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
	}
	
	@Test(enabled=true, priority = 1)
	public void VerifyURLofChekoutPage2Test()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-two.html";
		String actURL = check2.VerifyURLofChekoutPage2();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of CheckoutPage2 :- "+actURL);
	}
	
	@Test(enabled=true, priority = 2)
	public void VerifyCheckoutPage2TitleTest() 
	{
		String expTitle = "Checkout: Overview";
		String actTitle = check2.VerifyCheckoutPage2Title();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of CheckoutPage2 :- "+actTitle);
	}
	
	@Test (enabled = true, priority = 3)
	public void VerifyPaymentInfoLableTest()
	{
		String expPay = "Payment Information";
		String actPay = check2.VerifyPaymentInfoLable();
		Assert.assertEquals(expPay, actPay);
		Reporter.log("Payment Informatin of CheckoutPage2 :- "+actPay);
	}
	
	@Test (enabled = true, priority=4)
	public void VerifyShippingInfoLableTest()
	{
		String expShip = "Shipping Information";
		String actShip = check2.VerifyShippingInfoLable();
		Assert.assertEquals(expShip, actShip);
		Reporter.log("Shipping Information of CheckoutPage2 :- "+actShip);
	}
	
	@Test (enabled = true, priority=5)
	public void VerifyTotalPriceLableTest()
	{
		String expPrice = "Price Total";
		String actPrice = check2.VerifyTotalPriceLable();
		Assert.assertEquals(expPrice, actPrice);
		Reporter.log("Price Total of CheckoutPage2 :- "+actPrice);
	}
	
	@Test (enabled = true, priority = 6)
	public void VerifyCancelBtnTest()
	{
		String expCancel = "Cancel";
		String actCancel = check2.VerifyCancelBtn();
		Assert.assertEquals(expCancel, actCancel);
		Reporter.log("Cancel Button of CheckOutPage1 :- "+actCancel);
	}
	
	@Test (enabled = true, priority = 7)
	public void VerifyFinishBtnTest()
	{
		String expBtn = "https://www.saucedemo.com/checkout-complete.html";
		String actBtn = check2.VerifyFinishBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("Finish Button of CheckOutPage2 :- "+actBtn);
	}
	
	@Test (enabled = true, priority = 8)
	public void VefiyTotalFinalPriceTest()
	{
		boolean Total = check2.VefiyTotalFinalPrice();
		Assert.assertEquals(Total, true);
		Reporter.log("Total Final Price of CheckOutPage2 :- "+Total);
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
