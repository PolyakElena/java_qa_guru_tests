package tests;

import org.junit.jupiter.api.Test;

public class TextBoxTests extends TestBase {


    @Test
    void successfulFillFormTest() {
        TestData testData = new TestData();

        textBoxPage.openPage()
                .typeUserName(testData.firstName + " " + testData.lastName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.currentAddress)
                .submitForm()

                .checkField("name", testData.firstName + " " + testData.lastName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.currentAddress);
    }
}
