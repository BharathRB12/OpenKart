package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends BasePage
{

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//ul[@class='breadcrumb']//li[3]/a") WebElement headerCheckOut;
	
	@FindBy(xpath="//div[@class='panel-group']//following::a[contains(text(),'Billing Details')]")
	WebElement billingDetailsDropDown;
	
	@FindBy(xpath="//input[@name='payment_address' and @value='new']") WebElement rbtnnewAddress;
	
	@FindBy(xpath="//input[@name='firstname']") WebElement textFirstName;
	
	@FindBy(xpath="//input[@name='lastname']") WebElement txtLastName;
	 
	@FindBy(xpath="//input[@name='address_1']") WebElement txtAddress;
	
	@FindBy(xpath="//input[@name='postcode']") WebElement setPostCode;
	
	@FindBy(xpath="//input[@name='city']") WebElement txtCity;
	
	@FindBy(xpath="//select[@name='country_id']") WebElement drpdwnCountry;	
	
	@FindBy(xpath="//select[@name='zone_id']") WebElement drpdownState;
	
	@FindBy(xpath="//input[@value='Continue']") WebElement btnBillingContinue;
	
	@FindBy(xpath="//input[@name='shipping_address' and @value='existing']") WebElement RadioExistingShipping;
	
	@FindBy(xpath="//input[@id='button-shipping-address']") WebElement btnShippingContinue;
	
	@FindBy(xpath="//textarea[@name='comment']") WebElement txtDeliveryComment;
	 
	@FindBy(xpath="//input[@id='button-shipping-method']") WebElement btnShippingMethodContinue;
	
	@FindBy(xpath="//label[contains(.,'Cash On Delivery')]/input") WebElement rBtnCashOnDelivery;
	
	@FindBy(xpath="//label[contains(.,'Cash On Delivery')]/..//following::textarea[@name='comment']") WebElement txtPaymentComment;
	
	@FindBy(xpath="//input[@name='agree']") WebElement ChkBoxTermCondtion;
	
	@FindBy(xpath="//input[@id='button-payment-method']") WebElement btnPaymentContinue;
	
	@FindBy(xpath="//div[@class='table-responsive']/table/tbody/tr[1]/td[last()]") WebElement totalPrice;
	
	@FindBy(xpath="//input[@value='Confirm Order']") WebElement btnConfirmOrder;
	//action
	public String getCheckoutHeading()
	{
		waitForVisibility(headerCheckOut);
		return headerCheckOut.getText();
	}
	
	public void clickbillingDetailsDropDown()
	{
		billingDetailsDropDown.click();
	}
	
	public void clickNewAddress()
	{
		rbtnnewAddress.click();
	}
	
	public void setFirstName(String firstName)
	{
		textFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName)
	{
		txtLastName.sendKeys(lastName);
	}
	
	public void setAddress(String address)
	{
		txtAddress.sendKeys(address);
	}
	
	public void setCity(String city)
	{
		txtCity.sendKeys(city);
	}
	
	public void setPostCode(String postcode)
	{
		setPostCode.sendKeys(postcode);
	}

	public WebElement setCountry()
	{
		return drpdwnCountry;
		
	}
	
	public WebElement setState()
	{
		return drpdownState;
	}
	
	public void clickBillingContinue()
	{
		btnBillingContinue.click();
	}
	
	public boolean VerifyChekedExistingShippingAddress()
	{
		waitForVisibility(RadioExistingShipping);
		return RadioExistingShipping.isSelected();
	}
	
	public void clickShippingContinue()
	{
		btnShippingContinue.click();
	}
	
	public void setDeliveryComment(String comment)
	{
		txtDeliveryComment.sendKeys(comment);
	}
	
	public void clickDeliveryMethodContinue()
	{
		btnShippingMethodContinue.click();
	}
	
	public boolean verifyCheckedrBtnCashOnDelivery()
	{
		waitForVisibility(rBtnCashOnDelivery);
		return rBtnCashOnDelivery.isSelected();
	}
	
	public void setPaymentComment(String comment)
	{
		txtPaymentComment.sendKeys(comment);
	}
	
	public void clickTermCondtion()
	{
		ChkBoxTermCondtion.click();
	}
	
	public void clickPaymentContinue()
	{
		waitForVisibility(btnPaymentContinue);
		btnPaymentContinue.click();
	}
	
	public String getTotalPrice()
	{
		return totalPrice.getText();
	}
	
	public void clickConfirmOrder()
	{
		btnConfirmOrder.click();
	}
}
