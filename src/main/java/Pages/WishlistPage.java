package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.DriverManager;

public class WishlistPage extends BasePage{
	
    
    @FindBy(xpath = "//button[contains(@data-original-title,'Wish List')] | //button[contains(@title,'Wish List')]")
    private WebElement wishlistButton;
    
    @FindBy(xpath = "//a[contains(text(),'Wish List')] | //a[contains(@href,'account/wishlist')]")
    private WebElement wishlistLink;
    
    @FindBy(xpath = "//h1[contains(text(),'Wish List')] | //h2[contains(text(),'Wish List')]")
    private WebElement wishlistHeader;
    
    
    
    public void addToWishlist() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wishlistButton)).click();
    }
    
    public void openWishlistPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wishlistLink)).click();
    }
    
    public boolean isWishlistPageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOf(wishlistHeader));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
