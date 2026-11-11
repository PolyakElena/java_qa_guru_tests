package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;


public class SimpleFormTest {
    SimpleFormPage simpleFormPage = new SimpleFormPage();

    @BeforeAll
    static void setupEnv() {
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    public void successfulSimpleFormTest() {
        TestData testData = new TestData();

        simpleFormPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.userEmail)
                .typeCurrentAddress(testData.currentAddress)
                .typePermanentAddress(testData.currentAddress)
                .submit()

                .checkField("name", testData.firstName)
                .checkField("email", testData.userEmail)
                .checkField("currentAddress", testData.currentAddress)
                .checkField("permanentAddress", testData.currentAddress);
    }

    @Test
    public void negativeSimpleFormTest() {
        TestData testData = new TestData();

        simpleFormPage.openPage()
                .typeUserName(testData.firstName)
                .typeUserEmail(testData.wrongEmail)
                .submit()

                .checkNotVisibleElement("name")
                .checkNotVisibleElement("email");
    }
}
