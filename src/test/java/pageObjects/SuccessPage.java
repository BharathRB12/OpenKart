package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage
{

	public SuccessPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']/li[4]/a") WebElement headerSuccessPage;
	
	@FindBy(xpath="//div[@id='content']/h1") WebElement orderSuccessMessage;
	
	@FindBy(xpath="//a[text()='Continue']") WebElement btnContinue;
	
	public String getSuccessPageHeader()
	{
		waitForVisibility(headerSuccessPage);
		return headerSuccessPage.getText();
	}
	
	public String getSuccessMessage()
	{
		waitForVisibility(orderSuccessMessage);
		return orderSuccessMessage.getText();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
	}

}
