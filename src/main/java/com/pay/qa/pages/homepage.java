package com.pay.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pay.qa.testbase.TestBase;

public class homepage extends TestBase {
	

	@FindBy(xpath = "//h6[normalize-space()='Dashboard']")
	private WebElement dashboardimg;
	
	
	public homepage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Method
	public boolean dashboard() {
		boolean dashboardlogo=dashboardimg.isDisplayed();
		return dashboardlogo;
	}
}



