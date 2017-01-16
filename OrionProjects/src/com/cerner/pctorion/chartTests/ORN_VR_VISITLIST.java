package com.cerner.pctorion.chartTests;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.cerner.pctorion.chart.VisitListData;
import com.cerner.pctorion.chart.VisitListDetailsPage;
import com.cerner.pctorion.chart.VisitListDetailsPage.EncounterFields;
import com.cerner.pctorion.chart.VisitListReviewPage;
import com.cerner.pctorion.chart.VisitListReviewPage.EncNo;
import com.cerner.pctorion.chart.VisitListSplitViewPage;
import com.cerner.pctorion.platform.EncounterViewPage;
import com.cerner.pctorion.platform.EstablishRelationPage;
import com.cerner.pctorion.platform.LandingPage;
import com.cerner.pctorion.platform.LoginPage;
import com.cerner.pctorion.platform.PatientSearchPage;
import com.cerner.pctorion.utility.DataTable;
import com.cerner.pctorion.utility.Settings;
import com.cerner.pctorion.utility.UtilityMethods;
import com.relevantcodes.extentreports.LogStatus;


/*
 *author: rv042687-roshan / rg042938-rajesh
 */
public class ORN_VR_VISITLIST extends Settings{

	@Test
	public void ornVrVisitList() throws InterruptedException
	{	
		LandingPage lndPage = PageFactory.initElements(driver, LandingPage.class); 
		LoginPage logPage = PageFactory.initElements(driver, LoginPage.class);     
		PatientSearchPage patSrch  = PageFactory.initElements(driver, PatientSearchPage.class); 
		EncounterViewPage encSelc  = PageFactory.initElements(driver, EncounterViewPage.class);
		VisitListReviewPage vstRev = PageFactory.initElements(driver, VisitListReviewPage.class);		
		VisitListDetailsPage vstDet = PageFactory.initElements(driver, VisitListDetailsPage.class);
		VisitListSplitViewPage vstPg = PageFactory.initElements(driver, VisitListSplitViewPage.class);
		EstablishRelationPage estPg = PageFactory.initElements(driver, EstablishRelationPage.class);
		UtilityMethods  utm = new UtilityMethods();


		DataTable dataTable = new DataTable(VisitListData.sheet, VisitListData.testName);

		report = UtilityMethods.Instance(VisitListData.testName) ;


		test = report.startTest(VisitListData.testName);
		driver.get(VisitListData.URL);


		/* Step2 */
		test.log(LogStatus.INFO, "Step-2",  "User Logins & Loads Patient");
		String imageName = "Step1_VisitList_Profile_View"; //For Screenshots	

		utm.clickButton(lndPage.Login);
		logPage.enterUsernamePassword(VisitListData.UserName, VisitListData.Password);
		utm.clickButton(logPage.Login);  	
		utm.enterText(patSrch.PatientSearchTextBox, VisitListData.PatientA);
		patSrch.selectPatient(VisitListData.PatientA);	
		encSelc.selectEncounter(VisitListData.FIN_A);

		utm.verifyWithScreen(vstRev.vmBtn.getText(), "View More...", "View More Cell ", VisitListData.testName, imageName)
		
		.verify(vstRev.pageHead.getText(), VisitListData.visitLstTxt, "")
		.verify(vstRev.prevHead.getText(), VisitListData.prevTxt, "")
		.verify(vstRev.futHead.getText(),  VisitListData.futTxt, "")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc1_Time),     "Enc1 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc1_AttPhy),   "Enc1 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc1_Type),     "Enc1 - Type - Step-2")	   
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc1_Reason),   "Enc1 - Reason - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc2_Time),     "Enc2 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc2_AttPhy),   "Enc2 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc2_Type),     "Enc2 - Type - Step-2")	   
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc2_Reason),   "Enc2 - Reason - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc3_Time),     "Enc3 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc3_AttPhy),   "Enc3 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc3_Type),     "Enc3 - Type - Step-2")  
		.verify(vstRev.verifyPrevEncRows(VisitListData.PrvEnc3_Reason),   "Enc3 - Reason - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc4_Time),     "Enc4 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc4_AttPhy),   "Enc4 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc4_Type),     "Enc4 - Type - Step-2")	   
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc4_Reason),   "Enc4 - Reason - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc5_Time),     "Enc5 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc5_AttPhy),   "Enc5 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc5_Type),     "Enc5 - Type - Step-2")	   
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc5_Reason),   "Enc5 - Reason - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc6_Time),     "Enc6 - Time - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc6_AttPhy),   "Enc6 - Attending Phy - Step-2")
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc6_Type),     "Enc6 - Type - Step-2")	   
		.verify(vstRev.verifyPrevEncRows(VisitListData.FutEnc6_Reason),   "Enc6 - Reason - Step-2");






		/* Step3
		 * Since the Visit List test harness does not provide the slide panel, verifying the same in Pop-Up Modal 
		 *  */
		test.log(LogStatus.INFO, "Step-3",  "Encounter-2 Previous Details Page");
		imageName = "Screen_3_Encounter2";	
		System.out.println("TIME:  " + dataTable.getValue("PrvEnc1_Time"));
		vstRev.selectPrevious(EncNo.TWO);   	Thread.sleep(5000);

		utm.verifyWithScreen(vstDet.titleTxt.getText(),VisitListData.detTitleTxt, "Encounter Details Page ", VisitListData.testName, imageName)
		.verify(vstDet.verifyEncField(EncounterFields.ADMIT_DATE),       "ENC2 - Admit Date Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.ATTENDING_PHY),    "ENC2 - Attending Phy Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.DISCHARGE_DATE),   "ENC2 - Discharge Date Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_STATUS),       "ENC2 - Encounter Status Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_TYPE),         "ENC2 - Encounter Type Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.FIN),              "ENC2 - Fin Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.LOCATION),         "ENC2 - Location Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.REASON_FOR_VISIT), "ENC2 - Reason For Visit Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.ROOM),             "ENC2 - Room Field - Step-3")
		.verify(vstDet.verifyEncField(EncounterFields.SERVICE),          "ENC2 - Service Field - Step-3")

		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Time),     "ENC2 - Time Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_DiscDate), "ENC2 - Discharge Date Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Reason),   "ENC2 - Reason For Visit Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Service),  "ENC2 - Service Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_AttPhy),   "ENC2 - Attending Phy Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Location), "ENC2 - Location Field Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_RoomBed),  "ENC2 - Room Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_FIN),      "ENC2 - Fin Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Type),     "ENC2 - Type Value - Step-3")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Status),   "ENC2 - Status Value - Step-3");


		/* Step4 */
		test.log(LogStatus.INFO, "Step-4",  "Close Deatils Modal");
		imageName = "Screen_4";	
		vstDet.closeBtn.click(); Thread.sleep(5000);
		utm.verifyWithScreen(vstRev.pageHead.isDisplayed(), "Pop-Up", VisitListData.testName, imageName);


		/* Step5 */
		test.log(LogStatus.INFO, "Step-5",  "CLick on View More...");
		imageName = "Screen_5";	
		vstRev.vmBtn.click(); 

		utm.verifyWithScreen(vstPg.titleTxt.getText(), VisitListData.visitLstTxt," Visit List View More View ", VisitListData.testName, imageName)
		.verify(vstPg.prevBtn.getText(), VisitListData.prevTxt, "")
		.verify(vstPg.futBtn.getText(), VisitListData.futTxt, "")
		.verify(Boolean.parseBoolean(vstPg.prevBtn.getAttribute("aria-selected")), "Previous Button Selected by Default - Step-5")

		.verify(vstPg.bckBtn.isDisplayed(), "Back Button Displayed")	
		.verify(vstPg.prevHead.getText(), VisitListData.prevTxt, "")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc1_Time),    "Previous Encounter-1 Time - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc1_Reason),  "Previous Encounter-1 Reason - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc1_AttPhy),  "Previous Encounter-1 Attending Physcian - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc1_Type),    "Previous Encounter-1 Type - Step-5")

		.verify(vstPg.verifyEncData(VisitListData.PrvEnc2_Time),    "Previous Encounter-2 Time - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc2_Reason),  "Previous Encounter-2 Reason - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc2_AttPhy),  "Previous Encounter-2 Attending Physcian - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc2_Type),    "Previous Encounter-2 Type - Step-5")

		.verify(vstPg.verifyEncData(VisitListData.PrvEnc3_Time),    "Previous Encounter-3 Time - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc3_Reason),  "Previous Encounter-3 Reason - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc3_AttPhy),  "Previous Encounter-3 Attending Physcian - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc3_Type),    "Previous Encounter-3 Type - Step-5")

		.verify(vstPg.verifyEncData(VisitListData.PrvEnc7_Time),    "Previous Encounter-4 Time - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc7_Reason),  "Previous Encounter-4 Reason - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc7_AttPhy),  "Previous Encounter-4 Attending Physcian - Step-5")
		.verify(vstPg.verifyEncData(VisitListData.PrvEnc7_Type),    "Previous Encounter-4 Type - Step-5");


		/* Step6 */
		test.log(LogStatus.INFO, "Step-6",  "Encounter 2 Previous Details Page");
		imageName = "Screen_6";
		vstPg.selectEncWith(VisitListData.PrvEnc2_Time);

		utm.verifyWithScreen(vstPg.sidePnl.isEnabled(), "Details Slide Panel", VisitListData.testName, imageName)
		.verify(vstDet.verifyEncField(EncounterFields.ADMIT_DATE),       "Admit Date Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.ATTENDING_PHY),    "Attending Phy Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.DISCHARGE_DATE),   "Discharge Date Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_STATUS),       "Encounter Status Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_TYPE),         "Encounter Type Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.FIN),              "Fin Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.LOCATION),         "Location Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.REASON_FOR_VISIT), "Reason For Visit Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.ROOM),             "Room Field - Step-6")
		.verify(vstDet.verifyEncField(EncounterFields.SERVICE),          "Service Field - Step-6")

		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Time),      "ENC2 - Time Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_DiscDate),  "ENC2 - Discharge Date Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Reason),    "ENC2 - Reason For Visit Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Service),   "ENC2 - Service Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_AttPhy),    "ENC2 - Attending Phy Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Location),  "ENC2 - Location Field Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_RoomBed),   "ENC2 - Room Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_FIN),       "ENC2 - Fin Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Type),      "ENC2 - Type Value - Step-6")
		.verify(vstDet.verifyEncDetValues(VisitListData.PrvEnc2_Status),    "ENC2 - Status Value - Step-6");

		/* Step7 */
		test.log(LogStatus.INFO, "Step-7",  "Close Details Page");
		imageName = "Screen_7";
		vstDet.closeBtn.click();
		utm.verifyWithScreen(vstPg.sidePnl.isEnabled(), "Details Slide Panel Closed", VisitListData.testName, imageName);

		/* Step8 */
		Thread.sleep(5000);
		test.log(LogStatus.INFO, "Step-8",  "Click on Future Tab");
		imageName = "Screen_8";
		vstPg.futBtn.click();

		utm.verifyWithScreen(vstPg.futHead.getText(), VisitListData.futTxt," Future Encounter Screen  ", VisitListData.testName, imageName)
		.verify(vstPg.bckBtn.isDisplayed(),  "Back Button")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc4_AttPhy), "Enc4 Attending - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc4_Reason), "Enc4 Reason - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc4_Time),   "Enc4 Time - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc4_Type),   "Enc4 Type - Step-8")

		.verify(vstPg.verifyEncData(VisitListData.FutEnc5_AttPhy), "Enc5 Future Time - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc5_Reason), "Enc5 Reason - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc5_Time),   "Enc5 Time - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc5_Type),   "Enc5 Type - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc6_AttPhy), "Enc6 Future Time - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc6_Reason), "Enc6 Reason - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc6_Time),   "Enc6 Time - Step-8")
		.verify(vstPg.verifyEncData(VisitListData.FutEnc6_Type),   "Enc6 Type - Step-8");

		/* Step9 */
		test.log(LogStatus.INFO, "Step-9",  "Encounter-5 Future ");
		imageName = "Screen_9";
		vstPg.selectEncWith(VisitListData.FutEnc5_Time);
		utm.verifyWithScreen(vstPg.sidePnl.isEnabled(), "Details Slide Panel", VisitListData.testName, imageName)
		.verify(vstDet.verifyEncField(EncounterFields.ADMIT_DATE),       "Admit Date Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.ATTENDING_PHY),    "Attending Phy Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.DISCHARGE_DATE),   "Discharge Date Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_STATUS),       "Encounter Status Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.ENC_TYPE),         "Encounter Type Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.FIN),              "Fin Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.LOCATION),         "Location Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.REASON_FOR_VISIT), "Reason For Visit Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.ROOM),             "Room Field - Step-9")
		.verify(vstDet.verifyEncField(EncounterFields.SERVICE),          "Service Field - Step-9")

		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Time),      "Time Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_DiscDate),  "Discharge Date Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Reason),    "Reason For Visit Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Service),   "Service Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_AttPhy),    "Attending Phy Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Location),  "Location Field Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_RoomBed),   "Room Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_FIN),       "Fin Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Type),      "Type Value - Step-9")
		.verify(vstDet.verifyEncDetValues(VisitListData.FutEnc5_Status),    "Status Value - Step-9");



		Thread.sleep(5000);

		/* Step10 */
		test.log(LogStatus.INFO, "Step-10",  "Close Details Page");
		vstDet.closeBtn.click();
		utm.verify(vstPg.sidePnl.isEnabled(), "Details Slide Panel");


		/* Step11 */
		test.log(LogStatus.INFO, "Step-11",  "Verify No Previous and Future Visits for Patient");
		imageName = "Screen_6_NoFutPrev";
		driver.get(VisitListData.URL);
		utm.enterText(patSrch.PatientSearchTextBox,VisitListData.PatientB);
		patSrch.selectPatient(VisitListData.PatientB);	
		encSelc.selectEncounter(VisitListData.FIN_B);
		estPg.select(dataTable.getValue("RelationType"));
		estPg.contBtn.click();
		utm.verifyWithScreen(vstRev.noFutTxt.getText(),VisitListData.noFutTxt, " Visilit Profile View ", VisitListData.testName, imageName);
		utm.verify(vstRev.noPrevTxt.getText(), VisitListData.noPrevTxt, "");  	

	}

}
