package github2;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.commands.ShouldHave;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PricingTest {

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
    @Disabled
    void firstTest() {
        //открыть страницу github.com
        open("https://github.com/");

        //Навести курсор мышки на пункт Pricing
        $(".HeaderMenu--logged-out").$(byText("Pricing"))
                .hover();
        //Перейти в разел Compare plans"
        $("ul.list-style-none").$(byText("Compare plans")).pressEnter();

        //Проверить, что загрузилась нужная страница
        $(".application-main").shouldHave(text("Choose the plan that’s right for you.")).scrollTo();

    }
}