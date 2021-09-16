package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class BaseStep {
    protected BrowsersService browsersService;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);
protected WebDriver driver;

    public BaseStep(BrowsersService browsersService){
        this.browsersService = browsersService;

    }

    protected String pathToFile() {
        File testCase = new File("src/test/resources/qewd.xml");
        return testCase.getAbsolutePath();
        }

}
