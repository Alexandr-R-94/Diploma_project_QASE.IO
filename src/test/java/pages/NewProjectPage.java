package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import elements.RadioButton;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
    @FindBy(className = "form-control-feedback")
    private WebElement errorTitle;
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


    public NewProjectPage setName(String name) {
        projectNameInput.sendKeys(name);
        logger.info("Заполнение поля Name");
        return this;
    }
    public NewProjectPage cleanCode() {
        projectCodeInput.clear();
        logger.info("Очистка поля Code");
        return this;
    }
    public NewProjectPage setCode(String code) {
        projectCodeInput.sendKeys(code);
        logger.info("Заполнение поля Code");
        return this;
    }
    public NewProjectPage setDescription(String description) {
        descriptionInput.sendKeys(description);
        logger.info("Заполнение поля Description");
        return this;
    }
    public TestRepositoryPage successfulButtonClick() {
        addButtonClick();
        return new TestRepositoryPage(browsersService, false);
    }
    public NewProjectPage addButtonClick() {
        createProjectButton.click();
        logger.info("Нажатие на кнопку создать");
        return this;
    }
    public String errorText(){
       return errorTitle.getText();
    }

    public NewProjectPage radioButton(String value) {
        RadioButton radioButton = new RadioButton(browsersService, By.xpath("//input[@name ='access_type']"));
        radioButton.selectByIndex(value);
        return this;
    }
}
