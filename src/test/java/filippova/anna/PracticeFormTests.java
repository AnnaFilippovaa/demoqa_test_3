package filippova.anna;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import filippova.anna.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Locale;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeFormTests {

    Faker fakerEn = new Faker(new Locale("en"));
    Faker fakerRu = new Faker(new Locale("ru"));
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    String firstName = fakerRu.name().firstName(),
            lastName = fakerRu.name().lastName(),
            email = fakerEn.internet().emailAddress(),
            gender = "Female",
            userNumber = fakerRu.phoneNumber().subscriberNumber(10),
            keyForSubjects = "a",
            subjects = "Arts",
            hobbies = "Music",
            picture = "picture.jpg",
            currentAddress = fakerRu.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            title = "Thanks for submitting the form";

    @BeforeAll
    static void setUp() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setBirthDate("22", "April", "1998")
                .setSubjects(keyForSubjects, subjects)
                .setHobbies(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(currentAddress)
                .setState(state)
                .setCity(city)
                .clickSubmit()
                .checkResultTitle(title)
                .checkResultStudentName("Student Name", firstName, lastName)
                .checkResultStudentEmail("Email", email)
                .checkResultGender("Gender", gender)
                .checkResultMobile("Mobile", userNumber)
                .checkResultDateOfBirth("Date of Birth", "22 April,1998")
                .checkResultSubjects("Subjects", subjects)
                .checkResultHobbies("Hobbies", hobbies)
                .checkResultPicture("Picture", picture)
                .checkResultAddress("Address", currentAddress)
                .checkResultStateAndCity("State and City", state, city)
                .closeResult();

    }
}
