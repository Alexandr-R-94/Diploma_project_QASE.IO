package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import org.testng.Assert;
import pages.ProjectPage;

public class DialogWindowStep extends BaseStep {
    public DialogWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void dialogWindow(){

        ProjectPage dialogPage = new ProjectPage(browsersService, false)
                .reportsButton()
                        .textIsDisplay()
                                .notButton();
        Assert.assertTrue(dialogPage.titleLabel.isDisplayed());

    }
}
