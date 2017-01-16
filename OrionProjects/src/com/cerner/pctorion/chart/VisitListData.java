package com.cerner.pctorion.chart;

import com.cerner.pctorion.utility.DataTable;
/*
 * @uthor: rv042687 / roshan
 */
public class VisitListData {

	
	public static final String visitLstTxt="Visit List";
	public static final String futTxt ="Future";
	public static final String prevTxt="Previous";
	public static final String detTitleTxt="Encounter Details";
	
	public static final String noFutTxt = "No future visits for this patient";
	public static final String noPrevTxt = "No previous visits for this patient";
	
	
	
	/*
	 * Test Case Data for: ORN_VR_VISITLIST
	 * 
	 * */
	
	public static final String testName = "ORN_VR_VisitList";
	public static final String sheet = "VisitList";
	public static DataTable dataTable = new DataTable(sheet, testName);
	
	
	public static final String URL   = dataTable.getValue("URL");	
	public static String UserName    = dataTable.getValue("UserName");
	public static String Password    = dataTable.getValue("Password");
	
	public static final String PatientA   = dataTable.getValue("PatientA");
	public static final String FIN_A      = dataTable.getValue("FINA");
	public static final String PatientB   = dataTable.getValue("PatientB");
	public static final String FIN_B      = dataTable.getValue("FINB");
	
	
	/*
	 * Expected Data
	 * */
	public static final String PrvEnc1_Time    = dataTable.getValue("PrvEnc1_Time"); 
    public static final String PrvEnc1_AttPhy  = dataTable.getValue("PrvEnc1_AttPhy"); 
	public static final String PrvEnc1_Type    = dataTable.getValue("PrvEnc1_Type"); 
	public static final String PrvEnc1_Reason  = dataTable.getValue("PrvEnc1_Reason"); 

	//public static final String PrvEnc2_Time = "May 13, 2016 3:57 PM"; //  Admit Date & Time
	
	public static final String PrvEnc2_Time     = dataTable.getValue("PrvEnc2_Time");
	public static final String PrvEnc2_AttPhy   = dataTable.getValue("PrvEnc2_AttPhy");
	public static final String PrvEnc2_Type     = dataTable.getValue("PrvEnc2_Type"); //"Recurring";
	public static final String PrvEnc2_Reason   = dataTable.getValue("PrvEnc2_Reason");   // Reason for Visit
	public static final String PrvEnc2_DiscDate = dataTable.getValue("PrvEnc2_DiscDate");
	public static final String PrvEnc2_Service  = dataTable.getValue("PrvEnc2_Service");
	public static final String PrvEnc2_Location = dataTable.getValue("PrvEnc2_Location");
	public static final String PrvEnc2_RoomBed  = dataTable.getValue("PrvEnc2_RoomBed");
	public static final String PrvEnc2_FIN      = dataTable.getValue("PrvEnc2_FIN");
	public static final String PrvEnc2_Status   = dataTable.getValue("PrvEnc2_Status");

	
	public static final String PrvEnc3_Time     = dataTable.getValue("PrvEnc3_AttPhy");
	public static final String PrvEnc3_AttPhy   = dataTable.getValue("PrvEnc3_AttPhy");
	public static final String PrvEnc3_Type     = dataTable.getValue("PrvEnc3_Type");
	public static final String PrvEnc3_Reason   = dataTable.getValue("PrvEnc3_Reason");
	
	public static final String PrvEnc7_Time     = dataTable.getValue("PrvEnc7_Time");
	public static final String PrvEnc7_AttPhy   = dataTable.getValue("PrvEnc7_AttPhy");
	public static final String PrvEnc7_Type     = dataTable.getValue("PrvEnc7_Type");
	public static final String PrvEnc7_Reason   = dataTable.getValue("PrvEnc7_Reason");
	
	public static final String FutEnc4_Time     = dataTable.getValue("FutEnc4_Time");
	public static final String FutEnc4_AttPhy   = dataTable.getValue("FutEnc4_AttPhy");
	public static final String FutEnc4_Type     = dataTable.getValue("FutEnc4_Type");
	public static final String FutEnc4_Reason   = dataTable.getValue("FutEnc4_Reason");
	
	
	
	
	public static final String FutEnc5_Time     = dataTable.getValue("FutEnc5_Time");
	public static final String FutEnc5_AttPhy   = dataTable.getValue("FutEnc5_AttPhy");
	public static final String FutEnc5_Type     = dataTable.getValue("FutEnc5_Type");
	public static final String FutEnc5_Reason   = dataTable.getValue("FutEnc5_Reason");
	public static final String FutEnc5_DiscDate = dataTable.getValue("FutEnc5_DiscDate");
	public static final String FutEnc5_Service  = dataTable.getValue("FutEnc5_Service");
	public static final String FutEnc5_Location = dataTable.getValue("FutEnc5_Location");
	public static final String FutEnc5_RoomBed  = dataTable.getValue("FutEnc5_RoomBed");
	public static final String FutEnc5_FIN      = dataTable.getValue("FutEnc5_FIN");
	public static final String FutEnc5_Status   = dataTable.getValue("FutEnc5_Status");
	
	
	public static final String FutEnc6_Time 	= dataTable.getValue("FutEnc6_Time");   
	public static final String FutEnc6_AttPhy   = dataTable.getValue("FutEnc6_AttPhy"); 
	public static final String FutEnc6_Type     = dataTable.getValue("FutEnc6_Type"); 
	public static final String FutEnc6_Reason   = dataTable.getValue("FutEnc6_Reason"); 
	
	
}



