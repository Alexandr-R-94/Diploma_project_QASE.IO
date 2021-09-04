package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties properties;

    @BeforeTest
    public void setupTest() {
        properties = ReadProperties.getInstance();
    }

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
