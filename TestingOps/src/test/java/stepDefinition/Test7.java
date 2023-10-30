package stepDefinition;

import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Test7 {

    WebDriver driver;

    public void page_scroll_down(int n){
        while (n>0){
            driver.findElement(By.xpath("/html/body")).sendKeys(Keys.PAGE_DOWN);
            n--;
        }
    }

    @Given("User is on Use Cases")
    public void user_is_on_the_use_cases() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");

        Thread.sleep(1000);

        //Scrolling to the bottom of Page
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,8000);");
        page_scroll_down(9);

    }
}
