package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseStep {
    protected BrowsersService browsersService;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);

    public BaseStep(BrowsersService browsersService){
        this.browsersService = browsersService;
    }

}
