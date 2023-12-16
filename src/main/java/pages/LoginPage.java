package pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;
import utility.ReadData;

public class LoginPage extends TestBase
{
	@FindBy(xpath = "//input[@name='user-name']") private WebElement userTxtBox;
	@FindBy(xpath = "//input[@name='password']") private WebElement passwordTxtBox;
	@FindBy(xpath = "//input[@name='login-button']") private WebElement loginBtn;
	
	public LoginPage() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String loginOfApplication() throws IOException
	{
		logger=report.createTest("Login to Sauce Lab Application");
		userTxtBox.sendKeys(ReadData.readExcel(1, 0)); //(ReadData.readPropertyFile(ReadData.readExcel(1, 0)));
		logger.log(Status.INFO, "User Name is entered");
		passwordTxtBox.sendKeys(ReadData.readExcel(1, 1)); //(ReadData.readPropertyFile(ReadData.readExcel(1, 1)));
		logger.log(Status.INFO, "Password is entered");
		loginBtn.click();
		logger.log(Status.INFO, "Login Button is Clicked");
		logger.log(Status.PASS, "Login is Successful");
		return driver.getCurrentUrl();
	}
	
	public String loginToAppWithMultiCreds(String uname, String pass)
	{
		userTxtBox.sendKeys(uname);
		passwordTxtBox.sendKeys(pass);
		loginBtn.click();
		return driver.getCurrentUrl();
	}
	
	public String verifyTitleOfApplication()
	{
		return driver.getTitle();
	}
	
	public String verifyURLOfApplication() 
	{
		return driver.getCurrentUrl();
	}
	
}
