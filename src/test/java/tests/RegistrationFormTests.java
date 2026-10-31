package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__month-select").selectOption(month);
        $(String.format(".react-datepicker__day--0%s", day)).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#genterWrapper").$(byText(genter)).click();
        $("#hobbiesWrapper").$(byText(hobby)).click();
        $("#uploadPicture").uploadFromClasspath(picture);
        $("#currentAddress").setValue(currentAddress).pressEnter();
        $("#react-select-3-input").setValue(shtat).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").shouldHave(text(userEmail));
        $(".table-responsive").shouldHave(text(genter));
        $(".table-responsive").shouldHave(text(userNumber));
        $(".table-responsive").shouldHave(text(subjects));
        $(".table-responsive").shouldHave(text(hobby));
        $(".table-responsive").shouldHave(text(data));
        $(".table-responsive").shouldHave(text(currentAddress));
        $(".table-responsive").shouldHave(text(cityAndShtat));
        $("#closeLargeModal").click();
    }


    @Test
    void successFullCompletedWithOnlyRequiredFieldTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(firstName + " " + lastName));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(genter));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(userNumber));
        $("#closeLargeModal").click();
    }


    @Test
    void shortEmailTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(shortEmail);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongEmailTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(wrongEmail);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(userNumber);
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userEmail").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void wrongNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(wrongNumber);
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }

    @Test
    void emptyNumberTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#genterWrapper").$(byText(genter)).click();
        $("#userNumber").setValue(" ");
        $("#submit").click();

        $(".modal-content").shouldNotBe(visible);
        $("#userNumber").shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));
    }
}
