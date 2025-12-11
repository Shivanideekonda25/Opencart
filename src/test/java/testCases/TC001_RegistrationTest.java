package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_RegistrationTest extends BaseClass{

	
	
	@Test(groups= {"Sanity","Master"})
	void Registration() {
		try {
		logger.info("****Starting the TC001_RegistrationTest Execution****");
		HomePage HP = new HomePage(driver);
		
		logger.info("Clicking on MyAccount");
		HP.clickMyAccount();
		
		logger.info("Clicking on Register");
		HP.clickRegister();
		
		RegistrationPage RP = new RegistrationPage(driver);
		
		logger.info("Entering the required details");
		RP.setFirstName(RandomString().toUpperCase());
		RP.setLastName(RandomString().toUpperCase());
		RP.setEmail(RandomString()+"@gmail.com");
		RP.setPhone(RandomNum());
		
		String pwd=RandomAlphaNum();
		RP.setPassword(pwd);
		RP.setConfPassword(pwd);
		RP.CheckBoxAgree();
		RP.BtnContinue();
		String confirmationMsg= RP.TxtConfirm();
		
		//Assert.assertEquals(confirmationMsg, "Your Account Has Been Created!");
		
		if(confirmationMsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.assertTrue(false);
		}
		
		}
		
		catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("****Finished the TC001_RegistrationTest Execution****");
		
	}
	
	
}
