package com.startingharrypotter;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import static com.codeborne.selenide.Selenide.*;


import java.util.stream.Stream;

public class JunitMenuTestv1 {

    @BeforeAll
    static void configure() {

        Configuration.browser = "chrome";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1440";
    }
    @Test
    @Disabled
    static Stream<Arguments> dataProviderForLiveLibMenuTest() {
        return Stream.of(
                Arguments.of("Magical Sweets & Treats"),
                Arguments.of("Welcome to Gryffindor"),
                Arguments.of("Magical Creature Fact Files"),
                Arguments.of("Did You Know: Hogwarts Edition"),
                Arguments.of("How to Get to Hogwarts"),
                Arguments.of("What is Quidditch?")
        );
    }


    @MethodSource("dataProviderForLiveLibMenuTest")
    @ParameterizedTest(name = "В Меню после скролла влево есть пункт {0}")
    void liveLibMenuTest(String menu) {
        open("https://www.startingharrypotter.com/explore");
        $(".scrollArrow-woms8P").click();
        $$(".storyteller-wrapper").shouldHave(CollectionCondition.texts(menu));
    }
}
