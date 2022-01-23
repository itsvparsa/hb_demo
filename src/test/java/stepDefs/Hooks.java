package stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.WebDriverManager;

public class Hooks {

    @Before
    public static void beforeScenario(Scenario scenario) {
        WebDriverManager.getDriver();
        System.out.println(String.format("\n############################################### " +
                "Scenario '%s' is running:", scenario.getName()));
    }

    @After
    public void tearDown() {
        WebDriverManager.tearDown();
    }
}
