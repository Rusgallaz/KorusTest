package ru.esphere.tests.web;

import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.esphere.data.web.SearchTestsData;
import ru.esphere.pages.MainPage;
import ru.esphere.pages.ResultsPage;
import ru.esphere.steps.BaseSteps;

@Feature("Search")
public class SearchTests extends BaseWebTest {
    private MainPage mainPage;
    private ResultsPage resultsPage;

    @BeforeMethod
    public void beforeSearchTests() {
        webDriver.get(homeUrl);
        mainPage = new MainPage(webDriver);
        resultsPage = new ResultsPage(webDriver);
    }

    /*Не понял, что подразумевать под валидным поиском, поэтому проверю содержимое первого результата
    (без проблем масштабиурется до проверки всех результатов).*/
    @Test(dataProviderClass = SearchTestsData.class, dataProvider = "searchFIO",
            description = "Поиск по ФИО и проверка первого результата")
    public void searchFIOTest(String FIO, String expectedTitle, String expectedLink) {
        //Вводим ФИО в поиск и жмем поиск
        mainPage.inputText(FIO).searchBtnClick();

        //Проверка текста из input поля
        assertString(FIO, resultsPage.getTextFormInputTextArea());

        //Проверяем заголовок и линк первого результата
        assertString(expectedTitle, resultsPage.getResultTitle(0));
        assertString(expectedLink, resultsPage.getResultLink(0));
    }

    @Parameters({"tooltipSearch"})
    @Test(description = "Всплывающая подсказка при наведении курсора на поле ввода")
    public void popUpHintTest(@Optional("Поиск") String tooltipSearch) {
        /*Т.к. новые элементы, после наведения курсора на поле ввода, не появляются, а значение подсказки можно
        прочитать в title, то эмулировать движение мыши на поле ввода я не стал. Но такую возможность все равно добавил
        в BasePage*/
        assertString(tooltipSearch, mainPage.getTooltipInputTextArea());
    }

    @Test(description = "Пустая область результатов после нажатия на лого")
    public void EmptyResultsAfterLogoClick() {
        //Переходим на страницу с результатами поиска
        mainPage.inputText("test").searchBtnClick();

        //Кликаем на лого в верхнем левом углу
        resultsPage.logoClick();

        /*Не знаю, что подразумевается под пустой областью результатов, если нас перекидывает назад на главную страницу,
        поэтому просто проверю, что нету дива который присутсвует на странице с результатами.*/
        Assert.assertFalse(mainPage.tryFindElementWithResults(), "Нашелся элемент с результатами поиска");
    }


}
