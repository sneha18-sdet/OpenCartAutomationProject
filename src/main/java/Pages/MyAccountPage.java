package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	
	
	@FindBy(xpath = "//div[@id = 'content']//ul[@class = 'list-unstyled']")   List<WebElement> Myheadlinelinks;
	
	@FindBy(xpath = "//h2[text()='My Account']")  WebElement MyHeaderName;
	
	
	
	public void MyAccountlinks(String linkName) {
		for (WebElement link : Myheadlinelinks) {
            if (link.getText().trim().equalsIgnoreCase(linkName)) {
                link.click();
                return;
            }}
		
	}
	
	public boolean IsAtMyAccountPage() {
		return MyHeaderName.isDisplayed();
	}
	
}
