package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage extends BasePage {

    @FindBy(xpath = "//span[.='Projects']")
    private WebElement projectsBtn;

    @FindBy(xpath = "//span[.='Workspace']")
    private WebElement workspaceBtn;

    @FindBy(xpath = "//span[.='Billing']")
    private WebElement billingBtn;

    @FindBy(xpath = "//span[.='Reports']")
    private WebElement reportsBtn;

    @FindBy(id = "createButton")
    private WebElement newProjectBtn;

    @FindBy(tagName = "tbody")
    public WebElement titleLabel;

    private String endpoint = "projects";

    @FindBy(id = "HW_badge_cont")
    private WebElement bellBtn;

    @FindBy(xpath = "//strong[text() = 'April 2021 Updates.']")
    private WebElement iFraimText;


    private final static String projectBtn = "//a[.='replace']";

  @FindBy(id = "HW_badge_cont")
    public WebElement bellBtn;

   private final static String projectBtn = "//a[text()='replace']";

    public WebElement getProjectButton(String projectName) {
        return driver.findElement(By.xpath(projectBtn.replace("replace", projectName)));
    }


    public ProjectPage(BrowsersService browsersService, boolean openPageByURL) {
        super(browsersService, openPageByURL);
    }

    @Override
    protected void openPage() {
        browsersService.getDriver().get(ReadProperties.getInstance().getURL() + endpoint);
    }

    @Override
    public boolean isPageOpened() {
        try {
            return titleLabel.isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void projectsButton() {
        projectsBtn.click();
    }

    public void workspaceButton() {
        workspaceBtn.click();
    }

    public void billingButton() {
        billingBtn.click();
    }

    public void reportsButton() {
        reportsBtn.click();
    }

    public void newProjectButton() {
        newProjectBtn.click();
    }

    public void bellButton() {
        bellBtn.click();
    }

    public void projectButton(String projectName) {getProjectButton(projectName).click();}



    public String iFraimTitle(){
      return iFraimText.getText();
    }

}
