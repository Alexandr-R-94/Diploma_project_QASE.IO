package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DialogPage extends BasePage {
    @FindBy(xpath = "//p[@class = 'description']")
    private WebElement upgradeText;
    @FindBy(css = ".btn.btn-invisible")
    private WebElement notBtn;

    public DialogPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {

    }

    @Override
    public boolean isPageOpened() {
        try {
            return upgradeText.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void notButton() {
        notBtn.click();
    }

    public void textIsDisplay(){upgradeText.isDisplayed();}
}
