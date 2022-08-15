package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;

import static java.lang.String.format;

public class TestData {

    @BeforeAll
    static void configure() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1440";
    }

    Faker faker = new Faker();

    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmail = faker.internet().emailAddress();
    public String gender = "Male";
    public String userNumber = faker.phoneNumber().subscriberNumber(10);
    public String day = faker.number().numberBetween(1, 30) + "";
    public String month = "July";
    public String year = faker.number().numberBetween(1980, 2000) + "";
    public String subject = "History";
    public String hobbies = "Reading";
    public String picture = "src/test/resources/photo.jpg";
    public String currentAddress = faker.address().fullAddress();
    public String state = "NCR";
    public String city = "Noida";
    public String fullName = format("%s %s", firstName, lastName);
    public String getPicture = "photo.jpg";
    public String dateOfBirth = format("%s %s,%s", day, month, year);
    public String stateAndCity = format("%s %s", state, city);

}
