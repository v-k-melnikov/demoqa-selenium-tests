package com.demoqa.tests;

import com.demoqa.pages.RegistrationPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTests extends TestTemplate {

    @Test(priority = 1)
    public void registerUserTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillMainFields("a", "a", "89888888888"
                , getRandomName(), getRandomMail(), "QWErty12", "QWErty12");
        registrationPage.submitData();
        Assert.assertTrue(registrationPage.isRegistrationSuccessfull());
    }

    @DataProvider(name = "minimumAndMaximumCharactersToInput")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{"a", "a", "89888888888", "a", "a@a.com", "QWErty12", "QWErty12"}
                , {getSimpleString(64), getSimpleString(64), "+79888888888"
                , getSimpleString(64), getSimpleString(58) + "@a.com"
                , getSimpleString(62) + "A" + 1, getSimpleString(62) + "A" + 1}};
    }


    @Test(priority = 2, dataProvider = "minimumAndMaximumCharactersToInput"
            , description = "Testing maximum and minimum number of characters accepted for each field")
    public void maxAndMinCharsAvailableTest(String firstName, String lastName, String phoneNumber, String userName
            , String email, String password, String confirmPassword) {

        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillMainFields(firstName, lastName, phoneNumber, userName, email, password, confirmPassword);
        //TODO add unfocus
        Assert.assertTrue(!registrationPage.isThereErrorMessage());
    }

    //TODO
    @Test(priority = 2)
    public void testRequiredFieldsBlank() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();

    }
}
