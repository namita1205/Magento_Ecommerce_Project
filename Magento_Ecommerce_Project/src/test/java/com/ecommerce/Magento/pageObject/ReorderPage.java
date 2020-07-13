package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class ReorderPage {
	WebDriver driver;
	WaitHelper waithelper;
	
	public ReorderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}
	@FindBy(xpath="//tr[@class='first odd']//a[@class='link-reorder'][contains(text(),'Reorder')]")
	WebElement lnkReorder;
	
	@FindBy(xpath="//input[@title='Qty']")
	WebElement txtQuantity;
	
	@FindBy(xpath="//button//span[text()='Update']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//input[@id='s_method_flatrate_flatrate']")
	WebElement btnFixedShipping;
	
	@FindBy(xpath="//span[contains(text(),'Update Total')]")
	WebElement btnUpdateAfterShipping;
	
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']//tfoot//tr//td[1]")
	WebElement txtGrandTotal;
	
	@FindBy(xpath="//table[@id='shopping-cart-totals-table']//tfoot//tr//td[2]")
	WebElement txtPrice;
	
	public void clickLnkReorder() {
		waithelper.waitForElement(lnkReorder, 30);
		lnkReorder.click();
	}
	public void setQuantity(String quantity) {
		waithelper.waitForElement(txtQuantity, 30);
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
		
	}
	public void clickBtnUpdate() {
		waithelper.waitForElement(btnUpdate, 30);
		btnUpdate.click();
	}
	
	public void clickbtnFixedShipping() {
		waithelper.waitForElement(btnFixedShipping, 30);
		btnFixedShipping.click();
	}
	
	public void clickbtnUpdateAfterShippingCost() {
		waithelper.waitForElement(btnUpdateAfterShipping, 30);
		btnUpdateAfterShipping.click();
	}
	
	public boolean verifyGrandtotalUpdate(String text,String pUpdated) {
		waithelper.waitForElement(txtGrandTotal, 30);
		String textTotal=txtGrandTotal.getText();
		System.out.println("Text:"+ textTotal);
		String totalPriceUpdate=txtPrice.getText();
		System.out.println("Grand total:"+ totalPriceUpdate);
		if(textTotal.equals(text)&& totalPriceUpdate.equals(pUpdated)) {
			return true;
			
		}
		return false;
	}

}
