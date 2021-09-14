package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;
import steps.LoginStep;
import steps.ProjectStep;

public class RegressionsTests extends BaseTest {

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку входа некорректного пользователя")
    public void loginTestWithIncorrectDataTest() {
        logger.info("Ввод некорректных данных логина и пароля");
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(properties.getEmail());
        loginPage.setPassword(properties.getErrorPassword());
        loginPage.loginButton();

        Assert.assertEquals(loginPage.errorSelectorText(), "These credentials do not match our records.");

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку граничных значений поля")
    @Severity(SeverityLevel.NORMAL)
    public void createWithIncorrectCodeTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep incorrectCode = new ProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на обнаружение и взаимодействие с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void iFrameTest(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.bellButton();
        browsersService.getDriver().switchTo().frame("HW_frame");
        Assert.assertEquals(projectPage.iFraimTitle(), "April 2021 Updates.");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку работы с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void Alert(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.reportsButton();

    }

}
