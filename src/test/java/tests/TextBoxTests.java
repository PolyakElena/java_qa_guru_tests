package tests;

import org.junit.jupiter.api.Test;

import static tests.TestData.*;

public class TextBoxTests extends TestBase {

    @Test
    void successfulFillFormTest() {
        textBoxPage.openPage()
                .typeUserName(firstName + " " + lastName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(currentAddress)
                .submitForm()

                .checkField("name", firstName + " " + lastName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", currentAddress);
    }
}
