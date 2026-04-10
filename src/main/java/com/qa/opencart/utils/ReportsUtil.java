package com.qa.opencart.utils;

import com.qa.opencart.driverManager.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;

public class ReportsUtil {
    private static final Logger logger = LogManager.getLogger(ReportsUtil.class);
    private static final PropertiesFile propertiesFile = new PropertiesFile();

    public static File takeScreenshotAs() {
        logger.info("Taking screenshot ...");
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        if (driver == null) {
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static byte[] takeScreenshotAsByte() {
        logger.info("Taking screenshot in bytes ... ");
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        if (driver == null) {
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String takeScreenshotAsBase64() {
        logger.info("Taking screenshot in Base64 ... ");
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        if (driver == null) {
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }


    public static void getElementScreenshotAs(WebElement element, String fileName) {
        File src = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("./target/screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void takeElementScreenShots(WebElement element, String fileName) {
        File srcFile = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
        File destFile = new File("./target/screenshots/" + fileName + ".png");
        try {
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
