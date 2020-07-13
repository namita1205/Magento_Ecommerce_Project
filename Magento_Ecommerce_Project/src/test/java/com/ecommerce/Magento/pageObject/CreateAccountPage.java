package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class CreateAccountPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}
	@FindBy(xpath="//a[@class='skip-link skip-account']//span[@class='label']")
	WebElement lnkAccount;
	
	@FindBy(xpath="//div[@id='header-account']//li[@class='first']//a[@title='My Account']")
	WebElement lnkMyAccount;
	
	@FindBy(xpath="//a//span[text()='Create an Account']")
	WebElement lnkCreateAccount;
	
	@FindBy(xpath="//input[@id='firstname']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	WebElement txtLastName;
	
	@FindBy(xpath="//input[@id='email_address']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='confirmation']")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="//button[@title='Register']")
	WebElement btnRegister;
	
	@FindBy(xpath="//li//span")
	WebElement msgConfirmationDisplayed;
	
	@FindBy(xpath="//p[@class='hello']")
	WebElement msgConfirmationName;
	
	@FindBy(xpath="//a[contains(text(),'TV')]")
	WebElement lnkTV;
	
	@FindBy(xpath="//li[1]//div[1]//div[3]//ul[1]//li[1]//a[1]")

	WebElement lnkAddToWish;
	
	@FindBy(xpath="//span[contains(text(),'Share Wishlist')]")
	WebElement lnkShareWishlist;
	
	@FindBy(xpath="//textarea[@id='email_address']")
	WebElement txtEmailShare;
	
	@FindBy(xpath="//textarea[@id='message']")
	WebElement txtMsgShare;
	
	
	
	public void clickLnkAccount() {
		waithelper.waitForElement(lnkAccount, 30);
		lnkAccount.click();
	}
	public void clickLnkmyAccount() {
		waithelper.waitForElement(lnkMyAccount, 30);
		lnkMyAccount.click();
	}
	public void clickCreateAccount() {
		waithelper.waitForElement(lnkCreateAccount, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkCreateAccount);
		lnkCreateAccount.click();
	}
	public void setFirstName(String fname) {
		
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtLastName);
		
		txtLastName.sendKeys(lname);
	}
	
	public void setEmail(String email) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtEmail);
		
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtPassword);
		
		txtPassword.sendKeys(password);
	}
	public void setConfirmPassword(String cp) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtConfirmPassword);
		
		txtConfirmPassword.sendKeys(cp);
	}
	public void clickBtnRegister() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnRegister);
		
		btnRegister.click();
	}
	public boolean verifyConfirmationMsg(String text) {
		waithelper.waitForElement(msgConfirmationDisplayed, 30);
		String msg=msgConfirmationDisplayed.getText();
		System.out.println(msg);
		if(msg.equals(text)) {
			return true;
		}
		return false;
	}
	public boolean verifyNameMsg(String nameMsg) {
		waithelper.waitForElement(msgConfirmationName, 30);
		String msghello=msgConfirmationName.getText();
		System.out.println(msghello);
		if(msghello.equals(nameMsg)) {
			return true;
		}
		return false;
	}
	public void clickLnkTV() {
		waithelper.waitForElement(lnkTV, 30);
		lnkTV.click();
		
	}
	public void clicklnkAddToWish() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkAddToWish);
		
		lnkAddToWish.click();
	}
	public void clickShareWishlist() {
		lnkShareWishlist.click();
	}
	public void setShareEmail(String shareEmail) {
		txtEmailShare.sendKeys(shareEmail);
		
	}
	public void setMessage(String message) {
		txtMsgShare.sendKeys(message);
		
	}
	public boolean verifyWishlistMsg(String text) {
		waithelper.waitForElement(msgConfirmationDisplayed, 30);
		String msgWishlist=msgConfirmationDisplayed.getText();
		System.out.println(msgWishlist);
		if(msgWishlist.equals(text)) {
			return true;
		}
		return false;
	}
	
	
	
	
	

}
