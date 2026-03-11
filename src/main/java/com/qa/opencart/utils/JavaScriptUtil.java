package com.qa.opencart.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class JavaScriptUtil {
	
	private WebDriver driver;
	private JavascriptExecutor js;
	
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)this.driver;
	}
	
	public void scrollPageDown() {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}

	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}
	
	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

    public void highLightElement(WebElement element, String color){
       js.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
    }

    public void highLightElement(WebElement element){
        js.executeScript("arguments[0].style.border='3px solid green'", element);
    }


    public void clickOnElementJs(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("argument.click();",element);

    }

    public Object getDomainName(){
        return js.executeScript("return document.domain");
    }


    // Send value using JavaScript
    public void sendKeysUsingJS(WebElement element, String value) {
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }


    // Set value using JavaScript
    public void setValueUsingJS(WebElement element, String value) {
        js.executeScript("arguments[0].value=arguments[1];", element, value);
    }

    public void setAttributeUsingJS(WebElement element, String attributeName, String value) {
        js.executeScript("arguments[0].setAttribute(arguments[1], arguments[2]);", element, attributeName, value);
    }

    public String getPageTitleByJS() {
        return js.executeScript("return document.title;").toString();
    }

    public String getPageURLByJS() {
        return js.executeScript("return document.URL;").toString();
    }

    public String getInnerText() {
        return js.executeScript("return document.documentElement.innerText;").toString();
    }

    public void scrollToElement(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void scrollToElementCenter(WebElement element) {
        js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element);
    }


    public void scrollByPixel(int x, int y) {
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }


    public void refreshBrowserByJS() {
        js.executeScript("history.go(0);");
    }

    public void navigateBackByJS() {
        js.executeScript("history.back();");
    }

    public void navigateForwardByJS() {
        js.executeScript("history.forward();");
    }

    public void drawBorder(WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red';", element);
    }
    public void changeBackgroundColor(WebElement element, String color) {
        js.executeScript("arguments[0].style.backgroundColor=arguments[1];", element, color);
    }


    public void highlightElement(WebElement element) {
        drawBorder(element);
        changeBackgroundColor(element, "yellow");
    }


    public void flashElement(WebElement element) {
        String originalColor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 5; i++) {
            changeBackgroundColor(element, "rgb(255,255,0)");
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            changeBackgroundColor(element, originalColor);
            try {
                sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void zoomPage(String percentage) {
        js.executeScript("document.body.style.zoom=arguments[0];", percentage);
    }


    public void clickHiddenElementByJS(WebElement element) {
        js.executeScript("arguments[0].click();", element);
    }

}
