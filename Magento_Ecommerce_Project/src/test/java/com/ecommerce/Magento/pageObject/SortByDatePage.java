package com.ecommerce.Magento.pageObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class SortByDatePage {
	public WebDriver driver;
	WaitHelper waithelper;
	public ArrayList<Date> sortedlist = null;
	public ArrayList<Date> obtainedlist = null;

	public SortByDatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(driver);
	}

	@FindBy(xpath = "//table[@class='data']//tr//td[3]")
	List<WebElement> datesWebtable;

	@FindBy(xpath = "//span[contains(text(),'Invoices')]")
	WebElement lnkInvoices;

	@FindBy(xpath = "//span[contains(text(),'Invoice Date')]")
	WebElement invoicedate;

	public void clickInvoices() {
		waithelper.waitForElement(lnkInvoices, 30);
		lnkInvoices.click();
	}

	public void clickinvoicedate() {
		waithelper.waitForElement(invoicedate, 30);
		invoicedate.click();
	}

	public void setArrayListOfDates() throws ParseException {
		Date date = null;

		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy hh:mm:ss a");
		obtainedlist = new ArrayList<Date>();
		
		for (WebElement dates : datesWebtable) {
			String datetext = dates.getText();
			System.out.println(datetext);
			date = sdf.parse(datetext);

			obtainedlist.add(date);

		}
		System.out.println("Obtained List:" + obtainedlist);
		sortedlist = new ArrayList<Date>();
		for (Date datefromObtainedlist : obtainedlist) {
			sortedlist.add(datefromObtainedlist);
		}
		System.out.println("Sorted List before:" + sortedlist);
	}

	public boolean sortdateAscending() {

		Collections.sort(sortedlist);
		// Collections.reverse(sortedlist);
		System.out.println("Sorted List After Sorting:" + sortedlist);
		if (obtainedlist.equals(sortedlist)) {
			return true;
		}
		return false;
	}

	public boolean sortdateDescending() {

		Collections.sort(sortedlist, Collections.reverseOrder());
		System.out.println("Sorted List After desc Sorting:" + sortedlist);
		if (obtainedlist.equals(sortedlist)) {
			return true;
		}
		return false;
	}

}
