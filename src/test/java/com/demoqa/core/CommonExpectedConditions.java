package com.demoqa.core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CommonExpectedConditions {

    public static ExpectedCondition<Boolean> pageLoaded() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor exec = (JavascriptExecutor) driver;
                return exec.executeScript("return document.readyState").equals("complete");
            }

            @Override
            public String toString() {
                return "Page didn't load";
            }
        };

    }
}
