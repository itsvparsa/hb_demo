package stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageObjects.VitaminsPage;

public class VitaminsSteps extends BaseSteps{

    public VitaminsPage vitaminsPage;

    public VitaminsSteps() {
        vitaminsPage = new VitaminsPage();
    }

    @And("^the user clicks on \"([^\"]*)\" filter$")
    public void the_user_clicks_on_xxx_title(String accordionTitle) {
        vitaminsPage.clickOnAccordionTitle(accordionTitle);
    }

    @When("^the user selects Vitabiotics filter option$")
    public void the_user_selects_vitabiotics_filter_option() {
        vitaminsPage.clickOnVitabioticsFilterOption();
    }
}
