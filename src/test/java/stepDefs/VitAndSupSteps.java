package stepDefs;

import io.cucumber.java.en.And;
import pageObjects.VitAndSupPage;

public class VitAndSupSteps extends BaseSteps{

    public VitAndSupPage vitAndSupPage;

    public VitAndSupSteps() {
        vitAndSupPage = new VitAndSupPage();
    }

    @And("^the user clicks on \"([^\"]*)\"$")
    public void the_user_clicks_on_something (String subNavLink) {
        vitAndSupPage.clickOnSubNavLink(subNavLink);
    }
}
