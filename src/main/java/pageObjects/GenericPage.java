package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenericPage extends BasePage {

    @FindBy(css = "#cookie-consent-accept")
    WebElement cookieAcceptButton;

    public void acceptCookie() {
        webUtils.pause(1);
        webUtils.waitTillElementIsVisible(cookieAcceptButton);
        cookieAcceptButton.click();
    }
}