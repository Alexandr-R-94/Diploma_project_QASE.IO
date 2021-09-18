package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImportTestCasesPage extends BasePage {

    @FindBy(className = "filter-option-inner-inner")
    private WebElement title;
    @FindBy(xpath = "//span[.='Qase.io']/ancestor::button")
    public WebElement dropDownButton;
    @FindBy(xpath = "//input[@type = 'file' and @name = 'file']")
    private WebElement uploadFileButton;
    @FindBy(xpath = "//button[text()='Import']")
    private WebElement importBtn;

    public ImportTestCasesPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return title.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


    public void setUploadFileButton(String path) {
        uploadFileButton.sendKeys(path);
    }
    public void importButton() {
        importBtn.submit();
    }
    public void sourceTypeBtn() {
        dropDownButton.click();
    }

}
