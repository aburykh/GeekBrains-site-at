package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.block.Navigation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public abstract class BasePage {

    public BasePage(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);
        this.driver = driver;
    }

    protected WebDriver driver;
    private Navigation navigation;

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerTitlePage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;

    @Step("Закрытие Pop-UP окна")
    public BasePage closedPopUp() {
        buttonPopUpClosed.click();
        return this;
    }

    @Step("Проверка загрузки заголовка страницы {exampleNamePage}")
    public BasePage checkNamePage(String exampleNamePage) {
        new WebDriverWait(driver, 30)
                .until(ExpectedConditions.textToBePresentInElement(headerTitlePage, exampleNamePage));

        String headerPageText = headerTitlePage.getText();
        assertThat(headerPageText, equalToCompressingWhiteSpace(exampleNamePage));
        return this;
    }

    public Navigation getNavigation() {
        return navigation;
    }
}