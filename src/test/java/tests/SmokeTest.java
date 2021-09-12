package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import steps.AddDeleteProjectStep;
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
    public void loginTestWithIncorrectDataSecond() {
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
}
