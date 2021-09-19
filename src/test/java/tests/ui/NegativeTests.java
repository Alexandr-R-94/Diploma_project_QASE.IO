package tests.ui;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import org.testng.annotations.Test;
import pages.TestRepositoryPage;
import steps.LoginStep;
import steps.ProjectStep;

public class NegativeTests extends BaseTest {

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку генерации скриншота в отчёте Allure")
    public void defectsTest() {
        logger.error("Начало теста на создание дефекта с генерацией Screenshot в Allure");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.addDefectProject("Name", "name", "name");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        testRepositoryPage.projectsBtn();
        projectStep = new ProjectStep(browsersService);
        projectStep.addDefectProject("Name", "name", "name");
        logger.error("Завершение теста на создание дефекта с генерацией Screenshot в Allure");
    }

}
