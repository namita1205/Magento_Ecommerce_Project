package com.ecommerce.Magento.pageObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SortByNamePage {
	public WebDriver driver;

	public SortByNamePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[contains(text(),'Mobile')]")
	WebElement menuMobile;

	@FindBy(xpath = "//div[@class='toolbar-bottom']//select[@title='Sort By']")
	WebElement selectDropdown;

	@FindBy(xpath = "//li//div//h2//a")
	List<WebElement> productList;

	public boolean verifyPageTitle() {
		String Exp_title = "Home page";
		String Act_title = driver.getTitle();
		if (Act_title.equals(Exp_title)) {
			return true;
		}
		return false;
	}

	public void clickMEnuMobile() {
		menuMobile.click();
	}

	public boolean verifyPageTitleAfterClick() {
		String Exp_title = "Mobile";
		String Act_title = driver.getTitle();
		if (Act_title.equals(Exp_title)) {
			return true;
		}
		return false;
	}

	public void selectDropdown(String name) {
		Select sel = new Select(selectDropdown);
		sel.selectByVisibleText(name);
	}

	public boolean verifySortByName() {
		ArrayList<String> obtainedList = new ArrayList<String>();
		for (WebElement products : productList) {
			obtainedList.add(products.getText());
		}

		System.out.println("Obtained list:" + obtainedList);

		ArrayList<String> sortedList = new ArrayList<String>();
		for (String s : obtainedList) {
			sortedList.add(s);

		}
		Collections.sort(sortedList);

		System.out.println("Sorted list after sort:" + sortedList);

		if (obtainedList.equals(sortedList)) {
			return true;
		}
		return false;
	}

}
