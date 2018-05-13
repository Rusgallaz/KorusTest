package ru.esphere.data.web;

import org.testng.annotations.DataProvider;

public class SearchTestsData {

    @DataProvider(name = "searchFIO")
    public Object[][] searchFIO(){
        return new Object[][]{
                {"Галлямов Руслан Азатович", "Галлямов Руслан Азатович ИНН: 027614511901 - реквизиты ...",
                "https://www.kartoteka.ru/card/9f3d8e7e6fb6c3c67df4cac4566a5568/"}
        };
    }
}
