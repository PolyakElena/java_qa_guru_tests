package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#userEmail").setValue("elena@ya.ru");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1999");
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--010").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#subjectsInput").setValue("Biology").pressEnter();
        $("#genterWrapper").$(byText("Other")).click();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("#currentAddress").setValue("г. Москва").pressEnter();
        $("#react-select-3-input").setValue("Rajasthan").pressEnter();
        $("#react-select-4-input").setValue("Jaipur").pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Elena Polyakova"));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text("elena@ya.ru"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text("10 March,1999"));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text("Arts, Biology"));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text("Sports"));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text("1.jpg"));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text("г. Москва"));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text("Rajasthan Jaipur"));
        $("#closeLargeModal").click();
    }


    @Test
    void successFullCompletedWithOnlyRequiredFieldTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text("Elena Polyakova"));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text("1234567890"));
        $("#closeLargeModal").click();
    }


    @Test
    void shortEmailTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#userEmail").setValue("elena@ya");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongEmailTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#userEmail").setValue("elena");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("1234567890");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue("7999");
        $("#submit").click();
        sleep(2000);
        $(".modal-content").shouldNotBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Elena");
        $("#lastName").setValue("Polyakova");
        $("#genterWrapper").$(byText("Other")).click();
        $("#userNumber").setValue(" ");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
