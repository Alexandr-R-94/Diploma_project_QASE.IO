package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import io.qameta.allure.Step;
import models.ProjectBuilder;
import models.ProjectBuilderError;
import org.testng.Assert;
import pages.NewProjectPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;

public class ProjectStep extends BaseStep {
    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Создание нового проекта с параметрами {projectBuilder}")
    public void addProject(ProjectBuilder projectBuilder) {
        TestRepositoryPage testRepositoryPage = new ProjectPage(browsersService, false)
                .newProjectButton()
                .setName(projectBuilder.getProjectName())
                .cleanCode()
                .setCode(projectBuilder.getProjectCode())
                .setDescription(projectBuilder.getDescription())
                .radioButton("public")
                .successfulButtonClick();
        logger.info("Сравнение ожидаемого имени проекта с фактическим");
        Assert.assertEquals(testRepositoryPage.titleText(), projectBuilder.getProjectName());
    }

    @Step("Удаление проекта с именем {projectName}")
    public void deleteProject(String projectName) {

        ProjectPage projectPage = new ProjectPage(browsersService, false)
                .projectButton(projectName)
                .settingsClick()
                .deleteButtonClick()
                .deleteButtonClick();
        Assert.assertTrue(projectPage.titleLabel.isDisplayed());
    }

    @Step("Попытка создания проекта с параметрами {projectBuilderError}")
    public void addErrorCode(ProjectBuilderError projectBuilderError) {

        NewProjectPage newProjectPage = new ProjectPage(browsersService, false)
                .newProjectButton()
                .setName(projectBuilderError.getProjectName())
                .cleanCode()
                .setCode(projectBuilderError.getIncorrectProjectCode())
                .setDescription(projectBuilderError.getDescription())
                .radioButton("public")
                .addButtonClick();
        Assert.assertEquals(newProjectPage.errorText(), "The code must be at least 2 characters.");
    }

    @Step("Импорт тест-кейса в проект с именем {projectName}")
    public void uploadingTestCase(String projectName, String sourceType) {
        TestRepositoryPage testRepositoryPage = new ProjectPage(browsersService, false)
                .projectButton(projectName)
                .importBtn()
                .sourceTypeBtn()
                .dropDown(sourceType)
                .setUploadFileButton()
                .importButton();
        Assert.assertTrue(testRepositoryPage.uploadDoneMessage.isDisplayed());
    }

    @Step("Создание двух новых проекта с именем {projectName}, уникальным кодом {projectCode} и описанием {descriptions}")
    public void addDefectProject(String projectName, String projectCode, String descriptions) {
        TestRepositoryPage testRepositoryPage = new ProjectPage(browsersService, false)
                .newProjectButton()
                .setName(projectName)
                .cleanCode()
                .setCode(projectCode)
                .setDescription(descriptions)
                .radioButton("public")
                .successfulButtonClick();
        Assert.assertEquals(testRepositoryPage.titleText(), projectName);
    }
}
