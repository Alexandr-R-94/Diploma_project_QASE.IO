package baseEntities;

import core.BrowsersService;
import core.ReadProperties;
import models.LoginBuilder;
import models.ProjectBuilder;
import models.ProjectBuilderError;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {
    public BrowsersService browsersService;
    protected ReadProperties properties;
    protected final Logger logger = LogManager.getLogger(this);
    protected LoginBuilder loginBuilder;
    protected ProjectBuilder projectBuilder;
    protected ProjectBuilderError projectBuilderError;

    @BeforeSuite
    public void LoginDate(){
        loginBuilder = LoginBuilder.builder()
                .username("bestwarlock94@gmail.com")
                .password("T@D_2Fk7Kt8Qp5q")
                .build();
    }

    @BeforeSuite
    public void correctDate(){
        projectBuilder = ProjectBuilder.builder()
                .projectName("sergey")
                .projectCode("123")
                .description("sergey")
                .build();
    }

    @BeforeSuite
    public void inCorrectDate(){
        projectBuilderError = ProjectBuilderError.builder()
                .projectName("sergey")
                .incorrectProjectCode("1")
                .description("sergey")
                .build();
    }

    @BeforeTest
    public void setupTest() {
        properties = ReadProperties.getInstance();
    }

    @BeforeMethod
    public void startBrowser() {
        browsersService = new BrowsersService();
    }

    @AfterMethod
    public void closeBrowser() {
        browsersService.getDriver().quit();
        browsersService = null;
    }

}