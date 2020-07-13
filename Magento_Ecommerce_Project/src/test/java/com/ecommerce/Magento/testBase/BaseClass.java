package com.ecommerce.Magento.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	public Properties configProp;
	public Logger logger=LogManager.getLogger(this.getClass());
	
	@BeforeClass
	@Parameters({"browser"})
	public void setUp(String br) throws IOException {
		configProp=new Properties();
		FileInputStream configFile=new FileInputStream(System.getProperty("user.dir")+"//Configuration//config.properties");
		configProp.load(configFile);
		if(br.equals("firefox")) {
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
		}
		else if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
		}
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
	public String randomstring() {
		String generatedString=RandomStringUtils.randomAlphabetic(6);
		return generatedString;
	}
	public void captureScreen(WebDriver driver,String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target=new File(System.getProperty("user.dir")+"//Screenshots//"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		
	}

}
