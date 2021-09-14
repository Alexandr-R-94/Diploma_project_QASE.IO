package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import io.qameta.allure.*;
import io.restassured.mapper.ObjectMapperType;
import models.ProjectAPI;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class SuccessfullyAPITests extends BaseApiTest {
    private String projectCode;

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на создание проекта")
    @Severity(SeverityLevel.CRITICAL)
    public void addProjectTest() {
        ProjectAPI projectAPI = ProjectAPI.builder()
                .title("Test API Project")
                .code("API")
                .description("This is test project from API")
                .build();


        projectCode = given()
                .body(projectAPI, ObjectMapperType.GSON)
                .when()
                .post(ProjectEndpoints.POST_ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("result.code");
    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на получение всех проектов заданного пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void getAllProjectsTest() {
        ProjectAPI projectAPI = new ProjectAdapter().getAllProjects();

    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на получение проекта", dependsOnMethods = "addProjectTest")
    @Severity(SeverityLevel.NORMAL)
    public void getProjectTest() {
        ProjectAPI projectAPI = new ProjectAdapter().getProject(projectCode);

    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на удаление проекта", dependsOnMethods = "getProjectTest")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProjectTest() {
        ProjectAPI projectAPI = new ProjectAdapter().deleteProject(projectCode);


    }
}