package guru.qa.pages;

import com.codeborne.selenide.SelenideElement;


import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    //locators
    //$("#firstName")
    private SelenideElement
            headerTitle = $(".practice-form-wrapper"),
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            resultsTable = $(".table-responsive");

    //actions
    //setValue("Alex");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Students Registration Form"));

        return this;
    }

    public RegistrationPage setFirstName(String firstName) {

        firstNameInput.setValue(firstName);
        return this;

    }

    public RegistrationPage setLastName(String lastName) {

        lastNameInput.setValue(lastName);
        return this;
    }

    public RegistrationPage checkForm(String fieldName, String value) {
        resultsTable.$(byText(fieldName))
                .parent().shouldHave(text(value));

        return this;
    }

}
