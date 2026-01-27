package com.qa.opencart.tests;


import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.utils.PropertiesFile;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    private final PropertiesFile propertiesFile= new PropertiesFile();
    @Test(priority = 0, alwaysRun = true,enabled = true)
    public void verifyApplicationURL_Title  (){
        TestLogger.log("Verifying Application URL and Application Title");
        TestLogger.log("Fetching the Application URL");
        String actualURL=loginPage.getCurrentURL(propertiesFile.getPropertiesValue("Application_URL"));
        TestLogger.log("Application URL is: " +actualURL);
        Assert.assertEquals(actualURL,propertiesFile.getPropertiesValue("Application_URL"));
        TestLogger.log("Fetching the Application Title ");
        String actualTitle=loginPage.getPageTitle();
        TestLogger.log("Application Title is :: " +actualTitle);
        Assert.assertEquals(actualTitle, AppConstant.LOGIN_PAGE_TITLE);
        TestLogger.log("Successfully verified Application URL and Application Title");
    }

    @Test(priority = 1, alwaysRun = true, enabled = true)
    public void isForgottenPasswordLinkPresent(){
        TestLogger.log("Verifying is Forgotten Password Link present ...");
       boolean b= loginPage.isForgotten_password_Link_Present();
       TestLogger.log("Successfully verifying Forgotten Password Link present:: "+b);
       Assert.assertTrue(b," Forgotten Password Link is not present");
    }

    @Test(priority = 2,alwaysRun = true, enabled = true)
    public void loginToApplication() throws InterruptedException {
        TestLogger.log("Logging to the application");
        TestLogger.log("Entering userName ...");
        loginPage.enterUserName("palnilava1930@gmail.com");
        TestLogger.log("UserName entered successfully ...");
        TestLogger.log("Entering the password");
        loginPage.enterPassword("admin");
        TestLogger.log("Password entered successfully ...");
        TestLogger.log("Clicking on login button ...");
        loginPage.clickOnLoginButton();
        TestLogger.log("Successfully clicked on login button ...");

    }
}
