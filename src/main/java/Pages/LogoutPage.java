package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class LogoutPage extends BasePage {

    
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Top-right My Account > Logout link
    @FindBy(xpath = "//a[contains(text(),'Logout') and contains(@href,'account/logout')]")
    private WebElement logoutLink;

    // Logout confirmation message / header
    @FindBy(xpath = "//div[@id='content']//h1[contains(text(),'Account Logout')]")
    private WebElement logoutHeader;

    // Optional continue button after logout
    @FindBy(xpath = "//a[contains(@href,'account/account') and contains(text(),'Continue')]")
    private WebElement continueButton;

    

    public void clickLogout() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public boolean isLogoutMessageDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(logoutHeader));
            return logoutHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Optional helper if your scenario clicks Continue after logout
    public void clickContinue() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
        } catch (Exception e) {
            // ignore if not present
        }
    }
}
