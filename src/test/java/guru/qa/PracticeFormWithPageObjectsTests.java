package guru.qa;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtilsWithFaker;


import static io.qameta.allure.Allure.step;


public class PracticeFormWithPageObjectsTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    RandomUtilsWithFaker rf = new RandomUtilsWithFaker();


    @Tag("homeWork")
    @Test
    void positiveFillPracticeFormTest() {
        step("Открываем страницу формы", () -> {
            registrationPage.openPage()
                    .closeBanner();
        });
        step("Задаем имя: ", () -> {
            registrationPage.setFirstName(rf.firstName);
        });
        step("Задаем фамилию: ", () -> {
            registrationPage.setLastName(rf.lastName);
        });
        step("Задаем электронную почту: ", () -> {
            registrationPage.setEmail(rf.userEmail);
        });
        step("Задаем пол: ", () -> {
            registrationPage.setGender(rf.userGender);
        });
        step("Задаем номер телефона: ", () -> {
            registrationPage.setNumber(rf.userPhone);
        });
        step("Задаем дату рождения: ", () -> {
            registrationPage.setDateOfBirth(rf.day, rf.month, rf.year);
        });
        step("Задаем предмет: ", () -> {
            registrationPage.setSubject(rf.userObject);
        });
        step("Задаем хобби: ", () -> {
            registrationPage.setHobby(rf.userHobbies);
        });
        step("Задаем картинку: ", () -> {
            registrationPage.uploadPicture(rf.userPicture);
        });
        step("Задаем адрес: ", () -> {
            registrationPage.setCurrentAddress(rf.userAddress);
        });
        step("Задаем штат: ", () -> {
            registrationPage.setState(rf.userState);
        });
        step("Задаем город: ", () -> {
            registrationPage.setCity(rf.userCity);
        });
        step("Отправляем форму", () -> {
            registrationPage.clickSubmit();
        });


        step("Ожидаем совпадение с заданными данными", () -> {
            registrationPage.checkResultRegistrationForm("Student Name", rf.firstName + " " + rf.lastName)
                    .checkResultRegistrationForm("Student Email", rf.userEmail)
                    .checkResultRegistrationForm("Gender", rf.userGender)
                    .checkResultRegistrationForm("Mobile", rf.userPhone)
                    .checkResultRegistrationForm("Date of Birth", rf.day + " " + rf.month + "," + rf.year)
                    .checkResultRegistrationForm("Subjects", rf.userObject)
                    .checkResultRegistrationForm("Hobbies", rf.userHobbies)
                    .checkResultRegistrationForm("Picture", rf.userPicture)
                    .checkResultRegistrationForm("Address", rf.userAddress)
                    .checkResultRegistrationForm("State and City", rf.userState + " " + rf.userCity);
        });

    }
}
