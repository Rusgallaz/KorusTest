package ru.esphere.tests.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.ITestResult;
import org.testng.TestException;
import org.testng.TestListenerAdapter;
import org.testng.annotations.*;
import ru.esphere.steps.BaseSteps;
import ru.esphere.util.Constants;
import ru.esphere.util.Screenshot;
import ru.esphere.util.WebDriverFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BaseWebTest extends BaseSteps {
    protected WebDriver webDriver;
    protected String homeUrl;

    @Parameters({"browser", "url"})
    @BeforeMethod
    public void init(@Optional("") String browser, String url) throws TestException {
        homeUrl = url;

        if (browser.equals(""))
            throw new TestException("browser not set");

        webDriver = WebDriverFactory.getWebDriver(browser);

        if (webDriver == null)
            throw new TestException("browser" + browser + " not found");

        webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethodBaseTest(ITestResult iTestResult) throws IOException {
        if (webDriver != null) {

            if (ITestResult.FAILURE == iTestResult.getStatus()) {
                Screenshot.takeScreenshot(webDriver);
            }

            quitWebDriver();
        }
    }

    //У оперы баг и метод quit не закрывает браузер
    private void quitWebDriver() throws IOException {
        if (webDriver instanceof OperaDriver) {
            Runtime.getRuntime().exec("taskkill /f /im opera.exe");
        } else {
            webDriver.quit();
        }

    }
}
