package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;
import com.qa.opencart.utils.JavaScriptUtil;
import com.qa.opencart.utils.ReportsUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

   private final WebDriver driver;
   private final ElementUtil elementUtil;
   private final JavaScriptUtil javaScriptUtil;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        elementUtil= new ElementUtil(driver);
        javaScriptUtil= new JavaScriptUtil(driver);
    }


    private final By userName_Id=By.id("input-email");
    private final By password_Id=By.id("input-password");
    private final By forgotten_password_LinkText=By.linkText("Forgotten Password");
    private final By loginButton_Xpath=By.xpath("//input[@type='submit']");
    private final By alertMessage_Xpath=By.xpath("//div[@class='alert alert-danger alert-dismissible']/i");
    private final By accountLogin_Id=By.id("account-login");

    public String getPageTitle(){
      return elementUtil.waitForTitleIs("Account Login", AppConstant.LONG_TIME_OUT);

    }

    public String getCurrentURL(String url){
        return elementUtil.waitForURLIs(url,AppConstant.DEFAULT_TIME_OUT);
    }

    public boolean isForgotten_password_Link_Present(){
        return elementUtil.isElementDisplayed(forgotten_password_LinkText);
    }

    public void enterUserName(String userName){
        elementUtil.doSendKeys(userName_Id,userName);

    }

    public void enterPassword(String passWord){
        elementUtil.doSendKeys(password_Id,passWord);


    }

    public AccountPage clickOnLoginButton() {
     //   getScreenshotsForElement();
        elementUtil.doClick(loginButton_Xpath);
        return new AccountPage(driver);
    }

    public AccountPage loginToTheApplication(String userName, String passWord){
       // getScreenshotsForElement();
        elementUtil.doSendKeys(userName_Id,userName);
        elementUtil.doSendKeys(password_Id,passWord);
        elementUtil.doClick(loginButton_Xpath);
        return  new AccountPage(driver);
    }

    public String alertMessage(String str){
        elementUtil.waitForElementVisible(alertMessage_Xpath,30);
         return  elementUtil.doElementGetText(alertMessage_Xpath);
    }


    //This method is for element screenshot check
//        private void getScreenshotsForElement(){
//        WebElement element=elementUtil.getElement(accountLogin_Id);

 //   }





}
