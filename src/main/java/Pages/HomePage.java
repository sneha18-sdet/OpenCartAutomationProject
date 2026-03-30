package Pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class HomePage extends BasePage{
    
	//private WebDriver driver;
    
    public HomePage() {
    	super();
//        PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//input[@name='search']")
    private WebElement searchBox;
    
    @FindBy(xpath = "//button[@type='submit' or @class='btn btn-default']")
    private WebElement searchButton;
    
    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    private WebElement myAccountLink;
    
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    private WebElement loginLink;
    
    @FindBy(xpath = "//span[contains(@class,'cart')]//a | //a[contains(@href,'shopping_cart')]")
    private WebElement cartLink;
    
    @FindBy(xpath = "//a[contains(text(),'Contact Us')]")
    private WebElement contactUsLink;
    
   
    
    
    public void navigateToLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }
    
    
    public void searchProduct(String productName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchBox.sendKeys(Keys.ENTER);
    }
    
    
    public void navigateToHome() {
        driver.get("https://demo.opencart.com/");
    }
    
    
    public void clickCartLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
    
    
    public void clickMyAccountLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(myAccountLink)).click();
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }
    
    
    public void clickContactUs() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(contactUsLink)).click();
    }
}
