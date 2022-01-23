package stepDefs;

import io.cucumber.java.en.Given;
import pageObjects.GenericPage;

public class NavigationSteps extends BaseSteps{

    public GenericPage genericPage;

    public NavigationSteps(){
        genericPage = new GenericPage();
    }

    @Given("^the user navigated to the site$")
    public void the_user_navigated_to_the_site() {
        launchSite();
        System.out.println("Current URL: " + driver().getCurrentUrl());
        System.out.println("Current page title: " + driver().getTitle());
        closeCookieBar();
    }

    public void launchSite() {
        driver().navigate().to("https://www.hollandandbarrett.com/");
    }

    public void closeCookieBar() {
        genericPage.acceptCookie();
    }
}
