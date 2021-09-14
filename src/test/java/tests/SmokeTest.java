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
    @Test(description = "Тест на логирование корректного пользователя")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTestWithCorrectDataTest() {

        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на создание нового проекта")
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
