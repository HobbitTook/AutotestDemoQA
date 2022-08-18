package com.startingharrypotter;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static com.codeborne.selenide.Selenide.*;

public class JunitMenuTestv2 {
    @BeforeAll
    static void configure() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1440";
    }



    @CsvSource(value = {
            "Magical Sweets & Treats",
            "Welcome to Gryffindor",
            "Magical Creature Fact Files",
            "Did You Know: Hogwarts Edition",
            "How to Get to Hogwarts",
            "What is Quidditch?",
    })

    @ParameterizedTest(name = "В Меню после скролла влево есть пункт {0}")
    void liveLibMenuTest(String menu) {
        open("https://www.startingharrypotter.com/explore");
        $(".scrollArrow-woms8P").click();
        $$(".storyteller-wrapper").shouldHave(CollectionCondition.texts(menu));
    }
}
