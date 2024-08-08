package com.pay.qa.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.pay.qa.testbase.TestBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listner extends TestBase implements ITestListener {
	ExtentTest test;
	ExtentReports extent=ExtentReport.getReportObject();
	ThreadLocal<ExtentTest>extentTest=new ThreadLocal<ExtentTest>();
	
	
	public void onTestStart (ITestResult result) {
		test=extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	
	public void onTestSuccess(ITestResult result) {
		extentTest.get().log(Status.PASS, "Test Passed");
		System.out.println("I am in Listner class");
		
	}
	public void onTestFailure(ITestResult result) {
		extentTest.get().fail(result.getThrowable());
		
		
		WebDriver driver=null;
		String testmethodname=result.getMethod().getMethodName();
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		}
		catch (Exception e){
			e.printStackTrace();
		}
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenshotAs(testmethodname),result.getMethod().getMethodName());
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
public void onTestSkipped(ITestResult result) {
	
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}


	public Listner() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

}
