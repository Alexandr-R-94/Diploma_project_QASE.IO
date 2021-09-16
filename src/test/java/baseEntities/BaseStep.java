package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class BaseStep {
    protected BrowsersService browsersService;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    public BaseStep(BrowsersService browsersService){
        this.browsersService = browsersService;
    }

    protected String pathToFile() {
        File testCase = new File("src/test/resources/qewd.xml");
        return testCase.getAbsolutePath();
        }

}
