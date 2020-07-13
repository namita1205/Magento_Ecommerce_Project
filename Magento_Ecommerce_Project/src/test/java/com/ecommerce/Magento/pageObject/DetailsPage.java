package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class DetailsPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public DetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}

	@FindBy(xpath = "//img[@id='product-collection-image-1']")
	WebElement LnkImg;

	@FindBy(xpath = "//span[@id='product-price-1']")
	WebElement txtPrice;

	@FindBy(xpath = "//div[@class='product-shop']//div[@class='product-name']")
	WebElement txtMobileName;

	@FindBy(xpath = "//span[@class='price']")
	WebElement txtSonyXperiaPrice;

	public String getListPagePrice() {
		waithelper.waitForElement(txtPrice, 30);
		return txtPrice.getText();
	}

	public void clickImg() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", LnkImg);
		LnkImg.click();

	}

	public String getDetailsPagePrice() {
		waithelper.waitForElement(txtMobileName, 30);
		String SonyXperiaPrice = "";
		String mobileName = txtMobileName.getText();

		if (mobileName.equals("SONY XPERIA")) {
			SonyXperiaPrice = txtSonyXperiaPrice.getText();

		}

		return SonyXperiaPrice;
	}

}
