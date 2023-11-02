package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.concurrent.TimeUnit;

public class Test2 {
    WebDriver driver;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://xenonstack.jobs/app/login");
        Thread.sleep(2000);
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() throws InterruptedException {
        // Locate and enter the username and password fields
        driver.findElement(By.id("tpt_loginUsername")).sendKeys("pandey252001@gmail.com");
        driver.findElement(By.id("tpt_loginPassword")).sendKeys("Shudhxenonstack@25");
        Thread.sleep(2000);
    }

    @When("User clicks the Sign in button")
    public void user_clicks_the_button() throws InterruptedException {
        WebElement SigninButton = driver.findElement(By.xpath("//*[@id=\"loginButton\"]"));
        SigninButton.click();
        Thread.sleep(2000);
    }

    @Then("User should be successfully logged in")
    public void user_should_be_successfully_logged_in() {
        // Add assertions or verifications to confirm a successful login
        // For example, check for a welcome message or a user dashboard page.

        //After Login Url
        String actualUrl="https://xenonstack.jobs/app/dashboard";
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        // Close the browser
        driver.quit();
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}