package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver){
		super(driver);
	}
	

	@FindBy(xpath="//input[@id='input-email']") WebElement Txt_email;
	@FindBy(xpath="//input[@id='input-password']") WebElement Txt_pwd;
	@FindBy(xpath="//input[@value='Login']") WebElement btn_login;
	
	public void emailId(String email) {
		Txt_email.sendKeys(email);
	}
	
	public void password(String pwd) {
		Txt_pwd.sendKeys(pwd);
	}
	
	public void login() {
		btn_login.click();
	}
}
