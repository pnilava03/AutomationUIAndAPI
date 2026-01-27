package com.qa.opencart.utils;

import com.qa.opencart.driverManager.DriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ReportsUtil {
    private static final Logger logger= LogManager.getLogger(ReportsUtil.class);
    private static final PropertiesFile propertiesFile = new PropertiesFile();

    public static File takeScreenshotAs() {
        logger.info("Taking screenshot ...");
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        if (driver == null){ return null;}
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    }

    public static byte[] takeScreenshotAsByte() {
        logger.info("Taking screenshot in bytes ... ");
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        if (driver == null){
            return null;
        }
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public static String takeScreenshotAsBase64(){
            logger.info("Taking screenshot in Base64 ... ");
            WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
            if(driver==null ){
                return null;
            }
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }
}
