package tests;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.DialogWindowStep;
import steps.PopUpWindowStep;
import steps.ProjectStep;
import pages.LoginPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;
import steps.LoginStep;


public class SmokeTest extends BaseTest {

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку входа некорректного пользователя")
    public void loginTestWithIncorrectDataTest() {
        logger.error("Начало теста на ввод некорректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithIncorrectDate("123@123.com", "12334");
        logger.error("Конец теста на ввод некорректных данных при регистрации");

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на логирование корректного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTestWithCorrectDataTest() {
        logger.error("Начало теста на ввод корректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        logger.error("Коекц теста на ввод корректных данных при регистрации");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на создание нового проекта", dependsOnMethods = "loginTestWithCorrectDataTest", priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() {
        logger.error("Начало теста на создание нового проекта");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep addProjectStep = new ProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);
        logger.error("Начал теста на создание нового проекта");

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(dependsOnMethods = "downloadTests", description = "Тест на удаление проекта")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep deleteProjectStep = new ProjectStep(browsersService);
        deleteProjectStep.deleteProject(projectBuilder.getProjectName());
        logger.error("Начал теста на удаление проекта");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку граничных значений поля")
    @Severity(SeverityLevel.NORMAL)
    public void createWithIncorrectCodeTest() {
        logger.error("Начало теста на проверку граничных значений");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep incorrectCode = new ProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);
        logger.error("Конец теста на проверку граничных значений");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на обнаружение и взаимодействие с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void iFrameTest() {
        logger.error("Начало теста на открытие всплывающего окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        PopUpWindowStep popUpWindowStep = new PopUpWindowStep(browsersService);
        popUpWindowStep.popUpWindow();
        logger.error("Конец теста на открытие всплывающего окна");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку работы с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void Alert() {
        logger.error("Начало теста на открытие диалогового окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        DialogWindowStep dialogWindowStep = new DialogWindowStep(browsersService);
        dialogWindowStep.dialogWindow();
        logger.error("Конец теста на открытие диалогового окна");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(dependsOnMethods = "createNewProjectTest", description = "Тест на импортирование в проект тест-кейса")
    @Severity(SeverityLevel.MINOR)
    public void downloadTests() {
        logger.error("Начало теста на загрузку файла");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.uploadingTestCase(projectBuilder.getProjectName(), "E:/TMS testing/Projects/Diploma project of the site QASE.IO/src/test/java/files/DEMO-Test-Case.xml");
        logger.error("Конец теста на загрузку файла");
    }
}
