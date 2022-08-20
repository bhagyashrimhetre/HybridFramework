package com.Vtiger.common;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

public class CommonMethods {
	private WebDriver driver;
	
	public ExtentTest logger;
	public CommonMethods(ExtentTest logger,WebDriver driver)
	{
		this.logger=logger;
		this.driver=driver;
	}
	
	public void EnterValue(WebElement elm, String value, String elmName)
	{
		try
		{
		elm.clear();
		elm.sendKeys(value);
		logger.pass(value+ " has been entered successfully into "+elmName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.fail(value+ " did not enter into "+elmName+ "due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");


		}
	}
	
	public void SelectVisibleText(WebElement elm, String value, String elmName)
	{
		try
		{
		Select s = new Select(elm);
		s.selectByVisibleText(value);
		elm.sendKeys(value);
		logger.pass(value+ " has been selected from dropdown "+elmName);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.fail(value+ " did not select from dropdown "+elmName+ "due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public void ClickElement(WebElement elm, String elmName)
	{
		try
		{
		elm.click();
		logger.pass(elmName+" has been clicked successfully");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.fail(elmName+" did not click due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
		}
	}
	
	public boolean CheckDisplay(WebElement elm,String elmName)
	{	
		boolean b=false;
		try
		{
		b = elm.isDisplayed();
		logger.pass(elmName+" was displaying on the screen");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			logger.fail(elmName+" did not display on the screen due to error "+e.getMessage()+"<a href='"+getscreenshot()+"'><span class='label end-time'>Screenshot</span></a>");
			
		}
		return b;
	}
	
	public String getscreenshot()
	{
	DateFormat f = new SimpleDateFormat("yyyyMMhhmmss");
	Date d = new Date();
	String str = f.format(d);
	TakesScreenshot scrShot =((TakesScreenshot)driver);
	File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
	String Path = System.getProperty("user.dir")+"/src/test/java/com/Vtiger/reports/screenshots/image"+str+".png";
	File destFile = new File(Path);
	try
	{
		FileUtils.copyFile(srcFile, destFile);
		
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return Path;
	}
}
	
	

