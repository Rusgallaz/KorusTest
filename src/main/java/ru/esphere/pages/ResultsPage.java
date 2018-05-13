package ru.esphere.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage extends BasePage{

    @FindBy(id = "logo")
    private WebElement logoElement;

    @FindBy(id = "lst-ib")
    private WebElement inputTextArea;

    @FindBy(name = "btnG")
    private WebElement searchBtn;

    @FindBy(css = "h3.r > a")
    private List<WebElement> resultsList;

    public ResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    /**
     *
     * @param index Отсчет с 0
     * @return String or null
     */
    public String getResultTitle(int index){
        if(index > resultsList.size()){
            return null;
        }
        return resultsList.get(index).getText();
    }

    /**
     *
     * @param index Отсчет с 0
     * @return String or null
     */
    public String getResultLink(int index){
        if(index > resultsList.size()){
            return null;
        }
        return resultsList.get(index).getAttribute("href");
    }

    public String getTextFormInputTextArea(){
        return inputTextArea.getAttribute("value");
    }

    public ResultsPage logoClick(){
        waitUntilClickable(logoElement);
        logoElement.click();
        return this;
    }
}
