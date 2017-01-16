/*
https://jazz.cerner.com:9443/jts/dashboards/310Test Name: ORN_VR_PatientSearch
Purpose: Verify the Patient Search and Encounter View components in Orion Test Harness
Requirements: 807349, 753169, 753186, 753187
Change Control:
JW027642 Nov,11th 2016 Initial Creation
*/	
package com.cerner.pctorion.platformTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.IOException;

import com.cerner.pctorion.platform.*;
import com.cerner.pctorion.utility.*;


@SuppressWarnings("unused")
public class ORN_VR_PatientSearch extends Settings {
	
	@Test
	public void VRPatientSearch() throws InterruptedException, IOException
	  {
		
      //Initialize web elements from the pages that will be used in the test
		LandingPage lnp = PageFactory.initElements(driver, LandingPage.class); 
		LoginPage lgp = PageFactory.initElements(driver, LoginPage.class);     
		PatientSearchPage ps  = PageFactory.initElements(driver, PatientSearchPage.class); 
		EncounterViewPage ev  = PageFactory.initElements(driver, EncounterViewPage.class);
		UtilityMethods  utm = new UtilityMethods();
	
	  //Input xlxs file and choose worksheet and test to use for variable data
		String testName = "ORN_VR_PatientSearch";
		String sheet = "PatientSearch";
		DataTable datatable = new DataTable(sheet,testName);
		
	  //Declare variables
	  	String baseUrl = datatable.getValue("URL");;
	  	String username = datatable.getValue("Username");
	  	String password = datatable.getValue("Password");

	  //Use Extent Reports
		report = UtilityMethods.Instance(testName) ;
		test = report.startTest(testName);
	    String imageName = ""; //For Screenshots
		
	  //Step 1 -- Open Test Harness (Patient Search) 
		  	driver.get(baseUrl);	
			utm.clickButton(lnp.Login);
		  	lgp.enterUsernamePassword(username, password);
		  	utm.clickButton(lgp.Login);	

	   //Step 2 -- Testing X button
		  	String searchstring = "abc123";
		  	utm.enterText(ps.PatientSearchTextBox,searchstring) ;
		  	utm.clickButton(ps.XButton);
		  	utm.verifyFalse(ps.patientSearchText().contains(searchstring), "X Button clearing Patient Search Text Box");

		//Step 3 -- Search by Name 	
			searchstring = datatable.getValue("PatientSearchString1");
			String expectedFullName = datatable.getValue("ExpectedFullName1");
			ps.enterPatientsearchString(searchstring);
			imageName = "SearchResultbyName";
			utm.verifyWithScreen(ps.findPatient(expectedFullName), expectedFullName + " expected in search results using name of " + searchstring, testName, imageName);
		
		//Step 4 -- Search by FIN 	
			searchstring = datatable.getValue("PatientSearchString2");
			expectedFullName = datatable.getValue("ExpectedFullName2");
			ps.enterPatientsearchString(searchstring);
			imageName = "SearchResultbyFIN";
			utm.verifyWithScreen(ps.findPatient(expectedFullName), expectedFullName + " expected in search results using FIN of " + searchstring, testName, imageName);

		//Step 5 -- Search by MRN 	
			searchstring = datatable.getValue("PatientSearchString3");
			expectedFullName = datatable.getValue("ExpectedFullName3");
			ps.enterPatientsearchString(searchstring);
			imageName = "SearchResultbyMRN";
			utm.verifyWithScreen(ps.findPatient(expectedFullName), expectedFullName + " expected in search results using MRN of " + searchstring, testName, imageName);
					  
		//Step 6 -- Select last patient searched for - validate encounter using name in demographics bar 	   
			ps.selectPatient(expectedFullName);
			String demoName = ev.getDemoBarName();
			utm.verify(demoName, expectedFullName, " in Demographics Bar");

		//Select to view all encounters
			utm.clickButton(ev.All);	
			
		//Step 7 -- Validate Encounter found
			imageName = "EncounterResult";
			String expectedEncounter = datatable.getValue("ExpectedEncounterFIN3");
			utm.verifyWithScreen(ev.findEncounter(expectedEncounter), expectedEncounter + " expected in encounter results", testName, imageName); 

		//Step 8 - Navigate back to patient search
			utm.clickButton(ev.Back);	


			softAssert.assertAll(); //put at test level for test level failure
	    }

}