package com.pay.qa.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.pay.qa.util.TestUtil;

public class TestBase {
	public static WebDriver driver;
	public static Properties props;
	public static Logger logger;
	
	
	public TestBase() throws IOException {
		props=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\Atish Arun Raut\\eclipse-workspace\\3MavenProject2024\\src\\main\\java\\com\\pay\\qa\\confige\\confige.properties");
		props.load(file);
		
	}
	@SuppressWarnings("deprecation")
	public static void initialization() {
		System.out.println(props.getProperty("browser"));
	    String Browsername=props.getProperty("browser");

		if(Browsername.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","C:\\Installations\\chromedriver.exe");
			 driver=(WebDriver) new ChromeDriver();

		}
		else if(Browsername.equals("Edge")) {
		    System.setProperty("webdriver.edge.driver", "C:\\Installations\\msedgedriver.exe");    
		    driver=(WebDriver) new EdgeDriver();  		
		}		
		//Firefox
		else if(Browsername.equals("FireFox")) {
		    System.setProperty("webdriver.gecko.driver", "C:\\Installations\\geckodriver.exe");    
            driver = (WebDriver) new FirefoxDriver();
			
		}
		else {
			System.out.println("No browser value is given");
		}
	
         driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
         driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
         driver.get(props.getProperty("url"));
	}
	public String getScreenshotAs(String testCaseName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File Source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/screenshot/"+testCaseName+".png";
		FileUtils.copyFile(Source, new File (destination));
		return destination;
		
	}
	public static void teardown() {
		driver.quit();
	}
	
	

}
