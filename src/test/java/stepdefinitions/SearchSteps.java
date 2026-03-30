package stepdefinitions;

import org.testng.Assert;

import Pages.HomePage;
import Pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchSteps {

    private HomePage homePage;
    private SearchPage searchPage;

    @When("user searches product {string}")
    public void user_searches_product(String product) {
        homePage = new HomePage();
        searchPage = new SearchPage();

        homePage.searchProduct(product);
    }

    @When("user clicks searched product")
    public void user_clicks_searched_product() {
        searchPage.clickFirstSearchResult();
    }

    @Then("search results should be displayed")
    public void search_results_should_be_displayed() {
        Assert.assertTrue(searchPage.isResultDisplayed(),
                "Search result not displayed");
    }
}