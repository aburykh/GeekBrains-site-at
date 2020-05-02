package ru.geekbrains.main.site.at.page.content;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.geekbrains.main.site.at.block.CourseHeader;
import ru.geekbrains.main.site.at.page.content.base.BasePage;

import java.util.List;

public class CoursePage extends BasePage {


    @FindBy(xpath = "//form/ul//label")
    private List<WebElement> filterList;

    @FindBy(xpath = "//a/div/div/span")
    private List<WebElement> courseList;

    public CoursePage(WebDriver driver) {
        super(driver);
        this.courseHeader = PageFactory.initElements(driver, CourseHeader.class);
    }

    private CourseHeader courseHeader;


    @Step("Установка чек-боксов \"Бесплатные\" и \"Тестирование\"")
    public CoursePage configFilter(String... args) {
        for (String test : args) {
            WebElement element = findElement(filterList, test);
            element.click();
        }
        return this;
    }

    @Step("Проверка отображения в результатах курсов \"Тестирование ПО. Уровень 1\" и \"Тестирование ПО. Уровень 2\"")
    public CoursePage checkingDisplayedCourses(String... args) {
        for (String test : args) {
            WebElement element = findElement(courseList, test);
            wait10second.until(ExpectedConditions.visibilityOf(element));
        }
        return this;
    }


    public CourseHeader getCourseHeader() {
        return courseHeader;
    }

    @Override
    public CoursePage openUrl() {
        driver.get("https://geekbrains.ru/courses");
        return this;
    }

}