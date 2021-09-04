package tests;

import baseEntities.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;

public class SmokeTest extends BaseTest {

    @Test
    public void loginTestWithCorrectData() {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail(properties.getEmail());
        loginPage.setPassword(properties.getPassword());
        loginPage.loginButton();


        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }
    @Test
    public void loginTestWithCorrectDataSecond() {
        LoginPage loginPage = new LoginPage(browsersService, true);
        loginPage.setEmail("bestwarlock94@gmail.com");
        loginPage.setPassword("T@D_2Fk7Kt8Qp5q");
        loginPage.loginButton();


        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }
}
