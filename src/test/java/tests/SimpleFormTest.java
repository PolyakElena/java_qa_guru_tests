package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class SimpleFormTest {

    @BeforeAll
    static void setupEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void successfulSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(userEmail);
        $("textarea#currentAddress").setValue(currentAddress);
        $("textarea#permanentAddress").setValue(currentAddress);
        $("#submit").click();

        $("#name").shouldHave(text(firstName));
        $("#email").shouldHave(text(userEmail));
        $("p#currentAddress").shouldHave(text(currentAddress));
        $("p#permanentAddress").shouldHave(text(currentAddress));

    }

    @Test
    public void negativeSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue(firstName);
        $("#userEmail").setValue(wrongEmail);
        $("#submit").click();

        $("#name").shouldNot(visible);
        $("#email").shouldNot(visible);
    }
}
