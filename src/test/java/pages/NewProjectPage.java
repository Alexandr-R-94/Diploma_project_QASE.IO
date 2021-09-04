package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewProjectPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'New Project']")
    private WebElement title;
    @FindBy(id ="inputTitle")
    private WebElement projectnameinput;
    @FindBy(id ="inputCode")
    private WebElement projectcodeinput;
    @FindBy(id ="inputDescription")
    private WebElement description;
    @FindBy(xpath = "//button[text() ='Create project']")
    private WebElement createprojectbutton;
    private final static String endpoint = "project/create";

    public NewProjectPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return createprojectbutton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
