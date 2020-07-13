package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CartUpdatePage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_UpdateCartTest_003 extends BaseClass {
	@Test
	public void MoreQuantityUpdateCartTest() throws InterruptedException, IOException {
		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName = new SortByNamePage(driver);
		logger.info("****** Clicking link Mobile ******");
		sortName.clickMEnuMobile();
		logger.info("****** Clicking button Add to cart ******");
		CartUpdatePage uc = new CartUpdatePage(driver);
		uc.clickbtnAddToCart();
		logger.info("****** Updating quantity and clicking button Update ******");

		uc.setQuantity("1000");
		uc.clickUpdatebtn();
		logger.info("****** Verifying Update message *******");
		captureScreen(driver, "MoreQuantityUpdateCartTest");

		boolean statusMessage = uc.verifyUpdate("Some of the products cannot be ordered in requested quantity.");
		Assert.assertEquals(statusMessage, true);
		logger.info("****** Verifying maximum quantity allowed for purchase ******");
		captureScreen(driver, "MoreQuantityUpdateCartTest");

		boolean ErrMsgSony = uc.verifyUpdateSonyXperia("* The maximum quantity allowed for purchase is 500.");
		Assert.assertEquals(ErrMsgSony, true);

		uc.clickbtnEmptyCart();
		logger.info("****** Verifying cart empty message ******");
		captureScreen(driver, "MoreQuantityUpdateCartTest");

		boolean statusmsgCartEmpty = uc.verifyEmptyCart("You have no items in your shopping cart.");
		Assert.assertEquals(statusmsgCartEmpty, true);

	}

}
