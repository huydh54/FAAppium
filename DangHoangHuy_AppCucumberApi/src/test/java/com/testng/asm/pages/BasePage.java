package com.testng.asm.pages;

import com.testng.asm.keyword.ActionKeyword;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage {
    public AndroidDriver<WebElement> driver;
    public ActionKeyword actionKeyword;

    public BasePage(AndroidDriver<WebElement> driver){
        this.driver = driver;
        this.actionKeyword = new ActionKeyword(driver);
    }

    public String txtViewNameXpath = "//*[@text='%s']";

    public WebElement getElementByName(String viewName){
        return actionKeyword.findElementCustom(By.xpath(String.format(txtViewNameXpath, viewName)));
    }


    public void scrollToElementByVisibleText(String visibleText) {
        String uiSelector = "new UiSelector().text(\"" + visibleText + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }

    public void scrollToElementById(String id) {
        String uiSelector = "new UiSelector().resourceId(\"" + id + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }

    public void scrollToElementByClass(String classname) {
        String uiSelector = "new UiSelector().className(\"" + classname + "\")";
        String command = "new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(" + uiSelector + ");";
        driver.findElementByAndroidUIAutomator(command);
    }
}