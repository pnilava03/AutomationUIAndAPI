package com.qa.opencart.pages;

import com.qa.opencart.constants.AppConstant;
import com.qa.opencart.utils.ElementUtil;
import io.cucumber.java.bs.A;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AccountPage {

    WebDriver driver;
    ElementUtil elementUtil;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
        elementUtil = new ElementUtil(driver);
    }

    private final By list_group_Xpath = By.xpath("//div[@class='list-group']/a");
    private final By header_Xpath = By.xpath("//div[@id='content']/div/h2");
    private final By listOfLinksOnAccountPage_Xpath = By.xpath("//div[@class='list-group mb-3']/a");
    private final By menu_Links=By.xpath("//ul[@class='navbar-nav horizontal']/li/a/div/span");

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
        By headerXpath = By.xpath("//div[@id='content']/div/h2[text()='" + accountPageHeader + "']");
        elementUtil.waitForElementVisible(headerXpath, 10);
        return elementUtil.doElementGetText(headerXpath);

    }

    public List<String> getLinkFromMyAccountHeader(String accountPageHeader, String expectedResult) {
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> elementList = elementUtil.getElements(By.xpath("//div[@id='content']/div/h2[text()='"+getMyAccountHeaderText(accountPageHeader)+"']/following-sibling::div/div/div/a"));
        for (WebElement webElement : elementList) {
            arrayList.add(webElement.getText());
        }

        String myAffiliateHeaderText=elementUtil.doElementGetText(By.xpath("//div[@id='content']/div/h2[text()='My Affiliate Account']"));

        if(myAffiliateHeaderText.equals(accountPageHeader)){
            elementList = elementUtil.getElements(By.xpath("//div[@id='content']/div/h2[text()='"+getMyAccountHeaderText(accountPageHeader)+"']/following-sibling::div/a"));
            for (WebElement webElement : elementList) {
                arrayList.add(webElement.getText());
            }
        }

        return arrayList;
    }

    public List<String> getAllLinksFromMyAccountPage() {
        elementUtil.waitForElementVisible(listOfLinksOnAccountPage_Xpath,10);
        driver.navigate().refresh();
        ArrayList<String> arrayList = new ArrayList<>();
        List<WebElement> listOfElements = elementUtil.getElements(listOfLinksOnAccountPage_Xpath);
        for (WebElement element : listOfElements) {
            arrayList.add(element.getText());
        }

        return arrayList;
    }

    public List<String> getAllMenuLinks(){
      List<WebElement> webList=  elementUtil.getElements(menu_Links);
      ArrayList<String> arrayList= new ArrayList<>();
      for(int i=0;i<webList.size();i++){
          arrayList.add(webList.get(i).getText());
      }

      return arrayList;
    }

}



