package tests;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;
import steps.AddProjectStep;
import steps.LoginStep;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTestWithCorrectData() {
        logger.info("Ввод корректных данных логина и пароля");
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(properties.getEmail());
        loginPage.setPassword(properties.getPassword());
        loginPage.loginButton();


        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }
    @Test
    public void loginTestWithCorrectDataSecond() {

        LoginStep loginStep = new LoginStep(browsersService);
                loginStep.loginWithBuilder(loginBuilder);

        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());
    }



    @Test
    public void createNewProject(){
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        AddProjectStep addProjectStep = new AddProjectStep(browsersService);
                addProjectStep.addProject(projectBuilder);

                Assert.assertEquals(browsersService.getDriver().findElement(By.xpath("//p[@class='header']")).getText(), projectBuilder.getProjectName());


//        RadioButton radioButton = new RadioButton(browsersService, By.name("access_type"));
//        radioButton.selectByText("Public");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
