package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleFormPage {

    // Elements
    private SelenideElement userNameInput = $("#userName");
    private SelenideElement userEmailInput = $("#userEmail");
    private SelenideElement currentAddressInput = $("textarea#currentAddress");
    private SelenideElement permanentAddressInput = $("textarea#permanentAddress");
    private SelenideElement submitButton = $("#submit");


    // Actions
    @Step("Open registration page /one-page-form/text-box.html")
    public SimpleFormPage openPage() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");

        return this;
    }

    @Step("Type user name \"{value}\"")
    public SimpleFormPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    @Step("Type user Email \"{value}\"")
    public SimpleFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    @Step("Type current address \"{value}\"")
    public SimpleFormPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    @Step("Type permanent address \"{value}\"")
    public SimpleFormPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    @Step("submit form")
    public SimpleFormPage submit() {
        submitButton.click();

        return this;
    }

    @Step("Check that field \"{key}\" has result \"{value}\"")
    public SimpleFormPage checkField(String key, String value) {
        $("p#" + key).shouldHave(text(value));

        return this;
    }

    @Step("check modal window not visible")
    public SimpleFormPage checkNotVisibleElement(String value) {
        $("p#" + value).shouldNotBe(visible);
        return this;
    }

}
