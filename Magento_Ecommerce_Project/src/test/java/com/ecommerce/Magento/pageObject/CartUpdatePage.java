package com.ecommerce.Magento.pageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.Magento.utilities.WaitHelper;

public class CartUpdatePage {
	public WebDriver driver;
	WaitHelper waithelper;

	public CartUpdatePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waithelper=new WaitHelper(driver);

	}
	@FindBy(xpath="//li[1]//div[1]//div[3]//button[1]//span[1]//span[1]")
	WebElement btnAddToCart;
	
	@FindBy(xpath="//table//tbody//tr[@class='first last odd']//td[4]//input")
	WebElement txtQuantity;
	
	@FindBy(xpath="//button[@title='Update']")
	WebElement btnUpdate;
	
	@FindBy(xpath="//ul[@class='messages']")
	WebElement txterrorMessage1;
	
	@FindBy(xpath="//p[@class='item-msg error']")
	WebElement txterrorMessage2;
	
	@FindBy(xpath="//div[@id='closeBtn']")
	WebElement frame;
	
	@FindBy(xpath="//tfoot//button[2]")
	WebElement btnEmptyCart;
	
	@FindBy(xpath="//div[@class='cart-empty']//p[1]")
	WebElement txtErrorMessageCart;
	
	public void clickbtnAddToCart() {
		waithelper.waitForElement(btnAddToCart, 30);
		btnAddToCart.click();
		
	}
	public void setQuantity(String quantity) {
		waithelper.waitForElement(txtQuantity, 30);
		txtQuantity.clear();
		txtQuantity.sendKeys(quantity);
	}
	public void clickUpdatebtn() {
		waithelper.waitForElement(btnUpdate, 30);
		btnUpdate.click();
	}
	public boolean verifyUpdate(String Errmessage) {
		String Act_Message=txterrorMessage1.getText();
		if(Act_Message.equals(Errmessage)) {
			System.out.println("Err Message On Page:"+ Act_Message);
			return true;
			
		}
		return false;
		
	}
	public boolean verifyUpdateSonyXperia(String ErrMessageSony) {
		String Act_Message=txterrorMessage2.getText();
		if(Act_Message.equals(ErrMessageSony)) {
		System.out.println("Err Message Sony:"+ Act_Message);
		return true;
		}
		return false;
	}

	public void clickbtnEmptyCart() {
		waithelper.waitForElement(btnEmptyCart, 30);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",btnEmptyCart);
		btnEmptyCart.click();
	}
	public boolean verifyEmptyCart(String ErrMessageCartEmpty) {
		String Act_Message=txtErrorMessageCart.getText();
		if(Act_Message.equals(ErrMessageCartEmpty)) {
		System.out.println("Err Message Empty Cart:"+ Act_Message);
		return true;
		}
		return false;
	}

}
