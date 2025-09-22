package testCases;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AddToCartPage;
import pageObjects.CheckOutPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SuccessPage;
import testBase.BaseClass;

public class TC005_OrderingItem extends BaseClass {
	@Test(groups = "Regression")
	public void verifyUserIsAbleToOrder() {
		try {	
			logger.info("Starting TC005_OrderingItem testcase.............");
			HomePage hp = new HomePage(driver);
			logger.info("Navigating to Login page");
			String expHomeTitle=pr.getProperty("homePageTitle");
			String homeTitle=hp.getPageTitle(expHomeTitle);
			Assert.assertEquals(homeTitle, homeTitle);
			boolean hpLogo = hp.isLogoDisplayed();
			Assert.assertTrue(hpLogo);
			hp.clickMyAccount();
			hp.clickLogin();
			LoginPage lp = new LoginPage(driver);
			logger.info("Login to Application");
			String expLoginTitle=pr.getProperty("loginPageTitle");
			String	loginHeader=lp.getPageTitle(expLoginTitle);
			Assert.assertEquals(loginHeader, expLoginTitle);
			boolean lpHeader = lp.isReturnCustHeaderExist();
			Assert.assertTrue(lpHeader);
			lp.loginToApp(pr.getProperty("email"), pr.getProperty("password"));
			logger.info("Search for Item");
			Thread.sleep(2000);
			hp.setSearchTxt(pr.getProperty("purchaseItem"));
			hp.clickSearch();

			SearchPage sp = new SearchPage(driver);
			logger.info("Verifying Search Page");
			String expSpTitle=pr.getProperty("searchPageHeader")+" - "+pr.getProperty("purchaseItem");
			Thread.sleep(2000);
			String spTitle=sp.getPageTitle(expSpTitle);
			Assert.assertEquals(spTitle, expSpTitle);
			logger.info("Adding to cart");
			sp.clickAddToCart();
			
			logger.info("navigating to Shopping Cart page");
			AddToCartPage acp = new AddToCartPage(driver);
			Thread.sleep(2000);
			String acpHeader = acp.verifyCartPageHeader();
			Assert.assertEquals(acpHeader, pr.getProperty("purchaseItem"));
			acp.clickAddTocart();
			boolean cartSuccessMsg = acp.verifyAddToCartSuccessMsg();
			Assert.assertTrue(cartSuccessMsg);
			acp.clickGoCartButton();
			acp.clickViewCart();
			
			logger.info("Navigating to Checkout page");
			ShoppingCartPage scp = new ShoppingCartPage(driver);
			String expSCTitle=pr.getProperty("shoppingCartPageTitle");
			String SCTitle=scp.getPageTitle(expSCTitle);
			Assert.assertEquals(SCTitle, expSCTitle);
			ArrayList<String> arrList = scp.getAddedItemInList();
			arrList.contains(pr.getProperty("purchaseItem"));
			String beforeTtlPrice = scp.getTotalPrice();
			scp.clickCheckOut();
			
			logger.info("Validating checkout page");
			CheckOutPage cop = new CheckOutPage(driver);
			String expCOPtitle=pr.getProperty("checkoutPageTitle");
			String COPTitle=cop.getPageTitle(expCOPtitle);
			Assert.assertEquals(COPTitle, expCOPtitle);

			logger.info("providing the billing details");
			//cop.clickbillingDetailsDropDown();
			cop.clickNewAddress();
			Thread.sleep(3000);
			String frstName = randomString();
			cop.setFirstName(frstName);
			String lastName = randomString();
			cop.setLastName(lastName);
			cop.setAddress(pr.getProperty("address"));
			cop.setCity(pr.getProperty("city"));
			cop.setPostCode(pr.getProperty("postcode"));
			WebElement countryDropdown = cop.setCountry();
			setDropDownValue(countryDropdown, pr.getProperty("country"));
			WebElement stateDropdown = cop.setState();
			setDropDownValue(stateDropdown, pr.getProperty("state"));
			cop.clickBillingContinue();
			boolean existingAddress = cop.VerifyChekedExistingShippingAddress();
			Assert.assertTrue(existingAddress);
			cop.clickShippingContinue();
			cop.setDeliveryComment(pr.getProperty("comment"));
			cop.clickDeliveryMethodContinue();
			boolean cashOnDeliveryRadioBtn = cop.verifyCheckedrBtnCashOnDelivery();
			Assert.assertTrue(cashOnDeliveryRadioBtn);
			cop.setPaymentComment(pr.getProperty("comment"));
			cop.clickTermCondtion();
			cop.clickPaymentContinue();
			Thread.sleep(2000);
			String totalPrice = cop.getTotalPrice();
			Assert.assertEquals(totalPrice, beforeTtlPrice);
			cop.clickConfirmOrder();
			
			logger.info("Validating Order Success page");
			SuccessPage successpage = new SuccessPage(driver);
			String expSuccessTitle=pr.getProperty("successPageTitle");
			String successPagetitle=successpage.getPageTitle(expSuccessTitle);
			Assert.assertEquals(expSuccessTitle, successPagetitle);
		} catch (Exception e) {
			logger.error("Test failed..");
			Assert.fail("Test failed due to exception: " + e.getMessage());
		}
		logger.info("End TC005_OrderingItem testcase.............");
	}
}
