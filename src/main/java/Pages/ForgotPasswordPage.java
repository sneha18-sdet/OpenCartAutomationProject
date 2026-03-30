package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class ForgotPasswordPage extends BasePage{
	
   // private WebDriver driver;
    public ForgotPasswordPage() {
    	super();
//        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//div[@id='content']//a[contains(@href,'forgotten')]")
    private WebElement forgotPasswordLink;
    
    @FindBy(name = "email")
    private WebElement emailField;
    
    @FindBy(xpath = "//input[@value='Continue']")
    private WebElement continueButton;
    
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMessage;
    
    
    
    public void clickForgottenPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
    }
    
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    
    public void clickContinue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
    
    public boolean isSuccessMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
