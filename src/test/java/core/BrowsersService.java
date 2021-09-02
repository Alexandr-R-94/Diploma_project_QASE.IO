package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowsersService {
    private WebDriver webDriver = null;

    public BrowsersService() {

        switch (ReadProperties.getInstance().getBrowserName().toLowerCase()) {
            case "chrome":
                WebDriverManager.getInstance(DriverManagerType.CHROME).setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(ReadProperties.getInstance().isHeadless());
                chromeOptions.addArguments("--disable-gpu");
                chromeOptions.addArguments("--start-maximized");
                webDriver = new ChromeDriver(chromeOptions);
                break;

            case "firefox":
                WebDriverManager.getInstance(DriverManagerType.FIREFOX).setup();

                webDriver = new FirefoxDriver();
                break;

            default:
                System.out.println("Browser " + ReadProperties.getInstance().getBrowserName() + " is not supported.");
        }
    }
    public WebDriver getDriver() {
        return webDriver   ;
    }


    public void sleep ( long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
