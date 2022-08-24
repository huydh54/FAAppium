package com.testng.asm.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddActionPage extends BasePage {
    public AddActionPage(AndroidDriver<WebElement> driver) {
        super(driver);
    }

    private String btnOkId = "android:id/button1";
    @FindBy(xpath = "//*[@text='System Log']")
    WebElement rdoSystemLog;

    public WebElement getOkButton(){
        return actionKeyword.findElementCustom(By.id(btnOkId));
    }

    public AddActionPage clickOnLoggingView(){
        scrollToElementByVisibleText("Logging");
        actionKeyword.click(getElementByName("Logging"));
        return this;
    }

    public AddActionPage clickClearLogButton(){
        scrollToElementByVisibleText("Clear Log");
        actionKeyword.click(getElementByName("Clear Log"));
        return this;
    }

    public AddActionPage selectSystemLogRadioButton(){
        actionKeyword.click(getElementByName("System Log"));
        return this;
    }

    public void clickOkButton(){
        actionKeyword.click(getOkButton());
    }
}
