package baseEntities;

import core.BrowsersService;

public class BaseStep {
    protected BrowsersService browsersService;

    public BaseStep(BrowsersService browsersService){
        this.browsersService = browsersService;
    }

}
