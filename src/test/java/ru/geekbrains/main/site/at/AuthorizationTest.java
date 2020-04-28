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
@Feature(value = "Проверка авторизации")
@Story(value = "Авторизация с валидными данными")
public class AuthorizationTest extends BaseTest {

    @DisplayName("Вход с валидными логином и паролем")
    @Test
    @Issue(value = "https://google.com")
    @TmsLink(value = "https://ya.ru")
    @Description(value = "Тест-кейс позволяет проверить авторизацию на портале с валидными данными с последующей проверкой загрузки страницы после авторизации")
    void checkSignInValidLogin() {
        String login = "hao17583@bcaoo.com";
        String password = "hao17583";

        driver.get("https://geekbrains.ru/login");
        PageFactory.initElements(driver, AuthorizationPage.class)
                .authorization(login, password)
                .checkNamePage("Главная");
    }
}