package com.ecommerce.Magento.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ecommerce.Magento.pageObject.CreateAccountPage;
import com.ecommerce.Magento.pageObject.SortByNamePage;
import com.ecommerce.Magento.testBase.BaseClass;

public class TC_CreateAccountTest_005 extends BaseClass {
	@Test
	public void CreateAccountTest() throws InterruptedException {

		driver.get(configProp.getProperty("URL"));
		SortByNamePage sortName = new SortByNamePage(driver);
		sortName.clickMEnuMobile();

		CreateAccountPage ca = new CreateAccountPage(driver);
		logger.info("****** Clicking link Account ******");
		ca.clickLnkAccount();
		logger.info("****** Clicking link MyAccount ******");
		ca.clickLnkmyAccount();
		logger.info("****** Clicking link CreateAccount ******");
		ca.clickCreateAccount();
		logger.info("****** Filling Details ******");
		ca.setFirstName("Ninja");
		ca.setLastName("Tester");
		String email = randomstring() + "@gmail.com";
		ca.setEmail(email);
		ca.setPassword("tester");
		ca.setConfirmPassword("tester");
		logger.info("****** Clicking button Register ******");
		ca.clickBtnRegister();

	}

	@Test
	public void registrationMsgTest() throws IOException {
		CreateAccountPage ca = new CreateAccountPage(driver);
		logger.info("****** Verifying Registration Confirmation Message ******");
		

		boolean registerConfirmed = ca.verifyConfirmationMsg("Thank you for registering with Main Website Store.");
		Assert.assertEquals(registerConfirmed, true);
	}

	@Test
	public void verifyMsghelloTest() throws IOException {
		CreateAccountPage ca = new CreateAccountPage(driver);
		logger.info("****** Verifying message Hello ******");
		
		boolean msghelloConfirmed = ca.verifyNameMsg("Hello, Ninja Tester!");
		if (msghelloConfirmed == true) {
			logger.info("****** Test is Passed ******");
			Assert.assertTrue(true);
		} else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"verifyMsghelloTest");
			Assert.assertTrue(false);
		}
		// Assert.assertEquals(msghelloConfirmed, true);
	}

	@Test
	public void wishlistShareTest() throws InterruptedException, IOException {
		CreateAccountPage ca = new CreateAccountPage(driver);
		ca.clickLnkTV();
		
		logger.info("****** Clicking lnk Add To Wish ******");
		ca.clicklnkAddToWish();
		logger.info("****** Clicking lnk Share Wish List ******");
		ca.clickShareWishlist();
		ca.setShareEmail("cool123@gmail.com");
		ca.setMessage("Wish I could have it...");
		ca.clickShareWishlist();
		logger.info("****** Verifying Wish List is Shared ******");
		
		boolean ShareWishlistConfirmed = ca.verifyConfirmationMsg("Your Wishlist has been shared.");
		if(ShareWishlistConfirmed==true) {
			logger.info("****** Test is Passed ******");
			
			Assert.assertTrue(true);
		}else {
			logger.info("****** Test is Failed ******");
			captureScreen(driver,"wishlistShareTest");
			Assert.assertTrue(false);
		}
		

	}

}
