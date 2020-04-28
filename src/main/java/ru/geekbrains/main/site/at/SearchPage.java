package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchPage {

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver driver;

    @FindBy(css = "[id=\"top-menu\"] [class=\"show-search-form\"] svg")
    private WebElement buttonSearch;

    @FindBy(css = "input[class=\"search-panel__search-field\"]")
    private WebElement inputSearch;


    @FindBy(xpath = "//header/h2[text()='Профессии']")
    private WebElement textProfession;

    @FindBy(xpath = "//header/h2[text()='Курсы']")
    private WebElement textCourses;

    @FindBy(xpath = "//header/h2[text()='Вебинары']")
    private WebElement textWebinars;

    @FindBy(xpath = "//header/h2[text()='Блоги']")
    private WebElement textBlogs;

    @FindBy(xpath = "//header/h2[text()='Форум']")
    private WebElement textForum;

    @FindBy(xpath = "//header/h2[text()='Тесты']")
    private WebElement textTests;

    @FindBy(xpath = "//header/h2[text()='Проекты и компании']")
    private WebElement textProjectsAndCompanies;


    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"professions\"] span")
    private WebElement countProfession;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"courses\"] span")
    private WebElement countCourses;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"webinars\"] span")
    private WebElement countWebinars;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"blogs\"] span")
    private WebElement countBlogs;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"forums\"] span")
    private WebElement countForums;

    @FindBy(css = "[class=\"search-page-tabs\"] [data-tab=\"tests\"] span")
    private WebElement countTests;

    @FindBy(css = "[class=\"company-item__pic\"] [src*=\"63268ac.png\"]")
    private WebElement logoGB;

    @FindBy(css = "h3 [href=\"/career/682\"]")
    private WebElement textGB;


    @Step("Проверка нажатия на иконку поиска")
    public SearchPage clickSearch() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.elementToBeClickable(buttonSearch));
        buttonSearch.click();
        return PageFactory.initElements(driver, SearchPage.class);
    }

    @Step("Ввод в строку поиска ключевого слова \"java\"")
    public SearchPage inputSearch() {
        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");
        return PageFactory.initElements(driver, SearchPage.class);
    }

    @Step("Проверка отображения блока \"Профессии\" и проверка количественного показателя (>= 2)")
    public SearchPage checkProfession() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textProfession, "Профессии"));
        String textBlock = textProfession.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Профессии"));
        assertThat(textBlock, allOf(equalToIgnoringCase("профессии"), containsString("Про")));

        String countInBlock = countProfession.getText();
        int countOfProfessions = Integer.parseInt(countInBlock.trim());
        System.out.println("countOfProfessions = " + countOfProfessions);
        assertThat(countOfProfessions, greaterThanOrEqualTo(2));
        return this;
    }

    @Step("Проверка отображения блока \"Курсы\" и проверка количественного показателя (> 15)")
    public SearchPage checkCourses() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textCourses, "Курсы"));
        String textBlock = textCourses.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Курсы"));
        assertThat(textBlock, allOf(equalToIgnoringCase("курсы"), containsString("ур")));

        String coursesActual = countCourses.getText();
        int countOfCourses = Integer.parseInt(coursesActual.trim());
        System.out.println("countOfCourses = " + countOfCourses);
        assertThat(countOfCourses, greaterThan(15));
        return this;
    }

    @Step("Проверка отображения блока \"Вебинары\" и проверка количественного показателя (> 180 && < 300)")
    public SearchPage checkWebinars() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textWebinars, "Вебинары"));
        String textBlock = textWebinars.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Вебинары"));
        assertThat(textBlock, allOf(equalToIgnoringCase("вебинары"), containsString("бинар"), endsWith("ры")));

        String webinarsActual = countWebinars.getText();
        int countOfWebinars = Integer.parseInt(webinarsActual.trim());
        System.out.println("countOfWebinars = " + countOfWebinars);
        assertThat(countOfWebinars, allOf(greaterThan(180), lessThan(300)));
        return this;
    }

    @Step("Проверка отображения блока \"Блоги\" и проверка количественного показателя (> 300)")
    public SearchPage checkBlogs() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textBlogs, "Блоги"));
        String textBlock = textBlogs.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Блоги"));
        assertThat(textBlock, allOf(equalToIgnoringCase("блоги"), containsString("лог")));

        String blogsActual = countBlogs.getText();
        int countOfBlogs = Integer.parseInt(blogsActual.trim());
        System.out.println("countOfBlogs = " + countOfBlogs);
        assertThat(countOfBlogs, greaterThan(300));
        return this;
    }

    @Step("Проверка отображения блока \"Форум\" и проверка количественного показателя (!= 350)")
    public SearchPage checkForum() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textForum, "Форум"));
        String textBlock = textForum.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Форум"));
        assertThat(textBlock, allOf(equalToIgnoringCase("форум"), containsString("ору")));

        String forumsActual = countForums.getText();
        int countOfForums = Integer.parseInt(forumsActual.trim());
        System.out.println("countOfForums = " + countOfForums);
        assertThat(countOfForums, not(350));
        return this;
    }

    @Step("Проверка отображения блока \"Тесты\" и проверка количественного показателя (!= 0)")
    public SearchPage checkTests() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textTests, "Тесты"));
        String textBlock = textTests.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Тесты"));
        assertThat(textBlock, allOf(equalToIgnoringCase("тесты"), containsStringIgnoringCase("тест")));

        String testsActual = countTests.getText();
        int countOfTests = Integer.parseInt(testsActual.trim());
        System.out.println("countOfTests = " + countOfTests);
        assertThat(countOfTests, not(0));

        return this;
    }

    @Step("Проверка отображения блока \"Проекты и компании\", а также проверка загрузки логотипа и текста карточки \"GeekBrains\" с последующим кликом на данную карточку")
    public void checkProjectsAndCompanies() {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies, "Проекты и компании"));
        String textBlock = textProjectsAndCompanies.getText();
        assertThat(textBlock, equalToCompressingWhiteSpace("Проекты и компании"));

        logoGB.isDisplayed();

        Assertions.assertEquals("Образовательный портал GeekBrains", textGB.getText());
        String textGBActual = textGB.getText();
        assertThat(textGBActual, allOf(
                equalToIgnoringCase("образовательный портал geekbrains"),
                containsStringIgnoringCase("geekbrains"),
                endsWith("GeekBrains"),
                equalToCompressingWhiteSpace("Образовательный портал GeekBrains")
        ));

        logoGB.click();

    }
}