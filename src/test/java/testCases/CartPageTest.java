package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;
import pages.CartPage;
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;

public class CartPageTest extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	CartPage cart;
	
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
	}
	
	@Test(enabled=true, priority=1)
	public void VerifyshoppingCartPageTest()
	{
		boolean Cart = cart.VerifyshoppingCartPage();
		Assert.assertEquals(Cart, true);
		Reporter.log("Shopping Cart of Inventory Page :- "+Cart);
	}
	
	@Test(enabled=true, priority=2)
	public void VerifyURLofCartPageTest() throws EncryptedDocumentException, IOException
	{
		String expURL = "https://www.saucedemo.com/cart.html"; //ReadData.readExcel(1, 2);
		String actURL = cart.VerifyURLofCartPage();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("URL of Your Cart :- "+actURL);
	}
	
	@Test(enabled=true, priority=3)
	public void verifyCartPageTitle() throws EncryptedDocumentException, IOException
	{
		String expTitle = "Your Cart"; //ReadData.readExcel(1, 3);
		String actTitle = cart.verifyCartPageTitle();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Title of Your Cart :- "+actTitle);
	}
	
	@Test(enabled=true, priority=4)
	public void verifyCartQTYLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable = "QTY";	//ReadData.readExcel(1, 4);
		String actLable = cart.verifyCartQTYLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Visibility of Cart Page QTY Lable :- "+actLable);
	}
	
	@Test(enabled=true, priority=5)
	public void verifyCartDescriptionLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable = "Description";	//ReadData.readExcel(1, 5);
		String actLable = cart.verifyCartDescriptionLable();
		Assert.assertEquals(expLable, actLable);
		Reporter.log("Visibility of Cart Page Description Lable :- "+actLable);
	}
	
	@Test(enabled=true, priority=6)
	public void verifyContinueShoppingCartBtnTest() throws EncryptedDocumentException, IOException
	{
		String expBtn = "Continue Shopping";	//ReadData.readExcel(1, 6);
		String actBtn = cart.verifyContinueShoppingCartBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("Continue Shopping Button of Cart Page :- "+actBtn);
	}
	
	@Test(enabled=true, priority=7)
	public void verifyCartCheckOutBtnTest()
	{
		String expBtn = "Checkout"; // Checkout
		String actBtn = cart.verifyCartCheckOutBtn();
		Assert.assertEquals(expBtn, actBtn);
		Reporter.log("CheckOut Button of Cart Page :- "+actBtn);
	}
	
	@Test(enabled=true, priority=8)
	public void VerifyURLofCheckOutPageTest() throws EncryptedDocumentException, IOException
	{
		String expurl = "https://www.saucedemo.com/checkout-step-one.html"; //ReadData.readExcel(0, 2); 
		String acturl = cart.VerifyURLofCheckOutPage();
		Assert.assertEquals(expurl, acturl);
	}
	
	@Test(enabled=true, priority=9)
	public void verifyCartTwitterLogoTest()
	{
		boolean twitter = cart.verifyCartTwitterLogo();
		Assert.assertEquals(twitter, true);
		Reporter.log("Twitter Log of Cart Page :- "+twitter);
	}
	
	@Test(enabled=true, priority=10)
	public void verifyCartFacebookLogoTest()
	{
		boolean facebook = cart.verifyCartFacebookLogo();
		Assert.assertEquals(facebook, true);
		Reporter.log("Facebook Log of Cart Page :- "+facebook);
	}
	
	@Test(enabled=true, priority=11)
	public void verifyCartLinkedInLogoTest()
	{
		boolean linkedIn = cart.verifyCartLinkedInLogo();
		Assert.assertEquals(linkedIn, true);
		Reporter.log("LinkedIn Logo of Cart page :- "+linkedIn);
	}
	
	@Test(enabled=true, priority=12)
	public void verifyCart3linesTest()
	{
		boolean lines = cart.verifyCart3lines();
		Assert.assertEquals(lines, true);
		Reporter.log("Visibility of Cart Page OpenMenu :- "+lines);
	}
		
	@Test(enabled=true, priority=13)
	public void verifyFooterTxtCartPageTest()
	{
		boolean txt = cart.verifyFooterTxtCartPage();
		Assert.assertEquals(txt, true);
		Reporter.log("Footer Text of Cart Page :- "+txt);
	}
	
	@Test(enabled=true, priority=14)
	public void remove3ProductCartPageTest() throws InterruptedException
	{
		String exp = "3";
		String act = cart.remove3ProductCartPage();
		Assert.assertEquals(exp, act);
		Reporter.log("Remove Product of Cart Page :- "+act);
	}
	
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
