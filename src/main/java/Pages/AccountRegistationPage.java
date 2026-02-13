package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistationPage extends BasePage {
	
	public AccountRegistationPage(WebDriver driver) {
		super (driver);
	}
	
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement txt_user_firstname;
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement txt_user_lastname;
	@FindBy(xpath = "//input[@id='input-email']") WebElement txt_email;
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement txt_phoneno;
	@FindBy(xpath = "//input[@id='input-password']") WebElement txt_pass;
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement txt_confirm_pass;
	
	@FindBy(xpath ="//label[normalize-space()='Yes']") WebElement radio_yes;
	@FindBy(xpath = "//input[@value='0']") WebElement radio_no;
	@FindBy(xpath = "//input[@name='agree']") WebElement chk_box_agree;
	@FindBy(xpath = "//input[@value='Continue']") WebElement btn_continue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement confirm_meassage;
	//@FindBy(xpath = "//a[normalize-space()='Continue']") WebElement to_login_continue;
	
	
	public void firstUsername(String fname) {
		txt_user_firstname.sendKeys(fname);
	}
	
	public void lastUsername(String lname) {
		txt_user_lastname.sendKeys(lname);
	}
	
	public void email(String UEmail) {
		txt_email.sendKeys(UEmail);
	}
	
	public void phoneNumber(String phone) {
		txt_phoneno.sendKeys(phone);
	}
	
	public void password(String pass) {
		txt_pass.sendKeys(pass);
	}
	
	public void ConfirmPassword(String ConPass) {
		txt_confirm_pass.sendKeys(ConPass);
	}
	
	public void RadioYes() {
		radio_yes.click();
	}
	
	public void RadioNo() {
		radio_no.click();
	}
	
	public void Agree() {
		chk_box_agree.click();
	}
	
	public void btnContinue() {
		btn_continue.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return (confirm_meassage.getText());
		}catch (Exception e) {
			return (e.getMessage());
		}
	}
	
	
}
