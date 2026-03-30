package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import factory.DriverManager;

public class AddtocartPage extends BasePage {

	public AddtocartPage() {
		super();
	}

	@FindBy(name="search")
	WebElement search_box;

	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	WebElement search_btn;

	@FindBy(linkText="MacBook")
	WebElement product_click;

	@FindBy(id="button-cart")
	WebElement add_to_cart_btn;

	@FindBy(css=".alert-success")
	WebElement success_message;

	public void enterProduct(String product) {
		search_box.clear();
		search_box.sendKeys(product);
	}

	public void clickSearch() {
		search_btn.click();
	}

	public void selectProduct() {
		product_click.click();
	}

	public void clickAddToCart() {
		add_to_cart_btn.click();
	}

	public String getSuccessMessage() {
		return success_message.getText();
	}

}