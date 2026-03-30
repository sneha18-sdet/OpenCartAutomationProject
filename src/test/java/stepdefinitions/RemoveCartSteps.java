package stepdefinitions;

import org.testng.Assert;
import Pages.RemoveCartPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class RemoveCartSteps {

    private RemoveCartPage removeCartPage;

    @When("user removes product from cart")
    public void user_removes_product_from_cart() {
        removeCartPage = new RemoveCartPage();
        removeCartPage.removeProduct();
    }

    @Then("cart should be empty")
    public void cart_should_be_empty() {
        Assert.assertTrue(removeCartPage.isCartEmpty(),
                "Cart is not empty after removing product");
    }
}