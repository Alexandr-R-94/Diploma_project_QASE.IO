package tests;

import baseEntities.BaseTest;
import com.sun.org.apache.bcel.internal.generic.LoadInstruction;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
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

    @Test
    public void Test() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.projectButton("sergey");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);

        Assert.assertTrue(testRepositoryPage.title.isDisplayed());



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


