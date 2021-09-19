package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import elements.DropDownMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.File;

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


    public ImportTestCasesPage setUploadFileButton() {
        File testCase = new File("src/test/resources/TestRail_TestCase.xml");
        String path = testCase.getAbsolutePath();
        uploadFileButton.sendKeys(path);
        logger.info("Нажатие на кнопку выбора файла и ввод пути к файлу");
        return this;
    }
    public TestRepositoryPage importButton() {
        importBtn.submit();
        logger.info("Нажатие на кнопку загрузить");
        return new TestRepositoryPage(browsersService, false);
    }
    public ImportTestCasesPage sourceTypeBtn() {
        dropDownButton.click();
        logger.info("Открытие DropDownMenu для выбора нужного типа файла");
        return this;
    }

    public ImportTestCasesPage dropDown(String sourceType) {
        DropDownMenu dropDownMenu = new DropDownMenu(browsersService, By.xpath("//div[@id='bs-select-1']//child::span[@class='import-dropdown-item team-member-name']"));
        dropDownMenu.selectByName(sourceType);
        return this;
    }

}
