package com.qa.opencart.base;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.driverManager.DriverFactory;
import com.qa.opencart.enums.EnvironmentType;
import com.qa.opencart.exceptions.EnvironmentException;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.PropertiesFile;
import com.qa.opencart.utils.ReportsUtil;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Hooks {

    private static final Logger logger = LogManager.getLogger(Hooks.class);
    private final PropertiesFile propertiesFile = new PropertiesFile();


    @Before(order = 0)
    public void setUp() {
        logger.info("Browser: {}", propertiesFile.getPropertiesValue("Browser"));
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        DriverFactory.setDriver(driver);

        String env = propertiesFile.getPropertiesValue("EnvType").trim();
        logger.info("EnvType: {}", env);

        if (env.equalsIgnoreCase(EnvironmentType.DEV.toString())
                || env.equalsIgnoreCase(EnvironmentType.QA.toString())
                || env.equalsIgnoreCase(EnvironmentType.PROD.toString())) {
            driver.get(propertiesFile.getPropertiesValue("Application_URL"));
        } else {
            throw new EnvironmentException("Environment not found ...");
        }
    }

    @After(order = 0)
    public void tearDown(Scenario scenario) {
        if (scenario.getStatus() == Status.PASSED) {
            TestLogger.log("Attaching screenshot to ChainTest...");
            byte[] bytes = ReportsUtil.takeScreenshotAsByte();
            if (bytes != null) {
                ChainTestListener.embed(bytes, "image/png");

            }

        }else{
            if(scenario.getStatus()==Status.FAILED){
                TestLogger.log("Attaching screenshot to ChainTest...");

                byte[] bytes = ReportsUtil.takeScreenshotAsByte();
                if (bytes != null) {
                    ChainTestListener.embed(bytes, "image/png");
                }
            }
        }
        logger.info("Quiting the browser ....");
        DriverFactory.quitBrowser();
    }


    }

