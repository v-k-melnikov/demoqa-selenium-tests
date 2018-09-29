package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    private int timeOut = 5;

    BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, timeOut);
        PageFactory.initElements(driver, this);
    }


    private void changeImplicitWait(int value, TimeUnit timeUnit) {
        driver.manage().timeouts().implicitlyWait(value, timeUnit);
    }


    private void restoreDefaultImplicitWait() {
        changeImplicitWait(timeOut, TimeUnit.SECONDS);
    }

    boolean isElementOnPage(WebElement element) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean isElementOnPage = true;
        try {
            // Get location on WebElement is rising exception when element is not present
            element.getLocation();
        } catch (WebDriverException ex) {
            isElementOnPage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return isElementOnPage;
    }

    boolean doesElementHaveErrorMessage(WebElement element) {
        changeImplicitWait(500, TimeUnit.MILLISECONDS);
        boolean doesElementHaveErrorMessage = true;
        try {
            element.findElement(By.xpath("../../div[@class='fieldset error']"));
        } catch (WebDriverException ex) {
            doesElementHaveErrorMessage = false;
        } finally {
            restoreDefaultImplicitWait();
        }
        return doesElementHaveErrorMessage;
    }
}
