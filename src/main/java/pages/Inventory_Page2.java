package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;
import utility.HandleDropdownList;

public class Inventory_Page2 extends TestBase
{	
	//object repository
	@FindBy(xpath = "//span[@class='shopping_cart_badge']") private WebElement CartCount;
	@FindBy(xpath = "//span[@class='title']") private WebElement productsLable;
	@FindBy(xpath = "//select[@class='product_sort_container']") private WebElement dropDown;
	@FindBy(xpath = "//button[@id='react-burger-menu-btn']") private WebElement openMenuBtn;
	@FindBy(xpath = "//div[@class='footer_copy']") private WebElement footerText;
	//Logo Element
	@FindBy(xpath = "//div[@class='app_logo']") private WebElement appLogo;
	@FindBy(xpath = "//a[text()='Twitter']") private WebElement twitterLogo;
	@FindBy(xpath = "//a[text()='Facebook']") private WebElement facebookLogo;
	@FindBy(xpath = "//a[text()='LinkedIn']") private WebElement linkedInLogo;
	//Product Text
	@FindBy(xpath = "//div[text()='Sauce Labs Backpack']") private WebElement BackpackText;
	@FindBy(xpath = "//div[text()='Sauce Labs Bike Light']") private WebElement BikeLightText;
	@FindBy(xpath = "//div[text()='Sauce Labs Bolt T-Shirt']") private WebElement BoltTShirtText;
	@FindBy(xpath = "//div[text()='Sauce Labs Fleece Jacket']") private WebElement JacketText;
	@FindBy(xpath = "//div[text()='Sauce Labs Onesie']") private WebElement OnesieText;
	@FindBy(xpath = "//div[text()='Test.allTheThings() T-Shirt (Red)']") private WebElement TShirtRedText;
	
	//Element Added
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']") private WebElement backpackProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']") private WebElement bikeLightProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']") private WebElement shirtProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']") private WebElement jacketProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']") private WebElement onesieProduct;
	@FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']") private WebElement shirtRedProduct;
	
	//Element Remove
	@FindBy(xpath = "//button[@id='remove-sauce-labs-backpack']") private WebElement removeBackpackProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bike-light']") private WebElement removeBikeLightProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-bolt-t-shirt']") private WebElement removeShirtProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-fleece-jacket']") private WebElement removeJacketProduct;
	@FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']") private WebElement removeOnesieProduct;
	@FindBy(xpath = "//button[@id='remove-test.allthethings()-t-shirt-(red)']") private WebElement removeShirtRedProduct;
	 
	//Product Details
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[1]") private WebElement productText1;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[2]") private WebElement productText2;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[3]") private WebElement productText3;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[4]") private WebElement productText4;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[5]") private WebElement productText5;
	@FindBy(xpath = "(//div[@class='inventory_item_desc'])[6]") private WebElement productText6;
	


	public Inventory_Page2()
	{
		PageFactory.initElements(driver, this);
	}

	public String verifyproductsLable()
	{
		return productsLable.getText();
	}

	public boolean verifytwitterLogo()
	{
		return twitterLogo.isDisplayed();
	}
	
	public boolean verifyfacebookLogo()
	{
		return facebookLogo.isDisplayed();
	}
	
	public boolean verifylinkedInLogo()
	{
		return linkedInLogo.isDisplayed();
	}
	
	public boolean verifyappLogo()
	{
		return appLogo.isDisplayed();
	}
	
	public String verifyopenMenuBtn()
	{
		openMenuBtn.click();
		return openMenuBtn.getText();	
	}

	public boolean verifyFooterText()
	{
		return footerText.isDisplayed();
	}
	
	public String verifyBackpackText()
	{
		return BackpackText.getText();
	}
	
	public String verifyBikeLightText()
	{
		return BikeLightText.getText();
	}
	
	public String verifyBoltTShirtText()
	{
		return BoltTShirtText.getText();
	}
	
	public String verifyJacketText()
	{
		return JacketText.getText();
	}
	
	public String verifyOnesieText()
	{
		return OnesieText.getText();
	}
	
	public String verifyTShirtRedText()
	{
		return TShirtRedText.getText();
	}
	
	public String add6Products() throws InterruptedException 
	{
		HandleDropdownList.handleSelectClass(dropDown, "Price (low to high)");
		backpackProduct.click();
		bikeLightProduct.click();
		shirtProduct.click();
		jacketProduct.click();
		onesieProduct.click();
		shirtRedProduct.click();
		Thread.sleep(2000);
		return CartCount.getText();
	}
	
	public String removeProducts() throws InterruptedException
	{
		add6Products();
		removeBackpackProduct.click();
		removeBikeLightProduct.click();
		removeOnesieProduct.click();
		removeShirtRedProduct.click();
		Thread.sleep(2000);
		return CartCount.getText();
	}
	
	public boolean verifyproductText1()
	{
		return productText1.isDisplayed();
	}
	
	public boolean verifyproductText2()
	{
		return productText2.isDisplayed();
	}
	
	public boolean verifyproductText3() 
	{
		return productText3.isDisplayed();
	}
	
	public boolean verifyproductText4()
	{
		return productText4.isDisplayed();
	}
	
	public boolean verifyproductText5()
	{
		return productText5.isDisplayed();
	}
	
	public boolean verifyproductText6()
	{
		return productText6.isDisplayed();
	}
	
	
}
