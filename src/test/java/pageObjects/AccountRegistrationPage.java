package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage
{
	//to invoke the BasePage Constructor
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h1") WebElement registerAccountHeading;
	@FindBy(xpath="//input[@id='input-firstname']") WebElement txtFirstName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement txtLastName;
	@FindBy(xpath="//input[@id='input-email']") WebElement txtEmail;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement txtTelephone;
	@FindBy(xpath="//input[@id='input-password']") WebElement txtPassword;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confmPassword;
	@FindBy(xpath="//input[@name='agree']") WebElement chkdPolicy;
	@FindBy(xpath="//input[@value='Continue']") WebElement btnContinue;
	@FindBy(xpath="//div[@id='content']/h1") WebElement msgConfirmation;
	
	//actions
	public String getHeadingText()
	{
		return registerAccountHeading.getText();
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email)
	{
		txtEmail.sendKeys(email);
	}
	
	public void setTelephone(String phoneNumber)
	{
		txtTelephone.sendKeys(phoneNumber);
	}
	
	public void setPassword(String password)
	{
		txtPassword.sendKeys(password);
	}
	
	public void confirmPassword(String password)
	{
		confmPassword.sendKeys(password);
	}
	
	public void setPrivacyPolicy()
	{
		chkdPolicy.click();
	}
	
	public void clickContinue()
	{
		btnContinue.click();
		
		/*
		btnContinue.submit();
		
		Actions act=new Actions(driver);
		act.moveToElement(btnContinue).click().perform();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", btnContinue);
		
		btnContinue.sendKeys(Keys.RETURN);
		
		WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(10));
		myWait.until(ExpectedConditions.elementToBeClickable(btnContinue)).click();
		*/
	}
	
	public String getConfirmationMsg()
	{
		try {
			return(msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}
	

}
