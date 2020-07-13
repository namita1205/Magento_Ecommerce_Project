package com.ecommerce.Magento.testCases;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.ReadingFromCSVFilePage;
import com.ecommerce.Magento.pageObject.SortByDatePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_SortDateTest_013 extends BaseClass {
	@Test
	public void SortDateAscendingtest() throws InterruptedException, IOException, ParseException {
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		ReadingFromCSVFilePage readcsvfile=new ReadingFromCSVFilePage(driver); 
		readcsvfile.setUsername("user01");
		readcsvfile.setPassword("guru99com");
		readcsvfile.clickbtnLogin();
		readcsvfile.clickbtnpopupclose();
		readcsvfile.clicklnkSales();
		Thread.sleep(5000);
		logger.info("****** Sorting by date ******");
		SortByDatePage sortdate=new SortByDatePage(driver);
		sortdate.clickInvoices();
		sortdate.clickinvoicedate();
		Thread.sleep(3000);
		sortdate.setArrayListOfDates();
		Thread.sleep(5000);
		logger.info("****** Verifying date sorted in ascending order ******");
		boolean statusDateAscending=sortdate.sortdateAscending();
		if(statusDateAscending==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"SortDateAscendingTest");
			Assert.assertTrue(false);
		}
		
		
	}
	@Test
	public void verifyDateDescendingTest() throws InterruptedException, ParseException, IOException {
		SortByDatePage sortdate=new SortByDatePage(driver);
		sortdate.clickinvoicedate();
		Thread.sleep(5000);
		sortdate.setArrayListOfDates();
		Thread.sleep(5000);
		logger.info("****** Verifying date sorted in descending order ******");
		boolean statusDateDescending=sortdate.sortdateDescending();
		if(statusDateDescending==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"verifyDateDescendingTest");
			Assert.assertTrue(false);
		}
		
		
		
	}
}
