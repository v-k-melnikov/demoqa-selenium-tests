package com.demoqa.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class CommonExpectedConditions {
    public static ExpectedCondition<Boolean> newWindowPresent() {
        return new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                Object[] windows = driver.getWindowHandles().toArray();
                return (windows.length > 1);
            }

            @Override
            public String toString() {
                return "New window not found";
            }
        };
    }
}
