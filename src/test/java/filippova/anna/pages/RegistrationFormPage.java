package filippova.anna.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import filippova.anna.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    CalendarComponent calendar = new CalendarComponent();

    //locators
    SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            dateOfBirthInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            subjectsWrapper = $("#subjectsWrapper"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            state = $("#state"),
            city = $("#city"),
            stateCityWrapper = $("#stateCity-wrapper"),
            submitButton = $("#submit"),
            resultTitle = $("#example-modal-sizes-title-lg"),
            tableResponsive = $(".table-responsive"),
            closeResultButton = $("#closeLargeModal");

    //actions
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(Condition.text("Student Registration Form"));

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        dateOfBirthInput.click();
        calendar.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubjects(String key, String value) {
        subjectsInput.sendKeys(key);
        subjectsWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage uploadPicture(String value) {
        uploadPicture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationFormPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setState(String value) {
        state.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setCity(String value) {
        city.click();
        stateCityWrapper.$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage clickSubmit() {
        submitButton.click();

        return this;
    }

    //asserts
    public RegistrationFormPage checkResultTitle(String value) {
        resultTitle.shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultStudentName(String key, String value1, String value2) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value1 + " " + value2));

        return this;
    }

    public RegistrationFormPage checkResultStudentEmail(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultGender(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultMobile(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultDateOfBirth(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultSubjects(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultHobbies(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultPicture(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultAddress(String key, String value) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value));

        return this;
    }

    public RegistrationFormPage checkResultStateAndCity(String key, String value1, String value2) {
        tableResponsive.$(byText(key))
                .parent().shouldHave(text(value1 + " " + value2));

        return this;
    }

    public RegistrationFormPage closeResult() {
        closeResultButton.click();

        return this;
    }

}
