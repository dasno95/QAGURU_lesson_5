package dasno95.lesson_5.tests;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import dasno95.lesson_5.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PracticeFormTestWithFaker {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String uMail = faker.internet().emailAddress();
    String phoneNumber = faker.phoneNumber().subscriberNumber(10);
    String address = faker.address().fullAddress();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .typeFirstName(firstName)
                .typeLastName(lastName)
                .typeUserEmail(uMail)
                .typeGender()
                .typeUserNumber(phoneNumber)
                .setBirthDate("14", "November", "1995")
                .typeSubject("Maths")
                .typeHobby()
                .typePicture("DSCF0008.JPG")
                .typeCurrentAddress(address)
                .typeState("NCR")
                .typeCity("Noida")
                .clickSubmit();

        // check result form
        registrationPage
                .checkResults(firstName)
                .checkResults(lastName)
                .checkResults(uMail)
                .checkResults("Female")
                .checkResults(phoneNumber)
                .checkResults("14 November,1995")
                .checkResults("Maths")
                .checkResults("Reading")
                .checkResults("DSCF0008.JPG")
                .checkResults(address)
                .checkResults("NCR Noida");

    }
}
