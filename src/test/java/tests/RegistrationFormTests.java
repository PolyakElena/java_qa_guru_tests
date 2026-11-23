package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class RegistrationFormTests extends TestBase {

    @Test
    @DisplayName("Successful Registration")
    void successfulFillFormTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .setGender(testData.genter)
                    .typeUserNumber(testData.userNumber)
                    .setDateOfBirth(testData.day, testData.month, testData.year)
                    .typeSubjects(testData.subject)
                    .setHobby(testData.hobby)
                    .uploadPicture(testData.picture)
                    .typeCurrentAddress(testData.currentAddress)
                    .setStateAndCity(testData.state, testData.city)
                    .submitForm();
        });

        step("Check registration form results data", () -> {
            registrationPage.checkModalWindow()
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Student Email", testData.userEmail)
                    .checkResult("Gender", testData.genter)
                    .checkResult("Mobile", testData.userNumber)
                    .checkResult("Date of Birth", testData.data)
                    .checkResult("Subjects", testData.subject)
                    .checkResult("Hobbies", testData.hobby)
                    .checkResult("Picture", testData.picture)
                    .checkResult("Address", testData.currentAddress)
                    .checkResult("State and City", testData.state + " " + testData.city)
                    .closeModalForm();
        });
    }

    @Test
    @DisplayName("Successful completed with only required field")
    void successFullCompletedWithOnlyRequiredFieldTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.genter)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });

        step("Check registration form results data", () -> {
            registrationPage.checkModalWindow()
                    .checkResult("Student Name", testData.firstName + " " + testData.lastName)
                    .checkResult("Gender", testData.genter)
                    .checkResult("Mobile", testData.userNumber)
                    .closeModalForm();
        });
    }

    @Test
    @DisplayName("Short Email")
    void shortEmailTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.shortEmail)
                    .setGender(testData.genter)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });

        step("Check not registration form", () -> {
            registrationPage.checkNotModalWindow()
                    .checkUserEmailBorderColor();
        });
    }

    @Test
    @DisplayName("Wrong Email")
    void wrongEmailTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .typeUserEmail(testData.wrongEmail)
                    .setGender(testData.genter)
                    .typeUserNumber(testData.userNumber)
                    .submitForm();
        });

        step("Check not registration form", () -> {
            registrationPage.checkNotModalWindow()
                    .checkUserEmailBorderColor();
        });
    }

    @Test
    @DisplayName("Wrong number")
    void wrongNumberTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage.typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.genter)
                    .typeUserNumber(testData.wrongNumber)
                    .submitForm();
        });

        step("Check not registration form", () -> {
            registrationPage.checkNotModalWindow()
                    .checkUserNumberBorderColor();
        });
    }

    @Test
    @DisplayName("Empty number")
    void emptyNumberTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                registrationPage.openPage());

        step("Fill registration form", () -> {
            registrationPage
                    .typeFirstName(testData.firstName)
                    .typeLastName(testData.lastName)
                    .setGender(testData.genter)
                    .typeUserNumber(" ")
                    .submitForm();
        });

        step("Check not registration form", () -> {
            registrationPage.checkNotModalWindow()
                    .checkUserNumberBorderColor();
        });
    }
}
