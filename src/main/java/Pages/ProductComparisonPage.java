package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class ProductComparisonPage extends BasePage{
	
	//private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    
    
    @FindBy(xpath = "//button[contains(@title,'Compare this Product')]")
    private WebElement compareButton;
    
    @FindBy(xpath = "//a[contains(text(),'Product Comparison')]")
    private WebElement comparisonLink;
    
    @FindBy(xpath = "//h1[contains(text(),'Product Comparison')] | //h2[contains(text(),'Product Comparison')]")
    private WebElement comparisonHeader;
    
    
    
    public void addFirstProductToCompare() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }
    
    public void addSecondProductToCompare() {
        // Click second product compare button (adjust index if needed)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(compareButton)).click();
    }
    
    public void openComparisonPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(comparisonLink)).click();
    }
    
    public boolean isComparisonPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(comparisonHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
