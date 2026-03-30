package Pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class RegisterPage extends BasePage {
	private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	public RegisterPage() {
        super();
//        
    }

    @FindBy(id = "input-firstname")
    private WebElement firstNameField;

    @FindBy(id = "input-lastname")
    private WebElement lastNameField;

    @FindBy(id = "input-email")
    private WebElement emailField;

    @FindBy(id = "input-telephone")
    private WebElement telephoneField;

    @FindBy(id = "input-password")
    private WebElement passwordField;

    @FindBy(id = "input-confirm")
    private WebElement confirmPasswordField;

    @FindBy(name = "agree")
    private WebElement privacyPolicyCheckbox;

    @FindBy(css = "input[value='Continue']")
    private WebElement continueButton;

    @FindBy(css = ".alert-success")
    private WebElement successMessage;

    @FindBy(css = ".alert-danger")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'email already')]")
    private WebElement duplicateEmailError;
    
    @FindBy(xpath = "//button[contains(text(),'Accept')] | //button[contains(text(),'Got it')]")
    private WebElement acceptPopupButton;
    
    @FindBy(xpath = "//button[contains(text(),'Dismiss')] | //button[contains(text(),'Close')]")
    private WebElement dismissPopupButton;

    
    public void openRegisterPage() {
        driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
        handlePopupIfExists();
    }

    public void enterFirstName(String firstName) {
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void enterEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterTelephone(String telephone) {
        telephoneField.clear();
        telephoneField.sendKeys(telephone);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.clear();
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void selectPrivacyPolicy() {
        wait.until(ExpectedConditions.elementToBeClickable(privacyPolicyCheckbox));
        privacyPolicyCheckbox.click();
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        continueButton.click();
    }
    
    private void handlePopupIfExists() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));
            
            // Handle Chrome privacy/cookie popup
            WebElement popupBtn = shortWait.until(
                ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(text(),'Accept') or contains(text(),'Got it') or contains(text(),'Dismiss') or contains(text(),'Close') or contains(text(),'Allow')]"
                )
            ));
            popupBtn.click();
            System.out.println("✅ Popup auto-dismissed!");
        } catch (Exception e) {
            // No popup = continue normally
            System.out.println("ℹ️ No popup found");
        }
    }

    

    public boolean isRegistrationSuccess() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isDuplicateEmailError() {
        try {
            // Wait for ANY error message (OpenCart shows different text)
            Thread.sleep(2000);  // Wait for redirect/popup
            
            List<WebElement> errors = driver.findElements(By.cssSelector(".alert-danger, .text-danger, div[class*='alert'][class*='danger']"));
            for (WebElement error : errors) {
                if (error.isDisplayed() && 
                    (error.getText().toLowerCase().contains("email") || 
                     error.getText().toLowerCase().contains("already") ||
                     error.getText().toLowerCase().contains("registered"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

}
