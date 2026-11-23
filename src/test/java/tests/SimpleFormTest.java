package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;

import static io.qameta.allure.Allure.step;


public class SimpleFormTest {
    SimpleFormPage simpleFormPage = new SimpleFormPage();

    @BeforeAll
    static void setupEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.browser = "chrome";
        Configuration.browserVersion = "157.0";
        Configuration.remote = "https://user1:1234@selenoid.qa.guru/wd/hub";
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @Test
    @DisplayName("Successful simple form")
    public void successfulSimpleFormTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                simpleFormPage.openPage());

        step("Fill simple form", () -> {
            simpleFormPage.typeUserName(testData.firstName)
                    .typeUserEmail(testData.userEmail)
                    .typeCurrentAddress(testData.currentAddress)
                    .typePermanentAddress(testData.currentAddress)
                    .submit();
        });

        step("Check simple form results data", () -> {
            simpleFormPage.checkField("name", testData.firstName)
                    .checkField("email", testData.userEmail)
                    .checkField("currentAddress", testData.currentAddress)
                    .checkField("permanentAddress", testData.currentAddress);
        });
    }

    @Test
    @DisplayName("Negative simple form")
    public void negativeSimpleFormTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                simpleFormPage.openPage());

        step("Fill simple form", () -> {
            simpleFormPage.typeUserName(testData.firstName)
                    .typeUserEmail(testData.wrongEmail)
                    .submit();
        });

        step("Check not simple form", () -> {
            simpleFormPage.checkNotVisibleElement("name")
                    .checkNotVisibleElement("email");
        });
    }
}
