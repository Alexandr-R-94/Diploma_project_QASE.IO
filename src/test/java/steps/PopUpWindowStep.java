package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import pages.ProjectPage;

public class PopUpWindowStep extends BaseStep {
    public PopUpWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void popUpWindow(){

        ProjectPage projectPage = new ProjectPage(browsersService, false)
                .jsExecutor1()
                .switchToFrameFromIndex2()
                .getWaits3();
//
//        ProjectPage projectPage = new ProjectPage(browsersService, false);
//        logger.info("Нажатие на кнопку уведомлений");
//
//        logger.info("Переход в iframe через id");
//    //    browsersService.getDriver().switchTo().frame(0);
//
//        logger.info("Сравнение ожидаемого текста с фактической");
    }
}
