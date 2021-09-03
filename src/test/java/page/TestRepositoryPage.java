package page;

import baseEntities.BasePage;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestRepositoryPage extends BasePage {

    @FindBy(xpath = "//h1[text() = 'Test repository']")
    private WebElement title;
    @FindBy(xpath = "//a[@title = 'Import']")
    private WebElement importbutton;
    @FindBy(xpath = "//button[@class = 'btn btn-secondary mt-3 me-2']")
    private WebElement exportbutton;
    @FindBy(xpath = "//a[text() = 'Trash bin']")
    private WebElement trashbinbutton;
    @FindBy(id = "create-suite-button")
    private WebElement suitebutton;
    @FindBy(id = "create-case-button")
    private WebElement casebutton;
    private final static String endpoint = "project/ABC";

    public TestRepositoryPage(WebDriver driver, boolean openPageByURL) {
        super(driver, openPageByURL);
    }

    @Override
    protected void openPage() {
        driver.get(properties.getURL());
    }

    @Override
    public boolean isPageOpened() {
        try {
            return trashbinbutton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}
