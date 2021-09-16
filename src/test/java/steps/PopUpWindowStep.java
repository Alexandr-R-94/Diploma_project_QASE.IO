package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.testng.Assert;
import pages.ProjectPage;

public class PopUpWindowStep extends BaseStep {
    public PopUpWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void popUpWindow() throws InterruptedException {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку уведомлений");
        projectPage.bellButton();
        logger.info("Переход в iframe через id");
//        Thread.sleep(3000);
        browsersService.getDriver().switchTo().frame(0);
//        Thread.sleep(3000);
        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertTrue(projectPage.iFrameText.isDisplayed());
    }
}
