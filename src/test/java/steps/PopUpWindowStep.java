package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import pages.ProjectPage;

public class PopUpWindowStep extends BaseStep {
    public PopUpWindowStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Взаимодействие с всплывающим окном IFrame")
    public void popUpWindow(){
        ProjectPage projectPage = new ProjectPage(browsersService, false)
                .getWaitsText2()
                .switchToFrameFromIndex()
                .getWaitsText();
    }
}
