package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//div[@id='logo']") WebElement homePageLogo;
	
	@FindBy(xpath="//span[normalize-space()='My Account']") WebElement lnkMyAccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement lnkRegister;
	
	@FindBy(xpath="//a[normalize-space()='Login']") WebElement lnkLogin;
	
	@FindBy(xpath="//input[@name='search']") WebElement txtSearch;
	
	@FindBy(xpath="//span[@class='input-group-btn']/button") WebElement btnSearch;
	
	//actions
	
	public boolean isLogoDisplayed()
	{
		return homePageLogo.isDisplayed();
	}
	
	public void clickMyAccount()
	{
		lnkMyAccount.click();
	}
	
	public void clickRegister()
	{
		lnkRegister.click();
	}
	
	public void clickLogin()
	{
		lnkLogin.click();
	}
	
	public void setSearchTxt(String searchItem)
	{
		txtSearch.sendKeys(searchItem);
	}
	
	public void clickSearch()
	{
		btnSearch.click();
	}	
}
