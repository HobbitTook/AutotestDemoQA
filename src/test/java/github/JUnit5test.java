package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class JUnit5test {

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

        //ввести в поле поиска Selenide и нажать Enter
        $("[name=q]").setValue("Selenide").pressEnter();

        //выбрать первый лин на стр с результатами поиска
        $$("ul.repo-list li").first().$("a").click();

        //перейти на вкладаку Wiki
        $("#wiki-tab").click();

        //Открыть весь список страниц справа
        $(byText("Show 2 more pages…")).click();


        //Находим на стр пункт SoftAssertions
        $("#wiki-pages-box").shouldHave(text("SoftAssertions"));

        //Переходим в раздел SoftAssertions
        $(byText("SoftAssertions")).click();

        //Ищем код для JUnit5
        $("#repo-content-pjax-container").shouldHave(text("JUnit5"));


    }
}