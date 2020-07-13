package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class CouponPage {
	WebDriver driver;
	WaitHelper waithelper;
	private static double subtotalprice = 0;
	private static double discountprice = 0;
	private static double discountedTotal=0;

	public CouponPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}

	@FindBy(xpath = "//li[2]//div[1]//div[3]//button[1]//span[1]//span[1]")
	WebElement btnIPhoneAddToCart;

	@FindBy(xpath = "//input[@name='coupon_code']")
	WebElement txtCouponCode;

	@FindBy(xpath = "//span[contains(text(),'Apply')]")
	WebElement lnkApply;

	@FindBy(xpath = "//li[@class='success-msg']//ul//li")
	WebElement txtSuccessMsg;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tbody//tr[1]//td[1]")
	WebElement headingSubtotal;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tbody//tr[1]//td[2]")
	WebElement txtSubtotalPrice;;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tbody//tr[2]//td[1]")
	WebElement headingDiscount;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tbody//tr[2]//td[2]")
	WebElement txtDiscountPrice;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tfoot//tr[1]//td[1]")
	WebElement txtGrandTotal;

	@FindBy(xpath = "//table[@id='shopping-cart-totals-table']//tfoot//tr[1]//td[2]")
	WebElement grandTotalPrice;

	public void clickIphoneAddToCart() {
		waithelper.waitForElement(btnIPhoneAddToCart, 30);
		btnIPhoneAddToCart.click();

	}

	public void setCouponCode(String cc) {
		waithelper.waitForElement(txtCouponCode, 30);
		txtCouponCode.sendKeys(cc);

	}

	public void clickLnkApply() {
		lnkApply.click();
	}

	public boolean verifySuccessMsg(String msg) {
		waithelper.waitForElement(txtSuccessMsg, 30);
		String msgCouponApplied = txtSuccessMsg.getText();
		System.out.println(msgCouponApplied);
		if (msgCouponApplied.equals(msg)) {
			return true;
		}
		return false;
	}

	public boolean verifycalculatedDiscount(String stheading, String discountheading) {

		double discountCalculated = 0;

		String hsubtotal = headingSubtotal.getText();
		System.out.println("Heading Subtotal:" + hsubtotal);
		if (hsubtotal.equals(stheading)) {
			waithelper.waitForElement(txtSubtotalPrice, 30);
			String subtotalP = txtSubtotalPrice.getText();
			subtotalP = subtotalP.replaceAll("[^a-zA-Z0-9.]", "");
			subtotalprice = Double.parseDouble(subtotalP);
			System.out.println("SubtotalPrice:" + subtotalprice);

		}
		discountCalculated = subtotalprice * 5 / 100;
		System.out.println("Discount Calculated:" + discountCalculated);
		String hDiscount = headingDiscount.getText();
		System.out.println("Heading Subtotal:" + hDiscount);
		if (hDiscount.equals(discountheading)) {
			waithelper.waitForElement(txtDiscountPrice, 30);
			String discountP = txtDiscountPrice.getText();
			discountP = discountP.replaceAll("[^a-zA-Z0-9.]", "");
			discountprice = Double.parseDouble(discountP);
			System.out.println("DiscountPrice:" + discountprice);
		}
		if (discountprice == discountCalculated) {
			
			return true;
		}
		return false;

	}

	public boolean verifyTotalAfterDiscount(String htotal) {
		double totalprice = 0;
		discountedTotal = subtotalprice - discountprice;
		System.out.println("Discounted price calculated:" + discountedTotal);
		waithelper.waitForElement(txtGrandTotal, 30);
		String hgrandtotal = txtGrandTotal.getText();
		System.out.println("grand total heading:" + hgrandtotal);
		if (hgrandtotal.equals(htotal)) {
			String priceAfterDiscount = grandTotalPrice.getText();
			priceAfterDiscount = priceAfterDiscount.replaceAll("[^a-zA-Z0-9.]", "");
			totalprice = Double.parseDouble(priceAfterDiscount);
			System.out.println("Total Price:"+ totalprice);
		}
		if(totalprice==discountedTotal) {
			return true;
		}
return false;
	}

}
