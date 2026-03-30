package stepdefinitions;

import org.testng.Assert;

import Pages.HomePage;
import Pages.ProductComparisonPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductComparisonSteps {

    private HomePage homePage;
    private ProductComparisonPage comparisonPage;

    @When("user adds product to comparison list")
    public void user_adds_product_to_comparison_list() {
        homePage = new HomePage();
        comparisonPage = new ProductComparisonPage();

        homePage.searchProduct("MacBook");
        comparisonPage.addFirstProductToCompare();

        homePage.searchProduct("iPhone");
        comparisonPage.addSecondProductToCompare();

        comparisonPage.openComparisonPage();
    }

    @Then("comparison page should be displayed")
    public void comparison_page_should_be_displayed() {
        Assert.assertTrue(comparisonPage.isComparisonPageDisplayed(),
                "Comparison page not displayed");
    }
}