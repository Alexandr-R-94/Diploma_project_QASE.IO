package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.testng.Assert;
import pages.DialogPage;
import pages.ProjectPage;

public class DialogWindowStep extends BaseStep {
    public DialogWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void dialogWindow(){
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку отчета");
        projectPage.reportsButton();
        logger.info("Открытие страницы диалогового окна");
        DialogPage dialogPage = new DialogPage(browsersService, false);
        logger.info("Проверка на появление данного окна");
        dialogPage.textIsDisplay();
        logger.info("Нажатие на кнопку закрытие окна");
        dialogPage.notButton();

        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());
    }
}
