package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class Test9 {
    WebDriver driver;

    @Given("User opens the nural-company page")
    public void userOpensTheNuralCompanyPage() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.xenonstack.com/neural-company/");
    }

    @When("scrolls the page")
    public void scrollsThePage() throws InterruptedException{
        WebElement formElement = driver.findElement(By.xpath("/html/body/div[2]/section[8]/div"));

        Point point = formElement.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
//        System.out.println("xCord : "+xcord +" pixels"+"\nyCord : "+ycord +" pixels");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy("+xcord+","+ycord+")");
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", formElement);

        Thread.sleep(3000);
    }
    @Then("User enters the values")
    public void userEntersTheValues()  throws InterruptedException{
        // Locate and enter the username and password fields
        driver.findElement(By.id("serFname")).sendKeys("John");
        driver.findElement(By.id("serLname")).sendKeys("Doe");
        driver.findElement(By.id("serEmail")).sendKeys("jd@gmail.com");
        driver.findElement(By.id("serCompanyName")).sendKeys("Jd Associates");
        driver.findElement(By.id("serJobTitle")).sendKeys("Software Engineer");
        driver.findElement(By.id("serPhoneNo")).sendKeys("1234567890");
        driver.findElement(By.id("serMessage")).sendKeys("Hello");

        Thread.sleep(2000);


        WebElement submitButton = driver.findElement(By.xpath("//*[@id=\"reqServicesForm\"]/div[5]/input"));
        submitButton.click();

        //Checking the successful Submission
        WebElement thankyouBox = driver.findElement(By.xpath("/html/body/div[2]/section[8]/div/div/div[2]/div"));

        String dispay = thankyouBox.getCssValue("display");
//        System.out.println(dispay);
        assertEquals("block",dispay);
    }

    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }



}
