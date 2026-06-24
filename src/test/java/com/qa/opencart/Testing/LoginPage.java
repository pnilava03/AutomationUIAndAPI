package com.qa.opencart.Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;
    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    private final By userName_Id=By.id("input-email");
    private final By password_id=By.id("input-password");
    private final By loginBttn_Xpath=By.xpath("//input[@type='submit']");
    private final By forgottenPassword_LinkText=By.linkText("Forgotten Password");

    public By getUserName_Id() {
        return userName_Id;
    }

    public By getPassword_id() {
        return password_id;
    }

    public By getLoginBttn_Xpath() {
        return loginBttn_Xpath;
    }

    public By getForgottenPassword_LinkText() {
        return forgottenPassword_LinkText;
    }
}
