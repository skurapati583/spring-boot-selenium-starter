package com.springboot.selenium.demospringbootseleniumstarter.pages;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    public HomePage() {
        super();
    }

    @Value("${api.url}")
    public String appUrl;

    public void clickHyperlink(String linkName) {
        clickLinkByText(linkName);
    }

    public void launchInternetHerokuApp() {
        launchURL(appUrl);
    }

}
