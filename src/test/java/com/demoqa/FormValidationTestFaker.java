package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class FormValidationTestFaker extends TestData {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();



    @Test
    void firstTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(userEmail)
                .setGender(gender)
                .setNumber(userNumber)
                .setBirthDate(day, month, year)
                .setSubject(subject)
                .setHobbies(hobbies)
                .setPicture(picture)
                .setAdress(currentAddress)
                .setStateAndCity(state, city)
                .setSubmit();


        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", userEmail)
                .checkResult("Gender", gender)
                .checkResult("Mobile", userNumber)
                .checkResult("Date of Birth", dateOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", getPicture)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", stateAndCity);


    }
}
