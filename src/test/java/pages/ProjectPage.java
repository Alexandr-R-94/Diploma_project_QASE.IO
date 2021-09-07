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
    public WebElement projectsBtn;

    @FindBy(xpath = "//span[.='Workspace']")
    public WebElement workspaceBtn;

    @FindBy(xpath = "//span[.='Billing']")
    public WebElement billingBtn;

    @FindBy(xpath = "//span[.='Reports']")
    public WebElement reportsBtn;

    @FindBy(id = "createButton")
    public WebElement newProjectBtn;

    @FindBy(xpath = "//h1[text()='Projects']")
    public WebElement titleLabel;
    private String endpoint = "projects";
  
  @FindBy(id = "HW_badge_cont")
    public WebElement bellBtn;
  
   private final static String projectBtn = "//a[.='replace']";

    public WebElement getProjectButton(String projectName) {
        return driver.findElement(By.xpath(projectBtn.replace("replace", projectName))); }


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

    public void bellButton() {bellBtn.click();}


}
