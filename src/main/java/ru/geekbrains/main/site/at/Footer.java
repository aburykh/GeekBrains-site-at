package ru.geekbrains.main.site.at;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.geekbrains.main.site.at.block.Navigation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;

public class Footer extends Page {

    public Footer(WebDriver driver) {
        super(driver);
    }

    private Navigation navigation;


    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"facebook\"]")
    private WebElement checkFacebookInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"vk\"]")
    private WebElement checkVkInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"instagram\"]")
    private WebElement checkInstagramInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"youtube\"]")
    private WebElement checkYoutubeInFooter;

    @FindBy(css = "[class=\"site-footer__icon\"] [class*=\"telegram\"]")
    private WebElement checkTelegramInFooter;


    public WebElement getCheckFacebookInFooter() {
        return checkFacebookInFooter;
    }

    public WebElement getCheckVkInFooter() {
        return checkVkInFooter;
    }

    public WebElement getCheckInstagramInFooter() {
        return checkInstagramInFooter;
    }

    public WebElement getCheckYoutubeInFooter() {
        return checkYoutubeInFooter;
    }

    public WebElement getCheckTelegramInFooter() {
        return checkTelegramInFooter;
    }


    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"/feedbacks\"]")
    private WebElement checkFeedbacksInFooter;

    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"https://geekbrains.zendesk.com/hc/ru\"]")
    private WebElement checkHelpInFooter;

    @FindBy(css = "[class*=\"footer__links_first-row\"] [href=\"/company\"]")
    private WebElement checkCompanyInFooter;


    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/license\"]")
    private WebElement checkLicenseInFooter;

    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/career\"]")
    private WebElement checkCareerInFooter;

    @FindBy(css = "[class*=\"footer__links_second-row\"] [href*=\"/forbusiness\"]")
    private WebElement checkForBusinessInFooter;


    @Step("Проверка отображения элементов в Footer'е")
    public void checkElementsInFooter() throws RuntimeException {

        getCheckFacebookInFooter().isDisplayed();
        getCheckVkInFooter().isDisplayed();
        getCheckInstagramInFooter().isDisplayed();
        getCheckYoutubeInFooter().isDisplayed();
        getCheckTelegramInFooter().isDisplayed();


        String feedbacksInFooterText = checkFeedbacksInFooter.getText();
        assertThat(feedbacksInFooterText, equalToCompressingWhiteSpace("Отзывы"));

        String helpInFooterText = checkHelpInFooter.getText();
        assertThat(helpInFooterText, equalToCompressingWhiteSpace("Помощь"));

        String companyInFooterText = checkCompanyInFooter.getText();
        assertThat(companyInFooterText, equalToCompressingWhiteSpace("О проекте"));

        String licenseInFooterText = checkLicenseInFooter.getText();
        assertThat(licenseInFooterText, equalToCompressingWhiteSpace("Лицензия"));

        String careerInFooterText = checkCareerInFooter.getText();
        assertThat(careerInFooterText, equalToCompressingWhiteSpace("Вакансии"));

        String forBusinessInFooterText = checkForBusinessInFooter.getText();
        assertThat(forBusinessInFooterText, equalToCompressingWhiteSpace("Компаниям"));

    }

}