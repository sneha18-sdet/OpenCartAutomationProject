package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class MyAccountPage extends BasePage{

    
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Header or breadcrumb that appears on My Account page
    @FindBy(xpath = "//h2[normalize-space()='My Account'] | //h1[normalize-space()='My Account']")
    private WebElement myAccountHeader;

    

    public boolean IsAtMyAccountPage() {
        try {
            wait.until(ExpectedConditions.visibilityOf(myAccountHeader));
            return myAccountHeader.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
