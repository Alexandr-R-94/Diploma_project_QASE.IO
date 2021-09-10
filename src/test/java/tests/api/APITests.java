package tests.api;

import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import io.restassured.mapper.ObjectMapperType;
import models.ProjectAPI;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APITests extends BaseApiTest {
    protected String projectCode;

    @Test
    public void addProjectTest() {
        ProjectAPI projectAPI = ProjectAPI.builder()
                .title("Test API Project")
                .code("API")
                .description("This is test project from API")
                .build();


        projectCode =  given()
                .body(projectAPI, ObjectMapperType.GSON)
                .when()
                .post(ProjectEndpoints.POST_ADD_PROJECT)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_OK)
                .extract().jsonPath().getString("result.code");
    }

    @Test
    public void getAllProjectsTest() {
        given()
                .when()
                .get(ProjectEndpoints.GET_ALL_PROJECTS)
                .then()
                .log().body()
                .body("status", is(true))
                .body("result.entities[0].code", is("DEMO"))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void getProjectTest() {
        given()
                .when()
                .get(String.format(ProjectEndpoints.GET_PROJECT, projectCode))
                .then()
                .log().body()
                .body("result.code", is(projectCode))
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(dependsOnMethods = "getProjectTest")
    public void deleteProjectTest() {
        given()
                .when()
                .delete(String.format(ProjectEndpoints.DELETE_PROJECT, projectCode))
                .then()
                .log().body()
                .body("status", is(true))
                .statusCode(HttpStatus.SC_OK);
    }


    @Test
    public void getAllProjectsNegativeTest() {

        given()
                .when()
                .get(ProjectEndpoints.GET_ALL_PROJECTSWrong)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }

    @Test
    public void getAllProjectsSecondNegativeTest() {

        given()
                .when()
                .post(ProjectEndpoints.GET_ALL_PROJECTS)
                .then()
                .log().body()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }
}