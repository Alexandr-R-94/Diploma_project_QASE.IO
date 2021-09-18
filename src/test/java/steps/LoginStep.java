package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import models.LoginBuilder;
import org.testng.Assert;
import pages.LoginPage;
import pages.ProjectPage;

public class LoginStep extends BaseStep {
    public LoginStep(BrowsersService browsersService) {
        super(browsersService);
    }


    @Step("Вход в систему с данными из {loginBuilder}")
    public void loginWithBuilder(LoginBuilder loginBuilder){
        ProjectPage projectPage = new LoginPage(browsersService, true)
                .setEmail(loginBuilder.getUsername())
                .setPassword(loginBuilder.getPassword())
                .successLoginButton();
        logger.info("Ожидание появления списка проектов");
        Assert.assertTrue(projectPage.titleLabel.isDisplayed());
    }

    public void loginWithIncorrectDate(String errorEmail, String errorPassword) {
        LoginPage loginPage = new LoginPage(browsersService, true)
                .setEmail(errorEmail)
                .setPassword(errorPassword)
                .loginButton();
        logger.info("Сравнение ожидаемого текста с фактическим");
        Assert.assertEquals(loginPage.errorSelectorText(), "These credentials do not match our records.");
    }
}
