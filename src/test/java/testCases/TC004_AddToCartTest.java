package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC004_AddToCartTest extends BaseClass
{
	@Test(groups={"Regression", "Master"})
	public void verifyAddToCart()
	{
		logger.info("*** Starting of TC004_AddToCartTest ***");
		try {
		HomePage hp=new HomePage(driver);
		logger.info("Verifing Home Page Logo");
		Assert.assertTrue(hp.isLogoDisplayed());
		logger.info("navigating to Login page");
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Verifing Login Page");
		Assert.assertTrue(lp.isReturnCustHeaderExist());
		String email=pr.getProperty("email");
		String password=pr.getProperty("password");
		logger.info("Providing Credentials for login");
		lp.loginToApp(email, password);
		
		
		logger.info("Seaching Item");
		String itemName=pr.getProperty("searchItem");
		hp.setSearchTxt(itemName);
		logger.info("Click on Search button");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		logger.info("Verifying Search page header");
		String spHeader=sp.verifySearchPage();
		String expHeader=pr.getProperty("searchPageHeader")+" - "+itemName;
		Assert.assertEquals(spHeader, expHeader);
		
		logger.info("Adding Item to Cart");
		sp.clickAddToCart();
		logger.info("Verifying successfull Message");
		Assert.assertTrue(sp.verifyAddToCartSuccessMsg());
		
		logger.info("Navigating to Shopping Cart Page");
		Thread.sleep(3000);
		sp.clickCartBtn();
		sp.clickViewCart();
		
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		logger.info("Validating Shopping Cart Page header");
		String targetPage=scp.validateShoppingCartPage();
		Assert.assertEquals(targetPage, pr.getProperty("shoppingCartPageHeader"));
		logger.info("Validating Added item is present or not");
		String validateItem=scp.ValidateAddedItem();
		Assert.assertEquals(validateItem, itemName);
		}
			catch(Exception e)
			{
				logger.error("Test failed..");
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}
		logger.info("*** Finished TC004_AddToCartTest ***");
	}
}
		
		
		
		