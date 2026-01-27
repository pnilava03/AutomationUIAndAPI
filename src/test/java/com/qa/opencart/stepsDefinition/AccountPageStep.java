package com.qa.opencart.stepsDefinition;

import com.qa.opencart.driverManager.DriverFactory;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.PropertiesFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountPageStep {

    private LoginPage loginPage;
    private AccountPage accountPage;
    PropertiesFile propertiesFile = new PropertiesFile();


    @Given("I am logged into OpenCart with valid credentials")
    public void iAmLoggedIntoOpenCartWithValidCredentials(DataTable credentials) {
        loginPage = new LoginPage(DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver());
        java.util.List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
        String userName = data.getFirst().get("UserName");
        TestLogger.log("UserName is :: " + userName);
        String password = data.getFirst().get("Password");
        TestLogger.log("Password is :: " + password);
        accountPage = loginPage.loginToTheApplication(userName, password);


    }

    @Then("I should see the {string} page title")
    public void iShouldSeeThePageTitle(String expectedResult) {
        String actualResult = accountPage.getPageTitle();
        Assert.assertEquals(actualResult, expectedResult);
    }


    @Then("I should see {string} header section")
    public void iShouldSeeHeaderSection(String expectedResult) {
        String actualResult = accountPage.getMyAccountHeaderText(expectedResult);
        TestLogger.log("Actual Header is:: " + actualResult);
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Then("I should see {string} link")
    public void iShouldSeeLink(String expectedLinks) {
        List<String> list = accountPage.getLinkFromMyAccountHeader(expectedLinks);
        ArrayList<String> arrayList= new ArrayList<String>();
        arrayList.addAll(list);

        TestLogger.log("Links are verified Successfully :: "+expectedLinks);

    }
}
