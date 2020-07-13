package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class DisabledFieldPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public DisabledFieldPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}

	@FindBy(xpath = "//tr[1]//td[11]//a[1]")
	WebElement btnEdit;

	@FindBy(xpath = "//span[contains(text(),'Account Information')]")
	WebElement lnkAccountInfo;

	@FindBy(xpath = "//select[@id='_accountwebsite_id']")
	WebElement txtAssociateToWebsite;

	@FindBy(xpath = "//input[@id='_accountcreated_in']")
	WebElement txtCreatedFrom;

	@FindBy(xpath = "//input[@id='_accountnew_password']")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@id='_accountlastname']")
	WebElement txtLastname;

	public void clickbtnEdit() {
		waithelper.waitForElement(btnEdit, 30);
		btnEdit.click();
	}

	public void clicklnkAccountinfo() {
		waithelper.waitForElement(lnkAccountInfo, 30);
		lnkAccountInfo.click();
	}

	public boolean verifyDisabledFields() {
		waithelper.waitForElement(txtAssociateToWebsite, 30);
		waithelper.waitForElement(txtCreatedFrom, 30);
		if (txtAssociateToWebsite.isEnabled() && txtCreatedFrom.isEnabled()) {
			System.out.println("Input Fields are Enabled");
			return true;
		} else {
			System.out.println("Input Fields are Disabled");
			return false;
		}
	}

	public boolean verifyPasswordFieldBlank() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtpassword);
		System.out.println("Password Attribute Value:" + txtpassword.getAttribute("value"));
		// boolean status = txtpassword.getText().trim().isEmpty();
		// boolean status=txtpassword.getAttribute("value").isEmpty();
		boolean status = txtpassword.getAttribute("value").equals("");
		if (status == true) {
			System.out.println("Password Field is Blank");
			return true;
		} else {
			System.out.println("Password Field is not Blank");
			return false;
		}
	}

	public boolean verifyLastnameFieldBlank() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtLastname);
		System.out.println(txtLastname.getAttribute("value"));
		// boolean status = txtLastname.getAttribute("value").isEmpty();
		boolean status = txtLastname.getAttribute("value").equals("");
		System.out.println("Lastname Status:" + status);
		if (status == true) {
			System.out.println("Lastname Field is Blank");
			return true;
		} else {
			System.out.println("Lastname Field is not Blank");
			return false;
		}
	}
}
