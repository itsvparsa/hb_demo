package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={"html:target/cukes-test-report/report.html",
                "json:target/cukes-test-report/report-json.json",
                "junit:target/cukes-test-report/report-xml.xml"},
        features={"src/test/resources/featureFiles"},
        glue={"stepDefs"}
        )

public class RunCukesTest {

}
