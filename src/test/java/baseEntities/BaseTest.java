package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {
    public BrowsersService browsersService;
    public ReadProperties properties;

    @BeforeMethod
    public void startBrowser() {
        browsersService = new BrowsersService();
    }

    @AfterMethod
    public void closeBrowser() {
        browsersService.getDriver().quit();
        browsersService = null;
    }

}
