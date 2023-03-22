package com.springboot.selenium.demospringbootseleniumstarter.pages;

import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SuccessPage extends BasePage {

    @Value("${success.message}")
    public String successMessage;

    public SuccessPage() {
        super();
    }

    public void verifySuccessMessage() {
        assert getTextByElementId("flash").contains(successMessage);
    }
}
