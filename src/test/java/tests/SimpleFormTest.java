package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.SimpleFormPage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
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

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--disable-dev-shm-usage", "--no-sandbox");
        chromeOptions.setCapability("se:cdpEnabled", false);
        chromeOptions.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = chromeOptions;
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide",
                new AllureSelenide().screenshots(true).savePageSource(true));
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
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
