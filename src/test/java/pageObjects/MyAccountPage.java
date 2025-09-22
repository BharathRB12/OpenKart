package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//WebElements Initialization
	@FindBy (xpath="//div[@id='content']/h2[1]") WebElement myAccPageHeader;
	@FindBy (xpath="//div[@class='list-group']//a[normalize-space()='Logout']") WebElement btnLogout;
	
	
	//Actions
	public boolean isMyAccountPageExist()
	{
		waitForVisibility(myAccPageHeader);
		return myAccPageHeader.isDisplayed();
	}
	
	public String getMyAccountPageHeader()
	{
		waitForVisibility(myAccPageHeader);
		return myAccPageHeader.getText();
	}
	
	public void clickLogout()
	{
		btnLogout.click();
	}
}
