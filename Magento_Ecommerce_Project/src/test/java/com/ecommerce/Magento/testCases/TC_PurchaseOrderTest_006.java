package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CreateAccountPage;
import com.ecommerce.Magento.pageObject.PurchaseOrderPage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_PurchaseOrderTest_006 extends BaseClass {
	@Test
	public void loginAndAddToWishlistTest() throws InterruptedException {
		driver.get(configProp.getProperty("URL"));
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.clickLnkAccount();
		logger.info("****** Loggin into account ******");
		ca.clickLnkmyAccount();
		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		po.setEmail("tester.ninja@gmail.com");
		po.setPassword("tester");
		po.clickBtnLogin();

		ca.clickLnkTV();

		ca.clicklnkAddToWish();

	}

	@Test
	public void setBillingInformation() throws InterruptedException, IOException {
		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		po.clickbtnAddToCart();

		po.clickbtnCheckout();
		logger.info("****** Filling billing details ******");
		po.clickbtnshipToDiff("New Address");

		po.setAddress("ABC");
		po.setCity("New York");
		po.setState("New York");
		po.setZip("542896");
		po.setPh("12345678");
		po.clickbtnContinue();

		boolean shipRate = po.getShippingRate("Flat Rate", "Fixed $5.00");
		if (shipRate == true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		} else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver, "setBillingInformation");
			Assert.assertTrue(false);
		}

	}

	@Test
	public void verifyorderTotalTest() throws InterruptedException {
		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		po.clickbtnShippingMethod();

		po.clickbtnCheck();

		po.clickbtnPaymentContinue();
		logger.info("****** Verifying total price ******");
		boolean verifyPricetotal = po.verifyTotalPrice("Subtotal", "Shipping", "Grand Total");
		Assert.assertEquals(verifyPricetotal, true);
		

	}

	@Test
	public void yourOrderConfirmedTest() throws InterruptedException, IOException {
		PurchaseOrderPage po = new PurchaseOrderPage(driver);

		po.clickbtnPlaceOrder();
		Thread.sleep(3000);
		boolean confirmationMsg=po.confirmationMsgDisplayed("YOUR ORDER HAS BEEN RECEIVED.");
		if(confirmationMsg==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"yourOrderConfirmationTest");
			Assert.assertTrue(false);
		}
		
		po.saveOrder();

	}

}
