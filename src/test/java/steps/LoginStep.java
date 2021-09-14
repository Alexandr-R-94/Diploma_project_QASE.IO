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

        LoginPage loginPage = new LoginPage(browsersService, true);
        logger.info("Ввод корректного логина");
        loginPage.setEmail(loginBuilder.getUsername());
        logger.info("Ввод корректного пароля");
        loginPage.setPassword(loginBuilder.getPassword());
        logger.info("Нажатие на кнопку ввода");
        loginPage.loginButton();
        logger.info("Ожидание появления списка проектов");
        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }

    public void loginWithIncorrectDate(String errorEmail, String errorPassword){
        LoginPage loginPage = new LoginPage(browsersService, true);
        logger.info("Ввод корректного логина");
        loginPage.setEmail(errorEmail);
        logger.info("Ввод некорректного пароля");
        loginPage.setPassword(errorPassword);
        logger.info("Нажатие на кнопку ввода");
        loginPage.loginButton();
        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertEquals(loginPage.errorSelectorText(), "These credentials do not match our records.");
    }
}
