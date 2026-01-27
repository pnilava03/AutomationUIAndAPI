package com.qa.opencart.stepsDefinition;

import com.qa.opencart.driverManager.DriverFactory;
import com.qa.opencart.log.TestLogger;
import com.qa.opencart.pages.AccountPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.utils.PropertiesFile;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;



public class LoginStep {
    private LoginPage loginPage;
    private AccountPage accountPage;
    private final PropertiesFile propertiesFile= new PropertiesFile();
    @Given("I am on Opencart application")
    public void iAmOnOpencartApplication() {
        WebDriver driver = DriverFactory.getInstance(propertiesFile.getPropertiesValue("Browser")).getDriver();
        loginPage = new LoginPage(driver);
    }


    @When("I enter email {string}")
    public void i_enter_email(String userName) {
        TestLogger.log("Entering userName ...");
        loginPage.enterUserName(userName);
        TestLogger.log("UserName Entered Successfully .. userName is :: " + userName);

    }

    @When("I enter password {string}")
    public void i_enter_password(String passWord) {
        TestLogger.log("Entering Password ...");
        loginPage.enterPassword(passWord);
        TestLogger.log("Password Entered Successfully .. userName is :: " + passWord);

    }

    @When("I click on the Login button")
    public void i_click_on_the_login_button() throws InterruptedException {
        TestLogger.log("Clicking Login button ...");
        accountPage = loginPage.clickOnLoginButton();
        TestLogger.log("Clicked on Login button Successfully");
    }

    @Then("I should see the {string} page")
    public void i_should_see_the_page(String expectedResult) {
        TestLogger.log("Verifying application logged successfully ... ");
        String actualResult = accountPage.getPageTitle();
        TestLogger.log("Application logged successfully ... " + actualResult);

    }

    @Then("I should see an alert message {string}")
    public void iShouldSeeAnAlertMessage(String expectedError) {
        TestLogger.log("Verifying Alert message if password is wrong");
        String actualError = loginPage.alertMessage(expectedError);
        TestLogger.log("Successfully Verifying alert message if password is wrong ... " + actualError);
    }

}
