package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

// TESTING THE SEARCH
public class Test3 {
    WebDriver driver;
    @Given("User is on the homepage")
    public void user_is_onhomepage() throws InterruptedException {
        driver  = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");
        Thread.sleep(2000);


        WebElement SearchButton = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/div/ul[2]/li[2]/img"));
        SearchButton.click();

        WebElement InputSearch = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/div[2]/div/div[1]/div/div/div/div/div/form/input"));

        String SearchTerm = "Devops";
        InputSearch.sendKeys(SearchTerm);
        Thread.sleep(1000);
        InputSearch.sendKeys(Keys.ENTER);


        //After Search Url
        String actualUrl="https://www.xenonstack.com/hs-search-results?term=" + SearchTerm;
        String expectedUrl= driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);

        Thread.sleep(3000);

        driver.quit();

    }
}
