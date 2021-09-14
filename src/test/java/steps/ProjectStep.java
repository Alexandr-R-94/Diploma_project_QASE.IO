package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import elements.RadioButton;
import models.ProjectBuilder;
import models.ProjectBuilderError;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;

public class ProjectStep extends BaseStep {
    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void addProject(ProjectBuilder projectBuilder) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку создание проекта");
        projectPage.newProjectButton();
        logger.info("Открытие страницы нового проекта");
        NewProjectPage newProjectPage = new NewProjectPage(browsersService, false);
        logger.info("Заполнение поля Name");
        newProjectPage.setName(projectBuilder.getProjectName());
        logger.info("Очистка поля Code");
        newProjectPage.cleanCode();
        logger.info("Заполнение поля Code");
        newProjectPage.setCode(projectBuilder.getProjectCode());
        logger.info("Заполнение поля Description");
        newProjectPage.setDescription(projectBuilder.getDescription());
        logger.info("Выбор типа доступа к проекту");
        RadioButton radioButton = new RadioButton(browsersService, By.xpath("//input[@name ='access_type']"));
        radioButton.selectByIndex("public");
        logger.info("Нажатие на кнопку создать");
        newProjectPage.addButtonClick();
        logger.info("Сравнение ожидаемого имени проекта с фактическим");
        Assert.assertEquals(new TestRepositoryPage(browsersService, false).titleText(), projectBuilder.getProjectName());

    }

    public void deleteProject() {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Выбор проекта по имени");
        projectPage.getProjectButton("sergey").click();
        logger.info("Открытие страницы внутри проекта");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        logger.info("Нажатие на кнопку насройки");
        testRepositoryPage.settingsClick();
        logger.info("Открытие страницы настроек");
        SettingsPage settingsPage = new SettingsPage(browsersService, false);
        logger.info("Нажатие на кнопку удаление");
        settingsPage.deleteButtonClick();
        logger.info("Открытие страницы подтверждения удаления");
        DeleteProjectPage deleteProjectPage = new DeleteProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку подтверждение удаления");
        deleteProjectPage.deleteButtonClick();
        logger.info("Ожидание появления списка проектов");
        Assert.assertTrue(new ProjectPage(browsersService, false).titleLabel.isDisplayed());

    }

    public void addErrorCode(ProjectBuilderError projectBuilderError) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку создание проекта");
        projectPage.newProjectButton();
        logger.info("Открытие страницы нового проекта");
        NewProjectPage newProjectPage = new NewProjectPage(browsersService, false);
        logger.info("Заполнение поля Name");
        newProjectPage.setName(projectBuilderError.getProjectName());
        logger.info("Очистка поля Code");
        newProjectPage.cleanCode();
        logger.info("Заполнение поля Code");
        newProjectPage.setCode(projectBuilderError.getIncorrectProjectCode());
        logger.info("Заполнение поля Description");
        newProjectPage.setDescription(projectBuilderError.getDescription());
        logger.info("Нажатие на кнопку создать");
        newProjectPage.addButtonClick();
        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertEquals(newProjectPage.errorText(), "The code must be at least 2 characters.");
    }

    public void uploadingTestCase(String projectName, String pathToFile) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Выбор проекта по имени");
        projectPage.projectButton(projectName);
        logger.info("Открытие страницы внутри проекта");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        logger.info("Нажатие на кнопку загрузки");
        testRepositoryPage.importBtn();
        logger.info("Открытие страницы загрузки");
        ImportTestCasesPage importTestCasesPage = new ImportTestCasesPage(browsersService, false);
        logger.info("Нажатие на кнопку выбора файла");
        importTestCasesPage.setUploadFileButton(pathToFile);
        logger.info("Нажатие на кнопку загрузить");
        importTestCasesPage.importButton();
        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertEquals(new TestRepositoryPage(browsersService, false).uploadDoneMessage.getText(), "1 suites and 4 cases were successfully imported!");

    }
}