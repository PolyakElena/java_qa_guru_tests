package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {
    // Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddress = $("#currentAddress");
    private SelenideElement permanentAddress = $("#permanentAddress");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement outputResults = $("#output");

    // Actions
    @Step("Open registration page /text-box")
    public TextBoxPage openPage() {
        open("/text-box");

        return this;
    }

    @Step("Type user name \"{value}\"")
    public TextBoxPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    @Step("Type user Email \"{value}\"")
    public TextBoxPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Type current address \"{value}\"")
    public TextBoxPage typeCurrentAddress(String value) {
        currentAddress.setValue(value);

        return this;
    }

    @Step("Type permanent address \"{value}\"")
    public TextBoxPage typePermanentAddress(String value) {
        permanentAddress.setValue(value);

        return this;
    }

    @Step("submit form")
    public TextBoxPage submitForm() {
        submitButton.click();

        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public TextBoxPage checkField(String key, String value) {
        outputResults.$(byId(key)).shouldHave(text(value));

        return this;
    }
}
