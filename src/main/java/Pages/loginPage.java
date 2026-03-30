package Pages;

import java.time.Duration;

//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage extends BasePage {
    
    //private WebDriver driver;
    
    public loginPage() {
        super();
//        PageFactory.initElements(driver, this);
    }
    
    @FindBy(id = "input-email")
    private WebElement emailField;
    
    @FindBy(id = "input-password")
    private WebElement passwordField;
    
    @FindBy(css = "input[value='Login']")
    private WebElement loginButton;
    
    @FindBy(linkText = "Forgotten Password")
    private WebElement forgotPasswordLink;
    
    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;
    
    @FindBy(css = ".alert-success")
    private WebElement successMessage;
    
    public void openLoginPage() {
        driver.get("https://demo.opencart.com/index.php?route=account/login");
    }
    
    public void enterEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        emailField.clear();
        emailField.sendKeys(email);
    }
    
    public void enterPassword(String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(passwordField));
        passwordField.clear();
        passwordField.sendKeys(password);
    }
    
    public void clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    
    public void clickForgottenPasswordLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink)).click();
    }
    
    public boolean isLoginSuccess() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(successMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isErrorMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(errorMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
