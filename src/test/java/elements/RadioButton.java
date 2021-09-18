package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RadioButton {
    private List<WebElement> options;

    public RadioButton(BrowsersService browsersService, By by) {
         options = browsersService.getDriver().findElements(by);
    }

    public void selectByIndex(String value) {
        for (WebElement element : options) {
            if (element.getAttribute("value").equalsIgnoreCase(value)) {
                element.click();
                break;
            }
        }
    }
}
