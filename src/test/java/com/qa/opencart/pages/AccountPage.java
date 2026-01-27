package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private final By list_group_Xpath = By.xpath("//div[@class='list-group']/a");
    private final By header_Xpath = By.xpath("//div[@id='content']/h2");


    public String getPageTitle() {
        return elementUtil.waitForTitleIs(AppConstant.ACCOUNT_PAGE_TITLE, AppConstant.LONG_TIME_OUT);

    }

    public int getListGroup_Count() {
        return elementUtil.getElementsCount(list_group_Xpath);
    }

    //verifying the table
    public List<String> getList_Group() {
        return elementUtil.getElementTextList(list_group_Xpath);

    }

    public List<String> getHeaderList() {
        return elementUtil.getElementTextList(header_Xpath);
    }

    public String getMyAccountHeaderText(String accountPageHeader) {
        return elementUtil.doElementGetText(By.xpath("//div[@id='content']/h2[text()='"+accountPageHeader   +"']"));

    }

    public List<String> getLinkFromMyAccountHeader(String expectedResult) {
        return elementUtil.getElementTextList(elementUtil.getBy("XPATH", "//div[@id='content']/h2[text()='My Account']/following-sibling::ul[1]/li/a"));



    }

}



