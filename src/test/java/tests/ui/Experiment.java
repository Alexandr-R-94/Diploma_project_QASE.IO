package tests.ui;

import baseEntities.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.ProjectPage;
import steps.LoginStep;

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;
import java.util.List;

public class Experiment extends BaseTest {

    @Test
    public void test() {
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        List<WebElement> list = new ArrayList<>();
        list = browsersService.getDriver().findElements(By.xpath("//iframe"));
        System.out.println(list.size());
    }
}
