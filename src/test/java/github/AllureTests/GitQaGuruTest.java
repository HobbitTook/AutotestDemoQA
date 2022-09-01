package github.AllureTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class GitQaGuruTest {

    @Test
    @Disabled
        public void testIssueSearch () {
            SelenideLogger.addListener("allure", new AllureSelenide());

            open("https://github.com");

            $(".header-search-input").click();
            $(".header-search-input").sendKeys("qa_guru_14_10");
            $(".header-search-input").submit();

            $("a[href*='qa-guru/qa_guru_14_10']").click();
            $("#issues-tab").shouldHave();

        }
    }
