package tests.ui;

import baseEntities.BaseTest;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProjectPage;
import steps.DialogWindowStep;
import steps.LoginStep;
import steps.PopUpWindowStep;
import steps.ProjectStep;

public class RegressionsTests extends BaseTest {

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку входа некорректного пользователя")
    public void loginTestWithIncorrectDataTest() {
        logger.error("Начало теста на ввод некорректных данных при регистрации");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithIncorrectDate("123@123.com", "12334");
        logger.error("Конец теста на ввод некорректных данных при регистрации");

    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку граничных значений поля")
    @Severity(SeverityLevel.NORMAL)
    public void createWithIncorrectCodeTest() {
        logger.error("Начало теста на проверку граничных значений");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep incorrectCode = new ProjectStep(browsersService);
        incorrectCode.addErrorCode(projectBuilderError);
        logger.error("Конец теста на проверку граничных значений");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на обнаружение и взаимодействие с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void iFrameTest() {
        logger.error("Начало теста на открытие всплывающего окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        PopUpWindowStep popUpWindowStep = new PopUpWindowStep(browsersService);
        popUpWindowStep.popUpWindow();
        logger.error("Конец теста на открытие всплывающего окна");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на проверку работы с диалоговым окном")
    @Severity(SeverityLevel.NORMAL)
    public void Alert() {
        logger.error("Начало теста на открытие диалогового окна");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        DialogWindowStep dialogWindowStep = new DialogWindowStep(browsersService);
        dialogWindowStep.dialogWindow();
        logger.error("Конец теста на открытие диалогового окна");
    }

    @Link(name = "Тестируемый сайт", type = "mysite")
    @Test(description = "Тест на импортирование в проект тест-кейса")
    @Severity(SeverityLevel.MINOR)
    public void downloadTests() throws InterruptedException {
        logger.error("Начало теста на загрузку файла");
        LoginStep loginStep = new LoginStep(browsersService);
        loginStep.loginWithBuilder(loginBuilder);
        ProjectStep projectStep = new ProjectStep(browsersService);
        projectStep.uploadingTestCase("Demo Project", "E:/TMS testing/Projects/Diploma project of the site QASE.IO/src/test/java/files/qewd.xml");
        logger.error("Конец теста на загрузку файла");
    }

}
