package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToCartPage extends BasePage {
	public AddToCartPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//ul[@class='breadcrumb']/li[2]/a")
	WebElement CartPageHeader;

	@FindBy(xpath = "//button[normalize-space()='Add to Cart']")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successMessage;
	
	@FindBy(xpath="//div[@class='btn-group btn-block']//following-sibling::button") WebElement btnGoCart;
	
	@FindBy(xpath="//p[@class='text-right']/a[1]") WebElement LnkviewCart;
	
	
	public String verifyCartPageHeader() //its a product name heading
	{
		waitForVisibility(CartPageHeader);
		return CartPageHeader.getText();
	}
	
	public void clickAddTocart()
	{
		btnAddToCart.click();
	}
	
	public boolean verifyAddToCartSuccessMsg() 
	{
		waitForVisibility(successMessage);
		return successMessage.isDisplayed();
	}
	
	public void clickGoCartButton()
	{
		waitForVisibility(btnGoCart);
		btnGoCart.click();
	}
	
	public void clickViewCart()
	{
		LnkviewCart.click();
	}
}
