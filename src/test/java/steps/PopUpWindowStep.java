package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.ProjectPage;

public class PopUpWindowStep extends BaseStep {
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
        browsersService.getDriver().switchTo().frame(0);
        WebElement element = browsersService.getDriver().findElement(By.xpath("//h3[.='Latest changes']"));
        logger.info("Сравнение ожидаемого текста с фактической");
        //Assert.assertTrue(element.isDisplayed());
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
