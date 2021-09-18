package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public abstract class BasePage {
    protected static final int WAIT_FOR_PAGE_LOADING_SEC = 5;
    protected final BrowsersService browsersService;
    protected WebDriver driver;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);


    protected abstract void openPage();

    public abstract boolean isPageOpened();

    public BasePage(BrowsersService browsersService, boolean openPageByURL) {
        this.browsersService = browsersService;
        this.driver = browsersService.getDriver();
        properties = ReadProperties.getInstance();


        PageFactory.initElements(this.driver, this);

        if (openPageByURL) {
            openPage();
        }
        waitForOpen();
    }

    protected void waitForOpen() {
        int secondsCount = 0;
        boolean isPageOpenedIndicator = isPageOpened();

        while (!isPageOpenedIndicator && secondsCount < WAIT_FOR_PAGE_LOADING_SEC) {
            browsersService.sleep(1000);
            secondsCount++;
            isPageOpenedIndicator = isPageOpened();
        }
        if (!isPageOpenedIndicator) {
            throw new AssertionError("Page was not opened");
        }
    }
}


