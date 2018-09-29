package com.demoqa.tests;

import com.demoqa.helpers.User;
import com.demoqa.helpers.UserFactory;
import com.demoqa.pages.RegistrationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTests extends TestTemplate {

    @Test(priority = 1)
    public void registerUserTest() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillRequiredFieldsByUserCredentials(UserFactory.createSignUpUser());
        registrationPage.submitData();
        Assert.assertTrue(registrationPage.isRegistrationSuccessfull());
    }

    @DataProvider(name = "minimumAndMaximumCharactersToInput")
    public Object[][] dataProviderMethod() {
        return new Object[][]{{UserFactory.createUserWithMaximumCredentials()}
                , {UserFactory.createUserWithMinimalCredentials()}};
    }


    @Test(priority = 1, dataProvider = "minimumAndMaximumCharactersToInput"
            , description = "Testing maximum and minimum number of characters accepted for each field")
    public void maxAndMinCharsAvailableTest(User user) {

        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.fillRequiredFieldsByUserCredentials(user);
        registrationPage.submitData();
        Assert.assertTrue(registrationPage.isRegistrationFailedByEmail());
    }

    @Test(priority = 2)
    public void testLeavingRequiredFieldsBlank() {
        RegistrationPage registrationPage = new RegistrationPage(driver).open();
        registrationPage.verifyErrorMessageOnElement(registrationPage.firstNameField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.phoneNumberField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.usernameField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.emailField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.passwordField);
        registrationPage.verifyErrorMessageOnElement(registrationPage.confirmPasswordField);
        }
    }

