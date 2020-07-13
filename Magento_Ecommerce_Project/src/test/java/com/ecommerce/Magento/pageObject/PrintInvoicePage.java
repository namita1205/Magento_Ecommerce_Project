package com.ecommerce.Magento.pageObject;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecommerce.Magento.utilities.WaitHelper;

public class PrintInvoicePage {
	public WebDriver driver;
	WaitHelper waithelper;

	public PrintInvoicePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}

	@FindBy(xpath = "//thead//tr[@class='filter']//th[8]//select")
	WebElement drpdownStatus;

	@FindBy(xpath = "//table[@class='actions']//tbody//tr//td//button[@title='Search']//span//span//span")
	WebElement btnSearch;

	@FindBy(xpath = "//div[@class='grid']//tr[1]//td[1]//input[1]")
	WebElement btncheckbox;

	@FindBy(xpath = "//select[@id='sales_order_grid_massaction-select']")
	WebElement drpdownAction;

	@FindBy(xpath = "//span[@class='field-row']//button")
	WebElement btnSubmit;

	@FindBy(xpath = "//ul//li[@class='error-msg']//ul//li//span")
	WebElement errorMsg;

	@FindBy(xpath = "//input[@name='order_ids']")
	WebElement checkboxStatusComplete;

	public void setStatus(String status) {
		waithelper.waitForElement(drpdownStatus, 30);
		Select sel = new Select(drpdownStatus);
		sel.selectByVisibleText(status);

	}

	public void clickbtnSearch() {
		waithelper.waitForElement(btnSearch, 30);
		btnSearch.click();
	}

	public void clickChechbox() {
		waithelper.waitForElement(btncheckbox, 30);
		btncheckbox.click();
	}

	public void setAction(String action) {
		waithelper.waitForElement(drpdownAction, 30);
		Select sel = new Select(drpdownAction);
		sel.selectByVisibleText(action);

	}

	public void clickbtnSubmit() {
		waithelper.waitForElement(btnSubmit, 30);
		btnSubmit.click();
	}

	public boolean verifyErrorMsg(String Exp_msg) {
		waithelper.waitForElement(errorMsg, 30);
		String Act_msg = errorMsg.getText();
		System.out.println(Act_msg);
		if (Act_msg.equals(Exp_msg)) {
			return true;
		}
		return false;
	}

	public void clickCheckboxStatusComplete() {
		waithelper.waitForElement(checkboxStatusComplete, 30);
		checkboxStatusComplete.click();
	}

	public File isFileExist(String loc) {

		File f = new File(loc);
		File[] files = f.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastmodifiedfile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastmodifiedfile.lastModified() < files[i].lastModified()) {
				lastmodifiedfile = files[i];
			}
		}
		System.out.println(lastmodifiedfile.getAbsolutePath());
		return lastmodifiedfile;

	}

}
