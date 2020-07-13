package com.ecommerce.Magento.pageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class SearchFunctionalityPage {
	public WebDriver driver;
	WaitHelper waithelper;

	public SearchFunctionalityPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}

	@FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
	WebElement lnkAdvanceSearch;

	@FindBy(xpath = "//input[@name='price[from]']")
	WebElement txtPriceFrom;

	@FindBy(xpath = "//input[@name='price[to]']")
	WebElement txtPriceTo;

	@FindBy(xpath = "//div[@class='buttons-set']//button[@class='button']")
	WebElement btnSearch;

	@FindBy(xpath = "//li//div[@class='product-info']//h2")
	List<WebElement> txtMobileName;

	@FindBy(xpath = "//div[@class='price-box']//span[@class='regular-price']")
	List<WebElement> txtPrice;

	@FindBy(xpath = "//p[@class='special-price']")
	WebElement specialPrice;

	@FindBy(xpath = "//a[contains(text(),'Modify your search')]")
	WebElement lnkModifySearch;

	public void clickAdvanceSearch() {
		waithelper.waitForElement(lnkAdvanceSearch, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkAdvanceSearch);
		lnkAdvanceSearch.click();
	}

	public void setPriceFrom(String pricefrom) {
		waithelper.waitForElement(txtPriceFrom, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtPriceFrom);
		txtPriceFrom.clear();
		txtPriceFrom.sendKeys(pricefrom);

	}

	public void setPriceTo(String priceTo) {
		waithelper.waitForElement(txtPriceTo, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", txtPriceTo);
		txtPriceTo.clear();
		txtPriceTo.sendKeys(priceTo);

	}

	public void clickbtnSearch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", btnSearch);
		btnSearch.click();
	}

	public boolean verifytxtMobileNames() {
		boolean found = false;
		
		for (WebElement mobnames : txtMobileName) {
			if (mobnames.isDisplayed()) {
				String namesOfmobile = mobnames.getText();
				System.out.println("Mobile Names:" + namesOfmobile);
				found = true;
			}

		}
		return found;
	}

	public boolean verifytxtPrice() {
		boolean found = false;
		
		for (WebElement mobprice : txtPrice) {
			if (mobprice.isDisplayed()) {
				String priceOfmobile = mobprice.getText();
				System.out.println("Mobile Price:" + priceOfmobile);
				found = true;
			}

		}
		return found;
	}

	public void verifySpecialPrice() {

		System.out.println("Special Price:" + specialPrice.getText());
	}

	public void clickModifySearch() {
		lnkModifySearch.click();
	}

}
