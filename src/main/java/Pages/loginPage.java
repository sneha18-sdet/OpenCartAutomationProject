package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage extends BasePage {
	
	public loginPage(WebDriver driver) {
			super(driver);
	}
	
	@FindBy(xpath= "//input[@id='input-email']" ) WebElement txt_user_email;
	@FindBy(xpath = "//input[@id='input-password']")  WebElement txt_user_pass;
	@FindBy(xpath = "//input[@value='Login']") WebElement btn;
	@FindBy(xpath = "//a[normalize-space()='Forgotten Password']") WebElement forgot_pass_link;
	@FindBy(xpath = "//a[normalize-space()='Continue']") WebElement new_acc_click;
	@FindBy(css = ".alert-danger") WebElement warningMsg;
	public void setEmail(String Email) {
		txt_user_email.clear();
		txt_user_email.sendKeys(Email);
	}
	
	public void setpassword(String pass) {
		txt_user_pass.clear();
		txt_user_pass.sendKeys(pass);
	}
	
	public void clickloginBtn() {
		btn.click();
	}
	

	public String getWarningMessage() {
	    return warningMsg.getText();
	}
	public void forgotPassLink() {
		forgot_pass_link.click();
	}
	
	public void NewAccountRegclick() {
		new_acc_click.click();
	}
}
