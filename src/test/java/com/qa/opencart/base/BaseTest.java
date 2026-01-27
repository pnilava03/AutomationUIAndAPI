package com.qa.opencart.base;

import com.aventstack.chaintest.plugins.ChainTestListener;
import com.qa.opencart.driverManager.DriverFactory;
import com.qa.opencart.enums.EnvironmentType;
import com.qa.opencart.exceptions.EnvironmentException;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.PropertiesFile;
import com.qa.opencart.utils.ReportsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

@Listeners(ChainTestListener.class)
public class BaseTest {

    private static final Logger logger = LogManager.getLogger(BaseTest.class);
    private final PropertiesFile propertiesFile = new PropertiesFile();
    protected LoginPage loginPage;
    protected AccountPage accountPage;

    WebDriver driver;

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browserName) {

        if (browserName != null) {
            propertiesFile.setPropertiesValue("Browser", browserName);
        }
        logger.info("Fetching Browser Name from Properties file ... {}", propertiesFile.getPropertiesValue("Browser"));

        driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        logger.info("Fetching Env type from properties file ... {}", propertiesFile.getPropertiesValue("EnvType"));
        if (propertiesFile.getPropertiesValue("EnvType").trim().toLowerCase().equalsIgnoreCase(EnvironmentType.DEV.toString())) {
            driver.get(propertiesFile.getPropertiesValue("Application_URL"));
        } else if (propertiesFile.getPropertiesValue("EnvType").trim().toLowerCase().equalsIgnoreCase(EnvironmentType.QA.toString())) {
            driver.get(propertiesFile.getPropertiesValue("Application_URL"));
        } else if (propertiesFile.getPropertiesValue("EnvType").trim().toLowerCase().equalsIgnoreCase(EnvironmentType.PROD.toString())) {
            driver.get(propertiesFile.getPropertiesValue("Application_URL"));
        } else {
            throw new EnvironmentException("Environment not found ...");
        }

        loginPage = new LoginPage(driver);

    }

    @AfterMethod
    public void takeScreenshotAs(ITestResult result) {

        if (result.isSuccess()) {
            logger.info("Taking screenshot ...");
            ChainTestListener.embed(ReportsUtil.takeScreenshotAsBase64(), "image/png");
        } else {
            ChainTestListener.embed(ReportsUtil.takeScreenshotAsBase64(), "image/png");
        }
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        logger.info("Quiting the browser ....");
        DriverFactory.quitBrowser();
        logger.info("++++++++++++++++++++++++ Browser Quit successfully ++++++++++++++++++++++++ ");

    }
}
