package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

import java.time.Duration;

public class SearchPage extends BasePage {

    //private WebDriver driver;
    private WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    // Search results locators (tutorialsninja demo)
    @FindBy(css = ".alert.alert-danger")
    private WebElement noResultsMessage;

    @FindBy(css = "p:nth-child(2)")
    private WebElement resultsCount;

    @FindBy(css = "h3 a")
    private WebElement firstSearchResultLink;

    @FindBy(css = "div.product-thumb")
    private WebElement firstProductThumb;

    @FindBy(css = ".product-thumb h4")
    private WebElement productTitle;

    

    public void clickFirstSearchResult() {
        wait.until(ExpectedConditions.elementToBeClickable(firstSearchResultLink));
        firstSearchResultLink.click();
    }

    public boolean isResultDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOf(firstProductThumb));
            return firstProductThumb.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNoResultMessageDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getResultsCount() {
        try {
            wait.until(ExpectedConditions.visibilityOf(resultsCount));
            return resultsCount.getText();
        } catch (Exception e) {
            return "";
        }
    }

    public String getFirstProductTitle() {
        try {
            wait.until(ExpectedConditions.visibilityOf(productTitle));
            return productTitle.getText();
        } catch (Exception e) {
            return "";
        }
    }
}
