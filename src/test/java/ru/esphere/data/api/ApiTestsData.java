package ru.esphere.data.api;

import org.testng.annotations.DataProvider;

public class ApiTestsData {

    @DataProvider(name = "searchForINN")
    public Object[][] searchForINN(){
        return new Object[][]{
                {"7703228474"}
        };
    }

    @DataProvider(name = "searchForOGRN")
    public Object[][] searchForOGRN(){
        return new Object[][]{
                {"1037739437966"}
        };
    }
}
