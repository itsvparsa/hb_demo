package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VitAndSupPage extends BasePage{

    @FindBy(css = "[class*='Navigation-module--nav']>ul>li")
    List<WebElement> subNavLinks;

    public void clickOnSubNavLink(String subNavLink) {
        webUtils.pause(1);
        for (WebElement mainNavLink : subNavLinks) {
            if (mainNavLink.getText().equalsIgnoreCase(subNavLink)) {
                mainNavLink.click();
                break;
            }
        }
    }
}
