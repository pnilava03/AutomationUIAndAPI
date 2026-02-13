package com.qa.opencart.driverManager;

import com.qa.opencart.utils.PropertiesFile;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionManager {

    private final PropertiesFile propertiesFile;


    public OptionManager(PropertiesFile propertiesFile) {
        this.propertiesFile = propertiesFile;
    }


    public ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (Boolean.parseBoolean(propertiesFile.getPropertiesValue("headless"))) {
            chromeOptions.addArguments("--headless=new");
        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("incognito"))){
            chromeOptions.addArguments("--incognito");
        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("remote"))){
            chromeOptions.setCapability("browserName","chrome");
        }

        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-notifications");

        return chromeOptions;

    }

    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (Boolean.parseBoolean(propertiesFile.getPropertiesValue("headless"))) {
            firefoxOptions.addArguments("--headless");

        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("incognito"))){
            firefoxOptions.addArguments("--incognito");
        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("remote"))){
            firefoxOptions.setCapability("browserName","firefox");
        }

        return firefoxOptions;
    }


    public EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (Boolean.parseBoolean(propertiesFile.getPropertiesValue("headless"))) {
            edgeOptions.addArguments("--headless");

        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("incognito"))){
            edgeOptions.addArguments("--Inprivate");
        }

        if(Boolean.parseBoolean(propertiesFile.getPropertiesValue("remote"))){
            edgeOptions.setCapability("browserName","edge");
        }

        return edgeOptions;


    }
}
