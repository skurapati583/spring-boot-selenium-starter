package com.springboot.selenium.demospringbootseleniumstarter.tests;

import com.springboot.selenium.demospringbootseleniumstarter.library.WebDriverLibrary;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoSpringbootSeleniumStarterApplicationTests {

	@Autowired
	public WebDriver webDriver;

	@Value("${api.url}")
	public String appUrl;

	@Test
	public void testBrowserLaunch() {
		webDriver.get(appUrl);
		webDriver.quit();
	}

}
