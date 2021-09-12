package steps;

import baseEntities.BaseStep;
import core.BrowsersService;
import models.ProjectBuilder;
import pages.ImportTestCasesPage;
import pages.NewProjectPage;
import pages.ProjectPage;
import pages.TestRepositoryPage;

public class AddProjectStep extends BaseStep {
    public AddProjectStep(BrowsersService browsersService) {
        super(browsersService);
    }

    public void addProject(ProjectBuilder projectBuilder){
        ProjectPage projectPage = new ProjectPage(browsersService, false);
        projectPage.newProjectButton();
        NewProjectPage newProjectPage = new NewProjectPage(browsersService, false);
        newProjectPage.setName(projectBuilder.getProjectName());
        newProjectPage.cleanCode();
        newProjectPage.setCode(projectBuilder.getProjectCode());
        newProjectPage.setDescription(projectBuilder.getDescription());
        newProjectPage.addButtonClick();
    }

    public void uploadingTestCase (String projectName, String pathToFile) {
        ProjectPage projectPage = new ProjectPage(browsersService,false);
        projectPage.projectButton(projectName);
        TestRepositoryPage testRepositoryPage = new TestRepositoryPage(browsersService, false);
        testRepositoryPage.importBtn();
        ImportTestCasesPage importTestCasesPage = new ImportTestCasesPage(browsersService, false);
        importTestCasesPage.setUploadFileButton(pathToFile);
        importTestCasesPage.importButton();
    }
}
