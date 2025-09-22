package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass
{
	@Test(groups= {"Regression", "Master"})
	public void verify_Account_Registration()
	{
		logger.info("*** Stating TC001_AccountRegistrationTest ***");
		try
		{
		HomePage hp=new HomePage(driver);
		String expHPTitle=pr.getProperty("homePageTitle");
		String hpTitle=hp.getPageTitle(expHPTitle);
		Assert.assertEquals(hpTitle, expHPTitle);
		logger.info("Verified Logo is present in homepage");
		Assert.assertEquals(hp.isLogoDisplayed(), true);
		logger.info("Clicked on My Account Button");
		hp.clickMyAccount();
		logger.info("Clicked on Register button");
		hp.clickRegister();
		
		AccountRegistrationPage regpage=new AccountRegistrationPage(driver);
		logger.info("Validating Registration Account page header");
		String expRegTitle= pr.getProperty("registerPageTitle");
		String regTitle=regpage.getPageTitle(expRegTitle);
		Assert.assertEquals(regTitle, expRegTitle);
		Assert.assertEquals(regpage.getHeadingText(), "Register Account");
		logger.info("Providing the customer details for Registration");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomAlpaNumeric()+"@gmail.com");
		regpage.setTelephone(randomNumber());
		
		//fetching password from base class and storing
		String password=randomAlpaNumeric();
		regpage.setPassword(password);
		regpage.confirmPassword(password);
		regpage.setPrivacyPolicy();
		regpage.clickContinue();
		logger.info("Validating Expected Message..");
		String confmsg=regpage.getConfirmationMsg();
		Assert.assertEquals(confmsg, pr.getProperty("accCreatedSuccessMsg"));	
		}	
		catch(Exception e)
		{
			logger.error("Test failed..");
			logger.debug("Debug logs..");
			Assert.fail();
		}
		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}	
}
