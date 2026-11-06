package pages;

import com.codeborne.selenide.SelenideElement;

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
    public SimpleFormPage openPage() {
        open("https://qa-guru.github.io/one-page-form/text-box.html");

        return this;
    }

    public SimpleFormPage typeUserName(String value) {
        userNameInput.setValue(value);

        return this;
    }

    public SimpleFormPage typeUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public SimpleFormPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormPage typePermanentAddress(String value) {
        permanentAddressInput.setValue(value);

        return this;
    }

    public SimpleFormPage submit() {
        submitButton.click();

        return this;
    }

    public SimpleFormPage checkField(String key, String value) {
        $("p#" + key).shouldHave(text(value));

        return this;
    }

    public SimpleFormPage checkNotVisibleElement(String value) {
        $("p#" + value).shouldNotBe(visible);
        return this;
    }

}
