package com.ecommerce.Magento.testCases;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.PrintInvoicePage;
import com.ecommerce.Magento.pageObject.ReadingFromCSVFilePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_PrintInvoiceTest_011 extends BaseClass {
	@Test
	public void ErrorPrintInvoiceMsgtest() throws InterruptedException, IOException {
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		ReadingFromCSVFilePage readcsvfile = new ReadingFromCSVFilePage(driver);
		readcsvfile.setUsername("user01");
		readcsvfile.setPassword("guru99com");
		readcsvfile.clickbtnLogin();

		readcsvfile.clickbtnpopupclose();

		readcsvfile.clicklnkSales();
		readcsvfile.clicklnkOrders();
		Thread.sleep(3000);
		PrintInvoicePage printinvoice = new PrintInvoicePage(driver);
		logger.info("****** Setting Status to Canceled ******");
		printinvoice.setStatus("Canceled");
		Thread.sleep(5000);
		printinvoice.clickbtnSearch();
		printinvoice.clickChechbox();
		logger.info("****** Printing Invoice of the Order Canceled ******");
		printinvoice.setAction("Print Invoices");
		printinvoice.clickbtnSubmit();
		Thread.sleep(5000);
		logger.info("****** Verifying error message ******");
		boolean statusErrorMsg = printinvoice
				.verifyErrorMsg("There are no printable documents related to selected orders.");
		Assert.assertEquals(statusErrorMsg, true);
	}

	@Test
	public void printInvoiceDownloadTest() throws InterruptedException {
		PrintInvoicePage printinvoice = new PrintInvoicePage(driver);
		logger.info("****** Setting Status to Complete ******");
		printinvoice.setStatus("Complete");
		Thread.sleep(5000);
		printinvoice.clickbtnSearch();
		Thread.sleep(5000);
		printinvoice.clickCheckboxStatusComplete();
		logger.info("****** Printing Invoice of Order Status Complete ******");
		printinvoice.setAction("Print Invoices");
		printinvoice.clickbtnSubmit();
		Thread.sleep(5000);
		logger.info("****** Verifying downloaded file exists ******");
		File statusFileDownload = printinvoice.isFileExist("C:\\Users\\namit\\Downloads");
		if (statusFileDownload.exists()) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

}
