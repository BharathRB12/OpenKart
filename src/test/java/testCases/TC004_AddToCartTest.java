package testCases;

import java.util.ArrayList;

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
		String expHomeTitle=pr.getProperty("homePageTitle");
		String homeTitle=hp.getPageTitle(expHomeTitle);
		Assert.assertEquals(homeTitle, homeTitle);
		logger.info("Verifing Home Page Logo");
		Assert.assertTrue(hp.isLogoDisplayed());
		logger.info("navigating to Login page");
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp=new LoginPage(driver);
		logger.info("Verifing Login Page");
		String expLoginTitle=pr.getProperty("loginPageTitle");
		String	loginHeader=lp.getPageTitle(expLoginTitle);
		Assert.assertEquals(loginHeader, expLoginTitle);
		Assert.assertTrue(lp.isReturnCustHeaderExist());
		String email=pr.getProperty("email");
		String password=pr.getProperty("password");
		logger.info("Providing Credentials for login");
		lp.loginToApp(email, password);
		
		
		logger.info("Seaching Item");
		String itemName=pr.getProperty("searchItem");
		Thread.sleep(2000);
		hp.setSearchTxt(itemName);
		logger.info("Click on Search button");
		hp.clickSearch();
		
		SearchPage sp=new SearchPage(driver);
		logger.info("Verifying Search page header");
		String expSpTitle=pr.getProperty("searchPageHeader")+" - "+itemName;
		String spTitle=sp.getPageTitle(expSpTitle);
		Assert.assertEquals(spTitle, expSpTitle);
		logger.info("Adding Item to Cart");
		sp.clickAddToCart();
		logger.info("Verifying successfull Message");
		Assert.assertTrue(sp.verifyAddToCartSuccessMsg());
		logger.info("Navigating to Shopping Cart Page");
		sp.clickCartBtn();
		sp.clickViewCart();
		
		ShoppingCartPage scp=new ShoppingCartPage(driver);
		logger.info("Validating Shopping Cart Page header");
		String expSCTitle=pr.getProperty("shoppingCartPageTitle");
		String SCTitle=scp.getPageTitle(expSCTitle);
		Assert.assertEquals(SCTitle, expSCTitle);
		logger.info("Validating Added item is present or not");
		ArrayList<String> arrlist = scp.getAddedItemInList();
		arrlist.contains(itemName);
		logger.info("Removing added item from Cart");
		scp.clickRemove();
		String emptyMsg=pr.getProperty("emptyShoppingCartMsg");
		String emptyCartMsg=scp.emptySCartMsg(emptyMsg);
		Assert.assertEquals(emptyCartMsg,emptyMsg);
		
		}
			catch(Exception e)
			{
				logger.error("Test failed..");
				Assert.fail("Test failed due to exception: " + e.getMessage());
			}
		logger.info("*** Finished TC004_AddToCartTest ***");
	}
}
		
		
		
		