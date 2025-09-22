package pageObjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPage extends BasePage
{

	public ShoppingCartPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Web Elements
	
	@FindBy(xpath="//div[@class='table-responsive']/table/tbody/tr/td[2]/a") List<WebElement> addedItemIntableList;
	
	@FindBy(xpath="//input[contains(@name,'quantity')]/..//button[@data-original-title='Remove']") WebElement btnRemove;
	
	@FindBy(xpath="//div[@class='table-responsive']//table/tbody/tr[1]/td[last()]") WebElement ItemTotalprice;
	
	@FindBy (xpath="//div[@class='buttons clearfix']//a[normalize-space()='Checkout']") WebElement btnCheckOut;
	
	private final By emptyMsg = By.xpath("//div[@id='content']/p");

	
	//actions
	public ArrayList<String> getAddedItemInList()
	{
		ArrayList<String> arlst=new ArrayList<>();
		for(WebElement ele:addedItemIntableList)
		{
			String item=ele.getText();
			arlst.add(item);
		}
		return arlst;
	}
	
	public String getTotalPrice()
	{
		return ItemTotalprice.getText();
	}
	
	public void clickRemove()
	{
		btnRemove.click();
	}
	
	public void clickCheckOut()
	{
		btnCheckOut.click();
	}
	
	public String emptySCartMsg(String message)
	{
		wait.until(ExpectedConditions.textToBe(emptyMsg, message));
		wait.until(ExpectedConditions.visibilityOfElementLocated(emptyMsg));
	    return driver.findElement(emptyMsg).getText();
	}
	

}
