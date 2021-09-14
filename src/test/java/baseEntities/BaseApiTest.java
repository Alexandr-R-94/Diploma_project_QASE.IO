package baseEntities;

import core.ReadProperties;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import models.ProjectBuilder;
import org.apache.http.protocol.HTTP;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import utils.Listener;

import static io.restassured.RestAssured.given;

@Listeners(Listener.class)
public abstract class BaseApiTest {
    protected ReadProperties properties;


@BeforeTest
    public void setupRestAssured() {


    properties = ReadProperties.getInstance();

    RestAssured.baseURI = ReadProperties.getInstance().getApiURL();

    RestAssured.requestSpecification = given()
            .header(HTTP.CONTENT_TYPE, ContentType.JSON)
            .header("Token", properties.getToken())
            .auth().oauth2(properties.getToken());


}
}
