package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.WebDriverManager;
import utilities.WebUtils;

public class BasePage {
    protected static WebUtils webUtils;

    public BasePage() {
        PageFactory.initElements(driver(), this);
        webUtils = new WebUtils();
    }

    protected static WebDriver driver() {
        return WebDriverManager.getDriver();
    }
}
