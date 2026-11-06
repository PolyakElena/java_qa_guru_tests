package tests;

import org.junit.jupiter.api.Test;

import static tests.TestData.*;

public class RegistrationFormTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(userEmail)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .setDateOfBirth(day, month, year)
                .typeSubjects(subjects)
                .setHobby(hobby)
                .uploadPicture(picture)
                .typeCurrentAddress(currentAddress)
                .setStateAndCity(shtat, city)
                .submitForm()

                .checkModalWindow()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", genter)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", data)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", shtat + " " + city)
                .closeModalForm();
    }

    @Test
    void successFullCompletedWithOnlyRequiredFieldTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkModalWindow()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", genter)
                .checkResult("Mobile", userNumber)
                .closeModalForm();
    }

    @Test
    void shortEmailTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(shortEmail)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkNotModalWindow()
                .checkUserEmailBorderColor();
    }

    @Test
    void wrongEmailTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(wrongEmail)
                .setGender(genter)
                .typeUserNumber(userNumber)
                .submitForm()

                .checkNotModalWindow()
                .checkUserEmailBorderColor();
    }

    @Test
    void wrongNumberTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genter)
                .typeUserNumber(wrongNumber)
                .submitForm()

                .checkNotModalWindow()
                .checkUserNumberBorderColor();
    }

    @Test
    void emptyNumberTest() {
        registrationPage.openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .setGender(genter)
                .typeUserNumber(" ")
                .submitForm()

                .checkNotModalWindow()
                .checkUserNumberBorderColor();
    }
}
