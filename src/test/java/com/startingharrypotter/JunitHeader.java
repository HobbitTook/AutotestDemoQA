package com.startingharrypotter;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;



public class JunitHeader {

    @EnumSource(Lang.class)
    @ParameterizedTest

    void liveLibGenresTest(Lang menu) {
        open("https://www.startingharrypotter.com/explore");
        $$(".main-header-menu").shouldHave(CollectionCondition.texts(menu.name()));
    }
}

