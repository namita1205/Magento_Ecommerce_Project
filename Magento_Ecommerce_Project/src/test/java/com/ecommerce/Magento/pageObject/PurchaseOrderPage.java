package com.ecommerce.Magento.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecommerce.Magento.utilities.WaitHelper;

public class PurchaseOrderPage {
	public WebDriver driver;
	private static String ordernumber="";
	WaitHelper waithelper;

	public PurchaseOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}

	// locators
	@FindBy(id = "email")
	WebElement txtemail;

	@FindBy(id = "pass")
	WebElement txtpassword;

	@FindBy(id = "send2")
	WebElement btnLogin;

	@FindBy(xpath = "//div[@class='block-content']//a[contains(text(),'My Wishlist')]")
	WebElement lnkMyWishlist;

	@FindBy(xpath = "//div[@class='cart-cell']//button[@class='button btn-cart']//span//span[contains(text(),'Add to Cart')]")
	WebElement btnAddToCart;

	@FindBy(xpath = "//ul[@class='checkout-types top']//span[text()='Proceed to Checkout']")
	WebElement btnProceedToCheckout;
	
	@FindBy(xpath="//select[@id='billing-address-select']")
	WebElement shipToDiffAdd;

	@FindBy(id = "billing:street1")
	WebElement txtAddress;

	@FindBy(id = "billing:city")
	WebElement txtcity;

	@FindBy(xpath = "//select[@id='billing:region_id']")
	WebElement txtstate;

	@FindBy(id = "billing:postcode")
	WebElement txtzip;

	@FindBy(id = "billing:telephone")
	WebElement txtphone;

	@FindBy(xpath = "//div[@id='billing-buttons-container']//button[@class='button']")
	WebElement btnContinue;

	@FindBy(xpath = "//dt[contains(text(),'Flat Rate')]")
	WebElement txtShippingPriceFlat;

	@FindBy(xpath = "//label[contains(text(),'Fixed')]")
	WebElement txtShippingRate;

	@FindBy(xpath = "//div[@id='shipping-method-buttons-container']//button[@class='button']")
	WebElement btnshippingContinue;

	@FindBy(xpath = "//input[@id='p_method_checkmo']")
	WebElement radiobtnCheck;

	@FindBy(xpath = "//div[@id='payment-buttons-container']//button[@class='button']")
	WebElement btnPaymentContinue;

	@FindBy(xpath = "//table[@id='checkout-review-table']//tfoot//tr//td[1]")
	List<WebElement> orderTable;

	@FindBy(xpath = "//table[@id='checkout-review-table']//tfoot//tr[1]//td[2]")
	WebElement subtotalPrice;

	@FindBy(xpath = "//table[@id='checkout-review-table']//tfoot//tr[2]//td[2]")
	WebElement shippingRate;
	
	@FindBy(xpath = "//table[@id='checkout-review-table']//tfoot//tr[3]//td[2]")
	WebElement grandTotal;
	
	@FindBy(xpath="//button[@class='button btn-checkout']")
	WebElement btnPlaceOrder;
	
	@FindBy(xpath="//div[@class='page-title']")
	WebElement confirmationMsg;
	
	@FindBy(xpath="//div[@class='main-container col1-layout']//p[1]")
	WebElement orderNo;
	
	

	// methods
	public void setEmail(String emailAdd) {
		waithelper.waitForElement(txtemail, 30);
		txtemail.sendKeys(emailAdd);
	}

	public void setPassword(String password) {
		
		txtpassword.sendKeys(password);
	}

	public void clickBtnLogin() {
		btnLogin.click();
	}

	public void clickLnkMyWishlist() {
		waithelper.waitForElement(lnkMyWishlist, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkMyWishlist);
		lnkMyWishlist.click();
	}

	public void clickbtnAddToCart() {
		waithelper.waitForElement(btnAddToCart, 30);
		btnAddToCart.click();
	}

	public void clickbtnCheckout() {
		waithelper.waitForElement(btnProceedToCheckout, 30);
		btnProceedToCheckout.click();
	}
	
	public void clickbtnshipToDiff(String NewAdd) {
		Select sel=new Select(shipToDiffAdd);
		sel.selectByVisibleText(NewAdd);
	}

	public void setAddress(String Add) {
		waithelper.waitForElement(txtAddress, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtAddress);
		txtAddress.clear();
		txtAddress.sendKeys(Add);
	}

	public void setCity(String city) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtcity);
		txtcity.clear();
		txtcity.sendKeys(city);
	}

	public void setState(String state) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtstate);
		Select sel = new Select(txtstate);
		sel.selectByVisibleText(state);
	}

	public void setZip(String zip) {
		waithelper.waitForElement(txtzip, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtzip);
		txtzip.clear();
		txtzip.sendKeys(zip);
	}

	public void setPh(String ph) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtphone);
		txtphone.clear();
		txtphone.sendKeys(ph);
	}

	public void clickbtnContinue() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnContinue);
		btnContinue.click();
	}

	public boolean getShippingRate(String flatrate, String price) {
		waithelper.waitForElement(txtShippingPriceFlat, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtShippingPriceFlat);
		String shippingFlat = txtShippingPriceFlat.getText();
		System.out.println("TEXT:"+shippingFlat);
		String shippingRate = txtShippingRate.getText();
		System.out.println("shippingFlat:"+shippingFlat);
		
		if (shippingFlat.equals(flatrate) && shippingRate.equals(price)) {
			return true;
		}
		return false;
	}

	public void clickbtnShippingMethod() {
		waithelper.waitForElement(btnshippingContinue, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnshippingContinue);
		btnshippingContinue.click();
	}

	public void clickbtnCheck() {
		radiobtnCheck.click();
	}

	public void clickbtnPaymentContinue() {
		waithelper.waitForElement(btnPaymentContinue, 30);
		btnPaymentContinue.click();
	}

	public boolean verifyTotalPrice(String subtotal, String shiprate ,String total) {
		double totalcost = 0;
		double subP=0;
		double sr=0;
		double tp=0;
		
		for (WebElement column : orderTable) {
			String heading = column.getText();
			
			if (heading.equals(subtotal)) {
				System.out.println(heading);
				String subPrice = subtotalPrice.getText();
				
				subPrice = subPrice.replaceAll("[^a-zA-Z0-9.]", "");
				System.out.println("subtotal:"+ subPrice);
				 subP = Double.parseDouble(subPrice);
				 System.out.println("Intsubtotal:"+ subP);
			}
			if (heading.contains(shiprate)) {
				System.out.println(heading);
				String sRate = shippingRate.getText();
				sRate = sRate.replaceAll("[^a-zA-Z0-9.]", "");
				System.out.println("shippingR:"+ sRate);
				 sr = Double.parseDouble(sRate);
				 System.out.println("Double shippingR:"+ sr);

			}
			if(heading.equals(total)) {
				String totalPrice=grandTotal.getText();

				totalPrice= totalPrice.replaceAll("[^a-zA-Z0-9.]", "");
				System.out.println("totalPriceincart:"+ totalPrice);
				 tp = Double.parseDouble(totalPrice);
				 System.out.println("Double grandtotal:"+ tp);
				
				
			}


		}
		totalcost=subP+sr;
		System.out.println("TotalCost:"+totalcost);
	if(tp==totalcost) {
		return true;
	}
	return false;

	}
	public void clickbtnPlaceOrder() {
		btnPlaceOrder.click();
	}
	public boolean confirmationMsgDisplayed(String msg) {
		String orderConfirmedText=confirmationMsg.getText();
		if(orderConfirmedText.equals(msg)) {
			return true;
		}
		return false;
		
	}
	public void saveOrder() {
		ordernumber=orderNo.getText();
		System.out.println("Saving:"+ ordernumber);
		
	}
	public String getOrderNumber() {
		System.out.println("Getting:"+ ordernumber);
		return ordernumber;
	}
	
	
	

}
