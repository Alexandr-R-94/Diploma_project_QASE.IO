package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(className = "logo")
    private WebElement titleLogo;
    @FindBy(id = "inputEmail")
    private WebElement emailInput;
    @FindBy(id = "inputPassword")
    private WebElement passwordInput;
    @FindBy(id = "btnLogin")
    private WebElement loginBtn;
    @FindBy(className = "form-control-feedback")
    private WebElement errorSelector;

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

    public String errorSelectorText() {
        return errorSelector.getText();
    }


    public LoginPage setEmail(String text) {
        emailInput.sendKeys(text);
        logger.info("Ввод корректного логина");
        return this;
    }
    public LoginPage setPassword(String text) {
        passwordInput.sendKeys(text);
        logger.info("Ввод корректного пароля");
        return this;
    }
    public LoginPage loginButton() {
        loginBtn.click();
        logger.info("Нажатие на кнопку ввода");
        return this;
    }
    public ProjectPage successLoginButton() {
        loginButton();
        logger.info("Нажатие на кнопку ввода");
    return new ProjectPage(browsersService, false);
    }



}
