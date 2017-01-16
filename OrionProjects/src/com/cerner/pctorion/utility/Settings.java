package com.cerner.pctorion.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


@SuppressWarnings("unused")
public class Settings 
{
	public static ExtentReports report;  //needed to end and flush report
	public static ExtentTest test; //needed to flush report
	public static WebDriver driver;
	public static String projectFolderPath = System.getProperty("user.dir");
	public static String domain ;
	public static String component ;
	public static String browser ;
	public static SoftAssert softAssert = new SoftAssert();
	@Parameters({"component","browser","domain"})  //getting browser parameter from .xml test file
	


	@BeforeClass
	public void setup (String parmComponent, String parmBrowser, String parmDomain)
	{	
		//Domain and Component variables set from parameters in xml file so can be used for folder path or items
		domain = parmDomain ;
		component = parmComponent ;
		browser = parmBrowser ;
		initializeBrowser(browser);  //takes browser you want to use and loads the driver based on Operating System Platform (Mac OS or Windows OS)
	}
	
	@AfterClass
	public void tearDown() 
	{
		report.endTest(test);  
		report.flush();  //Have to end and flush report in order for it to generate
		driver.close ();
		driver.quit();
	}

//-----------------------------------------------------------------------------------------------------------
	
	public void initializeBrowser(String browserName) {
		String CurrentOS=whichOS();
		if(CurrentOS.contains("Windows")){
			driver=getDriverWindows(browserName);
		}
		if(CurrentOS.equals("Mac OS X")){
			driver=getDriverOSX(browserName);
		}
	}
	
	public static String whichOS(){
		String OS = System.getProperty("os.name");
		return OS;
	}
	
	public WebDriver getDriverOSX(String browserName) {  
		WebDriver driver = null;
		try {
			if (browserName.equalsIgnoreCase("firefox") || browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", projectFolderPath+"/Resources/geckodriver");
				driver = new FirefoxDriver();
			    Dimension reso = new Dimension(320,600);
			    driver.manage().window().setSize(reso);
			    new WebDriverWait(driver, 5000);
			}
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectFolderPath+"/Resources/chromedriver");
				driver=new ChromeDriver();
			    driver.manage().window().maximize();
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    //new WebDriverWait(driver, 5000);
			}
			if(browserName.equalsIgnoreCase("safari")){
				SafariOptions safariOptions = new SafariOptions();
				safariOptions.setUseCleanSession(true);
				driver=new SafariDriver(safariOptions);
			}
		} catch (Exception exception) {
			System.out.println(exception);
		} 	
		return driver;
	}
	
	public WebDriver getDriverWindows(String browserName) {
		WebDriver driver = null;
		try {
			if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", projectFolderPath+"\\Resources\\geckodriver.exe");
				driver = new FirefoxDriver();
			    Dimension reso = new Dimension(320,600);
			    driver.manage().window().setSize(reso);
			    new WebDriverWait(driver, 5000);
			}
			if(browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", projectFolderPath+"\\Resources\\chromedriver.exe");
				driver=new ChromeDriver();
			    driver.manage().window().maximize();
			    new WebDriverWait(driver, 5000);
			}
			if(browserName.equalsIgnoreCase("iexplore32") || browserName.equalsIgnoreCase("ie32")){
				System.setProperty("webdriver.ie.driver", projectFolderPath+"\\Resources\\IE32DriverServer.exe");
				driver=new InternetExplorerDriver();
			    driver.manage().window().maximize();
			    new WebDriverWait(driver, 5000);
			}
			if(browserName.equalsIgnoreCase("iexplore64") || browserName.equalsIgnoreCase("ie64")){
				System.setProperty("webdriver.ie.driver", projectFolderPath+"\\Resources\\IE64DriverServer.exe");
				driver=new InternetExplorerDriver();
			    driver.manage().window().maximize();
			    new WebDriverWait(driver, 5000);
			}
		} catch (Exception exception) {
			System.out.println(exception);
		} 	
		return driver;
	}
	
	
}

