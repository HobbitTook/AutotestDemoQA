package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class FormValidationTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1980";
    }

    @Test
    @Disabled
    void firstTest() {
        registrationFormPage.openPage()
                .setFirstName("John")
                .setLastName("Watson")
                .setEmail("Watson@mail.com")
                .setGender("Male")
                .setNumber("8956325785")
                .setBirthDate("13", "July", "1987")
                .setSubject("History")
                .setHobbies("Reading")
                .setPicture("src/test/resources/photo.jpg")
                .setAdress("test")
                .setStateAndCity("NCR", "Noida")
                .setSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", "John Watson")
                .checkResult("Student Email", "Watson@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8956325785")
                .checkResult("Date of Birth", "13 July,1987")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "photo.jpg")
                .checkResult("Address", "test")
                .checkResult("State and City", "NCR Noida");


    }
}
