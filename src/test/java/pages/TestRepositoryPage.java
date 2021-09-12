package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRepositoryPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Test repository']")
    public WebElement title;
    @FindBy(xpath = "//a[@title = 'Import']")
    private WebElement importButton;
    @FindBy(xpath = "//button[@class = 'btn btn-secondary mt-3 me-2']")
    private WebElement exportButton;
    @FindBy(xpath = "//a[text() = 'Trash bin']")
    private WebElement trashBinButton;
    @FindBy(id = "create-suite-button")
    private WebElement suiteButton;
    @FindBy(id = "create-case-button")
    private WebElement caseButton;
    @FindBy(xpath = "//span[text()=' 1 suites and 4 cases were successfully imported!']")
    public WebElement uploadDoneMessage;

    private final static String endpoint = "project/ABC";

    public TestRepositoryPage(BrowsersService browsersService, boolean openPageByURL) {
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

    public void importBtn() {
        importButton.click();
    }

    public void uploadMessage() {
        uploadDoneMessage.getText();
    }



}
