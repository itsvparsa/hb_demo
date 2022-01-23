package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(css = "[data-test='mega-menu-item']")
    List<WebElement> mainNavLinks;

    public void clickOnMainNavLink(String navLink) {
        webUtils.pause(1);
        for (WebElement mainNavLink : mainNavLinks) {
            if (mainNavLink.getText().equalsIgnoreCase(navLink)) {
                mainNavLink.click();
                break;
            }
        }
    }
}
