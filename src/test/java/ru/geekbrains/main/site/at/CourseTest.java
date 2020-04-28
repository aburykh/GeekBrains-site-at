package ru.geekbrains.main.site.at;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;


@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка авторизации")
@Feature(value = "Проверка работы фильтра на странице \"Курсы\"")
@Story(value = "Проверка фильтра на странице \"Курсы\" после успешной авторизации")
public class CourseTest extends BaseTest {

    @DisplayName("Проверка фильтра на странице \"Курсы\" после авторизации")
    @Test
    @Issue(value = "https://google.com")
    @TmsLink(value = "https://ya.ru")
    @Description(value = "Тест-кейс позволяет проверить работу фильтрации на странице \"Курсы\" после авторизации на портале с валидными данными")
    void checkSignInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");

        ((CoursePage)
                PageFactory.initElements(driver, AuthorizationPage.class)
                        .authorization(login, password)
                        .checkNamePage("Главная")
                        .getNavigation()
                        .clickButton("Курсы")
        )
                .getCourseHeader().clickButton("Курсы")
                .configFilter("Бесплатные", "Тестирование")
                .checkingDisplayedCourses("Тестирование ПО. Уровень 1", "Тестирование ПО. Уровень 2");

    }
}