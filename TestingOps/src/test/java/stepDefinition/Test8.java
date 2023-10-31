package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Test8 {
    WebDriver driver;

    @Given("User opens the website")
    public void user_open_the_website() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");
    }
    @Then("receives the status code")
    public void receives_the_status_code() throws InterruptedException {
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
            Assert.assertEquals(200,res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

}
