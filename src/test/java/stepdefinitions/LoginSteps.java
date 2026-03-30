package stepdefinitions;

import org.testng.Assert;
import Pages.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    private loginPage loginPage;

    @Given("user is on the OpenCart login page")
    public void user_is_on_the_open_cart_login_page() {
        loginPage = new loginPage();
        loginPage.openLoginPage();
    }

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLoginButton();
    }

    @Then("user should be logged in successfully")
    public void user_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccess(),
                "Login failed - user not logged in");
    }
}