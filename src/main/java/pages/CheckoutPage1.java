package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.TestBase;

public class CheckoutPage1 extends TestBase
{
	@FindBy(xpath = "//span[@class='title']") private WebElement CheckOut1Title;
	@FindBy(xpath = "//input[@name='firstName']") private WebElement firstNameTxtBox;
	@FindBy(xpath = "//input[@name='lastName']") private WebElement lastNameTxtBox;
	@FindBy(xpath = "//input[@name='postalCode']") private WebElement zipCodeTxtBox;
	@FindBy(xpath = "//input[@name='continue']") private WebElement continueBtn;
	//Error Message Without input information
	@FindBy(xpath = "//h3[@data-test='error']") private WebElement errorMessage;
	
	
	public CheckoutPage1()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyURLofCheckOutPage1()
	{
		return driver.getCurrentUrl();
	}
	
	public String VerifyCheckOutPage1Title()
	{
		return CheckOut1Title.getText();
	}
	
	public String InformationCheckOutPage1() throws InterruptedException
	{
		logger=report.createTest("Checkout to Sauce Lab Application");
		firstNameTxtBox.sendKeys("Harry");
		logger.log(Status.INFO, "First Name is entered");
		lastNameTxtBox.sendKeys("Potter");
		logger.log(Status.INFO, "Last Name is entered");
		zipCodeTxtBox.sendKeys("445204");
		logger.log(Status.INFO, "Zip Code is entered");
		Thread.sleep(2000);
		logger.log(Status.PASS, "Password is entered");
		continueBtn.click();
		Thread.sleep(4000);
		return driver.getCurrentUrl();
	}

	public String WithoutInformation() throws InterruptedException
	{
		continueBtn.click();
		Thread.sleep(2000);
		return errorMessage.getText();
	}
}
