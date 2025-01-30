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
        $("#userEmail").setValue("PVas@gmail.com");
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
        $("#react-select-3-input").setValue("u").pressEnter();
        $("#react-select-4-input").setValue("m").pressEnter();
        $("#submit").click();
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $("[class=table-responsive]").shouldHave(text("Petya"));
        $(".table-responsive").shouldHave(text("Vasichkin"));
        $(".table-responsive").shouldHave(text("PVas@gmail.com"));
        $(".table-responsive").shouldHave(text("Male"));
        $(".table-responsive").shouldHave(text("1234567890"));
        $(".table-responsive").shouldHave(text("31 May,1999"));
        $(".table-responsive").shouldHave(text("Maths"));
        $(".table-responsive").shouldHave(text("Music"));
        $(".table-responsive").shouldHave(text("12.jpg"));
        $(".table-responsive").shouldHave(text("Lenina street"));
        $(".table-responsive").shouldHave(text("Uttar Pradesh Merrut"));
        $("#closeLargeModal").click();

    }
}
