package stepDefinition;

import io.cucumber.java.en.*;
//import cucumber.api.java.en.Given;
public class Steps{
    @Given("^Open the firefox$")
    public void open_the_firefox() throws Throwable {
//        System.setProperty("webdriver.gecko.driver","")
        System.out.println("Open the firefox");
    }
    @When("I enter valid username and valid password")
    public void i_enter_valid_username_and_valid_password() throws Throwable {
        System.out.println("I enter valid username and valid password");

    }
    @Then("user should be able to login successfully")
    public void user_should_be_able_to_login_successfully() {
        System.out.println("user should be able to login successfully");
    }
}