package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage
{

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Web Elements
	@FindBy(xpath="//ul[@class='breadcrumb']//a[normalize-space()='Shopping Cart']") WebElement shoppingCartPageHeading;
	
	@FindBy(xpath="//div[@class='table-responsive']//table/tbody/tr[1]/td[2]/a") WebElement addedItem;
	
	//actions
	
	public String validateShoppingCartPage()
	{
		return shoppingCartPageHeading.getText();
	}
	
	public String ValidateAddedItem()
	{
		return addedItem.getText();
	}
	
}
