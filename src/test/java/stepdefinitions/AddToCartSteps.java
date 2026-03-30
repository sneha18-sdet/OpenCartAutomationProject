package stepdefinitions;

import org.testng.Assert;

import Pages.AddtocartPage;
import factory.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartSteps {

//	private final DriverManager driverManager;
//    private AddtocartPage addcart;
//
//    public AddToCartSteps(DriverManager driverManager) {
//        this.driverManager = driverManager;
//    }
	
	private AddtocartPage addcart;
	
    @Given("user is on the OpenCart home page")
    public void user_is_on_the_open_cart_home_page() {

    	DriverManager.getDriver().get("https://tutorialsninja.com/demo/");
    	addcart = new AddtocartPage();
    }

	@When("user searches for product {string}")
	public void user_searches_for_product(String product) {

		addcart.enterProduct(product);
		addcart.clickSearch();
	}

	@When("user selects the product")
	public void user_selects_the_product() {

		addcart.selectProduct();
	}

	@When("user clicks Add to Cart button")
	public void user_clicks_add_to_cart_button() {

		addcart.clickAddToCart();
	}

	@Then("product should be added to the cart successfully")
	public void product_should_be_added_to_the_cart_successfully() {

		Assert.assertTrue(addcart.getSuccessMessage().contains("Success"));
	}

}