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
        logger.info("Старт теста на добавление нового проекта");
        logger.warn("Создание проекта с помощью Builder");
        ProjectAPI projectAPI = ProjectAPI.builder()
                .title("Test API Project")
                .code("API")
                .description("This is test project from API")
                .build();


        logger.info("Передача POST запроса для создания проекта.");
        projectCode = given()
                .body(projectAPI, ObjectMapperType.GSON)
                .when()
                .post(ProjectEndpoints.POST_ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("result.code");
        logger.warn("Окончание теста и получение уникального кода для дальнейшего использования");
    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на получение всех проектов заданного пользователя")
    @Severity(SeverityLevel.NORMAL)
    public void getAllProjectsTest() {
        logger.info("Старт теста на получение всех проектов пользователя с помощью адаптера");
        ProjectAPI projectAPI = new ProjectAdapter().getAllProjects();

        logger.info("Окончание теста на получение всех проектов пользователя");

    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на получение проекта", dependsOnMethods = "addProjectTest")
    @Severity(SeverityLevel.NORMAL)
    public void getProjectTest() {
        logger.info("Старт теста на получение проекта с уникальным кодом");
        ProjectAPI projectAPI = new ProjectAdapter().getProject(projectCode);
        logger.info("Окончание теста на получение проекта с уникальным кодом");

    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на удаление проекта", dependsOnMethods = "getProjectTest")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProjectTest() {
        logger.info("Старт теста на удаление проекта с уникальным кодом");
        ProjectAPI projectAPI = new ProjectAdapter().deleteProject(projectCode);
        logger.info("Окончание теста на удаление проекта с уникальным кодом");
    }
}