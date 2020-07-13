package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class SaveOrderAsPdfPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public SaveOrderAsPdfPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}

	@FindBy(xpath = "//table//thead//tr//th[1]")
	WebElement tableHeadingOrder;

	@FindBy(xpath = "//table//thead//tr//th[5]")
	WebElement tableStatusheading;

	@FindBy(xpath = "//table//tbody//tr//td[1]")
	WebElement orderNo;

	@FindBy(xpath = "//table//tbody//tr//td[5]")
	WebElement statusValue;
	
	@FindBy(xpath="//tr[@class='first odd']//a[contains(text(),'View Order')]")
	WebElement lnkViewOrder;
	
	@FindBy(xpath="//a[@class='link-print']")
	WebElement printOrder;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//cr-button[1]")
	WebElement btnSave;
	
	public boolean verifyPreviousOrder(String horder) {
		waithelper.waitForElement(tableHeadingOrder, 30);
		String ordno="";
		String headingOrder=tableHeadingOrder.getText();
		System.out.println("Heading Order:"+ headingOrder);
		if(headingOrder.equals(horder)) {
			 ordno=orderNo.getText();
			 System.out.println("Order Number:"+ ordno);
		}
		PurchaseOrderPage po=new PurchaseOrderPage(driver);
		System.out.println("From Method:"+ po.getOrderNumber());
		if(po.getOrderNumber().contains(ordno)){
			return true;
		}
		return false;
	}
	
	public boolean verifyStatusvalue(String sheading, String svalue) {
		waithelper.waitForElement(tableStatusheading, 30);
		String hstatus=tableStatusheading.getText();
		if(hstatus.equals(sheading)) {
		String sval=statusValue.getText();
		System.out.println("Status Value:"+ sval);
		if(sval.equals(svalue)) {
			return true;
		}
	
		}
		return false;
	}
	public void clickViewOrder() {
		waithelper.waitForElement(lnkViewOrder, 30);
		lnkViewOrder.click();
		
	}
	public void clickPrintOrder() {
		waithelper.waitForElement(printOrder, 30);
		printOrder.click();
	}
	public void clickBtnSave() {
		waithelper.waitForElement(btnSave, 30);
		btnSave.click();
	}

}
