package stepdefinitions;

import org.testng.Assert;
import Pages.WishlistPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class WishlistSteps {

    private WishlistPage wishlistPage;

    @When("user adds product to wishlist")
    public void user_adds_product_to_wishlist() {
        wishlistPage = new WishlistPage();
        wishlistPage.addToWishlist();
    }

    @Then("product should be added to wishlist")
    public void product_should_be_added_to_wishlist() {
        Assert.assertTrue(wishlistPage.isWishlistPageDisplayed(),
                "Product not added to wishlist");
    }
}