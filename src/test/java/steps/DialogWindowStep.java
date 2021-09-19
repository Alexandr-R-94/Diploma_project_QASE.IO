package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.ProjectPage;

public class DialogWindowStep extends BaseStep {
    public DialogWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Взаимодействие с диалоговым окном по расширению подписки")
    public void dialogWindow() {
        ProjectPage dialogPage = new ProjectPage(browsersService, false)
                .reportsButton()
                .textIsDisplay()
                .notButton();
        Assert.assertTrue(dialogPage.titleLabel.isDisplayed());
    }
}
