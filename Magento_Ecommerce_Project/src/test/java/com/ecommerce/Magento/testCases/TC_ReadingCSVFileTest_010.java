package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.ReadingFromCSVFilePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_ReadingCSVFileTest_010 extends BaseClass {
	@Test
	public void exportCSVFiletest() throws InterruptedException, IOException {
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		ReadingFromCSVFilePage readcsvfile = new ReadingFromCSVFilePage(driver);
		logger.info("****** Logging into backend application ******");
		readcsvfile.setUsername("user01");
		readcsvfile.setPassword("guru99com");
		readcsvfile.clickbtnLogin();
		readcsvfile.clickbtnpopupclose();
		readcsvfile.clicklnkSales();
		readcsvfile.clicklnkOrders();
		// Thread.sleep(3000);
		// readcsvfile.drpdownSelectFile("CSV");
		readcsvfile.clicklnkExport();
		readcsvfile.readingCSVFile();

	}

}
