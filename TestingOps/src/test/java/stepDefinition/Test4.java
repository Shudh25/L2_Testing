package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

// TESTING THE SEARCH
public class Test4 {
    WebDriver driver;

    @Given("User is on the home")
    public void user_is_on_the_home() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");
    }


    @When("User hovers on Services")
    public void user_hovers_on_services() throws InterruptedException {
        WebElement Services = driver.findElement(By.id("what-first-id"));

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(Services).perform();
        Thread.sleep(2000);

    }

    String Url = "https://www.xenonstack.com/services/";

    @Then("User clicks on service1")
    public void user_clicks_on_service() throws InterruptedException {
        WebElement ServicesOption1 = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/div/ul[1]/li[2]/div[3]/div/div/div[2]/div[1]/div/ul/li[1]/a"));

        ServicesOption1.click();

        //After Search Url
        String actualUrl = Url + "big-data-services/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        Thread.sleep(1000);

        // Navigating Back to previous Page
        driver.navigate().back();
    }

    @Then("User clicks on service2")
    public void user_clicks_on_service2() throws InterruptedException {
        user_hovers_on_services();
        WebElement ServicesOption1 = driver.findElement(By.xpath("//*[@id=\"header-drop\"]/div/div[2]/div[1]/div/ul/li[2]/a"));

        ServicesOption1.click();

        //After Search Url
        String actualUrl = Url + "software-development/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        Thread.sleep(1000);

        // Navigating Back to previous Page
        driver.navigate().back();
    }
}