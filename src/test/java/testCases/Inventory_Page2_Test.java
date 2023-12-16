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
import pages.Inventory_Page2;
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class Inventory_Page2_Test extends TestBase
{
	LoginPage login;
	Inventory_Page2 invent;
	
	@BeforeMethod(alwaysRun = true)
	public void setup() throws IOException, InterruptedException
	{
		initilazation();
		login = new LoginPage();
		invent = new Inventory_Page2();
		login.loginOfApplication();
	}
	
	@Test(enabled=true,priority=1, groups = "Sanity")
	public void verifyproductsLableTest() throws EncryptedDocumentException, IOException
	{
		String expLable = ReadData.readExcel(0, 3);	//"Products"; (0,3);
		String actLable = invent.verifyproductsLable();
		Assert.assertEquals(expLable,actLable);
		Reporter.log("Lable of Inventory Page :- "+actLable);
	}
	
	@Test(enabled = true, priority =19, groups = "Retesting")
	public void verifytwitterLogoTest()
	{
		boolean logo1 = invent.verifytwitterLogo();
		Assert.assertEquals(logo1, true);
		Reporter.log("Visibility of Twitter Logo :- "+logo1);
	}
	
	@Test (enabled = true, priority = 2, groups = "Retesing")
	public void verifyfacebookLogoTest()
	{
		boolean logo2 = invent.verifyfacebookLogo();
		Assert.assertEquals(logo2, true);
		Reporter.log("Visibility of Facebook Logo :- "+logo2);
	}
	
	@Test (enabled = true, priority = 3, groups = {"Sanity","Retesting"})
	public void verifylinkedInLogoTest()
	{
		boolean logo3 = invent.verifylinkedInLogo();
		Assert.assertEquals(logo3, true);
		Reporter.log("Visibility of LinkedIn Logo :- "+logo3);
	}
	
	@Test (enabled = true, priority = 4)
	public void verifyappLogoTest()
	{
		boolean logo4 = invent.verifyappLogo();
		Assert.assertEquals(logo4, true);
		Reporter.log("Title of Inventory Page :- "+logo4);
	}
	
	@Test (enabled = true, priority = 5)
	public void verifyopenMenuBtnTest() throws EncryptedDocumentException, IOException
	{
		String expMenu = ReadData.readExcel(0, 4);	//"Open Menu";
		String actMenu = invent.verifyopenMenuBtn();
		Assert.assertEquals(expMenu, actMenu);
		Reporter.log("Visibility of Open Menu Logo :- "+actMenu);
	}
	
	@Test (enabled = true, priority = 6, groups = "Regression")
	public void verifyFooterTextTest()
	{
		boolean footerText  = invent.verifyFooterText();
		Assert.assertEquals(footerText, true);
		Reporter.log("Footer text for Swag Labs :- "+footerText);
	}
	
	@Test (enabled = true, priority = 7, groups = {"Retesting","Regression"})
	public void add6ProductsTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expCount = ReadData.readExcel(0, 5);	//"6";
		String actCount = invent.add6Products();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Total Products add to cart :- "+actCount);
	}
	
	@Test(enabled = true, priority = 20, groups = {"Retesting","Regression"})
	public void removeProductsTest() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String expCount = ReadData.readExcel(0, 6);	//"2";
		String actCount = invent.removeProducts();
		Assert.assertEquals(expCount, actCount);
		Reporter.log("Count for Remove Products :- "+actCount);
	}
	
	@Test(enabled = true, priority = 8)
	public void verifyBackpackTextTest()
	{
		String expText1 = "Sauce Labs Backpack";
		String actText1 = invent.verifyBackpackText();
		Assert.assertEquals(expText1, actText1);
		Reporter.log("Visibility of Backpack Product :- "+actText1);
	}
	
	@Test
	public void verifyBikeLightTextTest()
	{
		String expText2 = "Sauce Labs Bike Light";
		String actText2 = invent.verifyBikeLightText();
		Assert.assertEquals(expText2, actText2);
		Reporter.log("Visibility of BikeLight Product :- "+actText2);
	}
	
	@Test(enabled = true, priority = 9)
	public void verifyBoltTShirtTextTest()
	{
		String expText3 = "Sauce Labs Bolt T-Shirt";
		String actText3 = invent.verifyBoltTShirtText();
		Assert.assertEquals(expText3, actText3);
		Reporter.log("Visibility of BoltTShirt Product :- "+actText3);
	}
	
	@Test(enabled = true, priority = 10)
	public void verifyJacketTextTest()
	{
		String expText4 = "Sauce Labs Fleece Jacket";
		String actText4 = invent.verifyJacketText();
		Assert.assertEquals(expText4, actText4);
		Reporter.log("Visibility of Jacket Product :- "+actText4);
	}
	
	@Test(enabled = true, priority = 11)
	public void verifyOnesieTextTest()
	{
		String expText5 = "Sauce Labs Onesie";
		String actText5 = invent.verifyOnesieText();
		Assert.assertEquals(expText5, actText5);
		Reporter.log("Visibility of Onesie Product :- "+actText5);
	}
	
	@Test(enabled = true, priority = 12)
	public void verifyTShirtRedTextTest() 
	{
		String expText6 = "Test.allTheThings() T-Shirt (Red)";
		String actText6 = invent.verifyTShirtRedText();
		Assert.assertEquals(expText6, actText6);
		Reporter.log("Visibility of T-Shirt Red :- "+actText6);
	}
	
	@Test(enabled = true, priority = 13)
	public void verifyproductstext1Test()
	{
		boolean text = invent.verifyproductText1();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text1 :- " +text);
	}
	
	@Test(enabled = true, priority = 14)
	public void verifyproductText2Test()
	{
		boolean text = invent.verifyproductText2();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text2 :- "+text);
	}
	
	@Test(enabled=true, priority=15)
	public void verifyproductText3Test()
	{
		boolean text = invent.verifyproductText3();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text3 :- "+text);
	}
	
	@Test(enabled=true, priority=16)
	public void verifyproductText4Test()
	{
		boolean text = invent.verifyproductText4();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text4 :- "+text);
	}
	
	@Test(enabled=true, priority=17)
	public void verifyproductText5Test()
	{
		boolean text = invent.verifyproductText5();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text5 :- "+text);
	}
	
	@Test(enabled=true, priority=18)
	public void verifyproductText6Test()
	{
		boolean text = invent.verifyproductText6();
		Assert.assertEquals(text, true);
		Reporter.log("Visibility of Product Text6 :- "+text);
	}
	
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult itr) throws IOException
	{
		if (itr.FAILURE==itr.getStatus())
		{
			CaptureScreenshot.screenshot(itr.getName());
		}
		driver.close();
	}
}
