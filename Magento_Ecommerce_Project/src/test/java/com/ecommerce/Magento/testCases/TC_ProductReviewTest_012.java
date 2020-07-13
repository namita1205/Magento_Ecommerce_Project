package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.DetailsPage;
import com.ecommerce.Magento.pageObject.ProductReviewPage;
import com.ecommerce.Magento.pageObject.ReadingFromCSVFilePage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_ProductReviewTest_012 extends BaseClass {
	@Test
	public void fillReview() throws InterruptedException {
		driver.get("http://live.demoguru99.com/index.php/review/product/list/id/1/");
		ProductReviewPage review = new ProductReviewPage(driver); 
		logger.info("****** Setting Review ******");
		review.setReview("Great Mobile,Good Camera,Long Battery Life");
		review.setReviewSummary("Must Have");
		review.setNickname("CoolNinja");
		Thread.sleep(3000);
		logger.info("****** Clicking on Submit Button ******");
		review.clickbtnSubmit();
		
	}
	@Test
	public void setProductReviewApproved() throws InterruptedException {
		driver.get("http://live.demoguru99.com/index.php/backendlogin");
		ReadingFromCSVFilePage readcsvfile=new ReadingFromCSVFilePage(driver); 
		logger.info("****** Logging into Application ******");
		readcsvfile.setUsername("user01");
		readcsvfile.setPassword("guru99com");
		readcsvfile.clickbtnLogin();
		readcsvfile.clickbtnpopupclose();
		ProductReviewPage review = new ProductReviewPage(driver);
		logger.info("****** Navigating to customer review ******");
		review.moveTocatalog();
		review.moveToReviewandRating();
		review.moveToCustomerReview();
		Thread.sleep(3000);
		review.clickPendingReview();
		review.clickCheckbox();
		review.clickbtnEdit();
		logger.info("****** Setting to Approved in dropdown and saving it ******");
		review.drpdownSelect("Approved");
		review.btnSave();
	}
	@Test
	public void verifyReviewApproved() throws InterruptedException, IOException {
		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName = new SortByNamePage(driver);
		sortName.clickMEnuMobile();
		
		DetailsPage productDetail=new DetailsPage(driver);
		productDetail.clickImg();
		ProductReviewPage review = new ProductReviewPage(driver);
		review.clickbtnReview();
		Thread.sleep(3000);
		logger.info("****** Verifying Review Added ******");
		boolean statusmsg1=review.msgreview1("MUST HAVE");
		if(statusmsg1==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"verifyReviewApproved");
			Assert.assertTrue(false);
		}
		
		boolean statusmsg2=review.msgreview2("Great Mobile,Good Camera,Long Battery Life REVIEW BY COOLNINJA");
		Assert.assertEquals(statusmsg2, true);
		
	}
	

}
