package ru.SafonovILL;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {


    @Test
    public void testIssueSearch() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("Safonov-qa/HW_QA_GURU/");
        $(".header-search-input").submit();

        $(linkText("Safonov-qa/HW_QA_GURU")).click();
        $("#issues-tab").click();
        $(withText("Allure Test")).shouldHave(Condition.exist);


    }
}
