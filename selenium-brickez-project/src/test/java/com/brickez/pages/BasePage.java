package com.brickez.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//To avoid repeating common selenium code in all POM
//waitForVisibility
//tell selenium to wait until the element is visible on the screen
//waitForClickable
//tell selenium to wait until the element is clickable
//click()= reusable click action
//type()=safely enter text in testfield
//isDisplayed()= checks whether element is displayed on the screen or not

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(
                driver,
                Duration.ofSeconds(10)
        );
    }

    protected WebElement waitForVisibility(By locator) {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    protected WebElement waitForClickable(By locator) {
        return wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    protected void click(By locator) {
        waitForClickable(locator).click();
    }

    protected void type(By locator, String text) {
        WebElement element = waitForVisibility(locator);

        element.clear();
        element.sendKeys(text);
    }

    protected boolean isDisplayed(By locator) {
        return waitForVisibility(locator).isDisplayed();
    }
}
