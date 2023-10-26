package stepDefinition;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;

import java.util.concurrent.TimeUnit;

public class Homepage{
    WebDriver driver;
    @Given("Open the firefox and open xenonstack website")
    public void user_is_on_the_xenonstack_com_homepage() {
//        driver  = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        driver.get("https://www.xenonstack.com/");
        System.out.println("STEP1");
    }
    @When("the homepage is loaded")
    public void the_homepage_is_loaded() {
        driver  = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.get("https://www.xenonstack.com/neural-company/");

        Long backendTime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.responseStart - performance.timing.navigationStart;");

        Long frontendTime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.domComplete - performance.timing.responseStart;");

        System.out.println("Backend Load time is : "+ backendTime.floatValue());
        System.out.println("Frontend Load time is : "+ frontendTime.floatValue());


        System.out.println("STEP2 COMPLETED");
    }
    @Then("the user should see the homepage")
    public void the_user_should_see_the_homepage() {
        System.out.println("STEP3");
    }
}