package stepdefinitions;

import Pages.RegisterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.util.Map;

public class RegisterSteps {

    private RegisterPage registerPage;

    @Given("user is on register page")
    public void user_is_on_register_page() {
        registerPage = new RegisterPage();
        registerPage.openRegisterPage();
    }

    @When("user enters registration details")
    public void user_enters_registration_details(Map<String, String> data) {
        registerPage.enterFirstName(data.get("firstName"));
        registerPage.enterLastName(data.get("lastName"));
        registerPage.enterEmail(data.get("email"));
        registerPage.enterTelephone(data.get("telephone"));
        registerPage.enterPassword(data.get("password"));
        registerPage.enterConfirmPassword(data.get("confirmPassword"));
        registerPage.selectPrivacyPolicy();
        registerPage.clickContinue();
    }

    @Then("user should register successfully")
    public void user_should_register_successfully() {
        Assert.assertTrue(registerPage.isRegistrationSuccess(), "Registration failed");
    }

    @Then("duplicate email error should be displayed")
    public void duplicate_email_error_should_be_displayed() {
        Assert.assertTrue(registerPage.isDuplicateEmailError(), "Duplicate email error not shown");
    }
}