package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage
{
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Web Elements Initialization 
	@FindBy(xpath="//h2[text()='New Customer']") WebElement newCustHeader;
	
	@FindBy(xpath="//h2[text()='Returning Customer']") WebElement returnCustHeader;
	
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	
	@FindBy(xpath="//input[@value='Login']") WebElement btnLogin;
	
	//actions
	public boolean isNewCustHeaderExist()
	{
		try {
			return newCustHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isReturnCustHeaderExist()
	{
		try {
			return returnCustHeader.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void loginToApp(String email, String password)
	{
		setEmail(email);
		setPassword(password);
		clickLogin();
	}
}
