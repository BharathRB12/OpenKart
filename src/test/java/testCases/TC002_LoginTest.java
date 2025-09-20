package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass
{
	@Test(groups= {"Sanity", "Master"})
	public void verify_login()
	{
		logger.info("*** Starting TC002_LoginTest ***");
		try {
			//Home page
			HomePage hp=new HomePage(driver);
			logger.info("Verifying Home page logo");
			boolean homePageLogo=hp.isLogoDisplayed();
			Assert.assertEquals(homePageLogo, true, "Logo is not displayed");
			logger.info("Click on My Account link");
			hp.clickMyAccount();
			logger.info("Click on Login link");
			hp.clickLogin();
			
			//Login page
			LoginPage lp=new LoginPage(driver);
			logger.info("Verifying New Customer Header is present");
			boolean newCustHeader=lp.isNewCustHeaderExist();
			Assert.assertEquals(newCustHeader, true, "New Customer Header is not displayed");
			logger.info("Verifying Returning Customer Header is present");
			boolean returnCustHeader=lp.isReturnCustHeaderExist();
			Assert.assertEquals(returnCustHeader, true, "Returning Customer Header is not displayed");
			logger.info("Providing Login Credentials");
			lp.setEmail(pr.getProperty("email"));
			lp.setPassword(pr.getProperty("password"));
			lp.clickLogin();
			
			//My Account Page
			MyAccountPage map=new MyAccountPage(driver);
			logger.info("validating My Account page header");
			String targetPageHeader=map.getMyAccountPageHeader();
			Assert.assertEquals(targetPageHeader, pr.getProperty("myAccountPageHeading"), "My Account page is not displayed");
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Ending TC002_LoginTest ***");
	}
}
