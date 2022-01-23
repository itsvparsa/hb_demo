package stepDefs;

import io.cucumber.java.en.And;
import pageObjects.HomePage;

public class HomePageSteps extends BaseSteps{

    public HomePage homePage;

    public HomePageSteps() {
        homePage = new HomePage();
    }

    @And("^the user clicks on \"([^\"]*)\" from main navigation$")
    public void the_user_clicks_on_something_from_main_navigation(String navLink) {
        homePage.clickOnMainNavLink(navLink);
    }
}
