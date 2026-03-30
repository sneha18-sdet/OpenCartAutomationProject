package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class RemoveCartPage extends BasePage{
    //private WebDriver driver;
    
    @FindBy(xpath = "//a[contains(@href,'shopping_cart')]")
    private WebElement cartLink;
    
    @FindBy(xpath = "//button[contains(@data-original-title,'Remove')] | //a[contains(@title,'Remove')]")
    private WebElement removeButton;
    
    @FindBy(xpath = "//strong[contains(text(),'0 item')] | //span[contains(text(),'empty')]")
    private WebElement emptyCartMessage;
    
    public RemoveCartPage() {
    	super();
//        //PageFactory.initElements(driver, this);
    }
    
    public void openCartPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }
    
    public void removeProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }
    
    public boolean isCartEmpty() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
