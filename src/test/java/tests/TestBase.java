package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.RegistrationPage;
import pages.TextBoxPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    TextBoxPage textBoxPage = new TextBoxPage();

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @BeforeAll
    static void setupEnv() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.timeout = 10000; // default 4000
        Configuration.browser = "chrome";
        Configuration.browserVersion = "157.0";
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @AfterEach
    void tearDown() {
        closeWebDriver();
    }
}