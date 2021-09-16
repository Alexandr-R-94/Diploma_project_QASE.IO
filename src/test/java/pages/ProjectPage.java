package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//div[@class='changelog text-center']")
    public WebElement bellBtn;

    @FindBy(xpath = "//a[@class='logItem read seen']")
    public WebElement iFrameText;

    private static final By iFrame = By.xpath("//div[@class='logList']");

    private final static String projectBtn = "//a[.='replace']";

    private String endpoint = "projects";



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

    public WebElement iFrameLogo() {
                return driver.findElement(iFrame);
    }


    public String iFrameTitle(){
      return iFrameText.getText();
    }

}
