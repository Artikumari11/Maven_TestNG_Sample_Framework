package com.businessKeeper.util;

import com.businessKeeper.base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;

public class TestUtil extends BaseTest {

    public static void takeFullPageScreenshot() throws IOException {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        String testName=stackTraceElements[2].getMethodName();
        String testCaseName=stackTraceElements[3].getClassName();
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String currentDir = System.getProperty("user.dir");
        FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + "/"+testCaseName+"/" +System.currentTimeMillis()+ "_" + testName + ".png"));
    }

    public static String getTextByValue(WebElement element) {
        return element.getAttribute("value");

    }

    public static WebElement  WaitUntilElementIsVisible(WebElement element , int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        return wait.until(
                ExpectedConditions.visibilityOf(element));
    }

    public static void scrollThenClick(WebElement element) {

        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView()", element);
        executor.executeScript("arguments[0].click()", element);
    }
}
