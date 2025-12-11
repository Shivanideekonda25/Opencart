package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage  {

	public RegistrationPage(WebDriver driver){
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-firstname']") WebElement fName;
	@FindBy(xpath="//input[@id='input-lastname']") WebElement lName;
	@FindBy(xpath="//input[@id='input-email']") WebElement email;
	@FindBy(xpath="//input[@id='input-telephone']") WebElement tphone;
	@FindBy(xpath="//input[@id='input-password']") WebElement pswd;
	@FindBy(xpath="//input[@id='input-confirm']") WebElement confPwd;
	@FindBy(xpath="//input[@name='agree']") WebElement agreeCheckbox;
	@FindBy(xpath="//input[@value='Continue']") WebElement continueButton;
	@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']") WebElement Txt_confirmation;
	
	
	public void setFirstName(String firstname) {
		fName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname) {
		lName.sendKeys(lastname);
	}
	
	public void setEmail(String emailid) {
		email.sendKeys(emailid);
	}
	
	public void setPhone(String phonenumber) {
		tphone.sendKeys(phonenumber);
	}
	
	public void setPassword(String password) {
		pswd.sendKeys(password);
	}
	
	public void setConfPassword(String ConfPassword) {
		confPwd.sendKeys(ConfPassword);
	}
	
	public void CheckBoxAgree() {
		agreeCheckbox.click();
	}
	
	public void BtnContinue() {
		continueButton.click();
	}
	
	public String TxtConfirm() {
		String txt_Verification=Txt_confirmation.getText();
		return txt_Verification;
	}
}
