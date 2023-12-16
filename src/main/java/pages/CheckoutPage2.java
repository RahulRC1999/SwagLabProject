package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CheckoutPage2 extends TestBase
{
	@FindBy(xpath = "//span[@class='title']") private WebElement CheckoutPage2Title;
	@FindBy(xpath = "//div[text()='Payment Information']") private WebElement PaymentInfoLable;
	@FindBy(xpath = "//div[text()='Shipping Information']") private WebElement ShippingInfoLable;
	@FindBy(xpath = "//div[text()='Price Total']") private WebElement TotalPriceLable;
	@FindBy(xpath = "//button[@id='cancel']") private WebElement CancelBtn;
	@FindBy(xpath = "//button[@id='finish']") private WebElement FinishBtn;
	@FindBy(xpath = "//div[@class='summary_info_label summary_total_label']") private WebElement FinalPrice;
	
	public CheckoutPage2()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyURLofChekoutPage2()
	{
		return driver.getCurrentUrl();
	}
	
	public String VerifyCheckoutPage2Title()
	{
		return CheckoutPage2Title.getText();
	}
	
	public String VerifyPaymentInfoLable()
	{
		return PaymentInfoLable.getText();
	}
	
	public String VerifyShippingInfoLable()
	{
		return ShippingInfoLable.getText();
	}
	
	public String VerifyTotalPriceLable()
	{
		return TotalPriceLable.getText();
	}
	
	public String VerifyCancelBtn()
	{
		return CancelBtn.getText();
	}
	
	public String VerifyFinishBtn()
	{
		FinishBtn.click();
		return driver.getCurrentUrl();
	}
	
	public boolean VefiyTotalFinalPrice()
	{
		return FinalPrice.isDisplayed();
	}
}
