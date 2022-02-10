package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void successTest(){

        open("/text-box");

        $("#userName").setValue("Alex");
        $("#userEmail").setValue("emain@email.com");
        $("#currentAddress").setValue("Some Address");
        $("#permanentAddress").setValue("Another Address");
        $("#submit").click();

//        $("#output").shouldBe(visible);
//        $("#output").shouldHave(text("Alex"), text("emain@email.com"), text("Some Address"), text("Another Address"));
        $("#name").shouldHave(text("Alex"));
        $("#email").shouldHave(text("emain@email.com"));
//        $("#currentAddress").shouldHave(text("Some Address"));
        $("#currentAddress", 1).shouldHave(text("Some Address"));
        $("#output #permanentAddress").shouldHave(text("Another Address"));

    }
}
