package ru.esphere.steps;

import io.qameta.allure.Step;
import org.testng.Assert;
import ru.esphere.tests.web.BaseWebTest;

public class BaseSteps{

    @Step("Сравниваем строки")
    protected void assertString(String expected, String actual){
        Assert.assertEquals(expected, actual);
    }
}
