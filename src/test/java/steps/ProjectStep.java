package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import elements.DropDownMenu;
import elements.RadioButton;
import io.qameta.allure.Step;
import models.ProjectBuilder;
import models.ProjectBuilderError;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.*;

import java.io.File;
import java.util.Objects;

public class ProjectStep extends BaseStep {
    public ProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    @Step("Создание нового проекта с параметрами {projectBuilder}")
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
    @Step("Удаление проекта с именем {projectName}")
    public void deleteProject(String projectName) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Выбор проекта по имени");
        projectPage.getProjectButton(projectName).click();
        logger.info("Открытие страницы внутри проекта");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        logger.info("Нажатие на кнопку настройки");
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
    @Step("Попытка создания проекта с параметрами {projectBuilderError}")
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

    @Step("Импорт тест-кейса в проект с именем {projectName}")
    public void uploadingTestCase(String projectName, String sourceType) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Выбор проекта по имени");
        projectPage.projectButton(projectName);
        logger.info("Открытие страницы внутри проекта");
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        logger.info("Нажатие на кнопку загрузки");
        testRepositoryPage.importBtn();
        logger.info("Открытие страницы загрузки");
        ImportTestCasesPage importTestCasesPage = new ImportTestCasesPage(browsersService, false);
        importTestCasesPage.sourceTypeBtn();
        DropDownMenu dropDownMenu = new DropDownMenu(browsersService, By.xpath("//div[@id='bs-select-1']//child::span[@class='import-dropdown-item team-member-name']"));
        dropDownMenu.selectByName(sourceType);
        logger.info("Нажатие на кнопку выбора файла");
        File file =new File(Objects.requireNonNull(getClass().getClassLoader().getResource("qewd.xml").getFile()));
        String pathToFile = file.getAbsolutePath().replace("%20", " ");
        System.out.println(pathToFile);
        importTestCasesPage.setUploadFileButton(pathToFile);
        logger.info("Нажатие на кнопку загрузить");
        importTestCasesPage.importButton();
        logger.info("Сравнение ожидаемого текста с фактической");
        Assert.assertEquals(new TestRepositoryPage(browsersService, false).uploadDoneMessage.getText(), "1 suites and 3 cases were successfully imported!");
    }

    @Step("Создание нового проекта с именем {projectName}, уникальным кодом {projectCode} и описанием {descriptions}")
    public void addDefectProject(String projectName, String projectCode, String descriptions) {
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        logger.info("Нажатие на кнопку создание проекта");
        projectPage.newProjectButton();
        logger.info("Открытие страницы нового проекта");
        NewProjectPage newProjectPage = new NewProjectPage(browsersService, false);
        logger.info("Заполнение поля Name");
        newProjectPage.setName(projectName);
        logger.info("Очистка поля Code");
        newProjectPage.cleanCode();
        logger.info("Заполнение поля Code");
        newProjectPage.setCode(projectCode);
        logger.info("Заполнение поля Description");
        newProjectPage.setDescription(descriptions);
        logger.info("Выбор типа доступа к проекту");
        RadioButton radioButton = new RadioButton(browsersService, By.xpath("//input[@name ='access_type']"));
        radioButton.selectByIndex("public");
        logger.info("Нажатие на кнопку создать");
        newProjectPage.addButtonClick();
        Assert.assertEquals(new TestRepositoryPage(browsersService, false).titleText(), projectName);
    }
}
