package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage
{
	public SearchPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Web Element Initialization
	
	@FindBy(xpath="//div[@id='content']/h1") WebElement searchPageHeading;
	
	@FindBy(xpath="//span[@id='cart-total']//text()") WebElement cartItemCount;
	
	@FindBy(xpath="(//div[contains(@class,'product-layout product-grid col-lg')])[1]//button[1]") WebElement firstElmtAddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	
	@FindBy(xpath="//div[@id='cart']/button") WebElement cartButton;
	
	@FindBy(xpath="//p[@class='text-right']/a[1]") WebElement LnkviewCart;
	
	//Actions
	
	public String verifySearchPage()
	{
		return searchPageHeading.getText();
	}
	
	public String cartItemCount()
	{
		return cartItemCount.getText();
	}
	
	public void clickAddToCart()
	{
		firstElmtAddToCart.click();
	}
	
	public boolean verifyAddToCartSuccessMsg()
	{
		return successMessage.isDisplayed();
	}
	
	public void clickCartBtn()
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		cartButton.click();
	}
	
	public void clickViewCart()
	{
		LnkviewCart.click();
	}
}
