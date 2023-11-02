package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {
    WebDriver driver;
    @Given("Open the firefox and open xenonstack website")
    public void user_is_on_the_xenonstack_com_homepage() {
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.xenonstack.com");

        Long backendTime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.responseStart - performance.timing.navigationStart;");

        Long frontendTime = (Long) ((JavascriptExecutor) driver).executeScript("return performance.timing.domComplete - performance.timing.responseStart;");

        System.out.println("Backend Load time is : "+ backendTime+"ms");
        System.out.println("Frontend Load time is : "+ frontendTime+"ms");

        System.out.println("STEP1 COMPLETED");
    }
    @When("the homepage is loaded")
    public void the_homepage_is_loaded() {
        System.out.println("STEP2 COMPLETED");
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}