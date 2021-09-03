package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectPage {

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

    @FindBy(xpath = "//h1[text()='Projects']")
    private WebElement titleLabel;

    private final static String projectBtn = "//a[.='replace']";

//    public WebElement getProjectButton(String projectName) {
//        return driver.findElement(By.xpath(projectBtn.replace("replace", projectName))); }


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

}
