package orangeHRM_TC;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pay.qa.pages.Loginpage;
import com.pay.qa.pages.homepage;
import com.pay.qa.testbase.TestBase;
@Listeners (com.pay.qa.resources.Listner.class)
public class LoginTest extends TestBase{
	Loginpage loginpage;
	homepage hm;

	public LoginTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static Logger logger=LogManager.getLogger(TestBase.class.getName());
	
	@BeforeMethod
	public void setup() throws IOException {
		initialization();
		logger.info("Browser has initialized");
		loginpage=new Loginpage();
		hm=new homepage();
	}
	
	@Test(description = "Validate whether the login of customer is successful with valid credentials")
	public void loginwithvalidcred() {
		loginpage.login(props.getProperty("Username"), props.getProperty("Password"));
	     boolean act=hm.dashboard();
	     AssertJUnit.assertTrue(act);
          logger.warn("Login Failed");
	}

}
