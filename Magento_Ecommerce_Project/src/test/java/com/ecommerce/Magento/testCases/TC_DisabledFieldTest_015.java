package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.DisabledFieldPage;
import com.ecommerce.Magento.pageObject.ReadingFromCSVFilePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_DisabledFieldTest_015 extends BaseClass {
	@Test
	public void disabledAndBlankFieldTest() throws InterruptedException, IOException {
	driver.get("http://live.demoguru99.com/index.php/backendlogin");
	ReadingFromCSVFilePage readcsvfile=new ReadingFromCSVFilePage(driver); 
	readcsvfile.setUsername("user01");
	readcsvfile.setPassword("guru99com");
	readcsvfile.clickbtnLogin();

	readcsvfile.clickbtnpopupclose();

	DisabledFieldPage dp=new DisabledFieldPage(driver);
	dp.clickbtnEdit();
	dp.clicklnkAccountinfo();
	Thread.sleep(5000);
	boolean statusDisabledField=dp.verifyDisabledFields();
	if(statusDisabledField==true) {
		logger.info("****** Disabled Field Test is Passed ******");
		Assert.assertTrue(true);
	}else {
		logger.info("****** Disabled Field Test is Failed ******");
		captureScreen(driver,"disabledAndBlankFieldTest");
		Assert.assertTrue(false);
	}
	
	Thread.sleep(3000);
	boolean statusBlankField=dp.verifyPasswordFieldBlank();
	if(statusBlankField==true) {
		logger.info("****** Password Field Blank Test is Passed ******");
		Assert.assertTrue(true);
	}else {
		logger.info("****** Password Field Blank Test is Failed ******");
		captureScreen(driver,"disabledAndBlankFieldTest");
		Assert.assertTrue(false);
	}
	
	boolean statusLastnameField=dp.verifyLastnameFieldBlank();
	Assert.assertEquals(statusLastnameField, false);
	}
}
