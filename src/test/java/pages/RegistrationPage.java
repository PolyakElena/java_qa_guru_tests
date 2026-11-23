package pages;

import io.qameta.allure.Step;
import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.cssValue;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendar = new CalendarComponent();
    CheckResultTableComponent checkResultTableComponent = new CheckResultTableComponent();

    private SelenideElement firstNameInput = $("#firstName");
    private SelenideElement lastNameInput = $("#lastName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement userNumberInput = $("#userNumber");
    private SelenideElement genderContainer = $("#genterWrapper");
    private SelenideElement hobbiesContainer = $("#hobbiesWrapper");
    private SelenideElement subjectsInput = $("#subjectsInput");
    private SelenideElement stateSelect = $("#state");
    private SelenideElement citySelect = $("#city");
    private SelenideElement stateCityContainer = $("#stateCity-wrapper");
    private SelenideElement uploadPicture = $("#uploadPicture");
    private SelenideElement currentAddressInput = $("#currentAddress");
    private SelenideElement closeModalButton = $("#closeLargeModal");
    private SelenideElement submitButton = $("#submit");
    private final SelenideElement modalWindow = $(".modal-content");

    @Step("Open registration page /automation-practice-form")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
//        executeJavaScript("$('#fixedban').remove()");
//        executeJavaScript("$('footer').remove()");

        return this;
    }

    @Step("Type first name \"{value}\"")
    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    @Step("Type last name \"{value}\"")
    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    @Step("Type user Email \"{value}\"")
    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Type user number \"{value}\"")
    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    @Step("Type current address \"{value}\"")
    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Set gender \"{value}\"")
    public RegistrationPage setGender(String value) {
        genderContainer.$(byText(value)).click();

        return this;
    }

    @Step("Set hobby \"{value}\"")
    public RegistrationPage setHobby(String value) {
        hobbiesContainer.$(byText(value)).click();

        return this;
    }

    @Step("set date of birth day \"{day}\", month \"{month}\", year\"{year}\"")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendar.setDate(day, month, year);

        return this;
    }

    @Step("Type subjects \"{value}\"")
    public RegistrationPage typeSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();

        return this;
    }

    @Step("upload picture \"{value}\"")
    public RegistrationPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    @Step("set state \"{value}\"")
    public RegistrationPage setState(String value) {
        stateSelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    @Step("set city \"{value}\"")
    public RegistrationPage setCity(String value) {
        citySelect.click();
        stateCityContainer.$(byText(value)).click();

        return this;
    }

    @Step("set state \"{state}\" and city \"{city}\"")
    public RegistrationPage setStateAndCity(String state, String city) {
        setState(state);
        setCity(city);

        return this;
    }

    @Step("submit form")
    public RegistrationPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("check modal window visible")
    public RegistrationPage checkModalWindow() {
        modalWindow.shouldBe(visible);
        modalWindow.shouldHave(text("Thanks for submitting the form"));
        return this;
    }

    @Step("check modal window not visible")
    public RegistrationPage checkNotModalWindow() {
        modalWindow.shouldNotBe(visible);
        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public RegistrationPage checkResult(String key, String value) {
        checkResultTableComponent.checkResult(key, value);

        return this;
    }

    @Step("check user Email border color")
    public RegistrationPage checkUserEmailBorderColor() {
        userEmailInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    @Step("check user number border color")
    public RegistrationPage checkUserNumberBorderColor() {
        userNumberInput.shouldHave(cssValue("border-color", "rgb(220, 53, 69)"));

        return this;
    }

    @Step("close modal form")
    public RegistrationPage closeModalForm() {
        closeModalButton.click();

        return this;
    }

}