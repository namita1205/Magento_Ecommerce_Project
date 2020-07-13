package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CompareTwoMobilesPage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_CompareTwoMobilesTest_004 extends BaseClass {
	@Test
	public void CompareProductsTest() throws InterruptedException, IOException {

		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName = new SortByNamePage(driver);
		sortName.clickMEnuMobile();

		CompareTwoMobilesPage cm = new CompareTwoMobilesPage(driver);
		logger.info("****** Clicking on lnk Add To Compare ******");
		cm.clicklnkAddToCompareSony();
		cm.clicklnkAddToCompareIPhone();
		logger.info("****** clicking button Compare and identifying window handles ******");

		cm.clickBtnAndIdentifyHandles("Products Comparison List - Magento Commerce");
		logger.info("****** Verifying heading on page and product names ******");

		captureScreen(driver, "CompareProductsTest");
		boolean headingPresent = cm.verifyheadingOnPage("COMPARE PRODUCTS", "SONY XPERIA", "IPHONE");
		Assert.assertEquals(headingPresent, true);
		logger.info("****** Switching to parent window and verifying title ******");
		cm.toParentWindow();
	}
}
