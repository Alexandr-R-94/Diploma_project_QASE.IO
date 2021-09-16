package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProjectPage;
import utils.Waits;

public class PopUpWindowStep extends BaseStep {
    private Waits waits;
    public PopUpWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void popUpWindow() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) browsersService.getDriver();

        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку уведомлений");
        js.executeScript("arguments[0].click();", projectPage.bellBtn);
        //projectPage.bellButton();
        logger.info("Переход в iframe через id");
        browsersService.getDriver().switchTo().frame(browsersService.getDriver().findElement(By.id("HW_frame")));
        WebElement element = browsersService.getDriver().findElement(By.xpath("//strong[.='April 2021 Updates.']"));
        //element.click();


        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertTrue(element.isDisplayed());

    }
}
