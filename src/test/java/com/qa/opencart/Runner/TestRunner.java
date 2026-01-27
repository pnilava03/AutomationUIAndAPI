package com.qa.opencart.Runner;
import com.qa.opencart.utils.PropertiesFile;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

/**
 * This line for Junit
 */

//@Suite
//@SelectClasspathResource("features")
//@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.qa.opencart.stepsDefinition, com.qa.opencart.base")
//@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report.html")
//@ConfigurationParameter(key =FILTER_TAGS_PROPERTY_NAME, value = "@smoke or @negative")


@CucumberOptions(
        features = "./src/test/resources/features",
        glue = {"com.qa.opencart.stepsDefinition", "com.qa.opencart.base"},
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = " @account",
        monochrome = true)

@Listeners({ com.aventstack.chaintest.plugins.ChainTestListener.class })
public class TestRunner extends AbstractTestNGCucumberTests {
    private final PropertiesFile propertiesFile = new PropertiesFile();

    @Parameters({"browser"})
    @BeforeTest(alwaysRun = true)
    public void setUp(String browserName) {
            if(browserName!=null) {
                propertiesFile.setPropertiesValue("Browser", browserName);
            }

    }


}
