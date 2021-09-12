package elements;

import core.BrowsersService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.ArrayList;
import java.util.List;

public class RadioButton {
    private List<WebElement> options = new ArrayList<>();

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
