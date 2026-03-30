package stepdefinitions;

import org.testng.Assert;

import Pages.ForgotPasswordPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ForgotPasswordSteps {

    private ForgotPasswordPage forgotPasswordPage;

    @When("user clicks forgotten password link")
    public void user_clicks_forgotten_password_link() {
        forgotPasswordPage = new ForgotPasswordPage();
        forgotPasswordPage.clickForgottenPasswordLink();
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        forgotPasswordPage.enterEmail(email);
        forgotPasswordPage.clickContinue();
    }

    @Then("password reset confirmation should be displayed")
    public void password_reset_confirmation_should_be_displayed() {
        Assert.assertTrue(forgotPasswordPage.isSuccessMessageDisplayed(),
                "Password reset confirmation not displayed");
    }
}