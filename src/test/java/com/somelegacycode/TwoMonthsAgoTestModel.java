package com.somelegacycode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public  class TwoMonthsAgoTestModel {
    private static WebDriver driver;
    private static WebElement firstName;
    private static WebElement lastName;
    private static WebElement danceHobby;
    private static WebElement readingHobby;
    private static WebElement phoneNumber;
    private static WebElement username;
    private static WebElement email;
    private static WebElement description;
    private static WebElement password;
    private static WebElement confirmPassword;
    private static WebElement submit;
    private static List<WebElement> errorDivArr;
    private static WebElement regInfo;

    private String simpleString(int length) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < length; i++) {
            str.append("a");
        }
        return str.toString();
    }

    private void enterValidValues() {
        firstName.sendKeys("a");
        lastName.sendKeys("a");
        if (!danceHobby.isSelected()) {
            danceHobby.click();
        }
        phoneNumber.sendKeys("89888888888");
        username.sendKeys("a");
        email.sendKeys("a@a.com");
        password.sendKeys("QWErty12");
        confirmPassword.sendKeys("QWErty12");
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        phoneNumber.clear();
        username.clear();
        email.clear();
        description.clear();
        password.clear();
        confirmPassword.clear();
    }

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("http://demoqa.com/registration/");

        firstName = driver.findElement(By.name("first_name"));
        lastName = driver.findElement(By.name("last_name"));
        danceHobby = driver.findElements(By.name("checkbox_5[]")).get(0);
        readingHobby = driver.findElements(By.name("checkbox_5[]")).get(1);
        phoneNumber = driver.findElement(By.name("phone_9"));
        username = driver.findElement(By.name("username"));
        email = driver.findElement(By.name("e_mail"));
        description = driver.findElement(By.name("description"));
        password = driver.findElement(By.name("password"));
        confirmPassword = driver.findElement(By.id("confirm_password_password_2"));
        submit = driver.findElement(By.name("pie_submit"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test(priority = 1, description = "Testing minimum number of characters accepted for each field and first cases for fields \"Hobby\" and \"Phone Number\" ")
    public void testFirstCaseFirstScenario() {

        firstName.sendKeys("a");
        lastName.sendKeys("a");
        danceHobby.click();
        phoneNumber.sendKeys("89888888888");
        username.sendKeys("a");
        email.sendKeys("a@a.com");
        password.sendKeys("QWErty12");
        confirmPassword.sendKeys("QWErty12");
        submit.click();
        regInfo = driver.findElement(By.className("piereg_message"));
        Assert.assertEquals(regInfo.getText(), "Thank you for your registration");

    }

    @Test(priority = 1, description = "Testing maximum number of characters accepted for each field and second cases for fields \"Hobby\" and \"Phone Number\" and .")
    public void testFirstCaseSecondScenario() {

        firstName.sendKeys(simpleString(64));
        lastName.sendKeys(simpleString(64));
        danceHobby.click();
        readingHobby.click();
        phoneNumber.sendKeys("+79888888888");
        username.sendKeys("a");
        email.sendKeys(simpleString(58) + "@a.com");
        description.sendKeys(simpleString(256));
        password.sendKeys(simpleString(62) + "A" + 1);
        confirmPassword.sendKeys(simpleString(62) + "A" + 1);
        submit.click();
        regInfo = driver.findElement(By.className("piereg_message"));
        Assert.assertEquals(regInfo.getText(), "Thank you for your registration");

    }

    @Test(priority = 2, description = "MyTest leaving a required field blank.")
    public void testSecondCaseFirstScenario() {

//        enterValidValues();
//        firstName.clear();
//        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
//        Assert.assertEquals(errorDivArr.size(), 1);
//        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "first_name");
//        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath("./span[@class=legend error]")).getText(), "This field is required");
//        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

//        clearFields();
//        enterValidValues();
//        lastName.clear();
//        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
//        Assert.assertEquals(errorDivArr.size(), 1);
//        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "first_name");
//        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

        clearFields();
        enterValidValues();
        phoneNumber.clear();
        submit.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        //error message must be only one
        Assert.assertEquals(errorDivArr.size(), 1);
        //at the right place
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "phone_9");
        //with right words
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

        clearFields();
        enterValidValues();
        username.clear();
        submit.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        Assert.assertEquals(errorDivArr.size(), 1);
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "username");
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

        clearFields();
        enterValidValues();
        email.clear();
        submit.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        Assert.assertEquals(errorDivArr.size(), 1);
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "e_mail");
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

        clearFields();
        enterValidValues();
        password.clear();
        submit.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        Assert.assertEquals(errorDivArr.size(), 1);
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//input")).getAttribute("name"), "password");
        Assert.assertEquals(errorDivArr.get(0).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field is required");

    }

    @Test(priority = 2, description = "MyTest exceeding maximum field input lengths.")
    public void testSecondCaseSecondScenario() {

        firstName.sendKeys(simpleString(65));
        lastName.sendKeys(simpleString(65));
        username.sendKeys(simpleString(65));
        email.sendKeys(simpleString(59) + "@a.com");
        description.sendKeys(simpleString(257));
        password.sendKeys(simpleString(65));
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        Assert.assertEquals(errorDivArr.size(), 5);
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(errorDivArr.get(i).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* Exceeded the allowed number of characters");
        }
    }

    @Test(priority = 2, description = "MyTest various field input.")
    public void testSecondCaseThirdScenario() {

        firstName.sendKeys("#");
        lastName.sendKeys("^");
        description.sendKeys("@");
        password.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        for (int i = 0; i < 3; i++) {
            Assert.assertEquals(errorDivArr.get(i).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field allows to enter only letters");
        }
        enterValidValues();
        clearFields();
        phoneNumber.sendKeys("a");
        firstName.click();
        errorDivArr = driver.findElements(By.xpath("//div[@class ='fieldset error']"));
        Assert.assertEquals(errorDivArr.get(2).findElement(By.xpath(".//span[@class='legend error']")).getText(), "* This field allows to enter only digits and '+'");

        email.clear();
        email.sendKeys("a");
        firstName.click();
        Assert.assertEquals(errorDivArr.get(4).findElement(By.xpath(".//span[@class='legend error']")).getText(), "Entered value is not valid for e-mail");

        email.clear();
        email.sendKeys("a@b");
        firstName.click();
        Assert.assertEquals(errorDivArr.get(4).findElement(By.xpath(".//span[@class='legend error']")).getText(), "Entered value is not valid for e-mail");

        email.clear();
        email.sendKeys("a.b");
        firstName.click();
        Assert.assertEquals(errorDivArr.get(4).findElement(By.xpath(".//span[@class='legend error']")).getText(), "Entered value is not valid for e-mail");

        email.clear();
        email.sendKeys("a@b@c.b");
        firstName.click();
        Assert.assertEquals(errorDivArr.get(4).findElement(By.xpath(".//span[@class='legend error']")).getText(), "Entered value is not valid for e-mail");

    }

    public static void main(String[] args) {

        TwoMonthsAgoTestModel testModel = new TwoMonthsAgoTestModel();
        testModel.setUp();
        testModel.testFirstCaseFirstScenario();
//        testModel.testFirstCaseSecondScenario();
//        testModel.testSecondCaseFirstScenario();
//        testModel.testSecondCaseSecondScenario();
//        testModel.testSecondCaseThirdScenario();
        testModel.tearDown();

    }
}
