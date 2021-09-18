package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteProjectPage extends BasePage {
    @FindBy(xpath = "//button[@class = 'btn btn-cancel']")
    private WebElement deleteButton;
    private final static String endpoint = "project/123/delete";

    public DeleteProjectPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return deleteButton.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public ProjectPage deleteButtonClick(){
        deleteButton.click();
        logger.info("Нажатие на кнопку подтверждение удаления");
        return new ProjectPage(browsersService, false);
    }
}
