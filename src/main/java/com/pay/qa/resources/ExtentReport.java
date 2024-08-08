package com.pay.qa.resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import net.bytebuddy.utility.RandomString;
public class ExtentReport {
        public static ExtentReports extents;
        
        
        public static ExtentReports getReportObject() {
        	String Random = RandomString.make(5);
        	String name= "ExtentReport";
        	String path=System.getProperty("user.dir")+"/reports/"+name+Random+".html";
        	System.out.println(path);
        	
        	ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        	reporter.config().setReportName("2024 Framework");
        	reporter.config().setDocumentTitle("Automation Execution result");
        	
        	extents=new ExtentReports();
        	extents.attachReporter(reporter);
        	extents.setSystemInfo("QA Automation Engineer", "Atish Raut");
        	
			return extents;
        	
        }
        
}
