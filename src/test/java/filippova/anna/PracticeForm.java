package filippova.anna;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm {

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        String firstName = "Anna";
        String lastName = "Filippova";
        String email = "anna@filippova.com";
        String gender = "Female";
        String mobileNumber = "9998887766";
        String subjects = "Arts";
        String hobbies = "Music";
        String currentAddress = "Some street 1";
        String permanentAddress = "Another street 2";

        open("/automation-practice-form");

        //Asserts
        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(mobileNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1998");
        $("[aria-label='Choose Wednesday, April 22nd, 1998']").click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("[id=hobbiesWrapper]").$(byText(hobbies)).click();
        //$("[id=uploadPicture]").click();

    }

}
