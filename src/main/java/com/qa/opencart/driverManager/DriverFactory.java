package com.qa.opencart.driverManager;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static final Logger logger = LogManager.getLogger(DriverFactory.class);
    private static volatile DriverFactory instance;
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

    //Create private constructor
    private DriverFactory() {
    }


    /**
     * Initializing the browser
     *
     * @param browser
     */
    private void init_Driver(String browser) {
        switch (browser.trim().toUpperCase()) {
            case "CHROME":
                if (tlDriver != null) {
                    logger.info("Initialize Chrome Browser");
                    tlDriver.set(new ChromeDriver());
                } else {
                    throw new NullPointerException("Local Thread driver is null ...");
                }
                break;

            case "FIREFOX":
                if (tlDriver != null) {
                    logger.info("Initialize FireFox Browser");
                    tlDriver.set(new FirefoxDriver());
                } else {
                    throw new NullPointerException("Local Thread driver is null ...");
                }
                break;

            case "EDGE":
                if (tlDriver != null) {
                    logger.info("Initialize Edge Browser");
                    tlDriver.set(new EdgeDriver());
                } else {
                    throw new NullPointerException("Local Thread driver is null ...");
                }
                break;

            case "IE":
                if (tlDriver != null) {
                    logger.info("Initialize Internet Explorer Browser");
                    tlDriver.set(new InternetExplorerDriver());
                } else {
                    throw new NullPointerException("Local Thread driver is null ...");
                }
                break;

            case "SAFARI":
                if (tlDriver != null) {
                    logger.info("Initialize Safari Browser");
                    tlDriver.set(new SafariDriver());
                } else {
                    throw new NullPointerException("Local Thread driver is null ...");
                }
                break;

            default:
                throw new IllegalArgumentException("Please provide proper browser name ...");
        }

        tlDriver.get().manage().window().maximize();
        tlDriver.get().manage().deleteAllCookies();
    }

    //Creating single tone method for DriverFactory class
    public static DriverFactory getInstance(String browser) {
        if (instance == null) {
            synchronized (DriverFactory.class) {
                if (instance == null) {
                    instance = new DriverFactory();
                }
            }
        }

        if (tlDriver.get() == null) {
            logger.info("Initializing the driver");
            instance.init_Driver(browser);
        }

        return instance;

    }

    //creating get driver
    public WebDriver getDriver() {
        return tlDriver.get();
    }


    public static void setDriver(WebDriver driver) {
        tlDriver.set(driver);
    }

    //Quit the browser
    public static void quitBrowser() {
        if (tlDriver.get() != null) {
            logger.info("Quit the browser");
            tlDriver.get().quit();
            tlDriver.remove();
        } else {
            System.out.println("Session Id is active ::" + tlDriver);
        }
    }
}

