package com.cerner.pctorion.platform;


import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cerner.pctorion.utility.Settings;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@SuppressWarnings("unused")
public class PatientSearchPage extends Settings {  

	  //Locate the 'patient search text box'
      @FindBy(id="ion-patient-search-text-box")
	  public WebElement PatientSearchTextBox;

      //Locate the "x" button
      @FindBy(css="button.icon-dismiss")
	  public WebElement XButton;

	  //Method to search for patient
	  public PatientSearchPage enterPatientsearchString(String searchstring) throws InterruptedException {
	    try{
		  PatientSearchTextBox.clear();
		  PatientSearchTextBox.sendKeys(searchstring);
		  Thread.sleep(3000);
	    }
	    catch(NoSuchElementException e) {
	    	test.log(LogStatus.FATAL, "Unable to find patient search box");
	    }
		return this;
	  }
	  
	  //Used to validate text in Patient Search box
	  public String patientSearchText() {
		  return PatientSearchTextBox.getText();
	  }
	  	  
	  
	  //Clears the patient search text area
	  public PatientSearchPage clearTestArea() {
		  PatientSearchTextBox.clear();
		  return this;
	  }
		  
	  //Method to click on the "x" button
	  public void clickXButton(ExtentTest test)  {
		  try{
			  XButton.click();
		  }
		  catch(ElementNotVisibleException e) {
		  		test.log(LogStatus.WARNING, "X button does not exist or no text entered into search area") ;
		  } 
	  }
		   	  
	  //Find name in initial list of patient search results.
	  public Boolean findPatient(String expectedFullName) throws InterruptedException {
		  Thread.sleep(3000);
		  List<WebElement> allPatientElements = driver.findElements(By.cssSelector(".ion-patient-search-result-detail > h5")); 
			Boolean nameFound = false;
	      for (WebElement element: allPatientElements) {
	        if (element.getText().contains(expectedFullName)) { 
	        	nameFound = true ;
	        }
	      }
		return nameFound;
	  }
	  
	  //Click_Select patient 
	  public void selectPatient(String selectName) throws InterruptedException {
		  
		List<WebElement> allPatientElements = driver.findElements(By.cssSelector(".ion-patient-search-result-detail > h5")); 
		Boolean nameFound = false;
	      for (WebElement element: allPatientElements) {
	        if (element.getText().contains(selectName)) {
	        	element.click();
				Thread.sleep(3000);
	        	nameFound = true ;
	        	break ;
	        }
	      }
	      if(nameFound != true) {
	    	  test.log(LogStatus.WARNING, "Unable to find or select patient " + selectName);
	      }
	  }
	  
  }