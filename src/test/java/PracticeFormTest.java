import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Petya");
        $("#lastName").setValue("Vasichkin");
        $("#userEmail").setValue("PVas@gmaol.com");
        $("label[for='gender-radio-1']").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").scrollTo();
        $("option[value='1999']").click();
        $(".react-datepicker__month-select").click();
        $("option[value='4']").click();
        $(".react-datepicker__day.react-datepicker__day--031").click();
        $("#subjectsContainer").click();
        $("#subjectsInput").setValue("m").pressEnter();
        $("label[for='hobbies-checkbox-3']").click();
        $("#uploadPicture").uploadFromClasspath("12.jpg");
        $("#currentAddress").setValue("Lenina street");
        $(".css-1hwfws3").setValue("u").pressEnter();

        $("#").setValue("Another street 1");
        $("#").setValue("Another street 1");
        $("#").setValue("Another street 1");
        $("#").setValue("Another street 1");
        $("#").click();

        $("#output #name").shouldHave(text("Alex"));
        $("#output #email").shouldHave(text("alex@egorov.com"));
        $("#output #currentAddress").shouldHave(text("Some street 1"));
        $("#output #permanentAddress").shouldHave(text("Another street 1"));
    }
}
