package com.example.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.example.stepdefinations",
        plugin = {
                "pretty"
        },
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
