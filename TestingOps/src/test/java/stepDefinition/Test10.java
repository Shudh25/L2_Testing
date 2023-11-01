package stepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.util.concurrent.TimeUnit;

// TESTING THE SEARCH
public class Test10 {
    WebDriver driver;

    @Given("User is on the Website")
    public void userIsOnTheWebsite() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://xenonstack.com");
    }

    @When("User hovers on Resources")
    public void user_hovers_on_resources() throws InterruptedException {
        WebElement Resources = driver.findElement(By.id("resources"));

        //Creating object of an Actions class
        Actions action = new Actions(driver);

        //Performing the mouse hover action on the target element.
        action.moveToElement(Resources).perform();
        Thread.sleep(2000);

    }

    @Then("User clicks on Use Cases")
    public void userClicksOnUseCases() throws InterruptedException {
        WebElement useCases = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/nav/div/ul[1]/li[5]/div[3]/div/div/div/div[2]/div/div[4]/div[2]/ul/li/a"));

        useCases.click();

        //Checking url
        String actualUrl = "https://www.xenonstack.com/use-cases";
        String expectedUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);


//        **********************

        WebElement useCasesCategories = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]"));

        Point point = useCasesCategories.getLocation();
        int xcord = point.getX();
        int ycord = point.getY();
//        System.out.println("xCord : "+xcord +" pixels"+"\nyCord : "+ycord +" pixels");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy("+xcord+","+ycord+")");

        Thread.sleep(3000);


//        *************************************

        WebElement EnterpriseAiCard = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[1]/div/a"));
//        EnterpriseAiCard.click();
        WebElement ApplicationModernisation = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[2]/div/a"));
        WebElement DataAnalytics = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[3]/div/a"));
        WebElement DataOps = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[4]/div/a"));
        WebElement MultiCloud = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[5]/div/a"));
        WebElement PlatformEngineering = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[6]/div/a"));
        WebElement CloudNativeSecurity = driver.findElement(By.xpath("/html/body/div[2]/section[2]/div/div[2]/div/div[7]/div/a"));
//        CloudNativeSecurity.click();
    }


    @After
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }


}