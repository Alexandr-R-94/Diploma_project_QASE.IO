package adapters;

import baseEntities.BaseAdapter;
import endpoints.ProjectEndpoints;
import io.restassured.response.Response;
import models.ProjectAPI;
import org.apache.http.HttpStatus;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProjectAdapter extends BaseAdapter {

    public ProjectAPI getAllProjects() {
        Response response = given()
                .when()
                .get(ProjectEndpoints.GET_ALL_PROJECTS)
                .then()
                .log().body()
                .body("status", is(true))
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return gson.fromJson(response.asString().trim(), ProjectAPI.class);
    }

    public ProjectAPI getProject(String projectCode) {

        Response response = given()
                .when()
                .get(String.format(ProjectEndpoints.GET_PROJECT, projectCode))
                .then()
                .log().body()
                .body("result.code", is(projectCode))
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return gson.fromJson(response.asString().trim(), ProjectAPI.class);
    }

    public ProjectAPI deleteProject(String projectCode) {
        Response response = given()
                .when()
                .delete(String.format(ProjectEndpoints.DELETE_PROJECT, projectCode))
                .then()
                .log().body()
                .body("status", is(true))
                .statusCode(HttpStatus.SC_OK)
                .extract().response();

        return gson.fromJson(response.asString().trim(), ProjectAPI.class);
    }
}
