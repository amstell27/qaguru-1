package guru.qa.tests;


import com.codeborne.selenide.selector.ByText;
import guru.qa.pages.RegistrationPage;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PracticeTestFormWithTestBase extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    String firstName = "Alex";
    String lastName = " Alexeev";


    @Test
    void automationPracticeTests() {

        registrationPage.openPage();
        registrationPage.setFirstName(firstName).setLastName(lastName).setBirthDate("26", "June", "1992");
        $("#lastName").setValue("Alexeev");
        $("#userEmail").setValue("emain@email.com");

        $("#genterWrapper").$(byText("Male")).click();

        $("#userNumber").setValue("8002000500");

        registrationPage.setBirthDate("26", "June", "1992");


        $("#subjectsInput").setValue("Chemistry").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();

        $("#currentAddress").setValue("Current Address");

        $("#state").click();
        $(new ByText("NCR")).click();

        $("#city").click();
        $(new ByText("Delhi")).click();

        $("#submit").click();

        $("[class='modal-header']").shouldBe(text("Thanks for submitting the form"));

        //       $$(".table-responsive tr").filterBy(text("Student Name")).shouldBe(texts("Alex Alexeev"));
        //       $$(".table-responsive tr").filterBy(text("Student Email")).shouldBe(texts("emain@email.com"));
        //       $$(".table-responsive tr").filterBy(text("Gender")).shouldBe(texts("Male"));
        $$(".table-responsive tr").filterBy(text("Mobile")).shouldBe(texts("8002000500"));
        $$(".table-responsive tr").filterBy(text("Date of Birth")).shouldBe(texts("25 June,1992"));
        $$(".table-responsive tr").filterBy(text("Subjects")).shouldBe(texts("Chemistry"));
        $$(".table-responsive tr").filterBy(text("Hobbies")).shouldBe(texts("Sports"));

        $$(".table-responsive tr").filterBy(text("Address")).shouldBe(texts("Current Address"));
        $$(".table-responsive tr").filterBy(text("State and City")).shouldBe(texts("NCR Delhi"));

        registrationPage.checkForm("Student Name", firstName + lastName).checkForm("Gender", "Male").checkForm("Student Email", "emain@email.com");

    }
}
