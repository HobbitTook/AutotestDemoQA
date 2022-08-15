package com.demoqa;


import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.demoqa.Components.CalendarComponent;
import com.demoqa.Components.ResultsModal;
import com.demoqa.Components.StateAndCity;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {


    private CalendarComponent calendarComponent = new CalendarComponent();
    private ResultsModal resultsModal = new ResultsModal();
    private StateAndCity stateAndCity = new StateAndCity();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail"),

    subjectInput = $("#subjectsInput"),

    adressInput = $("#currentAddress");


    //Открыть сайт
    public RegistrationFormPage openPage() {
        open("https://demoqa.com/automation-practice-form");

        return this;
    }

    //Ввести имя
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    //Ввести фамилию
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    //Ввести почту
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    //Ввести пол
    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    //Ввести номер телефона
    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    //Ввести дату рождения
    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        calendarComponent.setDate(day, month, year);
        return this;
    }

    //Ввести предмет
    public RegistrationFormPage setSubject(String value) {
        subjectInput.setValue(value).pressEnter();
        return this;
    }

    //Ввести хобби
    public RegistrationFormPage setHobbies(String value) {
        $("#hobbiesWrapper").$(byText(value)).click();

        return this;
    }

    //Загрузить фото
    public RegistrationFormPage setPicture(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    //Ввести адрес
    public RegistrationFormPage setAdress(String value) {
        adressInput.setValue(value);

        return this;
    }

    //Выбрать город и штат
    public RegistrationFormPage setStateAndCity(String state, String city) {
        stateAndCity.setStateAndCity(state, city);

        return this;
    }

    //Нажать кнопку Submit
    public RegistrationFormPage setSubmit() {
        $("#submit").click();

        return this;
    }

    //Проверить модальное окно
    public RegistrationFormPage checkResultsTableVisible() {
        resultsModal.checkVisible();

        return this;
    }

    public RegistrationFormPage checkResult(String key, String value) {
        resultsModal.checkResult(key, value);

        return this;
    }
}


