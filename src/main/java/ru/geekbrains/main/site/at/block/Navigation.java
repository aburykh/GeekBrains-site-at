package ru.geekbrains.main.site.at.block;

import io.qameta.allure.Step;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.BasePage;
import ru.geekbrains.main.site.at.CoursePage;
import ru.geekbrains.main.site.at.HomePage;

public class Navigation {

    @FindBy(css = "[class=\"svg-icon icon-logo\"]")
    private WebElement icon;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/courses\"]")
    private WebElement buttonCourses;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/events\"]")
    private WebElement buttonEvents;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/topics\"]")
    private WebElement buttonTopics;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/posts\"]")
    private WebElement buttonPosts;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/tests\"]")
    private WebElement buttonTests;

    @FindBy(css = "[class*=\"main-page-hidden\"] [href=\"/career\"]")
    private WebElement buttonCareer;

    private WebDriver driver;

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка нажатия на кнопку {nameButton}")
    public BasePage clickButton(String nameButton) {
        switch (nameButton) {
            case "Главная": {
                icon.click();
                return PageFactory.initElements(driver, HomePage.class);
            }
            case "Курсы": {
                buttonCourses.click();
                return PageFactory.initElements(driver, CoursePage.class);
            }
            case "Вебинары": {
                buttonEvents.click();
                break;
            }
            case "Форум": {
                buttonTopics.click();
                break;
            }
            case "Блог": {
                buttonPosts.click();
                break;
            }
            case "Тесты": {
                buttonTests.click();
                break;
            }
            case "Карьера": {
                buttonCareer.click();
                break;
            }
            default: {
                throw new NotFoundException("Не найдена кнопка с именем: " + nameButton);
            }
        }

        return PageFactory.initElements(driver, HomePage.class);
    }
}