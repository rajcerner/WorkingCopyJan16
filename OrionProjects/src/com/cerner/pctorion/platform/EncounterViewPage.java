package com.cerner.pctorion.platform;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cerner.pctorion.utility.Settings;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class EncounterViewPage extends Settings {  
	  
      //Locate name in Demographics bar
      @FindBy(css=".demographics-row > h1")
	  public WebElement DemographicsName;
      
     //Locate the "Active" button on the segmented control
     @FindBy(css="button.ion-encounters-active-btn")
     public WebElement Active;
     
     //Locate the "Discharged" button on the segmented control
     @FindBy(css="button.ion-encounters-discharged-btn")
     public WebElement Discharged;
     
     //Locate the "Future" button on the segmented control
     @FindBy(css="button.ion-encounters-future-btn")
     public WebElement Future;
     
     //Locate the "All" button on the segmented control
     @FindBy(css="button.ion-encounters-all-btn")
     public WebElement All;
     
     //Locate the back arrow (<--) button
     @FindBy(css="button.icon-arrow-left")
     public WebElement Back;
     
     //Method to select "Active" button on the segmented control
     public void selectActive() throws InterruptedException {
    	 try{
    		 Active.click();
 			Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			test.log(LogStatus.WARNING, "Option to show Active encounter failed or is not found");
		}
     }
     
     //Method to select "Discharged" button on the segmented control
     public void selectDischarged() throws InterruptedException {
    	 try{
    		 Discharged.click();
 			Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			test.log(LogStatus.WARNING, "Option to show Discharged encounter failed or is not found");
		}
     }
     
     //Method to select "Future" button on the segmented control
     public void selectFuture() throws InterruptedException {
    	 try{
		      Future.click();
		      Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			test.log(LogStatus.WARNING, "Option to show Future encounter failed or is not found");
		}
     }
     
     //Method to select "All" button on the segmented control
     public void selectAll() throws InterruptedException {
    	 try{
		      All.click();
		      Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			test.log(LogStatus.WARNING, "Option to show All encounter failed or is not found");
		}
     }
     
     //Method to select the back arrow (<--) button
     public void selectBack() throws InterruptedException {
    	 try{
    		 Back.click();
		      Thread.sleep(3000);
		}
		catch(NoSuchElementException e) {
			test.log(LogStatus.WARNING, "Back button in encounter screen failed or is not found");
		}
     }
	 //Method to get name in Demographics bar
	  public String getDemoBarName() {
		  try{
			  return DemographicsName.getText(); 
		  }
		  catch(NoSuchElementException e) {
		    	test.log(LogStatus.WARNING, "Unable to locate demographics name on Encounter results page");	  
		  }
		return null;
	  }
 
	  
	  //Find encounter in list of encounter results
	  public Boolean findEncounter(String expectedEncounter) throws InterruptedException {
			Thread.sleep(3000);
		  List<WebElement> allEncounterElements = driver.findElements(By.cssSelector(".ion-encounter-detail > h6")); 
			Boolean encounterFound = false;
	      for (WebElement element: allEncounterElements) {
	        if (element.getText().contains(expectedEncounter)) { 
	        	encounterFound = true ;
	        }
	      }
		return encounterFound;
	  }
	  
	  //Click_Select Encounter 
	  public void selectEncounter(String selectEncounter) throws InterruptedException {
			Thread.sleep(3000);
		List<WebElement> allEncounterElements = driver.findElements(By.cssSelector(".ion-encounter-detail > h6")); 
		Boolean encounterFound = false;
	      for (WebElement element: allEncounterElements) {
	        if (element.getText().contains(selectEncounter)) {
	        	element.click();
				Thread.sleep(3000);
				encounterFound = true ;
	        	break ;
	        }
	      }
	      if(encounterFound != true) {
	    	  test.log(LogStatus.WARNING, "Unable to find or select encouner " + selectEncounter);
	      }
	  }

  }
