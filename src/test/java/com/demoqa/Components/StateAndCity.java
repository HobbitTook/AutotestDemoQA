package com.demoqa.Components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class StateAndCity {

    public StateAndCity setStateAndCity(String state, String city ) {
        $("[id=state]").click();
        $(byText(state)).click();
        $("[id=city]").click();
        $(byText(city)).click();

        return this;
    }
}
