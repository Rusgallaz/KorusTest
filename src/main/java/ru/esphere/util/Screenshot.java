package ru.esphere.util;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {

    @Attachment(value = "Screenshot after fail test", type = "image/png")
    public static byte[] takeScreenshot(WebDriver webDriver){
        TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
        byte[] png = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        return png;
    }
}
