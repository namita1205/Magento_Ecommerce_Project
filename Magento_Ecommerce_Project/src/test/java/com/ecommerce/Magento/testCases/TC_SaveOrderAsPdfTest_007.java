package com.ecommerce.Magento.testCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CreateAccountPage;
import com.ecommerce.Magento.pageObject.PurchaseOrderPage;
import com.ecommerce.Magento.pageObject.SaveOrderAsPdfPage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_SaveOrderAsPdfTest_007 extends BaseClass {

	@Test
	public void myOrderTest() throws InterruptedException {
		driver.get(configProp.getProperty("URL"));
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.clickLnkAccount();
		logger.info("****** Logging into Account ******");
		ca.clickLnkmyAccount();
		PurchaseOrderPage po = new PurchaseOrderPage(driver);
		po.setEmail("tester.ninja@gmail.com");
		po.setPassword("tester");
		po.clickBtnLogin();

		SaveOrderAsPdfPage savepg = new SaveOrderAsPdfPage(driver);
		boolean statusOrderDisplayed = savepg.verifyPreviousOrder("ORDER #");
		Assert.assertEquals(statusOrderDisplayed, true);
	}

	@Test
	public void verifyStatusTest() throws IOException {
		SaveOrderAsPdfPage savepg = new SaveOrderAsPdfPage(driver);
		logger.info("****** Verifying status is Pending ******");
		boolean valuepending = savepg.verifyStatusvalue("STATUS", "Pending");
		if (valuepending == true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		} else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver, "verifyStatusTest");
			Assert.assertTrue(false);
		}

	}

	@Test
	public void yourOrderSaveAsPdfTest() throws InterruptedException {
		SaveOrderAsPdfPage savepg = new SaveOrderAsPdfPage(driver);
		savepg.clickViewOrder();

		savepg.clickPrintOrder();
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
		System.out.println("Title:" + driver.getTitle());
		Thread.sleep(3000);
		savepg.clickBtnSave();
		logger.error("****** Button Save not found ******");

	}
}
