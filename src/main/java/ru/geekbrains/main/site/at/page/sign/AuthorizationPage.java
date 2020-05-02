package ru.geekbrains.main.site.at.page.sign;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.main.site.at.page.BasePageObject;
import ru.geekbrains.main.site.at.page.OpenUrl;
import ru.geekbrains.main.site.at.page.content.HomePage;

public class AuthorizationPage extends BasePageObject implements OpenUrl {

    public AuthorizationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid=\"login-email\"]")
    private WebElement inputLogin;

    @FindBy(css = "[data-testid=\"login-password\"]")
    private WebElement inputPassword;

    @FindBy(css = "[data-testid=\"login-submit\"")
    private WebElement buttonSingInd;


    @Step("авторизация с логином: {login} и паролем: {password}")
    public HomePage authorization(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        buttonSingInd.click();
        return new HomePage(driver);
    }

    @Override
    public AuthorizationPage openUrl() {
        driver.get("https://geekbrains.ru/login");
        return null;
    }

}