package tests.api;

import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class NegativeAPITests extends BaseApiTest {

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на нахождение ошибки при запросе некорректного адреса")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllProjectsNegativeTest() {
        logger.info("Начало теста на получение списка всех проектов с неправильным URL");

        given()
                .when()
                .get(ProjectEndpoints.GET_ALL_PROJECTSWrong)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
        logger.info("Окончание теста на получение списка всех проектов с неправильным URL");
    }

    @Link(name = "Документация к API тестам", type = "APIDoc")
    @Test(description = "Тест на нахождение ошибки при неверном запросе")
    @Severity(SeverityLevel.CRITICAL)
    public void getAllProjectsSecondNegativeTest() {
        logger.info("Начало теста на получение списка всех проектов с использованием POST запроса");

        given()
                .when()
                .post(ProjectEndpoints.GET_ALL_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
        logger.info("Окончание теста на получение списка всех проектов с использованием POST запроса");
    }
}
