package com.pay.qa.pages;

import java.io.IOException;

import javax.management.loading.PrivateClassLoader;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pay.qa.testbase.TestBase;

public class Loginpage extends TestBase {
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement password;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	private WebElement loginbutton;
	
	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	private WebElement forgotyourpassword;

	public Loginpage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	//Methods
	public void login(String UN, String PW) {
		username.clear();
		username.sendKeys(UN);
		password.clear();
		password.sendKeys(PW);
		loginbutton.click();
	}

}
