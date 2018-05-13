package ru.esphere.tests.api;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import ru.esphere.data.api.ApiTestsData;

@Feature("API")
public class ApiTests extends BaseApiTest {
    private final String SEARCH_PATH = "task/search";
    private final String SEARCH_PARAM = "innOgrn";
    
    @Test(dataProviderClass = ApiTestsData.class, dataProvider = "searchForINN",
            description = "Поиск по ИНН")
    public void searchForINNTest(String innParam) {
        given().
                param(SEARCH_PARAM, innParam).
        when().
                get(SEARCH_PATH).
        then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("validator/schema-validate.json")).
                body("data.свЮЛ.инн", equalTo(innParam));
    }

    @Test(dataProviderClass = ApiTestsData.class, dataProvider = "searchForOGRN",
            description = "Поиск по ОГРН")
    public void searchForOGRNTest(String ogrnParama) {
        given().
                param(SEARCH_PARAM, ogrnParama).
        when().
                get(SEARCH_PATH).
        then().
                statusCode(200).
                body(matchesJsonSchemaInClasspath("validator/schema-validate.json")).
                body("data.свЮЛ.огрн", equalTo(ogrnParama));
    }
}
