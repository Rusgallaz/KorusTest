package ru.esphere.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;

public class WebDriverFactory {

    public static final String BROWSER_CHROME = "Chrome";
    public static final String BROWSER_FIREFOX = "Firefox";
    public static final String BROWSER_IE = "IE";
    public static final String BROWSER_OPERA = "Opera";

    /**
     * Возвращает WebDriver в завимсимости от указанного браузера
     *
     * @param browser (Chrome, Firefox, Opera)
     * @return WebDriver or null
     */
    public static WebDriver getWebDriver(String browser) {
        WebDriver webDriver = null;

        switch (browser) {
            case BROWSER_CHROME:
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
                break;
            case BROWSER_FIREFOX:
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            case BROWSER_OPERA:
                WebDriverManager.operadriver().setup();
                OperaOptions operaOptions = new OperaOptions();
                operaOptions.setBinary(System.getProperty("opera.binary"));
                webDriver = new OperaDriver(operaOptions);
                break;
        }

        return webDriver;
    }
}
