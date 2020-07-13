package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.SearchFunctionalityPage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_SearchFunctionalityTest_014 extends BaseClass {
	@Test
	public void SearchFunctionalityPriceTo150() throws InterruptedException, IOException {
		driver.get(configProp.getProperty("URL"));
		SearchFunctionalityPage sf=new SearchFunctionalityPage(driver);
		sf.clickAdvanceSearch();
		sf.setPriceFrom("0");
		sf.setPriceTo("150");
		sf.clickbtnSearch();
		Thread.sleep(3000);
		boolean statusNamesDisplayed=sf.verifytxtMobileNames();
		if(statusNamesDisplayed==true) {
			logger.info("****** NameDisplayedTestTo150 is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** NameDisplayedTestTo150 is Failed ******");
			captureScreen(driver,"SearchFunctionalityPriceTo150");
			Assert.assertTrue(false);
		}
		
		boolean statusPriceDisplayed=sf.verifytxtPrice();
		if(statusPriceDisplayed==true) {
			logger.info("****** PriceDisplayedTestTo150 is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** PriceDisplayedTestTo150 is Failed ******");
			captureScreen(driver,"SearchFunctionalityPriceTo150");
			Assert.assertTrue(false);
		}
		
		Thread.sleep(3000);
		sf.verifySpecialPrice();
		sf.clickModifySearch();
	}
	@Test
	public void verifySearchFunctionalityPrice151To1000() throws InterruptedException, IOException {
		SearchFunctionalityPage sf=new SearchFunctionalityPage(driver);
		sf.setPriceFrom("151");
		sf.setPriceTo("1000");
		sf.clickbtnSearch();
		Thread.sleep(3000);
		boolean statusNamesDisplayed=sf.verifytxtMobileNames();
		if(statusNamesDisplayed==true) {
			logger.info("****** NameDisplayedTest151To1000 is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** NameDisplayedTestTo151To1000 is Failed ******");
			captureScreen(driver,"SearchFunctionalityPrice151To1000");
			Assert.assertTrue(false);
		}
		
		boolean statusPriceDisplayed=sf.verifytxtPrice();
		if(statusPriceDisplayed==true) {
			logger.info("****** PriceDisplayedTest151To1000 is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** PriceDisplayedTest151To1000 is Failed ******");
			captureScreen(driver,"SearchFunctionalityPrice151To1000");
			Assert.assertTrue(false);
		}
		Thread.sleep(3000);
		sf.verifySpecialPrice();
		
	}
	

}
