package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/fratures",
        glue = {"src/test/java/StepDefination", "src/test/java/utility"},
        plugin = {"pretty", "htnl:target/cucumber-html-report" , "json:cucumber.json"}
)
public class TestRunner {

}
