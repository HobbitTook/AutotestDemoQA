package com.demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.files.DownloadActions.click;


public class formValidation {

    @BeforeAll
    static void configure() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1980";
    }

    @AfterAll
    static void configure1() {

        Configuration.holdBrowserOpen = false;
    }


    @Test
    void firstTest() {
        open("https://demoqa.com/automation-practice-form");
        $("[id=firstName]").setValue("John");
        $("[id=lastName]").setValue("Watson");
        $("[id=userEmail]").setValue("Watson@mail.com");
        $("[for=gender-radio-1").click();
        $("[id=userNumber").setValue("8956325785");
        $("[id=dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1987");
        $(".react-datepicker__month-select").selectOption("July");
        $(".react-datepicker__day--013").click();
        $("[id=subjectsInput]").setValue("History").pressEnter();
        $("[for=hobbies-checkbox-2").click();
        $("[id=uploadPicture]").uploadFile(new File("src/test/resources/photo.jpg"));
        $("[id=currentAddress]").setValue("test");
        $("[id=state]").click();
        $(byText("NCR")).click();
        $("[id=city]").click();
        $(byText("Noida")).click();
        $("[id=submit").click();
        $("[id=example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").shouldHave(text("John Watson"));
        $(".modal-body").shouldHave(text("Watson"));
        $(".modal-body").shouldHave(text("Watson@mail.com"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8956325785"));
        $(".modal-body").shouldHave(text("13 July,1987"));
        $(".modal-body").shouldHave(text("History"));
        $(".modal-body").shouldHave(text("Reading"));
        $(".modal-body").shouldHave(text("photo.jpg"));
        $(".modal-body").shouldHave(text("test"));
        $(".modal-body").shouldHave(text("NCR Noida"));
        $("[id=closeLargeModal]").click();



    }
}
