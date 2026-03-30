package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class CheckoutPage extends BasePage {
	
	public CheckoutPage() {
        super();
//        PageFactory.initElements(driver, this);
    }
    
	@FindBy(xpath = "//h1[contains(text(),'Checkout')] | //h1[contains(text(),'Shopping Cart')]")
	private WebElement checkoutHeader;
    
    
    @FindBy(xpath = "//a[contains(@href,'checkout/checkout') and contains(text(),'Checkout')] | //a[contains(@class,'btn') and contains(text(),'Checkout')]")
    private WebElement checkoutButton;
    
    
    
   
    public void clickCheckout() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
            checkoutButton.click();
        } catch (Exception e) {
            System.out.println("Checkout button not clickable: " + e.getMessage());
        }
    }
    
    public boolean isCheckoutPageDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(checkoutHeader));
            return checkoutHeader.isDisplayed();
        } catch (Exception e) {
            System.out.println("Checkout header not found: " + e.getMessage());
            return false;
        }
    }
}
