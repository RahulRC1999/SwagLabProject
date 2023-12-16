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
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class CheckoutPage1_Test extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	CheckoutPage1 check1;
	
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
	}
	
	@Test(enabled=true, priority=1)
	public void VerifyURLofCheckOutPage1Test()
	{
		String expURL = "https://www.saucedemo.com/checkout-step-one.html";
		String actURL = check1.VerifyURLofCheckOutPage1();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of CheckOutPage1 :- "+actURL);
	}
	
	@Test(enabled=true, priority=2)
	public void VerifyCheckOutPage1TitleTest()
	{
		String expTitle = "Checkout: Your Information";
		String actTitle = check1.VerifyCheckOutPage1Title();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of CheckOutPage1 :- "+actTitle);
	}
	
	@Test(enabled=true, priority=3)
	public void InformationCheckOutPage1Test() throws InterruptedException
	{
		String expInfo = "https://www.saucedemo.com/checkout-step-two.html";
		String actInfo = check1.InformationCheckOutPage1();
		Assert.assertEquals(expInfo, actInfo);
		Reporter.log("Information Field of CheckOutPage1 :- "+actInfo);
	}
	
	@Test(enabled=true, priority=4)
	public void WithoutInformationTest() throws InterruptedException
	{
		String expError = "Error: First Name is required";
		String actError = check1.WithoutInformation();
		Assert.assertEquals(expError, actError);
		Reporter.log("Error Message without field information :- "+actError);
	}

	@SuppressWarnings("static-access")
	@AfterMethod
	public void closeBrowser(ITestResult it) throws IOException
	{
		if (it.FAILURE == it.getStatus()) 
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
