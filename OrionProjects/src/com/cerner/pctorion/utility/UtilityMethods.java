package com.cerner.pctorion.utility;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class UtilityMethods extends Settings 
{	  
	static String CurrentOS=Settings.whichOS();
	
	public UtilityMethods verify(String actual, String expected, String stepDesc) //Verify actual string vs expected
	{
		//softAssert.assertEquals(actual, expected);
		try{
			Assert.assertEquals(actual, expected);
			test.log(LogStatus.PASS, expected + " Text Found  <br />", stepDesc);
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, actual +   " Text Not Found <br />", stepDesc);
		}	
		return this;
	}

	public UtilityMethods verify(Boolean status, String stepDesc) //Verify status Boolean
	{
		softAssert.assertTrue(status);
		try{
			Assert.assertTrue(status);
			test.log(LogStatus.PASS, stepDesc);
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc);		
		}

		return this;
	}

	public UtilityMethods verifyFalse(Boolean status, String stepDesc) //Verify status Boolean is false
	{
		softAssert.assertFalse(status);
		try{
			Assert.assertFalse(status);
			test.log(LogStatus.PASS, stepDesc);
		}
		catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc);		
		}

		return this;
	}

	public UtilityMethods verifyWithScreen(String actual, String expected, String stepDesc, String testName, String imageName) //Verify actual string vs expected with screenshot
	{
		softAssert.assertEquals(actual, expected);
		captureScreenshot(driver, testName, imageName);
		try{	
			Assert.assertEquals(actual, expected);
			//test.log(LogStatus.PASS, expected  + " Text Found <br />" + stepDesc, test.addScreenCapture(imageName+".png"));
			test.log(LogStatus.PASS, test.addScreenCapture(imageName+".png") , expected  + " Text Found <br />" + stepDesc);
		}catch(AssertionError e)
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(imageName+".png"),  actual    + " Text Not Found <br />" + stepDesc);
		}

		return this ;
	}

	public UtilityMethods verifyWithScreen(Boolean status, String stepDesc, String testName, String imageName) //Verify status Boolean with screenshot
	{
		softAssert.assertTrue(status);
		captureScreenshot(driver, testName, imageName);
		try{	
			Assert.assertTrue(status);
			test.log(LogStatus.PASS, test.addScreenCapture(imageName+".png"), stepDesc);
		}catch(AssertionError e)
		{	
			test.log(LogStatus.FAIL, stepDesc + test.addScreenCapture(imageName+".png") );	
		}	

		return this;
	}


	public static void captureScreenshot(WebDriver driver, String testName,  String imageName) //Creates screenshot and give image path
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
		}
		catch(NoSuchElementException e){
			test.log(LogStatus.FATAL, "not able to click on button");
		}
	}

	public void enterText(WebElement element,String text) throws InterruptedException{  //enters test into element
		try{
			element.clear();
			element.sendKeys(text); 
		}
		catch(NoSuchElementException e){
			test.log(LogStatus.FATAL, "Not able to Enter data in text field");
		}
	}

}