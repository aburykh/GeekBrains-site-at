package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.block.CourseHeader;

public class CoursePage extends BasePage {

    public CoursePage(WebDriver driver) {
        super(driver);
        this.courseHeader = PageFactory.initElements(driver, CourseHeader.class);
    }

    private CourseHeader courseHeader;

    @Step("Установка чек-боксов \"Бесплатные\" и \"Тестирование\"")
    public CoursePage configFilter(String... args) {
        for (String checkBox : args) {
            driver.findElement(By.xpath("//form/ul//label[text()='" + checkBox + "']"))
                    .click();
        }
        return this;
    }

    @Step("Проверка отображения в результатах курсов \"Тестирование ПО. Уровень 1\" и \"Тестирование ПО. Уровень 2\"")
    public CoursePage checkingDisplayedCourses(String... args) {
        for (String searchResult : args) {
            driver.findElement(By.xpath("//a/div/div/span[text()='" + searchResult + "']"));
        }
        return this;
    }

    public CourseHeader getCourseHeader() {
        return courseHeader;
    }
}