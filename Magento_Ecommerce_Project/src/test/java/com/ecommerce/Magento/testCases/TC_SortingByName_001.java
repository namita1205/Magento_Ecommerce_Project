package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_SortingByName_001 extends BaseClass {
	@Test
	public void sortByNameTitleTest() throws InterruptedException, IOException {
		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName = new SortByNamePage(driver);
		logger.info("****** Verifying Page Title ******");

		captureScreen(driver, "sortByNameTitleTest");
		boolean title = sortName.verifyPageTitle();
		Assert.assertEquals(title, true);

		logger.info("****** Clicking on menu Mobile ******");

		sortName.clickMEnuMobile();
		Thread.sleep(3000);
		logger.info("****** Verifying title of Mobile Page ******");
		captureScreen(driver, "sortByNameTitleTest");
		boolean titleMobile = sortName.verifyPageTitleAfterClick();
		Assert.assertEquals(titleMobile, true);

	}

	@Test
	public void verifySortByNameTest() throws InterruptedException, IOException {
		SortByNamePage sortName = new SortByNamePage(driver);
		logger.info("****** Selecting option Name in dropdown ******");
		sortName.selectDropdown("Name");
		Thread.sleep(3000);

		logger.info("****** Verifying sort by Name ******");
		captureScreen(driver, "sortByNameTitleTest");
		boolean sortedName = sortName.verifySortByName();
		Assert.assertEquals(sortedName, true);

	}

}