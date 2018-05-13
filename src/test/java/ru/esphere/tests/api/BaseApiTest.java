package ru.esphere.tests.api;

import io.restassured.RestAssured;
import org.testng.TestException;
import org.testng.annotations.*;
import ru.esphere.listener.ApiListener;
import ru.esphere.steps.BaseSteps;

@Listeners(ApiListener.class)
public class BaseApiTest extends BaseSteps {

    @Parameters({"baseHost", "basePath"})
    @BeforeMethod
    public void init(@Optional("") String baseHost, String basePath){
        if(baseHost.equals(""))
            throw new TestException("baseHost not set");

        RestAssured.baseURI = baseHost;
        RestAssured.basePath = basePath;
    }
}
