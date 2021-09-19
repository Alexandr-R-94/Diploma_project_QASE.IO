package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class DropDownMenu {
    private List<WebElement> options = new ArrayList<>();
    private BrowsersService service;

    public DropDownMenu(BrowsersService service, By by) {
        this.service = service;

        for (WebElement element : service.getDriver().findElements(by)) {
            options.add(element);
        }
    }
        public void selectByName(String name) {
            for (WebElement element : options) {
                String textValue = element.getText();
                if (textValue.equalsIgnoreCase(name)) {
                    element.click();
                    break;
                }
            }
        }
}
