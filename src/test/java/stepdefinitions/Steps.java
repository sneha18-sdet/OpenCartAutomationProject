package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.MyAccountPage;
import Pages.loginPage;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private loginPage lp;
    private MyAccountPage Maccpage;

    // Constructor Injection (DI)
    public Steps(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
        this.driver = driverFactory.getDriver();
    }

    @Given("user is on the OpenCart login page")
    public void user_is_on_the_open_cart_login_page() {

        driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");

        lp = new loginPage(driver);
        Maccpage = new MyAccountPage(driver);
    }

    @When("user enters email {string} and password {string}")
    public void user_enters_email_and_password(String email, String password) {
        lp.setEmail(email);
        lp.setpassword(password);
    }

    @When("user clicks on Login button")
    public void user_clicks_on_login_button() {
        lp.clickloginBtn();
    }

    @Then("user should be redirected to My Account page")
    public void user_should_be_redirected_to_my_account_page() {
        Assert.assertTrue(Maccpage.IsAtMyAccountPage());
    }

    @Then("warning message should be displayed")
    public void warning_message_should_be_displayed() {
        Assert.assertTrue(lp.getWarningMessage().contains("Warning"));
    }

    @Then("email and password required warning should be displayed")
    public void email_and_password_required_warning_should_be_displayed() {
        Assert.assertTrue(lp.getWarningMessage().contains("Warning"));
    }
}
