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

    private BrowsersService browsersService;
    private List<WebElement> options = new ArrayList<>();

    public RadioButton(BrowsersService browsersService, By by) {

         options = browsersService.getDriver().findElements(by);

    }

    public void selectByText(String optionName) {
        for (WebElement element : options) {
         String textValue = element.findElement(By.xpath("//div[@class ='col-2']/div/label")).getText();
            if (textValue.trim().equalsIgnoreCase(optionName)){
                element.click();
                break;
            }
        }
    }

}
