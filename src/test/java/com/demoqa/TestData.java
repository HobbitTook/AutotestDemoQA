package com.demoqa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static java.lang.String.format;

public class TestData {
    @BeforeAll
    static void configure() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = System.getProperty("browser_name", "chrome");
        Configuration.browserVersion = System.getProperty("browser_version", "105.0");
        Configuration.browserSize = System.getProperty("browser_size", "1920x1080");

        if (System.getProperty("selenide.remote") != null) {
            Configuration.remote = System.getProperty("selenide.remote");
        }

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

    @AfterEach
    void addAttachments() {
        AllureAttach.screenshotAs("Screenshot");
        AllureAttach.pageSource();
        AllureAttach.browserConsoleLogs();
        AllureAttach.addVideo();
    }
}
