package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SettingsPage extends BasePage {
    private final static String endpoint = "project/123/settings/general";
    @FindBy(xpath = "//h1[text() = 'Settings']")
    private WebElement title;
    @FindBy(xpath = "//a[@class = 'btn btn-cancel']")
    private WebElement deleteButton;

    public SettingsPage(BrowsersService browsersService, boolean openPageByURL) {
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

    public void deleteButtonClick(){
        deleteButton.click();
    }
}
