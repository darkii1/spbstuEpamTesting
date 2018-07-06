package com.spbstu.lab4.allure;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import ru.yandex.qatools.allure.annotations.Attachment;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Allure extends TestListenerAdapter{


    @Attachment
    public byte[] makeScreenshot() {
        byte[] array = {1};
        try {
            return ((TakesScreenshot) getWebDriver()).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
        return array;
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshot();
    }

    @Override
    public void  onTestSuccess(ITestResult iTestResult) {
        makeScreenshot();
    }

}