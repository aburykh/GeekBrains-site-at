package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.block.Navigation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;


public class Header {

    private Navigation navigation;

    public Header(WebDriver driver) {
        navigation = PageFactory.initElements(driver, Navigation.class);

    }

    @FindBy(css = "[class=\"gb-header__title\"]")
    private WebElement headerPage;

    @FindBy(css = "div button svg[class=\"svg-icon icon-popup-close-button \"]")
    private WebElement buttonPopUpClosed;


    @FindBy(css = "[class*=\"gb-top-menu__item\"] [class=\"svg-icon icon-search \"]")
    private WebElement searchIcon;

    @FindBy(css = "[class*=\"gb-top-menu__item\"] [href=\"/login\"]")
    private WebElement checkLoginInHeader;

    @FindBy(css = "[class*=\"gb-top-menu__item\"] [href=\"/register\"]")
    private WebElement checkRegisterInHeader;


    public WebElement getSearchIcon() {
        return searchIcon;
    }


    @Step("Проверка отображения элементов в Header'е")
    public void checkElementsInHeader() throws RuntimeException {
        getSearchIcon().isDisplayed();

        String loginInHeaderText = checkLoginInHeader.getText();
        assertThat(loginInHeaderText, equalToCompressingWhiteSpace("Вход"));

        String registerInHeaderText = checkRegisterInHeader.getText();
        assertThat(registerInHeaderText, equalToCompressingWhiteSpace("Регистрация"));

    }
}
