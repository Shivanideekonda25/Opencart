package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountVerification;
import testBase.BaseClass;

public class TC002_LoginPage extends BaseClass{
	
	@Test(priority=1, groups={"Regression","Master"})
	public void HomepageLogin() {
		try {
		logger.info("****Starting the TC002_LoginPage Execution****");
		HomePage HP= new HomePage(driver);
		HP.clickMyAccount();
		HP.clickLogin();
	
		LoginPage LP = new LoginPage(driver);
		LP.emailId(p.getProperty("emailIdLogin"));
		LP.password(p.getProperty("passwordLogin"));	
		LP.login();
		
		MyAccountVerification MA=new MyAccountVerification(driver);
		String verification_Txt=MA.MyAccountVerify();
		Assert.assertEquals(verification_Txt, "My Account");
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Completed the TC002_LoginPage Execution****");
	}
	
	
}
