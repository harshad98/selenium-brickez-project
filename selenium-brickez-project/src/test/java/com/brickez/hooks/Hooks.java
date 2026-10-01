package com.brickez.hooks;

import com.brickez.utils.DriverManager;
import com.brickez.utils.ScreenshotUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;

//before scenario and after scenario steps
//initialize driver, get the current driver, maximize the browser
//teardown logic
//receives current scenario object,
//if the current scenario has failed,
//Take a screenshot of the current browser
//if screenshot was captured, attach it to the allure report
//closes the browser session
public class Hooks {
    @Before
    public void setUp() {

        DriverManager.initializeDriver();

        DriverManager.getDriver()
                .manage()
                .window()
                .maximize();
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {

            byte[] screenshot =
                    ScreenshotUtil.capture(
                            DriverManager.getDriver()
                    );

            if (screenshot.length > 0) {

                Allure.addAttachment(
                        "Failure Screenshot - " + scenario.getName(),
                        "image/png",
                        new java.io.ByteArrayInputStream(screenshot),
                        ".png"
                );
            }
        }

        DriverManager.quitDriver();
    }
}
