package baseEntities;


import core.BrowsersService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

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