package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CouponPage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_CouponTest_009 extends BaseClass {
	@Test
	public void discountCouponAppliedMsgTest() throws InterruptedException {
	driver.get(configProp.getProperty("URL"));
	SortByNamePage sortName = new SortByNamePage(driver);
	sortName.clickMEnuMobile();
	CouponPage cp=new CouponPage(driver);
	cp.clickIphoneAddToCart();
	logger.info("****** Setting couponcode ******");
	cp.setCouponCode("GURU50");
	cp.clickLnkApply();
	logger.info("****** Verifying Message Coupon Applied ******");
	boolean successMsgPresent=cp.verifySuccessMsg("Coupon code \"GURU50\" was applied.");
	Assert.assertEquals(successMsgPresent, true);
	}
	@Test
	public void percentageDiscountAppliedTest() throws InterruptedException {
		CouponPage cp=new CouponPage(driver);
		logger.info("****** Verifying Discount ******");
		boolean discountVerified=cp.verifycalculatedDiscount("SUBTOTAL", "DISCOUNT (GURU50)");
		Assert.assertEquals(discountVerified, true);
		
		
	}
	@Test
	public void totalDiscountedPriceTest() throws IOException {
		CouponPage cp=new CouponPage(driver);
		logger.info("****** Verifying total after discount ******");
		boolean statusDiscountAppliedOnTotal=cp.verifyTotalAfterDiscount("GRAND TOTAL");
		if(statusDiscountAppliedOnTotal==true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"totalDiscountedPriceTest");
			Assert.assertTrue(false);
		}
		
	}
}
