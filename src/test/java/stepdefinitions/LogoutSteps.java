package stepdefinitions;

import org.testng.Assert;
import Pages.LogoutPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LogoutSteps {

    private LogoutPage logoutPage;

    @When("user clicks logout link")
    public void user_clicks_logout_link() {
        logoutPage = new LogoutPage();
        logoutPage.clickLogout();
    }

    @Then("user should be logged out successfully")
    public void user_should_be_logged_out_successfully() {
        Assert.assertTrue(logoutPage.isLogoutMessageDisplayed(),
                "Logout failed - user still logged in");
    }
}