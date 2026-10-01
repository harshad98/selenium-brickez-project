package com.brickez.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

//Automate screenshot logic at one resuable place
//null safety check, check the WebDriver object
//If the driver does not support screenshots, stop and return an empty byte array.
//"Treat this WebDriver object as a TakesScreenshot object. then capture a screenshot,
//return that screenshot in bytes array
public class ScreenshotUtil {
    private ScreenshotUtil() {
        // Utility class
    }

    public static byte[] capture(WebDriver driver) {

        if (driver == null) {
            return new byte[0];
        }

        if (!(driver instanceof TakesScreenshot)) {
            return new byte[0];
        }

        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

}
