package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class Test6 {

    WebDriver driver;

    public void page_scroll_down(int n){
        while (n>0){
            driver.findElement(By.xpath("/html/body")).sendKeys(Keys.PAGE_DOWN);
            n--;
        }
    }
    @Given("User is on the BottomPage")
    public void user_is_on_the_bottom_page() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");

        Thread.sleep(1000);

        //Scrolling to the bottom of Page
        page_scroll_down(10);
//        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,8000)");
    }
    @When("User Click on icon1")
    public void user_he_bottom_page() throws InterruptedException {

        WebElement Icon1 = driver.findElement(By.xpath("/html/body/div[2]/div[3]/footer/div[2]/div/div[1]/div/a[1]"));
        Thread.sleep(1500);

        Icon1.click();

        Thread.sleep(2000);
    }
    @Then("After new Tab opened")
    public void checking_after_new_tab_opened() throws InterruptedException {

        // Get all window handles
        Set alltabs = driver.getWindowHandles();

        String url1 = "https://www.youtube.com/@XenonStack?sub_confirmation=1";

        // Using stream API
        alltabs.forEach(tab -> {
            String url = driver.switchTo().window((String) tab).getCurrentUrl();
//                    System.out.println("title is :"+url);
            if (url.equals(url1)){
                Assert.assertEquals(url1, url);
            }
        });
    }
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
