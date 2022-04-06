package filippova.anna;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    @BeforeAll
    static void setUp() {
        //Configuration.holdBrowserOpen = true;
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
        String picture = "picture.jpg";
        String currentAddress = "Some street 1";
        String state = "Haryana";
        String city = "Karnal";

        open("/automation-practice-form");

        $("[id=firstName]").setValue(firstName);
        $("[id=lastName]").setValue(lastName);
        $("[id=userEmail]").setValue(email);
        $("[id=genterWrapper]").$(byText(gender)).click();
        $("[id=userNumber]").setValue(mobileNumber);
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("April");
        $(".react-datepicker__year-select").selectOption("1998");
        $("[aria-label='Choose Wednesday, April 22nd, 1998']").click();
        $("#subjectsInput").sendKeys("a");
        $("#subjectsWrapper").$(byText(subjects)).click();
        $("[id=hobbiesWrapper]").$(byText(hobbies)).click();
        $("[id=uploadPicture]").uploadFromClasspath(picture);
        $("[id=currentAddress]").setValue(currentAddress);
        $("[id=state]").click();
        $("[id=stateCity-wrapper]").$(byText(state)).click();
        $("[id=city]").click();
        $("[id=stateCity-wrapper]").$(byText(city)).click();
        $("[id=submit]").click();

        //Asserts
        $("[id=example-modal-sizes-title-lg]").shouldHave(Condition.text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(Condition.text(firstName + " " + lastName),
                Condition.text(email),
                Condition.text(gender),
                Condition.text(mobileNumber),
                Condition.text("22 April,1998"),
                Condition.text(subjects),
                Condition.text(hobbies),
                Condition.text(picture),
                Condition.text(currentAddress),
                Condition.text(state + " " + city)
        );
        $("[id=closeLargeModal]").click();
    }

}
