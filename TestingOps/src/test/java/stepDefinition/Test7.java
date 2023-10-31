package stepDefinition;

import io.cucumber.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
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
        try {
            // establish, open connection with URL
            HttpURLConnection cn = (HttpURLConnection) new URL(driver.getCurrentUrl()).openConnection();
            // set HEADER request
            cn.setRequestMethod("HEAD");
            // connection initiate
            cn.connect();
            //get response code
            int res = cn.getResponseCode();
            //Display
            System.out.println("Http response code: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

//      Scrolling to the element on Page
//        WebElement UseCases = driver.findElement(By.xpath("/html/body/div[2]/section[8]/div/div/div[1]/div/div"));

        WebElement UseCases_Link = driver.findElement(By.xpath("/html/body/div[2]/section[8]/div/div/div[1]/div/div/a"));
        WebElement UseCases_Link2 = driver.findElement(By.xpath("/html/body/div[2]/section[8]/div/div/div[2]/div/div[2]/div[3]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", UseCases_Link2);

        UseCases_Link.click();

        //After Click Url
        String actualUrl = "https://www.xenonstack.com/use-cases";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);

        Thread.sleep(2000);





    }
}
