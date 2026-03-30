package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class Contactuspage extends BasePage {
    
	
    
    public Contactuspage() {
    	super();
//        //PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//footer//a[contains(@href,'contact')]")
    private WebElement contactUsLink;
    
    @FindBy(name = "name")
    private WebElement nameField;
    
    @FindBy(name = "email")
    private WebElement emailField;
    
    @FindBy(name = "enquiry")
    private WebElement enquiryField;
    
    @FindBy(name = "submit")
    private WebElement submitButton;
    
    @FindBy(xpath = "//div[contains(@class,'alert-success')]")
    private WebElement successMessage;
    
    
    
    public void navigateToContactUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
    }
    
    public void enterName(String name) {
        nameField.clear();
        nameField.sendKeys(name);
    }
    
    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }
    
    public void enterEnquiry(String enquiry) {
        enquiryField.clear();
        enquiryField.sendKeys(enquiry);
    }
    
    public void clickSubmit() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
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
