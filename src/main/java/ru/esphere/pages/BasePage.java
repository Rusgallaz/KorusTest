package ru.esphere.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.esphere.util.Constants;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Step("Переносим курсор мыши к элементу")
    public void moveMouseTo(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
    }

    /**
     * Возвращает true, если нашелся хоть один элемент.
     */
    protected boolean isElementExist(By by) {
        boolean find;
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        find = !webDriver.findElements(by).isEmpty();
        webDriver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT, TimeUnit.SECONDS);
        return find;
    }

    protected void waitUntilClickable(WebElement webElement){
        WebDriverWait webDriverWait = new WebDriverWait(webDriver, 20);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
