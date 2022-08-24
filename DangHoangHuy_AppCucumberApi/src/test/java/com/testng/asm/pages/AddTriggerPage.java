package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AddTriggerPage extends BasePage {
    public AddTriggerPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }
    private String btnOkId = "android:id/button1";

    public WebElement getOkButton(){
        return actionKeyword.findElementCustom(By.id(btnOkId));
    }

    public AddTriggerPage clickOnApplicationsView(){
        scrollToElementByVisibleText("Applications");
        actionKeyword.click(getElementByName("Applications"));
        return new AddTriggerPage(this.driver);
    }

    public AddTriggerPage clickOnAppInstallRemoveUpdateButton(){
        scrollToElementByVisibleText("App Install/Remove/Update");
        actionKeyword.click(getElementByName("App Install/Remove/Update"));
        return new AddTriggerPage(this.driver);
    }

    public AddTriggerPage selectApplicationRemovedRadioButton(){
        actionKeyword.click(getElementByName("Application Removed"));
        return new AddTriggerPage(this.driver);
    }

    public AddTriggerPage selectAnyApplicationRadioButton(){
        actionKeyword.click(getElementByName("Any Application"));
        return new AddTriggerPage(this.driver);
    }

    public AddTriggerPage clickOkButton(){
        actionKeyword.click(getOkButton());
        return this;
    }
}
