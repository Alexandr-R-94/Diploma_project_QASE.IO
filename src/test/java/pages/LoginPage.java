package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "logo")
    public WebElement titleLogo;

    @FindBy(id = "inputEmail")
    public WebElement emailInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;

    @FindBy(id = "btnLogin")
    public WebElement loginBtn;

    public LoginPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return titleLogo.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void setEmail(String text) {
        emailInput.sendKeys(text);
    }
    public void setPassword(String text) {
        passwordInput.sendKeys(text);
    }
    public void loginButton() {loginBtn.click();
    }


}
