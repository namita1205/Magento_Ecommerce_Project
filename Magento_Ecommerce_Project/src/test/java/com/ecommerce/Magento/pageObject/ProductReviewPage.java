package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecommerce.Magento.utilities.WaitHelper;

public class ProductReviewPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public ProductReviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}
	@FindBy(xpath="//textarea[@id='review_field']")
	WebElement txtReviewBox;
	
	@FindBy(xpath="//input[@id='summary_field']")
	WebElement txtReviewSummary;
	
	
	@FindBy(xpath="//input[@id='nickname_field']")
	WebElement txtNickname;
	
	@FindBy(xpath="//button[@title='Submit Review']")
	WebElement btnSubmitReview;
	
	@FindBy(xpath="//span[contains(text(),'Catalog')]")
	WebElement lnkCatalog;
	
	@FindBy(xpath="//span[contains(text(),'Reviews and Ratings')]")
	WebElement lnkReviewandRatings;
	
	@FindBy(xpath="//span[contains(text(),'Customer Reviews')]")
	WebElement lnkCustomerReview;
	
	@FindBy(xpath="//span[contains(text(),'Pending Reviews')]")
	WebElement lnkPendingReview;
	

	@FindBy(xpath="//table//tbody//tr[1]//td//input[@class='massaction-checkbox']")
	WebElement checkbox;
	
	@FindBy(xpath="//tr[1]//td[10]//a[1]")
	WebElement btnEdit;
	
	@FindBy(xpath="//select[@id='status_id']")
	WebElement drpdown;
	
	@FindBy(xpath="//div[@id='page:main-container']//button[@id='save_button']")
	WebElement btnSave;
	
	
	
	
	@FindBy(xpath="//li[@class='last']//span[contains(text(),'Reviews')]")
	WebElement btnReview;
	
	@FindBy(xpath="//dl//dt[1]//a[contains(text(),'Must Have')]")
	WebElement msgReview1;
	
	@FindBy(xpath="//dd[@class='tab-container last current']//dd[1]")
	WebElement msgReview2;
	
	
	
	
	
	public void setReview(String review) {
		waithelper.waitForElement(txtReviewBox, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtReviewBox);
		txtReviewBox.sendKeys(review);
	}
	
	public void setReviewSummary(String RSummary) {
		waithelper.waitForElement(txtReviewSummary, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtReviewSummary);
		txtReviewSummary.sendKeys(RSummary);
	}
	
	public void setNickname(String nickname) {
		waithelper.waitForElement(txtNickname, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtNickname);
		txtNickname.sendKeys(nickname);
	}
	public void clickbtnSubmit() {
		btnSubmitReview.click();
	}
	public void moveTocatalog() {
		waithelper.waitForElement(lnkCatalog, 30);
		Actions move=new Actions(driver);
		move.moveToElement(lnkCatalog).build().perform();
	}
	
	public void moveToReviewandRating() {
		Actions move=new Actions(driver);
		move.moveToElement(lnkReviewandRatings).build().perform();
	}
	public void moveToCustomerReview() {
		waithelper.waitForElement(lnkCustomerReview, 30);
		Actions move=new Actions(driver);
		move.moveToElement(lnkCustomerReview).build().perform();
	}
	public void clickPendingReview() {
		waithelper.waitForElement(lnkPendingReview, 30);
		lnkPendingReview.click();
	}
	
	public void clickCheckbox() {
		waithelper.waitForElement(checkbox, 30);
	checkbox.click();
	}
	public void clickbtnEdit() {
		waithelper.waitForElement(btnEdit, 30);
	btnEdit.click();
	}
	public void drpdownSelect(String value) {
		waithelper.waitForElement(drpdown, 30);
	Select sel=new Select(drpdown);
	sel.selectByVisibleText(value);
	}
	public void btnSave() {
	btnSave.click();
	}
	
	
	public void clickbtnReview() {
		waithelper.waitForElement(btnReview, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnReview);
		btnReview.click();
	}
	public boolean msgreview1(String Exp_Msg1) {
		waithelper.waitForElement(msgReview1, 30);
		String Act_Msg1=msgReview1.getText();
		System.out.println(Act_Msg1);
		if(Act_Msg1.equals(Exp_Msg1)) {
			return true;
		}
		return false;
	}
	public boolean msgreview2(String Exp_Msg2) {
		waithelper.waitForElement(msgReview2, 30);
		String Act_Msg2=msgReview2.getText();
		System.out.println(Act_Msg2);
		if(Act_Msg2.contains(Exp_Msg2)) {
			return true;
		}
		return false;
	}
	

}
