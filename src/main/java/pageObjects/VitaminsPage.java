package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VitaminsPage extends BasePage{

    @FindBy(css = "[class='accordion'] > div > button")
    List<WebElement> accordions;

    @FindBy(css = "[data-test-value='Vitabiotics']")
    WebElement vitabioticsFilter;

    public void clickOnAccordionTitle(String accordionTitle) {
        webUtils.pause(1);
        for (WebElement accordion : accordions) {
            if (accordion.getText().equalsIgnoreCase(accordionTitle)) {
                accordion.click();
                break;
            }
        }
    }

    public void clickOnVitabioticsFilterOption() {
        webUtils.waitTillElementIsVisible(vitabioticsFilter);
        vitabioticsFilter.click();
    }
}
