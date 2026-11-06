package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.SimpleFormPage;

import static tests.TestData.*;

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
        simpleFormPage.openPage()
                .typeUserName(firstName)
                .typeUserEmail(userEmail)
                .typeCurrentAddress(currentAddress)
                .typePermanentAddress(currentAddress)
                .submit()

                .checkField("name", firstName)
                .checkField("email", userEmail)
                .checkField("currentAddress", currentAddress)
                .checkField("permanentAddress", currentAddress);
    }

    @Test
    public void negativeSimpleFormTest() {
        simpleFormPage.openPage()
                .typeUserName(firstName)
                .typeUserEmail(wrongEmail)
                .submit()

                .checkNotVisibleElement("name")
                .checkNotVisibleElement("email");
    }
}
