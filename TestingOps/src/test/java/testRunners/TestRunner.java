package testRunners;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(

//          6th not completed
        features = "/home/xs390-shupan/L2_Testing/TestingOps/src/test/java/features/Test7.feature",
//        features = "/home/xs390-shupan/L2_Testing/TestingOps/src/test/java/features",
        glue =  "stepDefinition",
        plugin = {"pretty","html:target/HtmlReports/html-report.html"}
)
public class TestRunner {
}
