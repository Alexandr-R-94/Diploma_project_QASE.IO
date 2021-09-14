package tests.ui;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import steps.ProjectStep;
import steps.LoginStep;


public class SmokeTest extends BaseTest {


    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на логирование корректного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTestWithCorrectDataTest() {
        logger.error("Начало теста на ввод корректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        logger.error("Завершение теста на ввод корректных данных при регистрации");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на создание нового проекта")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewProjectTest() {
        logger.error("Начало теста на создание нового проекта");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep addProjectStep = new ProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);
        logger.error("Завершение теста на создание нового проекта");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(dependsOnMethods = "createNewProjectTest", description = "Тест на удаление проекта")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep deleteProjectStep = new ProjectStep(browsersService);
        deleteProjectStep.deleteProject(projectBuilder.getProjectName());
        logger.error("Завершение теста на удаление проекта");
    }
}
