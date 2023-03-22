package com.springboot.selenium.demospringbootseleniumstarter.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class BasePage {

    @Autowired
    public WebDriver webDriver;

    public void enterText(WebElement element, CharSequence text) {
        element.sendKeys(text);
    }

    public void clickButton(WebElement element) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(element).build().perform();
        element.click();
    }

    public void launchURL(String url) {
        webDriver.manage().window().maximize();
        webDriver.get(url);
    }

    public void clickLinkByText(String linkName) {
        By by = By.linkText(linkName);
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(by));
        new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.stalenessOf(element));
        clickButton(element);
    }

    public void enterTextById(String id, String text) {
        By by = By.id(id);
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(by));
        element.sendKeys(text);
    }

    public void clickButtonByTagName(String tag) {
        By by = By.tagName(tag);
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(by));
        clickButton(element);
    }

    public String getTextByElementId(String id) {
        By by = By.id(id);
        WebElement element = new WebDriverWait(webDriver, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(by));
        return element.getText();

    }

}
