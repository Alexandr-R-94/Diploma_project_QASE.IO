package pages;

import baseEntities.BasePage;
import core.BrowsersService;
import core.ReadProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
    @FindBy(xpath = "//i[@class='far fa-fw fa-bell']")
    public WebElement bellBtn;
    @FindBy(xpath = "//strong[text() = 'April 2021 Updates.']")
    private WebElement iFrameText;

    private final static String projectBtn = "//a[.='replace']";

    private String endpoint = "projects";

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

    public WebElement getProjectButton(String projectName) {
        return driver.findElement(By.xpath(projectBtn.replace("replace", projectName)));
    }

    public ProjectPage projectsButton() {
        projectsBtn.click();
        logger.info("Обновление страницы с проектами");
        return this;
    }
    public void workspaceButton() {
        workspaceBtn.click();
    }
    public void billingButton() {
        billingBtn.click();
    }
    public DialogPage reportsButton() {
        logger.info("Нажатие на кнопку отчета");
        reportsBtn.click();
        logger.info("Открытие страницы диалогового окна");
        return new DialogPage(browsersService, false);
    }
    public NewProjectPage newProjectButton() {
        logger.info("Нажатие на кнопку создание проекта");
        newProjectBtn.click();
        return new NewProjectPage(browsersService, false);
    }
    public TestRepositoryPage projectButton(String projectName) {
        logger.info("Выбор проекта по имени");
        getProjectButton(projectName).click();
        logger.info("Открытие страницы внутри проекта");
        return new TestRepositoryPage(browsersService, false);
    }

    public ProjectPage switchToFrameFromIndex() {
        browsersService.getDriver().switchTo().frame(driver.findElement(By.cssSelector("iframe[class='HW_frame']")));
        return this;
    }
    public ProjectPage jsExecutorBellBtn() {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) browsersService.getDriver();
        jsExecutor.executeScript("arguments[0].click();", bellBtn);
        return this;
    }
    public ProjectPage getWaitsText() {
        browsersService.getWaits().waitForVisibility(iFrameText);
        return this;
    }
}
