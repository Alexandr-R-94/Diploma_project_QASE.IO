package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Waits {
    private WebDriverWait wait;
    public Waits(WebDriver driver, int timeOut){
        wait =  new WebDriverWait(driver, timeOut);
    }

    public WebElement waitForVision(By by) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }
    public WebElement waitForVision(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public Boolean waitForAttribute (By by, String attributeName, String attributeValue) {
        return wait.until(ExpectedConditions.attributeToBe(by, attributeName, attributeValue));
    }

public Boolean waitForWindows(int windowCount) {
        return wait.until(ExpectedConditions.numberOfWindowsToBe(windowCount));
    }


     public List<WebElement> waitForVisionAll(By by) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

public Boolean waitForInvisibility(By by) {
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

public Boolean waitForInvisibility(WebElement element) {
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }

}
