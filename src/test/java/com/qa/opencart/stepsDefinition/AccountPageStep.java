package com.qa.opencart.stepsDefinition;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.driverManager.DriverFactory;
import com.qa.opencart.exceptions.NoHeaderFoundExceptions;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.PropertiesFile;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AccountPageStep {

    private LoginPage loginPage;
    private AccountPage accountPage;
    PropertiesFile propertiesFile = new PropertiesFile();
    String actualResult;



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
    public String iShouldSeeHeaderSection(String expectedResult) {
        actualResult = accountPage.getMyAccountHeaderText(expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
        TestLogger.log("Actual Header is:: " + actualResult);
        return actualResult;

    }

    @Then("I should see {string} link")
    public void iShouldSeeLink(String expectedLinks) {
        TestLogger.log("Verifying All links under the " + actualResult + " Header");

        switch (actualResult) {
            case AppConstant.MY_ACCOUNT_HEADER:
                List<String> expectedList = AppConstant.MYACCOUNT_HEADER_LINKS_LIST;
                List<String> actualList = accountPage.getLinkFromMyAccountHeader(actualResult, expectedLinks);
                Assert.assertEquals(actualList, expectedList);
                TestLogger.log("All actual links " + actualList + " are Successfully verified");
                break;

            case AppConstant.MY_ORDERS_HEADER:
                List<String> expectedOrdersList = AppConstant.MYORDERS_HEADER_LINK_LIST;
                List<String> actualOrdersList = accountPage.getLinkFromMyAccountHeader(actualResult, expectedLinks);
                Assert.assertEquals(actualOrdersList, expectedOrdersList);
                TestLogger.log("All actual links " + actualOrdersList + " are Successfully verified");
                break;


            case AppConstant.MY_AFFILIATE_ACCOUNT_HEADER:
                List<String> expectedAffiliatedList = AppConstant.MY_AFFILIATE_HEADER_LINK_LIST;
                List<String> actualAffiliatedList = accountPage.getLinkFromMyAccountHeader(actualResult, expectedLinks);
                Assert.assertEquals(actualAffiliatedList, expectedAffiliatedList);
                TestLogger.log("All actual links " + actualAffiliatedList + " are Successfully verified");
                break;

            case AppConstant.NEWSLETTER_HEADER:
                List<String> expectedNewsletterList = AppConstant.NEWSLETTER_HEADER_LINK_LIST;
                List<String> actualNewsletterList = accountPage.getLinkFromMyAccountHeader(actualResult, expectedLinks);
                Assert.assertEquals(actualNewsletterList, expectedNewsletterList);
                TestLogger.log("All actual links " + actualNewsletterList + " are Successfully verified");
                break;

            default:
                throw new NoHeaderFoundExceptions("Header not found exceptions");
        }

    }

    @Then("I should see All links")
    public void iShouldSeeAllLinks(DataTable listOfLinks) {
        List<String> list = accountPage.getAllLinksFromMyAccountPage();
        ArrayList<String> expectedList = new ArrayList<>(listOfLinks.asList());
        ArrayList<String> actualList = new ArrayList<>(list);
        Assert.assertEquals(actualList.size(), expectedList.size());
        TestLogger.log("Expected List size :" + expectedList.size() + " And Actual List Size :" + actualList.size());
        TestLogger.log("Verified ActualLinks and ExpectedLinks from Account Page" + actualList + " \n" + expectedList);

    }
}
