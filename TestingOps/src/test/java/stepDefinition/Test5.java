package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test5 {
    WebDriver driver;

    @Given("User is on the MainPage")
    public void user_is_on_the_home() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");
    }


    @When("User clicks on Contact us Button")
    public void user_clicks_on_contact_us_button() throws InterruptedException {
        WebElement ContactBtn = driver.findElement(By.xpath("/html/body/div[2]/section[1]/div[1]/div[1]/div/div[1]/div/div/button/div/a"));

        ContactBtn.click();
        Thread.sleep(2000);

    }
    @Then("User clicks on Logo")
    public void user_clicks_on_logo() throws InterruptedException {
        WebElement Logo = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/div/ul[1]/li[1]/a"));

        Logo.click();

//        After Search Url
        String actualUrl = "https://www.xenonstack.com/";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        Thread.sleep(2000);


    }
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
