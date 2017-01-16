package com.cerner.pctorion.platform;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.cerner.pctorion.utility.Settings;
 
  public class LandingPage extends Settings {  
	  
	  //Locate the "Login" button
      @FindBy(linkText = "Login")
	  public WebElement Login;
     
 	  //Method to click on the "Login" button
	  public void clickLoginButton() {
		Login.click();
	}
	
  }