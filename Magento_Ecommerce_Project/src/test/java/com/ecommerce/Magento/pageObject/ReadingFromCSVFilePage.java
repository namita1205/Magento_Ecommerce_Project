package com.ecommerce.Magento.pageObject;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ecommerce.Magento.utilities.WaitHelper;
import com.opencsv.CSVReader;

public class ReadingFromCSVFilePage {
	public WebDriver driver;
	WaitHelper waithelper;

	public ReadingFromCSVFilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);

	}

	@FindBy(id = "username")
	WebElement txtusername;

	@FindBy(id = "login")
	WebElement txtpassword;

	@FindBy(xpath = "//input[@class='form-button']")
	WebElement btnLogin;

	@FindBy(xpath = "//span[contains(text(),'close')]")
	WebElement btnpopupclose;

	@FindBy(xpath = "//*[@id=\"nav\"]/li[1]/a")
	WebElement lnkSales;

	@FindBy(xpath = "//span[contains(text(),'Orders')]")
	WebElement lnkOrders;

	// @FindBy(xpath="//table[@class='actions']//tbody//tr//td[2]//select")
	// WebElement selectCSV;

	@FindBy(xpath = "//table[@class='actions']//tbody//tr//td[2]//button")
	WebElement lnkExport;

	public void setUsername(String uname) {
		waithelper.waitForElement(txtusername, 30);
		txtusername.sendKeys(uname);

	}

	public void setPassword(String password) {
		waithelper.waitForElement(txtpassword, 30);
		txtpassword.sendKeys(password);
	}

	public void clickbtnLogin() {
		btnLogin.click();
	}

	public void clickbtnpopupclose() {
		waithelper.waitForElement(btnpopupclose, 30);
		btnpopupclose.click();
	}

	public void clicklnkSales() {
		Actions act = new Actions(driver);
		waithelper.waitForElement(lnkSales, 30);
		act.moveToElement(lnkSales).build().perform();
		// lnkSales.click();
	}

	public void clicklnkOrders() {
		waithelper.waitForElement(lnkOrders, 30);
		lnkOrders.click();
	}

//	public void drpdownSelectFile(String filename) {
//		Select sel=new Select(selectCSV);
//		sel.selectByVisibleText(filename);
//	}
	public void clicklnkExport() {
		waithelper.waitForElement(lnkExport, 30);
		lnkExport.click();
	}

	public void readingCSVFile() throws IOException {
		String path = "C:\\Users\\namit\\Downloads\\orders.csv";
		int line=0;

		CSVReader reader = new CSVReader(new FileReader(path));

		for (String[] row : reader) {
			System.out.println(++line+ " "+ Arrays.toString(row));
			
		}
//		File file=new File(path);
//		int lineNo=0;
//		try {
//			Scanner inputstream=new Scanner(file);
//			while(inputstream.hasNext()) {
//				String data=inputstream.nextLine();
//				
//				System.out.println(++lineNo+":"+data);
//				
//			}
//			inputstream.close();
//		} catch (FileNotFoundException e) {
//			System.out.println(e);
//			e.printStackTrace();
//		}
//		BufferedReader br = new BufferedReader(new FileReader(new File(path)));
//		 String available;
//		 while ((available = br.readLine()) != null) {
//		     System.out.println(available);
//	}

	}

}