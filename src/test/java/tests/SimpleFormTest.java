package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SimpleFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void successfulSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue("Elena");
        $("#userEmail").setValue("elena@ya.ru");
        $("textarea#currentAddress").setValue("г Москва");
        $("textarea#permanentAddress").setValue("г Москва");
        $("#submit").click();

        $("#name").shouldHave(text("Elena"));
        $("#email").shouldHave(text("elena@ya.ru"));
        $("p#currentAddress").shouldHave(text("г Москва"));
        $("p#permanentAddress").shouldHave(text("г Москва"));

    }

    @Test
    public void negativeSimpleFormTest() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");
        $("#userName").setValue("Elena");
        $("#userEmail").setValue("elena");
        $("#submit").click();

        $("#name").shouldNot(visible);
        $("#email").shouldNot(visible);
    }
}
