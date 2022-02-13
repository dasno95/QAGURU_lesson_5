package dasno95.lesson_5.pages;

import com.codeborne.selenide.SelenideElement;
import dasno95.lesson_5.pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderFemaleInput = $("[for='gender-radio-2']"),
            userNumberInput = $("#userNumber"),
            subjectInput = $("#subjectsInput"),
            hobbyReadingInput = $("[for='hobbies-checkbox-2']"),
            pictureUpload = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitClick = $("#submit"),
            resultValue = $(".table-responsive");

    public RegistrationPage openPage() {
        open("https://demoqa.com/automation-practice-form");
        return this;
    }

    public RegistrationPage typeFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationPage typeUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationPage typeGender() {
        genderFemaleInput.click();
        return this;
    }

    public RegistrationPage typeUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    public CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage typeSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeHobby() {
        hobbyReadingInput.click();
        return this;
    }

    public RegistrationPage typePicture(String fileName) {
        pictureUpload.uploadFromClasspath(fileName);
        return this;
    }

    public RegistrationPage typeCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage typeState(String value) {
        stateInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage typeCity(String value) {
        cityInput.setValue(value).pressEnter();
        return this;
    }

    public RegistrationPage clickSubmit() {
        submitClick.click();
        return this;
    }

    public RegistrationPage checkResults(String value) {
        resultValue.shouldHave(text(value));
        return this;
    }

}