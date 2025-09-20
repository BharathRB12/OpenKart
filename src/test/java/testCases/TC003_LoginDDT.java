package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass
{
	@Test(dataProvider="LoginData", dataProviderClass = DataProviders.class, groups= {"DataDriven"})//to link the ExcelUtility Class 
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("*** Starting TC003_LoginDDT ***");
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
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
			//My Account Page
			MyAccountPage map=new MyAccountPage(driver);
			logger.info("validating My Account page header");
			boolean targetPage=map.isMyAccountPageExist();
			
			//for logout and expected result validation
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage==true)
				{
					map.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
			
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Ending TC003_LoginDDT ***");
	}

}
