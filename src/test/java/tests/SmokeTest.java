package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;
import pages.LoginPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;
import steps.LoginStep;


public class SmokeTest extends BaseTest {

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
    @Test(description = "Тест на логирование корректного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTestWithCorrectDataTest() {

        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на создание нового проекта", dependsOnMethods = "loginTestWithCorrectDataTest", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep addProjectStep = new ProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(dependsOnMethods = "downloadTests", description = "Тест на удаление проекта")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep deleteProjectStep = new ProjectStep(browsersService);
        deleteProjectStep.deleteProject(projectBuilder.getProjectName());

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

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(dependsOnMethods = "createNewProjectTest", description = "Тест на импортирование в проект тест-кейса")
    @Severity(SeverityLevel.MINOR)
    public void downloadTests() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.uploadingTestCase("Some project", "E:/TMS testing/Projects/Diploma project of the site QASE.IO/src/test/java/files/DEMO-Test-Case.xml");

        Assert.assertEquals(new TestRepositoryPage(browsersService, false).uploadDoneMessage.getText(), "1 suites and 4 cases were successfully imported!");
    }
}
