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
    @FindBy(id = "inputTitle")
    private WebElement projectNameInput;
    @FindBy(id = "inputCode")
    private WebElement projectCodeInput;
    @FindBy(id = "inputDescription")
    private WebElement descriptionInput;
    @FindBy(xpath = "//button[text() ='Create project']")
    private WebElement createProjectButton;
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
            return title.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public void setName(String name) {
        projectNameInput.sendKeys(name);
    }

    public void cleanCode() {projectCodeInput.clear();}

    public void setCode(String code) {
        projectCodeInput.sendKeys(code);
    }

    public void setDescription(String description) {
        descriptionInput.sendKeys(description);
    }

    public void addButtonClick() {
        createProjectButton.click();
    }
}
