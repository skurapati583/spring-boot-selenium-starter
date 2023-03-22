package com.springboot.selenium.demospringbootseleniumstarter.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage {

    @Value("${username}")
    public String username;

    @Value("${password}")
    public String password;

    @Value("${failure.message}")
    public String failureMessage;

    public LoginPage() {
        super();
    }

    public void enterUserNameAndPassword() {
        enterTextById("username" ,username);
        enterTextById("password" ,password);
    }

    public void clickLoginButton() {
        clickButtonByTagName("button");
    }

    public void enterUserNameAndPasswordInvalid() {
        enterText(webDriver.findElement(By.id("username")) ,"username");
        enterText(webDriver.findElement(By.id("password")) ,"password");
    }

    public void verifyLoginFailureMessage() {
        assert getTextByElementId("flash").contains(failureMessage);
    }
}
