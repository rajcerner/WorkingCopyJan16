package com.cerner.pctorion.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class UtilityMethods_NoSoftAssert extends Settings 
{	  
	static String CurrentOS=Settings.whichOS();

	
	public void verify(String actual, String expected) //Verify actual string vs expected
	{
		try{
			Assert.assertEquals(actual, expected);
			test.log(LogStatus.PASS, expected + " Text Found");
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, actual + " Text Not Found");		
		}
	}
	
	public void verify(Boolean status, String stepDesc) //Verify status Boolean
	{
		try{
			Assert.assertTrue(status);
			test.log(LogStatus.PASS, stepDesc);
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc);		
		}
	}
	
	public void verifyFalse(Boolean status, String stepDesc) //Verify status Boolean is false
	
	{
		try{
			Assert.assertFalse(status);
			test.log(LogStatus.PASS, stepDesc);
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc);		
		}
	}
	
	public void verifyWithScreen(String actual, String expected, String testName, String imageName) //Verify actual string vs expected with screenshot
	{
		captureScreenshot(driver, testName, imageName, browser);
		try{	
			Assert.assertEquals(actual, expected);
			test.log(LogStatus.PASS , expected + " Text Found" + test.addScreenCapture(imageName+".png"));

		}catch(AssertionError e)
		{
			test.log(LogStatus.FAIL, actual + " Text Not Found" + test.addScreenCapture(imageName+".png"));
		}
	}
	
	public void verifyWithScreen(Boolean status, String stepDesc, String testName, String imageName) //Verify status Boolean with screenshot
	{
		captureScreenshot(driver, testName, imageName, browser);
		try{	
			Assert.assertTrue(status);
			test.log(LogStatus.PASS, stepDesc + test.addScreenCapture(imageName+".png") );
		}catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc + test.addScreenCapture(imageName+".png") );	
		}	
	}
	
	
	public static Boolean verticalScrollBarExist(WebDriver driver) throws InterruptedException //Verifies as vertical scroll bar exist if you have a long list to scroll through. **Not Working**
	{
		Boolean vertScrollExist = (Boolean) ((JavascriptExecutor)driver).executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
		return vertScrollExist;
	}
	
	public String systemDate()  //gets system date and puts into format
	{ 
		Date date = new Date() ;
		SimpleDateFormat dateFormat = new SimpleDateFormat("MMddyyyy hhmm");
		String systemDate= dateFormat.format(date);
		return systemDate;
	}
		
	public static void captureScreenshot(WebDriver driver, String testName,  String imageName, String browser) //Creates screenshot and give image path
	{
		String imagePath = " ";
		if (CurrentOS.contains("Mac OS X")){
			imagePath = projectFolderPath+"/Reports/"+testName+" "+browser+"/"+imageName ;
		}
		else{
			imagePath = projectFolderPath+"\\Reports\\"+testName+" "+browser+"\\"+imageName ;
		}	
		TakesScreenshot ts=(TakesScreenshot)driver;
		File oSS = ts.getScreenshotAs(OutputType.FILE);
		File oDest = new File(imagePath+".png");
		
		try{
			FileUtils.copyFile(oSS, oDest);
		}
		catch (IOException e){
			System.out.println("Exception while taking screenshot "+e.getMessage());
		}	
	}
	
	public static ExtentReports Instance(String testName) //Creates and starts new report path based on OS
	{
		String reportPath = " ";
		if (CurrentOS.contains("Mac OS X")){
			reportPath = projectFolderPath+"/Reports/"+testName+" "+browser+"/"+testName+".html";
		}
		else {
			reportPath = projectFolderPath+"\\Reports\\"+testName+" "+browser+"\\"+testName+".html";
		}
		ExtentReports report = new ExtentReports(reportPath, true) ;
		return report;
			
	}
	
	public void clickButton(WebElement element) throws InterruptedException{  //clicks button based on element 
		try{
			element.click();
			Thread.sleep(3000);
		}
		catch(NoSuchElementException e){
			test.log(LogStatus.FATAL, "not able to click on button");
			//throw new OBJECT_NOT_EXIST();

		}
	}
	
	public void enterText(WebElement element,String text) throws InterruptedException{  //enters test into element
		try{
			element.clear();
			element.sendKeys(text);
			Thread.sleep(3000);
		}
		catch(NoSuchElementException e){
			test.log(LogStatus.FATAL, "Not able to Enter data in text field");
			//throw new OBJECT_NOT_EXIST();
		}
	}
	
}