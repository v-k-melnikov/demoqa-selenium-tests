package com.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public final static String URL_PATH = "https://web.archive.org/web/20180815044632/http://demoqa.com/registration";
    private final static String EXPECTED_TITLE = "Registration | Demoqa";

    @FindBy(id = "name_3_firstname")
    private static WebElement firstNameArea;
    @FindBy(id = "name_3_lastname")
    private static WebElement lastNameArea;
    @FindBy(id = "phone_9")
    private static WebElement phoneNumberArea;
    @FindBy(id = "username")
    private static WebElement usernameArea;
    @FindBy(id = "email_1")
    private static WebElement emailArea;
    @FindBy(id = "password_2")
    private static WebElement passwordArea;
    @FindBy(id = "confirm_password_password_2")
    private static WebElement confirmPasswordArea;
    @FindBy(name = "pie_submit")
    private static WebElement submitButton;
    @FindBy(css = ".piereg_message")
    private static WebElement regInfo;
    @FindBy(css = "[class='legend error']")
    private static WebElement errorAlert;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(EXPECTED_TITLE, actualTitle);
    }

    public void fillFirstName(String str) {
        firstNameArea.sendKeys(str);
    }

    public void fillLastName(String str) {
        lastNameArea.sendKeys(str);
    }

    public void fillPhoneNumber(String str) {
        phoneNumberArea.sendKeys(str);
    }

    public void fillUsername(String str) {
        usernameArea.sendKeys(str);
    }

    public void fillEmail(String str) {
        emailArea.sendKeys(str);
    }

    public void fillPassword(String str) {
        passwordArea.sendKeys(str);
    }

    public void fillConfirmPassword(String str) {
        confirmPasswordArea.sendKeys(str);
    }

    public void fillMainFields(String firstName, String lastName, String phoneNumber, String userName
            , String email, String password, String confirmPassword) {

        fillFirstName(firstName);
        fillLastName(lastName);
        fillPhoneNumber(phoneNumber);
        fillUsername(userName);
        fillEmail(email);
        fillPassword(password);
        fillConfirmPassword(confirmPassword);
    }
    public RegistrationPage open(){
        driver.get(URL_PATH);
        return this;
    }
    public void submitData() {
        submitButton.click();
   }

    public boolean isRegistrationSuccessfull() {
        return regInfo.getText().equals("Thank you for your registration");
    }

    public boolean isThereErrorMessage(){
        return isElementOnPage(errorAlert);
    }
}
