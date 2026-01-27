package com.qa.opencart.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
    Properties properties = new Properties();

    public PropertiesFile() {
        try {
            properties.load(new FileInputStream("./src/test/resources/configFile.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String getPropertiesValue(String key) {
        return properties.getProperty(key);
    }

    public void setPropertiesValue(String key, String value) {
        properties.setProperty(key, value);
    }
}
