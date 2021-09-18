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
        JavascriptExecutor jsExecutor = (JavascriptExecutor) browsersService.getDriver();

        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку уведомлений");
        jsExecutor.executeScript("arguments[0].click();", projectPage.bellBtn);
        logger.info("Переход в iframe через id");
        browsersService.getDriver().switchTo().frame(0);
        browsersService.getWaits().waitForVisibility(By.xpath("//strong[text() = 'April 2021 Updates.']"));
        logger.info("Сравнение ожидаемого текста с фактической");
    }
}
