package filippova.anna.tests;

import com.github.javafaker.Faker;
import filippova.anna.pages.RegistrationFormPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.file.Paths;
import java.util.Locale;

import static io.qameta.allure.Allure.step;

public class PracticeFormTests extends TestBase {

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
            picturePath = "img/picture.jpg",
            pictureFileName = Paths.get(picturePath).getFileName().toString(),
            currentAddress = fakerRu.address().fullAddress(),
            state = "Haryana",
            city = "Karnal",
            title = "Thanks for submitting the form";

    @Test
    @DisplayName("Successful fill registration test")
    void fillFormTest() {
        step("Open registration form", () -> {
            registrationFormPage.openPage();
        });

        step("Fill registration form", () -> {
            registrationFormPage.setFirstName(firstName)
                    .setLastName(lastName)
                    .setEmail(email)
                    .setGender(gender)
                    .setUserNumber(userNumber)
                    .setBirthDate("22", "April", "1998")
                    .setSubjects(keyForSubjects, subjects)
                    .setHobbies(hobbies)
                    .uploadPicture(picturePath)
                    .setCurrentAddress(currentAddress)
                    .setState(state)
                    .setCity(city)
                    .clickSubmit();
        });

        step("Verify form data", () -> {
            registrationFormPage.checkResultTitle(title)
                    .checkResultStudentName("Student Name", firstName, lastName)
                    .checkResultStudentEmail("Student Email", email)
                    .checkResultGender("Gender", gender)
                    .checkResultMobile("Mobile", userNumber)
                    .checkResultDateOfBirth("Date of Birth", "22 April,1998")
                    .checkResultSubjects("Subjects", subjects)
                    .checkResultHobbies("Hobbies", hobbies)
                    .checkResultPicture("Picture", pictureFileName)
                    .checkResultAddress("Address", currentAddress)
                    .checkResultStateAndCity("State and City", state, city)
                    .closeResult();
        });
    }
}
