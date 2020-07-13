package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CreateAccountPage;
import com.ecommerce.Magento.pageObject.PurchaseOrderPage;
import com.ecommerce.Magento.pageObject.ReorderPage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_ReorderTest_008 extends BaseClass {
	@Test
	public void quantityUpdateTest() throws InterruptedException {
		driver.get(configProp.getProperty("URL"));
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.clickLnkAccount();

		ca.clickLnkmyAccount();

		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		logger.info("****** Logging into Account ******");
		po.setEmail("tester.ninja@gmail.com");
		po.setPassword("tester");
		po.clickBtnLogin();
		Thread.sleep(3000);
		ReorderPage rp = new ReorderPage(driver);
		rp.clickLnkReorder();
		logger.info("****** Updating Quantity ******");
		rp.setQuantity("10");

		rp.clickBtnUpdate();
		rp.clickbtnFixedShipping();

		rp.clickbtnUpdateAfterShippingCost();

	}

	@Test
	public void totalUpdateTest() throws IOException {
		ReorderPage rp = new ReorderPage(driver);
		logger.info("****** Verifying Grand Total ******");
		boolean statusPriceUpdate = rp.verifyGrandtotalUpdate("GRAND TOTAL", "$6,200.00");
		if (statusPriceUpdate == true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		} else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver, "totalUpdateTest");
			Assert.assertTrue(false);
		}

	}

	@Test
	public void updateBillingAddress() throws InterruptedException {
		PurchaseOrderPage po = new PurchaseOrderPage(driver);

		po.clickbtnCheckout();

		po.clickbtnshipToDiff("New Address");
		logger.info("****** Updating Billing Address ******");
		po.setAddress("ABC");
		po.setCity("New York");
		po.setState("New York");
		po.setZip("542896");
		po.setPh("12345678");

		po.clickbtnContinue();
		po.clickbtnShippingMethod();

		po.clickbtnCheck();

		po.clickbtnPaymentContinue();
	}

	@Test
	public void yourOrderGenerated() throws InterruptedException, IOException {
		PurchaseOrderPage po = new PurchaseOrderPage(driver);

		po.clickbtnPlaceOrder();
		Thread.sleep(3000);
		boolean messageOrderConfirmed=po.confirmationMsgDisplayed("YOUR ORDER HAS BEEN RECEIVED.");
		if(messageOrderConfirmed==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"yourOrderGenerated");
			Assert.assertTrue(false);
		}
		
		po.saveOrder();
	}

}
