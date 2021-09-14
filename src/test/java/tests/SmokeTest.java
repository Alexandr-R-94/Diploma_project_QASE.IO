package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.DialogWindowStep;
import steps.PopUpWindowStep;
import steps.ProjectStep;
import pages.TestRepositoryPage;
import steps.LoginStep;


public class SmokeTest extends BaseTest {

    @Test(priority = 4)
    public void loginTestWithIncorrectDataTest() {
        logger.error("Начало теста на ввод некорректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithIncorrectDate();
        logger.error("Конец теста на ввод некорректных данных при регистрации");
    }

    @Test(priority = 1)
    public void loginTestWithCorrectDataTest() {
        logger.error("Начало теста на ввод корректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        logger.error("Коекц теста на ввод корректных данных при регистрации");
    }

    @Test(dependsOnMethods = "loginTestWithCorrectDataTest", priority = 1)
    public void createNewProjectTest() {
        logger.error("Начало теста на создание нового проекта");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep addProjectStep = new ProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);
        logger.error("Начал теста на создание нового проекта");

    }

    @Test(dependsOnMethods = "downloadTests")
    public void deleteProjectTest() {
        logger.error("Начало теста на удаление проекта");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep deleteProjectStep = new ProjectStep(browsersService);
        deleteProjectStep.deleteProject();
        logger.error("Начал теста на удаление проекта");
    }

    @Test
    public void createWithIncorrectCodeTest() {
        logger.error("Начало теста на проверку граничных значений");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep incorrectCode = new ProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);
        logger.error("Конец теста на проверку граничных значений");
    }

    @Test
    public void iFrameTest() {
        logger.error("Начало теста на открытие всплывающего окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        PopUpWindowStep popUpWindowStep = new PopUpWindowStep(browsersService);
        popUpWindowStep.popUpWindow();
        logger.error("Конец теста на открытие всплывающего окна");
    }

    @Test
    public void Alert() {
        logger.error("Начало теста на открытие диалогового окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        DialogWindowStep dialogWindowStep = new DialogWindowStep(browsersService);
        dialogWindowStep.dialogWindow();
        logger.error("Конец теста на открытие диалогового окна");
    }

    @Test(dependsOnMethods = "createNewProjectTest")
    public void downloadTests() {
        logger.error("Начало теста на загрузку файла");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.uploadingTestCase(projectBuilder.getProjectName(), "D:/proect/Diploma_project_QASE.IO/src/test/resources/DEMO-2021-09-10.xml");
        logger.error("Конец теста на загрузку файла");
    }
}
