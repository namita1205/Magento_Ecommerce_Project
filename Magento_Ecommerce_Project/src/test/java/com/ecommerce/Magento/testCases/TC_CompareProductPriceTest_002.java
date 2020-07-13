package com.ecommerce.Magento.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.DetailsPage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_CompareProductPriceTest_002 extends BaseClass {
	@Test
	public void ComparePriceTest() throws InterruptedException {
		
		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName=new SortByNamePage(driver);
		sortName.clickMEnuMobile();
		DetailsPage productDetail=new DetailsPage(driver);
		logger.info("****** Storing list price ******");
		String ListpriceSony=productDetail.getListPagePrice();
		
		productDetail.clickImg();
		Thread.sleep(5000);
		logger.info("****** Storing price from detail page ******");
		String DetailspriceSony= productDetail.getDetailsPagePrice();
		logger.info("****** Comparing both Prices ******");
		if(ListpriceSony.equals(DetailspriceSony)) {
			System.out.println("Details page price:"+ DetailspriceSony);
			System.out.println("List price:"+ ListpriceSony);
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
	
		}
		else {
			System.out.println(DetailspriceSony);
			
			System.out.println(ListpriceSony);
			logger.error("****** Test is Failed ******");
			Assert.assertTrue(false);
		}
	}

	

}
