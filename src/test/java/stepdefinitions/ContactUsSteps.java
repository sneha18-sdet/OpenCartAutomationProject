package stepdefinitions;

import org.testng.Assert;

import Pages.Contactuspage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

    private Contactuspage contactUsPage;

    @Given("user navigates to Contact Us page")
    public void user_navigates_to_contact_us_page() {
        contactUsPage = new Contactuspage();
        contactUsPage.navigateToContactUs();
    }

    @When("user enters name {string} email {string} and enquiry {string}")
    public void user_enters_name_email_and_enquiry(String name, String email, String enquiry) {
        contactUsPage.enterName(name);
        contactUsPage.enterEmail(email);
        contactUsPage.enterEnquiry(enquiry);
    }

    @When("user clicks submit button")
    public void user_clicks_submit_button() {
        contactUsPage.clickSubmit();
    }

    @Then("contact enquiry should be submitted successfully")
    public void contact_enquiry_should_be_submitted_successfully() {
        Assert.assertTrue(contactUsPage.isSuccessMessageDisplayed(),
                "Contact enquiry success message not displayed");
    }
}