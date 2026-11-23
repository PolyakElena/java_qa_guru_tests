package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TextBoxTests extends TestBase {


    @Test
    @DisplayName("Successful text box form")
    void successfulFillFormTest() {
        TestData testData = new TestData();

        step("Open registration page", () ->
                textBoxPage.openPage());

        step("Fill registration form", () -> {
            textBoxPage.typeUserName(testData.firstName + " " + testData.lastName)
                    .typeUserEmail(testData.userEmail)
                    .typeCurrentAddress(testData.currentAddress)
                    .typePermanentAddress(testData.currentAddress)
                    .submitForm();
        });

        step("Check text box form results data", () -> {
            textBoxPage.checkField("name", testData.firstName + " " + testData.lastName)
                    .checkField("email", testData.userEmail)
                    .checkField("currentAddress", testData.currentAddress)
                    .checkField("permanentAddress", testData.currentAddress);
        });
    }
}
