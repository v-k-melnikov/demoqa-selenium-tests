package com.demoqa.cucumbertests.stepdefs;

import com.demoqa.core.CommonExpectedConditions;
import com.demoqa.helpers.User;
import com.demoqa.helpers.UserBuilder;
import com.demoqa.pages.RegistrationPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class BrowserCommands {

    public WebDriver driver;

    public BrowserCommands() {
        driver = Hooks.driver;
    }

    @Given("^Navigate to \"([^\"]*)\"$")
    public void navigateTo(String url) throws Throwable {
        driver.get(url);
    }

    @When("^Fill fields with presented values")
    public void fillFieldsWithPresentedValues(List<User> users) throws Throwable {
        new RegistrationPage(driver).fillRequiredFieldsByUserCredentials(users.get(0));
    }

    @When("^Fill unique values to username and password$")
    public void fillUniqueValuesToUsernameAndPassword() throws Throwable {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillUsername(UserBuilder.getRandomUsername());
        registrationPage.fillEmail(UserBuilder.getRandomMail());
    }

    @Then("^Click on SUBMIT$")
    public void click_on_SUBMIT() throws Throwable {
        new RegistrationPage(driver).submitData();
    }

    @Then("Registration succeed$")
    public void displayed(String arg1) throws Throwable {
        new WebDriverWait(driver, 10).until(CommonExpectedConditions.pageLoaded());
        Assert.assertTrue(new RegistrationPage(driver).isRegistrationSuccessfull());
    }
}