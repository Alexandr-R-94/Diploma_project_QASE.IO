package baseEntities;


import core.BrowsersService;
import core.ReadProperties;
import models.LoginBuilder;
import models.ProjectBuilder;
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

    @BeforeSuite
    public void date1(){
        loginBuilder = LoginBuilder.builder()
                .username("bestwarlock94@gmail.com")
                .password("T@D_2Fk7Kt8Qp5q")
                .build();
    }

    @BeforeSuite
    public void date2(){
        projectBuilder = ProjectBuilder.builder()
                .projectName("sergey")
                .projectCode("111")
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