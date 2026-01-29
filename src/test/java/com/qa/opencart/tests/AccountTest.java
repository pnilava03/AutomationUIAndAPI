package com.qa.opencart.tests;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.utils.PropertiesFile;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class AccountTest extends BaseTest {

    @BeforeClass
    public void loginToTheApplication() {
        TestLogger.log("Logging to the Application");
        accountPage = loginPage.loginToTheApplication("palnilava1930@gmail.com", "admin");
        TestLogger.log("Successfully logging to the Application");
    }

    @Test(priority = 0, enabled = true, alwaysRun = true)
    public void verifyAccountPageTitle() {
        TestLogger.log("Verifying Account Page Title ...");
        String actualTitle = accountPage.getPageTitle();
        TestLogger.log("Successfully verified Account Title :: " + actualTitle);
        Assert.assertEquals(actualTitle, AppConstant.ACCOUNT_PAGE_TITLE);
    }

    @Test(priority = 1, enabled = true, alwaysRun = true)
    public void verifyListGroupCount() {
        TestLogger.log("Verifying List Group count from Account Page ...");
        int count = accountPage.getListGroup_Count();
        TestLogger.log("Successfully verified List Group count from Account Page ::" + count);
    }

    @Test(priority = 2, enabled = true, alwaysRun = true)
    public void verifyListGroupTextValue() {
        TestLogger.log("Verifying List Group Text value from Account Page ...");
        List<String> list= accountPage.getList_Group();
        for (String s : list) {
            TestLogger.log("List group Text values are :: " + s);
        }
    }

    @Test(priority = 3, enabled = true, alwaysRun = true)
    public void verifyHeaderListText(){
        TestLogger.log("Verifying List of header from Account Page ....");
        List<String> list=accountPage.getHeaderList();
        for(String actualTextValue: list){
            TestLogger.log("Actual text headers are: "+actualTextValue);
        }
    }

}
