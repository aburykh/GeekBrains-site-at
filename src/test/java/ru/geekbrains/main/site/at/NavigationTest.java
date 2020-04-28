package ru.geekbrains.main.site.at;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.base.BaseTest;

import java.util.stream.Stream;


@DisplayName("Тесты навигации по сайту GeekBrains")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Execution(value = ExecutionMode.SAME_THREAD)
@Feature(value = "Проверка страниц")
@Story(value = "Проверка навигации")

public class NavigationTest extends BaseTest {


    static Stream<String> stringProvider() {
        return Stream.of("Курсы", "Вебинары", "Форум", "Блог", "Тесты", "Карьера");
    }

    @DisplayName("Нажатие в навигации")
    @Description(value = "Тест-кейс позволяет проверить переход по страницам, используя панель навигации на портале, с последующей проверкой загрузки элементов в header и footer на каждой странице")
    @ParameterizedTest(name = "{index} ==> Проверка перехода на страницу \"{0}\"...")
    @MethodSource("stringProvider")
    void checkNavigation(String namePage) throws InterruptedException {
        driver.get("https://geekbrains.ru/career");

        PageFactory.initElements(driver, HomePage.class)
                .getNavigation().clickButton(namePage)
                .checkNamePage(namePage);

        PageFactory.initElements(driver, Header.class)
                .checkElementsInHeader();

        PageFactory.initElements(driver, Footer.class)
                .checkElementsInFooter();

    }
}