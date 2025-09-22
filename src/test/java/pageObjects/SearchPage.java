package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Web Element Initialization
	
	
	@FindBy(xpath="(//div[contains(@class,'product-layout product-grid col-lg')])[1]//button[1]") WebElement firstElmtAddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	
	@FindBy(xpath="//div[@id='cart']/button") WebElement cartButton;
	
	@FindBy(xpath="//p[@class='text-right']/a[1]") WebElement LnkviewCart;
	
	//Actions
	
	public void clickAddToCart()
	{
		waitForElementToBeClickable(firstElmtAddToCart);
		firstElmtAddToCart.click();
	}
	
	public boolean verifyAddToCartSuccessMsg()
	{
		waitForVisibility(successMessage);
		return successMessage.isDisplayed();
	}
	
	public void clickCartBtn()
	{
		waitForVisibility(cartButton);
		cartButton.click();
	}
	
	public void clickViewCart()
	{
		LnkviewCart.click();
	}
}
