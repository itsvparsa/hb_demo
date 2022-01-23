package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.SearchPage;
import pageObjects.SearchResultsPage;
import utilities.WebUtils;


import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchSteps extends BaseSteps {

    public SearchPage searchPage;
    public SearchResultsPage searchResultsPage;
    public WebUtils webUtils;

    public SearchSteps() {
        searchPage = new SearchPage();
        searchResultsPage = new SearchResultsPage();
        webUtils = new WebUtils();
    }

    @When("^the user search for (.*)$")
    public void the_user_search_for_something(String searchTerm) {
        searchPage.search(searchTerm);
        searchPage.checkSearchButtonEnabled();
        searchPage.clickOnSearchButton();
    }

    @Then("^the user able to see only (.*) products$")
    public void the_user_able_to_see_some_products(String searchTerm) {
        webUtils.pause(2);
        if (!searchTerm.equalsIgnoreCase("Vitabiotics")) {
            String expectedAfterSearchText = searchResultsPage.getAfterSearchText();
            String actualAfterSearchText = "You searched for " + "\'" + searchTerm + "\'";
            assertEquals("The after search text is not matching!", expectedAfterSearchText, actualAfterSearchText);
        }
        verifyProductTitles(searchTerm);
    }

    public void verifyProductTitles(String searchTerm) {
        List<String> expectedProductTitles = searchResultsPage.getProductTitles();
        for (String expectedProductTitle : expectedProductTitles) {
            System.out.println(expectedProductTitle);
            if (!expectedProductTitle.contains(searchTerm)) {
                String removedSpaceText = expectedProductTitle.replace(" ", "");
                assertTrue("The product title is not matching", removedSpaceText.toLowerCase().contains(searchTerm.toLowerCase()));
            } else {
                assertTrue("The product title is not matching", expectedProductTitle.contains(searchTerm));
            }

        }
    }

    @Then("^validation message shown on the screen$")
    public void validation_message_shown_on_the_screen() {
        String expectedValidationMessage = searchResultsPage.getValidationTextMessage();
        String actualValidationMessage = "Sorry, no results found...";
        assertEquals("Validation message is not matching", expectedValidationMessage, actualValidationMessage);
    }

    @And("^There is search box to search again$")
    public void there_is_search_box_to_search_again() {
        searchPage.verifySearchBoxPresent();
    }

}
