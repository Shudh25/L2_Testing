package testRunners;

//import cucumber.api.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
//        name of features file
        features = "/home/xs390-shupan/L2_Testing/TestingOps/src/test/java/features/Test4.feature",
//        features = "/home/xs390-shupan/L2_Testing/TestingOps/src/test/java/features",
        glue =  "stepDefinition"
)
public class TestRunner {
}
