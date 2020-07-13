package com.ecommerce.Magento.pageObject;


import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class CompareTwoMobilesPage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public String title;
	private String mainWindowHandle="";
	private String popUpHandle = "";
	WaitHelper waithelper;
	
	

	public CompareTwoMobilesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}

	@FindBy(xpath = "//li[1]//div[1]//div[3]//ul//li[2]//a[@class='link-compare']")
	WebElement lnkCompareSony;

	@FindBy(xpath = "//li[2]//div[1]//div[3]//ul//li[2]//a[@class='link-compare']")
	WebElement lnkCompareIPhone;

	@FindBy(xpath = "//button[@class='button']//span//span[contains(text(),'Compare')]")
	WebElement btnCompare;

	@FindBy(xpath = "//h1[contains(text(),'Compare Products')]")
	WebElement txtheading;
	
	@FindBy(xpath="//h2//a[@title='Sony Xperia']")
	WebElement txtNameMobile1;
	
	@FindBy(xpath="//h2//a[@title='IPhone']")
	WebElement txtNameMobile2;
	
	@FindBy(xpath="//button[@title='Close Window']")
	WebElement btnCloseWindow;

	public void clicklnkAddToCompareSony() {
		waithelper.waitForElement(lnkCompareSony, 30);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkCompareSony);
		lnkCompareSony.click();
	}

	public void clicklnkAddToCompareIPhone() {
		waithelper.waitForElement(lnkCompareIPhone, 30);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", lnkCompareIPhone);
		lnkCompareIPhone.click();

	}

	public void clickBtnAndIdentifyHandles(String popUpTitle) throws InterruptedException {
		waithelper.waitForElement(btnCompare, 30);
		btnCompare.click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("handles:"+handles);
		Thread.sleep(3000);


		for (String handle : handles) {

			driver.switchTo().window(handle);
			 title = driver.getTitle();
			System.out.println("Title:"+title);
			if (title.equals(popUpTitle)) {
				System.out.println(title);
				popUpHandle = handle;
			}
			else {
				mainWindowHandle=handle;
			}


		}

		
		

	}
	public void clickLnkCloseWindow() {
		waithelper.waitForElement(btnCloseWindow, 30);
		btnCloseWindow.click();
	}

	public boolean verifyheadingOnPage(String text,String name1,String name2) {
		driver.switchTo().window(popUpHandle);
		System.out.println("Expected pop up:"+ driver.getTitle());
		waithelper.waitForElement(txtheading, 30);
		String heading = txtheading.getText();
		String mobileName1=txtNameMobile1.getText();
		String mobileName2=txtNameMobile2.getText();
		
		if ((heading.equals(text))&& (mobileName1.equals(name1))&&(mobileName2.equals(name2))) {
			System.out.println("mobileName1:"+ mobileName1);
			System.out.println("mobileName2:"+ mobileName2);
			driver.close();
			//this.clickLnkCloseWindow();
		return true;

		}else {
			System.out.println(heading);
		}
		
		return false;
	}
	public void toParentWindow() {
		driver.switchTo().window(mainWindowHandle);
		System.out.println("MAin title:"+ driver.getTitle());
		
	System.out.println(driver.getCurrentUrl());
		}
	}


