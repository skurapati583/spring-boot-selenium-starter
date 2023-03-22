package com.springboot.selenium.demospringbootseleniumstarter.tests;

import com.springboot.selenium.demospringbootseleniumstarter.pages.HomePage;
import com.springboot.selenium.demospringbootseleniumstarter.pages.LoginPage;
import com.springboot.selenium.demospringbootseleniumstarter.pages.SuccessPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class DemoSpringbootSeleniumStarterApplicationTests extends AbstractTestNGSpringContextTests {

	@Autowired
	public HomePage homePage;

	@Autowired
	public LoginPage loginPage;

	@Autowired
	public SuccessPage successPage;

	@Test
	public void testLoginSuccess() {
		homePage.launchInternetHerokuApp();
		homePage.clickHyperlink("Form Authentication");
		loginPage.enterUserNameAndPassword();
		loginPage.clickLoginButton();
		successPage.verifySuccessMessage();
	}

	@Test
	void testLoginFailure() {
		homePage.launchInternetHerokuApp();
		homePage.clickHyperlink("Form Authentication");
		loginPage.enterUserNameAndPasswordInvalid();
		loginPage.clickLoginButton();
		loginPage.verifyLoginFailureMessage();
	}

}
