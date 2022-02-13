package dasno95.lesson_5.tests;

import com.codeborne.selenide.Configuration;
import dasno95.lesson_5.pages.RegistrationPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class PracticeFormTestWithPageObjects {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationPage
                .openPage()
                .typeFirstName("Daria")
                .typeLastName("Koroleva")
                .typeUserEmail("daria@k.com")
                .typeGender()
                .typeUserNumber("1234567890")
                .setBirthDate("14", "November", "1995")
                .typeSubject("Maths")
                .typeHobby()
                .typePicture("DSCF0008.JPG")
                .typeCurrentAddress("Street, 1")
                .typeState("NCR")
                .typeCity("Noida")
                .clickSubmit();

        // check result form
        registrationPage
                .checkResults("Daria Koroleva")
                .checkResults("daria@k.com")
                .checkResults("Female")
                .checkResults("1234567890")
                .checkResults("14 November,1995")
                .checkResults("Maths")
                .checkResults("Reading")
                .checkResults("DSCF0008.JPG")
                .checkResults("Street, 1")
                .checkResults("NCR Noida");

    }
}