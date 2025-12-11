package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountVerification extends BasePage{

	public MyAccountVerification(WebDriver driver){
		super(driver);
	}
	

	@FindBy(xpath="//h2[normalize-space()='My Account']") WebElement MyAccount;
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout;
	
	public String MyAccountVerify() {
		String Txt_MyAccount=MyAccount.getText();
		return Txt_MyAccount;
	}
	
	public void click_Logout() {
		Logout.click();
	}
}
