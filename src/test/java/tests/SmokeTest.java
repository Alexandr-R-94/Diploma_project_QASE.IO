package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.AddDeleteProjectStep;
import pages.LoginPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;
import steps.AddProjectStep;
import steps.LoginStep;


public class SmokeTest extends BaseTest {

    @Test
    public void loginTestWithCorrectData() {
        logger.info("Ввод корректных данных логина и пароля");
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(properties.getEmail());
        loginPage.setPassword(properties.getErrorPassword());
        loginPage.loginButton();

        Assert.assertEquals(loginPage.errorSelectorText(), "These credentials do not match our records.");

    }
    @Test
    public void loginTestWithCorrectDataSecond() {

        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);

    }

    @Test
    public void createNewProject() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        AddDeleteProjectStep addProjectStep = new AddDeleteProjectStep(browsersService);
        addProjectStep.addProject(projectBuilder);

    }

    @Test
    public void deleteProject() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        AddDeleteProjectStep deleteProjectStep = new AddDeleteProjectStep(browsersService);
        deleteProjectStep.deleteProject();

    }

    @Test
    public void createWithCorrectCode() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        AddDeleteProjectStep incorrectCode = new AddDeleteProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);

    }

    @Test
    public void iFrame(){
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

    @Test
    public void downloadTests() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        AddProjectStep addProjectStep = new AddProjectStep(browsersService);
        addProjectStep.uploadingTestCase("Some project", "E:/TMS testing/Projects/Diploma project of the site QASE.IO/src/test/resources/DEMO-2021-09-10.xml");

        Assert.assertEquals(new TestRepositoryPage(browsersService, false).uploadDoneMessage.getText(), "1 suites and 4 cases were successfully imported!");
    }
}
