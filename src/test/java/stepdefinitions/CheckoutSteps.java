package stepdefinitions;

import org.testng.Assert;

import Pages.CheckoutPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

    private CheckoutPage cp;

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        cp = new CheckoutPage();
        cp.clickCheckout();
    }

    @Then("checkout page should be displayed")
    public void checkout_page_should_be_displayed() {
        Assert.assertTrue(cp.isCheckoutPageDisplayed(),
                "Checkout page not displayed - header missing");
    }
}