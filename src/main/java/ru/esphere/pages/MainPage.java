package ru.esphere.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(id = "hplogo")
    private WebElement logoImage;

    @FindBy(id = "lst-ib")
    private WebElement inputTextArea;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(name = "btnI")
    private WebElement luckBtn;

    public MainPage(WebDriver webDriver){
        super(webDriver);

        PageFactory.initElements(webDriver, this);
    }

    @Step("Вводим текст в input поле")
    public MainPage inputText(String text){
        inputTextArea.clear();
        inputTextArea.sendKeys(text);
        return this;
    }

    @Step("Жмем на кнопку поиска")
    public MainPage searchBtnClick(){
        searchBtn.submit();
        return this;
    }

    public String getTooltipInputTextArea(){
        return inputTextArea.getAttribute("title");
    }

    public WebElement getInputTextArea() {
        return inputTextArea;
    }

    public boolean tryFindElementWithResults(){
        return isElementExist(By.id("res"));
    }
}
