package tests.api;

import adapters.ProjectAdapter;
import baseEntities.BaseApiTest;
import endpoints.ProjectEndpoints;
import io.restassured.mapper.ObjectMapperType;
import models.ProjectAPI;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class APITests extends BaseApiTest {
    private String projectCode;

    @Test
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

    @Test
    public void getAllProjectsTest() {
        ProjectAPI projectAPI = new ProjectAdapter().getAllProjects();

        System.out.println(projectAPI);
    }

    @Test(dependsOnMethods = "addProjectTest")
    public void getProjectTest() {
        ProjectAPI projectAPI = new ProjectAdapter().getProject(projectCode);

        System.out.println(projectAPI);
    }

    @Test(dependsOnMethods = "getProjectTest")
    public void deleteProjectTest() {
        ProjectAPI projectAPI = new ProjectAdapter().deleteProject(projectCode);

        System.out.println(projectAPI);

//        given()
//                .when()
//                .delete(String.format(ProjectEndpoints.DELETE_PROJECT, projectCode))
//                .then()
//                .log().body()
//                .body("status", is(true))
//                .statusCode(HttpStatus.SC_OK);
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