package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthorizationPage {

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

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
        return PageFactory.initElements(driver, HomePage.class);
    }
}