package stepDefs;

import org.openqa.selenium.WebDriver;
import utilities.WebDriverManager;

public class BaseSteps {

    protected WebDriver driver() {
        return WebDriverManager.getDriver();
    }
}
