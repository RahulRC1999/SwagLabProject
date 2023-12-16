package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class CartPage extends TestBase
{
	//Cart Page
	@FindBy(xpath = "//span[@class='title']") private WebElement yourCartTitle;
	@FindBy(xpath = "//div[@class='cart_quantity_label']") private WebElement CartQTYLable;
	@FindBy(xpath = "//div[@class='cart_desc_label']") private WebElement CartDescriptionLable;
	@FindBy(xpath = "//button[@name='continue-shopping']") private WebElement Continue_Shopping;
	@FindBy(xpath = "//button[@name='checkout']") private WebElement CheckOutBtn;
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement Cart3lines;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement FooterTxt;
	
	// CartPage Logo
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement CartTwitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement CartFacebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement CartLinkedInLogo;
	
	//Remove Element
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackpackCart;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLightCart;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeShirtCart;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement CartCount;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement shoppingCart;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	
	public CartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifyshoppingCartPage()
	{
		shoppingCart.click();
		return shoppingCart.isDisplayed();
	}
	
	public String VerifyURLofCartPage()
	{
		return driver.getCurrentUrl();
	}
	
	public String verifyCartPageTitle()
	{
		return yourCartTitle.getText();
	}
	
	public String verifyCartQTYLable()
	{
		return CartQTYLable.getText();
	}
	
	public String verifyCartDescriptionLable()
	{
		return CartDescriptionLable.getText();
	}
	
	public String verifyContinueShoppingCartBtn()
	{
		return Continue_Shopping.getText();	
	}
	
	public String verifyCartCheckOutBtn() 
	{
		return CheckOutBtn.getText();
	}
	
	public String VerifyURLofCheckOutPage()
	{
		CheckOutBtn.click();
		return driver.getCurrentUrl();
	}
	
	public boolean verifyCartTwitterLogo()
	{
		return CartTwitterLogo.isDisplayed();
	}
	
	public boolean verifyCartFacebookLogo()
	{
		return CartFacebookLogo.isDisplayed();
	}
	
	public boolean verifyCartLinkedInLogo()
	{
		return CartLinkedInLogo.isDisplayed();
	}
	
	public boolean verifyCart3lines()
	{
		return Cart3lines.isDisplayed();
	}
	
	public boolean verifyFooterTxtCartPage()
	{
		return FooterTxt.isDisplayed();
	}
	
	public String remove3ProductCartPage() throws InterruptedException
	{
		shoppingCart.click();
		removeBackpackCart.click();
		removeBikeLightCart.click();
		removeShirtCart.click();
		Thread.sleep(2000);
		return CartCount.getText();
	}
	
}
