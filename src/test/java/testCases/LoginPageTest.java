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
import pages.LoginPage;
import utility.CaptureScreenshot;
import utility.ReadData;

public class LoginPageTest extends TestBase
{
	LoginPage login;
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException, IOException
	{
		initilazation();
		login = new LoginPage();
	}
	
	@Test (priority = 1, enabled = true, groups = "Sanity")
	public void verifyTitleOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expTitle = ReadData.readExcel(0, 1); //"Swag Labs"; (0, 1);
		String actTitle = login.verifyTitleOfApplication();
		Assert.assertEquals(expTitle, actTitle);
		Reporter.log("Visibility of Title :- "+actTitle);
	}
	
	@Test (priority = 3,enabled=true, groups = {"Sanity","Retesting"})
	public void verifyURLOfApplicationTest() throws EncryptedDocumentException, IOException
	{
		String expURL = ReadData.readExcel(0, 0);	//"https://www.saucedemo.com/";
		String actURL = login.verifyURLOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Visibility of URL1 :- "+actURL);
	}
	
	@Test (priority = 2 ,enabled=true, groups = "Regression")
	public void loginOfApplicationTest() throws IOException
	{
		String expURL = ReadData.readExcel(0, 2); //"https://www.saucedemo.com/inventory.html";
		String actURL = login.loginOfApplication();
		Assert.assertEquals(expURL, actURL);
		Reporter.log("Visibility of URL2 :- "+actURL);
	}

	@SuppressWarnings("static-access")
	@AfterMethod(alwaysRun = true)
	public void closeBrowser(ITestResult it) throws IOException
	{
		if (it.FAILURE==it.getStatus()) 
		{
			CaptureScreenshot.screenshot(it.getName());
		}
		report.flush();
		driver.close();
	}
}
