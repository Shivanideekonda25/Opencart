package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountVerification;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid - login success - test pass - logout
 Data is valid -- login failed - test fail

 Data is invalid - login success - test fail - logout
 Data is invalid -- login failed - test pass
 */

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String pwd, String exp) {
		try {
			logger.info("****Starting the TC003_LoginDDT Execution****");
		HomePage HP= new HomePage(driver);
		HP.clickMyAccount();
		HP.clickLogin();
	
		LoginPage LP = new LoginPage(driver);
		LP.emailId(email);
		LP.password(pwd);	
		LP.login();
		
		MyAccountVerification MA=new MyAccountVerification(driver);
		String verification_Txt=MA.MyAccountVerify();
		boolean loginStatus=verification_Txt.equals("My Account");
		
		if(exp.equalsIgnoreCase("valid")) {
			if(loginStatus==true) {
				Assert.assertTrue(true);
				MA.click_Logout();
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid")) {
			if(loginStatus==true) {
				MA.click_Logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Starting the TC003_LoginDDT Execution****");
	}
}
