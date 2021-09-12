package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import steps.ProjectStep;
import pages.LoginPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;
import steps.LoginStep;


public class SmokeTest extends BaseTest {

    @Test(priority = 4)
    public void loginTestWithIncorrectDataTest() {
        logger.info("Ввод некорректных данных логина и пароля");
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(properties.getEmail());
        loginPage.setPassword(properties.getErrorPassword());
        loginPage.loginButton();

        Assert.assertEquals(loginPage.errorSelectorText(), "These credentials do not match our records.");

    }
    @Test(priority = 1)
    public void loginTestWithCorrectDataTest() {

        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);

    }

    @Test(dependsOnMethods = "loginTestWithCorrectDataTest", priority = 1)
    public void createNewProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep addProjectStep = new ProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);

    }

    @Test(dependsOnMethods = "downloadTests")
    public void deleteProjectTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep deleteProjectStep = new ProjectStep(browsersService);
        deleteProjectStep.deleteProject();

    }

    @Test
    public void createWithIncorrectCodeTest() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep incorrectCode = new ProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);

    }

    @Test
    public void iFrameTest(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.bellButton();
        browsersService.getDriver().switchTo().frame("HW_frame");
        Assert.assertEquals(projectPage.iFraimTitle(), "April 2021 Updates.");
    }

    @Test
    public void Alert(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.reportsButton();

    }

    @Test(dependsOnMethods = "createNewProjectTest")
    public void downloadTests() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.uploadingTestCase(projectBuilder.getProjectName(), "E:/TMS testing/Projects/Diploma project of the site QASE.IO/src/test/resources/DEMO-2021-09-10.xml");

        Assert.assertEquals(new TestRepositoryPage(browsersService, false).uploadDoneMessage.getText(), "1 suites and 4 cases were successfully imported!");
    }
}
